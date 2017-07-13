$(document).ready(function(){
  var socket = io.connect('ws://192.168.10.102:3000');
//    var socket = io.connect('ws://localhost:3000');
    $(document).ready(function(){
      // 입력버튼 누르면 발생
      $('#submitBtn').click(function(){
        var keyword = "";
        // 사용자 질문 채팅창에 띄우기
        var txt = $('#chat').html();
		  var userTxt = $('#userTxt').val().replace("\n","<br/>");
        $('#chat').html(
		  		txt+"<div class='line'>"+
						"<div class='user'>사용자<br/>"+
							"<div class='question'>"+
								userTxt+
							"</div>"+
						"</div>"+
					"</div>"
		  );
        var question =  document.getElementById("userTxt").value;
        // 사용자의 질문에서 키워드 추출하기
        $.ajax({
      		url:"http://api.datamixi.com/datamixiApi/keywordextract",
      		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
      		type:"POST",
      		dataType:'text',
      		data: {
      			request:'post',
      			key:'7173114780022473721',
      			text: question
      		},
			success: function(data){
      			var parser = JSON.parse(data);
				if (typeof parser.return_object !== "undefined") {
					for(i=0;i<parser.return_object.length;i++){
						var last = parser.return_object[i].term.indexOf('|');
						keyword += parser.return_object[i].term.substring(0,last);
						if(i != parser.return_object.length-1){
							keyword  += ",";
						}
					}
				}else{
					keyword = "키워드 없음";
				}
				socket.emit('chat', keyword,question);
      		}
			
      	});
        socket.on('recieveChat',function(data){
          var txt = $('#chat').html();
          $('#chat').html(
				txt+"<div class='line'>"+
						"<div class='admin'>관리자<br/>"+
							"<div class='answer'>"+
								data+
							"</div>"+
						"</div>"+
					"</div>"
			);
          socket.end();
        });
      });
    });
	$(document).bind('keydown',function(e){
		if (e.keyCode == 123) { /* F12 */
			e.preventDefault();
			e.returnValue = false;
		}
		if(e.ctrlKey && e.keyCode == 86){ /*ctrl + v*/ 
			e.preventDefault();
			e.returnValue=false; 
		}
		if(e.ctrlKey && e.keyCode == 67){ /*ctrl + c*/
			e.preventDefault();
			e.returnValue=false;
		}
		if(e.ctrlKey && e.keyCode == 85){ /*ctrl + u*/
			e.preventDefault();
			e.returnValue=false;
		}
		if(e.ctrlKey && e.keyCode == 83){ /*ctrl + s*/
			e.preventDefault();
			e.returnValue=false;
		}
		if(e.ctrlKey && e.shiftKey && e.keyCode == 73){ /*ctrl + shift + i*/
			e.preventDefault();
			e.returnValue=false;
		}
	});
	$(document).bind("contextmenu", function() {
		 return false;
	});
	$(document).bind('selectstart',function() {
		return false;
	}); 
	$(document).bind('dragstart',function(){
		return false;
	}); 
});

