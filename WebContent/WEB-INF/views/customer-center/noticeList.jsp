<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<jsp:include page="serviceCenter.jsp" /> 


<link rel="stylesheet" type="text/css" href="/buengbueng/css/notice/noticeList.css">
<!-- HEADER TEMPLATE -->

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항</title>

</head>
<div class="qq">
<div class="title">공지사항</div>
<c:if test="${sessionScope.loginId=='admin'}"> 
<div class="zxc"><a href = "noticeForm.do?snum=${snum}&pageNum=${pageNum}">공지하기</a></div>
</c:if>
<table class="er4">
<tr>
	<th class="tt1">번호</th>
	<th class="tt2">제목</th>
	<th class="tt3">작성자</th>
	<th class="tt4">작성일</th>
	<th class="tt5">조회</th>
</tr>	
	
<c:if test="${count == 0}">   
<div>
	<span>게시판에 저장된 글이 없습니다.</span>
</div>
</c:if>	

<c:if test="${count > 0}">  
<c:forEach var="article" items="${articleList}">
	<tr>
		<td class="tt1">
			<c:out value="${number}"/>
		</td>							    
		<td class="tt2"><a href="noticeContent.do?snum=${snum}&pageNum=${pageNum}&number=${number}&num=${article.num}&ref=${article.ref}">${article.title}</a></td>
			<c:set var="number" value="${number -1}"/>
		<td class="tt3">${article.writer}</td>
		<td class="tt4">${article.reg_date}</td>
		<td class="tt5">${article.readcount}</td>
	</tr>	
</c:forEach>
</table>	
</c:if>


	
	<div class="footer">         
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
</div>



       </div>
   </body>
</html>