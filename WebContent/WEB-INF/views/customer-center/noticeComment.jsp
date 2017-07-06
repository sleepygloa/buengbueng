<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"  href="/buengbueng/css/notice/comment.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<div id="comment">
<div id=css>
<div id="css${countRe}">
<c:forEach items="${CmList}" var="cl">
<div id="csss${countRe}">
	<span>${cl.writer}</span><br/>
	<span>${cl.content}</span>
	<input type="hidden" id="ref${countRe}" value="${cl.ref}"/>
	<input type="hidden" id="re_step${countRe}" value="${cl.re_step}"/>
<script type="text/javascript">
	function deletekey${countRe}(){
		if (confirm("정말 삭제하시겠습니까??") == true){    //확인
			$.ajax({
				url:"commentDeleteForm.do",
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
		}else{   //취소
		    return;
		}
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
<c:set var="countRe" value="${countRe-1}"/>
</div>
</c:forEach>
</div>



	<div>
	<textarea id="content">

	</textarea>
	</div>

	<div>
	<input type="password" name="passwd" id="passwd">
	</div>


</div>
</div>