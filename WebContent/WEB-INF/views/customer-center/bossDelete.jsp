<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
alert('삭제 되었습니다.');
</script>
<c:if test="${check==1}">
	<head>
	<meta http-equiv="Refresh" content="0;url=${addr}.do?snum=${snum}&pageNum=1" >
	</head>
</c:if>
<c:if test="${check==0}">
	<head>
	<c:if test="${snum==0}">
		<meta http-equiv="Refresh" content="0;url=${addr}.do?pageNum=1" >
	</c:if>
	<c:if test="${snum!=0}">
		<meta http-equiv="Refresh" content="0;url=${addr}.do?snum=${snum}&pageNum=1" >
	</c:if>		
	</head>
</c:if>