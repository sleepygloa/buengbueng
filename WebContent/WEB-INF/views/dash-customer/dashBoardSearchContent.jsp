<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- HEADER TEMPLATE -->
<jsp:include page="../dashHeader.jsp" />
<script type="text/javascript">
function bossDel(){
	if(confirm("정말 삭제하시겠습니까??") == true){    //확인
		$.ajax({
			url:"dashBoardDel.do",
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
<div>
	${dto.content}
</div>
<div>
	<c:if test="${re_step == 1}">
		<span>
			<input type="button" value="답글쓰기" onclick=
			"window.location='dashFranchiseForm.do?ref=${dto.ref}&re_step=${dto.re_step}&num=${dto.num}&title=${dto.title}&snum=${dto.snum}&pageNum=${pageNum}'">
		</span>
	</c:if>
	<span><button onclick="return bossDel();">글삭제</button></span>
	<span><input type="button" value="글수정" onclick="window.location='dashFranchiseModify.do?snum=${dto.snum}&num=${dto.num}&pageNum=${pageNum}'"></span>
	<span><input type="button" value="뒤로가기" onclick="history.go(-1);"></span>
</div>
</div>

<jsp:include page="../dashFooter.jsp"/>