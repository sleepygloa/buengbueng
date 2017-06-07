<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach begin="1" end="${count}" var="pcNum" step="1">
	<div class="seatDisposeSecondDiv">
		<input type="checkBox" value="${pcNum}" name="checkPC"/>${pcNum}
		<br><input type="button" value="정보 보기" onclick="showModiPcInfo('${pcNum}','0')"/><br/>
		<br><input type="button" value="정보 수정" onclick="showModiPcInfo('${pcNum}','1')"/>
	</div>
</c:forEach>