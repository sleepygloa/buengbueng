<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#deletepro").click(function(){
			$.ajax({
				url:"franchiseDeletePro.do",
				type:"post",
				data:{num:$("#num").val(),
					snum:$("#snum").val(),
					pageNum:$("#pageNum").val(),
					passwd:$("#passwd").val()},
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
	<span>비밀번호</span>
	<span><input type="password" id="passwd" placeholder="비밀번호 입력란"></span>
</div>
<div>
	<span><button id="deletepro">삭제하기</button></span>
	</span><input type="button" value="뒤로가기" onclick="history.go(0);">	
</div>
</div>