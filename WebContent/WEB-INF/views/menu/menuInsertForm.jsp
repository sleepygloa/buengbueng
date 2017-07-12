<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
    <head>
    <title>메 뉴 추 가</title>
    <link rel="stylesheet" type="text/css"  href="/buengbueng/css/bossERP/applyForSettlement.css">
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	</head>
    
    
    <body>
    
    <!-- HEADER TEMPLATE -->
	<jsp:include page="../erp_header.jsp" />
    <script type="text/javascript" src="/buengbueng/js/menu/onemoreCheck.js"></script>
    	<div class="ERP_Navigator">
			<ul>
				<li>ERP 관리</li>
				<li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
				<li>메뉴관리</li>
				<li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
				<li>메뉴추가</li>
			</ul>
		</div>
 	   
    	<div class="boss_con">
    	<p style="font-size:25">메뉴 관리 - 메뉴 추가</p>
		<hr>
    	
    	<div>
    		
    	
    	<form action="menuInsertPro.do" name="menuInsert" method="post" >
    		<table class="dailySettlementList_table1">

    								
    			<tr>	
    			<td>카테고리</td>
    			<td><input style="border:none" type="text" name="category" placeholder="카테고리 입력">	</td>
    			</tr>
    			
    			<tr>	
    			<td>제품명</td>
    			<td><input style="border:none" type="text" name="name" placeholder="제품명 입력">	</td>
    			</tr>
    		
    			<tr>	
    			<td>제조회사</td>
    			<td><input style="border:none" type="text" name="company" placeholder="제조회사 입력">	</td>
    			</tr>
     
    			<tr>	
    			<td>제품가격</td>
    			<td><input style="border:none" type="text" name="price" placeholder="제품가격 입력"></td>
    			</tr>
    							  		
    		</table>
    		
    		<div>
    	
    			<tr><td><input class="applyForSettlement_button" onclick="return menuInsertForm();" type="submit" value="추 가" />
    					<input type="hidden" name="l_key" value="${l_key}">
     			</td>
     			<td><input class="applyForSettlement_button" type="button" onclick="window.location='menu.do?l_key=${l_key}'" value="취 소"/></td></tr>
     		</div>
     	    
    		</form>
    	</div>
    	
    	<div>
 
    	</div>
    	
    </body>