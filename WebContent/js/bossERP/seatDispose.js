$(document).ready(function(){
	$("#seatAdd").click(function(){
		// 입력한만큼 좌석 추가
		var pcCount = document.getElementById("pcCount").value;
		// 입력한 값이 없으면 좌석 1개 추가
		if(pcCount == ''){
			pcCount = 1;
		}
		$.ajax({
			url:"seatAddDel.do",
			type:"post",
			data:{
				pcNums : pcCount,
				what : "add"
			},
			success:function(data){
				$(".seatDisposeFirstDiv").html(data);
			}
		});
	});

	$("#seatModi").click(function(){
		// 체크한 좌석 일괄 수정
		var checkPC = document.getElementsByName("checkPC");
		var pcNums = "";
		for(i = 0; i < checkPC.length; i++){
			if(checkPC[i].checked){
				pcNums += checkPC[i].value+',';
			}
		}
		pcNums = pcNums.substring(0, pcNums.length-1);
		$.ajax({
			url:"getSetPcInfo.do",
			type:"post",
			data:{
				pcNum : pcNums,
				page : "2"
			},
			success:function(data){
				$(".pcInfo").html(data);
			}
		});
	});
	
	$("#seatDel").click(function(){
		// 체크한 좌석 삭제
		var checkPC = document.getElementsByName("checkPC");
		var pcNums = "";
		for(i = 0; i < checkPC.length; i++){
			if(checkPC[i].checked){
				pcNums += checkPC[i].value+',';
			}
		}
		$.ajax({
			url:"seatAddDel.do",
			type:"post",
			data:{
				pcNums : pcNums,
				what : "del"
			},
			success:function(data){
				$(".seatDisposeFirstDiv").html(data);
			}
		});
	});
});

// 선택한 좌석 정보 보기(0) / 수정(1)
function showModiPcInfo(pcNum,page){
	$.ajax({
		url:"getSetPcInfo.do",
		type:"post",
		data:{
			pcNum : pcNum,
			page : page
		},
		success:function(data){
			$(".pcInfo").html(data);
		}
	});
}