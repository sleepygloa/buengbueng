<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 메뉴 및 css 내용 -->
<jsp:include page="../dashHeader.jsp"/>

<jsp:include page="userAdmin.jsp"/>

<div align="center">
	<form action="dashUserSearch.do" method="post" name="userSearch" onsubmit="return keywordCheck();">
		<input type="hidden" name="pageNum" value="${pageNum}">
		<input type="text" name="keyword" placeholder="키워드 입력">
		<input type="submit" value="회원 검색">
	</form>
</div>

<script>
function keywordCheck(){
	if(document.userSearch.keyword.value == ""){
		alert('키워드를 입력하세요.');
		return false;
	}}
</script> 


<!-- js 내용 -->
<jsp:include page="../dashFooter.jsp"/>