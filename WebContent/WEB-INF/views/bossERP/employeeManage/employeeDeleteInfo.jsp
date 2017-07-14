<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
	<link rel="stylesheet" type="text/css"  href="/buengbueng/css/erp.css">
</head>

<div class="addInfo_container">
	<div> <!-- class="contentBox col_height0" -->
		<form  action="employeeAddPro.do" method="post">
			<div class="contentBox_a"><p>직원 아이디 삭제</p></div>
			<hr>
			
			<table class="addInfoForm">
						<tr>
							<th><p>신청 번호</p></th>
							<td>
								<c:if test="${logNum == null}">
								1
								</c:if>
								<c:if test="${logNum != null}">
									${logNum+1}	
								</c:if>
							</td>
						</tr>
						<!-- 사장님아이디 -->
						<tr>
							<th><p>삭제할 직원 아이디</p></th>
							<td>
								${e_id}
								<input class="col-xs-12-12 form-control" type="hidden" name="e_id" value="${e_id}" />
							</td>		
						</tr>
						<!-- 가맹점 라이센스 -->	
						<tr>
							<th><p>가맹점 라이센스</p></th>
							<td>
								${sessionScope.b_key}
							</td>		
						</tr>
						<!-- 신청하는 아이디 개수 -->							
						<tr>
							<th><p>신청 사유</p></th>
							<td>
								<textarea class="col-xs-12-12 col-md-10-12 form-control" name="content" rows="5"></textarea>
							</td>		
						</tr>		
						</tr>
					</table>
					<!-- 버튼모음 -->
					<div class="addInfobtn_box">
						<div class="addInfobtn_btn_con">
						
							<input class="addInfobtn_btn1" type="submit" value="신청하기" />
							<input class="addInfobtn_btn2" type="button" value="취소하기"
							onclick="window.location='index.do'" />
						</div>
						</div>
					<!-- <div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<div class="form-group">
							<input class="btn btn-success col-xs-12-12 col-sm-12-12 col-md-12-12" type="submit" value="신청하기" />
							<input class="btn btn-default col-xs-12-12 col-sm-12-12 col-md-12-12" type="button" value="취소하기"
							onclick="window.location='index.do'" />
	
						</div>
					</div>	 -->		
					
		</form>
	</div>
</div>

