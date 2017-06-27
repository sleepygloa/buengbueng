<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/buengbueng/js/menu/menu.js"></script>

<div>
	<form action="userSelectFranchiseePro.do" method="post" name="userSelectFranchisee">


	<input type="hidden" name="name" >
	<select name="userfranchisee_select" onchange="userFranchiseeSelect();">
    	<option selected="selected" >가맹점 선택</option>
    	<c:forEach var="fl" items="${franchiseeList}" >
    	<option name="name" value="${fl.b_name}" >${fl.b_name}</option>
    	</c:forEach>
    </select>

    <div>
    
    	<input type="submit" value="선 택">
    </div>
	</form>
</div>
