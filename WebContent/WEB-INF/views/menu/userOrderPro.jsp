<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	function succ(check, url){
		alert(check);
		window.location=url;
	}
</script>


<c:if test="${check==1}">
	<body onload="succ('${order}이(가) 주문되었습니다.','userOrderForm.do')" />
</c:if>

<c:if test="${check==0}">
	<body onload="succ('상품이 품절 되었습니다.','userOrderForm.do')"/>
</c:if>


<c:if test="${check==-1}">
	<body onload="succ('오류. 사용에 불편을 드려서 죄송합니다.','userOrderForm.do')"/>
</c:if>