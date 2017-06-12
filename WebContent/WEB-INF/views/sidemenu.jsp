<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!-- SIDEMENU 위치에서 실제로 사용할 영역 지정하는 DIV -->
	<div class="sidemenu xs_hidden">
	<!-- 링크 LIST -->
		<ul class="my_side_ul">
<!-- --------------------------------------------------------- -->

		
		<c:if test="${sidemenu == 2}">
			<li>PC방 찾기</li>
			<li><a href="searchPCForm.do" >PC방 찾기</a></li>
			<li><a href="franchiseeAdd.do" >우리동네 PC방 찾기</a></li>
		</c:if>
		
		<c:if test="${sidemenu == 3}">
			<li><a href="bossErpManageMain.do" >ERP관리 MAIN</a></li>
			<li><hr /></li>
			<li>알바생 관리</li>
			<li><a href="bossEmployeeManageMain.do" >ㅇ</a></li>
			<li><a href="bossEmployeeAdd.do" >아이디 수 변경</a></li>
			<li><a href="bossEmployeeInfoList.do" >아이디 관리</a></li>
			<li><a href="bossEmployeeLoginLogoutLogManage.do" >알바 근태관리</a></li>
			<li><a href="bossEmployeeAccountManage.do" >장부 관리</a></li>
		</c:if>		
<!-- --------------------------------------------------------- -->		
		</ul>
	</div>