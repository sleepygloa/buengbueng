<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- HEADER TEMPLATE -->
<jsp:include page="../header.jsp" />
<head>
	<title>가맹 문의</title>
</head>
<div>
<div>가맹 문의</div><div><a href="#">문의하기</a></div>
	<span>번호</span>
	<span>제목</span>
	<span>작성자</span>
	<span>email</span>
	<span>작성일</span>

<c:if test="${count==0}">
<div>
	<span>등록된 게시물이 없습니다.</span>
</div>
</c:if>
<c:if test="${count>0}">
<c:forEach var="list" items="${list}">
<div>
		<span>
			<c:out value="${number}"/>
			<c:set var="number" value="${number-1}"/>
		</span>
		<span><a href="#">${list.title}</a></span>
		<span>${list.writer}</span>
		<span>${list.email}</span>
		<span>${list.reg_date}</span>
</div>
</c:forEach>
	
	<c:if test="${startPage > 10}">
        	<a href="custumerQA.do?num=${snum}&pageNum=${ startPage - 10 }">[이전]</a>
		</c:if>
        <c:forEach var="i" begin="${startPage}" end="${endPage}">
        	<a href="custumerQA.do?num=${snum}&pageNum=${i}">[${i}]</a>
        </c:forEach>
        <c:if test="${endPage < pageCount}">
        	<a href="custumerQA.do?num=${snum}&pageNum=${ startPage + 10 }">[다음]</a>
		</c:if>

</c:if>
</div>