nodeSituation();//노드 상황보기

function addChat(max){
	if($(".addChat").html() != ""){
		$(".addChat").html("");
	}else{
		$.ajax({
			url:"addChat.do",
			type:"POST",
			data: {
				max : max
			},
			success: function(data){
				$(".addChat").html(data);
			}
		});
	}
}

function checkDelete(num){
	if(confirm("정말 삭제하시겠습니까?")==true){
		window.location='removeChat.do?questionNum='+num;
	}else{
		alert("취소하였습니다."); //삭제취소
		return false;
	}
}

var num = document.getElementById("num").value;

function addAnswer(){
	var addDiv = document.createElement('div');
	addDiv.id = num;
	addDiv.innerHTML = "<input type='checkbox' name='deleteCheck' value='"+num+"'/><textArea name='answer"+num+"' placeholder='답변' cols='50'></textArea>";
	document.getElementById("holder").appendChild(addDiv);
	num++;
	document.getElementById("num").value = num;
}

function deleteAnswer(){
	var checkDel = document.getElementsByName("deleteCheck");
	var count = 0;
	
	var selectDel = new Array();
	
	for(i = 0; i < checkDel.length; i++){
		if(checkDel[i].checked){
			selectDel[count] = checkDel[i].value;
			count++;
		}
	}if(count == 0){
		num--;
		document.getElementById("holder").removeChild(document.getElementById(num));
		document.getElementById("num").value = num;
	}else{
		for(i = 0; i < count; i++){
			num--;
			var number = selectDel[i];
			document.getElementById("holder").removeChild(document.getElementById(number));
			document.getElementById("num").value = num;
		}
	}
}

function keyword(){
	$.ajax({
		url:"http://api.datamixi.com/datamixiApi/keywordextract",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		type:"POST",
		dataType:'text',
		data: {
			request:'post',
			key:'7173114780022473721',
			text: document.getElementById("questionTxt").value
		},
		success: function(data){
			var keyword = "";
			var parser = JSON.parse(data);
			for(i=0;i<parser.return_object.length;i++){
				var last = parser.return_object[i].term.indexOf('|');
				keyword += parser.return_object[i].term.substring(0,last);
				if(i != parser.return_object.length-1){
					keyword  += ",";
				}
			}
			document.getElementById("question").value = keyword;
		}
	});
}

function checkChatbot(){
    if(document.addChatbot.question.value == ""){
        document.getElementById("alert").value = "모든 정보를 입력해주십시오.";
        return false;
    }
    if(document.addChatbot.answer.value == ""){
        document.getElementById("alert").value = "모든 정보를 입력해주십시오.";
        return false;
    }
}

function checkModifyChatbot(){
    if(document.modifyChatbot.question.value == ""){
        document.getElementById("alert").value = "모든 정보를 입력해주십시오.";
        return false;
    }
    if(document.modifyChatbot.answer0.value == ""){
        document.getElementById("alert").value = "모든 정보를 입력해주십시오.";
        return false;
    }
}

/* 선호 코드 추가 */


function nodeSituation(){
	$.ajax({
		url : "chatSituation.do",
		type : "post",
		success : function(data){
			$("#nodeSituation").html(data);
		}
	});
	setTimeout("nodeSituation()",5000);
}
function nodeStart(){
	$.post("nodeStart.do");
}
function nodeEnd(){
	$.post("nodeEnd.do");
}