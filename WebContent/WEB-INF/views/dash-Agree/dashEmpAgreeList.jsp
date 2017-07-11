<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- HEADER TEMPLATE -->
<jsp:include page="../dashHeader.jsp" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="/buengbueng/css/dashBoard/dash-admin/dashAdmin.css">
<c:if test="${count==0}">
<script>
alert('검색결과가 없습니다');
history.go(-1);
</script>
</c:if>

<c:if test="${count>0}">
<div id="dashERPAgree">
<div class="dashERPAgreeTableRow">
<c:forEach var="list" items="${list}">
		<span class="dashERPAgreeTableCell col-er-1">
			<a href="dashemployeeManageInfo.do?b_id=${list.b_id}&b_key=${list.b_key}&b_name=${list.b_name}" 
			onclick="window.open(this.href,'_blank','width=350,height=500,toolbars=no,scrollbars=no'); return false;">
			${list.b_id}님의 ${list.b_name}점
			</a>
		</span>
</c:forEach>
</div>
<div class="pagePosition">
	<c:if test="${startPage > 10}">
        <a href="dashEmpAgreeList.do?pageNum=${ startPage - 10 }">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<a href="dashEmpAgreeList.do?pageNum=${i}">[${i}]</a>
	</c:forEach>
	<c:if test="${endPage < pageCount}">
    	<a href="dashEmpAgreeList.do?pageNum=${ startPage + 10 }">[다음]</a>
	</c:if>
</div>
</div>
</c:if>

<div class="pagePosition">
	<form action="dashEmpAgreeList.do" method="get" name="EmpSearch" onsubmit="return keywordCheck();">
		<input type="hidden" name="pageNum" value="${pageNum}">
		<input type="text" name="keyword" placeholder="가맹점 입력">
		<input type="submit" value="검색">
	</form>
</div>

<script>
function keywordCheck(){
	if(document.EmpSearch.keyword.value == ""){
		alert('키워드를 입력하세요.');
		return false;
	}}
</script> 

<!-- HEADER TEMPLATE -->
<jsp:include page="../dashFooter.jsp" />