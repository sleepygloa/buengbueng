<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    
<div id="comment">
<div id=css>
<div id="csss">

<script type="text/javascript">
function commentModifyPro(re_step){
$.ajax({
	url:"commentModifyPro.do",
	type:"post",
	data:{
		re_step:re_step,
		content:$("#content").val(),
		ref:$("#ref").val(),			
	    passwd:$("#passwd").val(),
	    snum:$("#snum").val()
	},
	success:function(data)
	    {
		$("#comment").html(data);
		}
	});
	}
</script>

	<span></span><br/>
	<span><input type="text" id="content" value="${content}"/></span><br/>
	<span><input type="password" id="passwd"/></span>
	<input type="hidden" id="ref" value="${ref}"/>
	<input type="hidden" id="snum" value="${snum}"/>
	
	
<button onclick="return commentModifyPro('${re_step}');">수정</button>

</div>
</div>
</div>