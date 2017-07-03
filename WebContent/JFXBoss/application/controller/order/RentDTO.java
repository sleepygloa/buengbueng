package application.controller.order;

public class RentDTO {
	private int rentOrderNum;
	private int returnOrderNum;
	
	private static RentDTO instance = new RentDTO();
	private RentDTO(){
		rentOrderNum = 0;
		returnOrderNum = 0;
	}
	public static RentDTO getInstance(){
		return instance;
	}
	public int getRentOrderNum() {
		return rentOrderNum;
	}
	public void setRentOrderNum(int rentOrderNum) {
		this.rentOrderNum = rentOrderNum;
	}
	public int getReturnOrderNum() {
		return returnOrderNum;
	}
	public void setReturnOrderNum(int returnOrderNum) {
		this.returnOrderNum = returnOrderNum;
	}
	
	
	
}
