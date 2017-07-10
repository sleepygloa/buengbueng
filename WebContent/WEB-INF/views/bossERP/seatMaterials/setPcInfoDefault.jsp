<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<title>좌석 관리</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/buengbueng/js/bossERP/seatDispose.js"></script>
	<link rel="stylesheet" type="text/css" href="/buengbueng/css/bossERP/seatDispose.css">
	<script type="text/javascript">
		$(function () {
		    $(".tab_content").hide();
		    $(".tab_content:first").show();
		    $(".tabs li:first").addClass("active").css("color", "red");
		    $(".tabs li").click(function () {
		        $(".tabs li").removeClass("active").css("color", "#333");
		        $(this).addClass("active").css("color", "red");
		        $(".tab_content").hide();
		        var activeTab = $(this).attr("rel");
		        $("#" + activeTab).fadeIn();
		    });
		});
	</script>
</head>

<body>
<jsp:include page="/WEB-INF/views/dashHeader.jsp"/>
<div class="pcInfoDefault">
	<form action="managePcInfoPro.do" name="pcInfoForm" method="post" onsubmit="return checkPCInfoDefault();">
		<br/><br/>
		<input type="text" id="alert" readonly="readonly"/>&emsp;<input type="submit" class="modiBtn3" value="수정"/>
		<br/><br/>
		<div id="container">
		    <ul class="tabs">
		        <li class="active" rel="tab1">&emsp;좌석 정보&emsp;</li>
		        <li rel="tab2">&emsp;본체 정보&emsp;</li>
		        <li rel="tab3">&emsp;모니터 정보&emsp;</li>
		        <li rel="tab4">&emsp;키보드 정보&emsp;</li>
		        <li rel="tab5">&emsp;마우스 정보&emsp;</li>
		        <li rel="tab6">&emsp;스피커 정보&emsp;</li>
		    </ul>
			<div class="tab_container">
				<div id="tab1" class="tab_content">
		        	<ul>
						<li>OS : <input type="text" name="os" /></li>
					</ul>
				</div>
				
				<div id="tab2" class="tab_content">
					<ul>
						<li>제조사 : <input type="text" name="c_company"/></li>
						<li>제품명 : <input type="text" name="c_name"/></li>
						<li>모델명 : <input type="text" name="c_model"/></li>
						<li>CPU : <input type="text" name="c_cpu"/></li>
						<li>Graphic : <input type="text" name="c_graphic"/></li>
						<li>Hard : <input type="text" name="c_hard"/></li>
						<li>RAM : <input type="text" name="c_ram"/></li>
						<li>Power : <input type="text" name="c_power"/></li>
						<li>LAN : <input type="text" name="c_lan"/></li>
						<li>Cooler : <input type="text" name="c_cooler"/></li>
					</ul>
				</div>
						
				<div id="tab3" class="tab_content">
					<ul>
						<li>제조사 : <input type="text" name="m_company"/></li>
						<li>제품명 : <input type="text" name="m_name"/></li>
						<li>모델명 : <input type="text" name="m_model"/></li>
						<li>크기 : <input type="text" name="m_inch"/></li>
						<li>해상도 : <input type="text" name="m_resolution"/></li>
						<li>액정 타입 : <input type="text" name="m_display"/></li>
						<li>커넥터 : <input type="text" name="m_connector"/></li>
					</ul>
				</div>
						
				<div id="tab4" class="tab_content">
					<ul>
						<li>제조사 : <input type="text" name="k_company"/></li>
						<li>제품명 : <input type="text"name="k_name"/></li>
						<li>종류 : <input type="text" name="k_type"/></li>
						<li>커넥터 : <input type="text" name="k_connector"/></li>
					</ul>
				</div>
						
				<div id="tab5" class="tab_content">
					<ul>
						<li>제조사 : <input type="text" name="mo_company"/><li>
						<li>제품명 : <input type="text" name="mo_name"/><li>
						<li>종류 : <input type="text" name="mo_type"/><li>
						<li>커넥터 : <input type="text" name="mo_connector"/><li>
					</ul>
				</div>
						
				<div id="tab6" class="tab_content">
					<ul>
						<li>제조사 : <input type="text" name="s_company"/><li>
						<li>제품명 : <input type="text" name="s_name"/><li>
						<li>커넥터 : <input type="text" name="s_connector"/><li>
					</ul>
				</div>
			</div>
		</div>
	</form>
</div>
<jsp:include page="/WEB-INF/views/dashFooter.jsp"/>
</body>