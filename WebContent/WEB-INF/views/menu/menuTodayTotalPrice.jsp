<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
<c:if test="${check==1}">
<table>
	<tr>
	<td>메뉴 정산</td>
	</tr>
	<tr>
	<td>메뉴</td>
	<td>판매수량</td>
	<td>총판매가격</td>
	</tr>
	
	<c:forEach var="mtp" items="${menuTotalAccount}">
	<tr>
		<td>${mtp.menuname}</td>
		<td>${mtp.menucount}</td>
		<td>${mtp.totalprice}</td>
			</tr>
	</c:forEach>

	<tr>
	<td colspan="2">총액</td>
	<td>${sumprice}</td>
	</tr>
</table>
</c:if>
</div>
