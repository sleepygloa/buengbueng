<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<head>
	<title>회원 가입</title>
	<script type="text/javascript" src="/buengbueng/js/userInfo/signForm.js"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<link rel="stylesheet" type="text/css" media="all" href="css/userInfo/userInfoForm.css">
</head>
<jsp:include page="../header.jsp" />
<body onload="alert('ddd')">
	<div>
		<p>회원가입</p>
	</div>
	
	<div class="userInfoSign_Container">
	<form action="userInfoSignPro.do" method="post" name="signForm" onsubmit="return checkSignAll();">
		<table border="1" class="userInfoSign_table">
			<tr>
				<th class="userInfoSign_Container_th"><p>아이디</p></th>
				<td class="userInfoSign_Container_tr">
					<input type="text" name="id" placeholder="아이디 입력해주세요" onblur="return checkId();"/>
				</td>
			</tr>
			<tr>
				<th class="userInfoSign_Container_th"><p>비밀번호</p></th>
				<td class="userInfoSign_Container_tr">
					<input type="password" name="pw" placeholder="비밀번호 입력해주세요" onblur="return chechPw();"/><br>
					<input type="password" name="pw_chk" placeholder="비밀번호 확인을 위해 다시 입력해주세요" onblur="return chechPw();"/>
				</td>
				
			</tr>
			<tr>
				<th class="userInfoSign_Container_th"><p>이름</p></th>
				<td class="userInfoSign_Container_tr">
					<input type="text" name="name" placeholder="이름을 입력해주세요" onblur="return checkName();"/>
				</td>
			</tr>
			<tr>
				<th class="userInfoSign_Container_th"><p>생년월일</p></th>
				<td class="userInfoSign_Container_tr">
					<input type="text" name="birth" placeholder="생년월일 입력(6자리)를 입력해주세요." size="6" maxlength="6" onblur="return checkBirth();"/>
				</td>
			</tr>
			<tr>
				<th class="userInfoSign_Container_th"><p>주소</p></th>
				<td class="userInfoSign_Container_tr">
					<input type="text" name="address" placeholder="주소 입력" onblur="return checkAddress();"/>
				</td>
			</tr>
			<tr>
				<th class="userInfoSign_Container_th"><p>전화번호</p></th>
				<td class="userInfoSign_Container_tr2">
					<span>
					<input class="signup_phone_input" type="text" name="phone_1" size="3"  maxlength="3" onblur="return checkPhone_1();"/>-
					<input class="signup_phone_input2" type="text" name="phone_2" size="4"  maxlength="4" onblur="return checkPhone_2();"/>-
					<input class="signup_phone_input2" type="text" name="phone_3" size="4"   maxlength="4" onblur="return checkPhone_3();"/>
					</span>
				</td>
			</tr>
			<tr>
				<th class="userInfoSign_Container_th"><p>이메일</p></th>
				<td class="userInfoSign_Container_tr2">
					<input class="signup_email_input" type="text" name="email" placeholder="이메일 입력" onblur="return checkEmail();"/>@
					<select class="signup_email_input" name="email_addr_select" onchange="emailSelect();">
						<option selected="selected">직접입력</option>
						<option>@naver.com</option>
						<option>@gmail.com</option>
						<option>@daum.net</option>
						<option>@nate.com</option>
					</select>
				</td>
			</tr>
			<tr>
				<th class="userInfoSign_Container_th"><p>등급</p></th>
				<td class="userInfoSign_Container_tr2">
					<input type="radio" value="3" name="grade" class="user" checked="checked" />사용자
					<input type="radio" value="1" name="grade" id="boss" />사장
					<input type="radio" value="2" name="grade" id="employee" />알바
					<input type="radio" value="0" name="grade" class="user" />관리자
				</td>
			</tr>
			<tr><td></td>
				<td><div id="grade" ></div></td>
				</tr>	
			<tr>
				<td>
					<input type="submit" value="가입" />&emsp;&emsp;
					<input type="button" value="취소" onclick="cancel();" />
			</tr>
		</table>
		
		</form>
	</div>
	<script type="text/javascript" src="/buengbueng/js/userInfo/bossSignForm.js"></script>
	
	
	
	<!-- 
	<form action="userInfoSignPro.do" method="post" name="signForm" onsubmit="return checkSignAll();">
		<table>
			<tr>
				<td colspan="3"><input type="text" name="alert" readonly /><td>
			<tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" placeholder="아이디 입력" onblur="return checkId();"/></td>
			<tr/>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw" placeholder="비밀번호 입력" onblur="return chechPw();"/><br>
					<input type="password" name="pw_chk" placeholder="비밀번호 확인 입력" onblur="return chechPw();"/>
				</td>
			<tr/>
			<tr>
				<td>등급</td>
				<td>
					
					<input type="radio" value="3" name="grade" class="user" checked="checked" />사용자
					<input type="radio" value="1" name="grade" id="boss" />사장
					<input type="radio" value="2" name="grade" id="employee" />알바
					<input type="radio" value="0" name="grade" class="user" />관리자
					
				</td>
				<tr><td></td>
				<td><div id="grade" ></div></td>
				</tr>				
			<tr/>
			
			
			
		
			
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" placeholder="이름 입력" onblur="return checkName();"/></td>
			<tr/>
			<tr>
				<td>생년월일</td>
				<td><input type="text" name="birth" placeholder="생년월일 입력(6자리)" size="6" maxlength="6" onblur="return checkBirth();"/></td>
			<tr/>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address" placeholder="주소 입력" onblur="return checkAddress();"/></td>
			<tr/>
			<tr>
				<td>전화번호</td>
				<td>
					<input type="text" name="phone_1" size="3"  maxlength="3" onblur="return checkPhone_1();"/>-
					<input type="text" name="phone_2" size="4"  maxlength="4" onblur="return checkPhone_2();"/>-
					<input type="text" name="phone_3" size="4"   maxlength="4" onblur="return checkPhone_3();"/>
				</td>
			<tr/>
			<tr>
				<td>이메일</td>
				<td>
					<input type="text" name="email" placeholder="이메일 입력" onblur="return checkEmail();"/>
					<select name="email_addr_select" onchange="emailSelect();">
						<option selected="selected">직접입력</option>
						<option>@naver.com</option>
						<option>@google.com</option>
						<option>@daum.net</option>
						<option>@nate.com</option>
					</select>
				</td>
			<tr/>
			<tr>
				<td>
					<input type="submit" value="가입" />&emsp;&emsp;
					<input type="button" value="취소" onclick="cancel();" />
			</tr>
		</table>
	</form>
	 -->
	
</body>