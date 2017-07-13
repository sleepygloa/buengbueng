<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/buengbueng/css/notice/noticeList.css">
<!-- HEADER TEMPLATE -->

<head>
	<title>Q & A</title>
</head>

<div class="qq">
<div class="title">Q & A</div>
<c:if test="${sessionScope.grade == 4}">
<div class="zxc"><a href="customerForm.do?snum=${snum}&pageNum=${pageNum}">QA작성</a></div>
</c:if>
<table class="er">
<tr>
	<th class="tt1">번호</th>
	<th class="tt2">제목</th>
	<th class="tt3">작성자</th>
	<th class="tt4">작성일</th>
	<th class="tt5">조회</th>
</tr>

<c:if test="${count==0}">
<div>
	<span>등록된 게시물이 없습니다.</span>
</div>
</c:if>

<c:if test="${count>0}">
<c:set value="0" var="d" />
<c:forEach var="list" items="${list}">
<tr>
		<td class="tt1">
			<c:out value="${number}"/>
		</td>
		<td class="tt2"><a href="customerContent.do?num=${list.num}&snum=${snum}&pageNum=${pageNum}&number=${number}&find=2">${list.title}</a></td>
		<td class="tt3">${list.writer}</td>
		<td class="tt4">${dates[d]}</td>
		<td class="tt5">${list.readcount}</td>
</tr>
<c:set var="number" value="${number-1}"/>
<c:set value="${d+1}" var="d" />
</c:forEach>
</table>


<div class="footer"> 	
	<c:if test="${startPage > 10}">
        <a href="serviceCenter.do?snum=${snum}&pageNum=${ startPage - 10 }&find=2">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<a href="serviceCenter.do?snum=${snum}&pageNum=${i}&find=2">[${i}]</a>
	</c:forEach>
	<c:if test="${endPage < pageCount}">
    	<a href="serviceCenter.do?snum=${snum}&pageNum=${ startPage + 10 }&find=2">[다음]</a>
	</c:if>
</c:if>
</div>
</div>