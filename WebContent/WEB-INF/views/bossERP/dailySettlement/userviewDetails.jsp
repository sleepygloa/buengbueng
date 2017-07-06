<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"  href="/buengbueng/css/bossERP/viewDetails.css">
		<title>상품내역 상세보기</title>
	</head>
	<body>
		<div class="wrap">
			<div class="title_box">
				<h3>상품주문내역 상세리스트</h3>
			</div>
			<div class="menu_container">
			<c:forEach var="name" items="${menunameList}" varStatus="stat">
					<div class="menu_container_piece">
					<div class="menu_container_piece2"><p>${name} X ${countList[stat.index]}</p></div>
					<div class="menu_container_piece2"><p>${totalpriceList[stat.index]}원</p></div>
					</div>
			</c:forEach>
			
					
						<div class="menu_container_piece">
							<div class="menu_container_piece2"><p>총 합계</p></div>
							<div class="menu_container_piece2"><p>${total}원</p></div>
						</div>
				
					
					
					
			</div>
		</div>
	</body>
</html>
