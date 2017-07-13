<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	$(function () {
	    $(".tab_content").hide();
	    $(".tab_content:first").show();
	    $("ul.tabs li:first").addClass("active").css("color", "blue");
	    $("ul.tabs li").click(function () {
	        $("ul.tabs li").removeClass("active").css("color", "#333");
	        $(this).addClass("active").css("color", "blue");
	        $(".tab_content").hide();
	        var activeTab = $(this).attr("rel");
	        $("#" + activeTab).fadeIn();
	    });
	});
</script>

<div class="userInfoDetail">
	<p class="center"><b>No.${pcNum}</b></p>
	<p class="rignt"><b>&emsp;${id}&nbsp;님&emsp;</b></p>
	<p class="rignt">&emsp;로그인&emsp;${startTime}&emsp;</p><br/>
	
	<div id="container">
	    <ul class="tabs">
	        <li class="active" rel="tab1">대여물품</li>
	        <li rel="tab2">메뉴</li>
	    </ul>
		<div class="tab_container">
			<div id="tab1" class="tab_content">
				<ul>
					<c:if test="${rentOrderList.size() == 0}">
						<li>대여 중인 물품이 없습니다.</li>
					</c:if>
					<c:forEach var="rent" items="${rentOrderList}">
						<li><b>물품명</b> [${rent.name}]&emsp;&emsp;<b>바코드</b> [${rent.code}]</li>
					</c:forEach>
				</ul>
			</div>
			<div id="tab2" class="tab_content">
				<ul>
					<c:if test="${menuOrderList.size() == 0}">
						<li>주문한 메뉴가 없습니다.</li>
					</c:if>
					<c:forEach var="menu" items="${menuOrderList}">
						<li><b>메뉴명</b> [${menu.menuname}]&emsp;&emsp;<b>바코드</b> [${menu.code}]&emsp;&emsp;<b>가격</b> [${menu.ordermoney}]</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</div>