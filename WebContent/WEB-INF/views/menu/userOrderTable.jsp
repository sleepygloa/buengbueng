<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <input type="hidden" id ="name" value="${name}" />
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
				<button onclick="window.location='userOrderCancel.do?id=${id}&ordertime=${userOrder.ordertime}&l_key=${l_key}'">주문 취소</button>
			</c:if>
			<c:if test="${userOrder.orderstatus==2}">주문 승인
				<button onclick="window.location='userOrderRefund.do?id=${id}&ordertime=${userOrder.ordertime}&l_key=${l_key}'">환불 요청</button>
			</c:if>
			<c:if test="${userOrder.orderstatus==3}">주문 취소</c:if>
			<c:if test="${userOrder.orderstatus==4}">환불 요청중</c:if>
			<c:if test="${userOrder.orderstatus==5}">환불 완료</c:if>
			<c:if test="${userOrder.orderstatus==6}">환불 불가</c:if>
			
			</td>
			</tr>
			</c:forEach>
			
			</table>