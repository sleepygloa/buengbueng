<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>


<head>
<link rel="stylesheet" type="text/css"  href="/buengbueng/css/bossERP/applyForSettlement.css">
<link rel="stylesheet" type="text/css"  href="/buengbueng/css/erp.css">
</head>
<body>

<!-- HEADER TEMPLATE -->
	<jsp:include page="../erp_header.jsp" />
	
		<div class="ERP_Navigator">
			<ul>
				<li>ERP 관리</li>
				<li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
				<li>재고관리</li>
				<li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
				<li>재고등록</li>
			</ul>
		</div>

	<div class="boss_con">
	<p>재고 관리 - 재고 등록</p>
	<hr>
	<table class="menu_table">
		<tr>
			<th>제품명</th>
			<th>바코드</th>
			<th>유통기한</th>
			<th>판매유무</th>
			<th>등록일</th>
			<th colspan="2">수정 / 삭제</th>
		</tr>
		<c:forEach var="product" items="${productList}">
			<tr>
				<td>${product.name}</td>
				<td>${product.code}</td>
				<td>${product.lastday}</td>
				<td>${product.salecheck}</td>
				<td>${product.beginregist}</td>
				<td width="150"><button class="menu_stats_btn" onclick="window.location='productModifyForm.do?name=${product.name}&code=${product.code}&l_key=${l_key}'">수 정</button></td>
				<td width="150"><button class="menu_stats_btn2" onclick="window.location='productDeletePro.do?name=${product.name}&code=${product.code}&l_key=${l_key}'">삭 제</button></td>
			</tr>
		</c:forEach>
		
	</table>


	<div>
		<button class="applyForSettlement_button" onclick="window.location='product.do?l_key=${l_key}'">돌아가기</button>
	</div>
	</div>

</body>