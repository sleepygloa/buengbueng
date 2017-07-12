<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"  href="/buengbueng/css/bossERP/applyForSettlement.css">
		<title>가맹점 PC이용 현황</title>
	</head>
	
	<jsp:include page="../../erp_header.jsp" />
	
	<body>
		<div class="ERP_Navigator">
			<ul>
				<li>ERP 관리</li>
				<li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
				<li>일일정산</li>
				<li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
				<li>가맹점 PC이용 현황</li>
			</ul>
		</div>
		<div class="boss_con">
			<p>가맹점 PC이용 현황</p>
			<hr>
			<table border="1" class="dailySettlementList_table">
				<tr>
					<th>번호</th>
					<th>가맹점</th>
					<th>아이디</th>
					<th>이름</th>
					<th>사용시작 시간</th>
					<th>사용종료 시간</th>
					<th>총 사용 금액</th>
					<th>PC이용 금액</th>
					<th>상품주문 금액</th>
					<th>주문상품 상세보기</th>
				</tr>
				<c:if test="${count < 1}">
					<tr class="dailySettlementList_NoCount">
						<td colspan="10">
							<p>
							<img src="/buengbueng/img/bossERP/bg_alert.gif" width="40" height="40">
								조회결과가 없습니다.
							</p>
						</td>
					</tr>
				</c:if>
				<c:if test="${count > 0}">
				<c:forEach items="${articleList}" var="articleList">
					<tr>
						<td>
							<c:out value="${number}"/>
							<c:set var="number" value="${number-1}"/>
						</td>
						<td>${articleList.businessName}</td>
						<td>${articleList.userId}</td>
						<td>${articleList.userName}</td>	
						<td>${articleList.usageTime}</td>
						<td>${articleList.endTime}</td>
						<td>${articleList.amountUsed}</td>
						<td>${articleList.pcAmount}</td>
						<td>${articleList.menuAmount}</td>
						<td><div class="bt_1"><a href="#" onclick="window.open('http://localhost:8080/buengbueng/userviewDetails.do', '_blank', 'width=550 height=500')" >상세보기</a></td>
					</tr>
				</c:forEach>
				</c:if>
			</table>
			<div class="paging_con">
				<div class="paging_con_box">
				    <c:if test="${count > 0}">
			        <c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}"/>
			        <c:set var="pageBlock" value="${10}"/>
			        <fmt:parseNumber var="result" value="${currentPage / 10}" integerOnly="true" />
			        <c:set var="startPage" value="${result * 10 + 1}" />
			        <c:set var="endPage" value="${startPage + pageBlock-1}"/>
			        <c:if test="${endPage > pageCount}">
			            <c:set var="endPage" value="${pageCount}"/>
			   		</c:if> 
			          
			   		<c:if test="${startPage > 10}">
			   			<div class="paging_part">
			        		<a class="pageing-ing" href="/buengbueng/pcUseStatusList.do?pageNum=${startPage - 10 }">[이전]</a>
			        	</div>
			   		</c:if>
			
			   		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			   			<div class="paging_part">
			       			<a class="pageing-ing" href="/buengbueng/pcUseStatusList.do?pageNum=${i}">${i}</a>
			       		</div>
			   		</c:forEach>
			
			   		<c:if test="${endPage < pageCount}">
			        	<div class="paging_part">
			        		<a class="pageing-ing" href="/buengbueng/pcUseStatusList.do?pageNum=${startPage + 10}"><i class="fa fa-angle-right" aria-hidden="true"></i></a>
			        	</div>
			   		</c:if>
					</c:if>
				</div>
			</div>
		</div>
		
	</body>
	<jsp:include page="../../footer.jsp" />
</html>
