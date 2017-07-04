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
	

		
		<!-- 홈페이지 제목 -->
		
	</head>

 

	 	<!-- LOGIN SECTION -->
	 	<header class="header_wrap" style="background:#2b3643; border:none; height:40px;">
			<div class="header container ">
				<div style="border:1px red solid; ; margin:0 auto; width:100%;">
					buengbueng
				</div>
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
 
 