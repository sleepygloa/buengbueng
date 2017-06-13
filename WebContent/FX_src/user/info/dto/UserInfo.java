package user.info.dto;

public class UserInfo {
	private int pcNum;
	private String id;
	private String point;
	private int grade;
	private String loginTime;
	
	private static UserInfo instance = new UserInfo();

	private UserInfo(){
		id = null;
		point = null;
		grade = 3;
		loginTime = null;
	}
	public static UserInfo getInstance(){
		return instance;
	}
	
	public void clear(){
		id = null;
		point = null;
		grade = 3;
		loginTime = null;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPoint(String point){
		this.point = point;
	}
	public String getPoint(){
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
	public int getPcNum() {
		return pcNum;
	}
	public void setPcNum(int pcNum) {
		this.pcNum = pcNum;
	}
}
