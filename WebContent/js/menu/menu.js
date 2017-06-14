



function franchiseeSelect(){
	document.franchiseeMenu.name.value = document.franchiseeMenu.franchisee_select.value;
}





/* 메뉴에 저장된 메뉴명만 뜰 수 있도록 (추가) */
function productSelect(){
	document.productInsertForm.name.value = document.productInsertForm.menu_select.value;
}

/* 위와 동일 (수정때) */
function productSelect2(){
	document.productModifyForm.name.value = document.productModifyForm.menu_select.value;
}

/* 사장이 메뉴등록시 카테고리별로 리스트 보이도록  */
function category(category){
		$.ajax({
			url:"menuCategoryClick.do",
			type:"post",
			data: {category: category},
			success:function(data){
				$("#categoryMenu").html(data);
			}
		});
}

/* 사장이 전체버튼을 눌렀을 때 전체메뉴가 리스트 보이도록  */
function alls(l_key){
	$.ajax({
		url:"menuCategoryAll.do",
		type:"post",
		data : {l_key: l_key},
		success:function(data){
			$("#categoryMenu").html(data);
		}
	});
}

/* 사용자가 각 카테고리버튼을 눌렀을 시 카테고리별로 리스트 보이도록  */
function usercategory(category){
	$.ajax({
		url:"userCategoryClick.do",
		type:"post",
		data: {category: category},
		success:function(data){
			$("#usercategoryMenu").html(data);
		}
	});
}
/* 사용자가 전체버튼을 눌렀을 때 전체메뉴가 리스트 보이도록  */
function useralls(){
	$.ajax({
		url:"userCategoryAll.do",
		type:"post",
		success:function(data){
			$("#usercategoryMenu").html(data);
		}
	});
}


