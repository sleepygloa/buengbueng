<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../dashHeader.jsp"/>
<script>
function reverseUser(){
	if(document.getElementById("reverse").value==""){
		alert('키워드를 입력하세요.');
		return false;
	}else{	
	if (confirm("복구 하시겠습니까??") == true){ 
		$.ajax({
			url:"dashInto.do",
			type:"post",
			data:{
				reverse:$("#reverse").val(),
			},
			success:function(data){
				$("#result").html(data);
		    }
		});
	}else{
		return;
	}}
}
</script>

<input type="text" id="reverse" placeholder="복구 아이디">
<button onclick="return reverseUser();">조회</button>
<div id="result"/>
<jsp:include page="../dashFooter.jsp"/>
