<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form id="cashCancel" action="cashCancel.do" method="post" >
	<input type="hidden" name="error_msg" value="${error_msg}"/>
	<input type="submit" value="Submit"> 
</form>
	<script type="text/javascript"> 
		this.document.getElementById("cashCancel").submit(); 
	</script> 
	
</body>
</html>