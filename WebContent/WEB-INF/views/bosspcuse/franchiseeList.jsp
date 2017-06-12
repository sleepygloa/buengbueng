<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<style>
[class*=col-]{margin-bottom:5px} /* 모든 클래스들 중 col- 로 시작하는 것들을 정의, grid간 아랫공간 띄우기*/
</style>
<script type="text/javascript">
	function getInfo(b_name){
		var b_name = b_name;
			$.ajax({
				url:"franchiseeInfo.do",
				type:"post",
				data:
					{ b_name : b_name },
				success:function(data){
					$("#franchiseeInfo").html(data);
				}
			})
	}
</script>
<!-- HEADER TEMPLATE -->
<jsp:include page="../header.jsp" />

	<!-- 페이지 제목 -->
	<div class="margin_bottom50">
		<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
			<h3>가맹점 현황</h3>
		</div>
	</div>
	<!--  -->
	<div class="margin_bottom50">
		<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
			<div class="row">
				<div>
				가맹점은 사장님마다 여러개의 가맹점을 보유하 실 수 있습니다 <br />
				현재 운영중인 PC방을 가맹점 신청하여 관리를 받으실 수도 있고, 새로 가맹점으로부터 운영을 시작할 수도 있습니다.<br />
				가맹점을 운영하려면, 먼저 가맹점을 신청해주세요! <br />
				<a href="franchiseeAdd.do" >가맹점 추가</a>
				<a href="franchiseeDelete.do" >가맹점 삭제신청</a>
				</div>
			</div>
		</div>
	</div>

<!-- 메인 주요기능 : 카드 섹션? 영역 -------------------------------------------------->
<div class="main_card_wrap row col-xs-12-12">
    <div class="main_card_content">
        <div class="card_title_wrap">`
            <h3 class="card_title">보유 가맹점 수 : ${count1}</h3>
        </div>
<div id="franchiseeInfo"></div>
	    <div class="card_content_wrap">
            <div class="row bg2">
<!-- 카드섹션 컨텐츠------------------------------------------------------------ -->
<c:forEach var="article" items="${articleList1}">
                <div class="col-xs-12-12 col-sm-6-12 col-md-4-12">
                    <div class="offer__function__section scalable">
                        <div class="card_icon"></div>
                        <h6  class="minor" onclick="getInfo('${article.b_name}');" value="">${article.b_name}</h6>
                        <span class="goProduct">${article.b_key}</span>
                    </div>
                </div>
</c:forEach>

			</div>
		</div>
	</div>
</div>


<!-- 메인 주요기능 : 카드 섹션? 영역 -------------------------------------------------->
<div class="main_card_wrap row col-xs-12-12">
    <div class="main_card_content">
        <div class="card_title_wrap">
            <h3 class="card_title">신청 중인 가맹점 수 : ${count2}</h3>
        </div>
<div id="franchiseeInfo"></div>
	    <div class="card_content_wrap">
            <div class="row bg2">
<!-- 카드섹션 컨텐츠------------------------------------------------------------ -->
<c:forEach var="article" items="${articleList2}">
                <div class="col-xs-12-12 col-sm-6-12 col-md-4-12">
                    <div class="offer__function__section scalable">
                        <div class="card_icon"></div>
                        <h6  class="minor" onclick="getInfo('${article.b_name}');" value="">${article.b_name}</h6>
                        <p class="tool__section__desc">
							<c:if test="${article.result == 0}">
								<input class="btn" type="button" value="승인대기중"
								onclick="window.location='franchiseeConfirm.do?num=${article.num}&b_name=${article.b_name}'" /> 
							</c:if>
							<c:if test="${article.result == 1}">
								<input class="btn" type="button" value="승인완료" /> 
							</c:if>
							<c:if test="${article.result == 2}">
								<input class="btn" type="button" value="보류" /> 
							</c:if>	
						</p>

                    </div>
                </div>
      					<p class="tool__section__desc">${article.date}</p>
						<p class="tool__section__desc">${article.finishDate}</p>
                        <span class="goProduct">${article.b_key}</span>
</c:forEach>

			</div>
		</div>
	</div>
</div>

<!-- FOOTER TEMPLATE -->
<jsp:include page="../footer.jsp" />