<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>	
		<script type="text/javascript">
			var check = ${checkPoint};
				function acpet() {
					if(check == 1){
						alert('정산요청이 정상적으로 완료되었습니다.');
					}else if(check <= 2){
						alert('이미 정산요청이 처리 되었습니다.');
						return false;
					}
				}
		</script>
	</head>
	<body>
	
		<c:if test="${affiliateCodeList == null }">
			가맹지점을 선택하여 주세요.
		</c:if>
		
		<c:if test="${affiliateCodeList != null }">
			<input type="hidden" name="affiliateCodeList" value="${affiliateCodeList}">
			<p>asdasdasdasd${check}</p>
			
			<div>
				<p>가맹주 아이디 : ${id}</p>
				<p>가맹주 이름: </p>
				<p>가맹 계좌번호 : </p>
				<p>가맹 예금주 : </p>
				<p>총  ${dailyCount}건의 오늘 정산금액은 ${dailyAmount}원 입니다.</p>
			</div>
			<table>
				<tr>
					<th>정산일자</th>
					<th>가맹주 아이디</th>
					<th>업체명</th>
					<th>정산방식</th>
					<th>정산상품수</th>
					<th>입금요청 계좌</th>
					<th>정산완료 금액</th>
					<th>정산 상태</th>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td> ${dailyAmount}</td>
					<td>미완료</td>
				</tr>
				
			</table>
			
			
			<table border="1">
				<tr>
					<th>번호</th>
					<th>사용자 아이디</th>
					<th>사용자 이름</th>
					<th>가맹점 이름</th>
					<th>사용시작 시간</th>
					<th>사용종료 시간</th>
					<th>사용 금액</th>
					<th>기타</th>
				
				</tr>
				<c:if test="${count < 1}">
					<tr>
						<td>
							<p>검색결과가 없습니다.</p>
						</td>
					</tr>
				</c:if>
				<c:if test="${count > 0}">
				<c:forEach items="${articleList}" var="articleList">
					<tr>
						<td>
							<c:out value="${number}"/>
							<c:set var="number" value="${number-1}"/>
						</td>
						<td>${articleList.userId}</td>
						<td>${articleList.userName}</td>
						<td>${articleList.businessName}</td>
						<td>${articleList.usageTime}</td>
						<td>${articleList.endTime}</td>
						<td>${articleList.amountUsed}</td>
						<td>${articleList.etc}</td>
					</tr>
				</c:forEach>
				</c:if>
			</table>
			
			<form action="applyForSettlementPro.do" method="post">
				<input type="text" name="bossId" value="${id}">
				<input type="text" name="companyName" value="루루루루루루">
				<input type="text" name="settlementMethod" value="Day+1">
				<input type="text" name="settlementNumber" value="${dailyCount}">
				<input type="text" name="requestedAccount" value="110-313-991874">
				<input type="text" name="settlementAmount" value="${dailyPureAmount}">
				<input type="text" name="settlementStatus" value="정산 요청중">
				<input type="text" name="resultValue" value="2">
				<input type="text" name="b_key" value="${affiliateCodeList}">
				<input type="hidden" name="affiliateCodeList" id="affiliateCodeList" value="${affiliateCodeList}">
			<input type="submit" value="정산하기" onclick="return acpet();">
			</form>
		</c:if>
	</body>
</html>