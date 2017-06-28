<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  

<script type="text/javascript" src="/buengbueng/js/userInfo/signForm.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="css/userInfo/userInfoForm.css">

    <table class="userInfoSign_table"> 
			<tr>
				<td class="userInfoSign_Container_th"><p>상호명</p></td>
				<td class="userInfoSign_Container_tr">
					<input type="text" name="b_name" placeholder="상호명 입력" onblur="return checkB_name();" />
				</td>
			<tr/>
			<tr>
				<td class="userInfoSign_Container_th"><p>사업자 번호</p></td>
				<td  class="userInfoSign_Container_tr2">
					<input class="signup_phone_input" type="text" name="b_number_1" size="3"  maxlength="3" onblur="return checkB_number_1();"/>-
					<input class="signup_phone_input2" type="text" name="b_number_2" size="2"  maxlength="2" onblur="return checkB_number_2();"/>-
					<input class="signup_phone_input2" type="text" name="b_number_3" size="5"   maxlength="5" onblur="return checkB_number_3();"/>
				</td>
			<tr/>
			
			<tr>
				<td class="userInfoSign_Container_th"><p>사업장 주소</p></td>
				<td class="userInfoSign_Container_tr">
					<input type="text" name="b_address" placeholder="사업장 주소 입력" onblur="return checkB_address();">
				</td>
			</tr>
			
			<tr>
				<td class="userInfoSign_Container_th"><p>사업장 전화번호</p></td>
				<td class="userInfoSign_Container_tr2">
				<span>
					<input class="signup_phone_input" type="text" name="b_tel1" size="3" maxlength="3" onblur="return checkB_tel1();">-
					<input class="signup_phone_input2" type="text" name="b_tel2" size="4" maxlength="4" onblur="return checkB_tel2();">-
					<input class="signup_phone_input2" type="text" name="b_tel3" size="4" maxlength="4" onblur="return checkB_tel3();">
				</span>
				</td>
			</tr>
			
			<tr>
				<td class="userInfoSign_Container_th"><p>사업장 규모</p></td>
				<td class="userInfoSign_Container_tr">
					<input type="text" name="b_size" placeholder="사업장 규모 입력 (평 수)" onblur="return checkB_size();">
				</td>
			</tr>
			
			<tr>
				<td class="userInfoSign_Container_th"><p>보유 컴퓨터 수</p></td>
				<td class="userInfoSign_Container_tr">
				<span>
					<input type="text" name="b_pccount" placeholder="보유 PC 수 입력" onblur="return checkB_pccount();"> 대
				</span>
				</td>
			</tr>
			
			<tr>
				<td class="userInfoSign_Container_th"><p>대표 IP</p></td>
				<td class="userInfoSign_Container_tr">
					<input type="text" name="b_ip" placeholder="사장 IP 입력" onblur="return checkB_ip();">
				</td>
			</tr>
			
    </table>