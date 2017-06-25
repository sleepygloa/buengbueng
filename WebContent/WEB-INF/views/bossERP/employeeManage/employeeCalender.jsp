<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- HEADER TEMPLATE -->
<jsp:include page="../../header.jsp" />
<style>
#toast-container{
	width: 70%;
	margin:0 auto;
}

.ghost-btn{
color:#E0E2E3;
font-weight:800;
background-color:#319DBC;
border:white 1px solid;
width: 100px;
height:30px;
font-size:1.2em;
vertical-align:middle;
float:right;
margin-right:10px;
}
</style>

<style type="text/css">
    body {
        margin :40px 10px;
        padding : 0;
        font-family : "Lucida Grande", Helvetica, Arial, Verdana,sans-serif;
        font-size : 14px;
    }
    #calendar {
        max-width : 900px;
        margin : 0 auto;
    }
</style>

<link href="/buengbueng/js/calender/fullcalendar.css" rel="stylesheet"/>
<link href="/buengbueng/js/calender/fullcalendar.print.css" rel="stylesheet" media="print"/>
<script type="text/javascript" src="/buengbueng/js/calender/lib/moment.min.js"></script>
<script type="text/javascript" src="/buengbueng/js/calender/fullcalendar.js" charset="utf-8"></script>
<script type="text/javascript">
function moveConfirm(date){
	var date = date;
	
	$.ajax({
		url: "employeeCalenderEventDrop.do",
    	type:"post",
    	data:{date:date},
    	dataType : "json",
    	success:function(data){
    		history.go(0);
    	},
    	fail:function(){
    		history.go(0);
    	}
	})
}
function revert(){} // 추가

   		$(document).ready(function() {
   		//토스트 -------------------------------------
   			
   			
   		//캘린더 ----------------------------------------
   		  //현재년월일
   		  var date = new Date();
   		  var d= date.getDate();
   		  var m = date.getMonth();
   		  var y = date.getFullYear();
   		  
   		  getEvent();
   		});
   		
   		function getEvent(){
   			var id = $('#id').val();
   			$.post('employeeCalenderList.do', createCalenderDateResult);
   		}
   		
   		function createCalenderDateResult(resp){
   			var result = $.parseJSON(resp),
   			eventData = "";
	   		eventData = result;

   			calendarEvent(eventData);
   		}
   		

   		function calendarEvent(eventData){
   		  var calendar = $('#calendar').fullCalendar({
   		  header: {
   		    left : 'prev, next today', //이전, 다음, 오늘
   		    center : 'title', //중앙 타이틀
   		    right: 'month, agendaWeek, agendaDay'
   		  },
   		  allDayText: '시간', //주간, 월간
   		  axisFormat: 'tt hh', //주간, 월간
   		  monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
   		  monthNamesShort : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
   		  dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'],
   		  dayNameShort:['일','월','화','수','목','금','토'],
   		  buttonText:{
   			  prev: '이전달',
   			  next: '다음달',
   			  prevYear: '전년',
   			  nextYear: '내년',
   			  today: '오늘',
   			  month: '월간',
   			  week: '주간',
   			  day: '일간'
   		  },
   		  
   		  selectable: true,
   		  selectHelper:true,
   		  eventClick: function(calEvent, jsEvent, view){
   			if(title != null){
				calendar.fullCalendar('renderEvent',{
					title: title,
					start: start,
					end: end
				})
				calender.fullCalendar('unselect');
			}
   			  return false;
   		  },
   		  select:function(start,end){
			window.open("employeeCalenderInsert.do?start="+start+"&end="+end,"",
	 		"width=450, height=300,status=no,toolbar=no,directories=no,location=no,scrollbars=no, resizable=no")
   		  },
   	    eventDrop: function(event, delta, revertFunc, delayToasts) {

   			revert = revertFunc; // 추가

		var toasts = new Toast('info','toast-top-full-width',
		"<div><label class=\"toast-title\">"+event.title+"님!</label><span class=\"toast-message\">일정을  ["+event.start.format()+" ~ "+event.end.format()+"] 로 변경하겠습니까?</div> <div><button class=\"ghost-btn\" onClick=\"revert()\">닫기</button></div><div><button class=\"ghost-btn\" "+
				"onClick=\"moveConfirm(\'{&quot;start&quot;:&quot;"+event.start.format()+"&quot;,&quot;end&quot;:&quot;"+event.end.format()+"&quot;}\')\">확인</button></div> ");
   			
   	     function Toast(type, css, msg){
				this.type = type;
				this.css = css;
				this.msg = msg 
			}
			
		    toastr.options.positionClass = 'toast-top-full-width';
		    toastr.options.extendedTimeOut = 0; //1000;
		    toastr.options.timeOut = 5000;
		    toastr.options.fadeOut = 250;
		    toastr.options.fadeIn = 250;
		    toastr.options.preventDuplicates=true;
		    
		    function delayToasts() {
		        var delay = 0;
		        window.setTimeout(function () { showToast(); }, delay);
		    }

		    function showToast() {
		        var t = toasts;
		        toastr.options.positionClass = t.css;
		        toastr[t.type](t.msg);
		    }
		    
		    showToast(); // 추가
		    
   	    },
   		  editable:true,
   		  eventLimit:true,
   		  events:eventData
	})
}
    

</script>

<input type="hidden" id="id" value="${sessionScope.loginId} " />
   <div id="calendar"></div>