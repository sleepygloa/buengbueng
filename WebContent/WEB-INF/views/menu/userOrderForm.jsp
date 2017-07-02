<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <head>
    	<title>사용자 주문창</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/buengbueng/js/menu/menu.js"></script>
    <script type="text/javascript" src="/buengbueng/js/menu/menuStatus.js"></script>
    </head>
    
    <body>
    <div>
		<button name="menuAll" onclick="useralls('${l_key}','${name}','${id}')">전 체</button>
	</div>
	
    	
    	<div>
		<table>
		<tr>
		<c:forEach var="category" items="${categoryList}">
			<td><input type="button" name="${category}" onclick="usercategory('${category}','${l_key}','${name}','${id}')" value="${category}" /> </td>
		</c:forEach>
		</tr>	
		</table>
	</div>
	
	<div>

		<table >	
		<tr><td>
		<div id="usercategoryMenu"></div>	
		</td></tr>

	
		</table>
	</div>
	<div><br><br></div>
		<input type="hidden" id ="name" value="${name}" />
		<input type="hidden" id ="id" value="${id}" />
		<div class="userMenuStatus">
		<table>
			<tr>
			<td>주문 상황</td>
			</tr>
			<tr>
			<td>가맹점</td><td>주문메뉴</td><td>가격</td><td>주문현황</td>
			<c:forEach var="userOrder" items="${userOrderList}">
			<tr>
			<td>${userOrder.l_key}</td>
			<td>${userOrder.menuname}</td>
			<td>${userOrder.ordermoney}</td>
			<td>
			<c:if test="${userOrder.orderstatus==1}">주문 중
				<button onclick="window.location='userOrderCancel.do?id=${id}&ordertime=${userOrder.ordertime}&l_key=${l_key}&name=${name}&ordermoney=${userOrder.ordermoney}'">주문 취소</button>
			</c:if>
			<c:if test="${userOrder.orderstatus==2}">주문 승인
				<button onclick="window.location='userOrderRefund.do?id=${id}&l_key=${l_key}&ordertime=${userOrder.ordertime}&name=${name}'">환불 요청</button>
			</c:if>
			<c:if test="${userOrder.orderstatus==3}">주문 취소</c:if>
			
			</td>
			</tr>
			</c:forEach>
			
			</table>
		</div>		
	
	
    </body>