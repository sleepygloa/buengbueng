<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../dashHeader.jsp"/>
<c:if test="${check==1}">
<div style="width:auto;height:auto">
<div style="width:50%;height:auto;float:left;">
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
		<span><a href="dashBoardContent.do?num=${list.num}&pageNum=${pageNum}&pageNum2=${pageNum2}&pageNum3=${pageNum3}&pageNum4=${pageNum4}&number=${number}"
		onclick="window.open(this.href,'_blank','width=700, height=400, left=30, top=30, scrollbars=no,titlebar=no,status=no,resizable=no,fullscreen=no'); return false;"
		>${list.title}</a></span>
		<span>${list.writer}</span>
		<span>${list.email}</span>
		<span>${dates[d]}</span>
		<span>${list.readcount}</span>
		<c:if test="${dates[d] == today && list.re_step ==0}">
			<span class="label bg-warning">${alarm}</span>
		</c:if>
</div>
		<c:set var="number" value="${number-1}"/>
		<c:set value="${d+1}" var="d" />
</c:forEach>
	
	<c:if test="${startPage > 10}">
        <a href="dashList.do?pageNum2=${pageNum2}&pageNum3=${pageNum3}&pageNum4=${pageNum4}&pageNum=${ startPage - 10 }">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<a href="dashList.do?pageNum2=${pageNum2}&pageNum3=${pageNum3}&pageNum4=${pageNum4}&pageNum=${i}">[${i}]</a>
	</c:forEach>
	<c:if test="${endPage < pageCount}">
    	<a href="dashList.do?pageNum2=${pageNum2}&pageNum3=${pageNum3}&pageNum4=${pageNum4}&pageNum=${ startPage + 10 }">[다음]</a>
	</c:if>
</c:if>
</div>
<!-------------------------------------------------------------------------------------------------->

<div style="width:50%;height:auto;float:left;">
<div>자주 묻는 질문</div>
	<div><a href="dashBoardWriteForm.do?snum=${snum2}&pageNum=${pageNum}&pageNum2=${pageNum2}&pageNum3=${pageNum3}&pageNum4=${pageNum4}"
	onclick="window.open(this.href,'_blank','width=700, height=400, left=30, top=30, scrollbars=no,titlebar=no,status=no,resizable=no,fullscreen=no'); return false;"
	>글쓰기</a>
	</div>
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
<c:set var="d" value="0"/>
<c:forEach var="list2" items="${list2}">
<div>
		<span>
		<c:out value="${number2}"/>
		</span>
		<span><a href="dashBoardContent.do?num=${list2.num}&pageNum=${pageNum}&pageNum2=${pageNum2}&pageNum3=${pageNum3}&pageNum4=${pageNum4}&number=${number2}"
		onclick="window.open(this.href,'_blank','width=700, height=400, left=30, top=30, scrollbars=no,titlebar=no,status=no,resizable=no,fullscreen=no'); return false;"
		>${list2.title}</a></span>
		<span>${list2.writer}</span>
		<span>${list2.email}</span>
		<span>${dates2[d]}</span>
		<span>${list2.readcount}</span>
</div>
		<c:set var="number2" value="${number2-1}"/>
		<c:set value="${d+1}" var="d" />
</c:forEach>
	
	<c:if test="${startPage2 > 10}">
        <a href="dashList.do?pageNum=${pageNum}&pageNum3=${pageNum3}&pageNum4=${pageNum4}&pageNum2=${ startPage2 - 10 }">[이전]</a>
	</c:if>
	<c:forEach var="i2" begin="${startPage2}" end="${endPage2}">
		<a href="dashList.do?pageNum=${pageNum}&pageNum3=${pageNum3}&pageNum4=${pageNum4}&pageNum2=${i2}">[${i2}]</a>
	</c:forEach>
	<c:if test="${endPage2 < pageCount2}">
    	<a href="dashList.do?pageNum=${pageNum}&pageNum3=${pageNum3}&pageNum4=${pageNum4}&pageNum2=${ startPage2 + 10 }">[다음]</a>
	</c:if>
</c:if>
</div>

<!-- --------------------------------------------------------------------------------------- -->

