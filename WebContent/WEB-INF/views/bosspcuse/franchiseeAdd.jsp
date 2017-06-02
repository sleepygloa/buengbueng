<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- HEADER TEMPLATE -->
<jsp:include page="../header.jsp" />

<!-- SIDEMENU TEMPLATE -->
<c:if test="${sidemenu == 1}">
	<jsp:include page="../sidemenu.jsp" />
</c:if>

<!-- ARTICLE -->
<div class="side_content">


	<!-- 페이지 제목 -->
	<div class="container margin_bottom50">
		가맹점 신청 PAGE!
	</div>
	
	<div class="container margin_bottom50">	
		<div class="col-xs-12-12 col-sm-12-12 col-md-12-12 form-horizontal">
					
			<form action="franchiseeAddPro.do" method="post">
				<!-- 회원 ID -->
				<div class="row">
					<label class="col-md-2-12 xsm_hidden ">
						ID
					</label>
					<div class="col-md-10-12 col-xs-12-12">
						<c:if test="${userDto.id != null}">
							<label class="md_hidden">ID<br /></label>
							<div class="form-group">
								<input class="col-xs-12-12 form-control" type="text" name="id" placeholder="아이디를 입력하세요" />
							</div>
						</c:if>
						<c:if test="${userDto.id == null}">비회원</c:if>
					</div>
				</div>
				<!-- 회원 GRADE -->
				<div class="row">
					<label class="col-md-2-12 xsm_hidden ">
						등급
					</label>
					<div class="col-md-10-12 col-xs-12-12">
						<c:if test="${userDto.grade != null}">
							<label class="md_hidden">등급<br /></label>
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
					<label class="col-md-2-12 xsm_hidden ">
						상호명
					</label>
					<div class="col-md-10-12 col-xs-12-12">
							<label class="md_hidden">상호명<br /></label>
							<div class="form-group">
								<input class="col-xs-12-12 form-control" type="text" name="b_name" placeholder="상호명을 입력하세요" />
							</div>
					</div>
				</div>
				<!-- 사업자 번호 -->
				<div class="row">
					<label class="col-md-2-12 xsm_hidden ">
						사업자번호
					</label>
					<div class="form-inline col-md-10-12 col-xs-12-12">
							<label class="md_hidden">사업자번호<br /></label>
							<div class="form-group col-xs-1-12">
								<input class=" form-control" type="text" name="b_number_1" size="3"  maxlength="3" onblur="return checkB_number_1();"/>	
							</div>
							<div class="form-group col-xs-1-12">
								<label>-</label>     
								<input class=" form-control" type="text" name="b_number_2" size="2"  maxlength="2" onblur="return checkB_number_2();"/>	
							</div>
							<div class="form-group col-xs-1-12">
								<label>-</label>     
								<input class=" form-control" type="text" name="b_number_3" size="5"   maxlength="5" onblur="return checkB_number_3();"/>	
							</div>														
					</div>
				</div>				
				<!-- 사업장 주소 -->
				<div class="row">
					<label class="col-md-2-12 xsm_hidden ">
						사업장 주소
					</label>
					<div class="col-md-10-12 col-xs-12-12">
							<label class="md_hidden">사업장 주소<br /></label>
							<div class="form-group">
								<input class="col-xs-12-12 form-control" type="text" name="b_address" placeholder="사업장 주소 입력" onblur="return checkB_address();">
							</div>
					</div>
				</div>	
				<!-- 사업장 전화번호 -->
				<div class="row">
					<label class="col-md-2-12 xsm_hidden ">
						사업장 전화번호
					</label>
					<div class="col-md-10-12 col-xs-12-12">
							<label class="md_hidden">사업장 전화번호<br /></label>
							<div class="form-group">
								<input type="text" name="b_tel1" size="3" maxlength="3" onblur="return checkB_tel1();">-
								<input type="text" name="b_tel2" size="4" maxlength="4" onblur="return checkB_tel2();">-
								<input type="text" name="b_tel3" size="4" maxlength="4" onblur="return checkB_tel3();">
							</div>
					</div>
				</div>
				<!-- 사업장 규모 -->
				<div class="row">
					<label class="col-md-2-12 xsm_hidden ">
						사업장 규모
					</label>
					<div class="col-md-10-12 col-xs-12-12">
							<label class="md_hidden">사업장 규모<br /></label>
							<div class="form-group">
								<input class="col-xs-12-12 form-control" type="text" name="b_size" placeholder="사업장 규모 입력 (평 수)" onblur="return checkB_size();">	
							</div>
					</div>
				</div>
				<!-- 보유 컴퓨터수 -->
				<div class="row">
					<label class="col-md-2-12 xsm_hidden ">
						보유컴퓨터 수
					</label>
					<div class="col-md-10-12 col-xs-12-12">
							<label class="md_hidden">보유컴퓨터 수<br /></label>
							<div class="form-group">
								<input class="col-xs-12-12 form-control" type="text" name="b_pccount" placeholder="보유한 컴퓨터 대수를 입력하세요" onblur="return checkB_size();">	
							</div>
					</div>
				</div>	
				<!-- 사업장 사장님컴퓨터 IP -->
				<div class="row">
					<label class="col-md-2-12 xsm_hidden ">
						사업장 사장님컴퓨터 IP
					</label>
					<div class="col-md-10-12 col-xs-12-12">
							<label class="md_hidden">사업장 사장님컴퓨터 IP<br /></label>
							<div class="form-group">
								${ip}
						<input type="hidden" value="${ip}" />
							</div>
					</div>
				</div>							
				<!-- 버튼 -->
				<div class="row">
					<div class="col-xs-12-12 sm_hidden">
						<input class="btn btn-default" type="submit" value="신청하기" />
					</div>
					<div class="col-xs-12-12 sm_hidden">
						<input class="btn btn-default" type="button" value="취소하기" />
					</div>					
					<div class="xs_hidden col-sm-12-12">
						<input class="btn btn-default" type="submit" value="신청하기" />
						<input class="btn btn-default" type="button" value="취소하기" />
					</div>
				</div>	
			</form>	
		</div>
	</div>
	
	<div class="container">
		<input type="button" value="메인페이지로" onclick="window.location='index.do'" />
	</div>
	
</div>

<script type="text/javascript" src="/buengbueng/js/userInfo/signForm.js"></script>

<script type="text/javascript">
/* 
$(document).ready(function(){
      $("#2").click(function(){
         $.ajax({
            url:"ajax.do",
            dataType : "json",
            success:function(model){
               $("#result").html(model.result);
               $("#result").append(model.id);
               $("#result").append(model.age);
               
            },
         });
      });
   });
 */   
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


<!-- FOOTER TEMPLATE -->
<jsp:include page="../footer.jsp" />