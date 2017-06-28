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
	private String color;
	
	//출근관리
	private Timestamp commuteTime;
	private Timestamp offWorkTime;
	
	
	
	
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
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
