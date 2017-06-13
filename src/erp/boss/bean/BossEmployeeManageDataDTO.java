package erp.boss.bean;

import java.sql.Timestamp;

public class BossEmployeeManageDataDTO {

	private String id;
	private String b_id;
	private int applyCount;
	private Timestamp applyTime;
	private Timestamp confirmTime;
	private String content;
	
	private int count; //주고받을 SQL결과의 count수, 알바생과 사장님아이디가 매칭된 갯수
	private String e_bossid;
	private String e_id;
	
	
	
	public String getE_bossid() {
		return e_bossid;
	}
	public void setE_bossid(String e_bossid) {
		this.e_bossid = e_bossid;
	}
	public String getE_id() {
		return e_id;
	}
	public void setE_id(String e_id) {
		this.e_id = e_id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public int getApplyCount() {
		return applyCount;
	}
	public void setApplyCount(int applyCount) {
		this.applyCount = applyCount;
	}
	public Timestamp getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Timestamp applyTime) {
		this.applyTime = applyTime;
	}
	public Timestamp getConfirmTime() {
		return confirmTime;
	}
	public void setConfirmTime(Timestamp confirmTime) {
		this.confirmTime = confirmTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}	
	
	
	
	
}
