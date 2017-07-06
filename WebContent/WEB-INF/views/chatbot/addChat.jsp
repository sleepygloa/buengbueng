<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="/buengbueng/js/chatbot/chatbotList.js"></script>

<input type="text" id="alert" readonly="readonly" />
<form action="addChatPro.do" method="post" name="addChatbot" onsubmit="return checkChatbot();">
	<%-- 질문 번호 --%>
	<input type="hidden" name="questionNum" value="${max+1}" />
	<%-- 질문 키워드 --%>
	<input type="text" id="questionTxt" onchange="keyword();" placeholder="예상 질문으로 키워드 추출" size="50"/><br/>
	<input type="text" name="question" id="question" placeholder="질문 키워드(,로 구분)" size="50"/><br/>
	<%-- 답변 --%>
	<textArea name="answer" placeholder="답변" cols="50"></textArea>
	<%-- 답변 개수 --%>
	<input type="hidden" name="answerNum" id="num" value="0" />
	<%-- 답변 추가시 <input> 태그들이 추가될 <div> --%>
	<div id="holder"></div>
	<%-- 답변 추가 버튼 클릭시 답변 적을 수 있는 칸이 추가됨 --%>
	<input type="button" value="답변 추가" onclick="addAnswer()"/>&nbsp;&nbsp;&nbsp;
	<%-- 답변 삭제 버튼 클릭시 답변 적을 수 있는 칸이 삭제됨 --%>
	<input type="button" value="답변 삭제" onclick="deleteAnswer()"/><br/>
	
	<input type="submit" value="저장" />
</form>