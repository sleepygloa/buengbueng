<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/buengbueng/css/dashBoard/dash-admin/dashAdmin.css" type="text/css">
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
<input type="hidden" name="pageNum5" value="${pageNum5}">
<input type="hidden" name="num" value="${num}">
<input type="hidden" name="ref" value="${ref}">
<input type="hidden" name="re_step" value="${re_step}">
<input type="hidden" name="snum" value="${snum}">

<div id="dashBoardwriteContent">
<div class="dashBoardwriteContentTableRow">
	<span class="dashBoardwriteContentTableCell col-mc-1">이름</span>
	<span class="dashBoardwriteContentTableCell col-mc-2"><input type="text" name="writer" value="${user.name}" readonly></span>
</div>
<div class="dashBoardwriteContentTableRow">
	<span class="dashBoardwriteContentTableCell col-mc-1">이메일</span>
	<span class="dashBoardwriteContentTableCell col-mc-3"><input type="text" name="email" value="${user.email}"></span>
</div>
<div class="dashBoardwriteContentTableRow">
	<span class="dashBoardwriteContentTableCell col-mc-1">제목</span>
	<c:if test="${num==0}">
		<span class="dashBoardwriteContentTableCell col-mc-4"><input type="text" name="title"></span>
	</c:if>
	<c:if test="${num!=0}">  
		<span class="dashBoardwriteContentTableCell col-mc-4"><input type="text" name="title" value="[답변]${title}"></span>
	</c:if>
</div>
<div class="dashBoardwriteContentTableRow">
	<span class="dashBoardwriteContentTableCell col-mc-6"><textarea rows="10%" cols="52%" name="content"></textarea></span>
</div>
<div class="dashBoardwriteContentTableRow">
	<span class="dashBoardwriteContentTableCell col-mc-5">
	<input type="submit" value="작성하기">
	<input type="reset" value="다시쓰기">
	<input type="button" value="창 끄기" onclick="window.close();"></span>
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