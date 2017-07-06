<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>유저사용내역</title>
	</head>
	<body>

		<table border="1">
			<tr>
				<th>번호</th>
				<th>사용자 아이디</th>
				<th>사용자 이름</th>
				<th>가맹식별코드</th>
				<th>사용시작 시간</th>
				<th>사용종료 시간</th>
				<th>사용 금액</th>
				<th>기타</th>
			</tr>
			<c:forEach items="${articleList}" var="articleList">
			<tr>
				<td>
					<c:out value="${number-failure}"/>
					<c:set var="number" value="${number-1}"/>
				</td>
				<td>${articleList.userId}</td>
				<td>${articleList.userName}</td>
				<td>${articleList.affiliateCode}</td>
				<td>${articleList.usageTime}</td>
				<td>${articleList.endTime}</td>
				<td>${articleList.amountUsed}</td>
				<td>${articleList.etc}</td>
			</tr>
			</c:forEach>
		</table>
		<button onclick="location.href='http://localhost:8080/buengbueng/userbilling/dailySettlement.do'">일일정산</button>
	</body>
</html>