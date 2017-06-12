<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- HEADER TEMPLATE -->
<jsp:include page="../header.jsp" />
<style>[class*=col]{margin-bottom:0px}</style>
	<!-- 페이지 제목 -->
	<div class="margin_bottom50">
		<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
			<h3>가맹점 신청 PAGE</h3>
		</div>
	</div>
	
	<div class="margin_bottom50">	
		<div class="col-xs-12-12">
					
			<form  action="franchiseeAddPro.do" method="post">
				<!-- 회원 ID -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<c:if test="${userDto.id != null}">
							<label>ID<br /></label>
							<div class="form-group">
								${userDto.id}
								<input class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" type="hidden" name="id" value="${userDto.id}" placeholder="아이디를 입력하세요" />
							</div>
						</c:if>
						<c:if test="${userDto.id == null}">비회원</c:if>
					</div>
				</div>
				<!-- 회원 GRADE -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<c:if test="${userDto.grade != null}">
							<label>등급<br /></label>
							<div class="form-group">
								<c:if test="${userDto.grade == 0}">관리자</c:if>
								<c:if test="${userDto.grade == 1}">사장</c:if>
								<c:if test="${userDto.grade == 2}">알바</c:if>
								<c:if test="${userDto.grade == 3}">사용자</c:if>
							</div>
						</c:if>
					</div>
				</div>				
				
				<!-- 상호명 -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
							<label>상호명<br /></label>
							<div class="form-group ">
								<input class="col-xs-12-12 form-control" type="text" name="b_name" placeholder="상호명을 입력하세요" />
							</div>
					</div>
				</div>
				<!-- 사업자 번호 -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
							<label>사업자번호<br /></label>	
							<div class="form-group">
								<div class="input-group">
									<input class="col-xs-1-12 form-control"  type="text" name="b_number_1" size="3"  maxlength="3" onblur="return checkB_number_1();"/>	
										<div class="input-group-addon">-</div>
									<input class="col-xs-1-12 form-control"  type="text" name="b_number_2" size="2"  maxlength="2" onblur="return checkB_number_2();"/>	
										<div class="input-group-addon">-</div>
									<input class="col-xs-1-12 form-control"  type="text" name="b_number_3" size="5"   maxlength="5" onblur="return checkB_number_3();"/>	
								</div>
								
							</div>														
					</div>
				</div>				
				<!-- 사업장 주소 -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
							<label>사업장 주소<br /></label>
							<div class="form-group">
								<input class="col-xs-12-12 form-control" type="text" name="b_address" placeholder="사업장 주소 입력" onblur="return checkB_address();">
							</div>
					</div>
				</div>	
				<!-- 사업장 전화번호 -->
				<div class="row">

					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
							<label>사업장 전화번호<br /></label>
							<div class="form-group">
								<div class="input-group">
									<input class="col-xs-1-12 form-control" type="text" name="b_tel1" size="3" maxlength="3" onblur="return checkB_tel1();">
										<div class="input-group-addon">-</div>
									<input class="col-xs-1-12 form-control" type="text" name="b_tel2" size="4" maxlength="4" onblur="return checkB_tel2();">
										<div class="input-group-addon">-</div>
									<input class="col-xs-1-12 form-control" type="text" name="b_tel3" size="4" maxlength="4" onblur="return checkB_tel3();">
								</div>
							</div>
					</div>
				</div>
				<!-- 사업장 규모 -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
							<label>사업장 규모<br /></label>
							<div class="form-group">
								<input class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" type="text" name="b_size" placeholder="사업장 규모 입력 (평 수)" onblur="return checkB_size();">	
							</div>
					</div>
				</div>
				<!-- 보유 컴퓨터수 -->
				<div class="row">

					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
							<label>보유컴퓨터 수<br /></label>
							<div class="form-group">
								<input class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-control" type="text" name="b_pccount" placeholder="보유한 컴퓨터 대수를 입력하세요" onblur="return checkB_size();">	
							</div>
					</div>
				</div>	
				<!-- 사업장 사장님컴퓨터 IP -->
				<div class="row">

					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
							<label>사업장 사장님컴퓨터 IP<br /></label>
							<div class="form-group">
								${ip}
						<input type="hidden" name="b_ip" value="${ip}" />
							</div>
					</div>
				</div>							
				<!-- 버튼 -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<input class="btn btn-success col-xs-12-12 col-sm-6-12 col-md-6-12" type="submit" value="신청하기" />
						<input class="btn btn-default col-xs-12-12 col-sm-6-12 col-md-6-12" type="button" value="취소하기" />
					</div>					
				</div>	
			</form>	
			<div class="row">
				<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
					<button class="btn btn-default col-xs-12-12 col-sm-12-12 col-md-12-12"  onclick="window.location='index.do'" >메인페이지로</button>
				</div>
			</div>
		</div>
	</div>
	
</div>

<script type="text/javascript" src="/buengbueng/js/userInfo/signForm.js"></script>

<script type="text/javascript">

	$(document).ready(function(){
		$("#bossInfo").click(function(){
		$.ajax({
			url:"franchiseeAddAjaxBossInfo.do",
			type:"post",
			data:{
/* 				id:$("#id").val(),
				pw:$("#pw").val() */
				},
				success: function(data){
					$("#result").html(data);
				 }
			});
			});
			
		});
   
</script>


