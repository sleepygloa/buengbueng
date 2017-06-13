/* 전화번호,생년월일 숫자만 입력가능하게 하는 정규식 */
var phone = /^[0-9]*$/;
/* 이메일 입력 정규식 */
var email = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;;

/* 사용자 회원가입 모든 항목 체크 */
function checkSignAll(){
	if(document.signForm.id.value == ""){
		document.signForm.alert.value = "아이디를 입력하십시오.";
		return false;
	}
	if(document.signForm.pw.value == ""){
		document.signForm.alert.value = "비밀번호를 입력하십시오.";
		return false;
	}if(document.signForm.pw_chk.value == ""){
		document.signForm.alert.value = "비밀번호 확인을 입력하십시오.";
		return false;
	}
	if(document.signForm.pw.value != document.signForm.pw_chk.value){
		document.signForm.alert.value = "비밀번호와 비밀번호 확인이 다릅니다.";
		return false;
	}
	if(document.signForm.name.value == ""){
		document.signForm.alert.value = "이름을 입력하십시오.";
		return false;
	}
	if(document.signForm.birth.value == ""){
		document.signForm.alert.value = "생년월일을 입력하십시오.";
		return false;
	}
	if(!phone.test(document.signForm.birth.value)){
		document.signForm.alert.value = "생년월일은 숫자만 입력하십시오.";
		document.signForm.birth.value = "";
		return false;
	}
	if(document.signForm.address.value == ""){
		document.signForm.alert.value = "주소를 입력하십시오.";
		return false;
	}
	if(document.signForm.phone_1.value == "" ){
		document.signForm.alert.value = "전화번호를 입력하십시오.";
		return false;
	}
	if(!phone.test(document.signForm.phone_1.value)){
		document.signForm.alert.value = "전화번호는 숫자만 입력하십시오.";
		document.signForm.phone_1.value = "";
		return false;
	}
	if(document.signForm.phone_2.value == "" ){
		document.signForm.alert.value = "전화번호를 입력하십시오.";
		return false;
	}
	if(!phone.test(document.signForm.phone_2.value)){
		document.signForm.alert.value = "전화번호는 숫자만 입력하십시오.";
		document.signForm.phone_2.value = "";
		return false;
	}
	if(document.signForm.phone_3.value == "" ){
		document.signForm.alert.value = "전화번호를 입력하십시오.";
		return false;
	}
	if(!phone.test(document.signForm.phone_3.value)){
		document.signForm.alert.value = "전화번호는 숫자만 입력하십시오.";
		document.signForm.phone_3.value = "";
		return false;
	}
	if(document.signForm.email.value == ""){
		document.signForm.alert.value = "이메일을 입력하십시오.";
		return false;
	}
	if(!email.test(document.signForm.email.value)){
		document.signForm.alert.value = "이메일을 정확하게 입력하십시오.";
		return false;
	}
	// 사장님 js
	if(document.signForm.b_name.value == ""){
		document.signForm.alert.value = "상호명을 입력하십시오.";
		return false;
	}
	if(document.signForm.b_number_1.value == "" ){
		document.signForm.alert.value = "사업자번호를 입력하십시오.";
		return false;
	}
	if(!b_number.test(document.signForm.b_number_1.value)){
		document.signForm.alert.value = "사업자번호는 숫자만 입력하십시오.";
		document.signForm.b_number_1.value = "";
		return false;
	}
	if(document.signForm.b_number_2.value == "" ){
		document.signForm.alert.value = "사업자번호를 입력하십시오.";
		return false;
	}
	if(!b_number.test(document.signForm.b_number_2.value)){
		document.signForm.alert.value = "사업자번호는 숫자만 입력하십시오.";
		document.signForm.b_number_2.value = "";
		return false;
	}
	if(document.signForm.b_number_3.value == "" ){
		document.signForm.alert.value = "사업자번호를 입력하십시오.";
		return false;
	}
	if(!b_number.test(document.signForm.b_number_3.value)){
		document.signForm.alert.value = "사업자번호는 숫자만 입력하십시오.";
		document.signForm.b_number_3.value = "";
		return false;
	}
	if(document.signForm.b_address.value == ""){
		document.signForm.alert.value = "주소를 입력하십시오.";
		return false;
	}
	if(document.signForm.b_tel1.value == "" ){
		document.signForm.alert.value = "전화번호를 입력하십시오.";
		return false;
	}
	if(!b_tel.test(document.signForm.b_tel1.value)){
		document.signForm.alert.value = "전화번호는 숫자만 입력하십시오.";
		document.signForm.b_tel1.value = "";
		return false;
	}
	if(document.signForm.b_tel2.value == "" ){
		document.signForm.alert.value = "전화번호를 입력하십시오.";
		return false;
	}
	if(!b_tel.test(document.signForm.b_tel2.value)){
		document.signForm.alert.value = "전화번호는 숫자만 입력하십시오.";
		document.signForm.b_tel2.value = "";
		return false;
	}
	if(document.signForm.b_tel3.value == "" ){
		document.signForm.alert.value = "전화번호를 입력하십시오.";
		return false;
	}
	if(!b_tel.test(document.signForm.b_tel3.value)){
		document.signForm.alert.value = "전화번호는 숫자만 입력하십시오.";
		document.signForm.b_tel3.value = "";
		return false;
	}
	if(document.signForm.b_size.value == ""){
		document.signForm.alert.value = "사업장의 규모를 입력하십시오.";
		return false;
	}
	if(document.signForm.b_pccount.value == ""){
		document.signForm.alert.value = "보유 PC 수 를 입력하십시오.";
		return false;
	}
	if(document.signForm.b_ip.value == ""){
		document.signForm.alert.value = "대표 IP를 입력하십시오.";
		return false;
	}
	// 알바 js
	if(document.signForm.e_bossid.value == ""){
		document.signForm.alert.value = "사장님 아이디를 입력하십시오.";
		return false;
	}
	
}




