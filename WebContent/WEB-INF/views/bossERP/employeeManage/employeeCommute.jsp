<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- HEADER TEMPLATE -->
<jsp:include page="../../erp_header.jsp" />

<style>
.bg-gray{
background-color:#555555;
color:#fff;
font-weight:600;
font-size:2em;
text-align:center;
height:30%;
padding:50 0 50 0;
}
.strong{
color:#8b0000;
}
</style>

<div class="main_ad" style="background-color:#EEF1F2;height:100%;">
	<div class="main_ad_content">
		<div class="col-xs-10-10 main_ad_contentBox">

			 출퇴근시에만 보이는 페이지입니다. <a href="/buengbueng/index.do">메인으로</a>
			 
			 <div class="col-xs-12-12">
			 	<div class="bg-gray">
			 	<c:if test="${checkCommute == 1}">
			 		<h2>${sessionScope.loginId} 님!</h2>
			 		${commuteTime}에 <br />
			 		 <c:if test="${check == -1}"><span class="strong">이미</span></c:if>출근 하였습니다.
			 	</c:if>
			 	<c:if test="${checkCommute == 2}">
			 		<h2>${sessionScope.loginId} 님!</h2>
			 		${commuteTime}에 <br />
			 		 <c:if test="${check == -1}"><span class="strong">이미</span></c:if>퇴근 하였습니다.
			 	</c:if>
			 	</div>
			 </div>
 
 		`</div>
 	</div>
 </div>