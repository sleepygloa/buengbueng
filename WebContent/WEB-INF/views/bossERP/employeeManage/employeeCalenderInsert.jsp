<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<c:if test="${check != 9}">

      <form action="employeeCalenderInsertPro.do" method="post">
   		<h2>알바일정</h2>
         <br />
         	아이디 : <input  type="button" value="${id}" /><br /><br />
			시작일 : <input type="hidden" name="startDate" value="${starts}" /><input type="button" name="startDate" value="${starts}" /><br />
            
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
            </select><br />
            
            종료일 : <input type="hidden" name="endDate" value="${ends}"/><input type="button" name="endDate" value="${ends}"/><br />
            근무일수 :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input class="date_button" type="button" value="${forDate}"/> 일<input  type="hidden" name="forDate" value="${forDate}"/><br /><br />
            표시 색상 : <select  class="date_selectbox" name="backgroundColor"  id="sel" onchange="backgroundCh();" style="background-color:#7092BE;color:#7092BE">
				<option class="date_selectbox_blue" value="#7092BE" selected="selected" >파랑</option>
            	<option class="date_selectbox_red" value="#FFAEC9">분홍</option>
            	<option class="date_selectbox_brown" value="#B97A57">갈색</option>
            	<option class="date_selectbox_yellow" value="#EFE4B0">연노랑</option>
            	<option class="date_selectbox_green" value="#B5E61D">초록</option>
            </select><br /><br />
                     
            <br /><br />
            <input class="date_submit col-xs-12-12" type="submit" value="신청하기"  /> 
      </form>

</c:if>
