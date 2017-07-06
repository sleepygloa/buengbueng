<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
		<script src="http://code.jquery.com/jquery-1.5.js"></script>
		<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
		<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.2.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> 
		<script>
		function set(n) {
			temp = document.main.elements.length  ;
			for (i=0; i < temp; i++) {   
				document.main.elements[i].checked=n;
			}
		} 
		
		function Invers(){
			temp = document.main.elements.length ;
			for (i=0; i < temp; i++){
				if(document.main.elements[i].checked == 1){document.main.elements[i].checked = 0;}
					else {document.main.elements[i].checked = 1}
			}
		}
		
		</script>
	</head>
	<body>
	<form  name="main" action="requestPro.do" method="post">
		<table border="1" >		
			<tr>
				<th>no</th>
				<th>정산일자</th>
				<th>가맹주 아이디</th>
				<th>가맹점 이름</th>
				<th>정산방식</th>
				<th>정산내역 수</th>
				<th>요청계좌</th>
				<th>정산금액</th>
				<th>현황</th>
				<th>	
					<INPUT name=button onclick=set(1) type=button value="전체선택">
					<INPUT name=button onclick=set(0) type=button value="전체취소">				
				</th>
			</tr>
			<c:forEach items="${articleList}" var="articleList">
			<tr>
				<td id="info" >${articleList.idx}</td>
				<td>${articleList.settlementDate}</td>
				<td>${articleList.bossId}</td>
				<td>${articleList.companyName}</td>
				<td>${articleList.settlementMethod}</td>
				<td>${articleList.settlementNumber}</td>
				<td>${articleList.requestedAccount}</td>
				<td>${articleList.settlementAmount}</td>
				<td>${articleList.settlementStatus}</td>
				<td><input type="checkbox" id="chbox" name="chbox" value="${articleList.idx}" onclick="alert('${articleList}');"></td>
			</tr>
			</c:forEach>
		</table>
		
		
		<input type="submit" value="정산">
		</form>

	
	</body>
</html>
