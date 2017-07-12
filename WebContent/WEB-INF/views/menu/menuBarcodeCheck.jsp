<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <head>
     <link rel="stylesheet" type="text/css"  href="/buengbueng/css/bossERP/applyForSettlement.css">
     <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
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
		
	<div class=" margin_bottom50">	
		<div class="col-xs-12-12">
	
	<div class="boss_con">
	<p style="font-size:25"> 바코드 입력</p>
	<hr>
	
	
	
    <div>
    <form action="menuOrderComplete.do" method="post">
    	<input type="text" name="barcode" maxlength="13" style="width:3s00px; height: 50px; border: none" placeholder="바코드를 입력해주세요"/>
    	<input type="hidden" name="name" value="${name}">
    	<input type="hidden" name="num" value="${num}">
    	<input type="hidden" name="l_key" value="${l_key}"/>
    	<input class="applyForSettlement_button1" type="submit" value="승 인">
	</form>
    </div>
    </div>
    </div>
    </div>
    </body>