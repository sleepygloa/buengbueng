<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
    <head>
    <title>메 뉴 추 가</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    </head>
    
    
    <body>
    	<div>
    	<form action="menuInsertPro.do" method="post">
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
    			<tr><td><input type="submit" value="추 가"/></td>
    			</tr>    		
    		</table>
    		</form>
    	</div>
    </body>