<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${page eq 'add'}">
	<form action="addModiRentProductPro.do" method="post" name="rentProductForm">
		<input type="hidden" value="add" name="page" />
		바코드 번호 : <input type="text" name="code" /><br/>
		대여물품 : <input type="text" name="rentProduct" />
		<select name="rent" onchange="rentSelect();">
			<option >선택</option>
			<c:forEach var="rentName" items="${rentName}">
				<option>${rentName.rentProduct}</option>
			</c:forEach>
		</select><br/>
		<input type="submit" value="추가"/>
	</form>
</c:if>

<c:if test="${page eq 'modi'}">
	<form action="addModiRentProductPro.do" method="post" name="rentProductForm">
		<input type="hidden" value="modi" name="page" />
		<input type="hidden" value="${rentP.code}" name="beforeCode"/>
		바코드 번호 : <input type="text" name="code" value="${rentP.code}"/><br/>
		대여물품 : <input type="text" name="rentProduct"  value="${rentP.rentProduct}"/>
		<select name="rent" onchange="rentSelect();">
			<option >선택</option>
			<c:forEach var="rentName" items="${rentName}">
				<option>${rentName.rentProduct}</option>
			</c:forEach>
		</select><br/>
		<input type="submit" value="추가"/>
	</form>
</c:if>