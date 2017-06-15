package menu.all.bean;

import java.sql.Date;

public class SellBuyLogDTO {
	private String name;
	private int code;
	private Date productregistdate;
	private Date productsaleregistdate;
	private String l_key;
	
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
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
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
