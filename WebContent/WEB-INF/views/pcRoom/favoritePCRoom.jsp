<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
	<title>즐겨찾는 PC방</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
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
			<li>즐겨찾는 PC방</li>
			<li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
			<li>즐겨찾는 PC방</li>
		</ul>
	</div>
	
	<div class="infoDiv">
		<c:if test="${favoritePCRoom.size() != 0}">
			<br/>
			<c:forEach var="favoritePCRoom" items="${favoritePCRoom}">
				<b onclick="pcRoomInfo('${favoritePCRoom.b_name}','${favoritePCRoom.b_id}');">${favoritePCRoom.b_name}</b>&emsp;
			</c:forEach>
			
			<div id="setInfo">
				<div class="pop">
			 		<button id="pop_close">x</button>
			 	</div>
					<div class="pcInfo"></div>
			</div>
			<div class="pcRoomInfo"></div>
			<div class="seatState"></div>
		</c:if>
		<c:if test="${favoritePCRoom.size() == 0}">
			<table border="1" class="dailySettlementList_table">
				<tr class="dailySettlementList_NoCount">
					<td colspan="9">
						<p>
						<img src="/buengbueng/img/bossERP/bg_alert.gif" width="40" height="40">
							조회결과가 없습니다.
						</p>
					</td>
				</tr>
			</table>
		</c:if>
	</div>
</body>

<jsp:include page="../footer.jsp" />