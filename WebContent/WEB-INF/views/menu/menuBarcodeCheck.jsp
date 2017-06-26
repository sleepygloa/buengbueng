<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <div>바코드 입력</div>
    <div>
    <form action="menuOrderComplete.do" method="post">
    	<input type="text" name="barcode" maxlength="13"/>
    	<input type="hidden" name="name" value="${name}">
    	<input type="hidden" name="num" value="${num}">
    	<input type="hidden" name="l_key" value="${l_key}"/>
    	<input type="submit" value="승 인">
	</form>
    </div>