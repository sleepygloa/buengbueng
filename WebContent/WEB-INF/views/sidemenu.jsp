<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



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
			<li><hr /></li>
			<li>알바생 관리</li>
			<li><a href="employeeManage.do" >알바아이디 관리</a></li>
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
			<li>메뉴 관리</li>
			<li><a href="franchiseeMenu.do">메뉴</a></li>
			<li><a href="menuInsertForm.do" >메뉴 추가</a></li>
			<li><a href="menuModify.do" >메뉴 수정</a></li>
			<li><a href="menuDeleteForm.do" >메뉴 삭제</a></li>
		
			<li><hr /></li>
			<li>재고 관리</li>
			<li><a href="product.do">재고 리스트</a></li>
			<li><a href="productInsertForm.do" >재고 추가</a></li>
			<li><a href="productModify.do" >재고 수정</a></li>
			<li><a href="productDeleteForm.do" >재고 삭제</a></li>
			
			
			<li><hr /></li>
			<li>주문 확인 (이거는 삭제할거예영)</li>
			<li><a href="userOrderForm.do">사용자 주문창</a></li>
			<li><a href="menuOrderListForm.do" >사장님 주문내역확인</a></li>
			
			<li><hr /></li>
			<li>PC방 관리</li>
			<li><a href="seatDisposeMain.do" >PC방 좌석 정보 관리</a></li>
			<li><a href="seatStateMain.do" >PC방 좌석 이용 관리</a></li>
			<li><hr /></li>
			<li>대여 관리</li>
			<li><a href="rentMain.do" >대여물품 관리</a></li>
		</c:if>	
			
		<c:if test="${sidemenu == 4}">
			<li>즐겨찾는 PC방</li>
			<li><hr /></li>
			<li><a href="favoritePCRoom.do" >즐겨찾는 PC방</a></li>
		</c:if>
		
		
<!-- --------------------------------------------------------- -->		
		</ul>
	</div>