<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <head>
    <title>메 뉴 수 정</title>
    <link rel="stylesheet" type="text/css"  href="/buengbueng/css/bossERP/applyForSettlement.css">
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
				<li>메뉴관리</li>
				<li><i class="fa fa-angle-double-right" aria-hidden="true"></i></li>
				<li>메뉴수정</li>
			</ul>
		</div>
	
	<div class="boss_con">
	
	<p style="font-size:25">메뉴 관리 - 메뉴 수정</p>
	<hr>
    	<div>
    	<form action="menuModifyPro.do" method="post" name="menuModify" >
    		<table class="dailySettlementList_table1">					
    			<tr>	
    			<td>카테고리</td>
    			<td><input type="text" style="border:none" name="category" placeholder="카테고리 입력" value="${mdto.category}" >	</td>
    			</tr>
    			
    			<tr>	
    			<td>제품명</td>
    			<td><input type="text" style="border:none" name="name" value="${mdto.name}"/>
    				<input type="hidden" name="beforeName" value="${mdto.name}"></td>
    			</tr>
    		
    			<tr>	
    			<td>제조회사</td>
    			<td><input type="text" style="border:none" name="company" placeholder="제조회사 입력" value="${mdto.company}">	</td>
    			</tr>
     
    			<tr>	
    			<td>제품가격</td>
    			<td><input type="hidden" style="border:none" name="l_key" value="${l_key}"/>
    			<input type="text" style="border:none" name="price" placeholder="제품가격 입력" value="${mdto.price}"></td>
    			</tr>
    		</table>
    		
    		<div>
    			
    			<tr><td><input class="applyForSettlement_button" onclick="return menuModifyForm();" type="submit" value="수 정"/></td>
    			<td><input class="applyForSettlement_button" type="button" onclick="window.location='menu.do?l_key=${l_key}'" value="취 소"/></td>
    			</tr>    		
    		
    		</div>
    		
    		</form>
    	</div>
    </div>
    </body>