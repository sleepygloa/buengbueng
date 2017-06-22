<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../dashHeader.jsp"/>
<form action="dashOneModifyPro.do" method="post">
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
	<span><input type="text" name="title" value="${dto.title}"></span>
</div>
<div>
	<textarea name="content">${dto.content}</textarea>
</div>
<div>
	<input type="submit" value="수정 완료">
	<input type="button" value="뒤로 가기" onclick="history.go(-1);">
</div>
</form>
<jsp:include page="../dashFooter.jsp"/>