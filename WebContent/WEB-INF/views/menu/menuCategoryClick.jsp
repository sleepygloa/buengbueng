<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    	
    	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css"  href="/buengbueng/css/bossERP/applyForSettlement.css">
	<link rel="stylesheet" type="text/css"  href="/buengbueng/css/erp.css">
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/buengbueng/js/menu/menu.js"></script>
	
  		
    	
    	
    	<table id="categoryMenu" class="menu_table">	
		<tr align="center">
<th width="200">카테고리</th>
			<th width="400">제 품</th>
			<th>제조사</th>
			<th>가 격</th>
			<th colspan="2" width="300">수정 / 삭제</th>
		</tr>			
	<c:forEach var="categoryMenu" items="${categoryMenuList}">
	
		<tr>
			<td>${categoryMenu.category}</td>
			<td>${categoryMenu.name}</td>
			<td>${categoryMenu.company}</td>
			<td>${categoryMenu.price}</td>
			<td width="150"><button  class="menu_stats_btn" onclick="window.location='menuModifyForm.do?name=${categoryMenu.name}&l_key=${categoryMenu.l_key}'">수정</button></td>
		<td width="150"><button  class="menu_stats_btn2" onclick="window.location='menuDeletePro.do?name=${categoryMenu.name}&l_key=${categoryMenu.l_key}'">삭제</button></td>
		
		</tr>
		</c:forEach>
		</table>