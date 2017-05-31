<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- HEADER TEMPLATE -->
<jsp:include page="../header.jsp" />

<!-- SIDEMENU TEMPLATE -->
<jsp:include page="franchiseeManageSidemenu.jsp" />


<!-- ARTICLE -->

<!-- 페이지 제목 -->
<div class="pricing__title--wrap container">
이 페이지는 가맹점을 추가하는 페이지입니다. 
</div>

<div class="pricing--wrap">
<div class="container for-desktop">
	<div class="row">
		<div class="col-md-12-12">
			<form>

				<table>
					<thead>
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
								<c:if test="${userDto.id != null}">${userDto.id}</c:if>
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
								<input type="text" name="b_name" placeholder="10자 이내로 력해주세요"/>
								<c:if test="${bossDto.b_name != null}">
									${bossDto.b_name}
								</c:if>							
							
							</td>
						</tr>					
						<tr>
							<td>사업자번호</td>
							<td>
								<input type="text" name="b_number" placeholder="8숫자 8자리입니다." maxlength="8" />
								<c:if test="${bossDto.b_number != null}">
									${bossDto.b_number}
								</c:if>									
							</td>
						</tr>						
						<tr>
							<td>사업장 주소</td>
							<td>
								<input type="text" name="b_address" placeholder="사업장 주소를 정확히 입력해주세요"/>
								<c:if test="${bossDto.b_address != null}">
									${bossDto.b_address}
								</c:if>	
							</td>
						</tr>						
						<tr>
							<td>사업장 전화번호</td>
							<td>
								<input type="text" name="b_tel" placeholder="- 과 같이 입력해주세요" maxlength="13"/>
								<c:if test="${bossDto.b_tel != null}">
									${bossDto.b_tel}
								</c:if>								
							</td>
						</tr>						
						<tr>
							<td>사업장 규모</td>
							<td>
								<input type="text" name="b_size" placeholder="단위는 평형 입니다. 평형은 빼고 숫자만 입력해주세요" maxlength="4" />
								<c:if test="${bossDto.b_size != null}">
									${bossDto.b_size}
								</c:if>								
							</td>
						</tr>						
						<tr>
							<td>보유 컴퓨터수</td>
							<td>
								<select name="b_pccount">
									<option value="0010">10대 미만</option>
									<option value="1020">20대 미만</option>
									<option value="2030">30대 미만</option>
									<option value="3040">40대 미만</option>
									<option value="4050">50대 미만</option>
									<option value="5060">60대 미만</option>
									<option value="6070">70대 미만</option>
									<option value="7080">80대 미만</option>
									<option value="8090">90대 미만</option>
									<option value="90100">100대 미만</option>
									<option value="100110">110대 미만</option>
									<option value="110120">120대 미만</option>
									<option value="120130">130대 미만</option>
									<option value="130140">140대 미만</option>
									<option value="140150">150대 미만</option>
								</select>
							</td>
						</tr>						
						<tr>
							<td>사장님 컴퓨터 IP</td>
							<td>
								${ip}
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
			</form>	
		</div>
	</div>
</div>

</div>

<input type="button" value="메인페이지로" onclick="window.location='index.do'" />

<br /><br /><br /><br /><br />


<!-- FOOTER TEMPLATE -->
<jsp:include page="../footer.jsp" />