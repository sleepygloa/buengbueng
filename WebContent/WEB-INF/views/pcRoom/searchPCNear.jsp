<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
	<title>우리 동네 PC방 찾기</title>
	<script type="text/javascript" src="/buengbueng/js/searchPCRoom/searchPCRoom.js"></script>
	<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=b6f10c55f448ee9fa690fab9e2bfe418&libraries=services"></script>
</head>

<!-- HEADER TEMPLATE -->
<jsp:include page="../header.jsp" />

<body onload="searchPCNear('${addr}');">
	<span id="guide" style="color:#999"></span>
	<div class="pcRoomInfo"></div>
	<div class="seatState"></div>
	<div class="pcInfo"></div>
	
	<!-- FOOTER TEMPLATE -->
	<jsp:include page="../footer.jsp" />
</body>