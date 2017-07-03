<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- HEADER TEMPLATE -->
<jsp:include page="../../header.jsp" />

<style>
div{
border:1px solid #f4f4f4;

}
</style>

	<!-- 페이지 제목 -->
	<div class=" margin_bottom50">
		<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
			<h3>ERP 알바생 관리</h3>
		</div>
	</div>

<!--  -->
<div class="row">
	<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
		<div class="col-xs-2-12">아이디</div>
		<div class="col-xs-2-12">출근계획시간</div>
		<div class="col-xs-2-12">퇴근계획시간</div>
		<div class="col-xs-2-12">출근한시간</div>
		<div class="col-xs-2-12">퇴근한시간</div>
		<div class="col-xs-2-12">상태</div>
	</div>
		<c:forEach var="list" items="${list}">
		<div class="row">
			<div class="col-xs-12-12 col-sm-12-12">
				<div class="col-xs-2-12">${list.title}</div>
				<div class="col-xs-2-12">${list.start}</div>
				<div class="col-xs-2-12">${list.end}</div>
				<div class="col-xs-2-12">
					<c:if test="${list.commuteTime == null}">
						
					</c:if>
					<c:if test="${list.commuteTime != null}">
						${list.commuteTime}
					</c:if>					
				</div>
				<div class="col-xs-2-12">
					<c:if test="${list.ex == null}">
						
					</c:if>
					<c:if test="${list.ex != null}">
						${list.ex}
					</c:if>		
				</div>
				<div class="col-xs-2-12">
					<c:if test="${list.result == 0}">
						출근준비중
					</c:if>
					<c:if test="${list.result == 1}">
						근무중
					</c:if>						
					<c:if test="${list.result == 2}">
						퇴근
					</c:if>					
				</div>
			</div>
		</div>
		
		 </c:forEach>	
 </div>