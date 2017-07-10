<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html style="height:100%;">

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
    	<link rel="stylesheet" type="text/css" media="all" href="/buengbueng/css/style_v2.css" />
		<!-- INDEX CSS 2 -->    
        <link rel="stylesheet" type="text/css" media="all" href="/buengbueng/css/dist/modules.min.css" />
        <link rel="stylesheet" type="text/css" media="all" href="/buengbueng/css/dist/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" media="all" href="/buengbueng/css/dist/bootstrap-theme.min.css" />
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" />
		<!-- <link rel="stylesheet" type="text/css"  href="/buengbueng/css/reset.css">  -->
	
		<!-- main -->
		<link rel="stylesheet" type="text/css" media="all" href="/buengbueng/css/dist/sidemain_main.css" />
		<!-- 구글 MATERIAL ICON -->
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
		
		<!-- 알람 toast API CSS -->
		<link rel="stylesheet" type="text/css" media="all" href="/buengbueng/css/toast/toast.css" />
		
		<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
		
		<!-- 알람 toast API JS 임시 -->
		<script src="/buengbueng/css/toast/toast.js"></script>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	
		<!-- erp_header 관련 CSS 및 JS -->
		<link rel="stylesheet" href="/buengbueng/css/menu.css"> 
		<link rel="stylesheet" href="/buengbueng/css/erp_header.css">
		<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>
	 	<script src="/buengbueng/js/menu.js"></script>
	 	
	 	<!-- erp_main 관련 CSS -->
	 	<link rel="stylesheet" href="/buengbueng/css/erp_main.css">
		<!-- 홈페이지 제목 -->
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




					
	</head>
 	

	 	<!-- LOGIN SECTION -->
	 	<header class="header_wrap" style="background:#2b3643; border:none; height:50px; float:left;">
			<div class="header container " style="float:left; height:50px;">
				<div class="logo_box">
					<div class="logo_con">
						<p>buengbueng ERP</p>
					</div>
									
				</div>
				
         </div>
         <%-- <ul>
			<c:if test="${sessionScope.loginId != null}" >
                  <li class="item sign"><a href="#">${sessionScope.loginId}님</a></li>
             
               </c:if>

               <c:if test="${sessionScope.loginId == null}" >
                  <li class="item sign"><a href="/buengbueng/loginForm.do">로그인</a></li>
               </c:if>
          </ul> --%>
         	   <div class="dropdown">
					
			      <div class="three col" >
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
			      
			      
			      
					  <div id="myDropdown" class="dropdown-content">
					 		
					 		<li class="menu">
					                <div class="stats_ms_menu">
						                <div class="stats_ms_menu_top">
						                	<div class="stats_ms_menu_top_left">
						                		<c:if test="${sessionScope.loginId != null}" >
						                			<span>${sessionScope.loginId}님</span>
						                		</c:if>
								                <c:if test="${sessionScope.loginId == null}" >
								                	<a style="color:red;" href="/buengbueng/loginForm.do">로그인</a> 
								                </c:if>
								            </div>
								            <div class="stats_ms_menu_top_right">
								            	<a href="/buengbueng/index.do">사용자 페이지</a>
								            </div>
					                	</div>
					                <select style="background:#293949; text-align:center; border-bottom:1px #344352 solid; " id="franchiseeSelect2" class="flist"></select>
					                </div>
					         
					        </li>
					    
					        <li class="menu">
					            <a class="menu_a">알바생 관리</a>
					            <ul class="hide" style="float:left; width:100%; margin-top:10px;">
					                <li><a href="employeeManageInfo.do">알바 아이디 관리</a></li>
							          <li><a href="employeeInfoList.do">신상관리</a></li>
							          <li><a href="#">알바 근태관리</a></li>
							          <li><a href="employeeCalender.do">근무달력</a></li>
							          <li><a href="employeeCommute.do">출근하기</a></li>
							          <li><a href="employeeOffWork.do">퇴근하기</a></li>
							          <li><a href="employeeWorkTimeList.do">출근기록 확인하기</a></li>
							          <li><a href="#">휴가관리</a></li>
							          <li><a href="bossEmployeeAccountManage.do">장부관리</a></li>
					            </ul>
					        </li>
					 
					        <li class="menu">
					            <a class="menu_a">가맹점 PC이용현황</a>
					            <ul class="hide" style="float:left; width:100%; margin-top:10px;">
					                <li><a href="pcUseStatusList.do">가맹점 PC이용현황</a></li>
					            </ul>
					        </li>
					        
					        <li class="menu">
					            <a class="menu_a">일일정산</a>
					            <ul class="hide" style="float:left; width:100%; margin-top:10px;">
					                <li><a href="applyForSettlement.do">일일정산 요청</a></li>
							         <li><a href="dailySettlementList.do">일일정산 내역</a></li>
					            </ul>
					        </li>
					        
					        <li class="menu">
					            <a class="menu_a">메뉴</a>
					            <ul class="hide" style="float:left; width:100%; margin-top:10px;">
					                <li class="active"><a href="menu.do">메뉴 관리</a></li>
							        <li class="active"><a href="product.do">재고 리스트</a></li>
					            </ul>
					        </li>
					        
					        <li class="menu">
					            <a class="menu_a">PC방 관리</a>
					            <ul class="hide" style="float:left; width:100%; margin-top:10px;">
					                <li><a href="seatDispose.do">PC방 좌석 정보 관리</a></li>
						            <li><a href="seatState.do">PC방 좌석 이용 관리</a></li>
					            </ul>
					        </li>
					        
					        <li class="menu">
					            <a class="menu_a">대여관리</a>
					            <ul class="hide" style="float:left; width:100%; margin-top:10px;">
					                <li><a href="rentManage.do">대여물품 관리</a></li>
					            </ul>
					        </li>
					    
					    </div>
					 
		
		     
	

						      
         <div class="util_menu">
         	<ul>
			<c:if test="${sessionScope.loginId != null}" >
                  <li class="item sign"><a href="#">${sessionScope.loginId}님</a></li>
                  <li class="item sign"><a href="/buengbueng/index.do">로그아웃</a></li>
                  <li class="item sign"><a href="/buengbueng/index.do">사용자 페이지</a></li>
                  <!-- <li class="item sign"><a href="/buengbueng/logout.do">로그아웃</a></li> -->
                  <c:if test="${sessionScope.grade!=4}" >
                  	<li class="item sign"><a onclick="window.open('/buengbueng/chatting.do','chatting','toolbar=no, location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500, height=500')" style="cursor: pointer;">실시간 문의</a></li>
                  </c:if>
               </c:if>

               <c:if test="${sessionScope.loginId == null}" >
                  <!-- <li class="item sign"><a href="/buengbueng/userInfoSignForm.do">회원가입</a></li> -->
                  <li class="item sign"><a href="">비밀번호찾기</a></li>
                  <li class="item sign"><a href="/buengbueng/loginForm.do">로그인</a></li>
                  <li class="item sign"><a onclick="window.open('/buengbueng/chatting.do','chatting','toolbar=no, location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500, height=500')" style="cursor: pointer;">실시간 문의</a></li>
               </c:if>
               
               <c:if test="${sessionScope.grade==4}" >
			      <li class="item sign"><a href="/buengbueng/dashIndex.do">관리자 페이지</a></li>
			   </c:if>
			  </ul>
			  
		 </div>	
		 
      </header>
      
<section class="main_wrap" style="float:left;"> 
	<!-- css로 추가활것 -->
  	<div class="main container" style="width:100%;">
 
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
			<div class="side_scontent container">
			
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
 
 