<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<link rel="stylesheet" type="text/css" media="all" href="css/userInfo/userInfo.css">
	
	<div class="login_wrap">
      <div class="login_container">
         <div class="login_inputform_container">
            <div><h1>아이디 찾기</h1></div>
            <div class="login_inputform">
               <form id="signinForm" action="userInfoSearchIdFormPro.do" method="post">
                <input class="login_inputform_input" type="text"  name="name" placeholder="이름를 입력해주세요">
                <input class="login_inputform_input" type="password"  name="email" placeholder="이메일를 입력해주세요">
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

