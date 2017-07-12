<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/buengbueng/css/dashBoard/dash-admin/dashAdmin.css">
		
			<div id="dashBossInfo">
				<div class="dashBossInfoTableRow">
					<span class="dashBossInfoTableCell col-bb-1" ><b>피시방 이름</b></span>
					<span class="dashBossInfoTableCell col-bb-2">${dto.b_name}</span>
					<span class="dashBossInfoTableCell col-bb-1"><b>사업자번호</b></span>
					<span class="dashBossInfoTableCell col-bb-2">${dto.b_number}</span>
					<span class="dashBossInfoTableCell col-bb-1"><b>주소</b></span>
					<span class="dashBossInfoTableCell col-bb-2">${dto.b_address}</span>
					<span class="dashBossInfoTableCell col-bb-1"><b>사업장전화번호</b></span>
					<span class="dashBossInfoTableCell col-bb-2">${dto.b_tel}</span>
					<span class="dashBossInfoTableCell col-bb-1"><b>규모</b></span>
					<span class="dashBossInfoTableCell col-bb-2">${dto.b_size}</span>
					<span class="dashBossInfoTableCell col-bb-1"><b>PC</b></span>
					<span class="dashBossInfoTableCell col-bb-2">${dto.b_pccount}</span>
					<span class="dashBossInfoTableCell col-bb-1"><b>신청 IP</b></span>
					<span class="dashBossInfoTableCell col-bb-2">${dto.b_ip}</span>
					<c:if test="${dto.b_key!=null}">
						<span class="dashBossInfoTableCell col-bb-1"><b>KEY</b></span>
						<span class="dashBossInfoTableCell col-bb-2">${dto.b_key}</span>
					</c:if>
					<c:if test="${dto.b_requestedAccount!=null}">
						<span class="dashBossInfoTableCell col-bb-1"><b>계좌번호</b></span>
						<span class="dashBossInfoTableCell col-bb-2">${dto.b_requestedAccount}</span>
					</c:if>
				</div>
			</div>
	