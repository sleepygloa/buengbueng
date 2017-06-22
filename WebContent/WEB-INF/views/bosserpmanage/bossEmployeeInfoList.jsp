<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
function getInfo(b_name){
	var b_name = b_name;
		$.ajax({
			url:"franchiseeInfo.do",
			type:"post",
			data:
				{ b_name : b_name },
			success:function(data){
				$("#franchiseeInfo").html(data);
			}
		})
}

</script>


<!-- HEADER TEMPLATE -->
<jsp:include page="../header.jsp" />

	<!-- 페이지 제목 -->
	<div class=" margin_bottom50">
		<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
			<h3>알바생 정보 수정하는 페이지</h3>
		</div>
	</div>
	
<div class=" margin_bottom50">	
		<div class="col-xs-12-12">
		
			<!-- 글 갯수 -->
			<div class="row">
				<div class="col-xs-6-12 col-sm-6-12 col-md-6-12">
알바생 아이디 수 (${count})
				</div>
				<div class="col-xs-6-12 col-sm-6-12 col-md-6-12">
<input type="button" name="" value="알바생 추가" onclick="" />
<input type="button" name="" value="알바생 삭제" onclick="" />
				</div>
			</div>

			<!-- 카테고리 -->
			<div class="row">
				<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
					${menuDiv}		
			<!-- 리스트 -->
				</div>
			</div>
			<div class="info"></div>
	</div>
</div>

