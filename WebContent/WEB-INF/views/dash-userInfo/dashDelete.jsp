<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#deletePro").click(function(){
			$.ajax({
				url:"dashDeletePro.do",
				type:"post",
				data:{
					id:$("#id").val()
				},
				success:function(data){
					$("#resultPro").html(data);
				}
			});
		});
	});
</script>
<div id="resultPro">
<input type="hidden" id="id${count}" value="${id}">
<button id="deletePro">삭제</button>
</div>