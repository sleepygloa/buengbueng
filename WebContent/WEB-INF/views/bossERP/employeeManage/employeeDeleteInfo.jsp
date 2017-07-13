<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-xs-10-10 col-sm-5-10 col-md-5-10  col_height620 contentBox_outline">
	<div class="contentBox col_height0">
		<form  action="employeeDeleteInfoPro.do" method="post">
		
				<div class="col-xs-10-10 col-sm-10-10 col-md-10-10  col_height80 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a"><a href="#">아이디 삭제 Form</a></div>
					</div>
				</div>
<div class="col-xs-10-10 hr"></div>
					<!-- 신청번호 -->
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
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
					<!-- 삭제할 알바아이디 -->
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<label>삭제할 알바아이디 ID<br /></label>
						<div class="form-group">
							${e_id}
							<input class="col-xs-12-12 form-control" type="hidden" name="e_id" value="${e_id}" />
						</div>
					</div>
					<!-- 가맹점 라이센스 -->
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<label>가맹점 라이센스<br /></label>
						<div class="form-group">
							${sessionScope.b_key}
						</div>
					</div>		
					<!-- 신청사유 -->
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<label>신청사유<br /></label>
						<div class="form-group">
							<textarea class="col-xs-12-12 col-md-10-12 form-control" name="content" rows="5"></textarea>
						</div>
					</div>	
					
					<!-- 버튼모음 -->
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<div class="form-group">
							<input class="btn btn-success col-xs-12-12 col-sm-12-12 col-md-12-12" type="submit" value="신청하기" />
							<input class="btn btn-default col-xs-12-12 col-sm-12-12 col-md-12-12" type="button" value="취소하기"
							onclick="window.location='index.do'" />
	
						</div>
					</div>					
					
		</form>
	</div>
</div>

