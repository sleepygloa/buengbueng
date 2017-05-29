<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>회원탈퇴</title>
<c:if test="${check==1}">
<form action="/buengbueng/main.do" method="post" name="deletePRo">
	<table width="270" border="0" cellspacing="0" cellpadding="5" align="center">
		<tr>
			<td align="center">
				<p>회원정보가 삭제되었습니다.</p>
			</td>
		</tr>
		<tr>
			<td align="center">
				<p>감사합니다 안녕히 가세요.</p>
				<meta http-equiv="Refrsh" content="5;url="index.do">
			</td>
		</tr>
		<tr>
			<td align="center">
				<input type="submit" valie="확인">
			</td>
		</tr>		
	</table>
</form>
</c:if>

<c:if test="${check != 1}">
<script>
alert("비밀번호가 맞지 않습니다.")
history.go(-1);
</script>
</c:if>