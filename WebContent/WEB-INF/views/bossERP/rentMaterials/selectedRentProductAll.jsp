<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/buengbueng/css/bossERP/applyForSettlement.css">
<c:if test="${rentPList.size() != 0}">
	<table border="1" class="dailySettlementList_table">
    	<tr>
			<th>체크</th><th>바코드 번호</th><th>대여 유무</th><th>최초 등록일</th><th>수정</th>
		</tr>
		<c:forEach var="rentPList" items="${rentPList}">
			<tr>
				<td><input type="checkbox" name="rentCode" value="${rentPList.code}" /></td>
				<td>${rentPList.code}</td>
				<c:if test="${rentPList.rentCheck == 0}">	
					<td>대여 가능</td>
				</c:if>
				<c:if test="${rentPList.rentCheck == 1}">	
					<td>대여 중</td>
				</c:if>
				<td>${rentPList.beginRegist}<input type="hidden" value="${b_key}" name="b_key"/></td>
				<td><div class="bt_3"><a onclick="modiRentProduct('${rentPList.code}','${b_key}');">수정</a></div></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<c:if test="${rentPList.size() == 0}">
	<table border="1" class="dailySettlementList_table">
		<tr class="dailySettlementList_NoCount">
			<td colspan="9">
				<p>
				<img src="/buengbueng/img/bossERP/bg_alert.gif" width="40" height="40">
					조회결과가 없습니다.
				</p>
			</td>
		</tr>
	</table>
</c:if>