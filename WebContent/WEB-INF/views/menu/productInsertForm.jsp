<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <head>
    <title>재 고 추 가</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    </head>
    
    
    <body>
    	<div>
    	<form action="productInsertPro.do" method="post">
    		<table>					
    			<tr>	
    			<td>상품명</td>
    			<td><input type="text" name="category" placeholder="카테고리 입력">	</td>
    			</tr>
    			
    			<tr>	
    			<td>바코드번호</td>
    			<td><input type="text" name="code" placeholder="바코드 입력">	</td>
    			</tr>
    		
    			<tr>	
    			<td>유통기한</td>
    			<td><input type="text" name="lastday" placeholder="유통기한 입력">	</td>
    			</tr>
     
    			<tr>	
    			<td>판매유무</td>
    			<td><input type="text" name="salecheck" placeholder="판매유무 입력"></td>
    			</tr>
    			
    			<tr>	
    			<td>최초등록일</td>
    			<td><input type="text" name="beginregist" placeholder="최초등록일 입력"></td>
    			</tr>
    			<tr><td><input type="submit" value="추 가"/></td>
    			</tr>    		
    		</table>
    		</form>
    	</div>
    </body>