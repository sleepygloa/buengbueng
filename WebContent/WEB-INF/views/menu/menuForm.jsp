<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <head>
	<title>메 뉴</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css"  href="/buengbueng/css/bossERP/applyForSettlement.css">
	<link rel="stylesheet" type="text/css"  href="/buengbueng/css/erp.css">
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
	
	
	

	<div class="boss_con">
	<div class="menu_titlbox">
		<span>메뉴 관리</span>
		<button class="menuAdd_btn" onclick="window.location='menuInsertForm.do?l_key=${l_key}'">메 뉴 추 가</button>
	</div>
	<hr>

	<div class="category_con_box">
		<div class="category_box">
			<button class="menu_category_total" onclick="alls('${l_key}')">전 체</button>
			<c:forEach var="category" items="${categoryList}">
				<input type="button" name="${category}" class="menu_category_total" onclick="category('${category}','${l_key}')" value="${category}" /> 
			</c:forEach>
		</div>
	</div>
	<div>


		
		
		</div>
		<table id="categoryMenu" class="menu_table">	
		<tr align="center">
			<th width="200">카테고리</th>
			<th width="400">제 품</th>
			<th>제조사</th>
			<th>가 격</th>
			<th colspan="2" width="300">수정 / 삭제</th>
		</tr>
		<c:forEach var="menu" items="${menuList}">
		<tr >
			<td>${menu.category}</td>
			<td>${menu.name}</td>
			<td>${menu.company}</td>
			<td>${menu.price}</td>
			<td width="150"><button class="menu_stats_btn" onclick="window.location='menuModifyForm.do?name=${menu.name}&l_key=${menu.l_key}'">수정</button></td>
			<td width="150"><button class="menu_stats_btn2" onclick="window.location='menuDeletePro.do?name=${menu.name}&l_key=${menu.l_key}'">삭제</button></td>
		</tr>
		</c:forEach>
		
		
		</table>
		
		
	</div>
	</div>

	
</body>