<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" media="all" href="css/dist/modules.min.css">
<style>[class*=col]{margin-bottom:0px}</style>
			<!-- 카테고리 -->
			<div class="bg4 row">
				<div class="col-xs-12-12 col-sm-12-12 col-md-12-12">
				
					<div class="row md_hidden">
						<div class="col-xs-12-12">피시방이름</div>
						<div class="col-xs-12-12"><a href="franchiseeInfoUpdate.do?b_name=${dto.b_name}" >${dto.b_name}</a></div>
						<div class="col-xs-12-12">사업자번호</div>
						<div class="col-xs-12-12">${dto.b_number}</div>
						<div class="col-xs-12-12">주소</div>
						<div class="col-xs-12-12">${dto.b_address}</div>
						<div class="col-xs-12-12">사업장전화번호</div>
						<div class="col-xs-12-12">${dto.b_tel}</div>
						<div class="col-xs-12-12">규모</div>
						<div class="col-xs-12-12">${dto.b_size}</div>
						<div class="col-xs-12-12">PC 수</div>
						<div class="col-xs-12-12">${dto.b_pccount}</div>
						<div class="col-xs-12-12">신청 IP</div>
						<div class="col-xs-12-12">${dto.b_ip}</div>
						<div class="col-xs-12-12">KEY</div>
						<div class="col-xs-12-12">${dto.b_key}</div>
					</div>
				
					<table class="xs_hidden" style="border:1px solod black; width:100%;text-align:center;">
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
