<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<c:forEach var="list" items="${list}">
	${list.num}&nbsp;&nbsp;${list.title}<br />
	</c:forEach>
</div>