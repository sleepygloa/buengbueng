<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="/buengbueng/js/bossERP/seatDispose.js"></script>

<div>
	&emsp;&emsp;&emsp;
	<input type="text" id="pcCount"/>&emsp;<input type="button" id="seatAdd" value="추가"/>
	&emsp;&emsp;&emsp;
	<input type="button" id="seatModi" value="일괄 수정"/>
	&emsp;&emsp;&emsp;
	<input type="button" id="seatDel" value="삭제"/>
</div>
<br/><br/>
<div class="seatDisposeFirstDiv">
	<c:forEach begin="1" end="${count}" var="pcNum" step="1">
		<div class="seatDisposeSecondDiv">
			<input type="checkBox" value="${pcNum}" name="checkPC"/>${pcNum}
			<br><input type="button" value="정보 보기" onclick="showModiPcInfo('${pcNum}','0')"/><br/>
			<br><input type="button" value="정보 수정" onclick="showModiPcInfo('${pcNum}','1')"/>
		</div>
	</c:forEach>
</div>