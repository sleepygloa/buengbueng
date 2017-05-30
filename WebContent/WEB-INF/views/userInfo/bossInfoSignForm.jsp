<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


       
    <table>
    
    	
			<tr>
				<td>상호명</td>
				<td><input type="text" name="b_name" placeholder="상호명 입력" /></td>
			<tr/>
			<tr>
				<td>사업자 번호</td>
				<td>
					<input type="text" name="b_number_1" size="3"  maxlength="3" onblur="return checkPhone_1();"/>-
					<input type="text" name="b_number_2" size="2"  maxlength="2" onblur="return checkPhone_2();"/>-
					<input type="text" name="b_number_3" size="5"   maxlength="5" onblur="return checkPhone_3();"/>
				</td>
			<tr/>
			
			<tr>
			<td>사업장 주소</td>
			<td>
				<input type="text" name="b_address" placeholder="사업장 주소 입력">
			</td>
			</tr>
			
			<tr>
			<td>사업장 전화번호</td>
			<td>
				<input type="text" name="b_tel1" size="3" maxlength="3">-
				<input type="text" name="b_tel2" size="4" maxlength="4">-
				<input type="text" name="b_tel3" size="4" maxlength="4">
			</td>
			</tr>
			
			<tr>
			<td>사업장 규모</td>
			<td>
				<input type="text" name="b_size" placeholder="사업장 규모 입력">
			</td>
			</tr>
			
			<tr>
			<td>보유 컴퓨터 수</td>
			<td>
				<input type="text" name="b_pccount" placeholder="보유 PC 수 입력"> 개
			</td>
			</tr>
			
			<tr>
			<td>대표 IP</td>
			<td>
				<input type="text" name="b_ip" placeholder="사장 IP 입력">
			</td>
			</tr>
			
			
    	
    	
    </table>