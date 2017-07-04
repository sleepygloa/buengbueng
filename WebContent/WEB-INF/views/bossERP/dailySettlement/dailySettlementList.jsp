<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			.tabl tr{border:1px red solid; width:auto;}
			.tabl td{border:1px red solid; width:auto;}
			.tabl th{border:1px red solid; width:auto;}
		</style>
	</head>
	
	<jsp:include page="../../header.jsp" />
	
	<body >
		<table border="1" class="tabl">
			<tr>
				<th>번호</th>
				<th>정산일자</th>
				<th>가맹주 아이디</th>
				<th>가맹점</th>
				<th>정산 내역 수</th>
				<th>계좌번호</th>
				<th>정산금액</th>
				<th>상품상세보기</th>
				<th>사용자 이용내역</th>
				<th>현황</th>
			</tr>
			<c:if test="${count > 0}">
			<c:forEach items="${articleList}" var="articleList">
				<tr>
					<td>
						<c:out value="${number}"/>
						<c:set var="number" value="${number-1}"/>
					</td>
					<td>${articleList.settlementDate}</td> 	
					<td>${articleList.bossId}</td>
					<td>${articleList.companyName}</td>
					<td>${articleList.settlementNumber}</td>
					<td>${articleList.requestedAccount}</td>
					<td>${articleList.settlementAmount}</td>
					<td><a href="#" onclick="window.open('http://localhost:8080/buengbueng//viewDetails.do?settlementDate=${articleList.settlementDate}', '_blank', 'width=550 height=500')" >상세보기</a></td>
					<td><a href="#" onclick="window.open('http://localhost:8080/buengbueng/viewDetails.do?settlementDate=${articleList.settlementDate}', '_blank', 'width=550 height=500')" >상세보기</a></td>
					<td>${articleList.settlementStatus}</td>
				</tr>
			</c:forEach>
			</c:if>
		</table>
	</body>
</html>