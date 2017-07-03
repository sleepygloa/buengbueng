<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
	<title>${pcNum}번 좌석 정보</title>
</head>

<body>
		<p>좌석 정보 보기</p>
		pc 번호 : <input type="text" value="${pcInfo.num}" name="num" readonly /><br/>
		OS : <input type="text" value="${pcInfo.os}" name="os" readonly/><br/>
		IP : <input type="text" value="${pcInfo.ip}" name="ip" readonly/><br/>
		상태 : <input type="text" value="${pcInfo.state}" name="state" readonly/><br/>
		
		<p>본체 정보<p/>
		제품코드 : <input type="text" value="${computer.c_code}" name="c_code" readonly/><br/>
		제조사 : <input type="text" value="${computer.c_company}" name="c_company" readonly/><br/>
		제조일 : <input type="text" value="${computer.c_date}" name="computer_date" readonly/><br/>
		제품명 : <input type="text" value="${computer.c_name}" name="c_name" readonly/><br/>
		모델명 : <input type="text" value="${computer.c_model}" name="c_model" readonly/><br/>
		CPU : <input type="text" value="${computer.c_cpu}" name="c_cpu" readonly/><br/>
		Graphic : <input type="text" value="${computer.c_graphic}" name="c_graphic" readonly/><br/>
		Hard : <input type="text" value="${computer.c_hard}" name="c_hard" readonly/><br/>
		RAM : <input type="text" value="${computer.c_ram}" name="c_ram" readonly/><br/>
		Power : <input type="text" value="${computer.c_power}" name="c_power" readonly/><br/>
		LAN : <input type="text" value="${computer.c_lan}" name="c_lan" readonly/><br/>
		Cooler : <input type="text" value="${computer.c_cooler}" name="c_cooler" readonly/><br/>
		
		<p>모니터 정보<p/>
		제품코드 : <input type="text" value="${monitor.m_code}" name="m_code" readonly/><br/>
		제조사 : <input type="text" value="${monitor.m_company}" name="m_company" readonly/><br/>
		제조일 : <input type="text" value="${monitor.m_date}" name="monitor_date" readonly/><br/>
		제품명 : <input type="text" value="${monitor.m_name}" name="m_name" readonly/><br/>
		모델명 : <input type="text" value="${monitor.m_model}" name="m_model" readonly/><br/>
		크기 : <input type="text" value="${monitor.m_inch}" name="m_inch" readonly/><br/>
		해상도 : <input type="text" value="${monitor.m_resolution}" name="m_resolution" readonly/><br/>
		액정 타입 : <input type="text" value="${monitor.m_display}" name="m_display" readonly/><br/>
		커넥터 : <input type="text" value="${monitor.m_connector}" name="m_connector" readonly/><br/>
		
		<p>키보드 정보<p/>
		제품코드 : <input type="text" value="${keyboard.k_code}" name="k_code" readonly/><br/>
		제조사 : <input type="text" value="${keyboard.k_company}" name="k_company" readonly/><br/>
		제품명 : <input type="text" value="${keyboard.k_name}" name="k_name" readonly/><br/>
		종류 : <input type="text" value="${keyboard.k_type}" name="k_type" readonly/><br/>
		커넥터 : <input type="text" value="${keyboard.k_connector}" name="k_connector" readonly/><br/>
		
		<p>마우스 정보<p/>
		제품코드 : <input type="text" value="${mouse.mo_code}" name="mo_code" readonly/><br/>
		제조사 : <input type="text" value="${mouse.mo_company}" name="mo_company" readonly/><br/>
		제품명 : <input type="text" value="${mouse.mo_name}" name="mo_name" readonly/><br/>
		종류 : <input type="text" value="${mouse.mo_type}" name="mo_type" readonly/><br/>
		커넥터 : <input type="text" value="${mouse.mo_connector}" name="mo_connector" readonly/><br/>
		
		<p>스피커 정보<p/>
		제품코드 : <input type="text" value="${speaker.s_code}" name="s_code" readonly/><br/>
		제조사 : <input type="text" value="${speaker.s_company}" name="s_company" readonly/><br/>
		제품명 : <input type="text" value="${speaker.s_name}" name="s_name" readonly/><br/>
		커넥터 : <input type="text" value="${speaker.s_connector}" name="s_connector" readonly/><br/>
</body>