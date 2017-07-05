<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- HEADER TEMPLATE -->
<jsp:include page="..//header.jsp" />
		
<div class="main_ad">
	<div class="main_ad_content">
			<div class="col-xs-10-10 main_ad_contentBox">
			<form action="userInfoSearchIdFormPro.do" method="post">
				<div class="mb0 col-xs-10-10 col-sm-5-10 col-md-12-12 col_height200 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_img_banner"><img src="/buengbueng/img/userInfo/idsearch.png" style="width:100%;height:100%;"/></div>
					</div>
				</div>
				<div class="xs_hidden mb0 col-xs-10-10 col-sm-5-10 col-md-3-12 col_height200 contentBox_outline">
					<div class="contentBox col_height0">
					</div>
				</div>
				<div class="mb0 col-xs-10-10 col-sm-5-10 col-md-3-12 col_height200 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a"><a href="#">회원 아이디 찾기</a></div>
					</div>
				</div>
				<div class="mb0 col-xs-10-10 col-sm-5-10 col-md-3-12 col_height200 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a">이름<input  class="input_style contentBox_right" type="text" name="name"></div>
						<div class="contentBox_a">이메일<input  class="input_style contentBox_right" type="text" name="email"></div>
						<div class="contentBox_a">핸드폰<input  class="input_style contentBox_right" type="text" name="phone"></div>
						<div class="contentBox_a"><input  type="submit" style="width:50%;" value="확인"><input  type="button" value="취소"  style="width:50%;" onclick="window.location='index.do'"></div>
					</div>
				</div>
			</form>				
			</div>
	</div>
</div>
