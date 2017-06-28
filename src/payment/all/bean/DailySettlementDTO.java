package payment.all.bean;

import java.sql.Timestamp;

public class DailySettlementDTO {
	private int idx;
	private Timestamp settlementDate;
	private String bossId;
	private String companyName;
	private String settlementMethod;
	private int settlementNumber;
	private String requestedAccount;
	private String settlementAmount;
	private String settlementStatus;
	private int resultValue;
	private String b_key;
	
	
	
	public String getB_key() {
		return b_key;
	}
	public void setB_key(String b_key) {
		this.b_key = b_key;
	}
	public int getResultValue() {
		return resultValue;
	}
	public void setResultValue(int resultValue) {
		this.resultValue = resultValue;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public Timestamp getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(Timestamp settlementDate) {
		this.settlementDate = settlementDate;
	}
	public String getBossId() {
		return bossId;
	}
	public void setBossId(String bossId) {
		this.bossId = bossId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getSettlementMethod() {
		return settlementMethod;
	}
	public void setSettlementMethod(String settlementMethod) {
		this.settlementMethod = settlementMethod;
	}
	public int getSettlementNumber() {
		return settlementNumber;
	}
	public void setSettlementNumber(int settlementNumber) {
		this.settlementNumber = settlementNumber;
	}
	public String getRequestedAccount() {
		return requestedAccount;
	}
	public void setRequestedAccount(String requestedAccount) {
		this.requestedAccount = requestedAccount;
	}
	public String getSettlementAmount() {
		return settlementAmount;
	}
	public void setSettlementAmount(String settlementAmount) {
		this.settlementAmount = settlementAmount;
	}
	public String getSettlementStatus() {
		return settlementStatus;
	}
	public void setSettlementStatus(String settlementStatus) {
		this.settlementStatus = settlementStatus;
	}
}
