<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form  action="employeeDeleteInfoPro.do" method="post">
		<!-- 신청번호 -->
		<div class="row">
			<div class="col-md-12-12 col-sm-12-12 col-xs-12-12">
				<label>신청 번호</label>
				<div>
					<c:if test="${logNum == null}">
						1
					</c:if>
					<c:if test="${logNum != null}">
						${logNum+1}	
					</c:if>
				
				</div>
			</div>
		</div>
		<!-- 사장님 ID -->
		<div class="row">
			<div class="col-md-12-12 col-sm-12-12 col-xs-12-12">
					<label>삭제할 알바아이디 ID<br /></label>
					<div class="form-group">
						${e_id}
						<input class="col-xs-12-12 form-control" type="hidden" name="e_id" value="${e_id}" />
					</div>
			</div>
		</div>
		
		<!-- 신청 사유 -->
		<div class="row">
			<div class="col-md-12-12 col-sm-12-12 col-xs-12-12">
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
						<input class="btn btn-success col-xs-12-12 col-sm-12-12 col-md-12-12" type="submit" value="신청하기" />
						<input class="btn btn-default col-xs-12-12 col-sm-12-12 col-md-12-12" type="button" value="취소하기"
						onclick="window.location='index.do'" />

					</div>
			</div>
		</div>	
</form>