<div style="width:50%;height:auto;float:left;">
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
<c:set var="d" value="0"/>
<c:forEach var="list3" items="${list3}">
<div>
		<span>
		<c:out value="${number3}"/>
		</span>
		<span><a href="dashBoardContent.do?num=${list3.num}&pageNum=${pageNum}&pageNum2=${pageNum2}&pageNum3=${pageNum3}&pageNum4=${pageNum4}&number=${number3}"
		onclick="window.open(this.href,'_blank','width=700, height=400, left=30, top=30, scrollbars=no,titlebar=no,status=no,resizable=no,fullscreen=no'); return false;"
		>${list3.title}</a></span>
		<span>${list3.writer}</span>
		<span>${list3.email}</span>
		<span>${dates3[d3]}</span>
		<span>${list3.readcount}</span>
		<c:if test="${dates[d] == today && list3.re_step == 0}">
			<span class="label bg-warning">${alarm}</span>
		</c:if>
</div>
		<c:set var="number3" value="${number3-1}"/>
		<c:set value="${d+1}" var="d" />
</c:forEach>

	<c:if test="${startPage3 > 10}">
        <a href="dashList.do?pageNum=${pageNum}&pageNum2=${pageNum2}&pageNum4=${pageNum4}&pageNum3=${ startPage3 - 10 }">[이전]</a>
	</c:if>
	<c:forEach var="i3" begin="${startPage3}" end="${endPage3}">
		<a href="dashList.do?pageNum=${pageNum}&pageNum2=${pageNum2}&pageNum4=${pageNum4}&pageNum3=${i3}">[${i3}]</a>
	</c:forEach>
	<c:if test="${endPage3 < pageCount3}">
    	<a href="dashList.do?pageNum=${pageNum}&pageNum2=${pageNum2}&pageNum4=${pageNum4}&pageNum3=${ startPage3 + 10 }">[다음]</a>
	</c:if>
</div>
</c:if>
<!-- ----------------------------------------------------------------------- -->

<div style="width:50%;height:auto;float:left;">
<div>공지 사항</div>
	<div><a href="dashBoardWriteForm.do?snum=${snum4}&pageNum=${pageNum}&pageNum2=${pageNum2}&pageNum3=${pageNum3}&pageNum4=${pageNum4}&pageNum5=${pageNum5}"
	onclick="window.open(this.href,'_blank','width=700, height=400, left=30, top=30, scrollbars=no,titlebar=no,status=no,resizable=no,fullscreen=no'); return false;"
	>글쓰기</a>
	</div>
	<span>번호</span>
	<span>제목</span>
	<span>작성자</span>
	<span>email</span>
	<span>작성일</span>
	<span>조회수</span>
<c:if test="${count5==0}">
<div>
	<span>등록된 게시물이 없습니다.</span>
</div>
</c:if>
<c:if test="${count5>0}">
<c:set var="d" value="0"/>
<c:forEach var="list5" items="${list5}">
<div>
		<span>
		<c:out value="${number5}"/>
		</span>
		<span><a href="dashBoardContent.do?num=${list5.num}&pageNum=${pageNum}&pageNum2=${pageNum2}&pageNum3=${pageNum3}&pageNum4=${pageNum4}&pageNum5=${pageNum5}&number=${number5}"
		onclick="window.open(this.href,'_blank','width=700, height=400, left=30, top=30, scrollbars=no,titlebar=no,status=no,resizable=no,fullscreen=no'); return false;"
		>${list5.title}</a></span>
		<span>${list5.writer}</span>
		<span>${list5.email}</span>
		<span>${dates5[d5]}</span>
		<span>${list5.readcount}</span>
</div>
		<c:set var="number5" value="${number5-1}"/>
		<c:set value="${d+1}" var="d" />
</c:forEach>
	
	<c:if test="${startPage5 > 10}">
        <a href="dashList.do?pageNum=${pageNum}&pageNum3=${pageNum3}&pageNum4=${pageNum4}&pageNum5=${pageNum5}&pageNum2=${ startPage5 - 10 }">[이전]</a>
	</c:if>
	<c:forEach var="i5" begin="${startPage5}" end="${endPage5}">
		<a href="dashList.do?pageNum=${pageNum}&pageNum3=${pageNum3}&pageNum4=${pageNum4}&pageNum5=${pageNum5}&pageNum2=${i5}">[${i5}]</a>
	</c:forEach>
	<c:if test="${endPage5 < pageCount5}">
    	<a href="dashList.do?pageNum=${pageNum}&pageNum3=${pageNum3}&pageNum4=${pageNum4}&pageNum5=${pageNum5}&pageNum2=${ startPage5 + 10 }">[다음]</a>
	</c:if>
