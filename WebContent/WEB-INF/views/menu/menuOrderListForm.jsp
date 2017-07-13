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
	<p style="font-size:25">주문현황</p>
	<hr>
	
		<div class="boss_con">
	<p style="font-size:20">주문처리 요청 리스트</p>
	<hr>
  <div class="bossMenuStatus">
	<input type="hidden" id="l_key" value="${l_key}" />
  
    	<table class="StockList_table">
    	<tr>
    	<td>주문번호</td><td>주문자 아이디</td><td>주문명</td><td>주문 시간</td><td>주문 금액</td><td>현황</td><td>확인</td>
    	</tr>

    	<c:forEach var="cl" items="${canList}">

    		<tr>
    		<td>${cl.num}</td><td>${cl.id}</td><td>${cl.menuname}</td><td>${cl.ordertime}</td><td>${cl.ordermoney}</td>
    			<c:if test="${cl.orderstatus==1}"><td style="background-color:#FFA7A7">주문 중</td>
    			<td>
    			<button style="border:none; background-color: white" onclick="window.location='menuBarcodeCheck.do?menuname=${cl.menuname}&num=${cl.num}&l_key=${l_key}'">주문승인</button>
    			</td></c:if>
    			<c:if test="${cl.orderstatus==2}"><td style="background-color:#B2CCFF">주문완료</td><td></td></c:if>		
    			<c:if test="${cl.orderstatus==3}"><td style="background-color:#D5D5D5">주문취소</td><td></td></c:if>
    			<c:if test="${cl.orderstatus==4}"><td style="background-color:#FFE08C ">환불 요청 중</td>
    			<td>
    			<button style="border:none; background-color: white" onclick="window.location='menuOrderRefund.do?ordermoney=${cl.ordermoney}&code=${cl.code}&orderstatus=${cl.orderstatus}&menuname=${cl.menuname}&num=${cl.num}&l_key=${l_key}&id=${cl.id}'">환불 승인</button>
    			<button style="border:none; background-color: white" onclick="window.location='menuOrderNotRefund.do?ordermoney=${cl.ordermoney}&code=${cl.code}&orderstatus=${cl.orderstatus}&menuname=${cl.menuname}&num=${cl.num}&l_key=${l_key}&id=${cl.id}'">환불 거절</button>
    			</td></c:if>
    			<c:if test="${cl.orderstatus==5}"><td style="background-color:#B2CCFF ">환불 승인</td><td></td></c:if>
    			<c:if test="${cl.orderstatus==6}"><td style="background-color:#B2CCFF ">환불 거절</td><td></td></c:if>
    		
    		
    		</tr>    	
			</c:forEach>
    	</table>

    	
    	    		<div class="boss_con">
	<p style="font-size:20">주문처리 완료 리스트</p>
	<hr>

	<input type="hidden" id="l_key" value="${l_key}" />
  
    	<table class="StockList_table">
    	<tr>
    	<td>주문번호</td><td>주문자 아이디</td><td>주문명</td><td>주문 시간</td><td>주문 금액</td><td>현황</td>
    	</tr>

    	<c:forEach var="ctl" items="${cantList}">

    		<tr>
    		<td>${ctl.num}</td><td>${ctl.id}</td><td>${ctl.menuname}</td><td>${ctl.ordertime}</td><td>${ctl.ordermoney}</td>
    			<c:if test="${ctl.orderstatus==1}"><td style="background-color:#FFA7A7">주문 중</td>
    			<td>
    			<button style="border:none; background-color: white" onclick="window.location='menuBarcodeCheck.do?menuname=${ctl.menuname}&num=${ctl.num}&l_key=${l_key}'">주문승인</button>
    			</td></c:if>
    			<c:if test="${ctl.orderstatus==2}"><td style="background-color:#B2CCFF">주문완료</td></c:if>		
    			<c:if test="${ctl.orderstatus==3}"><td style="background-color:#D5D5D5">주문취소</td></c:if>
    			<c:if test="${ctl.orderstatus==4}"><td style="background-color:#FFE08C ">환불 요청 중</td>
    			<td>
    			<button style="border:none; background-color: white" onclick="window.location='menuOrderRefund.do?ordermoney=${ctl.ordermoney}&code=${ctl.code}&orderstatus=${ctl.orderstatus}&menuname=${ctl.menuname}&num=${ctl.num}&l_key=${l_key}&id=${ctl.id}'">환불 승인</button>
    			<button style="border:none; background-color: white" onclick="window.location='menuOrderNotRefund.do?ordermoney=${ctl.ordermoney}&code=${ctl.code}&orderstatus=${ctl.orderstatus}&menuname=${ctl.menuname}&num=${ctl.num}&l_key=${l_key}&id=${ctl.id}'">환불 거절</button>
    			</td></c:if>
    			<c:if test="${ctl.orderstatus==5}"><td style="background-color:#B2CCFF ">환불 승인</td></c:if>
    			<c:if test="${ctl.orderstatus==6}"><td style="background-color:#B2CCFF ">환불 거절</td></c:if>
    		
    		
    		</tr>    	
			</c:forEach>
    	</table>
    	    	</div>
    	</div>
    </div>
	</div>
	</div>
   </div>

    </body>