<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- HEADER TEMPLATE -->
<jsp:include page="../erp_header.jsp" />
<style>
	.main_con{width:97%;background:#555; height:auto; MARGIN:20px AUTO; border:1px red solid;}
	.box1{width:25%;height:150px; background: #999; float:left; color:#2ab4c0;}
	.box2{width:25%;height:150px; background: green; float:left;}	
</style>


<div class="main_con">

	<div class="box1">
		<p>총 매출 현황</p>
		<c:if test="${count > 0}">
			<p>${totalAmount}원</p>
		</c:if>
		<c:if test="${count < 1}">
			<p>0원</p>
		</c:if>
	</div>
	
	<div class="box2">
		현재 매출 현황
		<c:if test="${count2 > 0}">
			<p>${dailyAmount}원</p>
		</c:if>
		<c:if test="${count2 < 1}">
			<p>0명</p>
		</c:if>
	</div>
	
	<div class="box1">
		<p>상품재고 현황</p>
		0
	</div>
	
	<div class="box2">
		가맹점 이용자 수
		<c:if test="${count3 > 0}">
			<p>${dailyUserCount}명</p>
		</c:if>
		<c:if test="${count3 < 1}">
			<p>0명</p>
		</c:if>
	</div>
</div>