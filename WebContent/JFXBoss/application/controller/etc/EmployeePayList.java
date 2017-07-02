package application.controller.etc;

import java.sql.Timestamp;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class EmployeePayList {

	private SimpleLongProperty payNum; //지급번호, 출퇴근 log번호
	private SimpleStringProperty payId; //알바생아이디
	private SimpleStringProperty payName; //알바생이름
	private SimpleLongProperty payWorkTime; //일한시간(초)
	private SimpleLongProperty payPayment; //일한시간에 대한 지급금액
	private Timestamp payCommute; //출근시간
	private Timestamp payOffWork; //퇴근시간
	
	public Long getPayNum() {
		return payNum.get();
	}
	public void setPayNum(Long payNum) {
		this.payNum = new SimpleLongProperty(payNum);
	}
	public String getPayId() {
		return payId.get();
	}
	public void setPayId(String payId) {
		this.payId = new SimpleStringProperty(payId);
	}
	public void setPayName(String payName) {
		this.payName = new SimpleStringProperty(payName);
	}
	public String getPayName() {
		return payName.get();
	}
	public Long getPayWorkTime() {
		return payWorkTime.get();
	}
	public void setPayWorkTime(Long payWorkTime) {
		this.payWorkTime = new SimpleLongProperty(payWorkTime);
	}
	public Long getPayPayment() {
		return payPayment.get();
	}
	public void setPayPayment(Long payPayment) {
		this.payPayment = new SimpleLongProperty(payPayment);
	}
	public Timestamp getPayCommute() {
		return payCommute;
	}
	public void setPayCommute(Long payCommute2) {
		Timestamp payCommute = longToTimestamp(payCommute2);
		this.payCommute = payCommute;
	}
	public Timestamp getPayOffWork() {
		return payOffWork;
	}
	public void setPayOffWork(Long payOffWork2) {
		Timestamp payOffWork = longToTimestamp(payOffWork2);
		this.payOffWork = payOffWork;
	}
	
	
	
	//Long to Timestamp 
	public Timestamp longToTimestamp(Long date){
		Timestamp t = null;
		
		t = new Timestamp(date);
		return t;
	}
	
}
