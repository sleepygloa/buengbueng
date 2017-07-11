$(document).ready(function(){
	$(document).bind('keydown',function(e){
		if (e.keyCode == 123) { /* F12 */
			e.preventDefault();
			e.returnValue = false;
		}
		if(e.ctrlKey && e.keyCode == 86){ /*ctrl + v*/ 
			e.preventDefault();
			e.returnValue=false; 
		}
		if(e.ctrlKey && e.keyCode == 67){ /*ctrl + c*/
			e.preventDefault();
			e.returnValue=false;
		}
		if(e.ctrlKey && e.keyCode == 85){ /*ctrl + u*/
			e.preventDefault();
			e.returnValue=false;
		}
		if(e.ctrlKey && e.keyCode == 83){ /*ctrl + s*/
			e.preventDefault();
			e.returnValue=false;
		}
		if(e.ctrlKey && e.shiftKey && e.keyCode == 73){ /*ctrl + shift + i*/
			e.preventDefault();
			e.returnValue=false;
		}
	});
	$(document).bind("contextmenu", function() {
		 return false;
	});
	$(document).bind('selectstart',function() {
		return false;
	}); 
	$(document).bind('dragstart',function(){
		return false;
	}); 
});

