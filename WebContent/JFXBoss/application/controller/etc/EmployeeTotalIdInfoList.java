package application.controller.etc;

import javafx.beans.property.SimpleStringProperty;

public class EmployeeTotalIdInfoList {

	private SimpleStringProperty totalId;
	private SimpleStringProperty totalName;
	private SimpleStringProperty totalBirth;
	private SimpleStringProperty totalPhone;
	private SimpleStringProperty totalAddress;
	private SimpleStringProperty totalEmail;
	private SimpleStringProperty totalGoogleId;
	
	
	public String getTotalId() {
		return totalId.get();
	}

	public void setTotalId(String totalId) {
		this.totalId = new SimpleStringProperty(totalId);
	}
	
	public String getTotalName() {
		return totalName.get();
	}

	public void setTotalName(String totalName) {
		this.totalName = new SimpleStringProperty(totalName);
	}
	
	
	public String getTotalBirth() {
		return totalBirth.get();
	}

	public void setTotalBirth(String totalBirth) {
		this.totalBirth = new SimpleStringProperty(totalBirth);
	}
	
	public String getTotalPhone() {
		return totalPhone.get();
	}

	public void setTotalPhone(String totalPhone) {
		this.totalPhone = new SimpleStringProperty(totalPhone);
	}	
			
			
	public String getTotalAddress() {
		return totalAddress.get();
	}

	public void setTotalAddress(String totalAddress) {
		this.totalAddress = new SimpleStringProperty(totalAddress);
	}
	
	
	public String getTotalEmail() {
		return totalEmail.get();
	}

	public void setTotalEmail(String totalEmail) {
		this.totalEmail = new SimpleStringProperty(totalEmail);
	}
	
	
	
	public String getTotalGoogleId() {
		return totalGoogleId.get();
	}

	public void setTotalGoogleId(String totalGoogleId) {
		this.totalGoogleId = new SimpleStringProperty(totalGoogleId);
	}
			
			
			
			
			
}
