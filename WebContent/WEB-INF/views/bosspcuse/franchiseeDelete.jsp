<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- HEADER TEMPLATE -->
<jsp:include page="../header.jsp" />
<style>[class*=col]{margin-bottom:20px}</style>
	<!-- 페이지 제목 -->
	<div class="margin_bottom50">
		<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
			<h3>가맹점 삭제 신청 PAGE</h3>
		</div>
	</div>
	
	<div class="margin_bottom50">	
		<div class="col-xs-12-12">
					
			<form  action="franchiseeDeletePro.do" method="post">
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
				<!-- 비밀번호 -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<label>비밀번호 <br /></label>
						<div class="form-group">
							<input class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" type="password" name="password" placeholder="비밀번호를 입력해주세요" />
						</div>
					</div>
				</div>					
				<!-- 라이센스KEY -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<label>가맹점 라이센스 key<br /></label>
						<div class="form-group">
						<input class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" type="text" name="b_key" placeholder="라이센스키를 정확히 입력해주세요" />
						</div>
					</div>
				</div>	
				<!-- 삭제 사유 -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<label>삭제 신청 사유</label>
						<div>
							<textarea name="reason" class="col-xs-12-12 col-sm-12-12 col-md-12-12" rows="5"></textarea>
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
