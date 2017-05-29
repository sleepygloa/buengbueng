<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
	<title>회원 아이디 찾기</title>
</head>
<body>
	<form action="userInfoSearchIdFormPro.do" method="post">
	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
			<td>핸드폰</td>
			<td><input type="text" name="phone"></td>
		</tr>
		<tr>
			<td><input type="submit" value="확인"></td>
			<td><input type="button" value="취소" onclick="window.location='index.do'"></td>
		</tr>
		
		
	</table>
	</form>