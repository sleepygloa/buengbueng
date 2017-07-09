<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
	<title>PC방 좌석 정보 관리</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script src="/buengbueng/js/bossERP/seatDispose.js"></script>
	<link rel="stylesheet" type="text/css" href="/buengbueng/css/bossERP/seatDispose.css">
</head>

<jsp:include page="../../erp_header.jsp" />

<body>
	<!-- 가맹점 선택하지 않는 경우 -->
	<c:if test="${result eq 'fail'}">
		가맹지점을 선택하여 주세요.
	</c:if>
	<c:if test="${result eq 'succ'}">
	<div class="infoAddModiDel">
		<ul>
			<li>ERP 관리</li>
			<li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
			<li>PC방 관리</li>
			<li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
			<li>PC방 좌석 정보 관리</li>
		</ul>
	</div>
	<div class="infoDiv">
		<br>
		PC 좌석&emsp;<input type="text" id="pcCount" placeholder="추가 좌석 개수"/>&emsp;<input type="button" id="seatAdd" value="추가"/>
		<br/><br/>
		<input type="button" id="seatModi" value="일괄 수정"/>
		&emsp;&emsp;&emsp;
		<input type="button" id="seatDel" value="삭제"/>
		<br><br><hr>
		<div id="seatDisposeFirstDiv">
			<c:forEach begin="1" end="${count}" var="pcNum" step="1">
				<div class="seatDisposeSecondDiv" onclick="showModiPcInfo('${pcNum}')">
					&emsp;<input type="checkBox" value="${pcNum}" name="checkPC"/>&nbsp;&nbsp;${pcNum}
				</div>
			</c:forEach>
		</div>
		<div id="pcInfo"></div>
	</div>
	</c:if>
</body>

<jsp:include page="../../footer.jsp" />