<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../dashHeader.jsp"/>
<script type="text/javascript">
	function getInfo(b_name){
		var b_name = b_name;
		window.open("dashAgreeInfo.do?b_name="+b_name, "가맹점 정보", "width=800, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=yes" ); 
	}
</script>
<div>
<div>신청 중인 가맹점 수 : ${count2}</div>
<c:forEach var="article" items="${articleList2}">
<h5 onclick="getInfo('${article.b_name}');" value="">${article.b_name}</h5>
		<p class="tool__section__desc">
			<c:if test="${article.result == 0}">
				<input class="btn" type="button" value="승인대기중"
				onclick="window.location='dashfranchiseeConfirm.do?num=${article.num}&b_name=${article.b_name}'" /> 
			</c:if>
			<c:if test="${article.result == 1}">
				<input class="btn" type="button" value="승인완료" /> 
			</c:if>
			<c:if test="${article.result == 2}">
				<input class="btn" type="button" value="보류" /> 
			</c:if>	
		</p>
		<p class="tool__section__desc">${article.date}</p>
<p class="tool__section__desc">${article.finishDate}</p>
<span class="goProduct">${article.b_key}</span>
</c:forEach>

	<c:if test="${startPage2 > 10}">
        <a href="dashAgreeList.do?pageNum1=${ startPage2 - 10 }">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPage2}" end="${endPage2}">
		<a href="dashAgreeList.do?pageNum1=${i}">[${i}]</a>
	</c:forEach>
	<c:if test="${endPage2 < pageCount2}">
    	<a href="dashAgreeList.do?pageNum1=${ startPage2 + 10 }">[다음]</a>
	</c:if>
</div>

<div>
<div>보유 가맹점 수 : ${count1}</div>
<c:forEach var="article1" items="${articleList1}">
	<div id="agreeList${count1}">
                <div class="col-xs-12-12 col-sm-6-12 col-md-4-12">
                    <div class="offer__function__section scalable">
                        <div class="card_icon"></div>
                        <h6  class="minor" onclick="getInfo('${article1.b_name}');" value="">${article1.b_name}</h6>
                        <span class="goProduct">${article1.b_key}</span>
                    </div>
                </div>
          <input type="hidden" id="b_key${count1}" value="${article1.b_key}"/>  
       <button onclick="return agreeDelete${count1}();">승인 삭제</button>
	</div>
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

	<c:if test="${startPage > 10}">
        <a href="dashAgreeList.do?pageNum=${ startPage - 10 }">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<a href="dashAgreeList.do?pageNum=${i}">[${i}]</a>
	</c:forEach>
	<c:if test="${endPage < pageCount}">
    	<a href="dashAgreeList.do?pageNum=${ startPage + 10 }">[다음]</a>
	</c:if>	
</div>


<jsp:include page="../dashFooter.jsp"/>