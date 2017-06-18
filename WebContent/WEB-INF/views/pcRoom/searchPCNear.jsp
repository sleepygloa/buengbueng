<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
	<title>우리 동네 PC방 찾기</title>
	<script type="text/javascript" src="/buengbueng/js/searchPCRoom/searchPCRoom.js"></script>
</head>

<body onload="searchPCNear('${addr}');">
	<!-- HEADER TEMPLATE -->
	<jsp:include page="../header.jsp" />
	
	<span id="guide" style="color:#999"></span>
	<div class="pcRoomInfo"></div>
	<div class="seatState"></div>
	<div class="pcInfo"></div>
	
	<!-- FOOTER TEMPLATE -->
	<jsp:include page="../footer.jsp" />
</body>