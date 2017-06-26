<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" media="all" href="css/dist/modules.min.css">
<style>[class*=col]{margin-bottom:0px}</style>
			<!-- 카테고리 -->
			<div class="bg4 row">
				<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
					<table class="xs_hidden" style="border:1px solod black; width:width=800; height:160; text-align:center;">
						<thead>
							<tr>
								<th width="100px">피시방이름</th>
								<th width="100px">사업자번호</th>
								<th width="150px">주소</th>
								<th width="100px">사업장전화번호</th>
								<th width="50px">규모</th>
								<th width="50px">PC</th>
								<th width="100px">신청 IP</th>
								<th width="100px">KEY</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td   width="100px">
										<a href="franchiseeInfoUpdate.do?b_name=${dto.b_name}" >${dto.b_name}</a>
								</td>
								
								<td   width="100px">${dto.b_number}</td>
								<td   width="150px">${dto.b_address}</td>
								<td   width="100px">${dto.b_tel}</td>
								<td   width="50px">${dto.b_size}</td>
								<td   width="50px">${dto.b_pccount}</td>
								<td   width="100px">${dto.b_ip}</td>
								<td   width="100px">${dto.b_key}</td>
							</tr>
						</tbody>	
					</table>
				</div>
			</div>