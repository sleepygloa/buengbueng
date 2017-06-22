<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
[class*=col]{margin-bottom:10px}
</style>
<!-- HEADER TEMPLATE -->
<jsp:include page="../header.jsp" />

	<!-- 페이지 제목 -->
	<div class="margin_bottom50">
		<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
			<h3>가맹점 수정 Form</h3>
		</div>
	</div>
	
	<div class="margin_bottom50">	
		<div class="col-xs-12-12">
					
			<form  action="franchiseeInfoUpdatePro.do" method="post">
				<!-- 가맹점 이름 -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<label>가맹점 이름<br /></label>
						<div class="form-group">
							<input class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" 
							type="text" name="b_name" value="${dto.b_name}" placeholder="아이디를 입력하세요" />
						</div>
					</div>
				</div>
				<!-- 가맹점 사업자번호 -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<label>사업자 번호<br /></label>
						<div class="form-group">
							<input class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" 
							type="text" name="b_number" value="${dto.b_number}" placeholder="- 포함하여 입력해주세요" maxLength="12"/>
						</div>
					</div>
				</div>	
				<!-- 가맹점 주소 -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<label>주소<br /></label>
						<div class="form-group">
							<input class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" 
							type="text" name="b_address" value="${dto.b_address}" placeholder="주소를 입력해주세요"/>
						</div>
					</div>
				</div>
				<!-- 가맹점 사업장 전화번호 -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<label>가맹점 전화번호<br /></label>
						<div class="form-group">
							<input class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" 
							type="text" name="b_tel" value="${dto.b_tel}" placeholder="가맹점 대표전화번호를 입력해주세요"/>
						</div>
					</div>
				</div>	
				<!-- 가맹점 규모 -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<label>가맹점 규모<br /></label>
						<div class="form-group">
							<input class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" 
							type="text" name="b_size" value="${dto.b_size}" placeholder="가맹점 평수를 입력해주세요"/>
						</div>
					</div>
				</div>	
				<!-- PC수 -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<label>가맹점 PC 수<br /></label>
						<div class="form-group">
							<input class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" 
							type="text" name="b_pccount" value="${dto.b_pccount}" placeholder="사장님 PC포함 대수를 입력해주세요"/>
						</div>
					</div>
				</div>	
				<!-- 사장님 IP -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<label>가맹점 IP<br /></label>
						<div class="form-group">
							<input class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" 
							type="text" name="b_ip" value="${dto.b_ip}" placeholder="공인 IP 주소를 입력해주세요"/>
						</div>
					</div>
				</div>	
				<!-- 라이센스KEY -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<label>가맹점 라이센스<br /></label>
						<div class="form-group">
						${dto.b_key}
						<input type="hidden" name="b_key" value="b_key" />
						</div>
					</div>
				</div>																		
				<!-- 버튼 -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<input class="btn btn-success col-xs-12-12 col-sm-6-12 col-md-6-12" type="submit" value="신청하기" />
						<input class="btn btn-default col-xs-12-12 col-sm-6-12 col-md-6-12" type="button" value="취소하기"
						onclick="window.location='franchiseeList.do'" />
					</div>					
				</div>	
			</form>	
			<div class="row">
				<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
					<button class="btn btn-default col-xs-12-12 col-sm-12-12 col-md-12-12" 
					onclick="window.location='index.do'" >메인페이지로</button>
				</div>
			</div>
		</div>
	</div>
	




