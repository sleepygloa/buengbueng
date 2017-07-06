<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${asd==1}">    
<script>
alert("삭제 되었습니다.");
history.go(0);
</script>
</c:if>

<c:if test="${asd==0}">
<script>
alert("삭제실패!!");
history.go(0);
</script>
</c:if>