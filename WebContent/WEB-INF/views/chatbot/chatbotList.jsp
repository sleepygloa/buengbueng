<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<title>챗봇 리스트</title>
	<script type="text/javascript" src="/buengbueng/js/chatbot/chatbotList.js"></script>
	<link rel="stylesheet" type="text/css" href="/buengbueng/css/chatbot/chatbot.css" />
</head>

<body>
	<jsp:include page="/WEB-INF/views/dashHeader.jsp"/>
	<button onclick="addChat('${max}');">챗봇 추가</button><br/>
	<div class="addChat"></div><br/>
	<table>
		<tr>
			<td style="border-bottom: 1px solid gray;">번호</td>
			<td style="border-bottom: 1px solid gray;">질문</td>
			<td style="border-bottom: 1px solid gray;">답변</td>
		</tr>
		<c:forEach var="chat" items="${chatbot}">
			<tr>
				<%-- 답변 개수 --%>
				<td><input type="hidden" value="${answerNum}" name="aNum"/></td>
				<td style="border-bottom: 1px solid gray;">${chat.questionNum}</td>
				<td style="border-bottom: 1px solid gray;">${chat.question}</td>
				<td style="border-bottom: 1px solid gray;">${chat.answer}</td>
				<td><input type="button" onclick="window.location='modifyChat.do?questionNum=${chat.questionNum}'" value="수정" /></td>
				<td><input type="button" onclick="return checkDelete('${chat.questionNum}');" value="삭제" /></td>
			</tr>
		</c:forEach>
	</table>
	<jsp:include page="/WEB-INF/views/dashFooter.jsp"/>
</body>