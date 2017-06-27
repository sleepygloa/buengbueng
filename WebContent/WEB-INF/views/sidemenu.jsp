<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/buengbueng/js/menu/onemoreCheck.js"></script>
<script type="text/javascript">
window.onload=function(){
	var id = '${sessionScope.loginId}';
	$.ajax({
		url : "franchiseeSelectList.do",
		type: "post",
		data : {id : id},
		success:function(data){
			$('.flist').html(data);
								}
			});
}
$(document).ready(function(){
	$("#franchiseeSelect").change(function(){
		var b_key =$(this).children("option:selected").val();
        $.ajax({
        	url: "franchiseeSelect.do",
        	type:"post",
        	data:{b_key:b_key},
        	success:function(data){
        		window.location="bossErpMain.do";
        	}
        });
})
})

</script>
${sessionScope.b_key}

<!-- SIDEMENU 위치에서 실제로 사용할 영역 지정하는 DIV -->
	<div class="sidemenu xs_hidden">
	<!-- 링크 LIST -->
		<ul class="my_side_ul">
<!-- --------------------------------------------------------- -->
		
		<c:if test="${sidemenu == 2}">
			<li>PC방 찾기</li>
			<li><hr /></li>
			<li><a href="searchPCForm.do" >PC방 찾기</a></li>
			<li><a href="searchPCNear.do" >우리동네 PC방 찾기</a></li>
		</c:if>
		
		<c:if test="${sidemenu == 3}">
			<li><a href="bossErpMain.do" >ERP관리 MAIN</a></li>
			<li>
				<select id="franchiseeSelect" class="flist">
				</select>
			
			</li>
			<li><hr /></li>
			<li>알바생 관리</li>
			<li><a href="employeeManageInfo.do" >알바아이디 관리</a></li>
			<li><a href="employeeInfoList.do" >신상 관리</a></li>
			<li><a href="" >알바 근태관리</a>
				<ul>
					<li><a class="minor-minor" href="employeeCalender.do">근무달력</a></li>
					<li><a class="minor-minor" href="">출근하기</a></li>
					<li><a class="minor-minor" href="">퇴근하기</a></li>
					<li><a class="minor-minor" href="">출근 기록 확인</a></li>
					<li><a class="minor-minor" href="employeeLoginList.do">알바 로그인 기록확인</a></li>
					<li><a class="minor-minor" href="">휴가 관리</a></li>
				</ul>
			</li>
			<li><a href="bossEmployeeAccountManage.do" >장부 관리</a></li>
		
			<li><hr /></li>
			<li>메뉴</li>
			<li><a href="menu.do" onclick="return getL_keyCheck(${sessionScope.b_key})">메뉴 관리</a></li>
			<li><a href="product.do">재고 관리</a></li>
			
			<li><hr /></li>
			<li>주문 확인</li>
			<li><a href="menuOrderListForm.do">주문 내역 확인</a></li>			
			
			<li><hr /></li>
			<li>주문 확인 (이거는 삭제할거예영)</li>
			<li><a href="userSelectFranchisee.do">사용자 주문창</a></li>
			
			
			<li><hr /></li>
			<li>PC방 관리</li>
			<li><a href="seatDispose.do" >PC방 좌석 정보 관리</a></li>
			<li><a href="seatState.do" >PC방 좌석 이용 관리</a></li>
			<li><hr /></li>
			<li>대여 관리</li>
			<li><a href="rentManage.do" >대여물품 관리</a></li>
		</c:if>	
			
		<c:if test="${sidemenu == 4}">
			<li>즐겨찾는 PC방</li>
			<li><hr /></li>
			<li><a href="favoritePCRoom.do" >즐겨찾는 PC방</a></li>
		</c:if>
		
		
<!-- --------------------------------------------------------- -->		
		</ul>
	</div>
