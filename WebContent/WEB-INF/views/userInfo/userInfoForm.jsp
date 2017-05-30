<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
	<title>회원 정보 수정</title>
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
	
	<input type="button" value="회원탈퇴" onclick="javascript:window.location='/buengbueng/userInfoDeleteForm.do'" />
	<input type="button" value="회원 정보수정"  onclick="javascript:window.location='/buengbueng/userInfoFormUpdate.do'" />
	<input type="button" value="메인페이지로"  onclick="javascript:window.location='/buengbueng/index.do'" />
					
</body>