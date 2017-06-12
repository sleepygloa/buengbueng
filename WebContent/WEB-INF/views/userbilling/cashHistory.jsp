<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<link rel="stylesheet" type="text/css"  href="/buengbueng/css/payment/cash.css">
		<title>Insert title here</title>
	</head>
	<jsp:include page="../header.jsp" />
	<body>	
		<h1 class="">회원님의 포인트 현황입니다.</h1>
		
		<table>
			<c:forEach items="${payment}" var="payment">
			<tr>
				<td><p>${payment.payment_type}</p></td>
				<td><p>${payment.payment_date}</p></td>
				<td><p>${payment.payment_type}</p></td>
				<td><p>${payment.paying_name}</p></td>
			</tr>
			
			</c:forEach>
		</table>
		
		<p>${check}12</p>
		<div>
			<p>현재 보유 포인트</p>
			<p><strong style="font-size:32px;">0</strong><strong style="font-size:24px;">P</strong></p>
		</div>
		
		<p class="margin_b10"><span><strong>전체 포인트 사용내역 총 5건</strong></span></p>
		<div>
			<table class="cash_history" >
				<tr class="table_header">
					<td>번호</td>
					<td>사용일</td>
					<td>오더아이디</td>
					<td>사용PC방</td>
					<td>사용금액</td>
					<td>시작시간</td>
					<td>종료시간</td>
					<td>잔액</td>
				</tr>
				<c:forEach  begin="1" end="5" step="1" >
				<tr class="table_content margin_b5">
					<td>1</td>
					<td>2017-05-29</td>
					<td>merchant_1496037290036</td>
					<td>${check}</td>
					<td>5,000원</td>
					<td>09:00</td>
					<td>10:00</td>
					<td>10,000원</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		
		<p class="margin_b10"><span><strong>포인트 결제 내역 총 5건</strong></span></p>
		<div>
			<table class="cash_history" border=1;>
				<tr class="table_header">
					<td>번호</td>
					<td>결제일</td>
					<td>결제수단</td>
					<td>거래번호</td>
					<td>결제 금액</td>
					<td>비고</td>
				</tr>
				<c:forEach  begin="1" end="5" step="1" >
				<tr class="table_content">
					<td>1</td>
					<td>2017-05-29</td>
					<td>신용카드</td>
					<td>merchant_1496037290036</td>
					<td>5,000원</td>
					<td>정상</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</body>
	<jsp:include page="../footer.jsp" />
</html>