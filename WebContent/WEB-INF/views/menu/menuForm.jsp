<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <head>
	<title>메 뉴</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	
	<script>
	
		function category(category){
				$.ajax({
					url:"menuCategoryClick.do",
					type:"post",
					data: {category: category},
					success:function(data){
						$("#categoryMenu").html(data);
					}
				});
		}
		
		function alls(){
			$.ajax({
				url:"menuCategoryAll.do",
				type:"post",
				success:function(data){
					$("#categoryMenu").html(data);
				}
			});
		}
		
		function order(name){
			$.ajax({
				url:"menuOrderListForm.do",
				type:"post",
				data: {name: name},
				success:function(data){
					$("#,").html(data);
				}
			});
		}
		
	</script>
	
	
</head>

<body>

   	<div>
		<button onclick="window.location='product.do'">재 고</button>
	</div>

	<div>
		<button onclick="window.location='menuInsertForm.do'">메 뉴 추 가</button>
	</div>
	
	<div>
		<button onclick="window.location='menuModify.do'">메 뉴 수 정</button>
	</div>
	
	<div>
		<button onclick="window.location='menuDeleteForm.do'">메 뉴 삭 제</button>
	</div>
	<div>
		<button name="menuAll" onclick="alls()">전 체</button>
	</div>
	
	
	<div>
		<table>
		<tr>
		<c:forEach var="category" items="${categoryList}">
			<td><input type="button" name="${category}" onclick="category('${category}')" value="${category}" /> </td>
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
	
</body>