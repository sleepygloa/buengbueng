<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- HEADER TEMPLATE -->
<jsp:include page="../../erp_header.jsp" />

<style>
[class*=col-]{margin-bottom:5px} /* 모든 클래스들 중 col- 로 시작하는 것들을 정의, grid간 아랫공간 띄우기*/
.contentBox > div {padding:0 auto;}
#plan{
border-style:none;
width:80%;
background-color:#9B9B9B;
color:#fff;
font-weight:700;
}
#commute{
border-style:none;
width:80%;
background-color:#32518F;
color:#fff;
font-weight:700;
}
#workOff{
border-style:none;
width:80%;
background-color:#B23636;
color:#fff;
font-weight:700;
}
</style>

<div class="main_ad" style="background-color:#EEF1F2;height:100%;">
	<div class="main_ad_content">
		<div class="col-xs-10-10 main_ad_contentBox">
	
				<div class="col-xs-10-10 col-sm-10-10 col-md-10-10  col_height90 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a"><a href="#">ERP 알바생 관리</a></div>
					</div>
				</div>

				<div class="col-xs-10-10 col-sm-10-10 col-md-10-10  contentBox_outline">
					<div class="contentBox col_height0">
						
	<div class="col-xs-12-12 col_height50">
		<div class="col-xs-3-12 col-sm-2-12">아이디</div>
		<div class="col-xs-3-12 col-sm-2-12">출근계획시간</div>
		<div class="col-xs-3-12 col-sm-2-12">퇴근계획시간</div>
		<div class="col-sm-2-12 xs_hidden">출근한시간</div>
		<div class="col-sm-2-12 xs_hidden">퇴근한시간</div>
		<div class="col-xs-3-12 col-sm-2-12">상태</div>
	</div>

		<c:forEach var="list" items="${list}">
			<div class="col-xs-12-12">
				<div class="col-xs-3-12 col-sm-2-12">${list.title}</div>
				<div class="col-xs-3-12 col-sm-2-12">${list.start}</div>
				<div class="col-xs-3-12 col-sm-2-12">${list.end}</div>
				<div class="col-sm-2-12 xs_hidden">
					<c:if test="${list.commuteTime == null}">
						
					</c:if>
					<c:if test="${list.commuteTime != null}">
						${list.commuteTime}
					</c:if>					
				</div>
				<div class="col-sm-2-12 xs_hidden">
					<c:if test="${list.ex == null}">
						
					</c:if>
					<c:if test="${list.ex != null}">
						${list.ex}
					</c:if>		
				</div>
				<div class="col-xs-3-12 col-sm-2-12">
					<c:if test="${list.result == 0}">
						<button id="plan">계획</button>
					</c:if>
					<c:if test="${list.result == 1}">
						<button id="commute">근무중</button>
					</c:if>						
					<c:if test="${list.result == 2}">
						<button id="workOff">퇴근</button>
					</c:if>					
				</div>
			</div>
		
		 </c:forEach>	
 		</div>
 	</div>
 </div>