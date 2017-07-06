<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<input type="text" id="alert" readonly="readonly"/>
<c:if test="${page eq 'add'}">
	<form action="addModiRentPro.do" method="post" name="rentForm" onsubmit="return checkRent();">
		<input type="hidden" value="${page}" name="page"/>
		<input type="hidden" name="b_key" value="${b_key}"/><br/>
		대여물품 목록 : <input type="text" id="rentProduct" name="rentProduct"/><br/>
		<input type="submit" value="추가"/>
	</form>
</c:if>

<c:if test="${page eq 'modi'}">
	<form action="addModiRentPro.do" method="post" name="rentForm" onsubmit="return checkRent();">
		<input type="hidden" value="${page}" name="page"/>
		<input type="hidden" value="${rent.rentProduct}" name="beforeProduct"/>
		<input type="hidden" name="key" value="${rent.b_key}"/><br/>
		대여물품 목록 : <input type="text" id="rentProduct" name="afterProduct" value="${rent.rentProduct}"/><br/>
		<input type="submit" value="수정"/>
	</form>
</c:if>