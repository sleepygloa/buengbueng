<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
	<title>PC방 찾기</title>
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script type="text/javascript" src="/buengbueng/js/searchPCRoom/searchPCRoom.js"></script>
</head>

<body>
	<!-- HEADER TEMPLATE -->
	<jsp:include page="../header.jsp" />
	
	<input type="button" value="PC방 주소 검색" onclick="seachAddr();">
	<input type="text" id="address" size="50" placeholder="주소">
	<input type="button" value="찾기" onclick="searchPCRoom();"/>
	<%--<input type="text" id="sample6_address2" placeholder="상세주소">--%>
	
	<span id="guide" style="color:#999"></span>
	<div class="pcRoomInfo"></div>
	<div class="seatState"></div>
	<div class="pcInfo"></div>
	
	<!-- FOOTER TEMPLATE -->
	<jsp:include page="../footer.jsp" />
</body>