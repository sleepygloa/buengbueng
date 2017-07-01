/* 사장님의 자신의 가맹점 select 값넘겨주는것*/
function userFranchiseeSelect(){
	document.userSelectFranchisee.name.value = document.userSelectFranchisee.userfranchisee_select.value;
}


/* 사장님의 자신의 가맹점 select 값넘겨주는것*/
function franchiseeSelect(){
	document.franchiseeMenu.name.value = document.franchiseeMenu.franchisee_select.value;
}


/* 위와 동일 (수정때) */
function productSelect2(){
	document.productModifyForm.name.value = document.productModifyForm.menu_select.value;
}

/* 사장이 메뉴등록시 카테고리별로 리스트 보이도록  */
function category(category,l_key){
		$.ajax({
			url:"menuCategoryClick.do",
			type:"post",
			data: {category: category,l_key:l_key},
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
function usercategory(category,l_key,name,id){
	$.ajax({
		url:"userCategoryClick.do",
		type:"post",
		data: {category: category, l_key:l_key, name:name, id:id},
		success:function(data){
			$("#usercategoryMenu").html(data);
		}
	});
}
/* 사용자가 전체버튼을 눌렀을 때 전체메뉴가 리스트 보이도록  */
function useralls(l_key,name,id){
	$.ajax({
		url:"userCategoryAll.do",
		type:"post",
		data : {l_key : l_key , name:name, id:id},
		success:function(data){
			$("#usercategoryMenu").html(data);
		}
	});
}


