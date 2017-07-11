<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>


<head>
<link rel="stylesheet" type="text/css"  href="/buengbueng/css/bossERP/applyForSettlement.css">
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
	
	<div class=" margin_bottom50">	
		<div class="col-xs-12-12">
	
	
	<div class="boss_con">
	<p style="font-size:25">재고 관리 - 재고 등록</p>
	<hr>
<table class="dailySettlementList_table">
	<tr>
	<td><p>제품명</p></td><td><p>바코드</p></td><td><p>유통기한</p></td><td><p>판매유무</p></td><td><p>등록일</p></td><td colspan="2" width="300"><p>수정 / 삭제</p></td>
	</tr>
	<c:forEach var="product" items="${productList}">
		<tr>
		<td>${product.name}
		<td>${product.code}
		<td>${product.lastday}
		<td>${product.salecheck}
		<td>${product.beginregist}
		<td width="150"><button style="background-color: white; border: none; font-weight: 900;" onclick="window.location='productModifyForm.do?name=${product.name}&code=${product.code}&l_key=${l_key}'">수 정</button></td>
		<td width="150"><button style="background-color: white; border: none; font-weight: 900;" onclick="window.location='productDeletePro.do?name=${product.name}&code=${product.code}&l_key=${l_key}'">삭 제</button></td>
		</tr>
	</form>
	</c:forEach>
	
</table>


<div>
	<button class="applyForSettlement_button" onclick="window.location='product.do?l_key=${l_key}'">돌아가기</button>
</div>
</div>
</div>
</div>
</body>