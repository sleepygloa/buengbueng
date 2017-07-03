<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<p>No.${pcNum}</p>
${id}&nbsp;님<br/>
로그인&emsp;${startTime}<br/><br/>

대여물품<br/>
<c:forEach var="rent" items="${rentOrderList}">
	물품명: ${rent.name}&emsp;&emsp;바코드: ${rent.code}<br/>
</c:forEach>
<br/>
메뉴<br/>
<c:forEach var="menu" items="${menuOrderList}">
	메뉴명: ${menu.menuname}&emsp;&emsp;바코드: ${menu.code}&emsp;&emsp;가격: ${menu.ordermoney}<br/>
</c:forEach>