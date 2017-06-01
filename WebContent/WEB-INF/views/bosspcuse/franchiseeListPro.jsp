<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 가맹점 승인이 완료되었다.. -->
<c:if test="${check == 1}">
	<script>
		alert('가맹점 승인이 완료되었습니다.')
	</script>
</c:if>

<!-- 가맹점 신청이 완료되었습니다. -->
<c:if test="${check == 2}">
	<script>
		alert('서버 오류가 발생하였습니다. 잠시후에 다시 시도해주세요')
	</script>
	<meta http-equiv="refresh" content="1;url=franchiseeList.do" />
</c:if>

<!-- 이상한 방법으로 접근할때. -->
<c:if test="${check != 1 && check != 2}">
	<script>
		alert('당신은 누구죠?')
	</script>
	<meta http-equiv="refresh" content="1;url=index.do" />
</c:if>


<meta http-equiv="refresh" content="1;url=index.do" />