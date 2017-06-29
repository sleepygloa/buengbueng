package application.controller.etc;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class RentOrderList {
	private SimpleStringProperty id;
	private SimpleStringProperty orderName;
	private SimpleStringProperty orderState;
	private SimpleObjectProperty<Button> orderBtn;
	
	public RentOrderList(String id, String orderName, String orderState, Button orderBtn){
		this.id = new SimpleStringProperty(id);
		this.orderName = new SimpleStringProperty(orderName);
		this.orderState = new SimpleStringProperty(orderState);
		this.orderBtn = new SimpleObjectProperty<Button>(orderBtn);
	}

	public RentOrderList() {
		this.id = new SimpleStringProperty();
		this.orderName = new SimpleStringProperty();
		this.orderState = new SimpleStringProperty();
		this.orderBtn = new SimpleObjectProperty<Button>();
	}

	public String getId(){
		return id.get();
	}
	public void setId(String id){
		this.id.set(id);
	}
	public String getOrderName(){
		return orderName.get();
	}
	public void setOrderName(String orderName){
		this.orderName.set(orderName);
	}
	public String getOrderState(){
		return orderState.get();
	}
	public void setOrderState(String orderState){
		this.orderState.set(orderState);
	}
	public Button getOrderBtn(){
		return orderBtn.get();
	}
	public void setOrderBtn(Button orderBtn){
		this.orderBtn.set(orderBtn);
	}
}
