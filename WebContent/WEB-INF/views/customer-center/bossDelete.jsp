<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#bossdelpro").click(function(){
			$.ajax({
				url:"bossDeletePro.do",
				type:"post",
				data:{num:$("#num").val(),
					snum:$("#snum").val(),
					pageNum:$("#pageNum").val()},
				success:function(data){
					$("#pro").html(data);
				}
			});
		});
	});
</script>
<head>
<title>게시글 삭제</title>
</head>
<input type="hidden" id="num" value="${dto.num}">
<input type="hidden" id="snum" value="${dto.snum}">
<input type="hidden" id="pageNum" value="${pageNum}">
<div id="pro">
<div>게시글 삭제</div>
<div>
	<b>삭제 하시겠습니까?</b>
</div>
<div>
	<span><button id="bossdelpro">삭제</button></span>
	</span><input type="button" value="뒤로가기" onclick="history.go(0);">	
</div>
</div>