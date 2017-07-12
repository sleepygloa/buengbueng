<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		
		<title>Insert title here</title>
	</head>
	<jsp:include page="../dashHeader.jsp"/>
	<body>
		<div>
		<table border="1">
			<tr class="table_header">
				<td class="td_title">번호</td>
				<td class="td_title">결제 아이디</td>
				<td class="td_title">결제일</td>
				<td class="td_title">카드사</td>
				<td class="td_title">상표명</td>
	    	    <td class="td_title">결제금액</td>
				<td class="td_title">상태</td>
				<td class="td_title">상태 메세지</td>
				<td class="td_title">PG사</td>
				<td class="td_title">주문 아이디</td>
				<td class="td_title">PG사 결제번호</td>
				
			</tr >
			<c:forEach items="${articleList}" var="articleList">
			<tr class="table_content">
				<td><p>${articleList.idx}</p></td>
				<td><p>${articleList.buyer_chatid}</p></td>
				<td><p>${articleList.payment_date}</p></td>
				<td><p>${articleList.payment_type}</p></td>
				<td><p>${articleList.paying_name}</p></td>
				<td><p>${articleList.paying_price}</p></td>
				<td><p>${articleList.confirmation}</p></td>
				<td><p>${articleList.error_msg}</p></td>
				<td><p>${articleList.pg_name}</p></td>
				<td><p>${articleList.merchant_uid}</p></td>
				<td><p>${articleList.pg_tid}</p></td>
			</tr>
			</c:forEach>
		</table>
			
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
	        		<a href="/buengbueng/completePayment.do?pageNum=${startPage - 10 }">[이전]</a>
	   		</c:if>
	
	   		<c:forEach var="i" begin="${startPage}" end="${endPage}">
	       		<a href="/buengbueng/completePayment.do?pageNum=${i}">[${i}]</a>
	   		</c:forEach>
	
	   		<c:if test="${endPage < pageCount}">
	        	<a href="/buengbueng/completePayment.do?pageNum=${startPage + 10}">[다음]</a>
	   		</c:if>
			</c:if>
		</center>
		
		</div>
		
	</body>
	
	<jsp:include page="../dashFooter.jsp"/>
</html>	