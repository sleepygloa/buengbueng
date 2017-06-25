<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	<form action="dashEmployeeAddAdminConfirm.do" method="post" >
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
	<form action="dashEmployeeDeleteAdminConfirm.do" method="post" >
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
	</form>
	</c:forEach>
</div>	