</c:if>
</div>

<!-- --------------------------------------------------------------------------------------- -->
<div style="width:50%;height:auto;float:left;">
<div>답변중인 글</div>
	<span>번호</span>
	<span>제목</span>
	<span>작성자</span>
	<span>email</span>
	<span>작성일</span>
	<span>게시판</span>
<c:if test="${count4==0}">
<div>
	<span>답변중인 게시물이 없습니다.</span>
</div>
</c:if>
<c:if test="${count4>0}">
<c:set var="d" value="0"/>
<c:forEach var="list4" items="${list4}">
<div>
		<span>
		<c:out value="${number4}"/>
		</span>
		<span><a href="dashBoardContent.do?num=${list4.num}&number=${number4}&pageNum=${pageNum}&pageNum2=${pageNum2}&pageNum3=${pageNum3}&pageNum4=${pageNum4}"
		onclick="window.open(this.href,'_blank','width=700, height=400, left=30, top=30, scrollbars=no,titlebar=no,status=no,resizable=no,fullscreen=no'); return false;"
		>${list4.title}</a></span>
		<span>${list4.writer}</span>
		<span>${list4.email}</span>
		<span>${dates4[d]}</span>
		<c:if test="${list4.snum == 1}">
			<span>가맹문의</span>
		</c:if>
		<c:if test="${list4.snum == 3}">
			<span>1:1문의</span>
		</c:if>
		<c:if test="${dates4[d] == today && list4.re_step ==0}">
			<span class="label bg-warning">${alarm}</span>
		</c:if>
</div>
		<c:set var="number4" value="${number4-1}"/>
		<c:set value="${d+1}" var="d" />
</c:forEach>
	
	<c:if test="${startPage4 > 10}">
        <a href="dashList.do?pageNum=${pageNum}&pageNum2=${pageNum2}&pageNum3=${pageNum3}&pageNum4=${ startPage4 - 10 }">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPage4}" end="${endPage4}">
		<a href="dashList.do?pageNum=${pageNum}&pageNum2=${pageNum2}&pageNum3=${pageNum3}&pageNum4=${i}">[${i}]</a>
	</c:forEach>
	<c:if test="${endPage4 < pageCount4}">
    	<a href="dashList.do?pageNum=${pageNum}&pageNum2=${pageNum2}&pageNum3=${pageNum3}&pageNum4=${ startPage4 + 10 }">[다음]</a>
	</c:if>
</div>
</c:if>
</c:if>
<!-- ------------------------------------------------------------------------------------------ -->

<c:if test="${check==2}">
<div style="width:50%;height:auto;float:left;">
<div>가맹 문의</div>
	<span>번호</span>
	<span>제목</span>
	<span>작성자</span>
	<span>email</span>
	<span>작성일</span>
	<span>조회수</span>
<c:if test="${count==0}">
<div>
	<span>검색된 게시물이 없습니다.</span>
</div>
</c:if>
<c:if test="${count>0}">
<c:set var="d" value="0"/>
<c:forEach var="list" items="${list}">
<div>
		<span>
		<c:out value="${number}"/>
		</span>
		<span><a href="dashBoardContent.do?num=${list.num}&pageNum=${pageNum}&pageNum2=${pageNum2}&pageNum3=${pageNum3}&pageNum4=${pageNum4}&number=${number}"
		onclick="window.open(this.href,'_blank','width=700, height=400, left=30, top=30, scrollbars=no,titlebar=no,status=no,resizable=no,fullscreen=no'); return false;"
		>${list.title}</a></span>
		<span>${list.writer}</span>
		<span>${list.email}</span>
		<span>${dates[d]}</span>
		<span>${list.readcount}</span>
		<c:if test="${dates[d] == today && list.re_step ==0}">
			<span class="label bg-warning">${alarm}</span>
		</c:if>
</div>
		<c:set var="number" value="${number-1}"/>
		<c:set value="${d+1}" var="d" />
