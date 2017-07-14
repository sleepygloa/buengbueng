<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<link rel="stylesheet" type="text/css" href="/buengbueng/css/notice/noticeForm.css">
<jsp:include page="../header.jsp" />  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>공지 하기</title>
</head>

<style>
[class*=col]{margin-bottom:5px;padding:10;text-align:left;}
.banner_bg{
background-color:#5CBDF4;
}
.titla_box,.titla_box:hover{
height:100%;
}
.title_a{
color:#fff;
font-weight:800;
}
.boardBtn{
text-align:center;
background-color:#ddd;
border-color:#ddd;
border-radius:0.2cm;
font-size:1.2em;
}
.inputbtn{
padding:0 10px;
border-color:#ddd;
border-radius:0.2cm;
height:35px;
width:95%;
}
.textareabtn{
padding:0 10px;
border-color:#ddd;
border-radius:0.2cm;
width:100%;
height:600px;}
</style>

<div class="main_ad" style="background-color:#fff;height:100%;">
	<div class="main_ad_content">
			<div class="col-xs-10-10 main_ad_contentBox">

<form action="noticePro.do?snum=${snum}&pageNum=${pageNum}" method="post">
<input type="hidden" name="num" value="${num}">
<input type="hidden" name="ref" value="${ref}">
<input type="hidden" name="re_step" value="${re_step}">



				<div class="col-xs-10-10 col_height120 contentBox_outline banner_bg">
					<div class="contentBox titla_box col_height0 banner_bg">
						<div class="contentBox_a titla_box" style="text-align:center;vertical-align:middle;"><a class="title_a" href="#" style="font-size:3em;">공지하기</a></div>
					</div>
				</div>


				<div class="col-xs-10-10 col_height100 contentBox_outline">
					<div class="contentBox col_height0" >
						<div>		
							<label>이름</label>
							<span><input class="inputbtn" type="text" name="writer" value="admin" readonly></span>
						</div>
					</div>
				</div>
				
				<div class="col-xs-10-10 col_height100 contentBox_outline">
					<div class="contentBox col_height0" >
						<div>		
							<label>이메일</label>
							<span><input class="inputbtn" type="text" name="email" value="admin.naver.com" readonly></span>
						</div>
					</div>
				</div>

				<div class="col-xs-10-10 col_height100 contentBox_outline">
					<div class="contentBox col_height0" >
						<div>		
							<label>제목</label>
							<span><input class="inputbtn" type="text" name="title" ></span>
							<!-- <span><input class="inputbtn" type="text" name="title" id="title11" ></span> -->
						</div>
					</div>
				</div>
				<div class="col-xs-10-10 col_height700 contentBox_outline">
					<div class="contentBox col_height0" >
						<div>	
							<label>내용</label>	
							<textarea class="inputbtn textareabtn" name="content" cols="130" rows="35"></textarea>
						</div>
					</div>
				</div>				

				<div class="col-xs-10-10 col_height100 contentBox_outline">
					<div class="contentBox col_height0" >
						<div>		
							<span><input class="col-xs-12-12 col-sm-4-12 boardBtn" type="submit" value="작성하기"></span>
							<span><input class="col-xs-12-12 col-sm-4-12 boardBtn" type="reset" value="다시쓰기"></span>
							<span><input class="col-xs-12-12 col-sm-4-12 boardBtn" type="button" value="돌아가기" onclick="window.location='notice.do?snum=${snum}&pageNum=${pageNum}'"></span>
						</div>
					</div>
				</div>

</form>

		</div>
	</div>
</div>