<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
$(document).ready(function(){
	var  l = $("#selectBox option:selected").val();
	alert(l);
})




</script>
<!-- HEADER TEMPLATE -->
<jsp:include page="../../header.jsp" />

	<!-- 페이지 제목 -->
	<div class=" margin_bottom50">
		<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
			<h3>ERP 아이디추가 페이지입니다.</h3> 
		</div>
	</div>
	<input type="hidden" id="clickB_key"/>
<div class=" margin_bottom50">	
	<div class="col-xs-12-12 col-md-5-12">
		가맹점 선택 : 
		<select id="selectBox" name="b_key">
			<c:forEach var="list" items="${franchiseeList}">
				<option  value="${list.b_key}" onclick="getEmployeeInfo('${list.b_key}')" >${list.b_name}${list.b_key}</option>
			</c:forEach>
		</select>
	</div>
</div>

<div class=" margin_bottom50">	
	<div class="col-xs-12-12 col-md-5-12">
		<div id="info"></div>
	</div>
</div>

<!-- HEADER TEMPLATE -->
<jsp:include page="../../footer.jsp" />