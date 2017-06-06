<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<title>게시글 수정</title>
</head>

<c:if test="${check==1}">
	<meta http-equiv="Refresh" content="0;url=oneQA.do?snum=${dto.snum}&pageNum=${pageNum}" >
</c:if>
<c:if test="${check!=1 }">
      <script language="JavaScript">      
      <!--      
        alert("비밀번호가 맞지 않습니다");
        history.go(-1);
      -->
     </script>
</c:if>