<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="/buengbueng/js/bossERP/rentManage.js"></script>

<c:if test="${check == 1}">
	<c:redirect url="rentManage.do" />
</c:if>

<c:if test="${check == 0}">
	<body onload="gotoAlert('이미 등록되어있습니다.');"/>
</c:if>