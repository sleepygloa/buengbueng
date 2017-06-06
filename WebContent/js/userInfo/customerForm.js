//가맹 문의 기본 검사
function franchiseCheck(){
	if(document.franchise.writer.value==""){
		alert("작성자를 확인해주세요.");
		document.franchise.writer.focus();
		return false;
	}
	if(document.franchise.email.value==""){
		alert("이메일을 확인해주세요.");
		document.franchise.email.focus();
		return false;
	}
	if(document.franchise.title.value==""){
		alert("제목을 입력해주세요.");
		document.franchise.title.focus();
		return false;
	}
	if(document.franchise.content.value==""){
		alert("내용을 입력해주세요.");
		document.franchise.content.focus();
		return false;
	}
	if(document.franchise.passwd.value==""){
		alert("비밀번호를 입력해주세요.");
		document.franchise.passwd.focus();
		return false;
	}
}
function franchiseModify(){
	if(document.franchise_m.email.value==""){
		alert("이메일을 확인해주세요.");
		document.franchise_m.email.focus();
		return false;
	}
	if(document.franchise_m.title.value==""){
		alert("제목을 입력해주세요.");
		document.franchise_m.title.focus();
		return false;
	}
	if(document.franchise_m.content.value==""){
		alert("내용을 입력해주세요.");
		document.franchise_m.content.focus();
		return false;
	}
	if(document.franchise_m.passwd.value==""){
		alert("비밀번호를 입력해주세요.");
		document.franchise_m.passwd.focus();
		return false;
	}
}
//Q & A 기본 검사
function customerCheck(){
	if(document.customer.writer.value==""){
		alert("작성자를 확인해주세요.");
		document.customer.writer.focus();
		return false;
	}
	if(document.customer.email.value==""){
		alert("이메일을 확인해주세요.");
		document.customer.email.focus();
		return false;
	}
	if(document.customer.title.value==""){
		alert("제목을 입력해주세요.");
		document.customer.title.focus();
		return false;
	}
	if(document.customer.content.value==""){
		alert("내용을 입력해주세요.");
		document.customer.content.focus();
		return false;
	}
	if(document.customer.passwd.value==""){
		alert("비밀번호를 입력해주세요.");
		document.customer.passwd.focus();
		return false;
	}
}
function customerModify(){
	if(document.customer_m.email.value==""){
		alert("이메일을 확인해주세요.");
		document.customer_m.email.focus();
		return false;
	}
	if(document.customer_m.title.value==""){
		alert("제목을 입력해주세요.");
		document.customer_m.title.focus();
		return false;
	}
	if(document.customer_m.content.value==""){
		alert("내용을 입력해주세요.");
		document.customer_m.content.focus();
		return false;
	}
	if(document.customer_m.passwd.value==""){
		alert("비밀번호를 입력해주세요.");
		document.customer_m.passwd.focus();
		return false;
	}
}

//1:1 문의 기본 검사
function oneCheck(){
	if(document.one.writer.value==""){
		alert("작성자를 확인해주세요.");
		document.one.writer.focus();
		return false;
	}
	if(document.one.email.value==""){
		alert("이메일을 확인해주세요.");
		document.one.email.focus();
		return false;
	}
	if(document.one.title.value==""){
		alert("제목을 입력해주세요.");
		document.one.title.focus();
		return false;
	}
	if(document.one.content.value==""){
		alert("내용을 입력해주세요.");
		document.one.content.focus();
		return false;
	}
	if(document.one.passwd.value==""){
		alert("비밀번호를 입력해주세요.");
		document.one.passwd.focus();
		return false;
	}
}
function oneModify(){
	if(document.one_m.email.value==""){
		alert("이메일을 확인해주세요.");
		document.one_m.email.focus();
		return false;
	}
	if(document.one_m.title.value==""){
		alert("제목을 입력해주세요.");
		document.one_m.title.focus();
		return false;
	}
	if(document.one_m.content.value==""){
		alert("내용을 입력해주세요.");
		document.one_m.content.focus();
		return false;
	}
	if(document.one_m.passwd.value==""){
		alert("비밀번호를 입력해주세요.");
		document.one_m.passwd.focus();
		return false;
	}
}