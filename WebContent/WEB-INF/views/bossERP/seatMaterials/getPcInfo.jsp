<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<title>${pcNum}번 좌석 정보</title>
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
		<form action="addModiPcInfo.do" name="pcInfoForm" method="post" onsubmit="return checkPCInfo();">
			<input type="text" id="alert" readonly="readonly"/>&emsp;<input type="submit" class="floatRight" value="수정"/>
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
							<li>pc 번호 : <input type="text" value="${pcNum}" name="pcNum" readonly/></li>
							<li>OS : <input type="text" value="${pcInfo.os}" name="os"/></li>
							<li>IP : <input type="text" value="${pcInfo.ip}" name="ip"/></li>
							<c:if test="${all == false}">
								<li>상태 : <select name="state"><option>${pcInfo.state}</option>
											<c:if test="${pcInfo.state == '정상'}">
												<option>고장</option>
											</c:if>
											<c:if test="${pcInfo.state == '고장'}">
												<option>정상</option>
											</c:if>
										 </select>
								</li>
					 		</c:if>
					 		<c:if test="${all == true}">
					 			<li>상태 : <select name="state">
											<option>정상</option>
											<option>고장</option>
										 </select>
					 			</li>
					 		</c:if>
						</ul>
					</div>
					
					<div id="tab2" class="tab_content">
						<ul>
							<li>제품코드 : <input type="text" value="${computer.c_code}" name="c_code"/></li>
							<li>제조사 : <input type="text" value="${computer.c_company}" name="c_company"/></li>
							<li>제조일 : <input type="text" value="${computer.c_date}" name="computer_date"/></li>
							<li>제품명 : <input type="text" value="${computer.c_name}" name="c_name"/></li>
							<li>모델명 : <input type="text" value="${computer.c_model}" name="c_model"/></li>
							<li>CPU : <input type="text" value="${computer.c_cpu}" name="c_cpu"/></li>
							<li>Graphic : <input type="text" value="${computer.c_graphic}" name="c_graphic"/></li>
							<li>Hard : <input type="text" value="${computer.c_hard}" name="c_hard"/></li>
							<li>RAM : <input type="text" value="${computer.c_ram}" name="c_ram"/></li>
							<li>Power : <input type="text" value="${computer.c_power}" name="c_power"/></li>
							<li>LAN : <input type="text" value="${computer.c_lan}" name="c_lan"/></li>
							<li>Cooler : <input type="text" value="${computer.c_cooler}" name="c_cooler"/></li>
						</ul>
					</div>
					
					<div id="tab3" class="tab_content">
						<ul>
							<li>제품코드 : <input type="text" value="${monitor.m_code}" name="m_code"/></li>
							<li>제조사 : <input type="text" value="${monitor.m_company}" name="m_company"/></li>
							<li>제조일 : <input type="text" value="${monitor.m_date}" name="monitor_date"/></li>
							<li>제품명 : <input type="text" value="${monitor.m_name}" name="m_name"/></li>
							<li>모델명 : <input type="text" value="${monitor.m_model}" name="m_model"/></li>
							<li>크기 : <input type="text" value="${monitor.m_inch}" name="m_inch"/></li>
							<li>해상도 : <input type="text" value="${monitor.m_resolution}" name="m_resolution"/></li>
							<li>액정 타입 : <input type="text" value="${monitor.m_display}" name="m_display"/></li>
							<li>커넥터 : <input type="text" value="${monitor.m_connector}" name="m_connector"/></li>
						</ul>
					</div>
					
					<div id="tab4" class="tab_content">
						<ul>
							<li>제품코드 : <input type="text" value="${keyboard.k_code}" name="k_code"/></li>
							<li>제조사 : <input type="text" value="${keyboard.k_company}" name="k_company"/></li>
							<li>제품명 : <input type="text" value="${keyboard.k_name}" name="k_name"/></li>
							<li>종류 : <input type="text" value="${keyboard.k_type}" name="k_type"/></li>
							<li>커넥터 : <input type="text" value="${keyboard.k_connector}" name="k_connector"/></li>
						</ul>
					</div>
					
					<div id="tab5" class="tab_content">
						<ul>
							<li>제품코드 : <input type="text" value="${mouse.mo_code}" name="mo_code"/></li>
							<li>제조사 : <input type="text" value="${mouse.mo_company}" name="mo_company"/></li>
							<li>제품명 : <input type="text" value="${mouse.mo_name}" name="mo_name"/></li>
							<li>종류 : <input type="text" value="${mouse.mo_type}" name="mo_type"/></li>
							<li>커넥터 : <input type="text" value="${mouse.mo_connector}" name="mo_connector"/></li>
						</ul>
					</div>
					
					<div id="tab6" class="tab_content">
						<ul>
							<li>제품코드 : <input type="text" value="${speaker.s_code}" name="s_code"/></li>
							<li>제조사 : <input type="text" value="${speaker.s_company}" name="s_company"/></li>
							<li>제품명 : <input type="text" value="${speaker.s_name}" name="s_name"/></li>
							<li>커넥터 : <input type="text" value="${speaker.s_connector}" name="s_connector"/></li>
						</ul>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>