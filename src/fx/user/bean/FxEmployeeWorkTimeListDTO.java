package fx.user.bean;

import java.sql.Timestamp;

public class FxEmployeeWorkTimeListDTO {
	
	private int wtNum;
	private Timestamp wtTodayDate;
	private String wtTitle;
	private Timestamp wtStart;
	private Timestamp wtEnd;
	private Timestamp wtCommuteTime;
	private Timestamp wtOffWorkTime;
	private int wtResult;
	private String wtColor;
	private Timestamp wtEx;
	public int getWtNum() {
		return wtNum;
	}
	public void setWtNum(int wtNum) {
		this.wtNum = wtNum;
	}
	public Timestamp getWtTodayDate() {
		return wtTodayDate;
	}
	public void setWtTodayDate(Timestamp wtTodayDate) {
		this.wtTodayDate = wtTodayDate;
	}
	public String getWtTitle() {
		return wtTitle;
	}
	public void setWtTitle(String wtTitle) {
		this.wtTitle = wtTitle;
	}
	public Timestamp getWtStart() {
		return wtStart;
	}
	public void setWtStart(Timestamp wtStart) {
		this.wtStart = wtStart;
	}
	public Timestamp getWtEnd() {
		return wtEnd;
	}
	public void setWtEnd(Timestamp wtEnd) {
		this.wtEnd = wtEnd;
	}
	public Timestamp getWtCommuteTime() {
		return wtCommuteTime;
	}
	public void setWtCommuteTime(Timestamp wtCommuteTime) {
		this.wtCommuteTime = wtCommuteTime;
	}
	public Timestamp getWtOffWorkTime() {
		return wtOffWorkTime;
	}
	public void setWtOffWorkTime(Timestamp wtOffWorkTime) {
		this.wtOffWorkTime = wtOffWorkTime;
	}
	public int getWtResult() {
		return wtResult;
	}
	public void setWtResult(int wtResult) {
		this.wtResult = wtResult;
	}
	public String getWtColor() {
		return wtColor;
	}
	public void setWtColor(String wtColor) {
		this.wtColor = wtColor;
	}
	public Timestamp getWtEx() {
		return wtEx;
	}
	public void setWtEx(Timestamp wtEx) {
		this.wtEx = wtEx;
	}
	
	
	
}
