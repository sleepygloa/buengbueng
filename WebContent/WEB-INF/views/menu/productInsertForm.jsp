<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
    <head>
    <title>재 고 추 가</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/buengbueng/js/menu/menu.js"></script>
    </head>
    
    
    <body>
    	<div>
    	<form action="productInsertPro.do" method="post" name="productInsertForm">
    		<table>					
    			<tr>	
    			<td>제품명</td>
    			<td>
    			<input type="text" name="name" placeholder="제품명 입력">
    			<select name="menu_select" onchange="productSelect();">
    				<option selected="selected">등록 메뉴 보기</option>
    				<c:forEach var="namelist" items="${nameList}" >
    				<option name="name" value="${namelist.name}" >${namelist.name}</option>
    				</c:forEach>
    			</select>
    				
    			</td>
    			</tr>
    			
    			<tr>	
    			<td>바코드번호</td>
    			<td><input type="text" name="code" placeholder="바코드 입력">	</td>
    			</tr>
    		
    			<tr>	
    			<td>유통기한</td>
    			<td><input type="text" name="last" placeholder="유통기한 입력">	</td>
    			</tr>
    			<tr><td><input type="submit" value="추 가"/></td>
    			</tr>    		
    		</table>
    		</form>
    	</div>
    </body>