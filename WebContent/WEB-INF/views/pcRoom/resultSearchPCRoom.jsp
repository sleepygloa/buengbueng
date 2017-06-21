<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<br/>
<c:forEach var="fInfo" items="${franchiseeInfo}">
	<b onclick="pcRoomInfo('${fInfo.b_name}','${fInfo.b_id}');">${fInfo.b_name}</b> &emsp;&emsp;
</c:forEach>