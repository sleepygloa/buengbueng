$(document).ready(function(){
	$("#addRent").click(function(){
		$.ajax({
			url: "addRent.do",
			type: "post",
			success: function(data){
				$(".rentDiv").html(data);
			}
		});
	});
	$("#delRent").click(function(){
		var rName = document.getElementsByName("rentName");
		var rentNames = "";
		for(i=0; i<rName.length; i++){
			if(rName[i].checked){
				rentNames += rName[i].value+',';
			}
		}
		$.ajax({
			url: "delRent.do",
			type: "post",
			data:{
				rentName : rentNames
			},
			success: function(data){
				$(".rentDiv").html('');
			}
		});
	});
	$("#addRentProduct").click(function(){
		$.ajax({
			url: "addRentProduct.do",
			type: "post",
			success: function(data){
				$(".rentDiv").html(data);
			}
		});
	});
	$("#delRentProduct").click(function(){
		var rCode = document.getElementsByName("rentCode");
		var rentPCodes = "";
		for(i=0; i<rCode.length; i++){
			if(rCode[i].checked){
				rentPCodes += rCode[i].value+',';
			}
		}
		$.ajax({
			url: "delRentProduct.do",
			type: "post",
			data:{
				rentPCode : rentPCodes
			},
			success: function(data){
				$(".rentDiv").html('');
			}
		});
	});
});

function gotoAlert(txt){
	alert(txt);
	history.go(-1);
}

function rentSelect(){
	document.rentProductForm.rentProduct.value = document.rentProductForm.rent.value;
}

function modiRent(rentProduct){
	$.ajax({
		url: "modiRent.do",
		type: "post",
		data: {
			rentProduct: rentProduct
		},
		success: function(data){
			$(".rentDiv").html(data);
		}
	});
}
function selectedproductList(rentProduct){
	$.ajax({
		url: "selectedRentProductAll.do",
		type: "post",
		data: {
			rentProduct: rentProduct
		},
		success: function(data){
			$(".rentDiv").html(data);
		}
	});
}

function modiRentProduct(rentCode){
	$.ajax({
		url: "modiRentProduct.do",
		type: "post",
		data: {
			rentCode: rentCode
		},
		success: function(data){
			$(".rentDiv").html(data);
		}
	});
}