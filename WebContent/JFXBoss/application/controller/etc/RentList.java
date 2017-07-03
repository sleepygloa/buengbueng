package application.controller.etc;

import javafx.beans.property.SimpleStringProperty;

public class RentList {
	private SimpleStringProperty name;
	private SimpleStringProperty code;
	
	public RentList(String name, String code){
		this.name = new SimpleStringProperty(name);
		this.code = new SimpleStringProperty(code);
	}

	public String getName(){
		return name.get();
	}
	public void setName(String name){
		this.name.set(name);
	}
	public String getCode(){
		return code.get();
	}
	public void setCode(String code){
		this.code.set(code);
	}
}
