<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <head>
	<title>메 뉴</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script>

	$(document).ready(
			function(){
				$(".category").click(function(){
					$.ajax({
						url:"menuCategoryClick.do",
						type:"post",
						data: {category: $(".category").value},
						success:function(data){
							$("#categoryMenu").html(data);
						}
					});
				});	
		});
	</script>
	
	
</head>

<body>
	<div>
		<button onclick="window.location='menuInsertForm.do'">메 뉴 추 가</button>
	</div>
	
	<div>
		<button onclick="window.location='menuDeleteForm.do'">메 뉴 삭 제</button>
	</div>
	
	<div>
		<table>
		<tr>
		<c:forEach var="category" items="${categoryList}">
			<td><input type="button" name="${category}" class="category" value="${category}" /> </td>
		</c:forEach>
		</tr>	
		</table>
	</div>
	
	<div>
		<table>
			<tr>
			<td>제 품</td><td>제조사</td><td>가 격</td>
			</tr>
		
		<tr><td>
		<div id="categoryMenu"></div>	
		</td></tr>
		
		<c:forEach var="menu" items="${menuList}">
		<tr>
			<td>${menu.name}</td>	<td>${menu.company}</td> 	<td>${menu.price}</td>
			<td><button id="order" value="${menu.name}">주 문</button></td>
		</tr>
		</c:forEach>
		
		
		
		</table>
	</div>
	
</body>