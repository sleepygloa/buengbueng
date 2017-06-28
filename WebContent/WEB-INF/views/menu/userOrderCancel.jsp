<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${check==1}">
	
	<script>
		alert("주문이 취소되었습니다.");
		window.location.href="userOrderForm.do?l_key=${l_key}";
	</script>
</c:if>

<c:if test="${check==0}">

	<script>
		alert("주문취소가 이뤄지지 않았습니다.");
		window.location.href="userOrderForm.do?l_key=${l_key}";
	</script>
</c:if>

<c:if test="${check==-1}">

	<script>
		alert("오류. 사용에 불편을 끼쳐 죄송합니다.");
		window.location.href="productInsertForm.do?l_key=${l_key}";
	</script>
</c:if>
     
     
    