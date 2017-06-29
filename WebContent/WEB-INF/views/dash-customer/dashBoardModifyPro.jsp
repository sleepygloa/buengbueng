<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
alert('수정완료');
opener.document.location.reload();
</script>
<head>
<title>게시글 수정</title>
<meta http-equiv="Refresh" 
content="0;url=dashBoardContent.do?snum=${dto.snum}&num=${dto.num}&pageNum=${pageNum}&pageNum2=${pageNum2}&pageNum3=${pageNum3}&pageNum4=${pageNum4}&number=${number}" >
</head>

