<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
   <title>대여물품 관리</title>
   <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
   <script src="/buengbueng/js/bossERP/rentManage.js"></script>
   <link rel="stylesheet" type="text/css" href="/buengbueng/css/bossERP/applyForSettlement.css">
   <link rel="stylesheet" type="text/css" href="/buengbueng/css/ko/kocss.css">
   <link rel="stylesheet" type="text/css"  href="/buengbueng/css/erp.css">
   <script type="text/javascript">
   $(function () {
       $(".tab_content").hide();
       $(".tab_content:first").show();
       $("ul.tabs li:first").trigger('click');
      $("ul.tabs li:first").addClass("active").css("color", "blue");
       $("ul.tabs li").click(function () {
           $("ul.tabs li").removeClass("active").css("color", "#333");
           $(this).addClass("active").css("color", "blue");
           $(".tab_content").hide();
           var activeTab = $(this).attr("rel");
           $("#" + activeTab).fadeIn();
       });
   });
   </script>
</head>

<jsp:include page="../../erp_header.jsp" />

<body>
   <!-- 가맹점 선택하지 않는 경우 -->
   <c:if test="${result eq 'fail'}">
      가맹지점을 선택하여 주세요.
   </c:if>
   <c:if test="${result eq 'succ'}">
      <div class="ERP_Navigator">
            <ul>
            <li>ERP 관리</li>
            <li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
            <li>대여 관리</li>
            <li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
            <li>대여물품 관리</li>
         </ul>
      </div>
      
      <div class="boss_con">
         <p>PC방 좌석 현황</p>
         <hr>
         <input type="hidden" id="b_key" value="${sessionScope.b_key}"/>
         <div style="width:98%; margin-left:1%; float:left; height:40px;   ">
            <div style=" float:left; height:40px;">
               <input type="button"  class="rentManage_btn" value="물품목록 추가" id="addRent"  onclick="setInfoView();"/>
               <input type="button" class="rentManage_btn" value="물품목록 삭제" id="delRent"  />
               <input type="button" class="rentManage_btn" value="물품 추가" id="addRentProduct" onclick="setInfoView();"/>
               <input type="button" class="rentManage_btn" value="물품 삭제" id="delRentProduct"/>
            </div>
         </div>
      
         <div id="setInfo">
            <div class="pop">
                <button id="pop_close">x</button>
             </div>
            <div id="rentDiv"></div>
         </div>
        
         <div id="seatDisposeFirstDiv">
            <c:if test="${rentList.size() != 0}">
            
            
                   <ul class="tabs">
                      <c:set var="num" value="1"/>
                        <c:forEach var="rentList" items="${rentList}">
                          <li rel="tab${num}" onclick="selectedproductList('${rentList.rentProduct}','${sessionScope.b_key}','tab${num}');">
                            &emsp;<input type="checkbox" name="rentName" value="${rentList.rentProduct}"/>&emsp;${rentList.rentProduct}&emsp;
                            <input type="button" class="modiBtn" value="수정" onclick="modiRent('${rentList.rentProduct}','${sessionScope.b_key}')"/>&emsp;
                        </li>
                        <c:set var="num" value="${num+1}"/>
                     </c:forEach>
                   </ul>
                   <div class="tab_container">
                      <c:set var="num" value="1"/>
                         <c:forEach var="rentList" items="${rentList}">          
                              <div id="tab${num}" class="tab_content"></div>
                              <c:set var="num" value="${num+1}"/>
                        </c:forEach>
                  </div>
      
            </c:if>
            <c:if test="${rentList.size() == 0}">
               <table border="1" class="dailySettlementList_table">
                  <tr class="dailySettlementList_NoCount">
                     <td colspan="9">
                        <p>
                        <img src="/buengbueng/img/bossERP/bg_alert.gif" width="40" height="40">
                           조회결과가 없습니다.
                        </p>
                     </td>
                  </tr>
               </table>
            </c:if>
         </div>
      </div>
   </c:if>
</body>