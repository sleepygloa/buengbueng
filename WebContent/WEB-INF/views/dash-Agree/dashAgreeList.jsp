<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../dashHeader.jsp"/>
<link rel="stylesheet" type="text/css" href="/buengbueng/css/dashBoard/dash-admin/dashAdmin.css">
<script type="text/javascript">
	function getInfo(b_name){
		var b_name = b_name;
		window.open("dashAgreeInfo.do?b_name="+b_name, "가맹점 정보", "width=350, height=500, toolbar=no, menubar=no, scrollbars=no, resizable=no" ); 
	}
</script>


<div id="dashAgree">
<div>승인 대기중인 가맹점 수 : ${count2}</div>
<div class="dashAgreeTableRow">
<span class="dashAgreeTableCell col-da-5">가맹점</span>
<span class="dashAgreeTableCell col-da-2">신청일</span>
<span class="dashAgreeTableCell col-da-4"> &nbsp;</span>
</div>
<div class="dashAgreeTableRow">
<c:forEach var="article" items="${articleList2}">
<div class="dashAgreeTableCell col-da-1" onclick="getInfo('${article.b_name}');">${article.b_name}</div>
	<span class="dashAgreeTableCell col-da-2">${article.aDate}</span>
	<span class="dashAgreeTableCell col-da-3">
		<c:if test="${article.result == 0}">
			<input type="button" value="승인대기"
			onclick="window.location='dashfranchiseeConfirm.do?num=${article.num}&b_name=${article.b_name}&pageNum1=${pageNum1}'" /> 
		</c:if>
		<c:if test="${article.result == 1}">
			<input class="buttonSize" type="button" value="승인완료" /> 
		</c:if>
		<c:if test="${article.result == 2}">
			<input class="buttonSize" type="button" value="보류" /> 
		</c:if>	
	</span>
</c:forEach>

</div>
<div class="pagePosition">
	<c:if test="${startPage2 > 10}">
        <a href="dashAgreeList.do?pageNum=${pageNum}&pageNum1=${ startPage2 - 10 }">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPage2}" end="${endPage2}">
		<a href="dashAgreeList.do?pageNum=${pageNum}&pageNum1=${i}">[${i}]</a>
	</c:forEach>
	<c:if test="${endPage2 < pageCount2}">
    	<a href="dashAgreeList.do?pageNum=${pageNum}&pageNum1=${ startPage2 + 10 }">[다음]</a>
	</c:if>
</div>
</div>


<div id="dashAgree">
<div>승인된 가맹점 수 : ${count1}</div>
<div class="dashAgreeTableRow" id="agreeList${count1}">
<span class="dashAgreeTableCell col-da-5">가맹점</span>
<span class="dashAgreeTableCell col-da-2">가맹점 코드</span>
<span class="dashAgreeTableCell col-da-4"> &nbsp;</span>
<c:forEach var="article1" items="${articleList1}">
	<span class="dashAgreeTableCell col-da-1" onclick="getInfo('${article1.b_name}');" value="">${article1.b_name}</span>
	<span class="dashAgreeTableCell col-da-2">${article1.b_key}</span>
	<span class="dashAgreeTableCell col-da-3">
		<input type="hidden" id="b_key${count1}" value="${article1.b_key}">  
		<button onclick="return agreeDelete${count1}();">승인 삭제</button>
	</span>
<script>
function agreeDelete${count1}(){
	if (confirm("정말 삭제하시겠습니까??") == true){    //확인	
		$.ajax({
			url:"dashAgreeDelete.do",
			type:"post",
			data:{b_key:$("#b_key${count1}").val()},
			success:function(data){
				$("#agreeList${count1}").html(data);
			}
		});
	}else{   //취소
	  	return;
	}
}
</script>
<c:set var="count1" value="${count1 - 1}"/> 
</c:forEach>	
</div>
<div class="pagePosition">
	<c:if test="${startPage > 10}">
        <a href="dashAgreeList.do?pageNum1=${pageNum1}&pageNum=${ startPage - 10 }">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<a href="dashAgreeList.do?pageNum1=${pageNum1}&pageNum=${i}">[${i}]</a>
	</c:forEach>
	<c:if test="${endPage < pageCount}">
    	<a href="dashAgreeList.do?pageNum1=${pageNum1}&pageNum=${ startPage + 10 }">[다음]</a>
	</c:if>
</div>	
</div>


<jsp:include page="../dashFooter.jsp"/>