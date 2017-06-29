$(document).ready(function() {
   window.setInterval("state()", 1000); // 5초에 한 번씩 좌석 이용 현황 확인
});

$(document).ready(function() {
	   window.setInterval("bossstate()", 1000); // 5초에 한 번씩 좌석 이용 현황 확인
	});



function state() {
   $.ajax({
      url : "userOrderForm.do",
      type : "post",
      data : {
         tf : "1",
         name: document.getElementById("name").value
      },
      success : function(data) {
         $(".userMenuStatus").html(data);
      }
   });
}

function bossstate() {
   $.ajax({
      url : "menuOrderListForm.do",
      type : "post",
      data : {
         tf : "1"
      },
      success : function(data) {
         $(".bossMenuStatus").html(data);
      }
   });
}