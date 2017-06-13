<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>


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
				<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
알바생 아이디 수 (${count})
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

