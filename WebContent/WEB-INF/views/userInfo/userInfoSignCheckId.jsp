<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
	<title>아이디 중복확인</title>
	<script type="text/javascript" src="/buengbueng/js/userInfo/signForm.js"></script>
</head>
<body>
	<%-- 입력한 아이디가 중복되지 않으면 --%>
	<c:if test="${result == 'idT'}">
		<body onload="setId('${id}')" />
		<p>입력하신 ${id} 는 사용할 수 있는 아이디입니다.</p>
	</c:if>
	
	<%-- 입력한 아이디가 중복되면 --%>
	<c:if test="${result == 'idF'}">
		<p>입력하신 ${id} 는 이미 있는 아이디입니다.</p>
		<form action="userInfoSignCheckId.do">
			<table>
				<tr><td><input name="id" type="text" placeholder="아이디 입력"/></td></tr>
				<tr><td><input type="submit" value="확인" /></td></tr>
			</table>
		</form>
	</c:if>
</body>