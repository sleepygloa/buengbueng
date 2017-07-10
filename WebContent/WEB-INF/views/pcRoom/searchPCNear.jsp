<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
	<title>우리 동네 PC방 찾기</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/buengbueng/js/searchPCRoom/searchPCRoom.js"></script>
	<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=94daac16260e127522f29ef34241f526&libraries=services"></script>
	<link rel="stylesheet" type="text/css" href="/buengbueng/css/bossERP/applyForSettlement.css">
	<link rel="stylesheet" type="text/css" href="/buengbueng/css/ko/kocss.css">
</head>

<jsp:include page="../user_header.jsp" />

<body onload="searchPCNear('${addr}');">
	<div class="ERP_Navigator">
		<ul>
			<li>사용자 PC방 이용</li>
			<li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
			<li>PC방 찾기</li>
			<li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
			<li>우리동네 PC방 찾기</li>
		</ul>
	</div>
	<div class="infoDiv">
		<span id="guide"></span>
		<div class="pcRoomInfo"></div>
		<div class="seatState"></div>
		<div class="pcInfo"></div>
	</div>
</body>

<jsp:include page="../footer.jsp" />