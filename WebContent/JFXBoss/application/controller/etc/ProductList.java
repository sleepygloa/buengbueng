package application.controller.etc;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class ProductList {
	private SimpleStringProperty code;
	private SimpleStringProperty name;
	private SimpleStringProperty saleCheck;
	private SimpleStringProperty beginRegist;
	private SimpleStringProperty lastDay;
	private SimpleObjectProperty<Button> modi;
	private SimpleObjectProperty<Button> del;

	public ProductList() {
		this.code = new SimpleStringProperty();
		this.name = new SimpleStringProperty();
		this.saleCheck = new SimpleStringProperty();
		this.beginRegist = new SimpleStringProperty();
		this.lastDay = new SimpleStringProperty();
		this.modi = new SimpleObjectProperty<Button>();
		this.del = new SimpleObjectProperty<Button>();
	}

	public String getCode(){
		return code.get();
	}
	public void setCode(String code){
		this.code.set(code);
	}
	public String getName(){
		return name.get();
	}
	public void setName(String name){
		this.name.set(name);
	}
	public String getSaleCheck(){
		return saleCheck.get();
	}
	public void setSaleCheck(String saleCheck){
		this.saleCheck.set(saleCheck);
	}
	public String getBeginRegist(){
		return beginRegist.get();
	}
	public void setBeginRegist(String beginRegist){
		this.beginRegist.set(beginRegist);
	}
	public String getLastDay(){
		return lastDay.get();
	}
	public void setLastDay(String lastDay){
		this.lastDay.set(lastDay);
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
