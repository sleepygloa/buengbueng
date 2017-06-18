<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
	<title>즐겨찾는 PC방</title>
	<script type="text/javascript" src="/buengbueng/js/searchPCRoom/searchPCRoom.js"></script>
</head>

<body>
	<!-- HEADER TEMPLATE -->
	<jsp:include page="../header.jsp" />
	
	<c:forEach var="favoritePCRoom" items="${favoritePCRoom}">
		<b onclick="pcRoomInfo('${favoritePCRoom.b_name}','${favoritePCRoom.b_id}');">${favoritePCRoom.b_name}</b><br/>
	</c:forEach>
	
	<div class="pcRoomInfo"></div>
	<div class="seatState"></div>
	<div class="pcInfo"></div>
	
	<!-- FOOTER TEMPLATE -->
	<jsp:include page="../footer.jsp" />
</body>