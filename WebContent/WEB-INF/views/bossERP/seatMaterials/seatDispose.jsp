<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
	<title>PC방 좌석 정보 관리</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script src="/buengbueng/js/bossERP/seatDispose.js"></script>
	<link rel="stylesheet" type="text/css" media="all" href="css/dist/modules.min.css">
	<link rel="stylesheet" type="text/css" href="/buengbueng/css/bossERP/seatDispose.css">
</head>

<body>
	<!-- HEADER TEMPLATE -->
	<jsp:include page="/WEB-INF/views/header.jsp" />
	PC방 좌석 정보 관리<br/>
	<div>
		&emsp;&emsp;&emsp;
		<input type="text" id="pcCount"/>&emsp;<input type="button" id="seatAdd" value="추가"/>
		&emsp;&emsp;&emsp;
		<input type="button" id="seatModi" value="일괄 수정"/>
		&emsp;&emsp;&emsp;
		<input type="button" id="seatDel" value="삭제"/>
	</div>
	<br/><br/>
	<div  class="bg4 row">
		<div id="seatDisposeFirstDiv" class="col-xs-12-12 col-sm-12-12 col-md-12-12">
			<c:forEach begin="1" end="${count}" var="pcNum" step="1">
				<div id="seatDisposeSecondDiv">
					<input type="checkBox" value="${pcNum}" name="checkPC"/>${pcNum}
					<br><input type="button" value="정보 보기" onclick="showModiPcInfo('${pcNum}','0')"/><br/>
					<br><input type="button" value="정보 수정" onclick="showModiPcInfo('${pcNum}','1')"/>
				</div>
			</c:forEach>
		</div>
		<div id="pcInfo" class="col-xs-12-12 col-sm-12-12 col-md-12-12"></div>
	</div>
</body>