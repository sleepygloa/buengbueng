<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
	<title>PC방 찾기</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script type="text/javascript" src="/buengbueng/js/searchPCRoom/searchPCRoom.js"></script>
	<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=94daac16260e127522f29ef34241f526&libraries=services"></script>
	<link rel="stylesheet" type="text/css" href="/buengbueng/css/bossERP/applyForSettlement.css">
	<link rel="stylesheet" type="text/css" href="/buengbueng/css/ko/kocss.css">
</head>

<jsp:include page="../user_header.jsp" />

<body>
	<div class="ERP_Navigator">
		<ul>
			<li>사용자 PC방 이용</li>
			<li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
			<li>PC방 찾기</li>
			<li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
			<li>PC방 찾기</li>
		</ul>
	</div>
	
	<div class="infoDiv">
		<br/>
		<input type="button" class="modiBtn2" value="PC방 주소 찾기" onclick="seachAddr();">
		<input type="text" id="address" size="50" placeholder="PC방 주소 또는 이름을 입력하십시오.">
		<input type="button" class="modiBtn" value="찾기" onclick="searchPCRoom();"/>
		
		<span id="guide"></span>
		<div class="pcRoomInfo"></div>
		
		<div id="setInfo">
			<div class="pop">
		 		<button id="pop_close">x</button>
		 	</div>
			<div class="pcInfo"></div>
		</div>
		
		<div class="seatState"></div>
	</div>
</body>

<jsp:include page="../footer.jsp" />