package menu.all.bean;

import java.util.Date;

public class TotalMenuPriceDTO {

	private String menuname;
	private int menuprice;
	private int menucount;
	private Date saledate;
	private int totalprice;
	private String l_key;
	
	
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public int getMenuprice() {
		return menuprice;
	}
	public void setMenuprice(int menuprice) {
		this.menuprice = menuprice;
	}
	public int getMenucount() {
		return menucount;
	}
	public void setMenucount(int menucount) {
		this.menucount = menucount;
	}
	public Date getSaledate() {
		return saledate;
	}
	public void setSaledate(Date saledate) {
		this.saledate = saledate;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public String getL_key() {
		return l_key;
	}
	public void setL_key(String l_key) {
		this.l_key = l_key;
	}
}
