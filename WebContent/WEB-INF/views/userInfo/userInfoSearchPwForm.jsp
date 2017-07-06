<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<link rel="stylesheet" type="text/css" media="all" href="css/userInfo/userInfo.css">
	
	<div class="login_wrap">
      <div class="login_container">
         <div class="login_inputform_container">
            <div><h1>비밀번호 찾기</h1></div>
            <div class="login_inputform">
               <form id="signinForm" action="userInfoSearchPwFormPro.do" method="post">
                <input class="login_inputform_input" type="text"  name="id" placeholder="아이디를 입력해주세요">
                <input class="login_inputform_input" type="password"  name="name" placeholder="이름를 입력해주세요">
                <input class="login_inputform_input" type="text"  name="phone" placeholder="전화번호를 입력해주세요">
                  
				<input class="login_inputform_submit"  type="submit" style="width:40%;" value="확인">
				<input class="login_inputform_submit"  type="button" value="취소"  style="width:40%;" onclick="window.location='index.do'">
               </form>
            </div>
         </div>
         <div class="login_inputform_img">
            <img src="/buengbueng/img/userInfo/login-banner.png" alt=""> 
         </div>
      </div>
    </div>		
		