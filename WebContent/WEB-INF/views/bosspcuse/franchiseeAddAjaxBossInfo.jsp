<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<table id="result">
					<thead>
						<tr>
							<th></th>
							<th class="radius-left-top">
								<input id="inputBossInfo" type="button" value="가맹점 정보를 직접 입력하시겠습니까?" />
							</th>
						</tr>					
						<tr>
							<th></th>
							<th class="radius-left-top">카테고리</th>
							<th>입력</th>
						</tr>
					</thead>
					
					<tbody>
						<tr>
							<td rowspan="2"> </td>
							<td>회원아이디</td>
							<td>
								<c:if test="${userDto.id != null}">${userDto.id}<input type="hidden" value="${userDto.id}" /></c:if>
								<c:if test="${userDto.id == null}">비회원</c:if>
								
							</td>
						</tr>
						<tr>

							<td>회원 등급</td>
							<td>
								<c:if test="${userDto.grade == 0}">사용자</c:if>
								<c:if test="${userDto.grade == 1}">사장</c:if>
								<c:if test="${userDto.grade == 2}">알바</c:if>
								<c:if test="${userDto.grade == 3}">관리자</c:if>
							</td>
						</tr>					
						<tr>
							<td rowspan="7"> </td>
							<td>상호명</td>
							<td>
								<c:if test="${bossDto.b_name != null}">
									${bossDto.b_name}
								</c:if>							
							
							</td>
						</tr>					
						<tr>
							<td>사업자번호</td>
							<td>
								<c:if test="${bossDto.b_number != null}">
									${bossDto.b_number}
								</c:if>									
							</td>
						</tr>						
						<tr>
							<td>사업장 주소</td>
							<td>
								<c:if test="${bossDto.b_address != null}">
									${bossDto.b_address}
								</c:if>	
							</td>
						</tr>						
						<tr>
							<td>사업장 전화번호</td>
							<td>
								<c:if test="${bossDto.b_tel != null}">
									${bossDto.b_tel}
								</c:if>								
							</td>
						</tr>						
						<tr>
							<td>사업장 규모</td>
							<td>
								<c:if test="${bossDto.b_size != null}">
									${bossDto.b_size}
								</c:if>								
							</td>
						</tr>						
						<tr>
							<td>보유 컴퓨터수</td>
							<td>
							</td>
						</tr>						
						<tr>
							<td>사장님 컴퓨터 IP</td>
							<td>
								${ip}
								<input type="hidden" value="${ip}" />
							</td>
						</tr>											
						<tr>
							<td></td>
							<td>결정</td>
							<td>
								<input type="submit" value="신청하기" />
								<input type="button" value="취소하기" />
							</td>
						</tr>						
					</tbody>
					
				</table>