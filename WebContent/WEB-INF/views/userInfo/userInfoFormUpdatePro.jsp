<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!-- 회원정보 수정 성공 -->
<c:if test="${check == 1}">
	<script>
		alert("회원정보가 수정되었습니다.");
	</script>

</c:if>

<!-- 회원정보 수정 실패  -->
<c:if test="${check == 2}">
	<script>
		alert("현재 서버가 불안정하여 회원정보수정이 취소되었습니다. 잠시후 재시도해주세요");
	</script>
</c:if>

<!-- 비밀번호 틀림  -->
<c:if test="${check == 3}">
	<script>
		alert("비밀번호가 틀렸습니다. 다시 확인해 주세요");
	</script>
	history.back();
</c:if>


<meta http-equiv="refresh" content="3;url=index.do" />