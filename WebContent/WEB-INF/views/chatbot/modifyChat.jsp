<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
	<title>챗봇 질답 수정</title>
	<script type="text/javascript" src="/buengbueng/js/chatbot/chatbotList.js"></script>
	<link rel="stylesheet" type="text/css" href="/buengbueng/css/chatbot/chatbot.css" />
</head>

<body>
	<jsp:include page="/WEB-INF/views/dashHeader.jsp"/>

	<input type="text" id="alert" readonly="readonly" />
	<form action="modifyChatPro.do" method="post" name="modifyChatbot" onsubmit="return checkModifyChatbot();">
		<table>
			<tr>
				<td>번호</td>
				<td>질문</td>
				<td>답변</td>
			</tr>
			<tr>
				<td>
					<input type="hidden" value="${max}" name="max"/>
				</td>
				<td><input type="text" value="${chatbot.questionNum}" name="questionNum" readonly/></td>
				<%-- 질문 키워드 수정 --%>
				<td>
					<input type="text" id="questionTxt" onchange="keyword();" placeholder="예상 질문으로 키워드 추출" size="50"/><br/>
					<input type="text" value="${chatbot.question}" name="question" id="question" size="50"/>
				</td>
				<td>
				<%-- 답변 수정 --%>
				<div id="holder">
				<c:forEach var="i" begin="0" end="${max-1}" step="1">
					<div id="${i}"><input type="checkbox" name="deleteCheck" value="${i}"/><textArea name="answer${i}" cols="50">${answer[i]}</textArea></div><br/>
				</c:forEach>
				</div>
				</td>
				<td><input type="hidden" name="answerNum" id="num" value="${max}"/></td>
				<%-- 답변 추가 버튼 클릭시 답변 적을 수 있는 칸이 추가됨 --%>
				<td><input type="button" value="답변 추가" onclick="addAnswer()"/></td>
				<%-- 답변 삭제 버튼 클릭시 답변 적을 수 있는 칸이 삭제됨 --%>
				<td><input type="button" value="답변 삭제" onclick="deleteAnswer()"/><br/></td>
			</tr>
		</table>
		<input type="submit" value="수정"/>
		<input type="button" value="취소" onclick="window.location='chatbotList.do'"/>
	</form>
	<script type="text/javascript" src="/buengbueng/js/chatbot/chatbotList.js"></script>
	<jsp:include page="/WEB-INF/views/dashFooter.jsp"/>
</body>