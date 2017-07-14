<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css"  href="/buengbueng/css/notice/comment.css">

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#delete").click(function(){
		$.ajax({
			url:"franchiseDelete.do",
			type:"post",
			data:{num:$("#num").val(),
				snum:$("#snum").val(),
				pageNum:$("#pageNum").val()},
			success:function(data){
				$("#form").html(data);
			}
		});
	});
});	
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
<c:if test="${check==0}">
	<body onload="alert('비밀번호 오류'); history.go(-1);"/>
</c:if>

<c:if test="${check==1}">
<input type="hidden" id="num" value="${dto.num}">
<input type="hidden" id="snum" value="${dto.snum}">
<input type="hidden" id="pageNum" value="${pageNum}">
<div id="form">
<div>
	<span>글번호</span>
	<span>${number}</span> 
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
<div id="meme">
	${dto.content}
</div>
<div id="button">
	<c:if test="${sessionScope.grade == 4}">
		<c:if test="${re_step == 1}">
			<span>
				<input type="button" value="답글쓰기" onclick=
				"window.location='franchiseForm.do?ref=${dto.ref}&re_step=${dto.re_step}&num=${dto.num}&title=${dto.title}&snum=${dto.snum}&pageNum=${pageNum}'">
			</span>
		</c:if>
		<span><button onclick="return bossDel();">글삭제</button></span>
	</c:if>
	<c:if test="${sessionScope.grade != 4 && dto.re_step==0}">
	<span><input type="button" value="글수정" onclick="window.location='franchiseModify.do?snum=${dto.snum}&num=${dto.num}&pageNum=${pageNum}'"></span>
	<span><button id="delete">글삭제</button></span>
	</c:if>
	<span><input type="button" value="뒤로가기" onclick="window.location='franchiseQA.do?snum=${dto.snum}&pageNum=${pageNum}'"></span>
</div>
</div>
</c:if>