/* 아이디 입력 확인 */
function checkId(){
	if(document.signForm.id.value == ""){
		document.signForm.alert.value = "아이디를 입력하십시오.";
		return false;
	}
	url = "/buengbueng/userInfoSignCheckId.do?id=" + document.signForm.id.value;
	window.open(url,"checkId", "toolbar=no, location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500, height=200");
}
/* 비밀번호 입력 확인 */
function chechPw(){
	if(document.signForm.pw.value == ""){
		document.signForm.alert.value = "비밀번호를 입력하십시오.";
		return false;
	}if(document.signForm.pw_chk.value == ""){
		document.signForm.alert.value = "비밀번호 확인을 입력하십시오.";
		return false;
	}
	if(document.signForm.pw.value != document.signForm.pw_chk.value){
		document.signForm.alert.value = "비밀번호와 비밀번호 확인이 다릅니다.";
		return false;
	}
	else{
		document.signForm.alert.value = "";
	}
}
/* 이름 입력 확인 */
function checkName(){
	if(document.signForm.name.value == ""){
		document.signForm.alert.value = "이름을 입력하십시오.";
		return false;
	}
	else{
		document.signForm.alert.value = "";
	}
}
/* 생년월일 입력 확인 */
function checkBirth(){
	if(document.signForm.birth.value == ""){
		document.signForm.alert.value = "생년월일을 입력하십시오.";
		return false;
	}
	if(!phone.test(document.signForm.birth.value)){
		document.signForm.alert.value = "생년월일은 숫자만 입력하십시오.";
		document.signForm.birth.value = "";
		return false;
	}
	else{
		document.signForm.alert.value = "";
	}
}
/* 주소 입력 확인 */
function checkAddress(){
	if(document.signForm.address.value == ""){
		document.signForm.alert.value = "주소를 입력하십시오.";
		return false;
	}
	else{
		document.signForm.alert.value = "";
	}
}
/* 전화번호 입력 확인 */
function checkPhone_1(){
	if(document.signForm.phone_1.value == "" ){
		document.signForm.alert.value = "전화번호를 입력하십시오.";
		return false;
	}
	if(!phone.test(document.signForm.phone_1.value)){
		document.signForm.alert.value = "전화번호는 숫자만 입력하십시오.";
		document.signForm.phone_1.value = "";
		return false;
	}
	else{
		document.signForm.alert.value = "";
	}
}
function checkPhone_2(){
	if(document.signForm.phone_2.value == "" ){
		document.signForm.alert.value = "전화번호를 입력하십시오.";
		return false;
	}
	if(!phone.test(document.signForm.phone_2.value)){
		document.signForm.alert.value = "전화번호는 숫자만 입력하십시오.";
		document.signForm.phone_2.value = "";
		return false;
	}
	else{
		document.signForm.alert.value = "";
	}
}
function checkPhone_3(){
	if(document.signForm.phone_3.value == "" ){
		document.signForm.alert.value = "전화번호를 입력하십시오.";
		return false;
	}
	if(!phone.test(document.signForm.phone_3.value)){
		document.signForm.alert.value = "전화번호는 숫자만 입력하십시오.";
		document.signForm.phone_3.value = "";
		return false;
	}
	else{
		document.signForm.alert.value = "";
	}
}
/* 이메일 입력 확인 */
function checkEmail(){
	if(document.signForm.email.value == ""){
		document.signForm.alert.value = "이메일을 입력하십시오.";
		return false;
	}
	else{
		document.signForm.alert.value = "";
	}
}


/* 이메일에서 직접입력 외의 것 누르면 실행 */
function emailSelect(){
	var email = document.signForm.email.value;
	var id = email.split('@');
	document.signForm.email.value = id[0] + document.signForm.email_addr_select.value;
}
/* 아이디가 중복되지 않으면 입력한 아이디로 값 변경 */
function setId(id){
	opener.document.signForm.id.value = id;
	opener.document.signForm.alert.value = "";
	setTimeout('self.close()',2000);
}
/* 취소 버튼 클릭 시 main으로 이동 */
function cancel(){
	window.location = '/buengbueng/index.do';
}
/* 회원 가입이 정상적으로 완료되지 않으면 이전 페이지로 이동 */
function historyGo(){
	alert("회원 가입에 실패했습니다.");
	history.go(-1);
}

