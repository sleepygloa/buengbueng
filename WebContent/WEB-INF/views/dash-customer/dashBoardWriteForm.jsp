<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="/buengbueng/js/userInfo/customerForm.js"></script>
<head>
<title>Q & A</title>
</head>
<div>자주 묻는 질문</div>
<form action="dashBoardWriteFormPro.do" method="post" onsubmit="return emptyCheck();" name="dashCustomer">
<input type="hidden" name="pageNum" value="${pageNum}">
<input type="hidden" name="pageNum2" value="${pageNum2}">
<input type="hidden" name="pageNum3" value="${pageNum3}">
<input type="hidden" name="pageNum4" value="${pageNum4}">
<input type="hidden" name="num" value="${num}">
<input type="hidden" name="ref" value="${ref}">
<input type="hidden" name="re_step" value="${re_step}">
<input type="hidden" name="snum" value="${snum}">

<div>
<div>
	<span>이름</span>
	<span><input type="text" name="writer" value="${user.name}" readonly></span>
</div>
<div>
	<span>이메일</span>
	<span><input type="text" name="email" value="${user.email}"></span>
</div>
<div>
	<span>제목</span>
	<c:if test="${num==0}">
		<span><input type="text" name="title"></span>
	</c:if>
	<c:if test="${num!=0}">  
		<span><input type="text" name="title" value="[답변]${title}"></span>
	</c:if>
</div>
	<textarea name="content"></textarea>
<div>
	<span><input type="submit" value="작성하기"></span>
	<span><input type="reset" value="다시쓰기"></span>
	<span><input type="button" value="창 끄기" onclick="window.close();"></span>
</div>
</div>
</form>

<script>
function emptyCheck(){
	if(document.dashCustomer.email.value == ""){
		alert('메일을 입력하세요');
		return false;
	}
	if(document.dashCustomer.title.value == ""){
		alert('제목을 입력하세요');
		return false;
	}
	if(document.dashCustomer.content.value == ""){
		alert('내용을 입력하세요');
		return false;
	}
}	
</script>