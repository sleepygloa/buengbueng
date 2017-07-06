package application.controller.order;

import java.net.URLEncoder;

import org.json.simple.JSONObject;

import all.info.dto.UserInfo;
import application.ConnectServer;
import application.controller.etc.RentOrderList;
import application.controller.module.BossPcManageController;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class RentOK extends AnchorPane{
	public RentOK getRentPane(String userId, String rentName, String pcNum, RentOrderList sui, Button btn, TableView<RentOrderList> rentTable){
		RentOK r = new RentOK();
		VBox vbox = new VBox();
		HBox hbox = new HBox();
		
		Label alert = new Label();
		alert.setTextFill(Color.RED);
		
		Label id = new Label("대여자 : "+userId);
		Label name = new Label("대여 물품 : "+rentName);
		hbox.getChildren().addAll(id,name);
		
		HBox hbox2 = new HBox();
		Label code = new Label("바코드");
		TextField codeTxt = new TextField();
		hbox2.getChildren().addAll(code,codeTxt);
		
		hbox.setSpacing(20);
		hbox2.setSpacing(20);
		vbox.setSpacing(20);
		
		HBox btnBox = new HBox();
		btnBox.setSpacing(20);
		Button rent = new Button("승인");
		rent.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				try {
					String param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8")+"&id="+URLEncoder.encode(userId,"UTF-8")+
							"&name="+URLEncoder.encode(rentName,"UTF-8")+"&code="+codeTxt.getText()+"&what="+URLEncoder.encode("rent","UTF-8");
					String urlInfo ="http://localhost:8080/buengbueng/fxUserRentReturnOk.do";
					JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
					if(jsonObj.get("result").equals("succ")){
						sui.setOrderState("대여 중");
						btn.setText("반납");
						btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
							@Override
							public void handle(MouseEvent event) {
								try{
									String param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8")+"&id="+URLEncoder.encode(userId,"UTF-8")+
											"&code="+codeTxt.getText()+"&what="+URLEncoder.encode("return","UTF-8");
									String urlInfo = "http://localhost:8080/buengbueng/fxUserRentReturnOk.do";
									ConnectServer.connect(param, urlInfo);
									int selectedIndex = rentTable.getFocusModel().getFocusedIndex();
								    if (selectedIndex >= 0) {
								    	rentTable.getItems().remove(selectedIndex);
								    	RentDTO.getInstance().setReturnOrderNum(RentDTO.getInstance().getReturnOrderNum()-1);
								    	BossPcManageController.getRentCount().setText(String.valueOf(RentDTO.getInstance().getReturnOrderNum()));
										RentDTO.getInstance().setRentOrderNum(RentDTO.getInstance().getRentOrderNum()-1);
										RentDTO.getInstance().setReturnOrderNum(RentDTO.getInstance().getReturnOrderNum()+1);
										BossPcManageController.getOrderCount().setText(String.valueOf(RentDTO.getInstance().getRentOrderNum()));
										BossPcManageController.getRentCount().setText(String.valueOf(RentDTO.getInstance().getReturnOrderNum()));
								    }
								}catch(Exception e){
									e.printStackTrace();
								}
							}
						});
						BossPcManageController.getStage().close();
					}else {
						alert.setText((String)jsonObj.get("result"));
					}
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Button cancel = new Button("대여 취소");
		cancel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				try {
					String param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8")+"&id="+URLEncoder.encode(userId,"UTF-8")+
							"&name="+URLEncoder.encode(rentName,"UTF-8")+"&what="+URLEncoder.encode("cancel","UTF-8");
					String urlInfo ="http://localhost:8080/buengbueng/fxGetUserRentCancel.do";
					JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
					if(jsonObj.get("result").equals("succ")){
						int selectedIndex = rentTable.getFocusModel().getFocusedIndex();
					    if (selectedIndex >= 0) {
					    	rentTable.getItems().remove(selectedIndex);
						    RentDTO.getInstance().setRentOrderNum(RentDTO.getInstance().getRentOrderNum()-1);
							BossPcManageController.getOrderCount().setText(String.valueOf(RentDTO.getInstance().getRentOrderNum()));
					    }
						BossPcManageController.getStage().close();
					}else {
						alert.setText((String)jsonObj.get("result"));
					}
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnBox.getChildren().addAll(rent,cancel);
		
		vbox.getChildren().addAll(alert,hbox,hbox2,btnBox);
		r.getChildren().add(vbox);
		return r;
	}
}
