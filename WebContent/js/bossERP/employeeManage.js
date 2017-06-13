function getInfo(){
	var e_id = $("#userDto").val();
	$.ajax({
		url:"bossEmployeeInfo.do",
		method:"post",
		type:"json",
		data: {"e_id" : e_id},
		success:function(data){
			$(".info").html(data);
			console.log(data)
		}
	});
}
