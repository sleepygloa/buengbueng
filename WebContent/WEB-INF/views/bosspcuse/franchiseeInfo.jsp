<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>.mb0 > div{margin-bottom:0px}.bottom_line{border-bottom:1px solid #e7e7e7;}.table_line{border:1px solid #e7e7e7}</style>

					<div class="contentBox ">
						<div class="mb0 md_hidden">
							<div class="col-xs-12-12 bottom_line">
								<a href="franchiseeInfoUpdate.do?b_name=${dto.b_name}" >${dto.b_name}
								<input type="hidden" name="b_key" value="${dto.b_key}" />
								</a>
							</div>
							<div class="col-xs-12-12 bottom_line">사업자번호</div>
							<div class="col-xs-12-12 bottom_line">${dto.b_number}</div>
							<div class="col-xs-12-12 bottom_line">주소</div>
							<div class="col-xs-12-12 bottom_line">${dto.b_address}</div>
							<div class="col-xs-12-12 bottom_line">사업장전화번호</div>
							<div class="col-xs-12-12 bottom_line">${dto.b_tel}</div>
							<div class="col-xs-12-12 bottom_line">규모</div>
							<div class="col-xs-12-12 bottom_line">${dto.b_size}</div>
							<div class="col-xs-12-12 bottom_line">PC 수</div>
							<div class="col-xs-12-12 bottom_line">${dto.b_pccount}</div>
							<div class="col-xs-12-12 bottom_line">신청 IP</div>
							<div class="col-xs-12-12 bottom_line bottom_line">${dto.b_ip}</div>
							<div class="col-xs-12-12 bottom_line">KEY</div>
							<div class="col-xs-12-12 bottom_line">${dto.b_key}</div>
						</div>
						<div>
							<table class="xsm_hidden" style="width:100%; text-align:center;">
							<thead>
								<tr>
									<th class="table_line" width="100px">피시방이름</th>
									<th class="table_line" width="100px">사업자번호</th>
									<th class="table_line">주소</th>
									<th class="table_line" width="150px">사업장전화번호</th>
									<th class="table_line" width="50px">규모</th>
									<th class="table_line" width="50px">PC</th>
									<th class="table_line" width="100px">신청 IP</th>
									<th class="table_line" width="100px">KEY</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="table_line" width="100px">
											<a href="franchiseeInfoUpdate.do?b_name=${dto.b_name}" >${dto.b_name}</a>
									</td>
									<td class="table_line"   width="100px">${dto.b_number}</td>
									<td class="table_line" >${dto.b_address}</td>
									<td class="table_line"   width="150px">${dto.b_tel}</td>
									<td class="table_line"   width="50px">${dto.b_size}</td>
									<td class="table_line"   width="50px">${dto.b_pccount}</td>
									<td class="table_line"   width="100px">${dto.b_ip}</td>
									<td class="table_line"   width="100px">${dto.b_key}</td>
								</tr>
							</tbody>	
						</table>
					</div>
					</div>
