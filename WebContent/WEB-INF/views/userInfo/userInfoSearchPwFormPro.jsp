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
	<body onload="succ('회원님의 비밀번호는 ${pw} 입니다.','loginForm.do')" />
</c:if>

<c:if test="${check==0}">
	<body onload="succ('정보입력이 바르지 않습니다.','userInfoSearchPwForm.do')"/>
</c:if>