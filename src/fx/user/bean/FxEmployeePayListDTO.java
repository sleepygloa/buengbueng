package fx.user.bean;

import java.sql.Timestamp;

public class FxEmployeePayListDTO {


	private int payNum; //지급번호, 출퇴근 Log 번호
	private String payId; //알바생아이디
	private String payName; //알바생이름
	private int payWorkTime; //일한시간(초)
	private int payPayment; //일한시간에 대한 지급금액
	private Timestamp payCommute; //출근시간
	private Timestamp payOffWork; //퇴근시간
	
	public int getPayNum() {
		return payNum;
	}
	public void setPayNum(int payNum) {
		this.payNum = payNum;
	}
	public String getPayId() {
		return payId;
	}
	public void setPayId(String payId) {
		this.payId = payId;
	}
	public String getPayName() {
		return payName;
	}
	public void setPayName(String payName) {
		this.payName = payName;
	}

	public int getPayWorkTime() {
		return payWorkTime;
	}
	public void setPayWorkTime(int payWorkTime) {
		this.payWorkTime = payWorkTime;
	}
	public int getPayPayment() {
		return payPayment;
	}
	public void setPayPayment(int payPayment) {
		this.payPayment = payPayment;
	}
	public Timestamp getPayCommute() {
		return payCommute;
	}
	public void setPayCommute(Timestamp payCommute) {
		this.payCommute = payCommute;
	}
	public Timestamp getPayOffWork() {
		return payOffWork;
	}
	public void setPayOffWork(Timestamp payOffWork) {
		this.payOffWork = payOffWork;
	}
	
	
}
