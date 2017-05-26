<%@ page language="java" contentType="text/html; charset=UTF-8"%>
${sessionScope.loginId}님 로그인 되었습니다.<br/>
<form action="logout.do" method="post">
<input type="submit" value="로그아웃">
</form>