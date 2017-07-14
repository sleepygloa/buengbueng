<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <head>
       <title>주문 현황</title>
       <link rel="stylesheet" type="text/css"  href="/buengbueng/css/bossERP/applyForSettlement.css">
         <link rel="stylesheet" type="text/css"  href="/buengbueng/css/erp.css">
         <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
       <script type="text/javascript" src="/buengbueng/js/menu/menu.js"></script>
       <script type="text/javascript" src="/buengbueng/js/menu/menuStatus.js"></script>
       
    </head>
    
    <body>    
    
    <!-- HEADER TEMPLATE -->
   <jsp:include page="../erp_header.jsp" />
    
          <div class="ERP_Navigator">
         <ul>
            <li>ERP 관리</li>
            <li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
            <li>주문 관리</li>
            <li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
            <li>가맹점 주문현황</li>
         </ul>
      </div>
   
    
<div class="bossMenuStatus">
   <div class="boss_con">
   <p>주문현황 리스트</p>
   <hr>

   <input type="hidden" id="l_key" value="${l_key}" />
  
      <table class="menu_table">
       <tr>
          <th>주문번호</th>
          <th>주문자 아이디</th>
          <th>주문명</th>
          <th>주문 시간</th>
          <th>주문 금액</th>
          <th>현황</th>
          <th>확인</th>
       </tr>

       <c:forEach var="ol" items="${orderList}">

          <tr>
             <td>${ol.num}</td>
             <td>${ol.id}</td>
             <td>${ol.menuname}</td>
             <td>${ol.ordertime}</td>
             <td>${ol.ordermoney}&#8361;</td>
             <c:if test="${ol.orderstatus==1}">
                <td><div class="menuOrderListForm_stats">주문 중</div></td>
                <td>
                   <button class="menuOrderListForm_stats2" onclick="window.location='menuBarcodeCheck.do?menuname=${ol.menuname}&num=${ol.num}&l_key=${l_key}'">주문승인</button></td>
             </c:if>
             <c:if test="${ol.orderstatus==2}">
                <td><div class="menuOrderListForm_stats2">주문 완료</div></td>
                <td>ㆍ</td>
             </c:if>      
             <c:if test="${ol.orderstatus==3}">
                <td><div class="menuOrderListForm_stats3">주문 취소</div></td>
                <td>ㆍ</td>
             </c:if>
             <c:if test="${ol.orderstatus==4}">
                <td><div class="menuOrderListForm_stats4">환불 요청 중</div></td>
                <td>
                   <button class="menuOrderListForm_stats4" onclick="window.location='menuOrderRefund.do?ordermoney=${ol.ordermoney}&code=${ol.code}&orderstatus=${ol.orderstatus}&menuname=${ol.menuname}&num=${ol.num}&l_key=${l_key}&id=${ol.id}'">환불 승인</button>
                   <button class="menuOrderListForm_stats4" onclick="window.location='menuOrderNotRefund.do?ordermoney=${ol.ordermoney}&code=${ol.code}&orderstatus=${ol.orderstatus}&menuname=${ol.menuname}&num=${ol.num}&l_key=${l_key}&id=${ol.id}'">환불 거절</button>
                </td>
             </c:if>
             <c:if test="${ol.orderstatus==5}">
                <td><div class="menuOrderListForm_stats4">환불 승인</div></td>
                <td>ㆍ</td>
             </c:if>
             <c:if test="${ol.orderstatus==6}">
                <td><div class="menuOrderListForm_stats4">환불 거절</div></td>
                <td>ㆍ</td>
             </c:if>
          </tr>       
      </c:forEach>
      </table>
      
   
  </div>  
   <div class="boss_con">
   <p>주문처리 완료 리스트</p>
   <hr>

   <input type="hidden" id="l_key" value="${l_key}" />
  
       <table class="menu_table">
       <tr>
	       <th>주문번호</th>
	       <th>주문자 아이디</th>
	       <th>주문명</th>
	       <th>주문 시간</th>
	       <th>주문 금액</th>
	       <th>현황</th>
       </tr>

       <c:forEach var="ctl" items="${cantList}">

          <tr>
          <td>${ctl.num}</td>
          <td>${ctl.id}</td>
          <td>${ctl.menuname}</td>
          <td>${ctl.ordertime}</td>
          <td>${ctl.ordermoney}&#8361;</td>
            <c:if test="${ctl.orderstatus==1}">
             	<td><div class="menuOrderListForm_stats2">주문 중</div></td>
          		<td>
             		<button class="menuOrderListForm_stats2" onclick="window.location='menuBarcodeCheck.do?menuname=${ctl.menuname}&num=${ctl.num}&l_key=${l_key}'">주문승인</button>
             	</td>	 
          	</c:if>
            <c:if test="${ctl.orderstatus==2}">
            	<td><div class="menuOrderListForm_stats2">주문완료</div></td>
            </c:if>      
            <c:if test="${ctl.orderstatus==3}">
            	<td><div class="menuOrderListForm_stats3">주문취소</div></td>
            </c:if>
            <c:if test="${ctl.orderstatus==4}">
            	<td><div class="menuOrderListForm_stats4">환불 요청 중</div></td>
	            <td>
		            <button class="menuOrderListForm_stats4" onclick="window.location='menuOrderRefund.do?ordermoney=${ctl.ordermoney}&code=${ctl.code}&orderstatus=${ctl.orderstatus}&menuname=${ctl.menuname}&num=${ctl.num}&l_key=${l_key}&id=${ctl.id}'">환불 승인</button>
		            <button class="menuOrderListForm_stats4" onclick="window.location='menuOrderNotRefund.do?ordermoney=${ctl.ordermoney}&code=${ctl.code}&orderstatus=${ctl.orderstatus}&menuname=${ctl.menuname}&num=${ctl.num}&l_key=${l_key}&id=${ctl.id}'">환불 거절</button>
	            </td>
            </c:if>
            <c:if test="${ctl.orderstatus==5}">
            	<td><div class="menuOrderListForm_stats4">환불 승인</div></td>
            </c:if>
            <c:if test="${ctl.orderstatus==6}">
            	<td><div class="menuOrderListForm_stats3">환불 거절</div></td>            
            </c:if>
          
          
          </tr>       
         </c:forEach>
       </table>
        </div>
  
  </div>
</body>