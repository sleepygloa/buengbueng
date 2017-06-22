<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- HEADER TEMPLATE -->
<jsp:include page="../../header.jsp" />

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
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
   		$(document).ready(function() {
   		  //현재년월일
   		  var date = new Date();
   		  var d= date.getDate();
   		  var m = date.getMonth();
   		  var y = date.getFullYear();
   		  
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
   		  select:function(start,end){
   					
   					
   				 window.open("employeeCalenderInsert.do?start="+start+"&end="+end,"",
   						  "width=450, height=300,status=no,toolbar=no,directories=no,location=no,scrollbars=no, resizable=no") 
			  	
   			  /* var title = prompt('일정을 입력하세요');
   			  if(title){
   				  calendar.fullCalender('renderEvent',
   					on(),
   					true 
   				  ); 
   			  }*/
   			  calender.fullCalendar('unselect');
   		  },
   		  editable:true,
   	    eventSources: [

   	                // your event source
   	                {
   	                    url: 'myfeed.do', // use the `url` property
   	                    color: 'yellow',    // an option!
   	                    textColor: 'black'  // an option!
   	                }

   	                // any other sources...

   	            ]
   		  })
   		});
/*     	    var lang_cd = 'ko';
    	    $('#calendar').fullCalendar({
    	        header: {
    	            left: 'prev,next today',
    	            center: 'title',
    	            right: 'month,listMonth'
    	        },
    	        defaultDate: moment().format('YYYY-MM-DD'),
    	        locale: initialLocaleCode,
    	        editable: true,
    	        navLinks: true,
    	        eventLimit: true,
    	        events: function(start, end, timezone, callback) {
    	            $.ajax({
    	                url: '/test/eventAll.do',
    	                type : 'post',
    	                data : {EVENT_CODE : '11', LANG : lang_cd, startDate : start.format(), endDate : end.format() },
    	                dataType: 'json',
    	                success: function(data) {
    	                    var events = [];
    	                    $(data).each(function() {
    	                        events.push({
    	                            title: $(this).attr('title'),
    	                            start: $(this).attr('start'),
    	                            end: $(this).attr('end'),
    	                            url: "/test/eventDetail.do?id="+$(this).attr('id')+"&amp;lang="+$(this).attr('lang')+"&amp;start="+$(this).attr('start')+"&amp;end="+$(this).attr('end'),
    	                            lang : $(this).attr('lang')
    	                        });
    	                    });
    	                    callback(events);
    	                }
    	            });
    	 
    	        },
    	        loading: function(bool) {
    	            $('#loading').toggle(bool);
    	        } */
    
</script>

   <div id="calendar"></div>