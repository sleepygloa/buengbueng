<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <head>
    <title>메 뉴 재 고</title>
  <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    </head>
    
    <body>
    
    <div>
		<button onclick="window.location='productInsertForm.do'">재 고 등 록</button>
	</div>
	
   	<div>
		<button onclick="window.location='productModify.do'">재 고 수 정</button>
	</div>
	
	<div>
		<button onclick="window.location='productDeleteForm.do'">재 고 삭 제</button>
	</div>
	
	<div>
		<table>
		<tr><td>제품명</td><td>바코드</td><td>유통기한</td><td>판매유무</td><td>등록일</td></tr>
		<c:forEach var="pl" items="${productList}">
			<tr>
			<td>${pl.name}</td>
			<td>${pl.code}</td>
			<td>${pl.lastday}</td>
			<td>${pl.salecheck}</td>
			<td>${pl.beginregist}</td>
			</tr>
			</c:forEach> 
		</table>
	
	</div>
    <div>
		<button onclick="window.location='menu.do'">메뉴로 돌아가기</button>
	</div>
    
  
    
    </body>