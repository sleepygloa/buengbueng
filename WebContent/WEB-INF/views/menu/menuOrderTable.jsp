<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



    	<table>
    	<tr>
    	<td>주문번호</td><td>주문자 아이디</td><td>주문명</td><td>주문 시간</td><td>주문 금액</td><td>현황</td><td></td>
    	</tr>

    	<c:forEach var="ol" items="${orderList}">

    		<tr>
    		<td>${ol.num}</td><td>${ol.id}</td><td>${ol.menuname}</td><td>${ol.ordertime}</td><td>${ol.ordermoney}</td>
    			<c:if test="${ol.orderstatus==1}"><td>주문 중</td>
    			<td>
    			<button onclick="window.location='menuBarcodeCheck.do?menuname=${ol.menuname}&num=${ol.num}&l_key=${l_key}'">주문승인</button>
    			</td></c:if>
    			<c:if test="${ol.orderstatus==2}"><td>주문완료</td></c:if>		
    			<c:if test="${ol.orderstatus==3}"><td>주문취소</td></c:if>
    			<c:if test="${ol.orderstatus==4}"><td>환불 요청 중</td>
    			<td>
    			<button onclick="window.location='menuOrderRefund.do?ordermoney=${ol.ordermoney}&code=${ol.code}&orderstatus=${ol.orderstatus}&menuname=${ol.menuname}&num=${ol.num}&l_key=${l_key}&id=${ol.id}'">환불 승인</button>
    			<button onclick="window.location='menuOrderNotRefund.do?ordermoney=${ol.ordermoney}&code=${ol.code}&orderstatus=${ol.orderstatus}&menuname=${ol.menuname}&num=${ol.num}&l_key=${l_key}&id=${ol.id}'">환불 거절</button>
    			</td></c:if>
    			<c:if test="${ol.orderstatus==5}"><td>환불 승인</td></c:if>
    			<c:if test="${ol.orderstatus==6}"><td>환불 거절</td></c:if>
    		
    		
    		</tr>    	
			</c:forEach>
    	</table>