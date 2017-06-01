<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- HEADER TEMPLATE -->
<jsp:include page="../header.jsp" />

<!-- SIDEMENU TEMPLATE -->
<c:if test="${sidemenu == 2}">
	<jsp:include page="../sidemenu.jsp" />
</c:if>

<body>
<input type="text" id="sample4_postcode" placeholder="우편번호">
<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" id="sample4_roadAddress" placeholder="도로명주소">
<input type="text" id="sample4_jibunAddress" placeholder="지번주소">
<span id="guide" style="color:#999"></span>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" src="/buengbueng/js/addressAPI.js"></script>
<script>
	daum.postcode.load(function(){
   	 new daum.Postcode({
   	     oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
        }
    }).open();
});
</script>



</body>






<!-- FOOTER TEMPLATE -->
<jsp:include page="../footer.jsp" />