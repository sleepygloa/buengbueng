<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="rentDivDetail">
<input type="text" id="alert" readonly="readonly"/>&emsp;
<c:if test="${page eq 'add'}">
	<form action="addModiRentProductPro.do" method="post" name="rentProductForm" onsubmit="return checkRentProduct();">
		<input type="hidden" value="add" name="page" />
		<input type="hidden" value="${b_key}" name="b_key">
		&emsp;바코드 번호 : <input type="text" name="code" />&emsp;<br/>
		&emsp;물품: <select name="rentProduct">
			<option >선택</option>
			<c:forEach var="rentName" items="${rentName}">
				<option value="${rentName.rentProduct}">${rentName.rentProduct}</option>
			</c:forEach>
		</select>&emsp;<br/>
		<input type="submit" value="추가"/>&emsp;
	</form>
</c:if>

<c:if test="${page eq 'modi'}">
	<form action="addModiRentProductPro.do" method="post" name="rentProductModiForm" onsubmit="return checkRentProductModi();">
		<input type="hidden" value="modi" name="page" />
		<input type="hidden" value="${rentP.code}" name="beforeCode"/>
		<input type="hidden" value="${b_key}" name="b_key">
		&emsp;바코드 번호 : <input type="text" name="code" value="${rentP.code}"/>&emsp;<br/>
		&emsp;대여 유무 : <select name="rentCheck">
						<c:if test="${rentP.rentCheck == 0}">
							<option value="0">대여 가능</option>
							<option value="1">대여 중</option>
						</c:if>
						<c:if test="${rentP.rentCheck == 1}">
							<option value="1">대여 중</option>
							<option value="0">대여 가능</option>
						</c:if>
					  </select>&emsp;<br/>
		<input type="submit" value="완료"/>&emsp;
	</form>
</c:if>
</div>