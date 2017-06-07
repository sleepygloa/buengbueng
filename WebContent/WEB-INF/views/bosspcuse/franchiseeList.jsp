<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- HEADER TEMPLATE -->
<jsp:include page="../header.jsp" />

	<!-- 페이지 제목 -->
	<div class="margin_bottom50">
		<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
			<h3>가맹점 현황</h3>
		</div>
	</div>

	<div class="margin_bottom50">	
		<div class="col-xs-12-12">
					
				<!-- 글 갯수 -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
글목록(전체 글:${count})
					</div>
				</div>

				<!-- 카테고리 -->
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<div class="col-xs-1-12 table_wd50">신청번호</div>
						<div class="col-xs-1-12 table_wd50">신청자</div>
						<div class="col-xs-1-12 table_wd50">피시방이름</div>
						<div class="col-xs-1-12 table_wd50">신청현황</div>
						
						<div class="col-xs-1-12 table_wd100">사업자번호</div>
						<div class="col-xs-1-12 table_wd200">주소</div>
						<div class="col-xs-1-12 table_wd100">사업장전화번호</div>
						<div class="col-xs-1-12 table_wd50">규모</div>
						<div class="col-xs-1-12 table_wd50">PC수</div>
						<div class="col-xs-1-12 table_wd50">신청 IP</div>
						<div class="col-xs-1-12 table_wd50">KEY</div>
						<div class="col-xs-1-12 table_wd50">신청날짜</div>
						<div class="col-xs-1-12 table_wd50">승인날짜</div>
					</div>
				</div>

				<!-- 게시글 -->
			<c:forEach var="article" items="${articleList}">
				<div class="row">
					<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
						<div class="col-xs-1-12 table_wd50">${article.num}</div>
						<div class="col-xs-1-12 table_wd50">${article.b_id}</div>
						<div class="col-xs-1-12 table_wd50">
							<a href="num=${article.num}&pageNum=${currentPage}">
							${article.b_name}</a> 
						</div>
						<div class="col-xs-1-12">
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
						</div>
						
						<div class="col-xs-1-12 table_wd100">${article.b_number}</div>
						<div class="col-xs-1-12 table_wd200">${article.b_address}</div>
						<div class="col-xs-1-12 table_wd100">${article.b_tel}</div>
						<div class="col-xs-1-12 table_wd50">${article.b_size}</div>
						<div class="col-xs-1-12 table_wd50">${article.b_pccount}수</div>
						<div class="col-xs-1-12 table_wd50">${article.b_ip}</div>
						<div class="col-xs-1-12 table_wd50">${article.b_key}</div>
						<div class="col-xs-1-12 table_wd50">${article.date}</div>
						<div class="col-xs-1-12 table_wd50">${article.finishDate}</div>
					</div>
				</div>
			</c:forEach>


<%-- 
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
 --%>
		
		</div>
	</div>





<script type="text/javascript" src="/buengbueng/js/userInfo/signForm.js"></script>

<!-- FOOTER TEMPLATE -->
<jsp:include page="../footer.jsp" />