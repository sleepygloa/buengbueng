<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
	<title>PC방 이용현황 관리</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script src="/buengbueng/js/bossERP/seatState.js"></script>
	<link rel="stylesheet" type="text/css" href="/buengbueng/css/bossERP/seatDispose.css" />
</head>

<body>
	<!-- HEADER TEMPLATE -->
	<jsp:include page="/WEB-INF/views/header.jsp" />
	PC방 이용현황 관리
	<br/>
	<br/>
	가맹점 선택&emsp;&emsp;
	<select id="b_key">
		<c:forEach var="franchisee" items="${franchisee}">
			<option value="${franchisee.b_key}">${franchisee.b_name}</option>
		</c:forEach>
	</select>&emsp;
	<input type="button" value="확인" id="getSeatState"/>
	<br/>
	<div class="seatState"></div>
</body>