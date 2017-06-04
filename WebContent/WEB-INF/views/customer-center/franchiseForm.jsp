<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<title>가맹 문의</title>
</head>
<div>가맹 문의</div>
<form action="franchiseForm.do" method="post">
<input type="text" name="serial_num" value="${snum}">

<div>
	<span>이름</span>
	<c:if test="${sessionScope.loginId != null}">
	
	</c:if>
		<span><input type="text" name="writer"></span>
</div>
<div>
	<span>이메일</span>
	<span><input type="text" name="email"></span>
</div>
<div>
	<span>제목</span>
	<span><input type="text" name="title"></span>
</div>
<textarea></textarea>
</form>