<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="/buengbueng/js/bossERP/rentManage.js"></script>

<c:if test="${check == 1}">
	<body onload="gotoURL2('rentManage.do','b_key','${b_key}','page','rentManage2')"/>
</c:if>

<c:if test="${check == 0}">
	<body onload="gotoAlert('이미 등록되어있습니다.');"/>
</c:if>