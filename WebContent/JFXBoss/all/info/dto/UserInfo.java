package all.info.dto;

public class UserInfo {
	private String id; // 사용자 ID
	private int grade; // 사용자 등급
	private String loginTime; // 사용자 로그인 시간
	private String b_key = "b7fd755f";
	private static UserInfo instance = new UserInfo();

	private UserInfo(){
		id = null;
		grade = 3;
		loginTime = null;
	}
	public static UserInfo getInstance(){
		return instance;
	}
	
	public void clear(){
		id = null;
		grade = 3;
		loginTime = null;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getB_key() {
		return b_key;
	}
	public void setB_key(String b_key) {
		this.b_key = b_key;
	}
	
}
