<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div> 노드 상황판  : 
	<c:if test="${nodeExeCheck == 0}"><img src="/buengbueng/img/chatbot/nodeEnd.png" width="20px" /></c:if>
	<c:if test="${nodeExeCheck == 1}"><img src="/buengbueng/img/chatbot/nodeStart.png" width="20px" /></c:if> 
	
	<c:if test="${nodeExeCheck==0}">
		<button onclick="nodeStart()" >노드 켜기</button></c:if>
	<c:if test="${nodeExeCheck==1}">
		<button onclick="nodeEnd()" >노드 끄기</button></c:if> 
</div>
