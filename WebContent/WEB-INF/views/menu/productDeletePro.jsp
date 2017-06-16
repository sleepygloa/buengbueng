<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<script type="text/javascript">

function succc(check, url, valueName, value){
	alert(check);
	
	var form = document.createElement("form");
	   form.setAttribute("method","post");
	   form.setAttribute("action",url);
		
	   var hidden = document.createElement("input");
	   hidden.setAttribute("type","hidden");
	   hidden.setAttribute("name", valueName);
	   hidden.setAttribute("value",value);
	   form.appendChild(hidden);
	  
	   document.body.appendChild(form);
	   form.submit();
	}


	}
</script>

	<body onload="succc('재고정보가 삭제되었습니다.','productDeleteForm.do','l_key','${l_key}')" />

