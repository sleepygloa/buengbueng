<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
  		
  		<table id="categoryMenu" class="dailySettlementList_table">	
		<tr align="center">
		<td> <p>카테고리</p></td><td><p>제 품</p></td><td><p>제조사</p></td><td><p>가 격</p></td><td colspan="2"><p>수정 / 삭제</p></td>
		</tr>			
    	
  
		<c:forEach var="menu" items="${menuList}">
		<tr>
		<td>${menu.category}</td><td>${menu.name}</td><td>${menu.company}</td><td>${menu.price}</td>
		<td width="100"><button style="background-color: white; border: none; font-weight: 900;" onclick="window.location='menuModifyForm.do?name=${menu.name}&l_key=${menu.l_key}'">수정</button></td>
		<td width="100"><button style="background-color: white; border: none; font-weight: 900;" onclick="window.location='menuDeletePro.do?name=${menu.name}&l_key=${menu.l_key}'">삭제</button></td>
		</tr>
		</c:forEach>
		
		</table>