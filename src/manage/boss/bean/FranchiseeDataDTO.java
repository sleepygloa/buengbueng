package manage.boss.bean;

import java.sql.Timestamp;

public class FranchiseeDataDTO {


	private String b_id; //사장님아이디
	private String b_name; //사업장이름
	private String b_number; //사업자 주소
	private String b_address; //사업장주소
	private String b_tel; //사업장 전화번호
	private String b_size; //사업장 규모
	private String b_pccount; //사업장 내 보유 PC수
	private String b_ip; //사업장 사장님 PC IP
	private String b_key; //프로그램 License Key
	
	private int num; //신청번호 //가맹점 list에서 사용
	private Timestamp date; //신청날짜
	private Timestamp finishDate; //승인날짜
	private int result; //신청결과
	
	private String reason; //삭제 사유
	private String pw; //삭제비밀번호
	
	
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		date = date;
	}
	public Timestamp getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Timestamp finishDate) {
		this.finishDate = finishDate;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_number() {
		return b_number;
	}
	public void setB_number(String b_number) {
		this.b_number = b_number;
	}
	public String getB_address() {
		return b_address;
	}
	public void setB_address(String b_address) {
		this.b_address = b_address;
	}
	public String getB_tel() {
		return b_tel;
	}
	public void setB_tel(String b_tel) {
		this.b_tel = b_tel;
	}
	public String getB_size() {
		return b_size;
	}
	public void setB_size(String b_size) {
		this.b_size = b_size;
	}
	public String getB_pccount() {
		return b_pccount;
	}
	public void setB_pccount(String b_pccount) {
		this.b_pccount = b_pccount;
	}
	public String getB_ip() {
		return b_ip;
	}
	public void setB_ip(String b_ip) {
		this.b_ip = b_ip;
	}
	public String getB_key() {
		return b_key;
	}
	public void setB_key(String b_key) {
		this.b_key = b_key;
	}

}
