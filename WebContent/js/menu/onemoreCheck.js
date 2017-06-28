function menuInsert() {
       if (confirm("등록하시겠습니까?")== true) {
           document.form.submit();
		}
       else {
           alert("등록이 취소되었습니다.");
           return false;
       }
   }

function menuModify() {
    if (confirm("수정하시겠습니까?")== true) {
        document.form.submit();
		}
    else {
        alert("수정이 취소되었습니다.");
        return false;
    }
}

function menuDelete(){
	if(confirm("삭제하시겠습니까?")==true){
		document.form.submit();
	}else{
		alert("삭제를 취소하셨습니다.");
		return false;
	}
}

function getL_keyCheck(l_key){
	if(l_key==0 || l_key=="가맹점 선택"){
		alert("권한이 없습니다.");
		return false;
	}
}
