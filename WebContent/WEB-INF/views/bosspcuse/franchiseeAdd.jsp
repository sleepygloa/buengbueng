<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- HEADER TEMPLATE -->
<jsp:include page="../header.jsp" />

<!-- SIDEMENU TEMPLATE -->
<c:if test="${sidemenu == 1}">
	<jsp:include page="../sidemenu.jsp" />
</c:if>

<!-- ARTICLE -->
<section class="side_content">


<!-- 							<th class="radius-left-top">
								<input id="bossInfo" type="button" value="사장님 보유한 PC방정보를 불러오시겠습니까?" />
							</th> -->

	<!-- 페이지 제목 -->
	<div class="container margin_bottom50">
		가맹점 신청 PAGE!
	</div>
	
	<div class="container margin_bottom50">	
		<div class="col-xs-12-12 col-sm-12-12 col-md-12-12 table form-horizontal">
			
			<div class="row">
				<div class="col-sm-4-12 xs_hidden">
					카테고리
				</div>
				<div class="col-sm-8-12 xs_hidden">
					입력
				</div>
				<div class="col-sm-12-12 sm_hidden">
					입력폼
				</div>
			</div>
		
			<form action="franchiseeAddPro.do" method="post">
				<!-- 회원 ID -->
				<div class=row>
					<div class="col-xs-4-12 xs_hidden control-label">
						ID
					</div>
					<div class="col-xs-8-12">
						<c:if test="${userDto.id != null}">
							<div class="sm_hidden ">ID<br /></div>
							<div>
								<input class="col-sm-12-12" type="text" name="id"  />
							</div>
						</c:if>
						<c:if test="${userDto.id == null}">비회원</c:if>
					</div>
				</div>
				<!-- 회원 GRADE -->
				<div class="row">
					<div class="col-xs-4-12 xs_hidden">
						등급
					</div>
					<div class="col-xs-8-12 ">
						<div class="sm_hidden">등급<br /></div>
						<c:if test="${userDto.grade == 0}">관리자</c:if>
						<c:if test="${userDto.grade == 1}">사장</c:if>
						<c:if test="${userDto.grade == 2}">알바</c:if>
						<c:if test="${userDto.grade == 3}">사용자</c:if>
					</div>
				</div>
				<!-- 상호명 -->
				<div class="row">
					<div class="col-xs-4-12 xs_hidden">
						상호명
					</div>
					<div class="col-xs-8-12">
						<div class="sm_hidden">상호명<br /></div>
						<input type="text" name="b_name" placeholder="10자 이내로 력해주세요"/>
					</div>
				</div>					
				<!-- 사업자 번호 -->
				<div class="row">
					<div class="col-xs-4-12 xs_hidden">
						사업자번호
					</div>
					<div class="col-xs-8-12">
						<div class="sm_hidden">사업자번호<br /></div>
						<input type="text" name="b_number_1" size="3"  maxlength="3" onblur="return checkB_number_1();"/>-
						<input type="text" name="b_number_2" size="2"  maxlength="2" onblur="return checkB_number_2();"/>-
						<input type="text" name="b_number_3" size="5"   maxlength="5" onblur="return checkB_number_3();"/>	
					</div>
				</div>	
				<!-- 사업장 주소 -->
				<div class="row">
					<div class="col-xs-4-12 xs_hidden">
						사업장 주소
					</div>
					<div class="col-xs-8-12">
						<div class="sm_hidden">사업장 주소<br /></div>
						<input type="text" name="b_address" placeholder="사업장 주소 입력" onblur="return checkB_address();">
					</div>
				</div>					
				<!-- 사업장 전화번호 -->
				<div class="row">
					<div class="col-xs-4-12 xs_hidden">
						사업장 전화번호
					</div>
					<div class="col-xs-8-12">
						<div class="sm_hidden">사업장 전화번호<br /></div>
						<input type="text" name="b_tel1" size="3" maxlength="3" onblur="return checkB_tel1();">-
						<input type="text" name="b_tel2" size="4" maxlength="4" onblur="return checkB_tel2();">-
						<input type="text" name="b_tel3" size="4" maxlength="4" onblur="return checkB_tel3();">
					</div>
				</div>					
				<!-- 사업장 규모 -->
				<div class="row">
					<div class="col-xs-4-12 xs_hidden">
						사업장 규모
					</div>
					<div class="col-xs-8-12">
						<div class="sm_hidden">사업장 규모<br /></div>
						<input type="text" name="b_size" placeholder="사업장 규모 입력 (평 수)" onblur="return checkB_size();">	
					</div>
				</div>	
				<!-- 보유 컴퓨터수 -->
				<div class="row">
					<div class="col-xs-4-12 xs_hidden">
						보유 컴퓨터 수
					</div>
					<div class="col-xs-8-12">
						<div class="sm_hidden">보유 컴퓨터 수<br /></div>
						<input type="text" name="b_name" placeholder="10자 이내로 력해주세요"/>
					</div>
				</div>	
				<!-- 사업장 사장님컴퓨터 IP -->
				<div class="row">
					<div class="col-xs-4-12 xs_hidden">
						사업장 사장님컴퓨터 IP
					</div>
					<div class="col-xs-8-12">
						<div class="sm_hidden">사업장 사장님 컴퓨터 IP<br /></div>
						${ip}
						<input type="hidden" value="${ip}" />
					</div>
				</div>		
				<!-- 사업장 주소 -->
				<div class="row">
					<div class="col-xs-4-12 xs_hidden">
						사업장 주소
					</div>
					<div class="col-xs-8-12">
						<div class="sm_hidden">사업장 주소<br /></div>
						<input type="text" name="b_address" placeholder="사업장 주소 입력" onblur="return checkB_address();">
					</div>
				</div>		
				<!-- 버튼 -->
				<div class="row">
					<div class="col-xs-12-12 xs_hidden">
						<input type="submit" value="신청하기" />
					</div>
					<div class="col-xs-12-12 xs_hidden">
						<input type="button" value="취소하기" />
					</div>					
					<div class="col-xs-6-12 col-sm-12-12">
						<input type="submit" value="신청하기" />
						<input type="button" value="취소하기" />
					</div>
				</div>	
			</form>	
		</div>
	</div>
	
	<div class="container">
		<input type="button" value="메인페이지로" onclick="window.location='index.do'" />
	</div>
	
</section>

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