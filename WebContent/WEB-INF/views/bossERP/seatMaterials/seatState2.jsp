<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${count != 0}">
	<c:set var="usePcCount" value="0" />
	<c:forEach begin="1" end="${count}" var="pcNum" step="1">
		<c:if test="${seatCon[pcNum-1] == '0'}">
			<div id="seatDisposeSecondDiv">
				&nbsp;${pcNum}
				<c:if test="${pcState[pcNum-1] eq '고장'}">
					&nbsp;<b style="color: red;">고장</b>
				</c:if>
			</div>
		</c:if>
		<c:if test="${seatCon[pcNum-1] == '1'}">
				<div id="seatDisposeSecondDiv2" onclick="getUserInfo('${pcNum}','${useSeatId.get(usePcCount)}');">
				<c:set var="usePcCount" value="0" />
				&nbsp;${pcNum}<br/>
				<c:forEach var="num" items="${useSeatNum}">
					<c:if test="${num == (pcNum)}">
						${useSeatId.get(usePcCount)}님<br/>
					</c:if>
					<c:if test="${num != (pcNum)}">
						<c:set var="usePcCount" value="${usePcCount+1}" />
					</c:if>
				</c:forEach>
			</div>
		</c:if>
	</c:forEach>
	<br/>
	<p>${usePcCount}/${count}</p>
</c:if>
<c:if test="${count == 0}">
	좌석 정보를 먼저 추가하십시오.
</c:if>