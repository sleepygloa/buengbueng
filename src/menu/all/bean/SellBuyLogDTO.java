package menu.all.bean;

import java.sql.Date;

public class SellBuyLogDTO {
	private String name;
	private int code;
	private Date productregistdate;
	private Date productsaleregistdate;
	
	
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
