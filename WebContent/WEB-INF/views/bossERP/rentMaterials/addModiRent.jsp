<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${page eq 'add'}">
	<form action="addModiRentPro.do" method="post">
		<input type="hidden" value="${page}" name="page"/>
		pc방 라이센스키 : <input type="text" name="b_key"/><br/>
		대여물품 목록 : <input type="text" name="rentProduct"/><br/>
		<input type="submit" value="추가"/>
	</form>
</c:if>

<c:if test="${page eq 'modi'}">
	<form action="addModiRentPro.do" method="post">
		<input type="hidden" value="${page}" name="page"/>
		<input type="hidden" value="${rent.rentProduct}" name="beforeProduct"/>
		pc방 라이센스키 : <input type="text" name="key" value="${rent.b_key}"/><br/>
		대여물품 목록 : <input type="text" name="afterProduct" value="${rent.rentProduct}"/><br/>
		<input type="submit" value="수정"/>
	</form>
</c:if>