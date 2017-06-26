<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<div class=" margin_bottom50">
	<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
		<h3>${b_name}가맹점의 ERP 알바ID 관리 페이지입니다.</h3> 
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
	<!-- 가져갈 value들  -->
	<input type="hidden" id="applyCount${count1}" value="${list.applyCount}" />
	<input type="hidden" id="b_id${count1}" value="${list.b_id}" />
	<input type="hidden" id="b_key${count1}" value="${list.b_key}" />
		<div>
			<span class="col-xs-6-12 col-md-1-12">신청번호</span>
			<span class="col-xs-6-12 col-md-1-12">ID</span>
			<span class="col-xs-6-12 col-md-1-12">신청수</span>
			<span class="col-xs-6-12 col-md-2-12">시각</span>
			<span class="col-xs-6-12 col-md-1-12">가맹점키</span>
			<span class="col-xs-6-12 col-md-5-12">사유</span>
			<span class="col-xs-6-12 col-md-1-12">신청확인</span>
		</div>
		<div>
			<span class="col-xs-6-12 md_hidden">${list.num}</span>
			<span class="col-xs-6-12 md_hidden">${list.b_id}</span>
			<span class="col-xs-6-12 md_hidden">${list.applyCount}</span>
			<span class="col-xs-6-12 md_hidden">${list.applyTime}</span>
			<span class="col-xs-6-12 md_hidden">${list.b_key}</span>
			<span class="col-xs-6-12 md_hidden">${list.content}</span>
		</div>
				<div class="col-xs-6-12 md_hidden">
				<button onclick="return successAdd${count1}();">신청 확인</button> 
			</div>
		</div>
	<script>
		function successAdd${count1}(){
			if (confirm("수정 하시겠습니까??") == true){ 
				$.ajax({
					url:"dashEmployeeAddAdminConfirm.do",
					type:"post",
					data:{
						b_id:$("#b_id${count1}").val(),
						b_key:$("#b_key${count1}").val(),
						applyCount:$("#applyCount${count1}").val()
					},
					success:function(){
						history.go(0);
				    }
				});
			}else{
				return;
			}
		}
	</script>
	<c:set var="count2" value="${count1-1}"/>
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
	<!-- 가져갈 value들  -->
	<input type="hidden" id="e_id${count2}" value="${list.e_id}" />
		<div class="container">
		<div>
			<span class="col-xs-6-12 col-md-1-12">신청번호</span>
			<span class="col-xs-6-12 col-md-1-12">ID</span>
			<span class="col-xs-6-12 col-md-1-12">삭제할 ID</span>
			<span class="col-xs-6-12 col-md-2-12">시각</span>
			<span class="col-xs-6-12 col-md-3-12">사유</span>
			<span class="col-xs-6-12 col-md-1-12">신청확인</span>
		</div>
		<div>
			<span class="col-xs-6-12 md_hidden">${list.num}</span>
			<span class="col-xs-6-12 md_hidden">${list.b_id}</span>
			<span class="col-xs-6-12 md_hidden">${list.e_id}</span>
			<span class="col-xs-6-12 md_hidden">${list.applyTime}</span>
			<span class="col-xs-6-12 md_hidden">${list.content}</span>
		</div>	
				<div class="col-xs-6-12 md_hidden">
				<button onclick="return successDel${count2}();">삭제 확인</button> 
			</div>
		</div>
	<script>
		function successDel${count2}(){
			if (confirm("수정 하시겠습니까??") == true){ 
				$.ajax({
					url:"dashEmployeeDeleteAdminConfirm.do",
					type:"post",
					data:{e_id:$("#e_id${count2}").val()},
					success:function(){
						history.go(0);
				    }
				});
			}else{
				return;
			}
		}
	</script>
	<c:set var="count2" value="${count2-1}"/>	
	</c:forEach>
</div>	

