<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	
<c:if test="${check==1}">
<script>
alert('수정되었습니다.');
history.go(0);
</script>
</c:if>

<c:if test="${check==0}">
<script>
alert('수정 실패!!');
history.go(0);
</script>
</c:if>