<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<tilte>회원탈퇴</tilte>
<form action="/buengbueng/userInfoDeletePro.do" method="post">
	<table cellPadding="1" cellSpacing="1" width="260" border="1" align="center">
		<tr>
			<td colspn="2" align="middle">
			<p>회원탈퇴</p>
			</td>
		</tr>
		<tr>
			<td width="110" align="center">비밀번호</td>
			<td width="150" align="center">
				<input type="password" name="pw">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="회원탈퇴">
				<input type="button" value="취소" onclick="window.location='/buengbueng/index.do'">	
			</td>
		</tr>				
	</table>
</form>