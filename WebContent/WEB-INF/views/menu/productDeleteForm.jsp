<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<head>
	<title>재고삭제</title>
	<script type="text/javascript" src="/buengbueng/js/menu/onemoreCheck.js"></script>
</head>

<body>

    <!-- HEADER TEMPLATE -->
	<jsp:include page="/WEB-INF/views/header.jsp" />
    

<div>
<form action="productDeletePro.do" method="post" onsubmit="return menuDelete()">
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
	<td><button type="submit" name="code" value="${product.code}">삭제</button>
	</tr>
	</c:forEach>
	<input type="hidden" name="l_key" value="${l_key}"/>
</table>
</form>
</div>
<div>
	<button onclick="window.location='product.do?l_key=${l_key}'">돌아가기</button>
</div>
</body>