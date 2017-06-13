<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<head>
<title>가맹점 메뉴관리</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/buengbueng/js/menu/menu.js"></script>

</head>


<body>
<div>
	<h2>${name} 님</h2>
</div>

<div>
	<form action="franchiseeMenuPro.do" method="post">

	<select name="franchisee_select" onchange="franchiseeSelect();">
    	<option selected="selected">나의 가맹점 선택</option>
    	<c:forEach var="fl" items="${franchiseeList}" >
    	<option name="name" value="${fl.b_name}" >${fl.b_name}</option>
    	</c:forEach>
    </select>
    <div>
    	<input type="submit" value="선 택">
    	<input type="hidden" name="key" value="${fl.b_key}" />
    </div>
	</form>
</div>

</body>