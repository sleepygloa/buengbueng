<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 삭제</title>
</head>
<body>
<div>게시글 삭제</div>
<div><span>비밀번호를 입력하세요.</span></div>
<div>
<form action="noticeDeletePro.do?snum=${snum}&pageNum=${pageNum}&num=${num}&ref=${ref}" method="post">
<input type="password" name="pw">		
<input type="submit" value="삭제">
<input type="button" value="뒤로가기" onclick="window.location='noticeContent.do?snum=${snum}&pageNum=${pageNum}&num=${num}&number=${number}'">
</form>
</div>
</body>