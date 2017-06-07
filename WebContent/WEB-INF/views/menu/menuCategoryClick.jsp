<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
	<c:forEach var="categoryMenu" items="${categoryMenuList}">
		<tr>
			<td>${categoryMenu.name}</td><td>${categoryMenu.company}</td><td>${categoryMenu.price}</td>
			<td><button id="order" value="${menu.name}">주 문</button></td>
		</tr>
		</c:forEach>