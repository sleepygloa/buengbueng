<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${franchiseeInfo.size() != 0}">
	<br/>
	<c:forEach var="fInfo" items="${franchiseeInfo}">
		<b onclick="pcRoomInfo('${fInfo.b_name}','${fInfo.b_id}');">${fInfo.b_name}</b> &emsp;&emsp;
	</c:forEach>
</c:if>

<c:if test="${franchiseeInfo.size() == 0}">
	<div class="marginTop">
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
	</div>
</c:if>