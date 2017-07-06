<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="url" value="menuOrderListForm.do?l_key=${l_key}"/>

<c:if test="${check==1}">
	
	<script>
		alert("환불 불가 처리되었습니다.");
		window.location.href=${url};
	</script>
</c:if>

<c:if test="${check==0}">

	<script>
		alert("환불 불가 처리에 실패하였습니다.");
		window.location.href=${url};
	</script>
</c:if>

<c:if test="${check==-1}">

	<script>
		alert("오류. 사용에 불편을 끼쳐 죄송합니다.");
		window.location.href=${url};
	</script>
</c:if>
     
     
    