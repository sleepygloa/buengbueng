<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${rentList.size() != 0}">
	<input type="button" value="대여물품 추가" id="addRentProduct"/>&emsp;&emsp;&emsp;
	<input type="button" value="대여물품삭제" id="delRentProduct"/>&emsp;&emsp;&emsp;
	<br/><br/>
	<c:forEach var="rentList" items="${rentList}">
		<input type="checkbox" name="rentName" value="${rentList.rentProduct}" />
		${rentList.rentProduct}
		<input type="button" value="수정하기" onclick="modiRent('${rentList.rentProduct}','${b_key}')"/>
		<input type="button" value="물품 보기" onclick="selectedproductList('${rentList.rentProduct}','${b_key}')"/>
	</c:forEach>
</c:if>
<c:if test="${rentList.size() == 0}">
	대여물품목록이 없습니다.
</c:if>