<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	function succ(check, url){
		alert(check);
		window.location=url;
	}
	
	
	function succc(check, url, valueName, value,valueName2,value2){
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
	
	
</script>


<c:if test="${check==1 }">
	<body onload="succc('메뉴정보가 추가되었습니다.','menu.do','l_key','${l_key}')"/>
</c:if>

<c:if test="${check==0}">
	<body onload="succ('접근권한이 없습니다.','index.do')"/>
</c:if>dksizz

<c:if test="${check==-1}">
	<body onload="succc('정보입력이 바르지 않습니다.','menuInsertForm.do'l_key','${l_key}')"/>
</c:if>


