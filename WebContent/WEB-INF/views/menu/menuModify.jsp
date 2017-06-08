<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<head>
	
</head>

<body>
<div>
<form action="menuModifyForm.do" method="post">
<table>
	<tr>
	<td>카테고리</td> <td>메뉴명</td> <td>회사명</td> <td>가격</td>
	</tr>
	<c:forEach var="menu" items="${menuList}">
	<tr>
	<td>${menu.category}</td>
	<td>${menu.name}</td>
	<td>${menu.company}</td>
	<td>${menu.price}</td>
	<td><button type="submit" name="name" value="${menu.name}">수정</button>
	</tr>
	</c:forEach>
</table>
</form>
</div>
<div>
	<button onclick="window.location='menu.do'">메뉴로 돌아가기</button>
</div>
</body>