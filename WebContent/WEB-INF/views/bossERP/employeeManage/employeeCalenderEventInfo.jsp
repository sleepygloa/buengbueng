<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	
	<form action="employeeCalenderEventInfoUpdatePro.do" method="post" >
		<h2>일정 세부정보</h2>
 		<br />
		현재 시작일정 : ${eventInfoDateStart}<input type="hidden" name="eventInfoDateStart" value="${eventInfoDateStart}" /><br />
		현재 종료일정 : ${eventInfoDateEnd}<input type="hidden" name="eventInfoDateEnd" value="${eventInfoDateEnd}" /><br />
 		<br />
 		변경 시작일정 : <input type="text" name="eventInfoChagneDateStart" /><br />
 		변경 종료일정 : <input type="text" name="eventInfoChangeDateEnd" /><br />
 		<br />
 		<input class="col-xs-6-12" type="submit" value="변경" />
		<input class="col-xs-6-12" id="asd" type="button" value="삭제"
		onClick="employeeEventDelete()" />
		
 	</form>		

