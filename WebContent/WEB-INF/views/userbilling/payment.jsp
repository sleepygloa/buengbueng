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
	var IMP = window.IMP; 
	IMP.init('imp84511323'); 
	
	IMP.request_pay({
	    pg : 'html5_inicis',
	    pay_method : 'card',
	    merchant_uid : 'merchant_' + new Date().getTime(),
	    name : 'PC방 포인트 충전',
	    amount : ${pay},
	    buyer_email : '${c.email}',
	    buyer_name : '${id}',
	    buyer_postcode : '123-456'
	}, function(rsp) {
	    if ( rsp.success ) {
	    	var smsg = '결제가 완료되었습니다.';
	    	var msg = '결제가 완료되었습니다.';
	    			msg += '\n고유ID : ' + rsp.imp_uid;
	    			msg += '\n상점 거래ID : ' + rsp.merchant_uid;
	    			msg += '\n결제 금액 : ' + rsp.paid_amount;
	    			msg += '카드 승인번호 : ' + rsp.imp_uid;
	    			
	    	location.replace("paymentPro.do?paying_price=${pay}&buyer_chatid=${id}&payment_type=${cardtype}"
	    			         +"&pg_name=html5_inicis&confirmation=Accept&paying_name=123&imp_uid="+rsp.imp_uid
	    			         +"&merchant_uid="+rsp.merchant_uid+"&error_msg="+smsg+"&pg_tid="+rsp.pg_tid+"&card_code="+rsp.card_code);
	    	jQuery.ajax({
	    		url: "/payments/complete", 
	    		type: 'POST',
	    		dataType: 'json',
	    		data: {
		    		imp_uid : rsp.imp_uid
		    	
	    		}
	    	}).done(function(data) {
	    	
	    		if ( everythings_fine ) {
	    			
	    			var msg = '결제가 완료되었습니다.';
	    			msg += '\n고유ID : ' + rsp.imp_uid;
	    			msg += '\n상점 거래ID : ' + rsp.merchant_uid;
	    			msg += '\n결제 금액 : ' + rsp.paid_amount;
	    			msg += '카드 승인번호 : ' + rsp.apply_num;
	    			
	    			
	    			
	    			alert(msg);
	    		}
	    	});
	    } else {
	    	
	        var msg = '결제에 실패하였습니다.';
	        msg+= '에러내용 : ' + rsp.error_msg;
	        
	        
	        alert(msg);
	        location.replace("cashCancelPro.do?paying_price=${pay}&buyer_chatid=${id}&payment_type=${KB}&pg_name=html5_inicis&confirmation=failure"
	        		         +"&paying_name=123&imp_uid="+rsp.imp_uid+"&merchant_uid="+rsp.merchant_uid+"&error_msg="+msg);
	      
	    }
	});
	</script>
	</head>
	<body>
	</body>
</html>