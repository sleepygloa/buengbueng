<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css" media="all" href="/buengbueng/css/dist/modules.min.css">
<link rel="stylesheet" type="text/css" media="all" href="/buengbueng/css/dist/bootstrap.min.css">
<link rel="stylesheet" type="text/css" media="all" href="/buengbueng/css/dist/bootstrap-theme.min.css">
<div class="col-xs-12-12 margin-bottom50"></div>
<div class="col-xs-12-12"><label>알바일정</label></div>
	<div class="col-xs-12-12">

	<form action="employeeCalenderInsertPro.do" method="post">
		<div style="border:1xp solid black" class="col-xs-12-12"><label>id : ${id}</label></div>
		<div class="col-xs-12-12">
			<div style="border:1xp solid black" class="col-xs-6-12">
			시작일<br />
			<input type="date" name="startDate" value="${starts}" />
			<select name="startHour">
				<option value="0000">00:00</option>
				<option value="0100">01:00</option>
				<option value="0200">02:00</option>
				<option value="0300">03:00</option>
				<option value="0400">04:00</option>
				<option value="0500">05:00</option>
				<option value="0600">06:00</option>
				<option value="0700">07:00</option>
				<option value="0800">08:00</option>
				<option value="0900">09:00</option>
				<option value="1000">10:00</option>
				<option value="1100">11:00</option>
				<option value="1200">12:00</option>
				<option value="1300">13:00</option>
				<option value="1400">14:00</option>
				<option value="1500">15:00</option>
				<option value="1600">16:00</option>
				<option value="1700">17:00</option>
				<option value="1800">18:00</option>
				<option value="1900">19:00</option>
				<option value="2000">20:00</option>
				<option value="2100">21:00</option>
				<option value="2200">22:00</option>
				<option value="2300">23:00</option>
				<option value="2400">24:00</option>
			</select>
			</div>
			<div style="border:1xp solid black" class="col-xs-6-12">
			종료일<br />
			<input type="date" name="endDate" value="${ends}"/>
			<select name="endHour">
				<option value="0000">00:00</option>
				<option value="0100">01:00</option>
				<option value="0200">02:00</option>
				<option value="0300">03:00</option>
				<option value="0400">04:00</option>
				<option value="0500">05:00</option>
				<option value="0600">06:00</option>
				<option value="0700">07:00</option>
				<option value="0800">08:00</option>
				<option value="0900">09:00</option>
				<option value="1000">10:00</option>
				<option value="1100">11:00</option>
				<option value="1200">12:00</option>
				<option value="1300">13:00</option>
				<option value="1400">14:00</option>
				<option value="1500">15:00</option>
				<option value="1600">16:00</option>
				<option value="1700">17:00</option>
				<option value="1800">18:00</option>
				<option value="1900">19:00</option>
				<option value="2000">20:00</option>
				<option value="2100">21:00</option>
				<option value="2200">22:00</option>
				<option value="2300">23:00</option>
				<option value="2400">24:00</option>
			</select>
			</div>	
		</div>
		반나절 <input type="checkbox" name="allDay" value="allDay" />
		<input class="btn btn-default col-xs-12-12" type="submit" value="신청하기" onclick="self.close()" />
	</form>
	</div>


<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
