<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<!-- HEADER TEMPLATE -->
<jsp:include page="../../header.jsp" />

	<!-- 페이지 제목 -->
	<div class=" margin_bottom50">
		<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
			<h3>ERP 아이디추가 페이지입니다.</h3>
		</div>
	</div>
	
<div class=" margin_bottom50">	
		<div class="col-xs-12-12">
			<div class="row col-xs-4-12">
				<div>
					<table style="border:solid 1px black">
						<thead>
							<th>알바생 아이디</th>
						</thead>
						<tbody>
							<tr><td>아이디</td></tr>
						</tbody>
						<tfoot>
						<tr>
							<td><input type="button" name="" value="알바생 추가" 
								onclick="getInfo()"/></td>
							<td><input type="button" name="" value="알바생 삭제"
								onclick="window.location=''" /></td>
							<td><input type="button" name="" value="▲" 
								onclick="window.location=''"/></td>
							<td><input type="button" name="" value="▼" 
								onclick="window.location=''"/></td>	
							<td><input type="button" name="" value="관리자가 아이디 추가" 
								onclick="window.location=''"/></td>	
						</tr>
						</tfoot>
					</table>
				</div>
			</div>
			<div class="row col-xs-6-12">
				<div>
					<div id="addInfo"></div>
				</div>
			
			</div>
	
</div>

<script type="text/javascript">
	function getInfo(){
		/* var b_name = b_name; */
 			$.ajax({
				url:"addEmployeeInfo.do",
				type:"post",
				success:function(data){
					$("#addInfo").html(data);
					alert("성공");
				}
			});
	}
</script>