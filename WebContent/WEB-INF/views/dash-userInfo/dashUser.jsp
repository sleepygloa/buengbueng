<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 메뉴 및 css 내용 -->
<jsp:include page="../dashHeader.jsp"/>

<div>
<div>
	<span>아이디</span>
	<span>비밀번호</span>
	<span>이름</span>
	<span>생일</span>
	<span>연락처</span>
	<span>이메일</span>
	<span>주소</span>
	<span>등급</span>
	<span>Google 아이디</span>
	<span>가입 날짜</span>
</div>

<c:forEach var="list" items="${list}">
<div>
	<span>${list.id}</span>
	<span>${list.pw}</span>
	<span>${list.name}</span>
	<span>${list.birth}</span>
	<span>${list.phone}</span>
	<span>${list.email}</span>
	<span>${list.address}</span>
	<span>${list.grade}</span>
		<c:if test="${list.googleid != null}">
			<span>${list.googleid}</span>
		</c:if>
		<c:if test="${list.googleid == null}">
			<span>일반 가입</span>
		</c:if>
	<span>${list.signdate}</span>
</div>
</c:forEach>
	
	<c:if test="${startPage > 10}">
        <a href="dashUser.do?grade=${grade}&pageNum=${ startPage - 10 }">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<a href="dashUser.do?grade=${grade}&pageNum=${i}">[${i}]</a>
	</c:forEach>
	<c:if test="${endPage < pageCount}">
    	<a href="dashUser.do?grade=${grade}&pageNum=${ startPage + 10 }">[다음]</a>
	</c:if>
</div>

<!-- js 내용 -->
<jsp:include page="../dashFooter.jsp"/>