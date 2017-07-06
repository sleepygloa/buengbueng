package application.controller.etc;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class RentProductList {
	private SimpleStringProperty code;
	private SimpleStringProperty rentCheck;
	private SimpleStringProperty beginRegist;
	private SimpleObjectProperty<Button> modi;
	private SimpleObjectProperty<Button> del;

	public RentProductList() {
		this.code = new SimpleStringProperty();
		this.rentCheck = new SimpleStringProperty();
		this.beginRegist = new SimpleStringProperty();
		this.modi = new SimpleObjectProperty<Button>();
		this.del = new SimpleObjectProperty<Button>();
	}

	public String getCode(){
		return code.get();
	}
	public void setCode(String code){
		this.code.set(code);
	}
	public String getRentCheck(){
		return rentCheck.get();
	}
	public void setRentCheck(String rentCheck){
		this.rentCheck.set(rentCheck);
	}
	public String getBeginRegist(){
		return beginRegist.get();
	}
	public void setBeginRegist(String beginRegist){
		this.beginRegist.set(beginRegist);
	}
	public Button getModi(){
		return modi.get();
	}
	public void setModi(Button modi){
		this.modi.set(modi);
	}
	public Button getDel(){
		return del.get();
	}
	public void setDel(Button del){
		this.del.set(del);
	}
}
