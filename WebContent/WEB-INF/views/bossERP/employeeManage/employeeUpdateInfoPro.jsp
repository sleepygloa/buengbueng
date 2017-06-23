<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 접속자가 비회원일때 알람과 함께 메인페이지로 이동 -->
<c:if test="${check == 9}">
	<script>
		alert('비회원은 이용할 수 없는 페이지입니다. 사장님만 이용할 수 있어요')
	</script>
	<meta http-equiv="refresh" content="1;url=index.do" />
</c:if>

<!-- 알바생신청 완료 -->
<c:if test="${check == 1}">
	<script>
		alert('알바생 정보 수정이 완료되었습니다. ')
	</script>
	<meta http-equiv="refresh" content="1;url=bossErpMain.do" />
</c:if>

<!-- 서버오류, 메인페이지로이동 -->
<c:if test="${check == 2}">
	<script>
		alert('2서버 오류가 발생하였습니다. 잠시후에 다시 시도해주세요')
	</script>
	<meta http-equiv="refresh" content="1;url=index.do" />
</c:if>

<!-- 서버오류, 메인페이지로이동 -->
<c:if test="${check == 3}">
	<script>
		alert('3서버 오류가 발생하였습니다. 잠시후에 다시 시도해주세요')
	</script>
	<meta http-equiv="refresh" content="1;url=index.do" />
</c:if>

<!-- BEAN 오류, 메인페이지로이동 -->
<c:if test="${check == 0}">
	<script>
		alert('실패')
	</script>
	<meta http-equiv="refresh" content="1;url=index.do" />
</c:if>


