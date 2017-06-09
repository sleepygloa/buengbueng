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
	<td>제품명</td><td>바코드</td><td>유통기한</td><td>판매유무</td><td>등록일</td>
	</tr>
	<c:forEach var="product" items="${productList}">
	<tr>
	<td>${product.name}</td>
	<td>${product.code}</td>
	<td>${product.lastday}</td>
	<td>${product.salecheck}</td>
	<td>${product.beginregist}</td>
	<td><button type="submit" name="code" value="${product.code}">수정</button>
	</tr>
	</c:forEach>
</table>
</form>
</div>
<div>
	<button onclick="window.location='menu.do'">메뉴로 돌아가기</button>
</div>
</body>