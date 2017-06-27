<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../dashHeader.jsp"/>

<div>
<div>가맹 문의</div>
	<span>번호</span>
	<span>제목</span>
	<span>작성자</span>
	<span>email</span>
	<span>작성일</span>
	<span>조회수</span>
<c:if test="${count==0}">
<div>
	<span>등록된 게시물이 없습니다.</span>
</div>
</c:if>
<c:if test="${count>0}">
<c:set var="d" value="0"/>
<c:forEach var="list" items="${list}">
<div>
		<span>
		<c:out value="${number}"/>
		</span>
		<span><a href="dashFranchiseContent.do?num=${list.num}&snum=${snum}&pageNum=${pageNum}&number=${number}">${list.title}</a></span>
		<span>${list.writer}</span>
		<span>${list.email}</span>
		<span>${dates[d]}</span>
		<span>${list.readcount}</span>
		<c:if test="${dates[d] == today && list.re_step ==0}">
			<span class="label bg-warning">${alarm}</a></span>
		</c:if>
</div>
		<c:set var="number" value="${number-1}"/>
		<c:set value="${d+1}" var="d" />
</c:forEach>
	
	<c:if test="${startPage > 10}">
        <a href="dashFranchiseList.do?snum=${snum}&pageNum=${ startPage - 10 }">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<a href="dashFranchiseList.do?snum=${snum}&pageNum=${i}">[${i}]</a>
	</c:forEach>
	<c:if test="${endPage < pageCount}">
    	<a href="dashFranchiseList.do?snum=${snum}&pageNum=${ startPage + 10 }">[다음]</a>
	</c:if>
</c:if>
</div>

<jsp:include page="../dashFooter.jsp"/>