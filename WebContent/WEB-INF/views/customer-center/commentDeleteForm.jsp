<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
  <c:if test="${sessionScope.loginId!='admin'}">  
<div id="comment">
<div id=css>
<div id="csss">

	

<script type="text/javascript">
function commentDeletePro(re_step){
$.ajax({
	url:"commentDeletePro.do",
	type:"post",
	data:{
		re_step:re_step,
		ref:$("#ref").val(),	
	    passwd:$("#passwd").val(),
		snum:$("#snum_se").val()
	},
	success:function(data)
	    {
		$("#comment").html(data);
		}
});
}
</script>


	<span></span><br/>
	<span>${content}</span><br/>
	<span><input type="password" id="passwd"/></span>
	<input type="hidden" id="ref" value="${ref}"/>
	<input type="hidden" id="snum_se" value="${snum}"/>






<button onclick="return commentDeletePro('${re_step}');">삭제</button>

</c:if>

</div>
</div>
</div>




<c:if test="${sessionScope.loginId=='admin'}">

<div id="comment">
<div id=css>
<div id="csss">

	

<script type="text/javascript">
function commentDeletePro(re_step){
$.ajax({
	url:"commentDeletePro.do?",
	type:"post",
	data:{
		re_step:re_step,
		ref:$("#ref").val(),	
	    passwd:$("#passwd").val(),
		snum:$("#snum_se").val(),
		asd:$("#asd").val()
	},
	success:function(data)
	    {
		$("#comment").html(data);
		}
});
}
</script>

	<input type="hidden" id="asd" value=1/>
	<input type="hidden" id="ref" value="${ref}"/>
	<input type="hidden" id="snum_se" value="${snum}"/>
<button onclick="return commentDeletePro('${re_step}');">삭제</button>

</c:if>
