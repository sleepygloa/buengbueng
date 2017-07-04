$(document).ready(function() {
	window.setInterval("state()", 5000); // 5초에 한 번씩 좌석 이용 현황 확인
});

function state() {
	$.ajax({
		url : "seatState.do",
		type : "post",
		data : {
			tf : "1"
		},
		success : function(data) {
			$(".seatDisposeFirstDiv").html(data);
		}
	});
}

function getUserInfo(pcNum, id){
	$.ajax({
		url : "getUseUserInfo.do",
		type : "post",
		data : {
			pcNum : pcNum,
			id : id
		},
		success : function(data) {
			$(".userInfo").html(data);
		}
	});s
}