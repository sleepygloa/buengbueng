<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
	<link rel="stylesheet" type="text/css" href="/buengbueng/css/bossERP/seatDispose.css" />
</head>

<div id="seatDisposeFirstDiv">
	<c:if test="${count != 0}">
		<c:set var="usePcCount" value="0" />
		<c:forEach begin="1" end="${count}" var="pcNum" step="1">
			<c:if test="${seatCon[pcNum-1] == '0'}">
				<div class="seatDisposeSecondDiv" onclick="showPcInfo('${pcNum}')">
					&emsp;${pcNum}
				</div>
			</c:if>
			<c:if test="${seatCon[pcNum-1] == '1'}">
				<div class="seatDisposeSecondDiv2" onclick="showPcInfo('${pcNum}')">
					&emsp;${pcNum}
				</div>
				<c:set var="usePcCount" value="${usePcCount+1}" />
			</c:if>
		</c:forEach>
		<br/>
	</c:if>
</div>
<h2>${usePcCount}/${count}</h2><hr>