<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<script type="text/javascript">
	$(function () {
	 	$(".tab_content").hide();
	    $(".tab_content:first").show();
	    $("ul.tabs li:first").trigger('click');
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
<c:if test="${rentList.size() != 0}">
	<br/>
	<div id="container">
	    <ul class="tabs">
	    	<c:set var="num" value="1"/>
	   		<c:forEach var="rentList" items="${rentList}">
		     	<li rel="tab${num}" onclick="selectedproductList('${rentList.rentProduct}','${sessionScope.b_key}','tab${num}');">
				    &emsp;<input type="checkbox" name="rentName" value="${rentList.rentProduct}"/>&emsp;${rentList.rentProduct}&emsp;
				    <input type="button" class="modiBtn" value="수정" onclick="modiRent('${rentList.rentProduct}','${sessionScope.b_key}')"/>&emsp;
				</li>
				<c:set var="num" value="${num+1}"/>
			</c:forEach>
	    </ul>
	    <div class="tab_container">
	    	<c:set var="num" value="1"/>
	    	<c:forEach var="rentList" items="${rentList}">
		   		<div id="tab${num}" class="tab_content"></div>
		   		<c:set var="num" value="${num+1}"/>
			</c:forEach>
		</div>
	</div>
</c:if>
<c:if test="${rentList.size() == 0}">
	<table border="1" class="dailySettlementList_table">
		<tr class="dailySettlementList_NoCount">
			<td colspan="9">
				<p>
				<img src="/buengbueng/img/bossERP/bg_alert.gif" width="40" height="40">
					조회결과가 없습니다.
				</p>
			</td>
		</tr>
	</table>
</c:if>