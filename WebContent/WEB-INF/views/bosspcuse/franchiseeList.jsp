<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<style>
[class*=col-]{margin-bottom:5px} /* 모든 클래스들 중 col- 로 시작하는 것들을 정의, grid간 아랫공간 띄우기*/

@media screen and (min-width:250px){
	.main_ad{font-size:14px;}
}
@media screen and (min-width:768px){
	.main_ad{font-size:14px;}
}
@media screen and (min-width:1200px){
	.main_ad{font-size:16px;}
}
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

<!-- 메인 화면 전광판  ------------------------------------------------------------>
<div class="main_ad" style="background-color:#fff;height:100%;">
	<div class="main_ad_content">
			<div class="col-xs-10-10 main_ad_contentBox">

				<div class="col-xs-10-10 col-sm-10-10 col-md-10-10  col_height230 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a"><a href="#">가맹점 현황</a></div>
						<div>				
				가맹점은 사장님마다 여러개의 가맹점을 보유하 실 수 있습니다 <br />
				현재 운영중인 PC방을 가맹점 신청하여 관리를 받으실 수도 있고, 새로 가맹점으로부터 운영을 시작할 수도 있습니다.<br />
				가맹점을 운영하려면, 먼저 가맹점을 신청해주세요! <br />
				<br />
				<a href="franchiseeAdd.do" >가맹점 추가</a> / <a href="franchiseeDelete.do" >가맹점 삭제신청</a>
            
            <%--설치파일 추가 --%>
            <c:if test="${count1 != 0}">
               <select id="setupFile">
                  <option disabled="disabled" selected="selected">설치파일 다운로드</option>
                  <c:forEach var="file" items="${fileName}">
                     <option onclick="window.location='down.do?fileName=${file}'">${file}</option>
                  </c:forEach>
               </select>
               <script type="text/javascript">
                  $("#setupFile").change(function(){
                     window.location = "down.do?fileName="+$(this).val();
                  });
               </script>
            </c:if>
					</div>
				</div>
<div class="col-xs-10-10 hr"></div>				
				<div class="col-xs-10-10 col-sm-10-10 col-md-10-10  col_height30 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a"><a href="#">보유 가맹점 수 : ${count1}</a></div>
					</div>
				</div>

<div id="franchiseeInfo" class="col-xs-10-10 col-sm-10-10 col-md-10-10  contentBox_outline"></div>

<c:forEach var="article" items="${articleList1}">
				<div class="col-xs-10-10 col-sm-4-12 col-md-4-12  col_height120 contentBox_outline" style="border:0.8px solid #e7e7e7;padding:0 auto">
					<div class="contentBox col_height0">
						<div class="contentBox_a">
							<h6  class="minor" onclick="getInfo('${article.b_name}');" value="">${article.b_name}</h6>
						</div>
						<div><span class="goProduct">${article.b_key}</span></div>
					</div>
				</div>
</c:forEach>



<div class="col-xs-10-10 hr"></div>				
				<div class="col-xs-10-10 col-sm-10-10 col-md-10-10  col_height30 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a"><a href="#">신청 중인 가맹점 수 : ${count2}</a></div>
					</div>
				</div>

<div id="franchiseeInfo"></div>

<c:forEach var="article" items="${articleList2}">
				<div class="col-xs-10-10 col-sm-4-12 col-md-4-12  col_height140 contentBox_outline" style="border:0.8px solid #e7e7e7;padding:0 auto">
					<div class="contentBox col_height0">
						<div class="contentBox_a">
							<h6  class="minor" onclick="getInfo('${article.b_name}');" value="">${article.b_name}</h6>
						</div>
						<div>
							<c:if test="${article.result == 0}">
								<input class="btn" type="button" value="승인대기중"
								onclick="window.location='franchiseeConfirm.do?num=${article.num}&b_name=${article.b_name}'" /> 
							</c:if>
							<c:if test="${article.result == 2}">
								<input class="btn" type="button" value="보류" /> 
							</c:if>	
						</div>
					</div>
				</div>
</c:forEach>






		</div>
	</div>
</div>

<!-- FOOTER TEMPLATE -->
<jsp:include page="../footer.jsp" />