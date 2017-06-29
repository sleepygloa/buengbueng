package login.user.bean;

import java.sql.Timestamp;

public class UseTimeLogDTO {
	
	private String id; //로그인로그아웃 아이디
	private int grade; // 사용자 등급
	private Timestamp loginTime; //로그인시간
	private Timestamp logoutTime; //로그아웃시간
	private String ip; //접속장소 IP
	
	private String licenseKey; //가맹점 라이센스
	
	private int r; //게시판 정렬카운트
	private int workTime; //알바가 일한시간(초)
	
	//FX호환 DTO
	private int usePcUseTime; //로그인해서 로그아웃까지 사용시간(초)
	private int usePcUseTimePay; //사용시간 * 이용정책 = 결제금액, 사용금액, 지불해야하는돈.
	private int userAccountMoney; //회원이 가지고있는 현재 돈
	private int payAfterMoney; //지불하고 남은돈.
	private String b_key; //라이센스키
	
	//FX호환 DTO
	private int employeeWorkTime; //로그인해서 로그아웃까지 근무시간(초)
	private int employeeWorkTimePay; //근무시간 * 근무정책 = 결제금액, 지불금액, 알바비
	private int employeeAccountMoney; //알바에게 적립된 금액
	private Timestamp commuteTime;
	private Timestamp offWorkTime;
	private String e_id;
	private String b_id;
	
	
	
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public String getE_id() {
		return e_id;
	}
	public void setE_id(String e_id) {
		this.e_id = e_id;
	}
	public Timestamp getCommuteTime() {
		return commuteTime;
	}
	public void setCommuteTime(Timestamp commuteTime) {
		this.commuteTime = commuteTime;
	}
	public Timestamp getOffWorkTime() {
		return offWorkTime;
	}
	public void setOffWorkTime(Timestamp offWorkTime) {
		this.offWorkTime = offWorkTime;
	}
	public int getEmployeeWorkTime() {
		return employeeWorkTime;
	}
	public void setEmployeeWorkTime(int employeeWorkTime) {
		this.employeeWorkTime = employeeWorkTime;
	}
	public int getEmployeeWorkTimePay() {
		return employeeWorkTimePay;
	}
	public void setEmployeeWorkTimePay(int employeeWorkTimePay) {
		this.employeeWorkTimePay = employeeWorkTimePay;
	}
	public int getEmployeeAccountMoney() {
		return employeeAccountMoney;
	}
	public void setEmployeeAccountMoney(int employeeAccountMoney) {
		this.employeeAccountMoney = employeeAccountMoney;
	}
	public String getB_key() {
		return b_key;
	}
	public void setB_key(String b_key) {
		this.b_key = b_key;
	}
	public int getUsePcUseTime() {
		return usePcUseTime;
	}
	public void setUsePcUseTime(int usePcUseTime) {
		this.usePcUseTime = usePcUseTime;
	}
	public int getUsePcUseTimePay() {
		return usePcUseTimePay;
	}
	public void setUsePcUseTimePay(int usePcUseTimePay) {
		this.usePcUseTimePay = usePcUseTimePay;
	}
	public int getUserAccountMoney() {
		return userAccountMoney;
	}
	public void setUserAccountMoney(int userAccountMoney) {
		this.userAccountMoney = userAccountMoney;
	}
	public int getPayAfterMoney() {
		return payAfterMoney;
	}
	public void setPayAfterMoney(int payAfterMoney) {
		this.payAfterMoney = payAfterMoney;
	}
	public int getWorkTime() {
		return workTime;
	}
	public void setWorkTime(int workTime) {
		this.workTime = workTime;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getLicenseKey() {
		return licenseKey;
	}
	public void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}
	public Timestamp getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}
	public Timestamp getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(Timestamp logoutTime) {
		this.logoutTime = logoutTime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
	
	
}
