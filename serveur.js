// load the things we need
var express = require('express');
var app = express();

// set the view engine to ejs
app.set('view engine', 'ejs');

// use res.render to load up an ejs view file

// index page 
app.get('/', function(req, res) {
    res.render('page/index', {
    });
});


app.get('/login', (req, res) => {
    res.render('page/login');
  });

// about page
app.get('/about', function(req, res) {
    res.render('page/about');
});

app.post('/login', (req, res) => {
    const username = req.body.username;
    const password = req.body.password;
  
    // Vérifiez les informations d'identification de l'utilisateur ici
    // Si les informations sont correctes, redirigez l'utilisateur vers la page d'accueil
    // Sinon, affichez un message d'erreur
  });

app.listen(8080);
console.log('8080 is the magic port');