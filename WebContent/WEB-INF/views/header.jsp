<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
	
		<!-- 기본 세팅, 브라우저 세팅, device 세팅 -->
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- 브라우저에서 레이아웃크기조절, 윈도우크기와 1:1비율로 맞춘다 -->
		<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
		
		<!-- IE=edge : 최신모드로 지정된 DOCTYPE에 상관없이 IE8 이상 버전에서 항상 최신 표준 모드로 렌더링됩니다. -->
		<meta http-equiv="X-UA-Compatible" content="IE=Edge">  
		<!-- 사파리에서(아이폰) 전화번호, 주소, 이메일을 쓸경우 자동으로 링크설정이되 스타일이 안먹히는 것을 방지  -->
		<meta name="format-detection" content="telephone=no, address=no, email=no">
		<!-- 모바일주소로 변환 <link rel="alternate"  href="http://www.beusable.com/m"> -->
		<!-- <link rel="shortcut icon" type="image/png" href="img/favicon/beuLogo.ico"/> -->

		<!-- CSS RESET -->
    	<link rel="stylesheet" type="text/css"  href="/buengbueng/css/reset.css">
		<!-- INDEX CSS 2 -->    
        <link rel="stylesheet" type="text/css" media="all" href="/buengbueng/css/dist/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" media="all" href="/buengbueng/css/dist/bootstrap-theme.min.css" />
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" media="all" href="/buengbueng/css/dist/modules.min.css" />
	
		<!-- main -->
		<link rel="stylesheet" type="text/css" media="all" href="/buengbueng/css/dist/sidemain_main.css" />
		
		<!-- 구글 MATERIAL ICON -->
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
		
		<!-- 알람 toast API CSS -->
		<link rel="stylesheet" type="text/css" media="all" href="/buengbueng/css/toast/toast.css" />
		
		<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
		
		<!-- 알람 toast API JS 임시 -->
		<script src="/buengbueng/css/toast/toast.js"></script>
	
		<!-- 챗봇 JS -->
		<script src="/buengbueng/js/layer.js"></script>
		<link rel="stylesheet" type="text/css" media="all" href="/buengbueng/css/chatbot/chatbot.css" />
		
		<!-- 반응형 메뉴 -->
		<script>
			/* When the user clicks on the button, 
			toggle between hiding and showing the dropdown content */
			function myFunction() {
			    document.getElementById("myDropdown").classList.toggle("show");
			}
			
			// Close the dropdown if the user clicks outside of it
			window.onclick = function(event) {
			  if (!event.target.matches('.dropbtn')) {
			
			    var dropdowns = document.getElementsByClassName("dropdown-content");
			    var i;
			    for (i = 0; i < dropdowns.length; i++) {
			      var openDropdown = dropdowns[i];
			      if (openDropdown.classList.contains('show')) {
			        /* openDropdown.classList.remove('show'); */
			      }
			    }
			  }
			}
			
			
			$(document).ready(function(){
			    // memu 클래스 바로 하위에 있는 a 태그를 클릭했을때
			    $(".menu>a").click(function(){
			        // 현재 클릭한 태그가 a 이기 때문에
			        // a 옆의 태그중 ul 태그에 hide 클래스 태그를 넣던지 빼던지 한다.
			        $(this).next("ul").toggleClass("hide");
			    });
			});
		</script>
		<style>
		.dropbtn {
    font-family: 'NEXONFootballGothicB';
    color: white;
    padding: 2px;
    font-size: 16px;
    border: none;
    cursor: pointer;
}
.hamburger .line {
    width: 28px;
    height: 5px;
    margin-bottom: 6px;
    background-color: #fff;
    display: block;
    -webkit-transition: all 0.3s ease-in-out;
    -o-transition: all 0.3s ease-in-out;
    transition: all 0.3s ease-in-out;
}
.dropdown-content {
    display: none;
    background-color: #e7e7e7;
    /* min-width: 160px; */
    overflow: auto;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    width: 100%;
    float: left;
    height: auto;
    text-align: center;
}
.menu {
    float: left;
    width: 100%;
    background: #fff;
    border:1px solid #e7e7e7;
    height:30px;
}
.menu_name, .menu_desc{
padding-left:10px;
}
.col1 {
    display: block;
    float: right;
    margin-right: 20px;
    margin-top: 10px;
}
.ux-heatmap{
padding-top:5px;
}
@media screen and (min-width:250px){
.buengbueng_logo{
float:left;
width:100%;}
}
@media screen and (min-width:768px){
.buengbueng_logo{
float:none;
width:750px;
}
@media screen and (min-width:992px){
.buengbueng_logo{
width:970px;
}
@media screen and (min-width:1200px){
.buengbueng_logo{
width:1100px;
}
}
		</style>
		
		<!-- 홈페이지 제목 -->
	</head>
	 	<!-- LOGIN SECTION -->
	 	<header class="header_wrap" >
			<div class="header container buengbueng_logo" style="background-color:#fff;">
				<!-- 로고 : BUENGBUENG 또는 그림 -->
				<div class="logo_box">
					<div class="logo_con" style="width:28%;float:left;">
						<p><a href="index.do">buengbueng</a></p>
					</div>
					
					<!-- NAV SECTION -->
				<!-- BIG NAV : 대 제목 : 메인 NAV : 메인 메뉴 -->				
				<ul class="menu_area"  style="width:70%;float:right;"> 
					<li class="item normal product" onClick="return true">
						<!-- 대메뉴 이름 : 링크 : 클릭시 드롭다운메뉴 -->
<!-- -------------------------------------------------------------------------------------------------------- -->						
 						<a class="ctgr" href="">
회사 소개
						</a>
						<!-- 드롭다운메뉴 : 소메뉴 -->
						<ul class="menu_list">
						<!-- 	소메뉴 타이틀 -->
							<h6 class="menu_subject minor-minor">회사소개&nbsp; | &nbsp;<span class="list__title__desc">PC방이용자님이 사용할수 있는 메뉴입니다.</span></h6>
							<!-- 소메뉴 의 각 링크들 -->
							<li class="row">
								<!-- 컨텐츠당 하나의 div로 구성 -->
								<div class="menu_menu col-sm-6-12">
									<a href="intro.do">
										<span class="menu_icon ux-heatmap" ><i class="fa fa-university fa-2x" aria-hidden="true"></i></span>
										<span class="menu_text">
											<h6 class="menu_name minor-minor">프로그램 기능소개</h6>
											<p class="menu_desc">BUENGBUENG 모든 기능 소개</p>
										</span>
									</a>
								</div>
							</li>
						</ul>	
					</li> 
<!-- ------------------------------------------------------------------------------------------------------ -->
				<c:if test="${sessionScope.grade==3}">
					<li class="item normal product" onClick="return true">
						<!-- 대메뉴 이름 : 링크 : 클릭시 드롭다운메뉴 -->
						<a class="ctgr" href="">
사용자 PC방 이용
						</a>
						<!-- 드롭다운메뉴 : 소메뉴 -->
						<ul class="menu_list ">
							<!-- 소메뉴 타이틀 -->
							<h6 class="menu_subject minor-minor">
								PC방이용&nbsp; | &nbsp;
								<span class="list__title__desc">PC방이용자님이 사용할수 있는 메뉴입니다.</span>
							</h6>
							
							<!-- 소메뉴 의 각 링크들 -->
							<li class="row">
								<!-- 컨텐츠당 하나의 div로 구성 -->
								<div class="menu_menu col-sm-6-12">
									<a href="searchPCForm.do">
										<span class="menu_icon ux-heatmap"><i class="fa fa-search fa-2x" aria-hidden="true"></i></span>
										<span class="menu_text">
											<h6 class="menu_name minor-minor">PC방 찾기</h6>
											<p class="menu_desc">우리동네, 지역 가맹 피시방찾기</p>
										</span>
									</a>
								</div>
								
								<!-- 컨텐츠당 하나의 div로 구성 -->
								<div class="menu_menu col-sm-6-12">
									<a href="cash.do">
										<span class="menu_icon ux-heatmap"><i class="fa fa-krw fa-2x" aria-hidden="true"></i></span>
										<span class="menu_text">
											<h6 class="menu_name minor-minor">결제</h6>
											<p class="menu_desc">PC이용요금 결제</p>
										</span>
									</a>
								</div>
							</li>
							<!-- 소메뉴 의 각 링크들 -->
							<li class="row">
								<!-- 컨텐츠당 하나의 div로 구성 -->
							
								<div class="menu_menu col-sm-6-12">
									<a href="favoritePCRoom.do">
										<span class="menu_icon ux-heatmap"><i class="fa fa-thumbs-up fa-2x" aria-hidden="true"></i></span>
										<span class="menu_text">
											<h6 class="menu_name minor-minor">즐겨찾는 PC방</h6>
											<p class="menu_desc">자주찾는 PC방을 지정하여 그곳의 정보를 먼저 파악</p>
										</span>
									</a>
								</div>
								<!-- 컨텐츠당 하나의 div로 구성 -->
							
								<div class="menu_menu col-sm-6-12">
									<a href="ledger.do">
										<span class="menu_icon ux-heatmap"><i class="fa fa-bar-chart fa-2x" aria-hidden="true"></i></span>
										<span class="menu_text">
											<h6 class="menu_name minor-minor">이용현황</h6>
											<p class="menu_desc">현재 실시간 자리현황 파악</p>
										</span>
									</a>
								</div>
							</li>
							<!-- 소메뉴 의 각 링크들 -->
							<li class="row">
								<!-- 컨텐츠당 하나의 div로 구성 -->
							
								
							</li>
						</ul>	
					</li>
				</c:if>
<!-- ---------------------------------------------------------------------------------------------------- -->
				<c:if test="${sessionScope.grade==1}">
 					<li class="item normal product" onClick="return true">
						<!-- 대메뉴 이름 : 링크 : 클릭시 드롭다운메뉴 -->
						
						<a class="ctgr" href="">
사장님 PC방 관리
						</a>
						<!-- 드롭다운메뉴 : 소메뉴 -->
						<ul class="menu_list ">
							<!-- 소메뉴 타이틀 -->
							<h6 class="menu_subject minor-minor">사장님관리&nbsp; | &nbsp;<span class="list__title__desc">사장님께서 PC방관리를 할 수 있습니다.</span></h6>
							<!-- 소메뉴 의 각 링크들 -->
							<li class="row">
								<!-- 컨텐츠당 하나의 div로 구성 -->
								<div class="menu_menu col-sm-6-12">
									<a href="">
										<span class="menu_icon ux-heatmap"><i class="fa fa-desktop fa-2x" aria-hidden="true"></i></span>
										<span class="menu_text">
											<h6 class="menu_name minor-minor">원격 조종</h6>
											<p class="menu_desc">멀리서 사장님 PC 관리</p>
										</span>
									</a>
								</div>
								<!-- 컨텐츠당 하나의 div로 구성 -->
								<div class="menu_menu col-sm-6-12">
									<a href="bossErpMainSession.do">
										<span class="menu_icon ux-heatmap"><i class="fa fa-tachometer fa-2x" aria-hidden="true"></i></span>
										<span class="menu_text">
											<h6 class="menu_name minor-minor">ERP 관리</h6>
											<p class="menu_desc">PC방 내 모든 현황 관리</p>
										</span>
									</a>
								</div>
							</li>
							<!-- 소메뉴 의 각 링크들 -->
							<li class="row">
								<!-- 컨텐츠당 하나의 div로 구성 -->
								<div class="menu_menu col-sm-6-12">
									<a href="franchiseeList.do">
										<span class="menu_icon ux-heatmap"><i class="fa fa-pencil-square-o fa-2x" aria-hidden="true"></i></span>
										<span class="menu_text">
											<h6 class="menu_name minor-minor">가맹점 관리</h6>
											<p class="menu_desc">가맹점 등록 및 삭제</p>
										</span>
									</a>
								</div>
							</li>
						</ul>	
					</li>				
				</c:if>	
<!-- ---------------------------------------------------------------------------------------------------- -->
<c:if test="${sessionScope.grade==4}">					
					<li class="item normal product" onClick="return true">
						<!-- 대메뉴 이름 : 링크 : 클릭시 드롭다운메뉴 -->
						
						<a class="ctgr" href="/buengbueng/dashIndex.do">
관리자 프로그램 관리
						</a>
						
					</li>		
</c:if>
<!-- ----------------------------------------------------------------------------------------------------								 -->
					<li class="item normal product" onClick="return true">
						<a href="">
고객센터
						</a>
						<!-- 드롭다운메뉴 : 소메뉴 -->
						<ul class="menu_list ">
							<!-- 소메뉴 타이틀 -->
							<h6 class="menu_subject minor-minor">All people&nbsp; | &nbsp;<span class="list__title__desc">모든 문의는 여기에서 확인할 수 있습니다.</span></h6>
							<!-- 소메뉴 의 각 링크들 -->
							<li class="row">
								<!-- 컨텐츠당 하나의 div로 구성 -->
								<div class="menu_menu col-sm-6-12">
									<a href="franchiseQA.do?snum=1">
										<span class="menu_icon ux-heatmap"><i class="fa fa-book fa-2x" aria-hidden="true"></i></span>
										<span class="menu_text">
											<h6 class="menu_name minor-minor">가맹 문의</h6>
											<p class="menu_desc">가맹시 궁금한 문의 여기로</p>
										</span>
									</a>
								</div>
								<!-- 컨텐츠당 하나의 div로 구성 -->
								<div class="menu_menu col-sm-6-12">
									<a href="customerQA.do?snum=2">
										<span class="menu_icon ux-heatmap"><i class="fa fa-book fa-2x" aria-hidden="true"></i></span>
										<span class="menu_text">
											<h6 class="menu_name minor-minor">자주 묻는 질문</h6>
											<p class="menu_desc">자주 물어보는 질문들 여기로</p>
										</span>
									</a>
								</div>
							</li>
							<!-- 소메뉴 의 각 링크들 -->
							<li class="row">
								<!-- 컨텐츠당 하나의 div로 구성 -->
								<div class="menu_menu col-sm-6-12">
									<a href="oneQA.do?snum=3">
										<span class="menu_icon ux-heatmap"><i class="fa fa-book fa-2x" aria-hidden="true"></i></span>
										<span class="menu_text">
											<h6 class="menu_name minor-minor">1:1 문의</h6>
											<p class="menu_desc">사소한것까지 궁금한건 여기로</p>
										</span>
									</a>
								</div>							
							<!-- 컨텐츠당 하나의 div로 구성 -->
							<div class="menu_menu col-sm-6-12">
							      <a href = "notice.do?snum=4&pageNum=1">
							      	 <span class="menu_icon ux-heatmap"><i class="fa fa-book fa-2x" aria-hidden="true"></i></span>
										<span class="menu_text">
											<h6 class="menu_name minor-minor">공지사항</h6>
											<p class="menu_desc">사이트 공지는  여기로</p>
										</span>
									</a>
							</div>
						</ul>	
					</li>							
               
               
            <!-- 로그인상태와 로그아웃상태일때 환영메세지, 관리자 일때 관리자페이지 링크가 보이게 한다. -->
               <c:if test="${sessionScope.loginId != null}" >
                  <li class="item sign"><a href="/buengbueng/logout.do">로그아웃</a></li>
                  <li class="item sign"><a href="/buengbueng/userInfoForm.do">회원 정보보기</a></li>
                  <li class="item sign"><a href="#">${sessionScope.loginId}님 환영해요</a></li>
                  <c:if test="${sessionScope.grade!=4}" >
                  	<li class="item sign"><a onclick="chattingView();" style="cursor: pointer;">실시간 문의</a></li>
                  </c:if>
               </c:if>
               <c:if test="${sessionScope.loginId == null}" >
                  <li class="item sign"><a href="/buengbueng/userInfoSignForm.do">회원가입</a></li>
                  <li class="item sign"><a href="">비밀번호찾기</a></li>
                  <li class="item sign"><a href="/buengbueng/loginForm.do">로그인</a></li>
                  <li class="item sign"><a onclick="chattingView();" style="cursor: pointer;">실시간 문의</a></li>
               </c:if>
               <c:if test="" >
                  <li class="item sign">관리자페이지</li>
               </c:if>
               
            </ul>
					
				</div>
				
				
				
				
				
            
            <div class="dropdown md_hidden" style="float:right;width:43.9%;height:50px;top:-50px;">
					
			      <div class="three col1" >
			      <div class="dropbtn"  style="z-index: 999999">
			        <div class="hamburger dropbtn" id="hamburger-1" onclick="myFunction()" >
			        <div>
			          <span class="line dropbtn"></span>
			          <span class="line dropbtn"></span>
			          <span class="line dropbtn"></span>
			          </div>
			        </div>
			        </div>
			      </div>
			</div>
			      
			      
			      
					  <div id="myDropdown" class="dropdown-content " style="top:-50px;">
					 		
					 		<li class="menu">
					                <div class="stats_ms_menu">
						                <div class="stats_ms_menu_top col-xs-12-12">
						                	<div class="stats_ms_menu_top_left">
						                		<c:if test="${sessionScope.loginId != null}" >
						                			<span>${sessionScope.loginId}님</span>
						                		</c:if>
								                <c:if test="${sessionScope.loginId == null}" >
								                	<a style="color:red;" href="/buengbueng/loginForm.do">로그인</a> 
								                </c:if>
								            </div>
					                	</div>
					                </div>
					         
					        </li>
					    
					        <li class="menu">
					            <a class="intro.do">회사 소개</a>
					        </li>
							<li class="menu">
					            <a href="cash.do">결제</a>
					        </li>
					        <li class="menu">
					            <a href="searchPCForm.do">PC방 찾기</a>
					        </li>
					        <li class="menu">
					            <a href="favoritePCRoom.do">즐겨찾는 PC방</a>
					        </li>
					        <li class="menu">
					            <a href="ledger.do">이용현황</a>
					        </li>
     					    <li class="menu">
					            <a href="remoteIntro.do">원격 지원</a>
					        </li>	
      					    <li class="menu">
					            <a href="franchiseeList.do">가맹점 관리</a>
					        </li>	
					        <li class="menu">
					            <a href="bossErpMainSession.do">ERP 관리</a>
					        </li>	
					        <li class="menu">
					            <a href="franchiseQA.do?snum=1">가맹 문의</a>
					        </li>	
					        <li class="menu">
					            <a href="customerQA.do?snum=2">자주묻는 질문</a>	
					        </li>	
					        <li class="menu">
					            <a href="oneQA.do?snum=3">1:1 문의</a>
					        </li>	
					        <li class="menu">
					            <a href = "notice.do?snum=4&pageNum=1">공지사항</a>
					        </li>	
					    
					    </div>
            
         </div>
         
			
         
      </header>
 
<section class="main_wrap1" style="float:left;"> 
	<!-- css로 추가활것 -->
  	<div class="main" style="width:100%;">
 
		 <!-- SIDEMENU TEMPLATE -->
		<c:if test="${sidemenuCheck == 1}">
		
		<!-- 가맹점 -->
		<link rel="stylesheet" type="text/css" media="all" href="css/bosspcuse/franchisee.css">
			
			<jsp:include page="sidemenu.jsp" />
			
			<!-- ARTICLE -->
			<div class="side_content container">
			
		</c:if>
 
 		 <!-- NO SIDEMENU TEMPLATE -->
		<c:if test="${sidemenuCheck != 1}">

			<!-- ARTICLE -->
			<div class="side_scontent container" style="margin:0 auto;">
			
		</c:if>
  <script>
 $("#respon_menu").click(function () {
	 $("#respon_menu_area").toggle("show"); 
 });
 $("#respon_menu_intro").click(function(){
	 $("#respon_submenu_intro").toggle("show");
	 var check = 1;
	 return closeman(check);
 });
 $("#respon_menu_user").click(function(){
	 $("#respon_submenu_user").toggle("show");
	 var check = 2;
	 return closeman(check);
 });
 $("#respon_menu_boss").click(function(){
	 $("#respon_submenu_boss").toggle("show");
	 var check = 3;
	 return closeman(check);
 });
 $("#respon_menu_admin").click(function(){
	 $("#respon_submenu_admin").toggle("show");
	 var check = 4;
	 return closeman(check);
 });
 $("#respon_menu_question").click(function(){
	 $("#respon_submenu_question").toggle("show");
	 var check = 5;
	 return closeman(check);
 });
 function closeman(check){
	 if(check == 1){$("#respon_submenu_user").hide();$("#respon_submenu_boss").hide();$("#respon_submenu_admin").hide();$("#respon_submenu_question").hide();}
	 if(check == 2){$("#respon_submenu_intro").hide();$("#respon_submenu_boss").hide();$("#respon_submenu_admin").hide();$("#respon_submenu_question").hide();}
	 if(check == 3){$("#respon_submenu_intro").hide();$("#respon_submenu_user").hide();$("#respon_submenu_admin").hide();$("#respon_submenu_question").hide();}
	 if(check == 4){$("#respon_submenu_intro").hide();$("#respon_submenu_user").hide();$("#respon_submenu_boss").hide();$("#respon_submenu_question").hide();}
	 if(check == 5){$("#respon_submenu_intro").hide();$("#respon_submenu_user").hide();$("#respon_submenu_boss").hide();$("#respon_submenu_admin").hide();}
 }
 </script>

<!-- 챗봇 창 -->
 <div id="chatting" style="display:none;position:absolute;z-index: 10">
 	<div style="width:100%;background-color: gray;display: inline-block;">
 		<button id="pop_close" class="pop">x</button>
 		<button id="pop_max" class="pop">ㅁ</button>
 		<button id="pop_min" class="pop">＿</button><br/>
 	</div>
 	<div id="chattingDiv" style="width:100%;display:inline-block;">
		<iframe src="http://localhost:3000/" width = 100% height="80%"></iframe>
	</div>
 </div>