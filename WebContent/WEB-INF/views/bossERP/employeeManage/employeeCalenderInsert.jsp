<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css" media="all" href="/buengbueng/css/bossERP/popup.css">

<style>
.date_button{
display:box;
padding:5px;
font-size:1.2em;
border : none;
background-color:#fff;
}
.date_selectbox{
padding:5 15px;
font-size:1.2em;
border:none;
}
.div_deco{
border-bottom:1px solid #f5f5f5;
padding:10 0px;
}
</style>
<c:if test="${check == 9}">

 <script>
 opener.parent.location.reload();
	function sc(){
		opener=self;
		
		setTimeout('self.close()',500);
	}
</script> 
	<body onload="sc()"></body>
</c:if>
<c:if test="${check != 9}">

	<div class="col-xs-12-12"><!-- 내용 -->
	<div class="margin-bottom50"></div><!-- 여백 -->
	
		<div class="container popup_container">
	
			<div class="popup_title"><label>알바일정</label></div>
			
			<form action="employeeCalenderInsertPro.do" method="post">
			<div class="popup_id"><label>아이디 : ${id}</label></div>
			<div class="popup_content">
				<div class="col-xs-12-12 div_deco">
				<span>시작일</span>&nbsp;&nbsp;
				<input type="hidden" name="startDate" value="${starts}" />
				<input class="date_button" type="button" name="startDate" value="${starts}" />
				<select class="date_selectbox" name="startHour">
					<option value="0">00:00</option>
					<option value="3600000">01:00</option>
					<option value="7200000">02:00</option>
					<option value="10800000">03:00</option>
					<option value="14400000">04:00</option>
					<option value="18000000">05:00</option>
					<option value="21600000">06:00</option>
					<option value="25200000">07:00</option>
					<option value="28800000">08:00</option>
					<option value="32400000">09:00</option>
					<option value="36000000">10:00</option>
					<option value="39600000">11:00</option>
					<option value="43200000">12:00</option>
					<option value="46800000">13:00</option>
					<option value="50400000">14:00</option>
					<option value="54000000">15:00</option>
					<option value="57600000">16:00</option>
					<option value="61200000">17:00</option>
					<option value="64800000">18:00</option>
					<option value="68400000">19:00</option>
					<option value="72000000">20:00</option>
					<option value="75600000">21:00</option>
					<option value="79200000">22:00</option>
					<option value="82800000">23:00</option>
					<option value="86400000">24:00</option>
				</select>
				~
				<select class="date_selectbox" name="endHour">
					<option value="0">00:00</option>
					<option value="3600000">01:00</option>
					<option value="7200000">02:00</option>
					<option value="10800000">03:00</option>
					<option value="14400000">04:00</option>
					<option value="18000000">05:00</option>
					<option value="21600000">06:00</option>
					<option value="25200000">07:00</option>
					<option value="28800000">08:00</option>
					<option value="32400000">09:00</option>
					<option value="36000000">10:00</option>
					<option value="39600000">11:00</option>
					<option value="43200000">12:00</option>
					<option value="46800000">13:00</option>
					<option value="50400000">14:00</option>
					<option value="54000000">15:00</option>
					<option value="57600000">16:00</option>
					<option value="61200000">17:00</option>
					<option value="64800000">18:00</option>
					<option value="68400000">19:00</option>
					<option value="72000000">20:00</option>
					<option value="75600000">21:00</option>
					<option value="79200000">22:00</option>
					<option value="82800000">23:00</option>
					<option value="86400000">24:00</option>
				</select>
				</div>
				
				<div  class="col-xs-12-12 div_deco">
				종료일&nbsp;&nbsp;<input type="hidden" name="endDate" value="${ends}"/>
				<input class="date_button" type="button" name="endDate" value="${ends}"/><br />
				기간&nbsp;&nbsp;<input type="button" name="for" value="${forDate}"/>
				</div>	
			</div>
			<div class="popup-btn">
				<!-- <input class="btn btn-default col-xs-12-12" type="submit" value="신청하기"/> -->
				<input class="btn btn-default col-xs-12-12" type="submit" value="신청하기"  /> 
			</div>
		</form>
		</div>
	
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

</c:if>