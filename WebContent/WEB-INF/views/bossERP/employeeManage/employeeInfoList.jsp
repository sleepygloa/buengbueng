<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
function clickId(id){
	document.getElementById("clickId").value = id;
}

function getInfo(id){
	var id = id;
	$.ajax({
		url : "employeeInfo.do",
		type : "post",
		data : {id : id},
		success:function(data){
			$("#info").html(data);
		}
	});
}
function getUpdateInfo(id){
	var id = id;
		$.ajax({
		url:"employeeUpdateInfo.do",
		type:"post",
		data: {id : id},
		success:function(data){
			$("#info").html(data);
		}
	});
}	
</script>


<!-- HEADER TEMPLATE -->
<jsp:include page="../../header.jsp" />

<input type="hidden" id="clickId" />
	<!-- 페이지 제목 -->
	<div class=" margin_bottom50">
		<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
			<h3>알바생 정보 페이지</h3>
		</div>
	</div>
	
<div class=" margin_bottom50">	
		<div class="col-xs-12-12">
		
			<!-- List -->
			<div class="row">
				<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
				${menu}
				</div>
			</div>

			<div id="info"></div>
	</div>
</div>

