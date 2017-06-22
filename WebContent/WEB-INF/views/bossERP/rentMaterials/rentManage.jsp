<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
	<title>대여물품 관리</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script src="/buengbueng/js/bossERP/rentManage.js"></script>
	<link rel="stylesheet" type="text/css" href="/buengbueng/css/bossERP/seatDispose.css" />
</head>

<body>

	<!-- HEADER TEMPLATE -->
	<jsp:include page="/WEB-INF/views/header.jsp" />
	
	<div>
		<input type="button" value="대여물품목록 추가" id="addRent"/>&emsp;&emsp;&emsp;
		<input type="button" value="대여물품목록삭제" id="delRent"  />&emsp;&emsp;&emsp;
	</div>
	<br/><br/>
	<div class="seatDisposeFirstDiv">
		<c:if test="${rentList.size() != 0}">
			<input type="button" value="대여물품 추가" id="addRentProduct"/>&emsp;&emsp;&emsp;
			<input type="button" value="대여물품삭제" id="delRentProduct"/>&emsp;&emsp;&emsp;
			<br/><br/>
			<c:forEach var="rentList" items="${rentList}">
				<input type="checkbox" name="rentName" value="${rentList.rentProduct}" />
				${rentList.rentProduct}
				<input type="button" value="수정하기" onclick="modiRent('${rentList.rentProduct}')"/>
				<input type="button" value="물품 보기" onclick="selectedproductList('${rentList.rentProduct}')"/>
			</c:forEach>
		</c:if>
		<c:if test="${rentList.size() == 0}">
			대여물품목록이 없습니다.
		</c:if>
	</div>
	<br/><br/>
	<div class="rentDiv"></div>
</body>