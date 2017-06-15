<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<link rel="stylesheet" type="text/css" media="all" href="css/userInfo/userInfoForm.css">
		<title>회원 정보 수정</title>
	</head>
	<jsp:include page="../header.jsp" />
	<body>
		
		<div class="mypage_title_box">
			<span>기본정보</span>
			<button class="delete_submit" onclick="javascript:window.location='/buengbueng/userInfoDeleteForm.do'">회원탈퇴</button>
			<button class="modify_submit" onclick="javascript:window.location='/buengbueng/userInfoFormUpdate.do'">회원정보 수정</button>
		</div>
		<table border="1" class="userInfoTable">
			<tr>
				<th class="userInfoTable_left_tr"><span>아이디</span></th>
				<td class="userInfoTable_right_tr">${user.id}</td>
			</tr>
			<tr>
				<th class="userInfoTable_left_tr"><span>이름</span></th>
				<td class="userInfoTable_right_tr">${user.name}</td>
			</tr>
			<tr>
				<th class="userInfoTable_left_tr"><span>생년월일</span></th>
				<td class="userInfoTable_right_tr">${user.birth}</td>
			</tr>
			<tr>
				<th class="userInfoTable_left_tr"><span>전화 번호</span></th>
				<td class="userInfoTable_right_tr">
					<p>${user.phone}</p>
					<span>쿠폰, 이벤트 정보 등을 제공 받으실 수 있습니다.</span>
				</td>
			</tr>
			<tr>
				<th class="userInfoTable_left_tr"><span>등급</span></th>
				<td class="userInfoTable_right_tr">${user.grade}</td>
			</tr>
			<tr>
				<th class="userInfoTable_left_tr"><span>주소</span></th>
				<td class="userInfoTable_right_tr">${user.address}</td>
			</tr>
			<tr>
				<th class="userInfoTable_left_tr"><span>이메일</span></th>
				<td class="userInfoTable_right_tr">${user.email}</td>
			</tr>
		</table>
		<div class="mypage_btn_box">
			<button class="mypage_btn" onclick="javascript:window.location='/buengbueng/index.do'">메인페이지</button>
		</div>				
	</body>
	<jsp:include page="../footer.jsp" />
</html>
