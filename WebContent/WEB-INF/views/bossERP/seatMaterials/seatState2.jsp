<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="usePcCount" value="0" />
<div class="pcBox">
	<c:if test="${count != 0}">
		<c:forEach begin="1" end="${count}" var="pcNum" step="1">
			<c:if test="${seatCon[pcNum-1] == '0'}">
				<div class="seatDisposeSecondDiv">
					&emsp;${pcNum}
					<c:if test="${pcState[pcNum-1] eq '고장'}">
						&nbsp;<b style="color: red;">고장</b>
					</c:if>
				</div>
			</c:if>
			<c:if test="${seatCon[pcNum-1] == '1'}">
				<div class="seatDisposeSecondDiv2" onclick="getUserInfo('${pcNum}','${useSeatId.get(currentPcCount)}');">
					<c:set var="currentPcCount" value="0" />
					&emsp;${pcNum}
					<c:forEach var="num" items="${useSeatNum}">
						<c:if test="${num == (pcNum)}">
							&emsp;${useSeatId.get(currentPcCount)}님<br/>
							<c:set var="usePcCount" value="${usePcCount+1}" />
						</c:if>
						<c:if test="${num != (pcNum)}">
							<c:set var="currentPcCount" value="${currentPcCount+1}" />
						</c:if>
					</c:forEach>
				</div>
			</c:if>
		</c:forEach>
	</c:if>
	<c:if test="${count == 0}">
		좌석 정보를 먼저 추가하십시오.
	</c:if>
</div>
<h2>${usePcCount}/${count}</h2><hr>