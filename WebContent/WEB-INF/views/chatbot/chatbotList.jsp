<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<title>챗봇 리스트</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/buengbueng/js/chatbot/chatbotList.js"></script>
	<link rel="stylesheet" type="text/css" href="/buengbueng/css/chatbot/chatbot.css" />
</head>
<jsp:include page="/WEB-INF/views/dashHeader.jsp"/>
<div class="content-title">
<div id="nodeSituation">챗봇상환판 자리 : </div>
</div>

<div class="inner-content">
                        <div class="row">
                             <div class="col-md-9 col-sm-12 col-xs-12">
                                 <div class="ui-item">
                                 <table class="table table-hover">
									<tr class="active">
										<td>번호</td>
										<td>질문</td>
										<td>답변</td>
										<td></td>
									</tr>
								<c:forEach var="chat" items="${chatbot}">
									<tr>
									<%-- 답변 개수 --%>
										<input type="hidden" value="${answerNum}" name="aNum"/>
										<td>${chat.questionNum}</td>
										<td>${chat.question}</td>
										<td>${chat.answer}</td>
										<td>
										<input type="button" onclick="window.location='modifyChat.do?questionNum=${chat.questionNum}'" value="수정" />
										<input type="button" onclick="return checkDelete('${chat.questionNum}');" value="삭제" />
										</td>
									</tr>
								</c:forEach>
								</table>
       				         </div>
                        </div>
                        <div class="col-md-3 col-sm-6 col-xs-12 col-mob">
                                    <div class="card z-depth-1">
                                        <div class="card-content">
                                            <div class="item">
	                                       	<div id="myCarousel" class="carousel slide">
										    <!-- Indicators -->
										 	<div>
										     <button type="button" data-target="#myCarousel" data-slide-to="0">최신 질문</button>
										     <button type="button" data-target="#myCarousel" data-slide-to="1">미답변 질문</button>
											 <button type="button" data-target="#myCarousel" data-slide-to="2">키워드</button>
											</div>
										
										    <!-- Wrapper for slides -->
										    <div class="carousel-inner">
										      <div class="item active">
										       	<c:forEach var="ldto" items="${ldto}" end="9">
										       		<div>${ldto.question}</div>
										       	</c:forEach>
										      </div>
										 
										      <div class="item">
										    	<c:forEach var="ldto2" items="${ldto2}" end="9">
										       		<div>${ldto2.question}</div>
										       	</c:forEach>
										      </div>
										      
										      <div class="item">
										    	<c:forEach var="countList" items="${countList}" end="9">
										    		<div><span style="overflow:hidden; white-space: nowrap;">${countList}</span></div>
										       	</c:forEach>
										      </div>
										    </div>
											</div>
                                            </div>
                                        </div>
                                    </div>
                                       	<div style="float:left;"><button class="btn btn-default" onclick="addChat('${max}');">챗봇 추가</button>
										<div class="addChat" width="100%"></div>
                                    </div>
                                </div>
                   </div>
               </div>
                               
                                

	<jsp:include page="/WEB-INF/views/dashFooter.jsp"/>
