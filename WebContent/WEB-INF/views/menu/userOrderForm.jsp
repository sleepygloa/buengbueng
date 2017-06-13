<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <head>
    	<title>사용자 주문창</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/buengbueng/js/menu/menu.js"></script>
    </head>
    
    <body>
    <div>
		<button name="menuAll" onclick="useralls()">전 체</button>
	</div>
	
    
    	<div>
		<table>
		<tr>
		<c:forEach var="category" items="${categoryList}">
			<td><input type="button" name="${category}" onclick="usercategory('${category}')" value="${category}" /> </td>
		</c:forEach>
		</tr>	
		</table>
	</div>
	
	<div>

		<table >	
		<tr><td>
		<div id="usercategoryMenu"></div>	
		</td></tr>

	
		</table>
	</div>
	
    </body>