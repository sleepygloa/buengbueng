<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/buengbueng/css/notice/noticeList.css">
<!-- HEADER TEMPLATE -->
<jsp:include page="../header.jsp" />
<head>
	<title>Q & A</title>
</head>

<div>
<div>자주 묻는 질문</div>
<c:if test="${sessionScope.grade == 4}">
<div><a href="customerForm.do?snum=${snum}&pageNum=${pageNum}">글쓰기</a></div>
</c:if>

<div class="top">
	<span class="tt1">번호</span>
	<span class="tt2">제목</span>
	<span class="tt3">작성자</span>
	<span class="tt4">작성일</span>
	<span class="tt5">조회</span>
</div>	
<c:if test="${count==0}">
<div>
	<span>등록된 게시물이 없습니다.</span>
</div>
</c:if>
<c:if test="${count>0}">
<c:set value="0" var="d" />
<c:forEach var="list" items="${list}">
<div class="middle1">
		<span class="tt1">
			<c:out value="${number}"/>
		</span>
		<span class="tt2"><a href="customerContent.do?num=${list.num}&snum=${snum}&pageNum=${pageNum}&number=${number}">${list.title}</a></span>
		<span class="tt3">${list.writer}</span>
		<span class="tt4">${dates[d]}</span>
		<span class="tt5">${list.readcount}</span>
</div>
<c:set var="number" value="${number-1}"/>
<c:set value="${d+1}" var="d" />
</c:forEach>

<div class="footer"> 	
	<c:if test="${startPage > 10}">
        <a href="customerQA.do?snum=${snum}&pageNum=${ startPage - 10 }">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<a href="customerQA.do?snum=${snum}&pageNum=${i}">[${i}]</a>
	</c:forEach>
	<c:if test="${endPage < pageCount}">
    	<a href="customerQA.do?snum=${snum}&pageNum=${ startPage + 10 }">[다음]</a>
	</c:if>
</c:if>
</div>
</div>