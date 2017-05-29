<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- HEADER TEMPLATE -->
<jsp:include page="header.jsp" />

<!-- ARTICLE -->
<article>
	
	<!-- 페이지 소개 -->
	<h2>buengbueng Main Page</h2>
	
	<!-- SIDENAV -->
	<div>
	
	</div>
	

	
	<!-- CONTENT SECTION -->
	<div>
	
	<!-- TEMPLATE 영역  -->
	<!-- INDEX 는 변수 없이, 각 NAV 메인페이지는 기본 변수를 받아서 INDEX페이지에서 불러올 수 있도록 한다. -->
	<!-- 각 MAIN페이지에는 내용만 있고, 주변의 틀은 INDEX의 틀을 따라간다. -->
 	
	<c:if test="${indexV == null}"><!-- 메인페이지 영역 -->
		<jsp:include page="main.jsp" />
	</c:if>
	<c:if test=""><!-- 회사소개 영역 -->

	</c:if>
	<c:if test="${indexV == '사용자가메뉴에접근'}"><!-- 사용자PC사용 영역 -->
		<c:import url="userpcuse/main.jsp" />
	</c:if>
	<c:if test=""><!-- 사장님PC사용 영역 -->
	</c:if>
	<c:if test=""><!-- 관리자PC사용 영역 -->
	</c:if>
	 
	
	
	
	
	
	
	
	</div>
	
	
	
</article>

<!-- FOOTER TEMPLATE -->
<jsp:include page="footer.jsp" />