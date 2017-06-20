<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<div class="col-xs-12-12">
	<form action="" method="post">
		<div class="col-xs-12-12">id : ${id}</div>
		<div class="col-xs-6-12">
		시작일<input type="date" name="start" value="${starts}" />${starts}
		</div>
		<div class="col-xs-6-12">
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
		<div class="col-xs-6-12">
		종료일<input type="date" name="end" value="${ends}"/>${ends}
		</div>	
		<div>
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
		반나절 <input type="checkbox" name="allDay" value="allDay" />
		<input type="submit" value="신청하기" onclick="self.close()" />
	</form>
	</div>
</div>