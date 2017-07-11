<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <head>
    	<title>주문 현황</title>
    	<link rel="stylesheet" type="text/css"  href="/buengbueng/css/bossERP/applyForSettlement.css">
    		<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    	<script type="text/javascript" src="/buengbueng/js/menu/menu.js"></script>
    	<script type="text/javascript" src="/buengbueng/js/menu/menuStatus.js"></script>
    	
    </head>
    
    <body>    
    
    <!-- HEADER TEMPLATE -->
	<jsp:include page="../erp_header.jsp" />
    
    		<div class="ERP_Navigator">
			<ul>
				<li>ERP 관리</li>
				<li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
				<li>주문 관리</li>
				<li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
				<li>가맹점 주문현황</li>
			</ul>
		</div>
	
    
	<div class="margin_bottom50">	
		<div class="col-xs-12-12">
	
	<div class="boss_con">
	<p style="font-size:25">주문현황 리스트</p>
	<hr>

	<input type="hidden" id="l_key" value="${l_key}" />
  
    	<table class="dailySettlementList_table">
    	<tr>
    	<td>주문번호</td><td>주문자 아이디</td><td>주문명</td><td>주문 시간</td><td>주문 금액</td><td>현황</td><td></td>
    	</tr>

    	<c:forEach var="ol" items="${orderList}">

    		<tr>
    		<td>${ol.num}</td><td>${ol.id}</td><td>${ol.menuname}</td><td>${ol.ordertime}</td><td>${ol.ordermoney}</td>
    			<c:if test="${ol.orderstatus==1}"><td>주문 중</td>
    			<td>
    			<button style="border:none; background-color: white" onclick="window.location='menuBarcodeCheck.do?menuname=${ol.menuname}&num=${ol.num}&l_key=${l_key}'">주문승인</button>
    			</td></c:if>
    			<c:if test="${ol.orderstatus==2}"><td>주문완료</td></c:if>		
    			<c:if test="${ol.orderstatus==3}"><td>주문취소</td></c:if>
    			<c:if test="${ol.orderstatus==4}"><td>환불 요청 중</td>
    			<td>
    			<button style="border:none; background-color: white" onclick="window.location='menuOrderRefund.do?ordermoney=${ol.ordermoney}&code=${ol.code}&orderstatus=${ol.orderstatus}&menuname=${ol.menuname}&num=${ol.num}&l_key=${l_key}&id=${ol.id}'">환불 승인</button>
    			<button style="border:none; background-color: white" onclick="window.location='menuOrderNotRefund.do?ordermoney=${ol.ordermoney}&code=${ol.code}&orderstatus=${ol.orderstatus}&menuname=${ol.menuname}&num=${ol.num}&l_key=${l_key}&id=${ol.id}'">환불 거절</button>
    			</td></c:if>
    			<c:if test="${ol.orderstatus==5}"><td>환불 승인</td></c:if>
    			<c:if test="${ol.orderstatus==6}"><td>환불 거절</td></c:if>
    		
    		
    		</tr>    	
			</c:forEach>
    	</table>
    </div>
	</div>
	</div>
    
    <div class=" margin_bottom10">	
		<div class="col-xs-12-12">
	
	<div class="boss_con">
	<p style="font-size:25">주문현황 리스트</p>
	<hr>

	<input type="hidden" id="l_key" value="${l_key}" />
  
    	<table class="dailySettlementList_table">
    	<tr>
    	<td>주문번호</td><td>주문자 아이디</td><td>주문명</td><td>주문 시간</td><td>주문 금액</td><td>현황</td><td></td>
    	</tr>

    	<c:forEach var="ol" items="${orderList}">

    		<tr>
    		<td>${ol.num}</td><td>${ol.id}</td><td>${ol.menuname}</td><td>${ol.ordertime}</td><td>${ol.ordermoney}</td>
    			<c:if test="${ol.orderstatus==1}"><td>주문 중</td>
    			<td>
    			<button style="border:none; background-color: white" onclick="window.location='menuBarcodeCheck.do?menuname=${ol.menuname}&num=${ol.num}&l_key=${l_key}'">주문승인</button>
    			</td></c:if>
    			<c:if test="${ol.orderstatus==2}"><td>주문완료</td></c:if>		
    			<c:if test="${ol.orderstatus==3}"><td>주문취소</td></c:if>
    			<c:if test="${ol.orderstatus==4}"><td>환불 요청 중</td>
    			<td>
    			<button style="border:none; background-color: white" onclick="window.location='menuOrderRefund.do?ordermoney=${ol.ordermoney}&code=${ol.code}&orderstatus=${ol.orderstatus}&menuname=${ol.menuname}&num=${ol.num}&l_key=${l_key}&id=${ol.id}'">환불 승인</button>
    			<button style="border:none; background-color: white" onclick="window.location='menuOrderNotRefund.do?ordermoney=${ol.ordermoney}&code=${ol.code}&orderstatus=${ol.orderstatus}&menuname=${ol.menuname}&num=${ol.num}&l_key=${l_key}&id=${ol.id}'">환불 거절</button>
    			</td></c:if>
    			<c:if test="${ol.orderstatus==5}"><td>환불 승인</td></c:if>
    			<c:if test="${ol.orderstatus==6}"><td>환불 거절</td></c:if>
    		
    		
    		</tr>    	
			</c:forEach>
    	</table>
    </div>
	</div>
	</div>
    
    
    </body>