<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <head>
    <title>메 뉴 재 고</title>
    <link rel="stylesheet" type="text/css"  href="/buengbueng/css/bossERP/applyForSettlement.css">
    <link rel="stylesheet" type="text/css"  href="/buengbueng/css/erp.css">
  	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    </head>
    
    <body>
    
    <!-- HEADER TEMPLATE -->
	<jsp:include page="../erp_header.jsp" />
	
	
	<div class="ERP_Navigator">
		<ul>
			<li>ERP 관리</li>
			<li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
			<li>재고관리</li>
		</ul>
	</div>
	

	
    
    <div class="boss_con">
	<div class="menu_titlbox">
		<span>재고 관리</span>
		<button class="menuAdd_btn" onclick="window.location='productInsertForm.do?l_key=${l_key}'">재 고 등 록</button>
	</div>
<div>
	<table class="menu_table">
		<tr>
			<th>카테고리</th>
			<th>재고 명</th>
			<th>재고수량</th>
			<th>상세보기</th>
		</tr>
		<c:forEach var="nl" items="${nameList}" varStatus="stat">
			<tr>
				<td>${categoryList[stat.index]}</td>
				<td>${nl}</td><td>${countList[stat.index]} 개</td>
				<td><button class="menu_stats_btn3" onclick="window.location='productModify.do?name=${nl}&l_key=${l_key}'">상세보기</button></td>
			</tr>
		</c:forEach>
	</table>
</div>



	</div>

  
    
    </body>