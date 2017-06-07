<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="/buengbueng/js/userInfo/customerForm.js"></script>
<!-- HEADER TEMPLATE -->
<jsp:include page="../header.jsp" />
<head>
<title>가맹 문의</title>
</head>
<div>가맹 문의</div>
<form action="customerPro.do" method="post" onsubmit="return customerCheck();" name="customer">
<input type="hidden" name="pageNum" value="${pageNum}">
<input type="hidden" name="snum" value="${snum}">
<input type="hidden" name="num" value="${num}">
<input type="hidden" name="ref" value="${ref}">
<input type="hidden" name="re_step" value="${re_step}">


<div>
<div>
	<span>이름</span>
	<c:if test="${sessionScope.loginId != null}">
		<span><input type="text" name="writer" value="${dto.name}" readonly></span>
	</c:if>
	<c:if test="${sessionScope.loginId == null}">
		<span><input type="text" name="writer"></span>
	</c:if>
</div>
<div>
	<span>이메일</span>
	<c:if test="${sessionScope.loginId != null}">
		<span><input type="text" name="email" value="${dto.email}"></span>
	</c:if>
	<c:if test="${sessionScope.loginId == null}">
		<span><input type="text" name="email"></span>
	</c:if>
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
<div>
	<c:if test="${dto.grade != 0}">
	<span>비밀번호</span>
	<span><input type="password" name="passwd" ></span>
	</c:if>
</div>
	<span><input type="submit" value="작성하기"></span>
	<span><input type="reset" value="다시쓰기"></span>
	<span><input type="button" value="돌아가기" onclick="window.location='customerQA.do?snum=${snum}&pageNum=${pageNum}'"></span>
</div>
</div>
</form>