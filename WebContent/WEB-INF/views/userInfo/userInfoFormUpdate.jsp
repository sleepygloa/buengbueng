<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>회원 정보</title>
		<link rel="stylesheet" type="text/css" media="all" href="css/userInfo/userInfoForm.css">
	</head>
	<jsp:include page="../header.jsp" />
	<body>
		<div class="mypage_title_box">
			<span>기본정보 수정</span>
		</div>
		
		<form action="userInfoFormUpdatePro.do" method="post">
		<!-- IP : BEAN 에서 IP 정보를 생성 및 전달 -->
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
					<th class="userInfoTable_left_tr"><span>패스워드</span></th>
					<td class="userInfoTable_right_tr">
						<input type="password" name="pw" value="${user.pw}" />
					</td>
				</tr>
				<tr>
					<th class="userInfoTable_left_tr"><span>전화 번호</span></th>
					<td class="userInfoTable_right_tr">
					<input type="text" name="phone" value="${user.phone}" />
						<span>쿠폰, 이벤트 정보 등을 제공 받으실 수 있습니다.</span>
					</td>
				</tr>
				<tr>
					<th class="userInfoTable_left_tr"><span>주소</span></th>
					<td class="userInfoTable_right_tr">
						<input type="text" name="address" value="${user.address}" />
					</td>
				</tr>
				<tr>
					<th class="userInfoTable_left_tr"><span>이메일</span></th>
					<td class="userInfoTable_right_tr">
						<input type="text" name="email" value="${user.email}" />
					</td>
				</tr>
			</table>
			<div class="userInfo_update_btnBox">
				<input class="update_cancel_btn" type="button" value="취소" onclick="window.location='index.do'" />
				<input class="update_success_btn" type="submit" value="수정" />
			</div>
		</form>
	</body>
</html>