<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- HEADER TEMPLATE -->
<jsp:include page="../header.jsp" />

	<!-- 페이지 제목 -->
	<div class=" margin_bottom50">
		<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
			<h3>ERP 아이디추가 페이지입니다.</h3>
		</div>
	</div>
	
<div class=" margin_bottom50">	
		<div class="col-xs-12-12">
					
			<form  action="bossEmployeeAddPro.do" method="post">
				<!-- 사장님 ID -->
				<div class="row">
					<div class="col-md-12-12 col-sm-12-12 col-xs-12-12">
						<c:if test="${id != null}">
							<label>ID<br /></label>
							<div class="form-group">
								${id}
								<input class="col-xs-12-12 form-control" type="hidden" name="id" value="${id}" placeholder="아이디를 입력하세요" />
							</div>
						</c:if>
					</div>
				</div>
				
				<!-- 신청하는  ID 수 -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<label>신청하는 ID 갯수<br /></label>
							<div class="form-group">
								<input class="col-xs-12-12 form-control" type="text" name=""  placeholder="아이디를 입력하세요" />
							</div>
					</div>
				</div>
	
				<!-- 신청 사유 -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<label>신청사유<br /></label>
							<div class="form-group">
								<textarea class="col-xs-12-12 col-md-10-12 form-control" name="content" rows="5"></textarea>

							</div>
					</div>
				</div>	
	
				<!--버튼 -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
							<div class="form-group">
								<input class="btn btn-success col-xs-12-12 col-sm-6-12 col-md-6-12" type="submit" value="신청하기" />
								<input class="btn btn-default col-xs-12-12 col-sm-6-12 col-md-6-12" type="button" value="취소하기"
								onclick="window.location='bossEmployeeInfoMain.do'" />

							</div>
					</div>
				</div>	
	
</div>