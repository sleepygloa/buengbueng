<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
	<title>pc방 좌석 현황</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script src="/buengbueng/js/bossERP/seatState.js"></script>
	<link rel="stylesheet" type="text/css" href="/buengbueng/css/bossERP/seatDispose.css" />
</head>

<body>
	<div class="seatDisposeFirstDiv">
		<c:if test="${count != 0}">
			<c:set var="usePcCount" value="0" />
			<c:forEach begin="1" end="${count}" var="pcNum" step="1">
				<c:if test="${seatCon[pcNum-1] == '0'}">
					<div class="seatDisposeSecondDiv">
						<input type="checkBox" value="${pcNum}" name="checkPC"/>${pcNum}
					</div>
				</c:if>
				<c:if test="${seatCon[pcNum-1] == '1'}">
					<div class="seatDisposeSecondDiv2">
						<input type="checkBox" value="${pcNum}" name="checkPC"/>${pcNum}<br/>
						<c:forEach var="num" items="${useSeatNum}">
							<c:if test="${num == (pcNum)}">
								${useSeatId.get(usePcCount)}님
							</c:if>
						</c:forEach>
					</div>
					<c:set var="usePcCount" value="${usePcCount+1}" />
				</c:if>
			</c:forEach>
			<br/>
			<p>${usePcCount}/${count}</p>
		</c:if>
		<c:if test="${count == 0}">
			좌석 정보를 먼저 추가하십시오.
		</c:if>
	</div>
</body>