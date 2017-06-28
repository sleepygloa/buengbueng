<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../dashHeader.jsp"/>

<div>
<div>가맹 문의</div>
	<span>번호</span>
	<span>제목</span>
	<span>작성자</span>
	<span>email</span>
	<span>작성일</span>
	<span>조회수</span>
<c:if test="${count==0}">
<div>
	<span>등록된 게시물이 없습니다.</span>
</div>
</c:if>
<c:if test="${count>0}">
<c:set var="d" value="0"/>
<c:forEach var="list" items="${list}">
<div>
		<span>
		<c:out value="${number}"/>
		</span>
		<span><a href="dashFranchiseContent.do?num=${list.num}&snum=${snum}&pageNum=${pageNum}&number=${number}">${list.title}</a></span>
		<span>${list.writer}</span>
		<span>${list.email}</span>
		<span>${dates[d]}</span>
		<span>${list.readcount}</span>
		<c:if test="${dates[d] == today && list.re_step ==0}">
			<span class="label bg-warning">${alarm}</a></span>
		</c:if>
</div>
		<c:set var="number" value="${number-1}"/>
		<c:set value="${d+1}" var="d" />
</c:forEach>
	
	<c:if test="${startPage > 10}">
        <a href="dashList.do?snum=${snum}&pageNum=${ startPage - 10 }">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<a href="dashList.do?snum=${snum}&pageNum=${i}">[${i}]</a>
	</c:forEach>
	<c:if test="${endPage < pageCount}">
    	<a href="dashList.do?snum=${snum}&pageNum=${ startPage + 10 }">[다음]</a>
	</c:if>
</c:if>
</div>

<!-------------------------------------------------------------------------------------------------->

<div>
<div>자주 묻는 질문</div><div><a href="dashCustomerWriteForm.do?snum=2&pageNum=1">글쓰기</a></div>
	<span>번호</span>
	<span>제목</span>
	<span>작성자</span>
	<span>email</span>
	<span>작성일</span>
	<span>조회수</span>
<c:if test="${count2==0}">
<div>
	<span>등록된 게시물이 없습니다.</span>
</div>
</c:if>
<c:if test="${count2>0}">
<c:set var="d2" value="0"/>
<c:forEach var="list2" items="${list2}">
<div>
		<span>
		<c:out value="${number2}"/>
		</span>
		<span><a href="dashCustomerContent.do?num=${list2.num}&snum=${snum2}&pageNum=${pageNum2}&number=${number2}">${list2.title}</a></span>
		<span>${list2.writer}</span>
		<span>${list2.email}</span>
		<span>${dates2[d]}</span>
		<span>${list2.readcount}</span>
</div>
		<c:set var="number2" value="${number2-1}"/>
		<c:set value="${d2+1}" var="d2" />
</c:forEach>
	
	<c:if test="${startPage2 > 10}">
        <a href="dashList.do?snum2=${snum2}&pageNum2=${ startPage2 - 10 }">[이전]</a>
	</c:if>
	<c:forEach var="i2" begin="${startPage2}" end="${endPage2}">
		<a href="dashList.do?snum2=${snum2}&pageNum2=${i2}">[${i2}]</a>
	</c:forEach>
	<c:if test="${endPage2 < pageCount2}">
    	<a href="dashList.do?snum2=${snum2}&pageNum2=${ startPage2 + 10 }">[다음]</a>
	</c:if>
</c:if>
</div>

<!-- --------------------------------------------------------------------------------------- -->

<div>
<div>1:1 문의</div>
	<span>번호</span>
	<span>제목</span>
	<span>작성자</span>
	<span>email</span>
	<span>작성일</span>
	<span>조회수</span>
<c:if test="${count3==0}">
<div>
	<span>등록된 게시물이 없습니다.</span>
</div>
</c:if>
<c:if test="${count3>0}">
<c:set var="d3" value="0"/>
<c:forEach var="list3" items="${list3}">
<div>
		<span>
		<c:out value="${number3}"/>
		</span>
		<span><a href="dashCustomerContent.do?num=${list3.num}&snum=${snum3}&pageNum=${pageNum3}&number=${number3}">${list3.title}</a></span>
		<span>${list3.writer}</span>
		<span>${list3.email}</span>
		<span>${dates3[d]}</span>
		<span>${list3.readcount}</span>
</div>
		<c:set var="number3" value="${number3-1}"/>
		<c:set value="${d3+1}" var="d3" />
</c:forEach>

	<c:if test="${startPage3 > 10}">
        <a href="dashList.do?snum3=${snum3}&pageNum3=${ startPage3 - 10 }">[이전]</a>
	</c:if>
	<c:forEach var="i3" begin="${startPage3}" end="${endPage3}">
		<a href="dashList.do?snum=${snum}&snum2=${snum2}&snum3=${snum3}&pageNum=${pageNum}&pageNum2=${pageNum2}&pageNum3=${i3}">[${i3}]</a>
	</c:forEach>
	<c:if test="${endPage3 < pageCount3}">
    	<a href="dashList.do?snum3=${snum3}&pageNum3=${ startPage3 + 10 }">[다음]</a>
	</c:if>
</c:if>
</div>

<jsp:include page="../dashFooter.jsp"/>