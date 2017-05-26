<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#action").click(function(){
			$.ajax({
				url:"login.do",
				type:"post",
				data:{
					id:$("#id").val(),
					pw:$("#pw").val()
				},
				success:function(data){
					$("#login").html(data);
				}
			});
		});
	});
</script>
<h1>로그인 테스트</h1>
<div id="login">
<div>id :<input type="text" id="id"></div>
<div>pw :<input type="password" id="pw"></div>
<button id="action">로그인</button>
</div>