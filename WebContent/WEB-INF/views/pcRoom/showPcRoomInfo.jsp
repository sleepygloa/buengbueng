<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<br/>
<b>${franchiseeInfo.b_name}<input type="hidden" value="${franchiseeInfo.b_name}" id="franchiseeName"/></b>
<c:if test="${favoritePCRoom == null}">
	<input type="button" value="즐겨찾는 PC방 추가" onclick="addFavoritePCRoom();"/>
</c:if>
<c:if test="${favoritePCRoom != null}">
	<input type="button" value="즐겨찾는 PC방 삭제" onclick="deleteFavoritePCRoom();"/>
</c:if>
<br/>
규모 : ${franchiseeInfo.b_size}<br/>
좌석 개수 : ${franchiseeInfo.b_pccount}&emsp;<input type="button" value="정보 보기" onclick="pcInfo('${franchiseeInfo.b_name}','${franchiseeInfo.b_id}');"/></br>
주소 : ${franchiseeInfo.b_address}<input type="hidden" value="${franchiseeInfo.b_address}" id="addr"/><br/>
전화번호 : ${franchiseeInfo.b_tel}<br/>

<div id="map" style="width:100%;height:350px;"></div>
<script type="text/javascript" src="/buengbueng/js/searchPCRoom/map.js"></script>
