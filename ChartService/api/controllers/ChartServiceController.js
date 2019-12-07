var MongoClient = require('mongodb').MongoClient

exports.list_all_tasks = function (req, res) {
  var xparam = []
  var yparam = []
  var bar = []
  var authorized = false
  try {
    const uri = "mongodb+srv://dumalk:dumalk@cluster0-yx3nh.mongodb.net/test?retryWrites=true&w=majority";
    const client = new MongoClient(uri, { useNewUrlParser: true, useUnifiedTopology: true });
    client.connect(err => {
      var TOKEN = () => {
        return new Promise((resolve, reject) => {
          const collection = client.db("survey_core").collection("tokens");
          collection.find({ userid: req.params.userid }).toArray(function (err, user) {
            err
              ? reject(err)
              : resolve(user);
          });
        });
      };
      var callValidation = async () => {
        var result = await (TOKEN());
        return result;
      };
      callValidation().then(function (result) {
        var token_key

        result.forEach(key => {
          token_key = key.token_key
        })
        if (req.params.TOKEN === token_key) {
          Task2callPromise().then(function (result) {
            bar.push(result)
          });

          Task3callPromise().then(function (result) {
            bar.push(result)
            res.render('index', { xAxis: xparam, yAxis: yparam, bar: bar });
            client.close();
          });
        }
        else {
          res.send('Access Denied')
        }
      });

      var myPromise = () => {
        return new Promise((resolve, reject) => {
          const collection = client.db("survey_core").collection("answer_pane");
          collection.find().toArray(function (err, items) {
            err
              ? reject(err)
              : resolve(items);
          });
        });
      };
      var callMyPromise = async () => {
        var result = await (myPromise());
        return result;
      };

      callMyPromise().then(function (result) {
        client.close();
        result.forEach(element => {
          xparam.push("'" + element._id + "'")
          yparam.push(element.userid)
        });

      });
      if (true) {
        var Task2Promise = (doc) => {
          return new Promise((resolve, reject) => {
            client.db("survey_core").collection(doc).find().count({}, function (error, numOfDocs) {
              error
                ? reject(error)
                : resolve(numOfDocs);
            });
          })
        };
        var Task2callPromise = async () => {
          var result = await (Task2Promise('access_pane'));
          return result;
        };
        var Task3callPromise = async () => {
          var result = await (Task2Promise('answer_pane'));

          return result;
        };
      }
    });
  } catch (e) {
    next(e)
  }
}
