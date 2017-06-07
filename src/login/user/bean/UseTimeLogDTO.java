package login.user.bean;

import java.sql.Timestamp;

public class UseTimeLogDTO {
	private String id;
	private Timestamp loginTime;
	private Timestamp logoutTime;
	private String ip;
	private int r;
	
	
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
