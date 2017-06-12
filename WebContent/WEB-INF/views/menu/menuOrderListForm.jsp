<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <head>
    	<title>주문 현황</title>
    		<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    	<script type="text/javascript" src="/buengbueng/js/menu/menu.js"></script>
    	
    </head>
    
    <body>
    
    <div>주문현황 리스트</div>
    <div>
    <form action="menuBarcodeCheck.do" method="post">
    <div>
    	<table>
    	<tr>
    	<td>주문번호</td><td>주문자 아이디</td><td>주문명</td><td>주문 시간</td><td>주문 금액</td><td>현황</td><td></td>
    	</tr>
    	<c:forEach var="ol" items="${orderList}">
    		<tr>
    		<td>${ol.num}</td><td>${ol.id}</td><td>${ol.menuname}</td><td>${ol.ordertime}</td><td>${ol.ordermoney}</td><td>${status}</td>		
    		<td><input type="submit" value="주문 승인"/>
    			<input type="hidden" name="num" value="${ol.num}"/>
    			<input type="hidden" name="menuname" value="${ol.menuname}">
    		</td>
    		</tr>    	
    		</c:forEach>
    	</table>
    </div>
    </form>
    </div>
    
    
    </body>