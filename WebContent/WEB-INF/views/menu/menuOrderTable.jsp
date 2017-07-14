<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <head>
    	<link rel="stylesheet" type="text/css"  href="/buengbueng/css/bossERP/applyForSettlement.css">
    		<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    	<script type="text/javascript" src="/buengbueng/js/menu/menu.js"></script>
    	<script type="text/javascript" src="/buengbueng/js/menu/menuStatus.js"></script>
    	
    </head>
    
    
    	
	
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

    	<c:forEach var="cl" items="${canList}">

    		<tr>
    		<td>${cl.num}</td><td>${cl.id}</td><td>${cl.menuname}</td><td>${cl.ordertime}</td><td>${cl.ordermoney}&#8361;</td>
    			<c:if test="${cl.orderstatus==1}">
    			<td><div class="menuOrderListForm_stats">주문 중</div></td>
    			<td>
    			<button class="menuOrderListForm_stats2" onclick="window.location='menuBarcodeCheck.do?menuname=${cl.menuname}&num=${cl.num}&l_key=${l_key}'">주문승인</button>
    			</td></c:if>
    			<c:if test="${cl.orderstatus==2}">
    			<td><div class="menuOrderListForm_stats2">주문완료</div></td>  <td>ㆍ</td>
             </c:if>  
    			<c:if test="${cl.orderstatus==3}">
    			<td><div class="menuOrderListForm_stats3">주문취소</div></td>  <td>ㆍ</td>
             </c:if>  
    			<c:if test="${cl.orderstatus==4}">
    			<td><div class="menuOrderListForm_stats4">환불 요청 중</div></td>
    			<td>
    			<button class="menuOrderListForm_stats4" onclick="window.location='menuOrderRefund.do?ordermoney=${cl.ordermoney}&code=${cl.code}&orderstatus=${cl.orderstatus}&menuname=${cl.menuname}&num=${cl.num}&l_key=${l_key}&id=${cl.id}'">환불 승인</button>
    			<button class="menuOrderListForm_stats4" onclick="window.location='menuOrderNotRefund.do?ordermoney=${cl.ordermoney}&code=${cl.code}&orderstatus=${cl.orderstatus}&menuname=${cl.menuname}&num=${cl.num}&l_key=${l_key}&id=${cl.id}'">환불 거절</button>
    			</td></c:if>
    			<c:if test="${cl.orderstatus==5}">
    			<td><div class="menuOrderListForm_stats4">환불 승인</div></td>   <td>ㆍ</td>
             </c:if>
    			<c:if test="${cl.orderstatus==6}">
    			<td><div class="menuOrderListForm_stats4">환불 거절</div></td>   <td>ㆍ</td>
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