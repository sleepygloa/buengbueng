<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<title>${pcNum}번 좌석 정보</title>
</head>

<body>
	<p>좌석 정보 수정</p>
	<form action="addModiPcInfo.do" method="post">
		<input type="hidden" value="${b_key}" name="b_key"/>
	<c:if test="${all == false}">
		pc 번호 : <input type="text" value="${pcNum}" name="num" readonly /><br/>
	</c:if>
	<c:if test="${all == true}">
		pc 번호 : <input type="text" value="${pcNum}" name="pcNum" readonly /><br/>
	</c:if>
		OS : <input type="text" value="${pcInfo.os}" name="os" /><br/>
		IP : <input type="text" value="${pcInfo.ip}" name="ip" /><br/>
		
		<p>본체 정보<p/>
		제품코드 : <input type="text" value="${computer.c_code}" name="c_code"/><br/>
		제조사 : <input type="text" value="${computer.c_company}" name="c_company"/><br/>
		제조일 : <input type="text" value="${computer.c_date}" name="computer_date"/><br/>
		제품명 : <input type="text" value="${computer.c_name}" name="c_name"/><br/>
		모델명 : <input type="text" value="${computer.c_model}" name="c_model"/><br/>
		CPU : <input type="text" value="${computer.c_cpu}" name="c_cpu"/><br/>
		Graphic : <input type="text" value="${computer.c_graphic}" name="c_graphic"/><br/>
		Hard : <input type="text" value="${computer.c_hard}" name="c_hard"/><br/>
		RAM : <input type="text" value="${computer.c_ram}" name="c_ram"/><br/>
		Power : <input type="text" value="${computer.c_power}" name="c_power"/><br/>
		LAN : <input type="text" value="${computer.c_lan}" name="c_lan"/><br/>
		Cooler : <input type="text" value="${computer.c_cooler}" name="c_cooler"/><br/>
		
		<p>모니터 정보<p/>
		제품코드 : <input type="text" value="${monitor.m_code}" name="m_code"/><br/>
		제조사 : <input type="text" value="${monitor.m_company}" name="m_company"/><br/>
		제조일 : <input type="text" value="${monitor.m_date}" name="monitor_date"/><br/>
		제품명 : <input type="text" value="${monitor.m_name}" name="m_name"/><br/>
		모델명 : <input type="text" value="${monitor.m_model}" name="m_model"/><br/>
		크기 : <input type="text" value="${monitor.m_inch}" name="m_inch"/><br/>
		해상도 : <input type="text" value="${monitor.m_resolution}" name="m_resolution"/><br/>
		액정 타입 : <input type="text" value="${monitor.m_display}" name="m_display"/><br/>
		커넥터 : <input type="text" value="${monitor.m_connector}" name="m_connector"/><br/>
		
		<p>키보드 정보<p/>
		제품코드 : <input type="text" value="${keyboard.k_code}" name="k_code"/><br/>
		제조사 : <input type="text" value="${keyboard.k_company}" name="k_company"/><br/>
		제품명 : <input type="text" value="${keyboard.k_name}" name="k_name"/><br/>
		종류 : <input type="text" value="${keyboard.k_type}" name="k_type"/><br/>
		커넥터 : <input type="text" value="${keyboard.k_connector}" name="k_connector"/><br/>
		
		<p>마우스 정보<p/>
		제품코드 : <input type="text" value="${mouse.mo_code}" name="mo_code"/><br/>
		제조사 : <input type="text" value="${mouse.mo_company}" name="mo_company"/><br/>
		제품명 : <input type="text" value="${mouse.mo_name}" name="mo_name"/><br/>
		종류 : <input type="text" value="${mouse.mo_type}" name="mo_type"/><br/>
		커넥터 : <input type="text" value="${mouse.mo_connector}" name="mo_connector"/><br/>
		
		<p>스피커 정보<p/>
		제품코드 : <input type="text" value="${speaker.s_code}" name="s_code"/><br/>
		제조사 : <input type="text" value="${speaker.s_company}" name="s_company"/><br/>
		제품명 : <input type="text" value="${speaker.s_name}" name="s_name"/><br/>
		커넥터 : <input type="text" value="${speaker.s_connector}" name="s_connector"/><br/>
		
		<br/>
		<input type="submit" value="수정"/>
	</form>
</body>