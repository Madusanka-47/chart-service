'use strict';
module.exports = function(app) {
  var todoList = require('../controllers/ChartServiceController');

  // todoList Routes
  app.route('/tasks/:TOKEN/:userid')
    .get(todoList.list_all_tasks)
};
