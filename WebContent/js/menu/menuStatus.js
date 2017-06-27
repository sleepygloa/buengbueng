$(document).ready(function() {
   window.setInterval("state()", 5000); // 5초에 한 번씩 좌석 이용 현황 확인
});

function state() {
   $.ajax({
      url : "userOrderForm.do",
      type : "post",
      data : {
         tf : "1"
      },
      success : function(data) {
         $(".userMenuStatus").html(data);
      }
   });
}