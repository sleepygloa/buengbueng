<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- HEADER TEMPLATE -->
<jsp:include page="../header.jsp" />

<!-- SIDEMENU TEMPLATE -->
<c:if test="${sidemenu == 1}">
	<jsp:include page="../sidemenu.jsp" />
</c:if>

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

<!-- ARTICLE -->

<!-- 페이지 제목 -->
<div class="pricing__title--wrap container">
이 페이지는 가맹점을 추가하는 페이지입니다. 
</div>

<div class="pricing--wrap container">
<div  class="container for-desktop">
	<div class="row">
		<div class="col-md-12-12">
			<form action="franchiseeAddPro.do" method="post">

				<table id="result">
					<thead>
						<tr>
							<th></th>
							<th class="radius-left-top">
								<input id="bossInfo" type="button" value="사장님 보유한 PC방정보를 불러오시겠습니까?" />
							</th>
						</tr>					
						<tr>
							<th></th>
							<th class="radius-left-top">카테고리</th>
							<th>입력</th>
						</tr>
					</thead>
					
					<tbody>
						<tr>
							<td rowspan="2"> </td>
							<td>회원아이디</td>
							<td>
								<c:if test="${userDto.id != null}">${userDto.id}<input type="hidden" value="${userDto.id}" /></c:if>
								<c:if test="${userDto.id == null}">비회원</c:if>
								
							</td>
						</tr>
						<tr>

							<td>회원 등급</td>
							<td>
								<c:if test="${userDto.grade == 0}">사용자</c:if>
								<c:if test="${userDto.grade == 1}">사장</c:if>
								<c:if test="${userDto.grade == 2}">알바</c:if>
								<c:if test="${userDto.grade == 3}">관리자</c:if>
							</td>
						</tr>					
						<tr>
							<td rowspan="7"> </td>
							<td>상호명</td>
							<td>
								<input type="text" name="b_name" placeholder="10자 이내로 력해주세요"/>
							</td>
						</tr>					
						<tr>
							<td>사업자번호</td>
							<td>
								<input type="text" name="b_number_1" size="3"  maxlength="3" onblur="return checkB_number_1();"/>-
								<input type="text" name="b_number_2" size="2"  maxlength="2" onblur="return checkB_number_2();"/>-
								<input type="text" name="b_number_3" size="5"   maxlength="5" onblur="return checkB_number_3();"/>								
							</td>
						</tr>						
						<tr>
							<td>사업장 주소</td>
							<td>
								<input type="text" name="b_address" placeholder="사업장 주소 입력" onblur="return checkB_address();">
							</td>
						</tr>						
						<tr>
							<td>사업장 전화번호</td>
							<td>
								<input type="text" name="b_tel1" size="3" maxlength="3" onblur="return checkB_tel1();">-
								<input type="text" name="b_tel2" size="4" maxlength="4" onblur="return checkB_tel2();">-
								<input type="text" name="b_tel3" size="4" maxlength="4" onblur="return checkB_tel3();">							
							</td>
						</tr>						
						<tr>
							<td>사업장 규모</td>
							<td>
								<input type="text" name="b_size" placeholder="사업장 규모 입력 (평 수)" onblur="return checkB_size();">						
							</td>
						</tr>						
						<tr>
							<td>보유 컴퓨터수</td>
							<td>
								<input type="text" name="b_pccount" placeholder="보유 PC 수 입력" onblur="return checkB_pccount();"> 대
							</td>
						</tr>						
						<tr>
							<td>사장님 컴퓨터 IP</td>
							<td>
								${ip}
								<input type="hidden" value="${ip}" />
							</td>
						</tr>											
						<tr>
							<td></td>
							<td>결정</td>
							<td>
								<input type="submit" value="신청하기" />
								<input type="button" value="취소하기" />
							</td>
						</tr>						
					</tbody>
					
				</table>
			</form>	
		</div>
	</div>
</div>

</div>

<input type="button" value="메인페이지로" onclick="window.location='index.do'" />

<br /><br /><br /><br /><br />

<script type="text/javascript" src="/buengbueng/js/userInfo/signForm.js"></script>

<!-- FOOTER TEMPLATE -->
<jsp:include page="../footer.jsp" />