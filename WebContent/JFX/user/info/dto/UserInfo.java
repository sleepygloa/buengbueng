package user.info.dto;

public class UserInfo {
	private String pcNum; // 사용자가 앉은 PC 좌석 번호
	private String id; // 사용자 ID
	private double point; // 사용자 잔액
	private int grade; // 사용자 등급
	private String loginTime; // 사용자 로그인 시간

	private static UserInfo instance = new UserInfo();

	private UserInfo(){
		id = null;
		point = 0;
		grade = 3;
		loginTime = null;
	}
	public static UserInfo getInstance(){
		return instance;
	}
	
	public void clear(){
		id = null;
		point = 0;
		grade = 3;
		loginTime = null;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
}
