package application.controller.etc;

import javafx.beans.property.SimpleStringProperty;

public class MenuList {
	private SimpleStringProperty mname;
	private SimpleStringProperty mcode;
	private SimpleStringProperty mprice;
	
	MenuList(String mname, String mcode, String mprice){
		this.mname = new SimpleStringProperty(mname);
		this.mcode = new SimpleStringProperty(mcode);
		this.mprice = new SimpleStringProperty(mprice);
	}

	public String getMname(){
		return mname.get();
	}
	public void setMname(String mname){
		this.mname.set(mname);
	}
	public String getMcode(){
		return mcode.get();
	}
	public void setMcode(String mcode){
		this.mcode.set(mcode);
	}
	public String getMprice(){
		return mprice.get();
	}
	public void setMprice(String mprice){
		this.mprice.set(mprice);
	}
}
