<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- HEADER TEMPLATE -->
<jsp:include page="../header.jsp" />

	<!-- 페이지 제목 -->
	<div class=" margin_bottom50">
		<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
			<h3>ERP 알바생 관리</h3>
		</div>
	</div>

<!--  -->
<div class="row">
	<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
	
	<div class="row">
		<div class="col-xs-12-12 col-sm-12-12">
				<div class="col-xs-4-12 col-sm-2-12 ">아이디</div>
				<div class="col-xs-4-12 col-sm-2-12 ">시작시간</div>
				<div class="xs_hidden col-sm-2-12 ">종료시간</div>
				<div class="xs_hidden col-sm-2-12 ">30분단위 계산</div>
				<div class="xs_hidden col-sm-2-12 ">접속 IP</div>
				<div class="col-xs-4-12 col-sm-2-12 ">상황</div>
		</div>
	</div>
		<c:forEach var="article" items="${articleList}">
		<div class="row">
			<div class="col-xs-12-12 col-sm-12-12">
				<div class="col-xs-4-12 col-sm-2-12 ">${article.id}</div>
				<div class="col-xs-4-12 col-sm-2-12 ">${article.loginTime}</div>
				<div class="xs_hidden col-sm-2-12 ">${article.logoutTime}</div>
				<div class="xs_hidden col-sm-2-12 "></div>
				<div class="xs_hidden col-sm-2-12 ">${article.ip}</div>
				<div class="col-xs-4-12 col-sm-2-12 ">
					<c:if test="${article.logoutTime == article.loginTime}">
					알바중.
					</c:if>
					<c:if test="${article.logoutTime != article.loginTime}">
					퇴근함.
					</c:if>
				</div>
			</div>
		</div>
		
		 </c:forEach>	

	
	</div>
</div>