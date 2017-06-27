<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<option>가맹점 선택</option>
<c:forEach var="list" items="${flist}">
<option value="${list.b_key}">${list.b_name}</option>					
</c:forEach>