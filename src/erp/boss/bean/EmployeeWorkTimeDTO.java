package erp.boss.bean;

import java.sql.Timestamp;

public class EmployeeWorkTimeDTO {

	private int num;
	private String b_key;
	private Timestamp todayDate;
	private String title;
	private Timestamp start;
	private Timestamp end;
	private Timestamp ex;
	private int result;
	private String backgroundColor;
	private String borderColor;
	
	//출근관리
	private Timestamp commuteTime;
	private Timestamp offWorkTime;
	
	
	
	
	public String getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}
	public String getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
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


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Timestamp getStart() {
		return start;
	}
	public void setStart(Timestamp start) {
		this.start = start;
	}
	public Timestamp getEnd() {
		return end;
	}
	public void setEnd(Timestamp end) {
		this.end = end;
	}
	public Timestamp getEx() {
		return ex;
	}
	public void setEx(Timestamp ex) {
		this.ex = ex;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	
	
}