/* 알바가 회원 가입 중에 사장님 아이디를 잘못 입력했을 경우 */
function bossNoCheck(){
	alert("사장님 아이디가 존재하지 않습니다.");
	history.go(-1);
}

/* 사장님 정보 입력 확인 */

//상호명 입력 확인.
function checkB_name(){
	if(document.signForm.b_name.value == ""){
		document.signForm.alert.value = "상호명을 입력하십시오.";
		return false;
	}
	else{
		document.signForm.alert.value = "";
	}
}

//사업자번호 입력 확인.
function checkB_number_1(){
	if(document.signForm.b_number_1.value == "" ){
		document.signForm.alert.value = "사업자번호를 입력하십시오.";
		return false;
	}
	if(!b_number.test(document.signForm.b_number_1.value)){
		document.signForm.alert.value = "사업자번호는 숫자만 입력하십시오.";
		document.signForm.b_number_1.value = "";
		return false;
	}
	else{
		document.signForm.alert.value = "";
	}
}

function checkB_number_2(){
	if(document.signForm.b_number_2.value == "" ){
		document.signForm.alert.value = "사업자번호를 입력하십시오.";
		return false;
	}
	if(!b_number.test(document.signForm.b_number_2.value)){
		document.signForm.alert.value = "사업자번호는 숫자만 입력하십시오.";
		document.signForm.b_number_2.value = "";
		return false;
	}
	else{
		document.signForm.alert.value = "";
	}
}

function checkB_number_3(){
	if(document.signForm.b_number_3.value == "" ){
		document.signForm.alert.value = "사업자번호를 입력하십시오.";
		return false;
	}
	if(!b_number.test(document.signForm.b_number_3.value)){
		document.signForm.alert.value = "사업자번호는 숫자만 입력하십시오.";
		document.signForm.b_number_3.value = "";
		return false;
	}
	else{
		document.signForm.alert.value = "";
	}
}

//사업장 주소 입력 확인.
function checkB_address(){
	if(document.signForm.b_address.value == ""){
		document.signForm.alert.value = "사업장 주소를 입력하십시오.";
		return false;
	}
	else{
		document.signForm.alert.value = "";
	}
}

//사업장 전화번호 입력 확인.

function checkB_tel1(){
	if(document.signForm.b_tel1.value == "" ){
		document.signForm.alert.value = "사업장 전화번호를 입력하십시오.";
		return false;
	}
	if(!b_tel.test(document.signForm.b_tel1.value)){
		document.signForm.alert.value = "사업장 전화번호는 숫자만 입력하십시오.";
		document.signForm.b_tel1.value = "";
		return false;
	}
	else{
		document.signForm.alert.value = "";
	}
}

function checkB_tel2(){
	if(document.signForm.b_tel2.value == "" ){
		document.signForm.alert.value = "사업장 전화번호를 입력하십시오.";
		return false;
	}
	if(!b_tel.test(document.signForm.b_tel2.value)){
		document.signForm.alert.value = "사업장 전화번호는 숫자만 입력하십시오.";
		document.signForm.b_tel2.value = "";
		return false;
	}
	else{
		document.signForm.alert.value = "";
	}
}

function checkB_tel3(){
	if(document.signForm.b_tel3.value == "" ){
		document.signForm.alert.value = "사업장 전화번호를 입력하십시오.";
		return false;
	}
	if(!b_tel.test(document.signForm.b_tel3.value)){
		document.signForm.alert.value = "사업장 전화번호는 숫자만 입력하십시오.";
		document.signForm.b_tel3.value = "";
		return false;
	}
	else{
		document.signForm.alert.value = "";
	}
}

//사업장 규모 입력 확인
function checkB_size(){
	if(document.signForm.b_size.value == ""){
		document.signForm.alert.value = "사업장 규모를 입력하십시오.";
		return false;
	}
	else{
		document.signForm.alert.value = "";
	}
}


//보유 컴퓨터 수 입력 확인
function checkB_pccount(){
	if(document.signForm.b_pccount.value == ""){
		document.signForm.alert.value = "보유 컴퓨터 수량을 입력하십시오.";
		return false;
	}
	else{
		document.signForm.alert.value = "";
	}
}

//대표 IP 입력 확인

function checkB_ip(){
	if(document.signForm.b_ip.value == ""){
		document.signForm.alert.value = "대표 IP를 입력하십시오.";
		return false;
	}
	else{
		document.signForm.alert.value = "";
	}
}


//등급 알바의 사장님 아이디 입력 확인.
function checkE_bossid(){
	if(document.signForm.e_bossid.value == ""){
		document.signForm.alert.value = "사장님 아이디를 입력하십시오.";
		return false;
	}
	else{
		document.signForm.alert.value = "";
	}
}







