<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!-- HEADER TEMPLATE -->
<jsp:include page="../header.jsp" />  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항</title>

	
	</head>
<c:if test="${sessionScope.loginId=='admin'}"> 
<div><a href = "noticeForm.do?snum=${snum}&pageNum=${pageNum}">공지하기</a></div>
</c:if>
<div>
<div>공지사항</div>
	<span>번호</span>
	<span>제목</span>
	<span>작성자</span>
	<span>email</span>
	<span>작성일</span>
	<span>조회</span>
	
<c:if test="${count == 0}">   
<div>
	<span>게시판에 저장된 글이 없습니다.</span>
</div>
</c:if>	

<c:if test="${count > 0}">  
<c:forEach var="article" items="${articleList}">
	<div>
		<span>
			<c:out value="${number}"/>
			
		</span>							    
		<span><a href="noticeContent.do?snum=${snum}&pageNum=${pageNum}&number=${number}&num=${article.num}&ref=${article.ref}">${article.title}</a></span>
			<c:set var="number" value="${number -1}"/>
		<span>${article.writer}</span>
		<span>${atricle.email}</span>
		<span>${article.reg_date}</span>
		<span>${article.readcount}</span>
	</div>
</c:forEach>	
</c:if>


          
   <c:if test="${startPage > 10}">
        <a href="notice.do?snum=${snum}&pageNum=${startPage - 10 }">[이전]</a>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <a href="notice.do?snum=${snum}&pageNum=${i}">[${i}]</a>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
        <a href="notice.do?snum=${snum}&pageNum=${startPage + 10}">[다음]</a>
   </c:if>

</div>
