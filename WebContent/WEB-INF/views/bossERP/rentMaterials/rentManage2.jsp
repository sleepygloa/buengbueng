<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${rentList.size() != 0}">
	<input type="button" value="대여물품 추가" id="addRentProduct"/>&emsp;&emsp;&emsp;
	<input type="button" value="대여물품삭제" id="delRentProduct"/>&emsp;&emsp;&emsp;
	<br/><br/>
	<div id="container">
	    <ul class="tabs">
	    	<c:set var="num" value="1"/>
	   		<c:forEach var="rentList" items="${rentList}">
		     	<li rel="tab${num}" onclick="selectedproductList('${rentList.rentProduct}','${sessionScope.b_key}','tab${num}');">
				    &emsp;<input type="checkbox" name="rentName" value="${rentList.rentProduct}"/>&emsp;${rentList.rentProduct}&emsp;
				    <input type="button" value="수정" onclick="modiRent('${rentList.rentProduct}','${sessionScope.b_key}')"/>&emsp;
				</li>
				<c:set var="num" value="${num+1}"/>
			</c:forEach>
	    </ul>
	    <div class="tab_container">
	    	<c:set var="num" value="1"/>
	    	<c:forEach var="rentList" items="${rentList}">
		   		<div id="tab${num}" class="tab_content"></div>
		   		<c:set var="num" value="${num+1}"/>
			</c:forEach>
		</div>
	</div>
</c:if>
<c:if test="${rentList.size() == 0}">
	대여물품목록이 없습니다.
</c:if>