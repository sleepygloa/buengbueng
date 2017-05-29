<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<head>
	<title>회원 정보</title>
</head>
<body>

	<form action="userInfoFormUpdatePro.do" method="post">
	<!-- IP : BEAN 에서 IP 정보를 생성 및 전달 -->
		<table>
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="id" value="${user.id}" />
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="pw" value="${user.password}" />
				</td>
			</tr>			
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="name" value="${user.name}" />
				</td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td>
					<input type="text" name="birth" value="${user.birth}" />
				</td>
			</tr>
			<tr>
				<td>전화 번호</td>
				<td>
					<input type="text" name="phone" value="${user.phone}" />
				</td>
			</tr>
			<tr>
				<td>등급</td>
				<td>
					<input type="text" name="grade" value="${user.grade}" />
				</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>
					<input type="text" name="address" value="${user.address}" />
				</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>
					<input type="text" name="email" value="${user.email}" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="수정하기" />
					<input type="reset" value="내용지우기" />
					<input type="button" value="메인화면으로" 
						onclick="window.location='index.do'" />
						
				</td>
			</tr>
			
		</table>
	</form>
</body>