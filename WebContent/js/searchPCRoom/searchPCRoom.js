function seachAddr(){
	new daum.Postcode({
  	     oncomplete: function(data) {
            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var fullAddr = ''; // 최종 주소 변수
            var extraAddr = ''; // 조합형 주소 변수

            // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
            if(data.userSelectedType === 'R'){
            	 fullAddr = data.roadAddress;
                //법정동명이 있을 경우 추가한다.
                if(data.bname !== ''){
                    extraAddr += data.bname;
                }
                // 건물명이 있을 경우 추가한다.
                if(data.buildingName !== ''){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                fullAddr = data.jibunAddress;
            }

            // 주소 정보를 해당 필드에 넣는다.
            document.getElementById('address').value = fullAddr;

            // 커서를 상세주소 필드로 이동한다.
        	// document.getElementById('sample6_address2').focus();
       }
   }).open();
}
function searchPCRoom(){
	var addr = document.getElementById("address").value;
	$(".seatState").html('');
	$.ajax({
		url: "searchPCRoom.do",
		type: "post",
		data: {
			addr: addr
		},
		success: function(data){
			$("#guide").html(data);
		}
	});
}
function searchPCNear(addr){
	$(".seatState").html('');
	$.ajax({
		url: "searchPCRoom.do",
		type: "post",
		data: {
			addr: addr
		},
		success: function(data){
			$("#guide").html(data);
		}
	});
}

var b_name;
var b_id;
function pcRoomInfo(name,id){
	b_name = name;
	b_id = id;
	$.ajax({
		url : "showPcRoomInfo.do",
		type : "post",
		data : {
			b_name : b_name,
			b_id : b_id
		},
		success : function(data) {
			$(".pcRoomInfo").html(data);
		}
	});
}

function pcInfo(name,id){
	b_name = name;
	b_id = id;
	window.setInterval("state()", 5000); // 5초에 한 번씩 좌석 이용 현황 확인
};
function state(){
	$.ajax({
		url : "pcRoomUseState.do",
		type : "post",
		data : {
			b_name : b_name,
			b_id : b_id
		},
		success : function(data) {
			$(".seatState").html(data);
		}
	});
}
function showPcInfo(pcNum){
	$.ajax({
		url:"showPcInfo.do",
		type:"post",
		data:{
			pcNum : pcNum,
			b_name : b_name,
			b_id : b_id
		},
		success:function(data){
			$(".pcInfo").html(data);
		}
	});
}
function addFavoritePCRoom(){
	$.ajax({
		url:"addFavoritePCRoom.do",
		type:"post",
		data:{
			b_name : b_name,
			b_id : b_id
		},
		success:function(data){
			$(".pcRoomInfo").html(data);
		}
	});
}
function deleteFavoritePCRoom(){
	$.ajax({
		url:"deleteFavoritePCRoom.do",
		type:"post",
		data:{
			b_name : b_name,
			b_id : b_id
		},
		success:function(data){
			$(".pcRoomInfo").html(data);
		}
	});
}