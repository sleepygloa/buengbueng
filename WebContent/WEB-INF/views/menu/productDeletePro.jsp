<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<script type="text/javascript">
	function succ(check, url){
		alert(check);
		window.location=url;
	}
</script>

	<body onload="succ('재고정보가 삭제되었습니다.','productDeleteForm.do')" />

