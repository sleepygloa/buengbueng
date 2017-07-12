<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"  href="/buengbueng/css/bossERP/applyForSettlement.css">
		<title>Insert title here</title>	
		<script type="text/javascript">
			var check = ${checkPoint};
				function acpet() {
					if(check == 1){
						alert('정산요청이 정상적으로 완료되었습니다.');
					}else if(check == 2){
						alert('이미 정산요청이 처리 되었습니다.');
						return false;
					}else if(check == 3){
						alert('정산요청 할 내역이 존재하지 않습니다.');
						return false;
					}
				}
		</script>
	</head>
	<!-- HEADER TEMPLATE -->
	<jsp:include page="../../erp_header.jsp" />
	
	<!-- 가맹점 선택하지 않는 경우 -->
	
	
	<body >
		<!-- 가맹점 선택하지 않는 경우 -->
		<c:if test="${affiliateCodeList == null }">
			가맹지점을 선택하여 주세요.
		</c:if>
		<c:if test="${affiliateCodeList != null }">
		
		<div class="ERP_Navigator">
			<ul>
				<li>ERP 관리</li>
				<li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
				<li>일일정산</li>
				<li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
				<li>일일정산 요청</li>
			</ul>
		</div>
			
		<div class="boss_con">
			<p>일일정산 요청</p>
			<hr>
			<table border="1" class="dailySettlementList_table">
				<tr>
					<th>번호</th>
					<th>사용자 아이디</th>
					<th>사용자 이름</th>
					<th>가맹점 이름</th>
					<th>사용시작 시간</th>
					<th>사용종료 시간</th>
					<th>사용 금액</th>
					<th>기타</th>
				</tr>
				<c:if test="${dailyCount < 1}">
					<tr class="dailySettlementList_NoCount">
						<td colspan="9">
							<p>
							<img src="/buengbueng/img/bossERP/bg_alert.gif" width="40" height="40">
								조회결과가 없습니다.
							</p>
						</td>
					</tr>
				</c:if>
				<c:if test="${dailyCount > 0}">
				<c:forEach items="${articleList}" var="articleList">
					<tr>
						<td>
							<c:out value="${number}"/>
							<c:set var="number" value="${number-1}"/>
						</td>
						<td>${articleList.userId}</td>
						<td>${articleList.userName}</td>
						<td>${articleList.businessName}</td>
						<td>${articleList.usageTime}</td>
						<td>${articleList.endTime}</td>
						<td>${articleList.amountUsed}</td>
						<td>${articleList.etc}</td>
					</tr>
				</c:forEach>
				</c:if>
			</table>
			<div class="paging_con">
				<div class="paging_con_box">
				    <c:if test="${dailyCount > 0}">
			        <c:set var="pageCount" value="${dailyCount / pageSize + ( count % pageSize == 0 ? 0 : 1)}"/>
			        <c:set var="pageBlock" value="${10}"/>
			        <fmt:parseNumber var="result" value="${currentPage / 10}" integerOnly="true" />
			        <c:set var="startPage" value="${result * 10 + 1}" />
			        <c:set var="endPage" value="${startPage + pageBlock-1}"/>
			        <c:if test="${endPage > pageCount}">
			            <c:set var="endPage" value="${pageCount}"/>
			   		</c:if> 
			          
			   		<c:if test="${startPage > 10}">
			        		<a href="/buengbueng/applyForSettlement.do?pageNum=${startPage - 10 }">[이전]</a>
			   		</c:if>
			
			   		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			   			<div class="paging_part">
			       		<a class="pageing-ing" href="/buengbueng/applyForSettlement.do?pageNum=${i}">${i}</a>
			       		</div>
			   		</c:forEach>
			
			   		<c:if test="${endPage < pageCount}">
			        	<a href="/buengbueng/applyForSettlement.do?pageNum=${startPage + 10}">[다음]</a>
			   		</c:if>
					</c:if>
				</div>
			</div>
		
			
				<form action="applyForSettlementPro.do" method="post">
					<input type="hidden" name="bossId" value="${id}">
					<input type="hidden" name="companyName" value="루루루루루루">
					<input type="hidden" name="settlementMethod" value="Day+1">
					<input type="hidden" name="settlementNumber" value="${dailyCount}">
					<input type="hidden" name="requestedAccount" value="110-313-991874">
					<input type="hidden" name="settlementAmount" value="${dailyPureAmount}">
					<input type="hidden" name="settlementStatus" value="정산 요청">
					<input type="hidden" name="resultValue" value="2">
					<input type="hidden" name="b_key" value="${affiliateCodeList}">
					<input type="hidden" name="affiliateCodeList" id="affiliateCodeList" value="${affiliateCodeList}">
					<input class="applyForSettlement_button" type="submit" value="정산하기" onclick="return acpet();">
				</form>
			</div>
		</c:if>
	</body>
</html>
