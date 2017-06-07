<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach begin="1" end="${count}" var="pcNum" step="1">
	<c:if test="${seatCon[pcNum-1] == '0'}">
		<div class="seatDisposeSecondDiv">
			<input type="checkBox" value="${pcNum}" name="checkPC"/>${pcNum}
		</div>
	</c:if>
	<c:if test="${seatCon[pcNum-1] == '1'}">
		<div class="seatDisposeSecondDiv2">
			<input type="checkBox" value="${pcNum}" name="checkPC"/>${pcNum}
		</div>
	</c:if>
</c:forEach>
