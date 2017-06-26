<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="/buengbueng/js/userInfo/customerForm.js"></script>
<!-- HEADER TEMPLATE -->
<jsp:include page="../header.jsp" />
<head>
<title>Q & A</title>
</head>
<c:if test="${sessionScope.grade!=4}">
	<script>alert("관리자 등급만 작성 가능"); history.go(-1);</script>
</c:if>
<div>자주 묻는 질문</div>
<form action="customerPro.do" method="post" onsubmit="return customerCheck();" name="customer">
<input type="hidden" name="pageNum" value="${pageNum}">
<input type="hidden" name="snum" value="${snum}">
<input type="hidden" name="num" value="${num}">
<input type="hidden" name="ref" value="${ref}">
<input type="hidden" name="re_step" value="${re_step}">


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
	<span><input type="button" value="돌아가기" onclick="window.location='customerQA.do?snum=${snum}&pageNum=${pageNum}'"></span>
</div>
</div>
</form>