</c:forEach>
	
	<c:if test="${startPage > 10}">
        <a href="dashBoardSearch.do?column=${column}&keyword=${keyword}&pageNum2=${pageNum2}&pageNum3=${pageNum3}&pageNum4=${pageNum4}&pageNum=${ startPage - 10 }">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<a href="dashBoardSearch.do?column=${column}&keyword=${keyword}&pageNum2=${pageNum2}&pageNum3=${pageNum3}&pageNum4=${pageNum4}&pageNum=${i}">[${i}]</a>
	</c:forEach>
	<c:if test="${endPage < pageCount}">
    	<a href="dashBoardSearch.do?column=${column}&keyword=${keyword}&pageNum2=${pageNum2}&pageNum3=${pageNum3}&pageNum4=${pageNum4}&pageNum=${ startPage + 10 }">[다음]</a>
	</c:if>
</c:if>
</div>
<!-------------------------------------------------------------------------------------------------->

<div style="width:50%;height:auto;float:left;">
<div>자주 묻는 질문</div>
	<span>번호</span>
	<span>제목</span>
	<span>작성자</span>
	<span>email</span>
	<span>작성일</span>
	<span>조회수</span>
<c:if test="${count2==0}">
<div>
	<span>검색된 게시물이 없습니다.</span>
</div>
</c:if>
<c:if test="${count2>0}">
<c:set var="d" value="0"/>
<c:forEach var="list2" items="${list2}">
<div>
		<span>
		<c:out value="${number2}"/>
		</span>
		<span><a href="dashBoardContent.do?num=${list2.num}&pageNum=${pageNum}&pageNum2=${pageNum2}&pageNum3=${pageNum3}&pageNum4=${pageNum4}&number=${number2}"
		onclick="window.open(this.href,'_blank','width=700, height=400, left=30, top=30, scrollbars=no,titlebar=no,status=no,resizable=no,fullscreen=no'); return false;"
		>${list2.title}</a></span>
		<span>${list2.writer}</span>
		<span>${list2.email}</span>
		<span>${dates2[d2]}</span>
		<span>${list2.readcount}</span>
</div>
		<c:set var="number2" value="${number2-1}"/>
		<c:set value="${d+1}" var="d" />
</c:forEach>
	
	<c:if test="${startPage2 > 10}">
        <a href="dashBoardSearch.do?column=${column}&keyword=${keyword}&pageNum=${pageNum}&pageNum3=${pageNum3}&pageNum4=${pageNum4}&pageNum2=${ startPage2 - 10 }">[이전]</a>
	</c:if>
	<c:forEach var="i2" begin="${startPage2}" end="${endPage2}">
		<a href="dashBoardSearch.do?column=${column}&keyword=${keyword}&pageNum=${pageNum}&pageNum3=${pageNum3}&pageNum4=${pageNum4}&pageNum2=${i2}">[${i2}]</a>
	</c:forEach>
	<c:if test="${endPage2 < pageCount2}">
    	<a href="dashBoardSearch.do?column=${column}&keyword=${keyword}&pageNum=${pageNum}&pageNum3=${pageNum3}&pageNum4=${pageNum4}&pageNum2=${ startPage2 + 10 }">[다음]</a>
	</c:if>
</c:if>
</div>

<!-- --------------------------------------------------------------------------------------- -->

<div style="width:50%;height:auto;float:left;">
<div>1:1 문의</div>
	<span>번호</span>
	<span>제목</span>
	<span>작성자</span>
	<span>email</span>
	<span>작성일</span>
	<span>조회수</span>
<c:if test="${count3==0}">
<div>
	<span>검색된 게시물이 없습니다.</span>
</div>
</c:if>
<c:if test="${count3>0}">
<c:set var="d" value="0"/>
<c:forEach var="list3" items="${list3}">
<div>
		<span>
		<c:out value="${number3}"/>
		</span>
		<span><a href="dashBoardContent.do?num=${list3.num}&pageNum=${pageNum}&pageNum2=${pageNum2}&pageNum3=${pageNum3}&pageNum4=${pageNum4}&number=${number3}"
		onclick="window.open(this.href,'_blank','width=700, height=400, left=30, top=30, scrollbars=no,titlebar=no,status=no,resizable=no,fullscreen=no'); return false;"
		>${list3.title}</a></span>
		<span>${list3.writer}</span>
		<span>${list3.email}</span>
		<span>${dates3[d3]}</span>
		<span>${list3.readcount}</span>
		<c:if test="${dates[d3] == today && list3.re_step ==0}">
			<span class="label bg-warning">${alarm}</span>
		</c:if>
</div>
		<c:set var="number3" value="${number3-1}"/>
		<c:set value="${d+1}" var="d" />
