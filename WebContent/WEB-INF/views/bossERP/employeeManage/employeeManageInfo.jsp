<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
function employeeIdSet(num){
	document.getElementById("clickNum").value = num;
}

function getAddInfo(b_key){
		$.ajax({
		url:"employeeAddInfo.do",
		type:"post",
		data:{b_key:b_key},
		success:function(data){
			$("#info").html(data);
		}
	});
}

function getDeleteInfo(){
	var num = document.getElementById("clickNum").value;
		$.ajax({
		url:"employeeDeleteInfo.do",
		type:"post",
		data: {num : num},
		success:function(data){
			$("#info").html(data);
		}
	});
}


function employeeIdUP(){
var num = document.getElementById("clickNum").value;
	$.ajax({
	url:"employeeIdUP.do",
	type:"post",
	data: {num : num},
	success:function(data){
		history.go(0);
	}
});
}	
function employeeIdDOWN(){
var num = document.getElementById("clickNum").value;
	$.ajax({
	url:"employeeIdDOWN.do",
	type:"post",
	data: {num : num},
	success:function(data){
		history.go(0);
	}
})
}
	
$(function (){
	$('.list').click(function(){
		$('.bn').css("background-color","white");
		$(this).css("background-color","green");
		
	});
});
</script>

<!-- 페이지 제목 -->
<div class=" margin_bottom50">
	<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
		<h3>가맹점 ${b_key}ERP 아이디관리 페이지입니다.</h3> 
	</div>
</div>
<div class=" margin_bottom50">	
	<div class="col-xs-12-12 col-md-5-12">
		<div class="col-xs-12-12">
			<input type="hidden" id="clickNum"/>
				<div class="col-xs-12-12" style="border:solid 2px black;height:450px;">
						<div>
							<div>알바생 아이디</div>
							<div>
								<input type="button" name="" value="알바생 추가" 
								onclick="getAddInfo('${b_key}')"/>
								<input type="button" name="" value="알바생 삭제"
								onclick="getDeleteInfo()" />
								<input type="button" name="" value="▲" 
								onclick="employeeIdUP()"/>
								<input type="button" name="" value="▼" 
								onclick="employeeIdDOWN()"/>
							</div>
						</div>
						<c:forEach var="list" items="${list1}">
							<tr style="height:56.25px"><td></td><td width="100%" >
							<span id="num${list.num}" class="list bn" value="${list.num}"
							onclick="employeeIdSet('${list.num}')">${list.e_id}
							<c:if test="${list.e_name != null}">(${list.e_name})</c:if></span></td></tr>
						</c:forEach>
				</div>
		</div>
	</div>
	<div class="col-xs-12-12 col-md-7-12">
		<div>
			<div id="info"></div>
		</div>
	</div>
</div>

<div class=" margin_bottom50">	
	<div class="col-xs-12-12">

		<!-- 페이지 제목 -->
		<div class=" margin_bottom50">
			<div class="col-xs-12-12">
				<h3>아이디 신청 List입니다.</h3>
			</div>
		</div>
	<c:forEach var="list" items="${list}">
	<form action="employeeAddAdminConfirm.do" method="post" >
	<!-- 가져갈 value들  -->
	<input type="hidden" name="applyCount" value="${list.applyCount}" />
	<input type="hidden" name="b_id" value="${list.b_id}" />
	<input type="hidden" name="b_key" value="${list.b_key}" />
		<div>
			<div class="col-xs-6-12 col-md-1-12">신청번호</div>
			<div class="col-xs-6-12 md_hidden">${list.num}</div>
			<div class="col-xs-6-12 col-md-1-12">ID</div>
			<div class="col-xs-6-12 md_hidden">${list.b_id}</div>
			<div class="col-xs-6-12 col-md-1-12">신청수</div>
			<div class="col-xs-6-12 md_hidden">${list.applyCount}</div>
			<div class="col-xs-6-12 col-md-2-12">시각</div>
			<div class="col-xs-6-12 md_hidden">${list.applyTime}</div>
			<div class="col-xs-6-12 col-md-1-12">가맹점키</div>
			<div class="col-xs-6-12 md_hidden">${list.b_key}</div>
			<div class="col-xs-6-12 col-md-5-12">사유</div>
			<div class="col-xs-6-12 md_hidden">${list.content}</div>
			<div class="col-xs-6-12 col-md-1-12">신청확인</div>
			<div class="col-xs-6-12 md_hidden">
				<input type="submit" name="confirm" value="신청확인" 	/> 
			</div>
		</div>
		<div>
			<div class="xsm_hidden col-md-1-12">${list.num}</div>
			<div class="xsm_hidden col-md-1-12">${list.b_id}</div>
			<div class="xsm_hidden col-md-1-12">${list.applyCount}</div>
			<div class="xsm_hidden col-md-2-12">${list.applyTime}</div>
			<div class="xsm_hidden col-md-1-12">${list.b_key}</div>
			<div class="xsm_hidden col-md-5-12">${list.content}</div>
			<div class="xsm_hidden col-md-1-12">
				<input type="submit" name="confirm" value="신청확인" 	/> 
			</div>
		</div>
	</form>
	</c:forEach>
	</div>
			<!-- 페이지 제목 -->
		<div class=" margin_bottom50">
			<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
				<h3>아이디 삭제 List입니다.</h3>
			</div>
		</div>
	<div class="col-xs-12-12 col-md-9-12">
	<c:forEach var="list" items="${list2}">
	<form action="employeeDeleteAdminConfirm.do" method="post" >
	<!-- 가져갈 value들  -->
	<input type="hidden" name="b_id" value="${list.b_id}" />
	<input type="hidden" name="e_id" value="${list.e_id}" />
		<div class="container">
			<div class="col-xs-6-12 col-md-1-12">신청번호</div>
			<div class="col-xs-6-12 md_hidden">${list.num}</div>
			<div class="col-xs-6-12 col-md-1-12">ID</div>
			<div class="col-xs-6-12 md_hidden">${list.b_id}</div>
			<div class="col-xs-6-12 col-md-1-12">삭제할 ID</div>
			<div class="col-xs-6-12 md_hidden">${list.e_id}</div>
			<div class="col-xs-6-12 col-md-2-12">시각</div>
			<div class="col-xs-6-12 md_hidden">${list.applyTime}</div>
			<div class="col-xs-6-12 col-md-3-12">사유</div>
			<div class="col-xs-6-12 md_hidden">${list.content}</div>
			<div class="col-xs-6-12 col-md-1-12">신청확인</div>
			<div class="col-xs-6-12 md_hidden">
				<input type="submit" name="confirm" value="신청확인" 	/> 
			</div>
		</div>
		<div class="container">
			<div class="col-xs-6-12 col-md-1-12">${list.num}</div>
			<div class="col-xs-6-12 col-md-1-12">${list.b_id}</div>
			<div class="col-xs-6-12 col-md-1-12">${list.e_id}</div>
			<div class="col-xs-6-12 col-md-2-12">${list.applyTime}</div>
			<div class="col-xs-6-12 col-md-3-12">${list.content}</div>
			<div class="col-xs-6-12 col-md-1-12">
				<input type="submit" name="confirm" value="신청확인" 	/> 
			</div>
		</div>
	</form>
	</c:forEach>
</div>	

</div>

