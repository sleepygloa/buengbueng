<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
	<title>PC방 좌석 정보 관리</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script src="/buengbueng/js/bossERP/seatDispose.js"></script>
	<link rel="stylesheet" type="text/css" href="/buengbueng/css/bossERP/applyForSettlement.css">
	<link rel="stylesheet" type="text/css" href="/buengbueng/css/ko/kocss.css">
	<link rel="stylesheet" type="text/css"  href="/buengbueng/css/erp.css">
</head>

<jsp:include page="../../erp_header.jsp" />

<body>
	<!-- 가맹점 선택하지 않는 경우 -->
	<c:if test="${result eq 'fail'}">
		가맹지점을 선택하여 주세요.
	</c:if>
	<c:if test="${result eq 'succ'}">
	<div class="ERP_Navigator">
		<ul>
			<li>ERP 관리</li>
			<li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
			<li>PC방 관리</li>
			<li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
			<li>PC방 좌석 정보 관리</li>
		</ul>
	</div>
	<div class="boss_con">
	<div class="seatDispose_titlebox">
		<span>PC방 좌석정보 관리</span>
		<div class="seatDispose_btn_box2_right">
			<input class="seatDispose_btn_box2_left_in"type="text" id="pcCount" placeholder="추가 좌석 개수"/>
			<input type="button" class="seatDispose_button2" id="seatAdd" value="추가"/>
		</div>		
	</div>
	<hr>
		<div class="seatDispose_box">
			<div class="seatDispose_btn_box">
				<div class="seatDispose_btn_box2">
					<div class="seatDispose_btn_box2_right">						
						<input type="button" class="seatDispose_button" id="seatModi" value="일괄 수정"/>
						<input type="button" style="margin-right:3%;" class="seatDispose_button" id="seatDel" value="삭제"/>
					</div>
				</div>
			</div>
			
			
			
			
			<div id="seatDisposeFirstDiv">
				<c:forEach begin="1" end="${count}" var="pcNum" step="1">
					<div class="seatDisposeSecondDiv" onclick="showModiPcInfo('${pcNum}')">
					<input class="seatDispose_checkbox" type="checkBox" value="${pcNum}" name="checkPC"/>&nbsp;&nbsp;${pcNum}
					</div>
				</c:forEach>
			</div>
			<div id="pcInfo"></div>
		</div>
			
	</div>
		</c:if>

</body>

<jsp:include page="../../footer.jsp" />