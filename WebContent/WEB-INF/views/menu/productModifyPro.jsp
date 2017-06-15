<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${check==1}">
	
	<script>
		alert("재고정보가 수정되었습니다.");
		window.location.href("productModify.do?l_key=${l_key}");
	</script>
</c:if>

<c:if test="${check==0}">
	
	<script>
		alert("정보입력이 바르지 않습니다.");
		window.location.href("productModifyForm.do?l_key=${l_key}");
	</script>
</c:if>