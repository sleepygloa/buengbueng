package application.controller.etc;

import javafx.beans.property.SimpleStringProperty;

public class EmployeeList {

	private SimpleStringProperty e_id;
	
	public String getE_id() {
		return e_id.get();
	}

	public void setE_id(String e_id) {
		this.e_id = new SimpleStringProperty(e_id);
	}
	
}
