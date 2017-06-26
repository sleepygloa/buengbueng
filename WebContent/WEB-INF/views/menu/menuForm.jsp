<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <head>
	<title>메 뉴</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/buengbueng/js/menu/menu.js"></script>
	</head>

<body>
<!-- HEADER TEMPLATE -->
	<jsp:include page="/WEB-INF/views/header.jsp" />

	<!-- 페이지 제목 -->
	<div class=" margin_bottom50">
		<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
			<h3>ERP 메뉴관리 페이지입니다.</h3>
		</div>
	</div>
	
	
	
	
<div class=" margin_bottom50">	
		<div class="col-xs-12-12">
	
	<div>
		<table>
		<tr>
		<td>
		<button onclick="window.location='menuInsertForm.do?l_key=${l_key}'">메 뉴 추 가</button>
		</td>
		
		<td>
		<button onclick="window.location='menuModify.do?l_key=${l_key}'">메 뉴 수 정</button>
		</td>
	
		<td>
		<button onclick="window.location='menuDeleteForm.do?l_key=${l_key}'">메 뉴 삭 제</button>
		</td>

	</table>
	</div>
	
	
	<div>
		<table>
		<tr><td><button onclick="alls('${l_key}')">전 체</button></td>
		<c:forEach var="category" items="${categoryList}">
			<td><input type="button" name="${category}" onclick="category('${category}','${l_key}')" value="${category}" /> </td>
		</c:forEach>
		</tr>	
		</table>
	</div>
	
	<div>

		<table >	
		<tr><td>
		<div id="categoryMenu">
		
				
		<tr>
		<td>카테고리</td><td>제 품</td><td>제조사</td><td>가 격</td>
		</tr>
		
				
		<c:forEach var="menu" items="${menuList}">
		<tr>
		<td>${menu.category}</td>			<td>${menu.name}</td>	<td>${menu.company}</td> 	<td>${menu.price}</td>
			
		</tr>
		</c:forEach>
		
		</div>	
		</td></tr>

	
		</table>
	</div>
	</div>
	</div>

	
</body>