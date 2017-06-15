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
<jsp:include page="../header.jsp" />

	<!-- 페이지 제목 -->
	<div class=" margin_bottom50">
		<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
			<h3>ERP 메뉴관리 페이지입니다.</h3>
		</div>
	</div>
	
	
	
	
<div class=" margin_bottom50">	
		<div class="col-xs-12-12">
	
	
	
   	<div>
		<button onclick="window.location='product.do'">재 고</button>
	</div>

	<div>
		<button onclick="window.location='menuInsertForm.do?l_key=${l_key}&name=${name}'">메 뉴 추 가</button>
	</div>
	
	<div>
		<button onclick="window.location='menuModify.do?l_key=${l_key}&name=${name}'">메 뉴 수 정</button>
	</div>
	
	<div>
		<button onclick="window.location='menuDeleteForm.do?l_key=${l_key}&name=${name}'">메 뉴 삭 제</button>
	</div>
	<div>
		<button onclick="alls('${l_key}')">전 체</button>
	</div>
	
	
	<div>
		<table>
		<tr>
		<c:forEach var="category" items="${categoryList}">
			<td><input type="button" name="${category}" onclick="category('${category}','${l_key}')" value="${category}" /> </td>
		</c:forEach>
		</tr>	
		</table>
	</div>
	
	<div>

		<table >	
		<tr><td>
		<div id="categoryMenu"></div>	
		</td></tr>

	
		</table>
	</div>
	</div>
	</div>

	
</body>