<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- class="col-xs-10-10 col-sm-5-10 col-md-5-10  col_height620 contentBox_outline" -->
<head>
	<link rel="stylesheet" type="text/css"  href="/buengbueng/css/erp.css">
</head>
<div class="addInfo_container">
	<div> <!-- class="contentBox col_height0" -->
		<form  action="employeeAddPro.do" method="post">
			<div class="contentBox_a"><p>직원 아이디 신청</p></div>
			<hr>
					<!-- 신청번호 -->
					<!-- class="col-xs-12-12 col-sm-12-12 col-md-12-12" -->
					<table class="addInfoForm">
						<tr>
							<th><p>신청 번호</p></th>
							<td>
								<c:if test="${beDTO.num == null}">
								1
							</c:if>
							<c:if test="${beDTO.num != null}">
								${beDTO.num+1}	
							</c:if>
							</td>
						</tr>
						<!-- 사장님아이디 -->
						<tr>
							<th><p>사장 아이디</p></th>
							<td>
								${b_id}<input class="col-xs-12-12 form-control" type="hidden" name="b_id" value="${b_id}" />
							</td>		
						</tr>
						<!-- 가맹점 라이센스 -->	
						<tr>
							<th><p>가맹점 라이센스</p></th>
							<td>
								${b_key}<input type="hidden" name="b_key" value="${b_key}" />
							</td>		
						</tr>
						<!-- 신청하는 아이디 개수 -->							
						<tr>
							<th><p>신청하는 ID 갯수</p></th>
							<td>
								<input class="addIdCount" type="text" name="applyCount" placeholder="신청하실 아이디 갯수를 입력해주세요."/>
							</td>		
						</tr>
						<!-- 신청사유 -->							
						<tr>
							<th><p>신청사유</p></th>
							<td>
								<textarea class="addIdText" name="content" rows="5" placeholder="신청사유를 입력해주세요."></textarea>
							</td>		
						</tr>
					</table>
					
					<!-- 버튼모음 -->
					
						<div class="addInfobtn_box">
						<div class="addInfobtn_btn_con">
						
							<input class="addInfobtn_btn1" type="submit" value="신청하기" />
							<input class="addInfobtn_btn2" type="button" value="취소하기"
							onclick="window.location='employeeManageInfo.do'" />
						</div>
						</div>
					
					
		</form>
	</div>
</div>


	
