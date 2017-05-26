<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
	<title>회원 정보</title>
</head>
<body>
	<table>
		<tr>
			<td>아이디</td>
			<td>${user.id}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${user.name}</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td>${user.birth}</td>
		</tr>
		<tr>
			<td>전화 번호</td>
			<td>${user.phone}</td>
		</tr>
		<tr>
			<td>등급</td>
			<td>${user.grade}</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>${user.address}</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${user.email}</td>
		</tr>
	</table>
</body>