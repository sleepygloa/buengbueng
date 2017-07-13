<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
    <head>
    <link rel="stylesheet" type="text/css"  href="/buengbueng/css/bossERP/applyForSettlement.css">
    <link rel="stylesheet" type="text/css"  href="/buengbueng/css/erp.css">
    <title>재 고 수 정</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/buengbueng/js/menu/onemoreCheck.js"></script>
    
    </head>
    
    
    <body>
    
    <!-- HEADER TEMPLATE -->
	<jsp:include page="../erp_header.jsp" />
    
    
			<div class="ERP_Navigator">
			<ul>
				<li>ERP 관리</li>
				<li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
				<li>재고 관리 - 재고 수정</li>
			</ul>
		</div>
	

	
	<div class="boss_con">
	<p>재고 수정</p>
	<hr>
    	<form action="productModifyPro.do" method="post" name="productModify" >
    		<table class="menu_table">					
    			<tr>	
	    			<th>제품명</th>
	    			<td style="float: left; margin-left: 2%; border: none; line-height: 4;">${pdto.name}</td>
    			</tr>  			
    			
    			
    			<tr>	
	    			<th>바코드번호</th>
	    			<td class="productModifyForm_td">
	    				<input type="text" name="code" maxlength="13" value="${pdto.code}">	
	    				<input type="hidden" name="beforeCode" value="${pdto.code}">
	    			</td>
    			</tr>
    		
    			<tr>	
    			<th>유통기한</th>
	    			<td class="productModifyForm_td">
	    				<input type="text" maxlength="10" name="last" value="${pdto.lastday}"><span>ex)xxxx-xx-xx</span>
	    				<input type="hidden" name="beforeLastday" value="${pdto.lastday}">
	    				<input type="hidden" name="l_key" value="${l_key}">
	    				<input type="hidden" name="name" value="${name}">
	    			</td>
    			</tr>
    
    			
    				
    		  		
    		</table>
    	<div>
    	<input class="applyForSettlement_button" type="submit" onclick="return menuModify()" value="수 정"/>
    	<input  class="applyForSettlement_button" type="button" onclick="window.location='productModify.do?name=${name}&l_key=${l_key}'" value="취 소"/> 
    	</div>
    	</form>
    	</div>
    </body>