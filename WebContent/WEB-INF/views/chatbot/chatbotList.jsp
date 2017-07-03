<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<title>챗봇 리스트</title>
	<script type="text/javascript" src="/buengbueng/js/chatbot/chatbotList.js"></script>
	<!--  BootStrap -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
	<div>
   <div id="myCarousel" class="carousel slide"  style="width:50%">
    <!-- Indicators -->
    <ol class="">
    </ol>
	<div>
     <button type="button" data-target="#myCarousel" data-slide-to="0">최신 질문</button>
     <button type="button" data-target="#myCarousel" data-slide-to="1">자주 묻는 질문</button>
     <button type="button" data-target="#myCarousel" data-slide-to="2">미답변 질문</button>
	 <button type="button" data-target="#myCarousel" data-slide-to="3">키워드</button>
	</div>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
       	<c:forEach var="ldto" items="${ldto}">
       		<div>${ldto.question}</div>
       	</c:forEach>
      </div>

      <div class="item">
       	<c:forEach var="ldto1" items="${ldto1}">
       		<div>${ldto1.question}</div>
       	</c:forEach>
      </div>
    
      <div class="item">
    	<c:forEach var="ldto2" items="${ldto2}">
       		<div>${ldto2.question}</div>
       	</c:forEach>
      </div>
      
      <div class="item">
    	<c:forEach var="ldto3" items="${ldto3}">
       		<div>${ldto3.keyword}</div>
       	</c:forEach>
      </div>
    </div>
  </div>
</div>
	<jsp:include page="/WEB-INF/views/dashFooter.jsp"/>
</body>