<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>해당 가맹지점 일일정산</title>
	</head>
	<body>

		
		<form action="dailySettlement.do" method="post">
		<select id="affiliateCodeList" name="affiliateCodeList">
		<c:forEach items="${affiliateCodeList}" var="affiliateCodeList">
			<option>
				<p>${affiliateCodeList}</p>
			</option>
		</c:forEach>
		</select>
		
		<input type="submit" value="전송">
		</form>
	</body>
</html>