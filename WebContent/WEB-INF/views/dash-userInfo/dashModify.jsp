<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	<span class="dashUserTableCell col-di-1"><input type="hidden" id="id" class="Boxcol" value="${dto.id}">${dto.id}</span>
	<span class="dashUserTableCell col-di-2"><input type="password" id="pw" class="Boxcol" value="${dto.pw}" placeholder="패스워드"></span>
	<span class="dashUserTableCell col-di-3"><input type="text" id="name" class="Boxcol" value="${dto.name}" placeholder="이름"></span>
	<span class="dashUserTableCell col-di-4"><input type="text" id="birth" class="Boxcol" value="${dto.birth}" placeholder="생일"></span>
	<span class="dashUserTableCell col-di-5"><input type="text" id="phone" class="Boxcol" value="${dto.phone}" placeholder="연락처"></span>
	<span class="dashUserTableCell col-di-6"><input type="text" id="email" class="Boxcol" value="${dto.email}" placeholder="이메일"></span>
	<span class="dashUserTableCell col-di-7"><input type="text" id="address" class="Boxcol" value="${dto.address}" placeholder="주소"></span>
	<span class="dashUserTableCell col-di-8"><input type="text" id="grade" class="Boxcol" value="${dto.grade}" placeholder="등급"></span>
	<span class="dashUserTableCell col-di-9"><input type="text" id="googleId" class="Boxcol" value="${googleId}" placeholder="구글Id"></span>
	<span class="dashUserTableCell col-di-0">${date}</span>
	<span class="dashUserTableCell col-di-10">
	<input type="button" onclick="return successModi();" value="수정">
	<input type="button" value="취소" onclick="history.go(0);">
	</span>

