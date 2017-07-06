<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${check==0}">
	<script>
		alert('일치하는 기록이 없습니다.');
		history.go(0);
	</script>
</c:if>
<c:if test="${check==1 }">
	<script>
		alert('아이디 복구 완료.');
		history.go(0);
	</script>
</c:if>