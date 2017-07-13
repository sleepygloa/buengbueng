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
			$("#seatDisposeFirstDiv").html(data);
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
			$("#setInfo").show();
			$('#setInfo').mousedown(handle_mousedown);
		}
	});
}

$(function(){
	$("#pop_close").click(function(){
		$("#setInfo").hide();
   }); 
});
function handle_mousedown(e){
    window.my_dragging = {};
    my_dragging.pageX0 = e.pageX;
    my_dragging.pageY0 = e.pageY;
    my_dragging.elem = this;
    my_dragging.offset0 = $(this).offset();
    function handle_dragging(e){
        var left = my_dragging.offset0.left + (e.pageX - my_dragging.pageX0);
        var top = my_dragging.offset0.top + (e.pageY - my_dragging.pageY0);
        $(my_dragging.elem)
        .offset({top: top, left: left});
    }
    function handle_mouseup(e){
        $('body')
        .off('mousemove', handle_dragging)
        .off('mouseup', handle_mouseup);
    }
    $('body')
    .on('mouseup', handle_mouseup)
    .on('mousemove', handle_dragging);
}