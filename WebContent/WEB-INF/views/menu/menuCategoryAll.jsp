<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    			
			<tr>
			<td>제 품</td><td>제조사</td><td>가 격</td>
			</tr>
		
		<c:forEach var="menu" items="${menuList}">
		<tr>
			<td>${menu.name}</td>	<td>${menu.company}</td> 	<td>${menu.price}</td>
			
		</tr>
		</c:forEach>