<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/buengbueng/css/notice/noticeContent.css">
<!-- HEADER TEMPLATE -->
<jsp:include page="../header.jsp" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
function bossDel(){
	if(confirm("정말 삭제하시겠습니까??") == true){    //확인
		$.ajax({
			url:"bossDelete.do",
			type:"post",
			data:{num:$("#num").val(),
				snum:$("#snum").val(),
				pageNum:$("#pageNum").val()},
			success:function(data){
					$("#form").html(data);
			}});
	}else{   //취소
	  	return;
	}
}
</script>
<head>
<title>작성한 글</title>
</head>
<input type="hidden" id="num" value="${dto.num}">
<input type="hidden" id="snum" value="${dto.snum}">
<input type="hidden" id="pageNum" value="${pageNum}">
<div id="form">
<div>
	<span>글번호</span>
	<span>${dto.num}</span> 
	<span>조회수</span>
	<span>${dto.readcount}</span>
</div>
<div>
	<span>작성자</span>
	<span>${dto.writer}</span>
	<span>이메일</span>
	<span>${dto.email}</span>
</div>
<div>
	<span>제목</span>
	<span>${dto.title}</span>
</div>
<div>
	${dto.content}
</div>
<div>

	<c:if test="${sessionScope.loginId == 'admin'}">
	
		<span><button id="bossDel">글삭제</button></span>
	</c:if>
	<c:if test="${sessionScope.grade==4 }">
	<span><button onclick="return bossDel();">글삭제</button></span>
	</c:if>
	<span><input type="button" value="뒤로가기" onclick="window.location='customerQA.do?snum=${dto.snum}&pageNum=${pageNum}'"></span>
</div>
</div>
