<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<jsp:include page="../header.jsp" />  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>공지 하기</title>
</head>
<div>공지하기</div>
<form action="noticePro.do?snum=${snum}&pageNum=${pageNum}" method="post">
<input type="hidden" name="num" value="${num}">
<input type="hidden" name="ref" value="${ref}">
<input type="hidden" name="re_step" value="${re_step}">

<div>
	<div>
		<span>이름</span>
		<span><input type="text" name="writer" value="admin" readonly></span>
	</div>
	<div>
		<span>이메일</span>
		<span><input type="text" name="email" value="admin.naver.com" readonly></span>
	</div>
	<div>
		<span>제목</span>
		<span><input type="text" name="title"></span>
	</div>
	<div>
		<textarea name="content"></textarea>
	</div>
	<div>
		<span><input type="submit" value="작성하기"></span>
		<span><input type="reset" value="다시쓰기"></span>
		<span><input type="button" value="돌아가기" onclick="window.location='notice.do?snum=${snum}&pageNum=${pageNum}'"></span>
	</div>
</div>	
</form>
