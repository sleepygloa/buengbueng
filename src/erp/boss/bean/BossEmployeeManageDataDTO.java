package erp.boss.bean;

import java.sql.Timestamp;

public class BossEmployeeManageDataDTO {

	
	private String id;	//회원아이디
	private String b_id;	//사장님아이디
	private int applyCount;	//사장님이 알바생아이디수 신청갯수
	private Timestamp applyTime;	//신청시각
	private Timestamp confirmTime;	//확인한 시각
	private String content;	//신청사유
	
	private int num; // 순번
	private int count; //주고받을 SQL결과의 count수, 알바생과 사장님아이디가 매칭된 갯수
	private String e_bossid;	//사장님아이디
	private String e_id;	//알바생아이디

	private String e_name; //알바생 관리에서 사용할 List에서 사용, name으로하면 오류나나?
	
	
	
	
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
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
