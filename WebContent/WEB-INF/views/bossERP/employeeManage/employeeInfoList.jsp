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
<jsp:include page="../../erp_header.jsp" />

<style>
[class*=col-]{margin-bottom:0px} /* 모든 클래스들 중 col- 로 시작하는 것들을 정의, grid간 아랫공간 띄우기*/

@media screen and (min-width:250px){
	.main_ad{font-size:12px;}
	a{font-size:12px;}
	.t-r{text-align:center;}
	.t-l{text-align:center;}
	.res_height{height:250px;}
}
@media screen and (min-width:768px){
	.main_ad{font-size:14px;}
	a{font-size:14px;}
	.t-r{text-align:right;}
	.t-l{text-align:left;}
	.res_height{height:400px;}
}
@media screen and (min-width:1200px){
	.main_ad{font-size:16px;}
	a{font-size:16px;}
}
a,a:visited,a:hover{
text-decoration: none;color:black;
}
.b_l > div{
border:0.8px solid #e7e7e7;
height:30px;
}
.btn_style {
background-color:#4C8CF5;
color:#fff;
border:none;
}

</style>

<input type="hidden" id="clickId" />

<div class="main_ad" style="background-color:#EEF1F2;height:100%;">
	<div class="main_ad_content">
		<div class="col-xs-10-10 main_ad_contentBox">
	
				<div class="col-xs-10-10 col-sm-10-10 col-md-10-10  col_height90 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a"><a href="#">알바생 정보 페이지</a></div>
					</div>
				</div>
				
				<div class="col-xs-10-10 col-sm-2-10 col-md-2-10  res_height contentBox_outline">
					<div class="contentBox col_height0" style="border:1px solid #e7e7e7;">
					<c:forEach var="list" items="${list}">
						<div class=" mb0" onclick="getInfo('${list.id}')" style="border:1px solid #e7e7e7;">
						<a href="#">${list.id} : 
							<c:if test="${list.name == null}"> 정보를 입력해주세요</c:if>
							<c:if test="${list.name != null}"> ${list.name}</c:if>
						</a></div>
					</c:forEach>
					</div>
					
				</div>
				<div  id="info" class="col-xs-10-10 col-sm-8-10 col-md-8-10   contentBox_outline">
				</div>
				
		</div>
	</div>
</div>
	

