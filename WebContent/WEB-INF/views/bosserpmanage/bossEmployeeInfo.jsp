<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- HEADER TEMPLATE -->
<jsp:include page="../header.jsp" />

<form action="bossEmployeeUpdate.do" method="post" name="bossEmployeeInfoUpdate" id="bossEmployeeInfoUpdate">
<!-- 카테고리 -->
<!-- 알바생아이디 -->
<div class="row">
	<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
			<div class=" col-xs-12-12 col-sm-12-12 col-md-12-12 form-group">
				<div class="input-group">
				<label>아이디 : ${userDto.id}<br /></label>
					<input type="hidden" name="id" value="${userDto.id}" placeholder="${userDto.id}" />
				</div>
			</div>														
	</div>
</div>	

<!-- 비밀번호 -->
<div class="row">
	<div class=" col-xs-12-12 col-sm-12-12 col-md-12-12">
			<div class=" col-xs-12-12 col-sm-12-12 col-md-12-12 form-group">
				<div class=" col-xs-12-12 col-sm-12-12 col-md-12-12 input-group">
				<label>비밀번호<br /></label>
					<input type="text" name="pw" class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" value="${userDto.pw}" placeholder="${userDto.pw}" />
				</div>
			</div>														

			<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  form-group">
				<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  input-group">
				<label>이름<br /></label>
					<input type="text" name="name" class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" value="${userDto.name}" placeholder="${userDto.name}" />
				</div>
			</div>														

			<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  form-group">
				<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  input-group">
				<label>생년월일<br /></label>
					<input type="text" class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" value="${userDto.birth}" placeholder="${userDto.birth}" />
				</div>
			</div>														

			<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  form-group">
				<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  input-group">
				<label>연락처<br /></label>
					<input type="text" name="phone" class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" value="${userDto.phone}" placeholder="${userDto.phone}" />
				</div>
			</div>														

			<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  form-group">
				<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  input-group">
				<label>주소<br /></label>
					<input type="text" name="address" class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" value="${userDto.address}" placeholder="${userDto.address}" />
				</div>
			</div>														

			<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  form-group">
				<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  input-group">
				<label>email<br /></label>
					<input type="text" name="email" class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" value="${userDto.email}" placeholder="${userDto.email}" />
				</div>
			</div>														
	</div>
</div>	

<div class="row">
	<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
		<input class="btn btn-success col-xs-12-12 col-sm-6-12 col-md-6-12" type="submit" value="신청하기" />
		<input class="btn btn-default col-xs-12-12 col-sm-6-12 col-md-6-12" type="button" value="취소하기"
		onclick="window.location='index.do'" />
	</div>					
</div>	

</form>