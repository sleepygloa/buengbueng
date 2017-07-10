<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- HEADER TEMPLATE -->
<jsp:include page="../../erp_header.jsp" />


<style>
[class*=col-]{margin-bottom:5px} /* 모든 클래스들 중 col- 로 시작하는 것들을 정의, grid간 아랫공간 띄우기*/

@media screen and (min-width:250px){
	.main_ad{font-size:12px;}
	a{font-size:12px;}
	.t-r{text-align:center;}
	.t-l{text-align:center;}
}
@media screen and (min-width:768px){
	.main_ad{font-size:14px;}
	a{font-size:14px;}
	.t-r{text-align:right;}
	.t-l{text-align:left;}
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

<!-- JS관련 코드 -->
<input type="hidden" id="clickNum"/>
<!-- 끝 -->

<div class="main_ad" style="background-color:#EEF1F2;height:100%;">
	<div class="main_ad_content">
		<div class="col-xs-10-10 main_ad_contentBox">
	
				<div class="col-xs-10-10 col-sm-10-10 col-md-10-10  col_height90 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a"><a href="#"><div class="col-xs-10-10 col-sm-5-10 col-md-5-10 t-r">가맹점 ${sessionScope.b_key} </div><div class="col-xs-10-10 col-sm-5-10 col-md-5-10 t-l xs_hidden"> 의 &nbsp; ERP 아이디관리 페이지</div></a></div>
					</div>
				</div>
				<div>
				<div class="col-xs-10-10 col-sm-5-10 col-md-5-10 col_height620  contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a"><a href="#">보유한 아이디</a></div>
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
						<c:forEach var="list" items="${list1}">
						<div class="col-xs-12-12">

							<span id="num${list.num}" class="list bn" value="${list.num}"
							onclick="employeeIdSet('${list.num}')">${list.e_id}
							<c:if test="${list.e_name != null}">(${list.e_name})</c:if></span>

						</div>
						</c:forEach>
					</div>
				</div>
				</div><!-- info와 단위 맞추기 위한 div -->
				<div id="info">
				</div>
				
				<div class="col-xs-10-10 col-sm-10-10 col-md-10-10  col_height300 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a">
							<label>아이디 신청 List입니다.</label>
							<c:forEach var="list" items="${list}">
							<form action="employeeAddAdminConfirm.do" method="post" >
							<!-- 가져갈 value들  -->
							<input type="hidden" name="applyCount" value="${list.applyCount}" />
							<input type="hidden" name="b_id" value="${list.b_id}" />
							<input type="hidden" name="b_key" value="${list.b_key}" />
								<div class="b_l">
									<div class="col-xs-6-12 col-md-1-12 ">신청번호</div>
									<div class="col-xs-6-12 md_hidden">${list.num}</div>
									<div class="col-xs-6-12 col-md-1-12">ID</div>
									<div class="col-xs-6-12 md_hidden">${list.b_id}</div>
									<div class="col-xs-6-12 col-md-1-12">신청수</div>
									<div class="col-xs-6-12 md_hidden">${list.applyCount}</div>
									<div class="col-xs-6-12 col-md-2-12">시각</div>
									<div class="col-xs-6-12 md_hidden">${list.applyTime}</div>
									<div class="col-xs-6-12 col-md-6-12">사유</div>
									<div class="col-xs-6-12 md_hidden">${list.content}</div>
									<div class="col-xs-6-12 col-md-1-12">신청확인</div>
									<div class="col-xs-6-12 md_hidden">
										<input class="btn_style" type="submit" name="confirm" value="신청확인" 	/> 
									</div>
								</div>
								<div class="b_l">
									<div class="xsm_hidden col-md-1-12">${list.num}</div>
									<div class="xsm_hidden col-md-1-12">${list.b_id}</div>
									<div class="xsm_hidden col-md-1-12">${list.applyCount}</div>
									<div class="xsm_hidden col-md-2-12">${list.applyTime}</div>
									<div class="xsm_hidden col-md-6-12">${list.content}</div>
									<div class="xsm_hidden col-md-1-12">
										<input class="btn_style" type="submit" name="confirm" value="신청확인" 	/> 
									</div>
								</div>
							</form>
							</c:forEach>
						</div>
					</div>
				</div>				
				
				<div class="col-xs-10-10 col-sm-10-10 col-md-10-10  col_height300 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a">
							<label>아이디 삭제 List입니다.</label>
							<c:forEach var="list" items="${list2}">
							<form action="employeeDeleteAdminConfirm.do" method="post" >
							<!-- 가져갈 value들  -->
							<input type="hidden" name="b_id" value="${list.b_id}" />
							<input type="hidden" name="e_id" value="${list.e_id}" />
								<div class="b_l">
									<div class="col-xs-6-12 col-md-1-12">신청번호</div>
									<div class="col-xs-6-12 md_hidden">${list.num}</div>
									<div class="col-xs-6-12 col-md-1-12">ID</div>
									<div class="col-xs-6-12 md_hidden">${list.b_id}</div>									
									<div class="col-xs-6-12 col-md-1-12">삭제할 ID</div>
									<div class="col-xs-6-12 md_hidden">${list.e_id}</div>
									<div class="col-xs-6-12 col-md-2-12">시각</div>
									<div class="col-xs-6-12 md_hidden">${list.applyTime}</div>
									<div class="col-xs-6-12 col-md-6-12">사유</div>
									<div class="col-xs-6-12 md_hidden">${list.content}</div>
									<div class="col-xs-6-12 col-md-1-12">신청확인</div>
									<div class="col-xs-6-12 md_hidden">
										<input class="btn_style" type="submit" name="confirm" value="신청확인" 	/> 
									</div>
								</div>
								<div class="b_l">
									<div class="xsm_hidden col-md-1-12">${list.num}</div>
									<div class="xsm_hidden col-md-1-12">${list.b_id}</div>
									<div class="xsm_hidden col-md-1-12">${list.e_id}</div>
									<div class="xsm_hidden col-md-2-12">${list.applyTime}</div>
									<div class="xsm_hidden col-md-6-12">${list.content}</div>
									<div class="xsm_hidden col-md-1-12">
										<input class="btn_style" type="submit" name="confirm" value="신청확인" 	/> 
									</div>
								</div>
							</form>
							</c:forEach>
						</div>
					</div>
				</div>				
				
				
		</div>
	</div>
</div>



<!-- FOOTER TEMPLATE -->
<%-- <jsp:include page="../../footer.jsp" /> --%>