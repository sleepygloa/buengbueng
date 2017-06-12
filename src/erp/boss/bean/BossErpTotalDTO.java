package erp.boss.bean;

import java.sql.Timestamp;

public class BossErpTotalDTO {

	private String id;  //회원아이디
	private Timestamp loginTime; //알바시작한 년월일
	private int count; //알바시작한 날의 일한시간
	
	
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
}
