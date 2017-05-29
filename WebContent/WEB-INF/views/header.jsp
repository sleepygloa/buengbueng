<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
	
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<!-- CSS RESET -->
		<link rel="stylesheet" type="text/css"  href="/buengbueng/css/reset.css">
	
	</head>
 
 
 	<body>
	 	<!-- LOGIN SECTION -->
		<div>
			<ul> 
			<!-- 로그인상태와 로그아웃상태일때 환영메세지, 관리자 일때 관리자페이지 링크가 보이게 한다. -->
				<c:if test="${sessionScope.loginId != null}" >
					<li>${sessionScope.loginId}님 환영합니다!!</li>
					<li><a href="/buengbueng/userInfoForm.do">회원 정보보기</a></li>
					<li><a href="/buengbueng/userInfoFormUpdate.do">회원 정보수정</a></li>
				</c:if>
				<c:if test="${sessionScope.loginId == null}" >
					<li><a href="/buengbueng/loginForm.do">로그인</a></li>
					<li><a href="/buengbueng/userInfoSignForm.do">회원가입</a></li>
					<li><a href="">비밀번호찾기</a></li>
				</c:if>
				<c:if test="" >
					<li>관리자페이지</li>
				</c:if>
			</ul>
		</div>
		
	<!-- NAV SECTION -->
		<!-- BIG NAV : 대 제목 : 메인 NAV : 메인 메뉴 -->
		<div>
			<ul>
				<li>회사소개</li>
				<li>사용자 PC방 이용</li>
				<li>사장님 PC방 관리</li>
				<li>관리자 PC방 관리</li>
				<li>고객센터</li>
			</ul>
		</div>

		<!-- SMALL NAV : 소 제목 : 작은 NAV : 드롭다운 메뉴 : DROPDOWN MENU -->
		<div>
			<!-- 회사소개 메뉴 -->
			<ul>
				<li>가맹점 찾기</li>
				<li>프로그램 기능 소개</li>
			</ul>
			<!-- 사용자 메뉴 : 사용자 NAV : 사용자 MENU -->
			<ul>
				<li>PC방 찾기</li>
				<li>결제</li>
				<li>예약</li>
				<li>이용현황</li>
				<li>즐겨찾는 PC방</li>
			</ul>
			<!-- 사장님 메뉴 : 사장님 NAV : 사장님 MENU -->
			<ul>
				<li>원격 조종</li>
				<li>ERP 관리</li>
			</ul>
			<!-- 관리자 메뉴 : 관리자 NAV : 관리자 MENU-->
			<ul>
				<li>챗봇 관리</li>
				<li>회원 관리</li>
				<li>ERP 관리</li>
				<li>페이지 관리(모듈)</li>
			</ul>
		</div>
	
		