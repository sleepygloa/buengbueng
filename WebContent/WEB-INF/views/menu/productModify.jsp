<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<body>
<div>

<table>
	<tr>
	<td>제품명</td><td>바코드</td><td>유통기한</td><td>판매유무</td><td>등록일</td>
	</tr>
	<c:forEach var="product" items="${productList}">
		<tr>
		<td>${product.name}
		<td>${product.code}
		<td>${product.lastday}
		<td>${product.salecheck}
		<td>${product.beginregist}
		<td><button onclick="window.location='productModifyForm.do?code=${product.code}&l_key=${l_key}'">수 정</button></td>
		</tr>
	</form>
	</c:forEach>
	
</table>

</div>
<div>
	<button onclick="window.location='product.do?l_key=${l_key}'">메뉴로 돌아가기</button>
</div>
</body>