<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	function succ(check, url){
		alert(check);
		window.location=url;
	}
</script>

<c:if test="${check==1}">
	<body onload="succ('주문승인이 완료 되었습니다.','menuOrderListForm.do')" />
</c:if>

<c:if test="${check==0}">
	<body onload="succ('판매되었거나 메뉴명과 바코드값이 맞지않습니다.','menuBarcodeCheck.do')"/>
</c:if>

<c:if test="${check==-1}">
	<body onload="succ('다시 한 번 시도해보세요.','menuBarcodeCheck.do')"/>
</c:if>