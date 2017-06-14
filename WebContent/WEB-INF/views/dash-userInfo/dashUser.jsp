<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 메뉴 및 css 내용 -->
<jsp:include page="../dashHeader.jsp"/>
<div align="center">
<div>
	<span>아이디</span>
	<span>비밀번호</span>
	<span>이름</span>
	<span>생일</span>
	<span>연락처</span>
	<span>이메일</span>
	<span>주소</span>
	<span>등급</span>
	<span>Google 아이디</span>
	<span>가입 날짜</span>
</div>

<c:forEach var="list" items="${list}">
<div id="dashInfo${count}">
	<span><input type="hidden" id="count${count}" value="${count}"></span>
	<span>${list.id}<input type="hidden" id="id${count}" value="${list.id}"></span>
	<span>${list.pw}<input type="hidden" id="pw${count}" value="${list.pw}"></span>
	<span>${list.name}<input type="hidden" id="name${count}" value="${list.name}"></span>
	<span>${list.birth}<input type="hidden" id="birth${count}" value="${list.birth}"></span>
	<span>${list.phone}<input type="hidden" id="phone${count}" value="${list.phone}"></span>
	<span>${list.email}<input type="hidden" id="email${count}" value="${list.email}"></span>
	<span>${list.address}<input type="hidden" id="address${count}" value="${list.address}"></span>
	<span>${list.grade}<input type="hidden" id="grade${count}" value="${list.grade}"></span>
		<c:if test="${list.googleId != null}">
			<span>${list.googleId}<input type="hidden" id="googleId${count}" value="${list.googleId}"></span>
		</c:if>
		<c:if test="${list.googleId == null}">
			<span>일반 가입<input type="hidden" id="googleId${count}" value="일반 가입"></span>
		</c:if>
	<span>${list.signdate}<input type="hidden" id="signdate${count}" value="${list.signdate}"></span>
<script>
	$(document).ready(function(){
		$("#dashDelete${count}").click(function(){
			$.ajax({
				url:"dashDelete.do",
				type:"post",
				data:{id:$("#id${count}").val(),count:$("#count${count}").val()},
				success:function(data){
					$("#dashInfo${count}").html(data);
					alert(data);
				}
			});
		});
	});
</script>
	<span><button id="dashDelete${count}">삭제</button></span>
</div>
<c:set var="count" value="${count-1}"/>
</c:forEach>
	
	<c:if test="${startPage > 10}">
        <a href="dashUser.do?grade=${grade}&pageNum=${ startPage - 10 }">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<a href="dashUser.do?grade=${grade}&pageNum=${i}">[${i}]</a>
	</c:forEach>
	<c:if test="${endPage < pageCount}">
    	<a href="dashUser.do?grade=${grade}&pageNum=${ startPage + 10 }">[다음]</a>
	</c:if>
</div>

<!-- js 내용 -->
<jsp:include page="../dashFooter.jsp"/>