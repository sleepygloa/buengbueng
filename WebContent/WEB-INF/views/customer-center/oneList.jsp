<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/buengbueng/css/notice/noticeList.css">
<!-- HEADER TEMPLATE -->
<jsp:include page="../header.jsp" />
<head>
	<title>1:1 문의</title>
</head>
<div>
<div class="title">1:1 문의</div>
<c:if test="${sessionScope.grade != 4 }">
<div class="zxc"><a href="oneForm.do?snum=${snum}&pageNum=${pageNum}">문의하기</a></div>
</c:if>
<div class="top">
	<span class="tt1">번호</span>
	<span class="tt2">제목</span>
	<span class="tt3">작성자</span>
	<span class="tt4">작성일</span>
	<span class="tt5">조회</span>
</div>	
<c:if test="${count==0}">
</div>

<div>
	<span>등록된 게시물이 없습니다.</span>
</div>
</c:if>
<c:if test="${count>0}">
<c:set var="d" value="0"/>
<c:forEach var="list" items="${list}">
<div class="middle1">
		<span class="tt1">
		<c:out value="${number}"/>
		</span>
		<c:if test="${sessionScope.grade != 4 }">
			<span class="tt2"><a href="oneWriteCheck.do?num=${list.num}&snum=${snum}&pageNum=${pageNum}&number=${number}">${list.title}</a></span>
		</c:if>
		<c:if test="${sessionScope.grade == 4 }">
			<span class="tt2"><a href="oneContent.do?num=${list.num}&snum=${snum}&pageNum=${pageNum}&number=${number}">${list.title}</a></span>
		</c:if>
		<span class="tt3">${list.writer}</span>
		<span class="tt4">${dates[d]}</span>
		<span class="tt5">${list.readcount}</span>
</div>
		<c:set var="number" value="${number-1}"/>
		<c:set value="${d+1}" var="d" />
</c:forEach>
	
<div class="footer">	
	<c:if test="${startPage > 10}">
        <a href="oneQA.do?snum=${snum}&pageNum=${ startPage - 10 }">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<a href="oneQA.do?snum=${snum}&pageNum=${i}">[${i}]</a>
	</c:forEach>
	<c:if test="${endPage < pageCount}">
    	<a href="oneQA.do?snum=${snum}&pageNum=${ startPage + 10 }">[다음]</a>
	</c:if>
</c:if>
</div>
</div>
