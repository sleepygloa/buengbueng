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
			
			</table>