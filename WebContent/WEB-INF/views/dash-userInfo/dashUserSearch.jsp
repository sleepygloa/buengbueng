<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 메뉴 및 css 내용 -->
<jsp:include page="../dashHeader.jsp"/>
<c:if test="${count==0  && keyword!=null}">
<script>
alert('검색결과가 없습니다');
history.go(-1);
</script>
</c:if>
<c:if test="${count>0 }">
<jsp:include page="userAdmin.jsp"/>
</c:if>
<div align="center">
	<form action="dashUserSearch.do" method="get" name="userSearch" onsubmit="return keywordCheck();">
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