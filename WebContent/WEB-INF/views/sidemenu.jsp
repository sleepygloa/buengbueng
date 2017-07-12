<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<link rel="stylesheet" type="text/css"  href="/buengbueng/css/sidemenu.css">


<script type="text/javascript">
window.onload=function(){
	var id = '${sessionScope.loginId}';
	$.ajax({
		url : "franchiseeSelectList2.do",
		type: "post",
		data : {id : id},
		success:function(data){
			$('.flist').html(data);
		}
	});
}
$(document).ready(function(){
	$("#franchiseeSelect,#franchiseeSelect2").change(function(){
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
	<input type="hidden" value="${sessionScope.b_key}">
</head>

<body style="height:100%;">
<!-- SIDEMENU 위치에서 실제로 사용할 영역 지정하는 DIV -->
	<div class="sidemenu xs_hidden">
	<!-- 링크 LIST -->
		
<!-- --------------------------------------------------------- -->

<aside class="sidebar">
  <div id="leftside-navigation" class="nano">
    <ul class="nano-content">
    <c:if test="${sidemenu == 2}">
	    <li class="sub-menu">
	        <a href="searchPCForm.do"><i class="fa fa-table"></i><span>가맹점 PC이용현황</span><i class="arrow fa fa-angle-right pull-right"></i></a>
	        <ul>
	          <li><a href="searchPCNear.do">가맹점 PC이용현황</a>
	          </li>
	        </ul>
	      </li>
    </c:if>
    <c:if test="${sidemenu == 3}">
      <li>
        <a href="bossErpMain.do"><i class="fa fa-dashboard"></i><span>BuengBueng Dashboard</span></a>
      </li>
      <li>
		<select id="franchiseeSelect" class="flist">
		</select>
	 </li>
      <li class="sub-menu">
        <a href="#"><i class="fa fa-cogs"></i><span>알바생 관리</span><i class="arrow fa fa-angle-right pull-right"></i></a>
        <ul>

          <li><a href="employeeManageInfo.do">알바 아이디 관리</a>
          </li>
          <!-- <li><a href="employeeInfoList.do">신상관리</a>
          </li> -->
          <li><a href="employeeCalender.do">근무달력</a>
          </li>
          <li><a href="employeeCommute.do">출근하기</a>
          </li>
          <li><a href="employeeOffWork.do">퇴근하기</a>
          </li>
          <li><a href="employeeWorkTimeList.do">출근기록 확인하기</a>
          </li>
        </ul>
      </li>
      <li class="sub-menu">
        <a href=#><i class="fa fa-table"></i><span>가맹점 PC이용현황</span><i class="arrow fa fa-angle-right pull-right"></i></a>
        <ul>
          <li><a href="pcUseStatusList.do">가맹점 PC이용현황</a>
          </li>
        </ul>
      </li>
       <li class="sub-menu">
        <a href="javascript:void(0);"><i class="fa fa-map-marker"></i><span>주문 관리</span><i class="arrow fa fa-angle-right pull-right"></i></a>
        <ul>
          <li><a href="menuOrderListForm.do">가맹점 주문현황</a>
          </li>
        </ul>
      </li>
      <li class="sub-menu">
        <a href="#"><i class="fa fa fa-tasks"></i><span>일일정산</span><i class="arrow fa fa-angle-right pull-right"></i></a>
        <ul>
          <li><a href="applyForSettlement.do">일일정산 요청</a>
          </li>
          <li><a href="dailySettlementList.do">일일정산 내역</a>
          </li>
        </ul>
      </li>
      <li class="sub-menu active">
        <a href="#"><i class="fa fa-envelope"></i><span>메뉴</span><i class="arrow fa fa-angle-right pull-right"></i></a>
        <ul>
          <li class="active"><a href="menu.do">메뉴 관리</a>
          </li>
          <li class="active"><a href="product.do">재고 리스트</a>
          </li>
        </ul>
      </li>
      <li class="sub-menu">
        <a href="javascript:void(0);"><i class="fa fa-bar-chart-o"></i><span>PC방관리</span><i class="arrow fa fa-angle-right pull-right"></i></a>
        <ul>
          <li><a href="seatDispose.do">PC방 좌석 정보 관리</a>
          </li>
          <li><a href="seatState.do">PC방 좌석 이용 관리</a>
          </li>
        </ul>
      </li>
      <li class="sub-menu">
        <a href="javascript:void(0);"><i class="fa fa-map-marker"></i><span>대여 관리</span><i class="arrow fa fa-angle-right pull-right"></i></a>
        <ul>
          <li><a href="rentManage.do">대여물품 관리</a>
          </li>
        </ul>
      </li>
      </c:if>
      
      <c:if test="${sidemenu == 4}"> 
		<li class="sub-menu">
        	<a href="javascript:void(0);"><i class="fa fa-file"></i><span>PC방 찾기</span><i class="arrow fa fa-angle-right pull-right"></i></a>
	        <ul>
	          <li><a href="searchPCForm.do">PC방 찾기</a></li>
	          <li><a href="searchPCNear.do">우리동네 찾기</a></li>
	        </ul>
      	</li>
		<li class="sub-menu">
			<a href="javascript:void(0);"><i class="fa fa-file"></i><span>즐겨찾는 PC방</span><i class="arrow fa fa-angle-right pull-right"></i></a>
	        <ul>
	          <li><a href="favoritePCRoom.do">즐겨찾는 PC방</a>
	          </li>
	        </ul>
      	</li>
      </c:if>
      
     <c:if test="${sidemenu == 1}"> 
     <li class="sub-menu">
        <a href="javascript:void(0);"><i class="fa fa-file"></i><span>고객센터</span><i class="arrow fa fa-angle-right pull-right"></i></a>
        <ul>
          <li><a href="franchiseQA.do?snum=1">가맹문의</a></li>
          <li><a href="customerQA.do?snum=2">자주묻는 질문</a></li>
          <li><a href="oneQA.do?snum=3">1:1 문의</a></li>
          <li><a href="notice.do?snum=4&pageNum=1">공지사항</a></li>
        </ul>
      </li>
      </c:if>
    </ul>
  </div>
</aside>
<!-- --------------------------------------------------------- -->		
	
	</div>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
<script>
$("#leftside-navigation .sub-menu > a").click(function(e) {
  $("#leftside-navigation ul ul").slideUp(), $(this).next().is(":visible") || $(this).next().slideDown(),
  e.stopPropagation()
})
</script>

</body>

</html>