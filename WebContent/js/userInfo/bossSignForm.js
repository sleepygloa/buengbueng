
	$(document).ready(	// jquery의 기본. java의 main.
			function(){
				$(".user").click(function(){
					$.ajax({
						url:"userInfoGrade.do",
						type:"post",
						success:function(data){
							$("#grade").html(data);
						}
					});
				});
				$("#boss").click(function(){
	
					$.ajax({
						url:"bossInfoSignForm.do",
						type:"post",
						success:function(data){
							$("#grade").html(data);
						}
					});
				});
				$("#employee").click(function(){
					$.ajax({
						url:"employeeSignForm.do",
						type:"post",
						success:function(data){
							$("#grade").html(data);
						}
				});	
			});	
		});
