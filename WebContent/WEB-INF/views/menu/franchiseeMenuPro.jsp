<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	function succ(check, url, data){
		
		alert(check);
		window.location=url;
	}
</script>

<c:if test="${check==1}">
	<body onload="succ('.','menuModify.do/KEY=${}')" />
</c:if>

<c:if test="${check==0}">
	<body onload="succ('정보입력이 바르지 않습니다.','menuModifyForm.do')"/>
</c:if>

<c:if test="${check==-1}">
	<body onload="succ('정보입력이 바르지 않습니다.','menuModifyForm.do')"/>
</c:if>