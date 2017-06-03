<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<!-- userInfo -->
		<link rel="stylesheet" type="text/css" media="all" href="css/userInfo/userInfo.css">

<section class="main_wrap"> 
  	<div class="main container">


<div class="userInfo_login_wrap">
    <div class="container">
        <div class="login_wrap">
            <div class="row">
                <div class="col-xs-12-12 col-md-6-12">
                    <h1 class="signin--title"><a class="home" href="index.do"><img src="../img/signin_beulogo-white.png" alt="buengbueng"></a></h1>
                </div>
                <div class="col-xs-12-12 col-md-6-12">
                    <div class="login_form_wrap">
                        <form id="signinForm" action="login.do" method="post">
                            <h3 class="signin--form__title">Sign In</h3>
                            <label for="email">이메일</label>
                            <input id="email" required="" type="text" name="id" value="" class="">
                            <span class="text_must text_right" id="msg_empty_email" style="display:none">* 이메일를 반드시 입력해주세요.</span>
                            <span class="text_must text_right" id="msg_wrong_email" style="display: none">* 가입되지 않은 이메일입니다.</span>
                            <span class="text_must text_right" id="msg_unactivated_email" style="display:none">* 이메일 인증이 완료되지 않았습니다</span>
                            <span class="text_must text_right" id="msg_unable_email" style="display:none">* 사용할 수 없는 계정입니다</span>

                            <label class="password_label" for="password">비밀번호</label>
                            <input id="password" required="" type="password" name="pw" class="">
                            <span class="text_must text_right" id="msg_empty_pw" style="display: none">* 비밀번호를 반드시 입력해주세요.</span>
                            <span class="text_must text_right" id="msg_wrong_pw" style="display:none">* 비밀번호를 다시 확인해주세요.</span>

                            <input class="button btn" type="submit" value="로그인" onclick="ga('send', 'event', 'button', 'click', 'signin');">
                        </form>
                        <div class="signin--other_form">
                            <a class="signup" href="userInfoSignForm.do">회원가입</a><a href="#" id="btn_find_pw">비밀번호 찾기</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

	</div>
</section>
