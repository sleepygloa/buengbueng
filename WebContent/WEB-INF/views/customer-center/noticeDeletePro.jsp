<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${check2==1}">
<script>
	alert("삭제되었습니다.");
</script>
</c:if>

<c:if test="${check2 !=1}">
<script>
alert("비밀번호를 다시 입력하세요.")
history.go(-1);
</script>
</c:if>

<c:redirect url="notice.do?snum=${snum}&pageNum=${pageNum}"/>


