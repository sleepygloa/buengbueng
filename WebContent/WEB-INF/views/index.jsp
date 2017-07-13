<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${check==1}">
<script>
alert('정보가 틀립니다.');
history.go(-1);
</script>
</c:if>
<!-- HEADER TEMPLATE -->
<jsp:include page="header.jsp" /> 

<script>
indexNoticeList(); //공지사항 리스트
indexFranchiseeList(); //가맹문의 리스트

function indexNoticeList(){
	$.ajax({
		url:"indexNoticeList.do",
		type:"post",
		success:function(data){
			$("#indexNoticeList").html(data);
		}
	})
}
function indexFranchiseeList(){
	$.ajax({
		url:"indexFranchiseeList.do",
		type:"post",
		success:function(data){
			$("#indexFranchiseeList").html(data);
		}
	})
}
</script>
<style>
.side_scontent{
background-color:#EEF1F2;
}
</style>

<!-- ARTICLE -->
<!-- 메인 화면 전광판  ------------------------------------------------------------>
<div class="main_ad" style="background-color:#EEF1F2;height:100%;">
	<div class="main_ad_content">
			<div class="col-xs-10-10 main_ad_contentBox">
				<div class="col-xs-10-10 col-sm-5-10 col-md-4-10 col_height200 contentBox_outline contentBox_right">
					<div class="contentBox col_height0" >
						<div class="login_title">
							<p>환영합니다. 원활한 이용을 위해 로그인이 필요합니다.</p>
						</div>
						<div class="contentBox_img_banner"><a href="loginForm.do"><img src="/buengbueng/img/index/login_banner.png" width="100%;" height="50px;" /></a></div>
						<div class="contentBox_login_other">
							<ul>
								<li class="col-xs-4-12 mb0"><a href="userInfoSignForm.do">회원가입</a></li>
								<li class="col-xs-4-12 mb0"><a href="userInfoSearchPwForm.do">비밀번호 찾기</a></li>
								<li class="col-xs-4-12 mb0"><a href="userInfoSearchIdForm.do">아이디 찾기</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-xs-10-10 col-sm-5-10 col-md-2-10  col_height200 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a"><a href="cash.do">포인트 결제</a></div>
						<div><i class="fa fa-krw fa-4x" aria-hidden="true"></i></div>
					</div>
				</div>
				<div class="col-xs-10-10 col-sm-5-10 col-md-2-10 col_height200 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a"><a href="cashHistory.do">결제내역 조회</a></div>
						<div><i class="fa fa-credit-card fa-4x" aria-hidden="true"></i></div>
					</div>
				</div>
				<div class="col-xs-10-10 col-sm-5-10 col-md-2-10 col_height200 contentBox_outline">
					<div class="contentBox col_height0" >
						<div class="contentBox_a"><a href="ledger.do">이용내역 조회</a></div>
						<div><i class="fa fa-bar-chart fa-4x" aria-hidden="true"></i></div>
					</div>
				</div>

				<div class="col-xs-10-10 col-sm-5-10 col-md-2-10 col_height200 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a"><a href="franchiseeList.do">가맹점 관리</a></div>
						<div><i class="fa fa-pencil-square-o fa-4x" aria-hidden="true"></i></div>
					</div>
				</div>
				<div class="col-xs-10-10 col-sm-5-10 col-md-4-10 col_height200 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a"><a href="notice.do?snum=4"><i class="fa fa-book fa-1x" aria-hidden="true"></i>&nbsp;공지사항</a></div>
						<div><hr /></div>
						<div id="indexNoticeList" class="contentBox_board_list">

						</div>
					</div>
				</div>
				<div class="col-xs-10-10 col-sm-5-10 col-md-4-10  col_height600 contentBox_outline contentBox_right">
					<div class="contentBox col_height0">
						<div class="contentBox_a"><a href="#">이벤트 & 광고</a></div>
						<div><i class="fa fa-krw fa-4x" aria-hidden="true"></i></div>
						<div style="display:inline-block;text-align:left;">
							${newsList}
						</div>
					</div>
				</div>					

				<div class="col-xs-10-10 col-sm-5-10 col-md-2-10  col_height200 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a"><a onclick="window.open('/buengbueng/chatting.do','chatting','toolbar=no, location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500, height=500')" style="cursor: pointer;">실시간 상담</a></div>
						<div><i class="fa fa-comments fa-4x" aria-hidden="true"></i></div>
					</div>
				</div>	
				<div class="col-xs-10-10 col-sm-5-10 col-md-2-10  col_height200 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a"><a href="employeeCalenderOnly.do">알바생 일정</a></div>
						<div><i class="fa fa-calendar fa-4x" aria-hidden="true"></i></div>
					</div>
				</div>					
				<div class="col-xs-10-10 col-sm-5-10 col-md-2-10  col_height200 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a"><a href="#">포인트 결제</a></div>
						<div><i class="fa fa-krw fa-4x" aria-hidden="true"></i></div>
					</div>
				</div>	
				<div class="col-xs-10-10 col-sm-5-10 col-md-4-10  col_height200 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a"><a href="franchiseQA.do"><i class="fa fa-book fa-1x" aria-hidden="true"></i>&nbsp;가맹 문의 최신글</a></div>
						<div><hr /></div>
						<div id="indexFranchiseeList" class="contentBox_board_list">
						</div>
					</div>
				</div>	
				<div class="col-xs-10-10 col-sm-5-10 col-md-2-10  col_height200 contentBox_outline">
					<div class="contentBox col_height0">
						<div class="contentBox_a"><a href="remoteIntro.do">원격 지원</a></div>
						<div><i class="fa fa-desktop fa-4x" aria-hidden="true"></i></div>
					</div>
				</div>	
				
				
		</div>
		
	</div>
<!-- FOOTER TEMPLATE -->
<jsp:include page="footer.jsp" /> 