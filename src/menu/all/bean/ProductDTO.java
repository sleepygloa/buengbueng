package menu.all.bean;

import java.sql.Timestamp;

public class ProductDTO {
	private int code;
	private String name;
	private Timestamp lastday;
	private boolean salecheck;
	private Timestamp beginregist;
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getLastday() {
		return lastday;
	}
	public void setLastday(Timestamp lastday) {
		this.lastday = lastday;
	}
	public boolean getSalecheck() {
		return salecheck;
	}
	public void setSalecheck(boolean salecheck) {
		this.salecheck = salecheck;
	}
	public Timestamp getBeginregist() {
		return beginregist;
	}
	public void setBeginregist(Timestamp beginregist) {
		this.beginregist = beginregist;
	}
}
