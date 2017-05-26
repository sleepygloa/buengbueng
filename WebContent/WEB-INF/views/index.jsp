<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- HEADER TEMPLATE -->
<jsp:include page="header.jsp" />

<!-- ARTICLE -->
<article>
	
	<!-- 페이지 소개 -->
	<h2>buengbueng Main Page</h2>
	
	<!-- LOGIN SECTION -->
	<div>
		<ul> 
		<!-- 로그인상태와 로그아웃상태일때 환영메세지, 관리자 일때 관리자페이지 링크가 보이게 한다. -->
			<c:if test="" >
				<li> 님 환영합니다!!</li>
			</c:if>
			<li><a href="">로그인</a></li>
			<li><a href="">회원가입</a></li>
			<li><a href="">비밀번호찾기</a></li>
			<c:if test="" >
				<li>관리자페이지</li>
			</c:if>
		</ul>
	</div>
	
	<!-- NAV SECTION -->
	<div></div>
	
	<!-- CONTENT SECTION -->
	<div></div>
	
	
	
</article>

<!-- FOOTER TEMPLATE -->
<jsp:include page="footer.jsp" />