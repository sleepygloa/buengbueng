<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<input type="text" id="alert" readonly="readonly"/>
<c:if test="${page eq 'add'}">
	<form action="addModiRentProductPro.do" method="post" name="rentProductForm" onsubmit="return checkRentProduct();">
		<input type="hidden" value="add" name="page" />
		<input type="hidden" value="${b_key}" name="b_key">
		바코드 번호 : <input type="text" name="code" /><br/>
		물품: <select name="rentProduct">
			<option >선택</option>
			<c:forEach var="rentName" items="${rentName}">
				<option value="${rentName.rentProduct}">${rentName.rentProduct}</option>
			</c:forEach>
		</select><br/>
		<input type="submit" value="추가"/>
	</form>
</c:if>

<c:if test="${page eq 'modi'}">
	<form action="addModiRentProductPro.do" method="post" name="rentProductModiForm" onsubmit="return checkRentProductModi();">
		<input type="hidden" value="modi" name="page" />
		<input type="hidden" value="${rentP.code}" name="beforeCode"/>
		<input type="hidden" value="${b_key}" name="b_key">
		바코드 번호 : <input type="text" name="code" value="${rentP.code}"/><br/>
		대여 유무 : <input type="text" name="rentCheck" value="${rentP.rentCheck}"/><br/>
		<input type="submit" value="수정"/>
	</form>
</c:if>