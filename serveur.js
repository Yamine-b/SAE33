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
  res.render('page/graph', {});
});

app.get('/signin', function(req, res) {
  res.render('page/signin',{error1:"sg"});
});
app.post('/signin', function(req, res){
  console.log(req.body);
    var login = req.body.login;
    var mdp = req.body.mdp;
            db.query(`SELECT * FROM users where login='${login}' and mdp='${mdp}'`,(err,rep) =>
            {if (err) throw err;
            var data = JSON.parse(JSON.stringify(rep));
            if(data.length != 0)
              {res.redirect('/graph');}
            else{
              res.render('page/singin',{error1:"Le nom d'utilisateur ou le mot de passe sont incrorrects !"});
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
