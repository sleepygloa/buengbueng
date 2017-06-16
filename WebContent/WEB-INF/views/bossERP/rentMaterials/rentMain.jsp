<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
	<title>대여물품 관리</title>
</head>

<body>
	<!-- HEADER TEMPLATE -->
	<jsp:include page="/WEB-INF/views/header.jsp" />
	대여물품 관리
	<br/>
	<br/>
	가맹점 선택&emsp;&emsp;
	<form action="rentManage.do" method="post">
		<select  name="b_key">
			<c:forEach var="franchisee" items="${franchisee}">
				<option value="${franchisee.b_key}">${franchisee.b_name}</option>
			</c:forEach>
		</select>&emsp;
		<input type="submit" value="확인"/>
	</form>
</body>