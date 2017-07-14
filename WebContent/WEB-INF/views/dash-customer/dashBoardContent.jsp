<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/buengbueng/css/dashBoard/dash-admin/dashAdmin.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
function bossDel(){
	if(confirm("정말 삭제하시겠습니까??") == true){    //확인
		$.ajax({
			url:"dashBoardDel.do",
			type:"post",
			data:{
				num:$("#num").val(),
				snum:$("#snum").val(),
				pageNum:${pageNum},
				pageNum2:${pageNum2},
				pageNum3:${pageNum3},
				pageNum4:${pageNum4},
				pageNum5:${pageNum5}
			},
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
<div id="form" class="dashBoardContent">
<div class="dashBoardContentTableRow">
	<span class="dashBoardContentTableCell col-bc-1">글번호</span>
	<span class="dashBoardContentTableCell col-bc-2">${number}</span> 
	<span class="dashBoardContentTableCell col-bc-1">조회수</span>
	<span class="dashBoardContentTableCell col-bc-2">${dto.readcount}</span>
	<span class="dashBoardContentTableCell col-bc-1">게시판</span>
	<c:if test="${dto.snum==1}">
	<span class="dashBoardContentTableCell col-bc-3">가맹 문의</span>
	</c:if>
	<c:if test="${dto.snum==2}">
	<span class="dashBoardContentTableCell col-bc-3">자주 묻는 질문</span>
	</c:if>
	<c:if test="${dto.snum==3}">
	<span class="dashBoardContentTableCell col-bc-3">1:1 문의</span>
	</c:if>
	<c:if test="${dto.snum==4}">
	<span class="dashBoardContentTableCell col-bc-3">공지 사항</span>
	</c:if>
</div>
<div class="dashBoardContentTableRow">
	<span class="dashBoardContentTableCell col-bc-1">작성자</span>
	<span class="dashBoardContentTableCell col-bc-4">${dto.writer}</span>
	<span class="dashBoardContentTableCell col-bc-1">이메일</span>
	<span class="dashBoardContentTableCell col-bc-5">${dto.email}</span>
</div>
<div class="dashBoardContentTableRow">
	<span class="dashBoardContentTableCell col-bc-1">제목</span>
	<span class="dashBoardContentTableCell col-bc-6">${dto.title}</span>
</div>
<div class="dashBoardContentTableRow">
	<span class="dashBoardContentTableCell col-bc-7">${dto.content}</span>
</div>
<div class="dashBoardContentTableRow">
	<span class="dashBoardContentTableCell col-bc-8">
	<c:if test="${re_step == 1 && dto.snum!=4}">
		<input type="button" value="답글쓰기" onclick=
		"window.location='dashBoardWriteForm.do?ref=${dto.ref}&re_step=${dto.re_step}&num=${dto.num}&title=${dto.title}&snum=${dto.snum}&pageNum=${pageNum}&pageNum2=${pageNum2}&pageNum3=${pageNum3}&pageNum4=${pageNum4}'">
	</c:if>
	<button onclick="return bossDel();">글삭제</button>
	<input type="button" value="글수정" onclick="window.location='dashBoardModify.do?snum=${dto.snum}&num=${dto.num}&pageNum=${pageNum}&pageNum2=${pageNum2}&pageNum3=${pageNum3}&pageNum4=${pageNum4}&number=${number}'">
	<input type="button" value="창닫기" onclick="window.close();"></span>
</div>
</div>
<c:if test="${dto.snum==4}">
<div id="comment">
	<div id="css${countRe}" class="dashBoardContent">
		<c:forEach items="${CmList}" var="cl">
			<div id="csss${countRe}" class="dashBoardwriteContentTableRow" >
				<span class="dashBoardwriteContentTableCell col-mc-1">작성자</span>
				<span class="dashBoardwriteContentTableCell col-mc-7">${cl.writer}</span>
				<span class="dashBoardwriteContentTableCell col-mc-9">
				<input type="hidden" id="ref${countRe}" value="${cl.ref}"/>
				<input type="hidden" id="re_step${countRe}" value="${cl.re_step}"/>
				<button onclick="return deletekey${countRe}();">삭제</button>
				</span>
				<span class="dashBoardwriteContentTableCell col-mc-8">${cl.content}</span>
			</div>
<script type="text/javascript">
	function deletekey${countRe}(){
		   //확인
			$.ajax({
				url:"commentDeleteForm.do",
				type:"post",
				data:{
					snum:5,
					ref:$("#ref${countRe}").val(),
					re_step:$("#re_step${countRe}").val(),
				},
				success:function(data){
					 $("#comment").html(data); 
				}
			});
		}
</script>
<c:set var="countRe" value="${countRe-1}"/>
</c:forEach>
</div>
</div>
</c:if>

