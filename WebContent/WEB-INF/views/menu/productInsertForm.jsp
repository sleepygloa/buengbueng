<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
    <head>
    <title>재 고 추 가</title>
    <link rel="stylesheet" type="text/css"  href="/buengbueng/css/bossERP/applyForSettlement.css">
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/buengbueng/js/menu/menu.js"></script>
    <script type="text/javascript" src="/buengbueng/js/menu/onemoreCheck.js"></script>
    </head>
    
    
    <body>
    
    <!-- HEADER TEMPLATE -->
	<jsp:include page="../erp_header.jsp" />
    
    
			<div class="ERP_Navigator">
			<ul>
				<li>ERP 관리</li>
				<li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
				<li>재고 관리 - 재고 추가</li>
			</ul>
		</div>
		
    <div class=" margin_bottom50">	
		<div class="col-xs-12-12">
	
	<div class="boss_con">
		<p style="font-size:25">재고 관리 - 재고 추가</p>
	<hr>
	
    	<form action="productInsertPro.do" method="post" name="productInsertForm" onsubmit="return menuInsert()">
    		<table class="dailySettlementList_table1">					
    			<tr>	
    			<td>제품명   <input type="hidden" name="l_key" value="${l_key}"></td>
    			<td>
    			
    			<select  style="border: none" name="name" style="width:200px; heigth:30px">
    				<option selected="selected">등록 메뉴 보기</option>
    				<c:forEach var="namelist" items="${nameList}" >
    				<option  value="${namelist.name}" >${namelist.name}</option>
    				</c:forEach>
    			</select>
    					
    			</td>
    			</tr>
    			
    			<tr>	
    			<td>바코드번호</td>
    			<td><input style="border: none" type="text" name="code" maxlength="13" placeholder="바코드 입력">	</td>
    			</tr>
    		
    			<tr>	
    			<td>유통기한</td>
    			<td><input style="border: none" type="text" name="last" placeholder="유통기한 입력">	</td>
    			</tr>    		
    		</table>

       	
    	<div>
    	<input class="applyForSettlement_button" type="submit" value="추 가"/>
    	<button class="applyForSettlement_button" onclick="window.location='product.do?l_key=${l_key}'">돌아가기</button> 
    	</div>
    	 </form>
    	</div>
    	</div>
    	</div>
    </body>