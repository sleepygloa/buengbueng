<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"  href="/buengbueng/css/payment/cash.css">
		<title>결제 완료 페이지</title>
		<script>
			/*뒤로 가기 막는 스크립트*/
			history.pushState(null, null, location.href); 
			window.onpopstate = function(event) { 
				alert('올바르지 못한 접근입니다.');
			history.go(1); 
			}
			/*새로고침 방지 스크립트*/
			document.onkeydown = function(e){
			      key = (e) ? e.keyCode : event.keyCode;
			      if(key==8 || key==116){
			         if(e){
			            e.preventDefault();
			            alert('새로고침버튼을 사용하실 수 없습니다.');
			         }
			         else{
			            event.keyCode = 0;
			            event.returnValue = false;
			         }
			      }
			}			
				
			
		</script>
	</head>
	<jsp:include page="../header.jsp" />
	
	<body >
		<center>
			<div class="emp_box">
				<div class="cash_title margin_b20">
					<span><b>${id}</b>님 환영합니다. 결제가 정상적으로 처리 되었습니다. </span>
				</div>
				
				<div class="cash_title_af">
					<p><span class="cash_title1">${cash}</span>P가 <span class="cash_title2">충전 완료</span> 되었습니다.</p>
					
					<div class="list_box">
						<!-- 결젠내역 테이블 -->
						<table class="cash_today_list">
							<tr>
								<th colspan="2" style="text-align: center">결제 내역</th>
							</tr>
							<tr>
								<td class="cash_today_list_td">결제일 </td>
								<td class="cash_today_list_td2">2017년 05월 29일</td>
							</tr>
							<tr>
								<td class="cash_today_list_td">결제 수단 </td>
								<td class="cash_today_list_td2">${payment_type}</td>
							</tr>
							<tr>
								<td class="cash_today_list_td"><span>결제 금액</span></td>
								<td class="cash_today_list_td2"><span>${cash}원</span></td>	
							</tr>		
						</table>
						<!-- 충전내역 테이블 -->
						<table class="point_have_list margin_l20" border="1">
							<tr>
								<th colspan="2" style="text-align: center">충전 포인트</th>
							</tr>
							<tr>
								<td class="point_have_list_td">기존 보유 포인트 </td>
								<td class="point_have_list_td2">${info1.money}원</td><!-- 기존회원테이블에서 포인트 가지고 올것 -->
							</tr>
							<tr>
								<td class="point_have_list_td">충전 포인트 </td>
								<td class="point_have_list_td2">${cash}원</td>
							</tr>
							<tr>
								<td class="point_have_list_td">결제 후 포인트 </td>
								<td class="point_have_list_td2">${info1.money+cash}원</td>
								
							</tr>		
						</table>
					</div>
				</div>	
								
				<div>
					<button class="main_btn margin_t20" onclick="window.location='index.do'">메인으로</button>		
				</div>
			</div>
		</center>
	</body>
	<jsp:include page="../footer.jsp" />
</html>