</c:forEach>

	<c:if test="${startPage3 > 10}">
        <a href="dashBoardSearch.do?column=${column}&keyword=${keyword}&pageNum=${pageNum}&pageNum2=${pageNum2}&pageNum4=${pageNum4}&pageNum3=${ startPage3 - 10 }">[이전]</a>
	</c:if>
	<c:forEach var="i3" begin="${startPage3}" end="${endPage3}">
		<a href="dashBoardSearch.do?column=${column}&keyword=${keyword}&pageNum=${pageNum}&pageNum2=${pageNum2}&pageNum4=${pageNum4}&pageNum3=${i3}">[${i3}]</a>
	</c:forEach>
	<c:if test="${endPage3 < pageCount3}">
    	<a href="dashBoardSearch.do?column=${column}&keyword=${keyword}&pageNum=${pageNum}&pageNum2=${pageNum2}&pageNum4=${pageNum4}&pageNum3=${ startPage3 + 10 }">[다음]</a>
	</c:if>
</div>
</c:if>

<div style="width:50%;height:auto;float:left;">
<div>답변중인 글</div>
	<span>번호</span>
	<span>제목</span>
	<span>작성자</span>
	<span>email</span>
	<span>작성일</span>
	<span>게시판</span>
<c:if test="${count4==0}">
<div>
	<span>답변중인 게시물이 없습니다.</span>
</div>
</c:if>
<c:if test="${count4>0}">
<c:set var="d" value="0"/>
<c:forEach var="list4" items="${list4}">
<div>
		<span>
		<c:out value="${number4}"/>
		</span>
		<span><a href="dashBoardContent.do?num=${list4.num}&number=${number4}&pageNum=${pageNum}&pageNum2=${pageNum2}&pageNum3=${pageNum3}&pageNum4=${pageNum4}"
		onclick="window.open(this.href,'_blank','width=700, height=400, left=30, top=30, scrollbars=no,titlebar=no,status=no,resizable=no,fullscreen=no'); return false;"
		>${list4.title}</a></span>
		<span>${list4.writer}</span>
		<span>${list4.email}</span>
		<span>${dates4[d4]}</span>
		<c:if test="${list4.snum == 1}">
			<span>가맹문의</span>
		</c:if>
		<c:if test="${list4.snum == 3}">
			<span>1:1문의</span>
		</c:if>
		<c:if test="${dates4[d] == today && list4.re_step ==0}">
			<span class="label bg-warning">${alarm}</span>
		</c:if>
</div>
		<c:set var="number4" value="${number4-1}"/>
		<c:set value="${d+1}" var="d" />
</c:forEach>
	
	<c:if test="${startPage4 > 10}">
        <a href="dashBoardSearch.do?column=${column}&keyword=${keyword}&pageNum=${pageNum}&pageNum2=${pageNum2}&pageNum3=${pageNum3}&pageNum4=${ startPage4 - 10 }">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPage4}" end="${endPage4}">
		<a href="dashBoardSearch.do?column=${column}&keyword=${keyword}&pageNum=${pageNum}&pageNum2=${pageNum2}&pageNum3=${pageNum3}&pageNum4=${i}">[${i}]</a>
	</c:forEach>
	<c:if test="${endPage4 < pageCount4}">
    	<a href="dashBoardSearch.do?column=${column}&keyword=${keyword}&pageNum=${pageNum}&pageNum2=${pageNum2}&pageNum3=${pageNum3}&pageNum4=${ startPage4 + 10 }">[다음]</a>
	</c:if>
</div>
</div>
</c:if>
</c:if>
</div>
<div align="center">
	<form action="dashBoardSearch.do" method="get" name="dashBoardSearch" onsubmit="return keywordCheck();">
		<input type="hidden" name="pageNum" value="${pageNum}">
		<input type="hidden" name="pageNum2" value="${pageNum2}">
		<input type="hidden" name="pageNum3" value="${pageNum3}">
		<input type="hidden" name="pageNum4" value="${pageNum4}">
		<select name="column">
		<option value="title">제목</option>
		<option value="writer">작성자</option>
		<option value="email">이메일</option>
		</select>
		
		<input type="text" name="keyword" placeholder="키워드 입력">
		<input type="submit" value="게시글 검색">
	</form>
</div>


<script>
function keywordCheck(){
	if(document.dashBoardSearch.keyword.value == ""){
		alert('키워드를 입력하세요.');
		return false;
	}}
</script> 

<jsp:include page="../dashFooter.jsp"/>