package application.controller.etc;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class MenuProductList {
	private SimpleStringProperty category;
	private SimpleStringProperty name;
	private SimpleStringProperty company;
	private SimpleStringProperty price;
	private SimpleObjectProperty<Button> modi;
	private SimpleObjectProperty<Button> del;

	public MenuProductList() {
		this.category = new SimpleStringProperty();
		this.name = new SimpleStringProperty();
		this.company = new SimpleStringProperty();
		this.price = new SimpleStringProperty();
		this.modi = new SimpleObjectProperty<Button>();
		this.del = new SimpleObjectProperty<Button>();
	}

	public String getCategory(){
		return category.get();
	}
	public void setCategory(String category){
		this.category.set(category);
	}
	public String getName(){
		return name.get();
	}
	public void setName(String name){
		this.name.set(name);
	}
	public String getCompany(){
		return company.get();
	}
	public void setCompany(String company){
		this.company.set(company);
	}
	public String getPrice(){
		return price.get();
	}
	public void setPrice(String price){
		this.price.set(price);
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
