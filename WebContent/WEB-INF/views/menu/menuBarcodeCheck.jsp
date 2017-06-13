<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <div>바코드 입력</div>
    <div>
    <form action="menuOrderComplete.do" method="post">
    	<input type="text" name="barcode" maxlength="13"/>
    	<input type="hidden" name="menuname" value="${menuname}">
    	<input type="hidden" name="num" value="${num}">
    	<input type="submit" value="승 인">
	</form>
    </div>