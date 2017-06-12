<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<link rel="stylesheet" type="text/css"  href="/payment/css/cash.css">
		<title>Insert title here</title>
	</head>
	<body>
		<div>
		<table class="cash_table">
			<tr class="table_header">
				<td class="td_title">번호</td>
				<td class="td_title">결제일</td>
				<td class="td_title">구분</td>
				<td class="td_title">결제자 이름</td>
				<td class="td_title">결제 금액</td>
				<td class="td_title">상태</td>
				<td class="td_title">에러메세지</td>
				<td class="td_title">buyChatID</td>
				<td class="td_title">PG사</td>
			</tr >
			<c:forEach items="${payment}" var="payment">
			<tr class="table_content">
				<td><p>${payment.p_num}</p></td>
				<td><p>${payment.payment_date}</p></td>
				<td><p>${payment.payment_type}</p></td>
				<td><p>${payment.paying_name}</p></td>
				<td><p>${payment.paying_price}</p></td>
				<td><p>${payment.confirmation}</p></td>
				<td><p>${payment.error_msg}</p></td>
				<td><p>${payment.buyer_chatid}</p></td>
				<td><p>${payment.pg_name}</p></td>
			</tr>
			</c:forEach>
		</table>
		</div>
	</body>
</html>