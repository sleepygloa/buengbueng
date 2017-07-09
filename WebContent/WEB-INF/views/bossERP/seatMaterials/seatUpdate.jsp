<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach begin="1" end="${count}" var="pcNum" step="1">
	<div class="seatDisposeSecondDiv" onclick="showModiPcInfo('${pcNum}')">
		&emsp;<input type="checkBox" value="${pcNum}" name="checkPC"/>&nbsp;&nbsp;${pcNum}
	</div>
</c:forEach>