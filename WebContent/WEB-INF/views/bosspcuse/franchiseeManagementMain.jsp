<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- HEADER TEMPLATE -->
<jsp:include page="../header.jsp" />

<!-- SIDEMENU TEMPLATE -->
<c:if test="${sidemenu == 1}">
	<jsp:include page="../sidemenu.jsp" />
</c:if>

<!-- ARTICLE -->


dfsafsads	



<input type="button" value="메인페이지로" onclick="window.location='index.do'"  />

<br /><br /><br /><br /><br />


<!-- FOOTER TEMPLATE -->
<jsp:include page="../footer.jsp" />