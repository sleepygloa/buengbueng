<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- HEADER TEMPLATE -->
<jsp:include page="../erp_header.jsp" />


<div class="erp_main_title"><p>Admin Dashboard<small> -  최근 통계 및 보고서</small></p></div>
<div class="main_con">
	<div class="box1">
		<div class="box_con ">
			<div class="box_con_top">
			
				<c:if test="${count > 0}">
					<p style="color:#fff;">${totalAmount}<i class="fa fa-krw" aria-hidden="true"></i></p>
				</c:if>
				<c:if test="${count < 1}">
					<p style="color:#fff;">0<i class="fa fa-krw" aria-hidden="true"></i></p>
				</c:if>
			</div>
			<div class="box_con_bottom">
				<p>총 매출 금액</p>
			</div>
			<div class="fafa_icon1"><i class="fa fa-krw" aria-hidden="true"></i></div>
		</div>
	</div>
	
	<div class="box1_5">
		<div class="box_con1_5">
			<div class="box_con_top1_5">
				<c:if test="${count3 > 0}">
					<p style="color:#fff;">${dailyAmount}<i class="fa fa-krw" aria-hidden="true"></i></p>
				</c:if>
				<c:if test="${count3 < 1}">
					<p style="color:#fff;">0 <i class="fa fa-krw" aria-hidden="true"></i></p>
				</c:if>
			</div>
			<div class="box_con_bottom1_5">
				<p>현재 매출 현황</p>
			</div>
			<div class="fafa_icon2"><i class="fa fa-bar-chart" aria-hidden="true"></i></div>
		</div>
	</div>
	
	<div class="box1_6">
		<div class="box_con1_6">
			<div class="box_con_top1_6">
				<c:if test="${count2 > 0}">
					<p style="color:#fff;">${dailyUserCount}명</p>
				</c:if>
				<c:if test="${count2 < 1}">
					<p style="color:#fff;">0명</p>
				</c:if>
			</div>
			<div class="box_con_bottom1_6">
				<p>오늘 PC이용자 수</p>
			</div>
			<div class="fafa_icon3"><i class="fa fa-desktop" aria-hidden="true"></i></div>
		</div>
	</div>
	
	<div class="box1_1">
		<div class="box_con1_1">
			<div class="box_con_top1_1">
				<c:if test="${count3 > 0}">
					<p style="color:#fff;">${dailyUserCount}명</p>
				</c:if>
				<c:if test="${count3 < 1}">
					<p style="color:#fff;">0 <i class="fa fa-krw" aria-hidden="true"></i></p>
				</c:if>
			</div>
			<div class="box_con_bottom1_1">
				<p>가맹점 이용자 수</p>
			</div>
			<div class="fafa_icon4"><i class="fa fa-desktop" aria-hidden="true"></i></div>
		</div>
	</div>
	
	<!--  -->
	
	<div class="box3 co">
		<p>PC이용 현황 리스트 <button class="erp_more_btn">상세보기</button></p>
		<hr>
		<div style="overflow: auto;height:250px; width:99%;">
		<table class="StockList_table">
			<thead>
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>이름</th>
					<th>사용시작 시간</th>
					<th>사용종료 시간</th>
					<th>사용금액</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${count4 < 1}">
					<tr class="noCount">
						<td colspan="6">
							<p>
								<img src="/buengbueng/img/bossERP/bg_alert.gif" width="30" height="30">
								조회결과가 없습니다.
							</p>
						</td>
					</tr>
				</c:if>
				<c:if test="${count4 > 0}">
					<c:forEach items="${articleList}"  var="articleList">
						<tr>
							<td>
								<c:out value="${number}"/>
								<c:set var="number" value="${number-1}"/>
							</td>
							<td>${articleList.userId}</td>
							<td>${articleList.userName}</td>
							<td>${articleList.usageTime}</td>
							<td>${articleList.endTime}</td>
							<td>${articleList.amountUsed}</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		</div>
	</div>
	
	<div class="box3_1">
		<p>정산 리스트 <button class="erp_more_btn">상세보기</button></p>
		<hr>
		<div style="overflow: auto;height:250px; width:99%;">
		<table class="StockList_table">
			<tr>
				<th>번호</th>
				<th>건수</th>
				<th>금액</th>
				<th>현황</th>
			</tr>
			<c:if test="${count5 < 1}">
				<tr class="noCount">
					<td colspan="4">
						<p>
							<img src="/buengbueng/img/bossERP/bg_alert.gif" width="30" height="30">
							조회결과가 없습니다.
						</p>
					</td>
				</tr>
			</c:if>
			<c:if test="${count5 > 0}">
				<c:forEach items="${articleList2}"  var="articleList2">
					<tr>
						<td>
							<c:out value="${number2}"/>
							<c:set var="number2" value="${number2-1}"/>
						</td>
						<td>${articleList2.settlementNumber}</td>
						<td>${articleList2.settlementAmount} &#8361;</td>
						<td>
							<c:if test="${articleList2.resultValue == 3}">
								<div class="bt_2"><span>${articleList2.settlementStatus}</span></div>
							</c:if>
							<c:if test="${articleList2.resultValue == 2}">
								<div class="bt_3"><span>${articleList2.settlementStatus}</span></div>
							</c:if>
							<c:if test="${articleList2.resultValue == 1}">
								<div class="bt_4"><span>${articleList2.settlementStatus}</span></div>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		</div>
	</div>
	
	<div class="box3_2">
		<p>재고 리스트 <button class="erp_more_btn">상세보기</button></p>
		<hr>
		<table class="StockList_table">
			<tr>
				<th>1</th>
				<th>2</th>
				<th>3</th>
				<th>4</th>
			</tr>
			<tr>
				<td>a</td>
				<td>s</td>
				<td>d</td>
				<td>f</td>
			</tr>
		</table>
	</div>
	
	</div>
	