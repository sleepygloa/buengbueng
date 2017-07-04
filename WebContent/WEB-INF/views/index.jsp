<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${check==1}">
<script>
alert('정보가 틀립니다.');
history.go(-1);
</script>
</c:if>
<!-- HEADER TEMPLATE -->
<jsp:include page="header.jsp" /> 

<!-- ARTICLE -->
<!-- 메인 화면 전광판  ------------------------------------------------------------>
<div class="main_ad">
	<div class="main_ad_content">
			<div class="col-xs-10-10 main_ad_contentBox">
				<div class="col-xs-10-10 col-sm-5-10 col-md-2-10  bg1 col_height200 contentBox_outline">
					<div class="contentBox">
						<div class="contentBox_a"><a href="#">포인트 결제</a></div>
						<div><i class="fa fa-krw fa-4x" aria-hidden="true"></i></div>
					</div>
				</div>
				<div class="col-xs-10-10 col-sm-5-10 col-md-2-10  bg2 col_height200 contentBox_outline">
					<div class="contentBox">
						<div class="contentBox_a"><a href="#">결제내역 조회</a></div>
						<div><i class="fa fa-krw fa-4x" aria-hidden="true"></i></div>
					</div>
				</div>
				<div class="col-xs-10-10 col-sm-5-10 col-md-2-10  bg3 col_height200">
					<a href="#">이용내역 조회</a>
				</div>
				
				<div class="col-xs-10-10 col-sm-5-10 col-md-4-10 col_height200 bg2">
					<div class="login_title">
						<p>PC방에 오신 것을 환영합니다.원활한 이용을 위해 로그인이 필요합니다.</p>
					</div>
					<button class="Login_button">BuengBueng <span class="Login_button_point">PC방</span> 로그인</button>
					<div class="Login_other">
						<ul>
							<li class="Login_other1"><a href="#">회원가입</a></li>
							<li class="Login_other2"><a href="#">비밀번호 찾기</a></li>
							<li class="Login_other2">|</li>
							<li class="Login_other2"><a href="#">아이디 찾기</a></li>
						</ul>
					</div>
				</div>
				
			</div>
			
			<!-- <div class="col-xs-12-12 col-sm-6-12 col-md-3-12  bg5 col_height100">
				<div class="left_container2_box2 bg13">
					<a href="#">가맹신청</a>
				</div>
				<div class="left_container2_box1 bg12">
					<a href="#">공지사항</a>
				</div>
			</div>
			<div class="left_container2 bg9">
				<div class="left_container2_box1_1 bg10">
					<a href="#">하하하하하</a>
				</div>
				<div class="left_container2_box2_1 bg11"> 
					<a href="#">호호호히히</a>
				</div>
			</div> -->
			
			<div class="right_container2">
				<p>배너</p>
			</div>
		</div>
		
	</div>
<!-- 끝 : 메인화면 전광판 ---------------------------------------------------------->	
	<%-- 
<!-- 메인 주요기능 : 카드 섹션? 영역 -------------------------------------------------->
<div class="main_card_wrap row">
    <div class="main_card_content">
        <div class="card_title_wrap">
            <h3 class="card_title">와우! 간편한 기능!</h3>
        </div>

	    <div class="card_content_wrap">
	            <h4 class="card_content_title">새로운 점주는 언제나 환영이지!!</h4>
	            <div class="row">
<!-- 카드섹션 컨텐츠------------------------------------------------------------ -->
	                <div class="col-xs-12-12 col-sm-6-12 col-md-4-12">
	                    <a class="offer__function__section scalable"  href="">
	                        <div class="card_icon ux-heatmap"></div>
	                        <h6 class=" minor">UX Heatmap</h6>
	                        <p class="tool__section__desc">사용자의 UX결과를 히트맵 형태로<br/>한눈에 볼 수 있습니다.</p>
	                        <span class="goProduct">더 알아보기 &gt;</span>
	                    </a>
	                </div>
	                <div class="col-xs-12-12 col-sm-6-12 col-md-4-12 ">
	                    <a class="offer__function__section scalable" href="">
	                        <div class="card_icon reporting-heatmap"></div>
	                        <h6 class=" minor">Reporting Heatmap</h6>
	                        <p class="tool__section__desc">히트맵 분석 결과와 이슈를 자동으로<br/>요약하고 정리 해드립니다.</p>
	                        <span class="goProduct">더 알아보기 &gt;</span>
	                    </a>
	                </div>
	                <div class="col-xs-12-12 col-sm-6-12 col-md-4-12 ">
	                    <a class="offer__function__section scalable" href="">
	                        <div class="card_icon comparing-referrers"></div>
	                        <h6 class=" minor">Comparing as Referrers</h6>
	                        <p class="tool__section__desc">유입 경로에 따라 달라지는 UX를<br/>직접 비교해 볼 수 있습니다.</p>
	                        <span class="goProduct">더 알아보기 &gt;</span>
	                    </a>
	                </div>
	                <div class="col-xs-12-12 col-sm-6-12 col-md-4-12 ">
	                    <a class="offer__function__section scalable" href="">
	                        <div class="card_icon user-heatmap"></div>
	                        <h6 class=" minor">User Analytics</h6>
	                        <p class="tool__section__desc">뷰저블을 설치하셨다면 사용자 지표도<br/>실시간으로 볼 수 있습니다.</p>
	                        <span class="goProduct">더 알아보기 &gt;</span>
	                    </a>
	                </div>
	                <div class="col-xs-12-12 col-sm-6-12 col-md-4-12 ">
	                    <a class="offer__function__section scalable" href="">
	                        <div class="card_icon gaze-heatmap"></div>
	                        <h6 class=" minor">Gaze Heatmap</h6>
	                        <p class="tool__section__desc">사용자들의 전반적인 사용 흐름을<br/>시각적으로 제공합니다.</p>
	                        <span class="goProduct">더 알아보기 &gt;</span>
	                    </a>
	                </div>
	                <div class="col-xs-12-12 col-sm-6-12 col-md-4-12 ">
	                    <a class="offer__function__section scalable" href="">
	                        <div class="card_icon segmenting-cta"></div>
	                        <h6 class=" minor">Segmenting as CTA</h6>
	                        <p class="tool__section__desc">특정 버튼이나 클릭 요소를 어떤 유형의</br> 사용자들이 선택했는지 알 수 있습니다.</p>
	                        <span class="goProduct">더 알아보기 &gt;</span>
	                    </a>
	                </div>
	            </div>
		</div>
    </div>
</div>
<!-- 메인 주요기능 : 카드 섹션? 영역 --------------------------------------------------->
--%>
<!-- FOOTER TEMPLATE -->
<jsp:include page="footer.jsp" /> 