<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${rentPList.size() != 0}">
	${rentProduct}<br/>
	<c:forEach var="rentPList" items="${rentPList}">
		<input type="checkbox" name="rentCode" value="${rentPList.code}" />
		${rentPList.code}<br/>
		<c:if test="${rentPList.rentCheck == 0}">	
			대여 가능
		</c:if>
		<c:if test="${rentPList.rentCheck == 1}">	
			대여 중
		</c:if>
		<br/>
		${rentPList.beginRegist}<br/>
		<input type="button" value="수정하기" onclick="modiRentProduct('${rentPList.code}');"/>
		<br/><br/>
	</c:forEach>
</c:if>
<c:if test="${rentPList.size() == 0}">
	${rentProduct} 목록에 등록된 대여물품이 없습니다.
</c:if>