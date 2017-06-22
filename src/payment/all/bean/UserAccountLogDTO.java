package payment.all.bean;

import java.sql.Timestamp;

public class UserAccountLogDTO {
	
	//accountLog 테이블 : 돈 거래로그
	private int num;	//로그 테이블 순번
	private String giveId;	//주는사람
	private String getId;	//받는사람
	private int money;	//거래금액
	private int method;	//거래방법(예: 무통장, 카드, 계좌이체)
	private int reason;	//충전, 메뉴결제, 피시방이용, 월급 등등
	private Timestamp signdate; //거래시각
	
	//userAccount 테이블 : 돈 계좌
	private String id; //회원아이디
	//money 는 accountlog과 동일
	
	public int getNum() {
		return num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getGiveId() {
		return giveId;
	}
	public void setGiveId(String giveId) {
		this.giveId = giveId;
	}
	public String getGetId() {
		return getId;
	}
	public void setGetId(String getId) {
		this.getId = getId;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getMethod() {
		return method;
	}
	public void setMethod(int method) {
		this.method = method;
	}
	public int getReason() {
		return reason;
	}
	public void setReason(int reason) {
		this.reason = reason;
	}
	public Timestamp getSigndate() {
		return signdate;
	}
	public void setSigndate(Timestamp signdate) {
		this.signdate = signdate;
	}
	
	
	
}
