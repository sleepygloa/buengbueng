package menu.all.bean;

import java.sql.Date;

public class SellBuyLogDTO {
	private String name;
	private String code;
	private String customer;
	private Date productregistdate;
	private Date productsaleregistdate;
	private int price;
	private String l_key;
	
	public String getCostomer() {
		return customer;
	}
	public void setCostomer(String costomer) {
		this.customer = costomer;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getL_key() {
		return l_key;
	}
	public void setL_key(String l_key) {
		this.l_key = l_key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getProductregistdate() {
		return productregistdate;
	}
	public void setProductregistdate(Date productregistdate) {
		this.productregistdate = productregistdate;
	}
	public Date getProductsaleregistdate() {
		return productsaleregistdate;
	}
	public void setProductsaleregistdate(Date productsaleregistdate) {
		this.productsaleregistdate = productsaleregistdate;
	}
}
