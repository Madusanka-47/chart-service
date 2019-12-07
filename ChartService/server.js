var express = require('express'),
  app = express()

  app.use(express.static(__dirname + '../views'));
  app.set('view engine', 'pug')

  port = process.env.PORT || 3000;

// app.use(bodyParser.urlencoded({ extended: true }));
// app.use(bodyParser.json());
var routes = require('./api/routes/ChartServiceRoutes'); //importing route
routes(app); //register the route
app.listen(port);