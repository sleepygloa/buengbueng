<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
form{border:1px solid black;}
</style>
<form action="" method="post">
<!-- 카테고리 -->
	<!-- 페이지 제목 -->
	<div class=" margin_bottom50">
		<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
			<h3>회원 정보</h3>
		</div>
	</div>
	<c:if test="${userDto.getName() == null}">
	
		<!-- 알바생아이디 -->
		<div class="row">
			<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
					<div class=" col-xs-12-12 col-sm-12-12 col-md-12-12 form-group">
						<div class="input-group">
						<label>아이디 : ${userDto.id}<br /></label>
						</div>
					</div>														
			</div>
		</div>	
		<div class="row">
			<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
				<input class="btn btn-success col-xs-12-12 col-sm-12-12 col-md-12-12" type="button" value="수정하기" 
				onclick="getUpdateInfo('${userDto.id}')" />
			</div>					
		</div>

			
	</c:if>
	<c:if test="${userDto.getName() != null}">
		<!-- 알바생아이디 -->
		<div class="row">
			<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
					<div class=" col-xs-12-12 col-sm-12-12 col-md-12-12 form-group">
						<div class="input-group">
						<label>아이디 : ${userDto.id}<br /></label>
						</div>
					</div>														
			</div>
		</div>	
	
		<!-- 비밀번호 -->
		<div class="row">
			<div class=" col-xs-12-12 col-sm-12-12 col-md-12-12">
				<div class=" col-xs-12-12 col-sm-12-12 col-md-12-12 form-group">
					<div class=" col-xs-12-12 col-sm-12-12 col-md-12-12 input-group">
					<label>비밀번호 <br /></label>
						${userDto.pw}
					</div>
				</div>														
	
				<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  form-group">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  input-group">
					<label>이름<br /></label>
						${userDto.name}
					</div>
				</div>														
	
				<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  form-group">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  input-group">
					<label>생년월일<br /></label>
						${userDto.birth}
					</div>
				</div>														
	
				<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  form-group">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  input-group">
					<label>연락처<br /></label>
						${userDto.phone}
					</div>
				</div>														
	
				<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  form-group">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  input-group">
					<label>주소<br /></label>
						${userDto.address}
					</div>
				</div>														
	
				<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  form-group">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12  input-group">
					<label>email<br /></label>
						${userDto.email}
					</div>
					</div>														
			</div>
		</div>	
		
		<div class="row">
			<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
				<input class="btn btn-success col-xs-12-12 col-sm-6-12 col-md-6-12" type="submit" value="수정하기" />
				<input class="btn btn-default col-xs-12-12 col-sm-6-12 col-md-6-12" type="button" value="취소하기"
				onclick="window.location='manageEmployee.do'" />
			</div>					
		</div>	
	</c:if>
</form>
