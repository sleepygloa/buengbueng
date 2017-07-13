<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- HEADER TEMPLATE -->
<jsp:include page="../../erp_header.jsp" />
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css"  href="/buengbueng/css/bossERP/applyForSettlement.css">
	<link rel="stylesheet" type="text/css"  href="/buengbueng/css/erp.css">
	<title>Insert title here</title>
</head>
<style>
[class*=col-]{margin-bottom:5px} /* 모든 클래스들 중 col- 로 시작하는 것들을 정의, grid간 아랫공간 띄우기*/
.contentBox > div {padding:0 auto;}
/* #plan{
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
} */
</style>
<div class="ERP_Navigator ">
	<ul>
		<li>ERP 관리</li>
		<li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
		<li>일일정산</li>
		<li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
		<li>일일정산 내역</li>
	</ul>
</div>

<div class="boss_con table-responsive ">
	<p>출ㆍ퇴근 기록 리스트</p>
	<hr>
	<table class="LeavingWork">
		<tr>	
			<th>아이디</th>
			<th>출근계획시간</th>
			<th>퇴근계획시간</th>
			<th>출근한시간</th>
			<th>퇴근한시간</th>
			<th>상태</th>
		</tr>
		
		<c:forEach var="list" items="${list}">
		<tr>
			<td>${list.title}</td>
			<td>${list.start}</td>
			<td>${list.end}</td>
			<td>
				<c:if test="${list.commuteTime == null}">
					ㆍ
				</c:if>
				<c:if test="${list.commuteTime != null}">
					${list.commuteTime}
				</c:if>	
			</td>
			<td>
				<c:if test="${list.ex == null}">
					ㆍ
				</c:if>
				<c:if test="${list.ex != null}">
					${list.ex}
				</c:if>	
			</td>
			<td>
				<c:if test="${list.result == 0}">
					<button class="employeeWorkTimeList_btn1" id="plan">계획</button>
				</c:if>
				<c:if test="${list.result == 1}">
					<button class="employeeWorkTimeList_btn2" id="commute">근무중</button>
				</c:if>						
				<c:if test="${list.result == 2}">
					<button class="employeeWorkTimeList_btn3" id="workOff">퇴근</button>
				</c:if>		
			</td>
		</tr>
		</c:forEach>
	</table>
</div>




<%-- 

<div class="main_ad" style="background-color:#EEF1F2;height:100%;">
	<div class="main_ad_content">
		<div class="col-xs-10-10 main_ad_contentBox">
	
				<div class="col-xs-10-10 col-sm-10-10 col-md-10-10  col_height90 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a"><a href="#">출ㆍ퇴근 기록 리스트</a></div>
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
					<c:if test="${list.commuteTime == '1970-01-01 00:00:00.0'}">
						
					</c:if>
					<c:if test="${list.commuteTime != '1970-01-01 00:00:00.0'}">
						${list.commuteTime}
					</c:if>					
				</div>
				<div class="col-sm-2-12 xs_hidden">
					<c:if test="${list.ex == '1970-01-01 00:00:00.0'}">
						
					</c:if>
					<c:if test="${list.ex != '1970-01-01 00:00:00.0'}">
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
 </div> --%>