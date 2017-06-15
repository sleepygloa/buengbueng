<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
    <head>
    <title>재 고 수 정</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/buengbueng/js/menu/menu.js"></script>
    </head>
    
    
    <body>
    	<div>
    	<form action="productModifyPro.do" method="post" name="productModifyForm">
    		<table>					
    			<tr>	
    			<td>제품명</td>
    			<td>
    			${pdto.name}
    			</td>
    			</tr>  			
    			
    			
    			<tr>	
    			<td>바코드번호</td>
    			<td><input type="text" name="code" value="${pdto.code}">	
    				<input type="hidden" name="beforeCode" value="${pdto.code}">
    			</td>
    			</tr>
    		
    			<tr>	
    			<td>유통기한</td>
    			<td><input type="text" name="last" value="${pdto.lastday}">
    				<input type="hidden" name="beforeLastday" value="${pdto.lastday}">
    				</td>
    			</tr>
    
    			<tr><td><input type="submit" value="수 정"/>
    					<input type="hidden" name="l_key" value="${l_key}">
    				</td>
    			</tr>    		
    		</table>
    		</form>
    	</div>
    </body>