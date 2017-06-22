package menu.all.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class ProductDTO {
	private int code;
	private String name;
	private Date lastday;
	private int salecheck;
	private Timestamp beginregist;
	private String key;
	
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
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
	public Date getLastday() {
		return lastday;
	}
	public void setLastday(Date lastday) {
		this.lastday = lastday;
	}
	public int getSalecheck() {
		return salecheck;
	}
	public void setSalecheck(int salecheck) {
		this.salecheck = salecheck;
	}
	public Timestamp getBeginregist() {
		return beginregist;
	}
	public void setBeginregist(Timestamp beginregist) {
		this.beginregist = beginregist;
	}
}
