<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	.size{width: 60px;}
</style>

<script>
function successModi(){
	if (confirm("수정 하시겠습니까??") == true){ 
		$.ajax({
			url:"dashModifyPro.do",
			type:"post",
			data:{
				id:$("#id").val(),
				pw:$("#pw").val(),
				name:$("#name").val(),
				birth:$("#birth").val(),
				phone:$("#phone").val(),
				email:$("#email").val(),
				address:$("#address").val(),
				grade:$("#grade").val(),
				googleId:$("#googleId").val()
			},
			success:function(){
				history.go(0);
		    }
		});
	}else{
		return;
	}
}
</script>
<div id="userInfo">
	<span><input type="hidden" id="id" value="${dto.id}">${dto.id}</span>
	<span><input type="password" id="pw" class="size" value="${dto.pw}" placeholder="패스워드"></span>
	<span><input type="text" id="name" class="size" value="${dto.name}" placeholder="이름"></span>
	<span><input type="text" id="birth" class="size" value="${dto.birth}" placeholder="생일"></span>
	<span><input type="text" id="phone" class="size" value="${dto.phone}" placeholder="연락처"></span>
	<span><input type="text" id="email" class="size" value="${dto.email}" placeholder="이메일"></span>
	<span><input type="text" id="address" class="size" value="${dto.address}" placeholder="주소"></span>
	<span><input type="text" id="grade" class="size" value="${dto.grade}" placeholder="등급"></span>
	<span><input type="text" id="googleId" class="size" value="${googleId}" placeholder="구글Id"></span>
	<span>${date}</span>
	<span><button onclick="return successModi();">수정완료</button></span>
		<span><input type="button" value="취소" onclick="history.go(0);"></span>
</div>
