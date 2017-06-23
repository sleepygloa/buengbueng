package erp.boss.bean;

import java.sql.Timestamp;

public class EmployeeWorkTimeDTO {

	private int num;
	private String b_key;
	private Timestamp todayDate;
	private String e_id;
	private Timestamp startTime;
	private Timestamp endTime;
	private Timestamp exTime;
	private int result;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getB_key() {
		return b_key;
	}
	public void setB_key(String b_key) {
		this.b_key = b_key;
	}
	public Timestamp getTodayDate() {
		return todayDate;
	}
	public void setTodayDate(Timestamp todayDate) {
		this.todayDate = todayDate;
	}
	public String getE_id() {
		return e_id;
	}
	public void setE_id(String e_id) {
		this.e_id = e_id;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public Timestamp getExTime() {
		return exTime;
	}
	public void setExTime(Timestamp exTime) {
		this.exTime = exTime;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	
	
}
