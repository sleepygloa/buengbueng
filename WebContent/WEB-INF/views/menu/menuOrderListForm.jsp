<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <head>
    	<title>주문 현황</title>
    		<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    	<script type="text/javascript" src="/buengbueng/js/menu/menu.js"></script>
    	
    </head>
    
    <body>
    
    <!-- HEADER TEMPLATE -->
	<jsp:include page="/WEB-INF/views/header.jsp" />
    
    
    <div>주문현황 리스트</div>
    <div>

    <div>
    	<table>
    	<tr>
    	<td>주문번호</td><td>주문자 아이디</td><td>주문명</td><td>주문 시간</td><td>주문 금액</td><td>현황</td><td></td>
    	</tr>

    	<c:forEach var="ol" items="${orderList}">

    		<tr>
    		<td>${ol.num}</td><td>${ol.id}</td><td>${ol.menuname}</td><td>${ol.ordertime}</td><td>${ol.ordermoney}</td>
    			<c:if test="${ol.orderstatus==1}"><td>주문 중</td></c:if>
    			<c:if test="${ol.orderstatus==2}"><td>주문완료</td></c:if>		
    			<c:if test="${ol.orderstatus==3}"><td>주문취소</td></c:if>
    		<td>

    			<c:if test="${ol.orderstatus==1}">
	    		<button onclick="window.location='menuBarcodeCheck.do?menuname=${ol.menuname}&num=${ol.num}&l_key=${l_key}'">주문승인</button>
    			</c:if>
    			<c:if test="${ol.orderstatus==2}">
    			
    			</c:if>
    		</td>
    		</tr>    	
			</c:forEach>
    	</table>
    </div>

    </div>
    
    
    </body>