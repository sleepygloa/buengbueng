<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<script type="text/javascript" src="/buengbueng/js/menu/menuStatus.js"></script>


<c:forEach var="canlist" items="${canList}">
				<tr>
					<td>${canlist.num}</td>
					<td>${canlist.id}</td>
					<td>${canlist.menuname}</td>
					<td>${canlist.ordermoney}</td>
					
						<c:if test="${canlist.orderstatus==1}">
							<td style="background-color:#FFA7A7">주문 중</td>
						</c:if>
						<c:if test="${canlist.orderstatus==4}">
							<td style="background-color:#FFE08C ">환불 요청 중</td>
						</c:if>
					
						</tr>
			</c:forEach>