<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
.bg1{
background-color:#e3e3e3;
}
</style>

<!-- HEADER TEMPLATE -->
<jsp:include page="../header.jsp" />

<!-- 알바 총계 레코드 -->
<c:set var="totalPaySize" value="${ewcList.size()-1}" />


<form action="" method="">
	<!-- 페이지 제목 -->
	<div class=" margin_bottom50">
		<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
			<h3>ERP PC방 장부관리</h3>
		</div>
	</div>
	
<!-- 총 -->
<div class="bg1 main_card_wrap row margin_bottom50">
	<div class="main_card_content col-xs-12-12 col-sm-12-12 col-md-12-12">

		<div class="card_content_wrap">
			<div class="row">
				<div class="col-xs-12-12">
					총 급여 : ${ewcList[2].count * 1.8} 원
					<c:set var="totalPaySize" value="${ewcList.size()-1}" />
					<input type="hidden" name="totalPay" value="${ewcList[totalPaySize].count * 1.8}" />				
				</div>
			<c:forEach var="employee" items="${ewcList}">
			<c:if test="${employee.id != null}" >
                <div class="col-xs-12-12 col-sm-6-12 col-md-4-12">
                    <a class="offer__function__section scalable"  href="">
                        <div class="card_icon ux-heatmap"></div>
                        <h6 class=" minor">${employee.id}</h6>
                        <p class="tool__section__desc">일한 시간<br />${employee.count} 초<br />
                        예상 급여 : ${employee.count * 1.8 } 원</p>
                    </a>
                </div>
               </c:if>
               	</c:forEach>
             </div>
		</div>
	</div>
</div>

<!-- 알바예상급여 -->
<div class="bg1 main_card_wrap row margin_bottom50">
	<div class="main_card_content col-xs-12-12 col-sm-12-12 col-md-12-12">

		<div class="card_content_wrap">
			<div class="row">
				<div class="col-xs-12-12">
					총 급여 : ${ewcList[2].count * 1.8} 원
					
					<input type="hidden" name="totalPay" value="${ewcList[totalPaySize].count * 1.8}" />				
				</div>
			<c:forEach var="employee" items="${ewcList}">
			<c:if test="${employee.id != null}" >
                <div class="col-xs-12-12 col-sm-6-12 col-md-4-12">
                    <a class="offer__function__section scalable"  href="">
                        <div class="card_icon ux-heatmap"></div>
                        <h6 class=" minor">${employee.id}</h6>
                        <p class="tool__section__desc">일한 시간<br />${employee.count} 초<br />
                        예상 급여 : ${employee.count * 1.8 } 원</p>
                    </a>
                </div>
               </c:if>
               	</c:forEach>
             </div>
		</div>
	</div>
</div>	

<!-- PC방 매출 -->
<div class="bg1 row margin_bottom50">
	<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
	가자
	</div>
</div>

<!-- 유지보스 -->
<div class="row margin_bottom50">
	<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
	가자
	</div>
</div>

</form>