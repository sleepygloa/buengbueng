package manage.boss.bean;

import java.sql.Timestamp;

public class RentProductDataDTO {

	private int code;
	private String b_key;
	private String rentProduct;
	private int rentCheck;
	private Timestamp beginRegist;
	
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
	public String getRentProduct() {
		return rentProduct;
	}
	public void setRentProduct(String rentProduct) {
		this.rentProduct = rentProduct;
	}
	public int getRentCheck() {
		return rentCheck;
	}
	public void setRentCheck(int rentCheck) {
		this.rentCheck = rentCheck;
	}
	public Timestamp getBeginRegist() {
		return beginRegist;
	}
	public void setBeginRegist(Timestamp beginRegist) {
		this.beginRegist = beginRegist;
	}
	
}
