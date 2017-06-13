<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.2.js"></script>
	<script type="text/javascript">
	var IMP = window.IMP; // 생략가능
	IMP.init('imp84511323'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
	
	IMP.request_pay({
	    pg : 'html5_inicis', //ActiveX 결제창은 inicis를 사용
	    pay_method : 'card', //card(신용카드), trans(실시간계좌이체), vbank(가상계좌), phone(휴대폰소액결제)
	    merchant_uid : 'merchant_' + new Date().getTime(), //상점에서 관리하시는 고유 주문번호를 전달
	    name : 'PC방 포인트 충전',
	    amount : ${pay},
	    buyer_email : '${c.email}',
	    buyer_name : '${id}',
	    buyer_tel : '010-1234-5678', //누락되면 이니시스 결제창에서 오류
	    buyer_addr : '서울특별시 강남구 삼성동',
	    buyer_postcode : '123-456'
	}, function(rsp) {
	    if ( rsp.success ) {
	    	//[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
	    	var smsg = '결제가 완료되었습니다.';
	    	var msg = '결제가 완료되었습니다.';
	    			msg += '\n고유ID : ' + rsp.imp_uid;
	    			msg += '\n상점 거래ID : ' + rsp.merchant_uid;
	    			msg += '\n결제 금액 : ' + rsp.paid_amount;
	    			msg += '카드 승인번호 : ' + rsp.imp_uid;
	    			
	    	location.replace("paymentPro.do?paying_price=${pay}&buyer_chatid=${id}&payment_type=${cardtype}&pg_name=html5_inicis&confirmation=Accept&paying_name=123&imp_uid="+rsp.imp_uid+"&merchant_uid="+rsp.merchant_uid+"&error_msg="+smsg); // 결제 후 이동 링크
	    	jQuery.ajax({
	    		url: "/payments/complete", //cross-domain error가 발생하지 않도록 주의해주세요
	    		type: 'POST',
	    		dataType: 'json',
	    		data: {
		    		imp_uid : rsp.imp_uid
		    		//기타 필요한 데이터가 있으면 추가 전달
	    		}
	    	}).done(function(data) {
	    		//[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
	    		if ( everythings_fine ) {
	    			
	    			var msg = '결제가 완료되었습니다.';
	    			msg += '\n고유ID : ' + rsp.imp_uid;
	    			msg += '\n상점 거래ID : ' + rsp.merchant_uid;
	    			msg += '\n결제 금액 : ' + rsp.paid_amount;
	    			msg += '카드 승인번호 : ' + rsp.apply_num;
	    			
	    			alert(msg);
	    		} else {
	    			//[3] 아직 제대로 결제가 되지 않았습니다.
	    			//[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
	    		}
	    	});
	    } else {
	    	
	        var msg = '결제에 실패하였습니다.';
	        msg+= '에러내용 : ' + rsp.error_msg;
	        
	        alert(msg);
	        location.replace("cashCancelPro.do?paying_price=${pay}&buyer_chatid=${id}&payment_type=${KB}&pg_name=html5_inicis&confirmation=failure&paying_name=123&imp_uid="+rsp.imp_uid+"&merchant_uid=?"+rsp.merchant_uid+"&error_msg="+msg);
	      
	    }
	});
	</script>
	</head>
	<body>
	</body>
</html>