package user.info.dto;

public class UserInfo {
	private String pcNum; // 사용자가 앉은 PC 좌석 번호
	private String id; // 사용자 ID
	private double startPoint;
	private double point; // 사용자 잔액
	private int grade; // 사용자 등급
	private String loginTime; // 사용자 로그인 시간
	private String b_key = "b7fd755f";
	private String bossIP;
	private String franchiseeName;
	private double moneyPolicy;

	private static UserInfo instance = new UserInfo();

	private UserInfo(){
		pcNum = null;
		id = null;
		startPoint = 0;
		point = 0;
		grade = 0;
		loginTime = null;
		bossIP = null;
		franchiseeName = null;
		moneyPolicy = 0;
	}
	public static UserInfo getInstance(){
		return instance;
	}
	
	public void clear(){
		pcNum = null;
		id = null;
		startPoint = 0;
		point = 0;
		grade = 0;
		loginTime = null;
		bossIP = null;
		franchiseeName = null;
		moneyPolicy = 0;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(double startPoint) {
		this.startPoint = startPoint;
	}
	public void setPoint(double point){
		this.point = point;
	}
	public double getPoint(){
		return point;
	}
	public void setGrade(int grade){
		this.grade = grade;
	}
	public int getGrade(){
		return grade;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public String getPcNum() {
		return pcNum;
	}
	public void setPcNum(String pcNum) {
		this.pcNum = pcNum;
	}
	public String getB_key() {
		return b_key;
	}
	public void setB_key(String b_key) {
		this.b_key = b_key;
	}
	public String getBossIP() {
		return bossIP;
	}
	public void setBossIP(String bossIP) {
		this.bossIP = bossIP;
	}
	public String getFranchiseeName() {
		return franchiseeName;
	}
	public void setFranchiseeName(String franchiseeName) {
		this.franchiseeName = franchiseeName;
	}
	public double getMoneyPolicy() {
		return moneyPolicy;
	}
	public void setMoneyPolicy(double moneyPolicy) {
		this.moneyPolicy = moneyPolicy;
	}
	
}
