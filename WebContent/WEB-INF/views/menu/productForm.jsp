<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <head>
    <title>메 뉴 재 고</title>
    <link rel="stylesheet" type="text/css"  href="/buengbueng/css/bossERP/applyForSettlement.css">
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
		
			
<div class=" margin_bottom50">	
		<div class="col-xs-12-12">
	
	
    
    <div class="boss_con">
	<p style="font-size:25">재고 관리</p>
	<hr>

<div>

		<div align="right" class="dailySettlementList_table">
		<button style="background-color: white; border: none; font-weight: 900" onclick="window.location='productInsertForm.do?l_key=${l_key}'">재 고 등 록</button>
		</div>
	<table class="dailySettlementList_table">
		<tr>
		<td><p>카테고리</p></td><td><p>재고 명</p></td><td><p>재고수량</p></td><td><p>상세보기</p></td>
		</tr>
		<c:forEach var="nl" items="${nameList}" varStatus="stat">
		<tr><td>${categoryList[stat.index]}</td><td>${nl}</td><td>${countList[stat.index]} 개</td>
		<td><button style="background-color: white; border: none; font-weight: 900;" onclick="window.location='productModify.do?name=${nl}&l_key=${l_key}'">상세보기</button></td></tr>
		</c:forEach>
	</table>
</div>



	</div>
	</div>
	</div>
    
  
    
    </body>