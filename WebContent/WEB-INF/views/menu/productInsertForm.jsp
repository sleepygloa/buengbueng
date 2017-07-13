<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
    <head>
    <title>재 고 추 가</title>
    <link rel="stylesheet" type="text/css"  href="/buengbueng/css/bossERP/applyForSettlement.css">
    <link rel="stylesheet" type="text/css"  href="/buengbueng/css/erp.css">
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
	
	<div class="boss_con">
		<p>재고 관리 - 재고 추가</p>
	<hr>
	
    	<form action="productInsertPro.do" method="post" name="productInsert" >
    		<table class="menu_table">					
    			<tr>	
    			<td>제품명   <input type="hidden" name="l_key" value="${l_key}"></td>
    			<td class="productModifyForm_td">
    			
    			<select style="float:left; margin-left:1%; height:35px; border:1px #eee solid;" name="name">
    				<option selected="selected">등록 메뉴 보기</option>
    				<c:forEach var="namelist" items="${nameList}" >
    				<option  value="${namelist.name}" >${namelist.name}</option>
    				</c:forEach>
    			</select>
    					
    			</td>
    			</tr>
    			
    			<tr>	
    			<td>바코드번호</td>
    			<td class="productModifyForm_td"><input type="text" name="code" maxlength="13" placeholder="바코드 입력">	</td>
    			</tr>
    		
    			<tr>	
    			<td>유통기한</td>
    			<td class="productModifyForm_td"><input type="text" name="last" maxlength="10" placeholder="유통기한 입력">	<span>ex)xxxx-xx-xx</span></td>
    			
    			</tr>    		
    		</table>

       	
    	<div>
    	<input class="applyForSettlement_button" type="submit" onclick="return productInsertForm();" value="추 가"/>
    	<input class="applyForSettlement_button" type="button" onclick="window.location='product.do?l_key=${l_key}'" value="돌아가기"/>
    	</div>
    	</form>
    	
    	</div>
    	
    	
    </body>