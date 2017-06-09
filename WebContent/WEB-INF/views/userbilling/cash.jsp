<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<link rel="stylesheet" type="text/css"  href="/buengbueng/css/payment/cash.css">
		<title>결제 페이지</title>	
		<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
		<script src="http://code.jquery.com/jquery-1.5.js"></script>
		<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
		<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.2.js"></script>
		<!-- 결제 스크립트 -->
		<script type="text/javascript">
			$(document).ready(function(){
				$("#bt").click(function(){
					$.ajax({
						url:"payment.do",
						type:"post",
						data:{
							pay : $("#pay").val(),
							cardtype : $("input:radio[name=interest]:checked").val()						},
						success:function(data){
							$("#result").html(data);
						}	
					});
				}); 
				//결제 금액 선택시 text 값 변경
				$("#1,#2,#3,#4,#5").click(function (Integer) { 
					var text = Number($(this).text()); 
						$("#pay").val(text);
						$("#payend").val(text+${info.cash});
					}); 
			});
		</script>
	</head>
	
	<jsp:include page="../header.jsp" />
	
	<body>
		<center>	
		<div class="emp_box">		
			<div class="cash_title margin_b20">
				<span><b>${id}</b>님 환영합니다. BuengBueng 포인트 구매 창입니다. </span>
			</div>
			<!-- 사용자정보 목록 -->
			<div class="user_info margin_r20">
				<div class="cash_in_list1">
					<span class="cash_span_left">현재 보유 : </span><span class="cash_span_right"><b class="cashing_point_b2">${info.cash}</b></span>
				</div>
				<div class="cash_in_list2">
					<span class="cash_span_left">충전 예정: </span><span class="cash_span_right"><input id="pay" class="cashing_point" type="text"  placeholder="0"  readonly><b class="cashing_point_b">P</b></span>
				</div>
				<div class="cash_in_list2">
					<span class="cash_span_left">충전 예정: </span><span class="cash_span_right"><input id="payend" class="cashing_point2" type="text"  placeholder="0"  readonly><b class="cashing_point_b2">P</b></span>
				</div>	
			</div>
			<!-- 결제금액 목록 -->
			<div class="emp_box_class1">
				<input type="hidden" id="result">
				<div class="cash_Price_box_0 margin_r10">
					<p>결제 금액</p>
				</div>	
				<div class="cash_Price_box_1 margin_l0" id="1"><button>10</button></div>
				<div class="cash_Price_box_1 margin_l0" id="2"><button>10000</button></div>
				<div class="cash_Price_box_1 margin_l0" id="3"><button>20000</button></div>
				<div class="cash_Price_box_1 margin_l0" id="4"><button>35000</button></div>
				<div class="cash_Price_box_1 margin_l0" id="5"><button>50000</button></div>

			</div>
			<!-- 결제수단 목록 -->
			<div class="emp_box_class1">
				<div class="cash_Price_box_0 margin_r10">
					<p>결제 수단</p>
				</div>
				<div class="cash_Price_box_2 margin_l0">
					<p class="card_title"><b>신용카드</b></p>
					<div class="cash_cehck">
				       	 <input class="cash_cehck_label2 cardtype" type="radio" id="Shinhan" name="interest" value="Shinhan">
					     	<label for="Shinhan">신한카드</label>
				    	 <input class="cash_cehck_label2 margin_l15 cardtype" type="radio" id="KB" name="interest" value="KB">
				    	 	<label for="KB">국민카드</label>
				    	 <input class="cash_cehck_label2 margin_l15 cardtype" type="radio" id="NH" name="interest" value="NH">
				    	 	<label for="NH">NH채움</label>
				    	 <input class="cash_cehck_label2 margin_l15 cardtype" type="radio" id="BC" name="interest" value="BC">
				    	 	<label for="BC">BC카드</label>
				    	 <input class="cash_cehck_label margin_l15 cardtype" type="radio" id="woori" name="interest" value="Woori">
				    	 	<label for="woori">우리카드</label>
				    	 <input class="cash_cehck_label margin_l15 cardtype" type="radio" id="hyundai" name="interest" value="hyundai">
				    	 	<label for="hyundai">현대카드</label>
				    	 <input class="cash_cehck_label margin_l15 cardtype" type="radio" id="samsung" name="interest" value="samsung">
				    	 	<label for="samsung">삼성카드</label>
				    	 <input class="cash_cehck_label margin_l15 cardtype" type="radio" id="Hana" name="interest" value="Hana">
				    	 	<label for="Hana">외환카드</label>
			    	 </div>
				</div>
			</div>
			
			<div class="emp_box_class1">
				<div class="cash_Price_box_0 margin_r10">
					<p>포인트 정책 동의 및 결제 전 주의사항</p>
				</div>	
				<div class="cash_Price_box_2 margin_l0">
					<ul>
						<li><p>해당 카드에 따라 VISA 안심클릭,ISP,일반결제로 진행됩니다.</p></li>
						<li><p>이용요금은 '(주)케이지이니시스'로 표시됩니다.</p></li>
						<li><p>타인의 카드를 동의 없이 무단으로 사용하면 형사처벌 받을 수 있습니다.</p></li>
					</ul>
				</div>
			</div>
			<!-- 버튼  -->
			<button class="cash_btn">돌아가기</button>
			<button class="cash_btn" id="bt">결제하기</button>
		</div>
	</center>
	<!-- 결제 버튼 스크립트 -->
	
	</body>
	<jsp:include page="../footer.jsp" />
</html>