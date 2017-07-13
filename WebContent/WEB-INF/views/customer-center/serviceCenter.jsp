<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Insert title here</title>
      <style>
         #container {
            width:100%;
            margin:0 auto;
            text-align:center;
            float:left;
         }
         .tab {
            list-style: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
         }
         /* Float the list items side by side */
         .tab li {
            float: left;
         }
         /* Style the links inside the list items */
         .tab li a {
            display: inline-block;
            color: #000;
            text-align: center;
            text-decoration: none;
            padding: 14px 16px;
            font-size: 17px;
            transition:0.3s;
         }
         /* Style the tab content */
         .tabcontent {
            display: none;
            background-color:#fff;
            color:#fff;
         }
         ul.tab li.current{
            border-bottom:1.5px #555 solid;
            color: #222;
         }
         .tabcontent.current {
            display: block;
         }
         .tabTitlebox{border:1px #dcdcdc solid; text-align: center; margin-bottom:40px;}
         .tabTitlebox_in{margin:0 auto; width:425px;}
         .banner{width:100%; float:left; background: #999; height:290px; float:left; margin-bottom:30px;}
      </style>
      <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
   </head>
   
   <jsp:include page="../header.jsp" />  
   
   <body>
      <div class="banner">12</div>
   
      <div id="container">
         <div class="tabTitlebox">
            <div class="tabTitlebox_in">
               <ul class="tab">
               	<c:if test="${snum==1}">
	               	<li class="current" ><a href="franchiseQA.do?snum=1">가맹문의</a></li>
	                <li><a href="customerQA.do?snum=2">자주 묻는 질문</a></li>
	                <li><a href="oneQA.do?snum=3">1:1문의</a></li>
	                <li><a href="notice.do?snum=4&pageNum=1">공지사항</a></li>
               	</c:if>
               	<c:if test="${snum==2}">
	               	<li><a href="franchiseQA.do?snum=1">가맹문의</a></li>
	                <li class="current" ><a href="customerQA.do?snum=2">자주 묻는 질문</a></li>
	                <li><a href="oneQA.do?snum=3">1:1문의</a></li>
	                <li><a href="notice.do?snum=4&pageNum=1">공지사항</a></li>
               	</c:if>
               	<c:if test="${snum==3}">
	               	<li><a href="franchiseQA.do?snum=1">가맹문의</a></li>
	                <li><a href="customerQA.do?snum=2">자주 묻는 질문</a></li>
	                <li class="current" ><a href="oneQA.do?snum=3">1:1문의</a></li>
	                <li><a href="notice.do?snum=4&pageNum=1">공지사항</a></li>
               	</c:if>
               	<c:if test="${snum==4}">
	               	<li><a href="franchiseQA.do?snum=1">가맹문의</a></li>
	                <li><a href="customerQA.do?snum=2">자주 묻는 질문</a></li>
	                <li><a href="oneQA.do?snum=3">1:1문의</a></li>
	                <li class="current" ><a href="notice.do?snum=4&pageNum=1">공지사항</a></li>
               	</c:if>
               </ul>
            </div>
         </div>
   
         
