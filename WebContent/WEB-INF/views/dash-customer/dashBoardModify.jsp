<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/buengbueng/css/dashBoard/dash-admin/dashAdmin.css" type="text/css">
<form action="dashBoardModifyPro.do" method="post">
<div id="dashBoardwriteContent">
<input type="hidden" name="num" value="${dto.num}">
<input type="hidden" name="snum" value="${dto.snum}">
<input type="hidden" name="number" value="${number}">
<input type="hidden" name="pageNum" value="${pageNum}">
<input type="hidden" name="pageNum2" value="${pageNum2}">
<input type="hidden" name="pageNum3" value="${pageNum3}">
<div  class="dashBoardwriteContentTableRow">
	<span class="dashBoardwriteContentTableCell col-mc-1">작성자</span>
	<span class="dashBoardwriteContentTableCell col-mc-2">${dto.writer}</span>
</div>
<div  class="dashBoardwriteContentTableRow">
	<span class="dashBoardwriteContentTableCell col-mc-1">이메일</span>
	<span class="dashBoardwriteContentTableCell col-mc-3"><input type="text" name="email" value="${dto.email}"></span>
</div>
<div  class="dashBoardwriteContentTableRow">
	<span class="dashBoardwriteContentTableCell col-mc-1">제목</span>
	<span class="dashBoardwriteContentTableCell col-mc-4"><input type="text" name="title" value="${dto.title}"></span>
</div>
<div  class="dashBoardwriteContentTableRow">
	<span class="dashBoardwriteContentTableCell col-mc-6"><textarea rows="10%" cols="52%" name="content">${dto.content}</textarea></span>
</div>
<div  class="dashBoardwriteContentTableRow">
<span class="dashBoardwriteContentTableCell col-mc-5"> 
	<input type="submit" value="수정 완료">
	<input type="button" value="뒤로 가기" onclick="history.go(-1);">
</span>
</div>
</div>
</form>
