<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${check==1}">
	
	<script>
		alert("환불이 요청되었습니다.");
		window.location.href="userOrderForm.do?name=${name}&id=${id}";
	</script>
</c:if>

<c:if test="${check==0}">

	<script>
		alert("환불 요청에 실패하였습니다.");
		window.location.href="userOrderForm.do?name=${name}&id=${id}";
	</script>
</c:if>

<c:if test="${check==-1}">

	<script>
		alert("오류. 사용에 불편을 끼쳐 죄송합니다.");
		window.location.href="productInsertForm.do?name=${name}&id=${id}";
	</script>
</c:if>
     
     
    