package menu.all.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class OrderDTO {

	private int num;
	private String id;
	private String menuname;
	private Timestamp ordertime;
	private int orderstatus;
	private int ordermoney;
	private String l_key;
	

	public String getL_key() {
		return l_key;
	}
	public void setL_key(String l_key) {
		this.l_key = l_key;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public Timestamp getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Timestamp ordertime) {
		this.ordertime = ordertime;
	}
	public int getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(int orderstatus) {
		this.orderstatus = orderstatus;
	}
	public int getOrdermoney() {
		return ordermoney;
	}
	public void setOrdermoney(int ordermoney) {
		this.ordermoney = ordermoney;
	}
}
