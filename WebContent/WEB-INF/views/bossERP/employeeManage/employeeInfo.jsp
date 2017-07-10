<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- 카테고리 -->
	<!-- 페이지 제목 -->
<div class="col-xs-10-10 col-sm-5-10 col-md-5-10  col_height620 contentBox_outline">
	<div class="contentBox col_height0">
		
				<div class="col-xs-10-10 col-sm-10-10 col-md-10-10  col_height50 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a"><a href="#">회원 정보</a></div>
					</div>
				</div>

<c:if test="${userDto.getName() == null}">

				<div class="col-xs-10-10 col-sm-10-10 col-md-10-10  col_height50 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a"><label>아이디 : ${userDto.id}<br /></label></div>
					</div>
				</div>
				
				<div class="col-xs-10-10 col-sm-10-10 col-md-10-10  col_height50 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a">
							<input class="btn btn-success col-xs-12-12 col-sm-12-12 col-md-12-12" type="button" value="수정하기" 
							onclick="getUpdateInfo('${userDto.id}')" />
						</div>
					</div>
				</div>				
</c:if>




			
<c:if test="${userDto.getName() != null}">
		<!-- 알바생아이디 -->
				<div class="col-xs-10-10 col-sm-10-10 col-md-10-10  col_height50 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a">
							<label>아이디 : ${userDto.id}<br /></label>
						</div>
					</div>
				</div>	


	
		<!-- 비밀번호 -->
				<div class="col-xs-10-10 col-sm-10-10 col-md-10-10  col_height50 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a">
						<label>비밀번호 <br /></label>
						${userDto.pw}
						</div>
					</div>
				</div>		
		<!-- 알바아이디 -->		
				<div class="col-xs-10-10 col-sm-10-10 col-md-10-10  col_height50 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a">
						<label>이름<br /></label>
						${userDto.name}
						</div>
					</div>
				</div>	
				
		<!-- 생일 -->		
				<div class="col-xs-10-10 col-sm-10-10 col-md-10-10  col_height50 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a">
						<label>생년월일<br /></label>
						${userDto.birth}
						</div>
					</div>
				</div>						
	
		<!-- 생일 -->		
				<div class="col-xs-10-10 col-sm-10-10 col-md-10-10  col_height50 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a">
						<label>생년월일<br /></label>
						${userDto.birth}
						</div>
					</div>
				</div>	
		<!-- 주소 -->	
				<div class="col-xs-10-10 col-sm-10-10 col-md-10-10  col_height50 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a">
						<label>주소<br /></label>
						${userDto.address}
						</div>
					</div>
				</div>						
	
		<!-- 이메일 -->	
				<div class="col-xs-10-10 col-sm-10-10 col-md-10-10  col_height50 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a">
						<label>email<br /></label>
						${userDto.email}
						</div>
					</div>
				</div>
				
		<!-- 버튼모음 -->	
				<div class="col-xs-10-10 col-sm-10-10 col-md-10-10  col_height50 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a">
							<input class="btn btn-success col-xs-12-12 col-sm-6-12 col-md-6-12" type="submit" value="수정하기" 
							onclick="getUpdateInfo('${userDto.id}')" />
							<input class="btn btn-default col-xs-12-12 col-sm-6-12 col-md-6-12" type="button" value="취소하기"
							onclick="window.location='employeeManage.do'" />
						</div>
					</div>
				</div>				
</c:if>

	</div>
</div>
