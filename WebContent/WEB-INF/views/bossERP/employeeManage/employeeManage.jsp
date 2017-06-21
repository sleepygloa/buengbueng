<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#selectBox").change(function(){
		var b_key =$(this).children("option:selected").val()
        $.ajax({
        	url: "employeeManageInfo.do",
        	type:"post",
        	data:{b_key:b_key},
        	success:function(data){
        		$("#employeeManageInfo").html(data);
        	}
        })
});
})
</script>
<!-- HEADER TEMPLATE -->
<jsp:include page="../../header.jsp" />

	<!-- 페이지 제목 -->
	<div class=" margin_bottom50">
		<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
			<h3 >ERP 아이디추가 페이지입니다.</h3> 
		</div>
	</div>
	<input type="hidden" id="clickB_key"/>
<div class=" margin_bottom50">	
	<div class="col-xs-12-12">
		가맹점 선택 : 
		<select id="selectBox" name="b_key"><option value="55">zz</option>
			<c:forEach var="list" items="${franchiseeList}">
				<option  value="${list.b_key}"  >${list.b_name}${list.b_key}</option>
			</c:forEach>
		</select>
	</div>
</div>

<div class=" margin_bottom50">	
	<div class="col-xs-12-12">
		<div id="employeeManageInfo"></div>
	</div>
</div>

<!-- HEADER TEMPLATE -->
<jsp:include page="../../footer.jsp" />