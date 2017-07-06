<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../header.jsp"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 수정</title>
</head>
<form action="noticeModifyPro.do?num=${num}&pageNum=${pageNum}&snum=${snum}&number=${number}" method="post" name="noticeModifyForm">
<div>
	<span>글번호</span>
	<span>${article.num}</span>
	<span>조회수</span>
	<span>${article.readcount}</span>
</div>
<div>
	<span>작성자</span>
	<span>${article.writer}</span>
	<span>이메일</span>
	<span>${article.email}</span>
</div>
<div>
	<span>제목</span>
	<span><input type="text" name="title" value="${article.title}"></span>	
</div>
<div>
	<textarea name="content">${article.content}</textarea>
</div>
<div>
	<input type="submit" value="수정완료">
	<input type="button" value="뒤로가기" onclick="history.go(-1);">
</div>
</form>	