<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>관리자 페이지</title>
    <!-- Bootstrap -->
    <link href="css/dashBoard/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900%7CRoboto+Mono:400,300,700' rel='stylesheet'
        type='text/css'>
    <link href="css/dashBoard/busy.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
    <section data-mt-navigation-type="vertical" data-mt-nav-placement="left" data-theme-layout="wide-layout" data-theme-bg="bg1">
        <div id="mtapp-wrapper" class="mt-hide-lpanel" data-mt-device-type-type="desktop">
            <header id="mt-header" data-mt-lpanel-effect="shrink" data-mt-color-type="logo-bg3">
                <div class="mt-left-header">
                    <a class="nav-expand" href="#"><img class="img-responsive img-circle" alt="Image Here" src="img/dashBoard/1.jpg" ></a>
                    <a class="brandname" href="/buengbueng/dashIndex.do"><i class="fa fa-eercast"></i> <span><span class="text-slim">bueng</span> bueng</span></a>
                    <span class="mt-sidebar-toggle"><a href="#"></a></span>
                </div>
                <div class="mt-right-header" data-mt-position-type="relative" data-mt-color-type="header-bg3">
                    <span class="mt-sidebar-toggle"><a href="#"></a></span>
                    <ul class="right-navbar">
                        <li>
                            <a class="nav-expand" href="#"><img class="img-responsive img-circle" alt="Image Here" src="img/dashBoard/1.jpg" > Mr.Charles</a>
                        </li>
                    </ul>
                </div>
<!---------------------------------------------경계선-------------------------->                
            </header>
            <div id="mtapp-container" data-mt-color-type="lpanel-bg3" data-mt-lpanel-effect="shrink">
                <aside id="mt-left-panel" data-mt-position-type="absolute">
                    <div class="user-block clearfix">
                        <img class="img-responsive" alt="Image Here" src="img/dashBoard/1.jpg">
                        <div class="detail">
                            <strong>${sessionScope.loginId}</strong><span class="badge badge-danger m-left-xs ">접속</span>
                            <ul class="list-inline">
                                <li class=""><a href="/buengbueng/userInfoForm.do">정보 버튼</a></li>
                                <li class=""><a href="/buengbueng/logout.do" class="no-margin">로그아웃 버튼</a></li>
                                <li class=""><a href="/buengbueng/index.do" class="no-margin">사용자 페이지</a></li>
                            </ul>
                        </div>
                    </div>
                    <ul class="nav panel-list">
                        <li class="nav-level">메뉴</li>
                        <li class="mt-has-menu">
                            <a href="javascript:void(0)" class="rippler rippler-default">
                            <i class="fa fa-home"></i>
                            <span class="menu-text">회원관리</span>
                            <span class="selected"></span>
                        </a>
                            <ul class="mt-sub-menu">
                                <li>
                                    <a href="/buengbueng/dashtest.do" class="rippler rippler-default">
                                    <span class="menu-text">등급 관리</span>
                                    <span class="selected"></span>
                                </a>
                                </li>
                                <li>
                                    <a href="index2.html" class="rippler rippler-default">
                                    <span class="menu-text">입금 관리</span>
                                    <span class="label bg-warning">Update</span>
                                    <span class="selected"></span>
                                </a>
                                </li>
                                <li>
                                    <a href="index1.html" class="rippler rippler-default">
                                    <span class="menu-text">출금 관리</span>
                                    <span class="label bg-warning">Update</span>
                                    <span class="selected"></span>
                                </a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="grid.html" class="rippler rippler-default">
                            <i class="fa fa-th"></i>
                            <span class="menu-text">챗봇 관리</span>
                            <span class="selected"></span>
                        </a>
                        </li>
                        <li class="mt-has-menu">
                            <a href="javascript:void(0)" class="rippler rippler-default">
                            <i class="fa fa-desktop"></i>
                            <span class="menu-text">ERP 관리</span>
                            <span class="selected"></span>
                        </a>
                            <ul class="mt-sub-menu">
                                <li>
                                    <a href="ui-animation.html" class="rippler rippler-default">
                                    <span class="menu-text">ERP ver.1</span>
                                    <span class="selected"></span>
                                </a>
                                </li>
                                <li>
                                    <a href="ui-button.html" class="rippler rippler-default">
                                    <span class="menu-text">ERP ver.2</span>
                                    <span class="selected"></span>
                                </a>
                                </li>
                                <li>
                                    <a href="ui-icons.html" class="rippler rippler-default">
                                    <span class="menu-text">ERP ver.3</span>
                                    <span class="selected"></span>
                                </a>
                                </li>
                                <li>
                                    <a href="ui-tabs-accordion.html" class="rippler rippler-default">
                                    <span class="menu-text">ERP ver.4</span>
                                    <span class="selected"></span>
                                </a>
                                </li>
      				        </ul>
                        </li>
                        <li class="mt-has-menu">
                            <a href="javascript:void(0)">
                            <i class="fa fa-pencil-square-o"></i>
                            <span class="menu-text">페이지 관리</span>
                            <span class="selected"></span>
                        </a>
                            <ul class="mt-sub-menu">
                                <li>
                                    <a href="forms-layout.html" class="rippler rippler-default">
                                    <span class="menu-text">카테고리</span>
                                    <span class="selected"></span>
                                </a>
                                </li>
                            </ul>
                        </li>
                        <li class="mt-has-menu">
                            <a href="javascript:void(0)" class="rippler rippler-default">
                            <i class="fa fa-table"></i>
                            <span class="menu-text">고객센터</span>
                            <span class="selected"></span>
                        </a>
                            <ul class="mt-sub-menu">
                                <li>
                                    <a href="tables-simple.html" class="rippler rippler-default">
                                    <span class="menu-text">가맹 문의</span>
                                    <span class="selected"></span>
                                </a>
                                </li>
                                <li>
                                    <a href="tables-datatables.html" class="rippler rippler-default">
                                    <span class="menu-text">Q & A</span>
                                    <span class="selected"></span>
                                </a>
                                </li>
                                <li>
                                    <a href="tables-datatables.html" class="rippler rippler-default">
                                    <span class="menu-text">1:1 문의</span>
                                    <span class="selected"></span>
                                </a>
                                </li>
                            </ul>
                        </li>
                </aside>
         <!-- 중앙에 들어갈 내용!-->
         <section id="main-content">