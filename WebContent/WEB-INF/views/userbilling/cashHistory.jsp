<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<link rel="stylesheet" type="text/css"  href="/buengbueng/css/payment/cash.css">
		<title>나의 포인트 | buengbueng</title>
	</head>
	<jsp:include page="../header.jsp" />
	
	<body>
	
	<div class="head_emp"></div>
	
	<div class="history_tbox">
		<div class="title_text_box">
			<p>나의 포인트</p>
			<span>내가 가진 buengbueng 포인트의 사용과 내용을 확인 할 수 있습니다.</span>
		</div>
	</div>
	
	<div class="history_point">
		<div class="history_point_img">
			<div class="history_point_tbox">
				<P>${id}님의 현재 보유 포인트는 <span >${c.money}P</span> 입니다.</P>
				<button class="cash_btn" onclick="location.href='http://localhost:8080/buengbueng/userbilling/cash.do'">충전하기</button>
			</div>
		</div>
		<div class="history_point_List ">
		<p class="history_point_List_title">포인트 결제 내역 총 ${count}건</p>
		<c:if test="${count > 0}">
			<table class="cash_history" border=1;>
				<tr class="table_header">
					<td><p>번호</p></td>
					<td>주문 ID</td>
					<td>구매일</td>
					<td>결제수단</td>
					<td>가격</td>
					<td>비고</td>
				</tr>
				<c:forEach  items="${articleList}" var="articleList">
				<tr class="table_content">
					<td>
						<c:out value="${number-1}"/>
						<c:set var="number" value="${number-1}"/>
					</td>
					<td><p>${articleList.imp_uid}/${articleList.merchant_uid}</p></td>
					<td>${articleList.payment_date}</td>
					<td>${articleList.pg_name}</td>
					<td>${articleList.paying_price}</td>
					<td>${articleList.confirmation}</td>
				</tr>
				</c:forEach>
			</table>
			</c:if>
		</div>
	</div>
	
		
		<center>
		    <c:if test="${count > 0}">
	        <c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}"/>
	        <c:set var="pageBlock" value="${10}"/>
	        <fmt:parseNumber var="result" value="${currentPage / 10}" integerOnly="true" />
	        <c:set var="startPage" value="${result * 10 + 1}" />
	        <c:set var="endPage" value="${startPage + pageBlock-1}"/>
	        <c:if test="${endPage > pageCount}">
	            <c:set var="endPage" value="${pageCount}"/>
	   		</c:if> 
	          
	   		<c:if test="${startPage > 10}">
	        		<a href="/buengbueng/userbilling/cashHistory.do?pageNum=${startPage - 10 }">[이전]</a>
	   		</c:if>
	
	   		<c:forEach var="i" begin="${startPage}" end="${endPage}">
	       		<a href="/buengbueng/userbilling/cashHistory.do?pageNum=${i}">[${i}]</a>
	   		</c:forEach>
	
	   		<c:if test="${endPage < pageCount}">
	        	<a href="/buengbueng/userbilling/cashHistory.do?pageNum=${startPage + 10}">[다음]</a>
	   		</c:if>
			</c:if>
		</center>
	 
	<p>1</p>
	</body>
	
	<jsp:include page="../footer.jsp" />
	
</html>