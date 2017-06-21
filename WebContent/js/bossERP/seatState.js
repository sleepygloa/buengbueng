var b_key;

$(document).ready(function() {
	$("#getSeatState").click(function(){
		var select = document.getElementById("b_key");
		b_key = select.options[select.selectedIndex].value;
		window.setInterval("state()", 5000); // 5초에 한 번씩 좌석 이용 현황 확인
	});
});

function state() {
	$.ajax({
		url : "seatState.do",
		type : "post",
		data : {
			b_key : b_key
		},
		success : function(data) {
			$(".seatState").html(data);
		}
	});
}