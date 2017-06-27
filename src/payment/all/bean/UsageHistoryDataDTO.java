package payment.all.bean;

import java.sql.Timestamp;

public class UsageHistoryDataDTO {
	private int idx;
	private String userId;
	private String userName;
	private String affiliateCode;
	private Timestamp usageTime;
	private Timestamp endTime;
	private int amountUsed;
	private String etc;
	private String businessName;
	private String bossId;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAffiliateCode() {
		return affiliateCode;
	}
	public void setAffiliateCode(String affiliateCode) {
		this.affiliateCode = affiliateCode;
	}
	public Timestamp getUsageTime() {
		return usageTime;
	}
	public void setUsageTime(Timestamp usageTime) {
		this.usageTime = usageTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public int getAmountUsed() {
		return amountUsed;
	}
	public void setAmountUsed(int amountUsed) {
		this.amountUsed = amountUsed;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getBossId() {
		return bossId;
	}
	public void setBossId(String bossId) {
		this.bossId = bossId;
	}
}
