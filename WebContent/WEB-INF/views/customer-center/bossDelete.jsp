<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${check==1}">
<script>
	alert('삭제 되었습니다.');
</script>
	<head>
	<meta http-equiv="Refresh" content="0;url=${addr}.do?snum=${snum}&pageNum=1" >
	</head>
</c:if>
<c:if test="${check==0}">
	<script>
		opener.document.location.reload();
		alert('삭제 되었습니다.');
		self.close();
	</script>
</c:if>