<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
    <head>
    <link rel="stylesheet" type="text/css"  href="/buengbueng/css/bossERP/applyForSettlement.css">
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
	
    <div class=" margin_bottom50">	
		<div class="col-xs-12-12">
	
	<div class="boss_con">
	<p style="font-size:25">메뉴 관리</p>
	<hr>
    	<form action="productModifyPro.do" method="post" onsubmit="return menuModify()" >
    		<table  class="dailySettlementList_table1">					
    			<tr>	
    			<td>제품명</td>
    			<td>
    			${pdto.name}
    			</td>
    			</tr>  			
    			
    			
    			<tr>	
    			<td>바코드번호</td>
    			<td><input type="text" name="code" maxlength="13" value="${pdto.code}">	
    				<input type="hidden" name="beforeCode" value="${pdto.code}">
    			</td>
    			</tr>
    		
    			<tr>	
    			<td>유통기한</td>
    			<td><input type="text" name="last" value="${pdto.lastday}">
    				<input type="hidden" name="beforeLastday" value="${pdto.lastday}">
    					<input type="hidden" name="l_key" value="${l_key}">
    					<input type="hidden" name="name" value="${name}">
    				</td>
    			</tr>
    
    			
    				
    		  		
    		</table>
    	<div>
    	<input class="applyForSettlement_button" type="submit" value="수 정"/>
    	<button  class="applyForSettlement_button" onclick="window.location='productModify.do?name=${name}&l_key=${l_key}'">돌아가기</button> 
    	</div>
    	</form>
    	</div>
    	</div>
    	</div>
    </body>