package application.controller.etc;

import java.sql.Timestamp;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class EmployeeWorkTimeList {

	private SimpleLongProperty wtNum; 
	private Timestamp wtTodayDate;
	private SimpleStringProperty wtTitle;
	private Timestamp wtStart;
	private Timestamp wtEnd;
	private Timestamp wtCommuteTime;
	private Timestamp wtOffWorkTime;
	private SimpleLongProperty wtResult;
	private SimpleStringProperty wtColor;
	private Timestamp wtEx;
	
	public Long getWtNum() {
		return wtNum.get();
	}
	public void setWtNum(Long wtNum) {
		this.wtNum = new SimpleLongProperty(wtNum);
	}
	public Timestamp getWtTodayDate() {
		return wtTodayDate;
	}
	public void setWtTodayDate(Long wtTodayDate2) {
		Timestamp wtTodayDate = longToTimestamp(wtTodayDate2);
		this.wtTodayDate = wtTodayDate;
	}
	public String getWtTitle() {
		return wtTitle.get();
	}
	public void setWtTitle(String wtTitle) {
		this.wtTitle = new SimpleStringProperty(wtTitle);
	}
	public Timestamp getWtStart() {
		return wtStart;
	}
	public void setWtStart(Long wtStart2) {
		Timestamp wtStart = longToTimestamp(wtStart2);
		this.wtStart = wtStart;
	}
	public Timestamp getWtEnd() {
		return wtEnd;
	}
	public void setWtEnd(Long wtEnd2) {
		Timestamp wtEnd = longToTimestamp(wtEnd2);
		this.wtEnd = wtEnd;
	}
	public Timestamp getWtCommuteTime() {
		return wtCommuteTime;
	}
	public void setWtCommuteTime(Long wtCommuteTime2) {
		Timestamp wtCommuteTime = longToTimestamp(wtCommuteTime2);
		this.wtCommuteTime = wtCommuteTime;
	}
	public Timestamp getWtOffWorkTime() {
		return wtOffWorkTime;
	}
	public void setWtOffWorkTime(Long wtOffWorkTime2) {
		Timestamp wtOffWorkTime = longToTimestamp(wtOffWorkTime2);
		this.wtOffWorkTime = wtOffWorkTime;
	}
	public Long getWtResult() {
		return wtResult.get();
	}
	public void setWtResult(Long wtResult) {
		this.wtResult = new SimpleLongProperty(wtResult);
	}
	public String getWtColor() {
		return wtColor.get();
	}
	public void setWtColor(String wtColor) {
		this.wtColor = new SimpleStringProperty(wtColor);
	}
	public Timestamp getWtEx() {
		return wtEx;
	}
	public void setWtEx(Long wtEx2) {
		Timestamp wtEx = longToTimestamp(wtEx2);
		this.wtEx = wtEx;
	}
	
	
	//Long to Timestamp 
	public Timestamp longToTimestamp(Long date){
		Timestamp t = null;
		t = new Timestamp(date);
		return t;
	}
	
}
