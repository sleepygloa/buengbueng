<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- HEADER TEMPLATE -->
<jsp:include page="../header.jsp" />
<script type="text/javascript">
	function Checkwrite(){
		if(document.writeCheck.passwd.value==""){
			alert("비밀번호를 입력하세요.");
			return false;
		}
	}
</script>
<head>
<title>비밀번호 체크</title>
</head>
<form name="writeCheck" action="oneContent.do" onsubmit="return Checkwrite();" method="post" >

<div>
<input type="hidden" name="number" value="${number}">
<input type="hidden" name="num" value="${num}">
<input type="hidden" name="snum" value="${dto.snum}">
<input type="hidden" name="pageNum" value="${pageNum}">
<div>
<c:if test="${sessionScope.grade != 4 || dto.re_step == 0}">
<div>
	<span>비밀번호</span>
	<span><input type="password" name="passwd" placeholder="비밀번호 입력란"></span>
</div>
</c:if>
<div>
	<span><input type="submit"  value="들어가기"></span>
	<span><input type="button" value="뒤로가기" onclick="history.go(-1);"></span>	
</div>


</form>