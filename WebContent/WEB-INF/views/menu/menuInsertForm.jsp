<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
    <head>
    <title>메 뉴 추 가</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/buengbueng/js/menu/onemoreCheck.js"></script>
    </head>
    
    
    <body>
    
    <!-- HEADER TEMPLATE -->
	<jsp:include page="/WEB-INF/views/header.jsp" />
    
    	<div>
    	<form action="menuInsertPro.do" method="post" onsubmit="return menuInsert()">
    		<table>					
    			<tr>	
    			<td>카테고리</td>
    			<td><input type="text" name="category" placeholder="카테고리 입력">	</td>
    			</tr>
    			
    			<tr>	
    			<td>제품명</td>
    			<td><input type="text" name="name" placeholder="제품명 입력">	</td>
    			</tr>
    		
    			<tr>	
    			<td>제조회사</td>
    			<td><input type="text" name="company" placeholder="제조회사 입력">	</td>
    			</tr>
     
    			<tr>	
    			<td>제품가격</td>
    			<td><input type="text" name="price" placeholder="제품가격 입력"></td>
    			</tr>
    			<tr><td><input type="submit" value="추 가" />
    					<input type="hidden" name="l_key" value="${l_key}">
    					
    			</td>
    			</tr>    					  		
    		</table>
    		</form>
    	</div>
    	
    	<div>
    	<button onclick="window.location='menu.do?l_key=${l_key}'">메뉴로 돌아가기</button> 
    	</div>
    	
    </body>