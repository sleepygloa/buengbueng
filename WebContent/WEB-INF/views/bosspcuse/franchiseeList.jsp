<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- HEADER TEMPLATE -->
<jsp:include page="../header.jsp" />

<!-- SIDEMENU TEMPLATE -->
<jsp:include page="franchiseeManageSidemenu.jsp" />

<div class="main_wrap container">
	<div class="row">
		<div class="col-sm-12-12">

<b>글목록(전체 글:${count})</b>

<table border="1" width="80%" cellpadding="0" cellspacing="0" align="center"> 
	<thead>
		<tr align="center">
			<th>신청번호</th>
			<th>점주</th>
			<th>피시방이름</th>
			<th>사업자번호</th>
			<th>주소</th>
			<th>사업장전화번호</th>
			<th>규모</th>
			<th>PC수</th>
			<th>신청 IP</th>
			<th>KEY현황</th>
			<th>신청날짜</th>
			<th>가맹점 형황</th>
			<th>승인날짜</th>
		</tr>
	</thead>
<c:if test="${count == 0}">	
	<tbody>
		  <tr align="center">
   			 <td align="center">
  			    게시판에 저장된 글이 없습니다.
  		  </td>
  		</tr>
	</tbody>	
</c:if>	
	<c:if test="${count > 0}">
	<tbody>
		<c:forEach var="article" items="${articleList}">
		<tr align="center">
			<td>
				${article.num}
			</td>
			<td>
				${article.b_id}
			</td>
			<td>     
			<a href="content.do?num=${article.num}&pageNum=${currentPage}">
			${article.b_name}</a> 
			</td>
			<td>${article.b_number}</td>
			<td>${article.b_address}</td>
			<td>${article.b_tel}</td>
			<td>${article.b_size}</td>
			<td>${article.b_pccount}</td>
			<td>${article.b_ip}</td>
			<td>${article.b_key}</td>
			<td>${article.date}</td>
			<td>
				<c:if test="${article.result == 0}">
					<input class="btn" type="button" value="승인대기중"
					onclick="window.location='franchiseeListConfirm.do?num=${article.num}'" /> 
				</c:if>
				<c:if test="${article.result == 1}">
					<input class="btn" type="button" value="승인완료" /> 
				</c:if>
				<c:if test="${article.result == 2}">
					<input class="btn" type="button" value="보류" /> 
				</c:if>				
			
			</td>
			<td>${article.finishDate}</td>
			
		</tr>
		</c:forEach>
	</tbody>
 	</c:if>
</table>


<c:if test="${count > 0}">
   <c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}"/>
   <c:set var="pageBlock" value="${10}"/>
   <fmt:parseNumber var="result" value="${currentPage / 10}" integerOnly="true" />
   <c:set var="startPage" value="${result * 10 + 1}" />
   <c:set var="endPage" value="${startPage + pageBlock-1}"/>
   <c:if test="${endPage > pageCount}">
        <c:set var="endPage" value="${pageCount}"/>
   </c:if> 
          
   <c:if test="${startPage > 10}">
        <a href="list.do?pageNum=${startPage - 10 }">[이전]</a>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <a href="list.do?pageNum=${i}">[${i}]</a>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
        <a href="list.do?pageNum=${startPage + 10}">[다음]</a>
   </c:if>
</c:if>

		
		</div>
	</div>
</div>





<script type="text/javascript" src="/buengbueng/js/userInfo/signForm.js"></script>

<!-- FOOTER TEMPLATE -->
<jsp:include page="../footer.jsp" />