package manage.boss.bean;

import java.sql.Timestamp;

public class RentLogDataDTO {

	private int code;
	private String b_key;
	private String name;
	private String id;
	private int pcNum;
	private Timestamp rentdate;
	private Timestamp returndate;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getB_key() {
		return b_key;
	}
	public void setB_key(String b_key) {
		this.b_key = b_key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public int getPcNum() {
		return pcNum;
	}
	public void setPcNum(int pcNum) {
		this.pcNum = pcNum;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getRentdate() {
		return rentdate;
	}
	public void setRentdate(Timestamp rentdate) {
		this.rentdate = rentdate;
	}
	public Timestamp getReturndate() {
		return returndate;
	}
	public void setReturndate(Timestamp returndate) {
		this.returndate = returndate;
	}
	
}
