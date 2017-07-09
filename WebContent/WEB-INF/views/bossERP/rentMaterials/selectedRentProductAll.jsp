<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${rentPList.size() != 0}">
	<ul>
		<c:forEach var="rentPList" items="${rentPList}">
		<li>
			<input type="checkbox" name="rentCode" value="${rentPList.code}" />&emsp;${rentPList.code}
			&emsp;
			<c:if test="${rentPList.rentCheck == 0}">	
				대여 가능
			</c:if>
			<c:if test="${rentPList.rentCheck == 1}">	
				대여 중
			</c:if>
			&emsp;
			${rentPList.beginRegist}
			&emsp;
			<input type="hidden" value="${b_key}" name="b_key"/>
			&emsp;
			<input type="button" value="수정" onclick="modiRentProduct('${rentPList.code}','${b_key}');"/>
		</li>
		</c:forEach>
	</ul>
</c:if>
<c:if test="${rentPList.size() == 0}">
	${rentProduct} 목록에 등록된 대여물품이 없습니다.
</c:if>