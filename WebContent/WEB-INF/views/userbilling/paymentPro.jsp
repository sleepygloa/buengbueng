<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR" >
<link rel="stylesheet" type="text/css"  href="/buengbueng/css/payment/cash.css">
<title>Insert title here</title>
</head>
<body  onload="javascript:window_onload()" style="margin:0 auto;">
<center>
<img class="cashing_img" src="/buengbueng/img/pament/cashing.gif">
</center>
<form id="cashPro" action="cashPro.do" method="post" >
	<input type="hidden" name="paying_price" value="${info1.cash + paying_price}"/>
	<input type="hidden" name="payment_type" value="${payment_type}"/>
	<input type="hidden" name="cash" value="${paying_price}"/>
	<input type="submit" value="Submit" style="border:none; color:#fff; background: #fff;"> 
</form>
	<script type="text/javascript"> 
	function window_onload(){
        setTimeout('go_url()',350)  // 5초후 go_url() 함수를 호출한다.
     }

     function go_url(){
    	 this.document.getElementById("cashPro").submit();
     }
	</script> 
</body>
</html>