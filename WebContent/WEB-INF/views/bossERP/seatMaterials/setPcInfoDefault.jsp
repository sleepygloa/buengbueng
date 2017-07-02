<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<title>좌석 정보 관리</title>
	<script type="text/javascript" src="/buengbueng/js/bossERP/seatDispose.js"></script>
	<link rel="stylesheet" type="text/css" href="/buengbueng/css/bossERP/seatDispose.css">
</head>

<jsp:include page="/WEB-INF/views/dashHeader.jsp" />

<body>
	<p>좌석 정보 관리</p>
	<input type="text" id="alert" readonly="readonly"/>
	<form action="managePcInfoPro.do" name="pcInfoForm" method="post" onsubmit="return checkPCInfoDefault();">
		OS : <input type="text" name="os" /><br/>

		<p>본체 정보<p/>
		제조사 : <input type="text" name="c_company"/><br/>
		제품명 : <input type="text" name="c_name"/><br/>
		모델명 : <input type="text" name="c_model"/><br/>
		CPU : <input type="text" name="c_cpu"/><br/>
		Graphic : <input type="text" name="c_graphic"/><br/>
		Hard : <input type="text" name="c_hard"/><br/>
		RAM : <input type="text" name="c_ram"/><br/>
		Power : <input type="text" name="c_power"/><br/>
		LAN : <input type="text" name="c_lan"/><br/>
		Cooler : <input type="text" name="c_cooler"/><br/>
		
		<p>모니터 정보<p/>
		제조사 : <input type="text" name="m_company"/><br/>
		제품명 : <input type="text" name="m_name"/><br/>
		모델명 : <input type="text" name="m_model"/><br/>
		크기 : <input type="text" name="m_inch"/><br/>
		해상도 : <input type="text" name="m_resolution"/><br/>
		액정 타입 : <input type="text" name="m_display"/><br/>
		커넥터 : <input type="text" name="m_connector"/><br/>
		
		<p>키보드 정보<p/>
		제조사 : <input type="text" name="k_company"/><br/>
		제품명 : <input type="text"name="k_name"/><br/>
		종류 : <input type="text" name="k_type"/><br/>
		커넥터 : <input type="text" name="k_connector"/><br/>
		
		<p>마우스 정보<p/>
		제조사 : <input type="text" name="mo_company"/><br/>
		제품명 : <input type="text" name="mo_name"/><br/>
		종류 : <input type="text" name="mo_type"/><br/>
		커넥터 : <input type="text" name="mo_connector"/><br/>
		
		<p>스피커 정보<p/>
		제조사 : <input type="text" name="s_company"/><br/>
		제품명 : <input type="text" name="s_name"/><br/>
		커넥터 : <input type="text" name="s_connector"/><br/>
		
		<br/>
		<input type="submit" value="수정"/>
	</form>
</body>