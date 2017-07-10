<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <head>
	<title>메 뉴</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css"  href="/buengbueng/css/bossERP/applyForSettlement.css">
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/buengbueng/js/menu/menu.js"></script>
	</head>

<body>
<!-- HEADER TEMPLATE -->
	<jsp:include page="../erp_header.jsp" />

	<!-- 페이지 제목 -->

	
			<div class="ERP_Navigator">
			<ul>
				<li>ERP 관리</li>
				<li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
				<li>메뉴관리</li>
			</ul>
		</div>
	
	
	
<div class=" margin_bottom50">	
		<div class="col-xs-12-12">
	
	<div class="boss_con">
	<p style="font-size:25">메뉴 관리</p>
	<hr>


		<button class="applyForSettlement_button1" style="font-weight: 900" onclick="alls('${l_key}')">전 체</button>
		<c:forEach var="category" items="${categoryList}">
		<input type="button" style="font-weight: 900" name="${category}" class="applyForSettlement_button1" onclick="category('${category}','${l_key}')" value="${category}" /> 
		</c:forEach>
	

	<div>


		<div align="right" class="dailySettlementList_table">
		<button style="background-color: white; border: none; font-weight: 900" onclick="window.location='menuInsertForm.do?l_key=${l_key}'">메 뉴 추 가</button>
		</div>
		<table id="categoryMenu" class="dailySettlementList_table">	
		<tr align="center">
		<td> <p>카테고리</p></td><td><p>제 품</p></td><td><p>제조사</p></td><td><p>가 격</p></td><td colspan="2"><p>수정 / 삭제</p></td>
		</tr>
		<c:forEach var="menu" items="${menuList}">
		<tr >
		<td>${menu.category}</td><td>${menu.name}</td><td>${menu.company}</td><td>${menu.price}</td>
		<td width="100"><button style="background-color: white; border: none; font-weight: 900;" onclick="window.location='menuModifyForm.do?name=${menu.name}&l_key=${menu.l_key}'">수정</button></td>
		<td width="100"><button style="background-color: white; border: none; font-weight: 900;" onclick="window.location='menuDeletePro.do?name=${menu.name}&l_key=${menu.l_key}'">삭제</button></td>
		</tr>
		</c:forEach>
		
		
		</table>
		
		
	</div>
	</div>
	</div>
</div>
	
</body>