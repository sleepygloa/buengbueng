<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<br/>
<b>${franchiseeInfo.b_name}</b>
<c:if test="${favoritePCRoom == null}">
	<input type="button" value="즐겨찾는 PC방 추가" onclick="addFavoritePCRoom();"/>
</c:if>
<c:if test="${favoritePCRoom != null}">
	<input type="button" value="즐겨찾는 PC방 삭제" onclick="deleteFavoritePCRoom();"/>
</c:if>
<br/>
규모 : ${franchiseeInfo.b_size}<br/>
좌석 개수 : ${franchiseeInfo.b_pccount}&emsp;<input type="button" value="정보 보기" onclick="pcInfo('${franchiseeInfo.b_name}','${franchiseeInfo.b_id}');"/></br>
주소 : ${franchiseeInfo.b_address}<br/>
전화번호 : ${franchiseeInfo.b_tel}<br/>