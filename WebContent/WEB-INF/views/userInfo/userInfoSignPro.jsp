<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
	<script type="text/javascript" src="/buengbueng/js/userInfo/signForm.js"></script>
</head>

<%-- 회원 가입이 성공적으로 완료됐으면 메인 페이지로 이동 --%>
<c:if test="${result == 'succ'}">
	<c:redirect url="/index.do" />
</c:if>

<%-- 회원 가입이 실패했으면 알림창 띄운 후 회원 가입 페이지로 돌아감 --%>
<c:if test="${result == 'fail'}">
	<body onload="historyGo();"/>
</c:if>

<%-- 알바가 입력한 사장아이디가 없을 경우 알림창을 띄운 후 회원 가입 페이지로 돌아감 --%>
<c:if test="${bossCheck=='fail'}">
	<body onload="bossNoCheck();"/>
</c:if>