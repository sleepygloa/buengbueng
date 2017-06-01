<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<br /><br /><br /><br /><br /><br />
<!-- SIDEMENU 위치 잡아주는 DIV -->
<div >
<!-- SIDEMENU 위치에서 실제로 사용할 영역 지정하는 DIV -->
	<div id="my_side">
	<!-- 링크 LIST -->
		<ul class="my_side_ul">
		<c:if test="${sidemenu == 1}">
			<li>가맹점 통계</li>
			<li><a href="franchiseeList.do" >가맹점 현황</a></li>
			<li><a href="franchiseeAdd.do" >가맹점 추가</a></li>
			<li>가맹점 추가신청</li>
		</c:if>
		</ul>
	
	</div>
</div> 