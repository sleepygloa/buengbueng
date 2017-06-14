<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	function succ(check, url){
		
		alert(check);
		window.location=url;
	}
	
	
	function gotoURI(check, url, valueName, value, valueName2, value2){
		alert(check);
		
		var form = document.createElement("form");
		   form.setAttribute("method","post");
		   form.setAttribute("action",url);
			
		   
		   var hidden = document.createElement("input");
		   hidden.setAttribute("type","hidden");
		   hidden.setAttribute("name", valueName);
		   hidden.setAttribute("value",value);
		   form.appendChild(hidden);
		   
		   hidden = document.createElement("input");
		   hidden.setAttribute("type","hidden");
		   hidden.setAttribute("name", valueName2);
		   hidden.setAttribute("value",value2);
		   form.appendChild(hidden);

		   document.body.appendChild(form);
		   form.submit();
		}
	
	
	
	
</script>


<c:if test="${check==1}">
	<body onload="gotoURI('${name} 메뉴로 이동합니다.','menu.do','name','${name}','l_key','${l_key}')" />
</c:if>

<c:if test="${check==0}">
	<body onload="succ('이동할 가맹점이 올바르지 않습니다.','franchiseeMenu.do')"/>
</c:if>

<c:if test="${check==-1}">
	<body onload="succ('예기치 않은 오류가 발생했습니다.','franchiseeMenu.do')"/>
</c:if>
