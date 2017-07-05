function Toast(type, css, msg){
			this.type = type;
			this.css = css;
			this.msg = msg 
		}
		
toastr.options = {
	  "positionClass": "toast-top-full-width",
		"extendedTimeOut" : 0, //1000;
	    "timeOut" : 0,
	    "fadeOut" : 250,
	    "fadeIn" : 250,	
	    "progressBar" : true, //알람 사라지는 시간 카운트
	    "preventDuplicates" : false, //알람 중복으로 나타나기
	    "tapToDismiss" : true //탭선택시 탭 사라지기
}
	    
	    
	    function delayToasts() {
	        var delay = 0;
	        window.setTimeout(function () { showToast(); }, delay);
	    }

	    function showToast(toasts) {
	        var t = toasts;
	        toastr.options.positionClass = t.css;
	        toastr[t.type](t.msg);
	    }