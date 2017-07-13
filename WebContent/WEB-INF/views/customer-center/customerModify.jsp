<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" type="text/css" href="/buengbueng/css/notice/noticeForm.css">
<script type="text/javascript" src="/buengbueng/js/userInfo/customerForm.js"></script>
<head>
<title>게시글 수정</title>
</head>
<!-- HEADER TEMPLATE -->
<jsp:include page="../header.jsp" />

<form action="customerModifyPro.do" method="post" onsubmit="return customerModify();" name="customer_m">
<input type="hidden" name="num" value="${dto.num}">
<input type="hidden" name="snum" value="${dto.snum}">
<input type="hidden" name="pageNum" value="${pageNum}">
<div>
	<span>작성자</span>
	<span>${dto.writer}</span>
</div>
<div>
	<span>이메일</span>
	<span><input type="text" name="email" value="${dto.email}"></span>
</div>
<div>
	<span>제목</span>
	<span><input type="text" name="title"  id="title11"  value="${dto.title}"></span>
</div>
<div>
	<textarea name="content" cols="130" rows="30">${dto.content}</textarea>
</div>
<div id="button">
	<input type="submit" value="수정 완료">
	<input type="button" value="뒤로 가기" onclick="history.go(-1);">
</div>
</form>