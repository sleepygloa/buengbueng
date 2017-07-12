<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<script type="text/javascript">
		$(function () {
		    $(".tab_content").hide();
		    $(".tab_content:first").show();
		    $("ul.tabs li:first").addClass("active").css("color", "red");
		    $("ul.tabs li").click(function () {
		        $("ul.tabs li").removeClass("active").css("color", "#333");
		        $(this).addClass("active").css("color", "red");
		        $(".tab_content").hide();
		        var activeTab = $(this).attr("rel");
		        $("#" + activeTab).fadeIn();
		    });
		});
	</script>
</head>

<body>
	<div class="pcInfoDetail">
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
						<li>pc 번호 : <input type="text" value="${pcInfo.num}" readonly/></li>
						<li>OS : <input type="text" value="${pcInfo.os}" readonly/></li>
						<li>IP : <input type="text" value="${pcInfo.ip}" readonly/></li>
						<li>상태 : <input type="text" value="${pcInfo.state}" readonly/></li>
					</ul>
				</div>
				
				<div id="tab2" class="tab_content">
					<ul>
						<li>제품코드 : <input type="text" value="${computer.c_code}" readonly/></li>
						<li>제조사 : <input type="text" value="${computer.c_company}" readonly/></li>
						<li>제조일 : <input type="text" value="${computer.c_date}" readonly/></li>
						<li>제품명 : <input type="text" value="${computer.c_name}" readonly/></li>
						<li>모델명 : <input type="text" value="${computer.c_model}" readonly/></li>
						<li>CPU : <input type="text" value="${computer.c_cpu}" readonly/></li>
						<li>Graphic : <input type="text" value="${computer.c_graphic}" readonly/></li>
						<li>Hard : <input type="text" value="${computer.c_hard}" readonly/></li>
						<li>RAM : <input type="text" value="${computer.c_ram}" readonly/></li>
						<li>Power : <input type="text" value="${computer.c_power}" readonly/></li>
						<li>LAN : <input type="text" value="${computer.c_lan}" readonly/></li>
						<li>Cooler : <input type="text" value="${computer.c_cooler}" readonly/></li>
					</ul>
				</div>
				
				<div id="tab3" class="tab_content">
					<ul>
						<li>제품코드 : <input type="text" value="${monitor.m_code}" readonly/></li>
						<li>제조사 : <input type="text" value="${monitor.m_company}" readonly/></li>
						<li>제조일 : <input type="text" value="${monitor.m_date}" readonly/></li>
						<li>제품명 : <input type="text" value="${monitor.m_name}" readonly/></li>
						<li>모델명 : <input type="text" value="${monitor.m_model}" readonly/></li>
						<li>크기 : <input type="text" value="${monitor.m_inch}" readonly/></li>
						<li>해상도 : <input type="text" value="${monitor.m_resolution}" readonly/></li>
						<li>액정 타입 : <input type="text" value="${monitor.m_display}" readonly/></li>
						<li>커넥터 : <input type="text" value="${monitor.m_connector}" readonly/></li>
					</ul>
				</div>
				
				<div id="tab4" class="tab_content">
					<ul>
						<li>제품코드 : <input type="text" value="${keyboard.k_code}" readonly/></li>
						<li>제조사 : <input type="text" value="${keyboard.k_company}" readonly/></li>
						<li>제품명 : <input type="text" value="${keyboard.k_name}" readonly/></li>
						<li>종류 : <input type="text" value="${keyboard.k_type}"readonly/></li>
						<li>커넥터 : <input type="text" value="${keyboard.k_connector}" readonly/></li>
					</ul>
				</div>
				
				<div id="tab5" class="tab_content">
					<ul>
						<li>제품코드 : <input type="text" value="${mouse.mo_code}" readonly/></li>
						<li>제조사 : <input type="text" value="${mouse.mo_company}" readonly/></li>
						<li>제품명 : <input type="text" value="${mouse.mo_name}" readonly/></li>
						<li>종류 : <input type="text" value="${mouse.mo_type}" readonly/></li>
						<li>커넥터 : <input type="text" value="${mouse.mo_connector}" readonly/></li>
					</ul>
				</div>
				
				<div id="tab6" class="tab_content">
					<ul>
						<li>제품코드 : <input type="text" value="${speaker.s_code}" readonly/></li>
						<li>제조사 : <input type="text" value="${speaker.s_company}" readonly/></li>
						<li>제품명 : <input type="text" value="${speaker.s_name}" readonly/></li>
						<li>커넥터 : <input type="text" value="${speaker.s_connector}" readonly/></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>