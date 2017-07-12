<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 메뉴 및 css 내용 -->
<jsp:include page="../dashHeader.jsp"/>
<link rel="stylesheet" type="text/css" href="/buengbueng/css/dashBoard/dash-admin/dashAdmin.css">
<div>회원 수 : ${count}</div>
<div id="dashUserTable">
<div class="dashUserTableRow">
	<span class="dashUserTableCell col-di-1">아이디</span>
	<span class="dashUserTableCell col-di-2">비밀번호</span>
	<span class="dashUserTableCell col-di-3">이름</span>
	<span class="dashUserTableCell col-di-4">생일</span>
	<span class="dashUserTableCell col-di-5">연락처</span>
	<span class="dashUserTableCell col-di-6">이메일</span>
	<span class="dashUserTableCell col-di-7">주소</span>
	<span class="dashUserTableCell col-di-8">등급</span>
	<span class="dashUserTableCell col-di-9">Google ID</span>
	<span class="dashUserTableCell col-di-0">가입 날짜</span>
	<span class="dashUserTableCell col-di-10"></span>
</div>
<c:set value="0" var="d" />
<c:forEach var="list" items="${list}">
<div id="dashInfo${count}" class="dashUserTableRow">
	<span class="dashUserTableCell col-di-1">${list.id}<input type="hidden" id="id${count}" value="${list.id}"></span>
	<span class="dashUserTableCell col-di-2">${list.pw}<input type="hidden" id="pw${count}" value="${list.pw}"></span>
	<span class="dashUserTableCell col-di-3">${list.name}<input type="hidden" id="name${count}" value="${list.name}"></span>
	<span class="dashUserTableCell col-di-4">${list.birth}<input type="hidden" id="birth${count}" value="${list.birth}"></span>
	<span class="dashUserTableCell col-di-5">${list.phone}<input type="hidden" id="phone${count}" value="${list.phone}"></span>
	<span class="dashUserTableCell col-di-6">${list.email}<input type="hidden" id="email${count}" value="${list.email}"></span>
	<span class="dashUserTableCell col-di-7">${list.address}<input type="hidden" id="address${count}" value="${list.address}"></span>
	<span class="dashUserTableCell col-di-8">${list.grade}<input type="hidden" id="grade${count}" value="${list.grade}"></span>
		<c:if test="${list.googleId != null}">
			<span class="dashUserTableCell col-di-9">${list.googleId}<input type="hidden" id="googleId${count}" value="${list.googleId}"></span>
		</c:if>
		<c:if test="${list.googleId == null}">
			<span class="dashUserTableCell col-di-9">일반 가입<input type="hidden" id="googleId${count}" value="일반 가입"></span>
		</c:if>
	<span class="dashUserTableCell col-di-0">${dates[d]}<input type="hidden" id="signdate${count}" value="${dates[d]}"></span>
<script>
function delCheck${count}(){
	if (confirm("정말 삭제하시겠습니까??") == true){    //확인	
		$.ajax({
			url:"dashDelete.do",
			type:"post",
			data:{id:$("#id${count}").val()},
			success:function(data){
				$("#dashInfo${count}").html(data);
			}
		});
	}else{   //취소
	  	return;
	}
}
$(document).ready(function(){
	$("#dashModify${count}").click(function(){
		$.ajax({
			url:"dashModify.do",
			type:"post",
			data:{id:$("#id${count}").val(),pageNum:${pageNum}},
			success:function(data){
				$("#dashInfo${count}").html(data);
			}
		});
	});
});
</script>
	<span class="dashUserTableCell col-di-10">
	<input type="button" onclick="return delCheck${count}();" value="삭제">
	<input type="button" id="dashModify${count}" value="수정">
	</span>
</div>
<c:set var="count" value="${count-1}"/>
<c:set value="${d+1}" var="d" />
</c:forEach>
</div>
<div class="Atag-event">
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