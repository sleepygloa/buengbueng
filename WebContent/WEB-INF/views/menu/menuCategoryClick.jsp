<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    	<tr>
			<td>제 품</td><td>제조사</td><td>가 격</td>
			</tr>
		
    
	<c:forEach var="categoryMenu" items="${categoryMenuList}">
	
		<tr>
			<td>${categoryMenu.name}</td>
			<td>${categoryMenu.company}</td>
			<td>${categoryMenu.price}</td>
			<td><button id="order" value="${menu.name}"onclick="order('${menu.name}')">주 문</button></td>
		</tr>
		</c:forEach>