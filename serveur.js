var express = require('express');
var app = express();
var sql = require('mysql')
var bodyParser = require('body-parser');
var db = sql.createConnection({
  host: "localhost",
  user: "root",
  password: "",
  database: "SAE33",
});

app.use(bodyParser.urlencoded({ extended: false }));
app.set('view engine', 'ejs');
app.use("/public", express.static("public"));

app.get('/', function(req, res) {
    res.render('page/index', {});
});

app.get('/graph', function(req, res) {
  // Récupération des données de température depuis la base de données
  db.query("SELECT * FROM donnee", function (err, result) {
    if (err) throw err;

    // Conversion des données en format JSON
    var data = JSON.parse(JSON.stringify(result));

    // Récupération des labels (dates) et des données (températures)
    var labels = data.map(function(item) { return item.date });
    var temperatures = data.map(function(item) { return item.Temperature });
    var humidite = data.map(function(item) { return item.Humidite });
    var luminosite = data.map(function(item) { return item.Luminosite });
    res.render('page/graph', {
      labels: labels,
      temperatures: temperatures,
      humidite: humidite,
      luminosite:luminosite
    });
  });
});
app.get('/signin', function(req, res) {
  res.render('page/signin',{error1:""});
});
app.post('/signin', function(req, res){
    var login = req.body.login;
    var mdp = req.body.mdp;
            db.query(`SELECT * FROM users where login='${login}' and mdp='${mdp}'`,(err,rep) =>
            {if (err) throw err;
            var data = JSON.parse(JSON.stringify(rep));
            if(data.length != 0)
              {res.redirect('/graph');}
            else{
              res.render('page/signin',{error1:"Le nom d'utilisateur ou le mot de passe sont incrorrects !"});
          }})

       
});

app.get('/signup', function(req, res) {
  res.render('page/signup',{error2:""});
});
app.post('/signup', function(req, res){
  var login = req.body.login;
  var mdp = req.body.mdp;
  db.query(`SELECT * FROM users WHERE Login = '${login}'`,(err,rep) =>{
    if(err){
      throw err;
    }
    var data = JSON.parse(JSON.stringify(rep));
    if(data.length != 0)
      {
        
        console.log("user already exist");
        res.render('page/signup',{error2: "Ce nom d'utilisateur est déjà utilisé !"});
      }
      else{
        db.query(`INSERT INTO users (Login, Mdp) VALUES('${login}','${mdp}')`,(err,rep) =>
        {
          if(err){
            throw err;
          }
          res.redirect('/graph');
        });
      }
    });
});


app.get('/about', function(req, res) {
    res.render('page/about');
});

app.listen(8080, function() {
    console.log('http://localhost:8080');
});
