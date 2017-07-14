<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css"  href="/buengbueng/css/notice/comment.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<jsp:include page="../header.jsp"/>


<script>	
		function button(){		
			$.ajax({
				url:"noticeComment.do",
				type:"post",
				data:{snum:$("#snum").val(),
					  num:$("#num").val(),
					  writer:$("#writer").val(),
					  content:$("#content").val(),
					  ref:$("#ref").val(),
					  re_step:$("#re_step").val(),
					  passwd:$("#passwd").val()
				},
					  success:function(data){
						  $("#comment").html(data);  
					}
			});
		}
</script>

<head>
<title>작성한 글</title>
</head>
<input type="hidden" id="snum" value="5"/>
<input type="hidden" id="num" value="${article.num}"/>
<input type="hidden" id="writer" value="${sessionScope.loginId}"/>
<input type="hidden" id="ref" value="${article.ref}"/>
<input type="hidden" id="re_step" value="${article.re_step}"/>
 
<div id="num">
		<span>no</span>
		<span>${article.num}</span>
</div>
<div>
	<div>
	<div id="title2">
		<span>${article.title}</span>
		</div>	
	<div id="writer2">
		<span>작성자</span>
		<span>${article.writer}(${article.email})</span>
	</div>
		${article.content}
		<br/>
	<span>댓글</span>
	<span>${countRe}</span>
	<span>조회수</span>
	<span>${article.readcount}</span>
	</div>
</div>  
	
<div id="comment">
<div id="css${countRe}">
<c:forEach items="${CmList}" var="cl">
<div id="csss${countRe}">	
	<span>${cl.writer}</span><br/>
	<span>${cl.content}</span>
	<input type="hidden" id="ref${countRe}" value="${cl.ref}"/>
	<input type="hidden" id="re_step${countRe}" value="${cl.re_step}"/>
	<c:if test="${sessionScope.loginId!=null}">	
<script type="text/javascript">
	function deletekey${countRe}(){
		   //확인
			$.ajax({
				url:"commentDeleteForm.do",
				type:"post",
				data:{
					snum:$("#snum").val(),
					ref:$("#ref${countRe}").val(),
					re_step:$("#re_step${countRe}").val(),
				},
				success:function(data){
					 $("#comment").html(data); 
				}
			});
		}
	
function commentModifyForm${countRe}(){
	$.ajax({
		url:"commentModifyForm.do",
		type:"post",
		data:{
			snum:$("#snum").val(),
			ref:$("#ref${countRe}").val(),
			re_step:$("#re_step${countRe}").val()
		},
		success:function(data){
			$("#comment").html(data);
		}
	});
}
</script>
<button onclick="return deletekey${countRe}();">삭제</button>
<button onclick="return commentModifyForm${countRe}();">수정</button>
</c:if>
<c:set var="countRe" value="${countRe-1}"/>
</c:forEach>
</div>

<div>
	내용:
	<textarea id="content">

	</textarea>
	</div>

<div>
<input type="password" id="passwd">
</div>
</div>
<div>
<button onclick="return button();">등록</button>
</div>
</div>

<c:if test="${sessionScope.loginId=='admin'}">
<div id="button3">
		<span><input type="button" value="글수정" onclick="window.location='noticeModifyForm.do?snum=${article.snum}&pageNum=${pageNum}&num=${article.num}&number=${number}'"></span>
		<span><input type="button" value="글삭제" onclick="window.location='noticeDeleteForm.do?snum=${article.snum}&pageNum=${pageNum}&num=${article.num}&number=${number}&ref=${ref}'"></span>
		<span><input type="button" value="뒤로가기" onclick="window.location='notice.do?snum=${article.snum}&pageNum=${pageNum}'"></span>
</div>
</c:if>

