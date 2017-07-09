<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
	<title>PC방 찾기</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script type="text/javascript" src="/buengbueng/js/searchPCRoom/searchPCRoom.js"></script>
	<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=94daac16260e127522f29ef34241f526&libraries=services"></script>
	<link rel="stylesheet" type="text/css" href="/buengbueng/css/pcRoom/pcRoom.css">
</head>

<jsp:include page="../user_header.jsp" />

<body>
	<div class="pcRoom">
		<ul>
			<li>사용자 PC방 이용</li>
			<li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
			<li>PC방 찾기</li>
			<li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
			<li>PC방 찾기</li>
		</ul>
	</div>
	<div class="pcRoomDiv">
		<br/>
		<input type="button" value="PC방 주소 찾기" onclick="seachAddr();">
		<input type="text" id="address" size="50" placeholder="PC방 주소 또는 이름을 입력하십시오.">
		<input type="button" value="찾기" onclick="searchPCRoom();"/>
		
		<span id="guide" style="color:#999"></span>
		<div class="pcRoomInfo"></div>
		<div class="seatState"></div>
		<div class="pcInfo"></div>
	</div>
</body>

<jsp:include page="../footer.jsp" />