<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"  href="/buengbueng/css/payment/cash.css">
		<title>결제 취소 페이지</title>
	
	</head>
	<jsp:include page="../header.jsp" />
	
	<body>
		<center>
			<div class="emp_box">
				<div class="cash_title margin_b20">
					<span><b>${id}</b>님, 결제가 취소 처리 되었습니다. </span>
				</div>
				
				<div class="cash_title_af" >
					<p>${error_msg}</p>
				</div>	
								
				<div>
					<button class="main_btn margin_t20">메인으로</button>		
				</div>
			</div>
		</center>
	</body>
	<jsp:include page="../footer.jsp" />
</html>