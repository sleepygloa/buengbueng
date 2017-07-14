<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<!-- userInfo -->
		<link rel="stylesheet" type="text/css" media="all" href="css/userInfo/userInfo.css">
	
<style>
@media screen and (min-width:250px){
	.xs_hidden{display:none;}
	.md_hidden{display:block;}
	.xsm_hidden{display:none;}
	.sm_hidden{display:block;}
	.login_container{width:330px;}
}
@media screen and (min-width:768px){
	.xs_hidden{display:block;}
	.sm_hidden{display:none;}
	.login_container{width:700px;}
}
@media screen and (min-width:1200px){
	.md_hidden{display:none;}
	.xsm_hidden{display:block;}
	.sm_hidden{display:none;}
}
</style>	
		
	<div class="login_wrap">
		<div class="login_container">
			<div class="login_inputform_container">
				<div><h1>buengbueng</h1></div>
				<div class="login_inputform">
					<form id="signinForm" action="login.do" method="post">
						<input class="login_inputform_input" type="text" id="email" name="id" placeholder="아이디를 입력해주세요">
						<input class="login_inputform_input" type="password" id="password" name="pw" placeholder="패스워드를 입력해주세요">
						
						<input class="login_inputform_submit" type="submit" value="로그인">
					</form>
					<div class="login_inputform_other">
					 <a href="userInfoSignForm.do">회원가입</a> | <a href="userInfoSearchIdForm.do">아이디 찾기</a> | <a href="userInfoSearchPwForm.do">비밀번호 찾기</a>
					</div>					
				</div>
			</div>
			<div class="login_inputform_img xs_hidden">
				<img src="/buengbueng/img/userInfo/login-banner.png" alt=""> 
			</div>
		</div>
	</div>
