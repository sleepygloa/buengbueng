<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                  <li class="current" data-tab="tab1"><a href="#">가맹문의</a></li>
                  <li data-tab="tab2"><a href="#">자주 묻는 질문</a></li>
                  <li data-tab="tab3"><a href="#">1:1문의</a></li>
                  <li data-tab="tab4"><a href="#">공지사항</a></li>
               </ul>
            </div>
         </div>
   
         <div id="tab1" class="tabcontent current">
			<jsp:include page="../customer-center/franchiseList.jsp" />
         </div>
   
         <div id="tab2" class="tabcontent">
         	<jsp:include page="../customer-center/customerList.jsp" />
         </div>
   
         <div id="tab3" class="tabcontent">
            <jsp:include page="../customer-center/oneList.jsp" />
         </div>
   
         <div id="tab4" class="tabcontent">
            <jsp:include page="../customer-center/noticeList.jsp" />
         </div>
      </div>
   
      <script>
         $(function() {
            $('ul.tab li').click(function() {
               var activeTab = $(this).attr('data-tab');
               $('ul.tab li').removeClass('current');
               $('.tabcontent').removeClass('current');
               $(this).addClass('current');
               $('#' + activeTab).addClass('current');
            })
         });
      </script>
   </body>
</html>