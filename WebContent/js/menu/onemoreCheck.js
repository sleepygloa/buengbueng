function menuInsertForm() {
	
	if (confirm("등록하시겠습니까?")== true) {
		if(document.menuInsert.category.value == ""){
			alert("카테고리를 입력하십시오.");
			return false;
		}
		if(document.menuInsert.name.value == ""){
			alert("메뉴명을 입력하십시오.");
			return false;
		}
		if(document.menuInsert.company.value == ""){
			alert("제조사를 입력하십시오.");
			return false;
		}
		if(document.menuInsert.price.value == ""){
			alert("가격를 입력하십시오.");
			return false;
		}
		document.form.submit();
        
		}
    else {
        alert("등록이 취소되었습니다.");
        return false;
    }
}

function menuModifyForm() {
    if (confirm("수정하시겠습니까?")== true) {
    	if(document.menuModify.category.value == ""){
			alert("카테고리를 입력하십시오.");
			return false;
		}
		if(document.menuModify.name.value == ""){
			alert("메뉴명을 입력하십시오.");
			return false;
		}
		if(document.menuModify.company.value == ""){
			alert("제조사를 입력하십시오.");
			return false;
		}
		if(document.menuModify.price.value == ""){
			alert("가격를 입력하십시오.");
			return false;
		}
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

function productInsertForm() {
	
	if (confirm("등록하시겠습니까?")== true) {
		
		if(document.productInsert.name.value == "등록 메뉴 보기"){
			alert("메뉴명을 선택하십시오.");
			return false;
		}
		if(document.productInsert.code.value == ""){
			alert("바코드를 입력하십시오.");
			return false;
		}
		if(document.productInsert.code.value.length!=13){
			alert("바코드는 13자리 입니다.");
			return false;
		}
		
		if(document.productInsert.last.value == ""){
			alert("유통기한을 입력하십시오.");
			return false;
		}
		document.form.submit();
        
		}
    else {
        alert("등록이 취소되었습니다.");
        return false;
    }
}

function productModifyForm() {
    if (confirm("수정하시겠습니까?")== true) {

		if(document.productModify.code.value == ""){
			alert("바코드번호를 입력하십시오.");
			return false;
		}
		if(document.productModify.code.value.length!=13){
			alert("바코드는 13자리 입니다.");
			return false;
		}
		if(document.productModify.last.value == ""){
			alert("유통기한를 입력하십시오.");
			return false;
		}
        document.form.submit();
		}
    else {
        alert("수정이 취소되었습니다.");
        return false;
    }
}

function getL_keyCheck(l_key){
	if(l_key==0 || l_key=="가맹점 선택"){
		alert("권한이 없습니다.");
		return false;
	}
}
