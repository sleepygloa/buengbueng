<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/buengbueng/css/dashBoard/dash-admin/dashAdmin.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<h3>${b_name}가맹점의 알바ID 관리</h3> 
<!-- 페이지 제목 -->
<h3>아이디 신청 List입니다.</h3>
	<div id="dashERPmodify">	
	<div class="dashERPmodifyTableRow">
	<c:forEach var="list" items="${list}">
	<!-- 가져갈 value들  -->
	<input type="hidden" id="applyCount${count1}" value="${list.applyCount}" />
	<input type="hidden" id="b_id${count1}" value="${list.b_id}" />
	<input type="hidden" id="b_key${count1}" value="${list.b_key}" />
		<span class="dashERPmodifyTableCell col-ep-1"><b>신청번호</b></span>
		<span class="dashERPmodifyTableCell col-ep-1">${list.num}</span>
		<span class="dashERPmodifyTableCell col-ep-1"><b>사장 ID</b></span>
		<span class="dashERPmodifyTableCell col-ep-1">${list.b_id}</span>
		<span class="dashERPmodifyTableCell col-ep-1"><b>신청수</b></span>
		<span class="dashERPmodifyTableCell col-ep-1">${list.applyCount}</span>
		<span class="dashERPmodifyTableCell col-ep-1"><b>가맹점키</b></span>
		<span class="dashERPmodifyTableCell col-ep-1">${list.b_key}</span>
		<span class="dashERPmodifyTableCell col-ep-2"><b>시각</b> </br> ${list.applyTime}</span>
		<span class="dashERPmodifyTableCell col-ep-2"><b>사유</b> </br> ${list.content}</span>
		<span class="dashERPmodifyTableCell col-ep-2"><button onclick="return successAdd${count1}();">신청 확인</button></span> 
	</div>
	</div>
	<script>
		function successAdd${count1}(){
			if (confirm("승인 하시겠습니까??") == true){ 
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
<h3>아이디 삭제 List입니다.</h3>
	<div id="dashERPmodify">
	<div class="dashERPmodifyTableRow">
	<c:forEach var="list" items="${list2}">
	<!-- 가져갈 value들  -->
	<input type="hidden" id="e_id${count2}" value="${list.e_id}" />
			<span class="dashERPmodifyTableCell col-ep-1"><b>신청번호</b></span>
			<span class="dashERPmodifyTableCell col-ep-1">${list.num}</span>
			<span class="dashERPmodifyTableCell col-ep-1"><b>사장 ID</b></span>
			<span class="dashERPmodifyTableCell col-ep-1">${list.b_id}</span>
			<span class="dashERPmodifyTableCell col-ep-1"><b>삭제요청 ID</b></span>
			<span class="dashERPmodifyTableCell col-ep-1">${list.e_id}</span>
			<span class="dashERPmodifyTableCell col-ep-2"><b>시각</b><br>${list.applyTime}</span>
			<span class="dashERPmodifyTableCell col-ep-2"><b>사유</b><br>${list.content}</span>
			<span class="dashERPmodifyTableCell col-ep-2"><button onclick="return successDel${count2}();">삭제 확인</button></span>
			<br></br>
	<script>
		function successDel${count2}(){
			if (confirm("삭제 하시겠습니까??") == true){ 
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

