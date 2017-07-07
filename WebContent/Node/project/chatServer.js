var express = require('express');
var app = express();

require('events').EventEmitter.prototype._maxListeners = 100;

// POST 사용
var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({extended:false}));

// MySQL 연동
var mysql = require('mysql');
var conn = mysql.createConnection({
  host: '211.211.163.86',
  port: 11056,
  user: 'buengbueng',
  password: '1234',
  database: 'buengbueng'
});
conn.connect();

// 외부 url 연결 및 json 파싱 사용
var request = require('request');
var parser = require('json-parser');

// 소켓 통신
var http = require('http');
var httpServer = http.createServer(app).listen(3000,function(req,res){
  console.log("SERVER : Connected 3000 port!");
});
var io = require('socket.io').listen(httpServer);
io.sockets.on('connection',function(socket){
  socket.on('chat',function(keyword, que){
    console.log('user keyword: '+keyword);
    // MySQL에서 질문 탐색 및 답변 받기
    var sql = "select * from chatbot where question = '"+keyword+"';";
    var questionNum = 0;
    var answerToUser = '답변할 수 없는 질문입니다.';
    conn.query(sql,function(err,rows,fields){
        var date = new Date();
        // 에러가 있던가 레코드가 없을 때
        if(err || rows.length == 0){
          console.log("selectERR: "+err);
        }
        // 에러가 없고 레코드가 있을 때
        else{
          // 답변 split
          var result = (rows[0].answer).split('/%/');
          // 랜덤 답변
          var num = Math.floor(Math.random()*result.length);
          answerToUser = result[num];
          questionNum = rows[0].questionNum;
        }
        // log 추가
        sql = 'insert into chatLog values(?,?,?,?,?);'
        params = [questionNum,que,keyword,answerToUser,date]; // sql문 '?'자리에 들어가는 값들 추후 num 부분은 auto increment로...
        conn.query(sql,params,function(err){
          if(err){
            console.log("insertErr: "+err);
          }
        });
        socket.emit('recieveChat',answerToUser);
    });
    socket.on('end',function(){
      console.log('Client connection ended');
    });
  });
});

// chatbot 채팅 화면
app.get('/',function(req,res){
  console.log("chat start!");
   res.sendFile("./public/chatClient.html", {root: __dirname});
});
