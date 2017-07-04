<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			.table{border:1px red solid;}
		</style>
	</head>
	
	
	
	<jsp:include page="../../header.jsp" />
	<body>
		<table class="table">
			<tr>
				<th>번호</th>
				<th>가맹점</th>
				<th>아이디</th>
				<th>이름</th>
				<th>사용시작 시간</th>
				<th>사용종료 시간</th>
				<th>총 사용 금액</th>
				<th>PC이용 금액</th>
				<th>상품주문 금액</th>
				<th>주문상품 상세보기</th>
			</tr>
			<c:forEach items="${articleList}" var="articleList">
			<tr>
				<td>
					<c:out value="${number}"/>
					<c:set var="number" value="${number-1}"/>
				</td>
				<td>${articleList.businessName}</td>
				<td>${articleList.userId}</td>
				<td>${articleList.userName}</td>	
				<td>${articleList.usageTime}</td>
				<td>${articleList.endTime}</td>
				<td>${articleList.amountUsed}</td>
				<td>${articleList.pcAmount}</td>
				<td>${articleList.menuAmount}</td>
				<td><a href="#" onclick="window.open('http://localhost:8080/buengbueng/userviewDetails.do?id=${articleList.userId}&starttime=${articleList.usageTime}&endtime=${articleList.endTime}', '_blank', 'width=550 height=500')" >상세보기</a></td>
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
	        		<a href="/buengbueng/pcUseStatusList.do?pageNum=${startPage - 10 }">[이전]</a>
	   		</c:if>
	
	   		<c:forEach var="i" begin="${startPage}" end="${endPage}">
	       		<a href="/buengbueng/pcUseStatusList.do?pageNum=${i}">[${i}]</a>
	   		</c:forEach>
	
	   		<c:if test="${endPage < pageCount}">
	        	<a href="/buengbueng/pcUseStatusList.do?pageNum=${startPage + 10}">[다음]</a>
	   		</c:if>
			</c:if>
		</center>
	</body>
</html>