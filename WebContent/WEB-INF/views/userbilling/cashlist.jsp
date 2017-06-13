<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center><b>글목록(전체 글:${count})</b>
<table width="700">
  <tr>
    <td align="right" bgcolor="${value_c}">
       <a href="/spring/board/writeForm.do">글쓰기</a>
    </td>
  </tr>
</table>
	<c:if test="${count == 0}">
	<table width="700" border="1" cellpadding="0" cellspacing="0">
	  <tr>
	    <td align="center">
	      게시판에 저장된 글이 없습니다.
	    </td>
	  </tr>
	</table>
	</c:if>
	
	<c:if test="${count > 0}">
	<table border="1" width="700" cellpadding="0" cellspacing="0" align="center"> 
	    <tr height="30" bgcolor="${value_c}"> 
	      <td align="center"  width="50"  >번 호</td> 
	      <td align="center"  width="250" >제   목</td> 
	      <td align="center"  width="100" >작성자</td>
	      <td align="center"  width="150" >작성일</td> 
	      <td align="center"  width="50" >조 회</td> 
	      <td align="center"  width="100" >IP</td>    
	    </tr>
	
	   <c:forEach var="payment" items="${payment}">
	   <tr height="30">
	    <td align="center"  width="50" >
		  <c:out value="${number}"/>
		  <c:set var="number" value="${number - 1}"/>
		</td>
	    <td  width="250" >
		  <c:if test="${article.re_level > 0}">
		  	<img src="images/level.gif" width="${5 * article.re_level}" height="16">
		    <img src="images/re.gif">
		  </c:if>
		  <c:if test="${article.re_level == 0}">
		    <img src="images/level.gif" width="${5 * article.re_level}" height="16">
		  </c:if>
	           
	      <a href="/spring/board/content.do?num=${article.num}&pageNum=${currentPage}">
	          ${article.subject}</a> 
	          <c:if test="${article.readcount >= 20}">
	            <img src="images/hot.gif" border="0"  height="16">
			  </c:if>
		</td>
	    <td align="center"  width="100"> 
	       <a href="mailto:${payment.idx}">${article.writer}</a>
		</td>
	    <td align="center"  width="150">${article.reg_date}
		</td>
	    <td align="center"  width="50">${article.readcount}</td>
	    <td align="center" width="100" >${article.ip}</td>
	  </tr>
	  </c:forEach>
	</table>
	</c:if>
</body>
</html>