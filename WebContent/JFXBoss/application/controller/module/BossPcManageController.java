package application.controller.module;

import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import all.info.dto.UserInfo;
import application.ConnectServer;
import application.controller.etc.RentOrderList;
import application.controller.order.PCCheckDTO;
import application.controller.order.RentDTO;
import application.controller.order.RentOK;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BossPcManageController {
	@FXML private AnchorPane pcAlertView;
	@FXML private AnchorPane pcUseView;
	@FXML private AnchorPane pcRentView;
	@FXML private TableView<RentOrderList> rentTable;
	@FXML private TableColumn<RentOrderList,String> id;
	@FXML private TableColumn<RentOrderList,String> orderName;
	@FXML private TableColumn<RentOrderList,String> orderState;
	@FXML private TableColumn<RentOrderList,Button> orderBtn;
	@FXML private AnchorPane pcCountView;
	@FXML private Text pcCheck;
	@FXML private Text orderCount;
	@FXML private Text rentCount;
	@FXML private Label franchiseeName;
	private static TableView<RentOrderList> pcRentTable;
	private static Text pcOrderCount;
	private static Text pcRentCount;
	private static Text pcCount;
	private static ArrayList<AnchorPane> pcList = new ArrayList<AnchorPane>();
	private static ObservableList<RentOrderList> data =FXCollections.observableArrayList();
	private static Stage rentStage;
	@FXML
	public void initialize(){
		try{
			rentTable.getItems().clear();
			data.clear();
			pcList.clear();
			RentDTO.getInstance().setRentOrderNum(0);
			RentDTO.getInstance().setReturnOrderNum(0);
			PCCheckDTO.getInstance().setCurrentCount(0);
			PCCheckDTO.getInstance().setPcAllCount(0);
			pcRentTable = rentTable;
			pcOrderCount = orderCount;
			pcRentCount = rentCount;
			pcCount = pcCheck;
			GridPane gridPane = new GridPane();
			String param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8");
			String urlInfo = "http://localhost:8080/buengbueng/fxGetPcUseState.do";
			JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
			JSONArray jsonPc = (JSONArray)jsonObj.get("seatCon");
			JSONArray jsonUserId = (JSONArray)jsonObj.get("useSeatId");
			JSONArray jsonSeatNum = (JSONArray)jsonObj.get("useSeatNum");
			JSONArray jsonSeatState = (JSONArray)jsonObj.get("state");
			
			// 가맹점 이름
			franchiseeName.setText((String)jsonObj.get("franchiseeName"));
			
			// 좌석 현황
			Iterator<Long> iteratorPc = jsonPc.iterator();
			Iterator<String> iteratorState = jsonSeatState.iterator();
			int i = 0;
			int j = 0;
			int k = 1;
			int l = 0;
			for(int c = 1; c <= Integer.parseInt((String)jsonObj.get("count")); c++){
				Long chkUse = iteratorPc.next();
				Label label = new Label(String.valueOf(k));
				label.getStyleClass().add("pcNum");
				AnchorPane pcUseCheck = new AnchorPane();
				pcUseCheck.setId(String.valueOf(k));
				pcUseCheck.setMaxWidth(128); pcUseCheck.setMinWidth(128);
				pcUseCheck.setMaxHeight(128); pcUseCheck.setMinHeight(128);
				pcUseCheck.getChildren().add(label);
				String stateChk = iteratorState.next();
				if(stateChk.equals("고장")){
					Label state = new Label("고장");
					state.setTextFill(Color.RED);
					Font font = Font.loadFont(getClass().getResourceAsStream("/application/css/font.ttf"), 20);
					state.setFont(font);
					state.setTranslateX(45); state.setTranslateY(10);
					pcUseCheck.getChildren().add(state);
				}
				if(chkUse == 0){
					pcUseCheck.getStyleClass().add("notUse");
				}else{
					l++;
					for(int sc = 0; sc < jsonSeatNum.size(); sc++){
						int num = Integer.parseInt((String)jsonSeatNum.get(sc));
						if(num == c){
							Label userId = new Label((String)jsonUserId.get(PCCheckDTO.getInstance().getCurrentCount()));
							userId.setTextFill(Color.WHITE);
							userId.setTranslateX(30); userId.setTranslateY(10);
							pcUseCheck.getChildren().add(userId);
							pcUseCheck.setOnMouseClicked(new EventHandler<MouseEvent>() {
								@Override
								public void handle(MouseEvent event) {
									try{
										UserInfoController.setNum(label.getText());
										UserInfoController.setUid(userId.getText());
										Parent main =  FXMLLoader.load(getClass().getResource("/application/controller/module/userInfo.fxml"));
										Scene scene = new Scene(main);
										Stage userInfoStage = new Stage();
										userInfoStage.setScene(scene);
										userInfoStage.show();
									}catch(Exception e){
										e.printStackTrace();
									}
								}
							});
						}
					}
					pcUseCheck.getStyleClass().add("use");
					PCCheckDTO.getInstance().setCurrentCount(PCCheckDTO.getInstance().getCurrentCount()+1);
				}
				pcList.add(pcUseCheck);
				gridPane.add(pcUseCheck, i, j);
				i++;
				k++;
				if(i%10 == 0){
					i = 0;
					j++;
				}
			}
			PCCheckDTO.getInstance().setPcAllCount(Integer.parseInt((String)jsonObj.get("count")));
			String check = PCCheckDTO.getInstance().getCurrentCount()+"/"+PCCheckDTO.getInstance().getPcAllCount();
			pcCheck.setText(check);
			pcUseView.getChildren().add(gridPane);
			
			// 대여
			param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8");
			urlInfo = "http://localhost:8080/buengbueng/fxGetUserRentOrder.do";
			jsonObj = ConnectServer.connect(param, urlInfo);
			
			id.setCellValueFactory(new PropertyValueFactory<RentOrderList,String>("id"));
			orderName.setCellValueFactory(new PropertyValueFactory<RentOrderList,String>("orderName"));
			orderState.setCellValueFactory(new PropertyValueFactory<RentOrderList,String>("orderState"));
			orderBtn.setCellValueFactory(new PropertyValueFactory<RentOrderList,Button>("orderBtn"));
			
			JSONArray jsonRentName = (JSONArray)jsonObj.get("name");
			JSONArray jsonRentId = (JSONArray)jsonObj.get("id");
			JSONArray jsonRentPcNum = (JSONArray)jsonObj.get("pcNum");
			JSONArray jsonRentCode = (JSONArray)jsonObj.get("code");
			
			Iterator<String> iteratorRName = jsonRentName.iterator();
			Iterator<String> iteratorRId = jsonRentId.iterator();
			Iterator<Long> iteratorRNum = jsonRentPcNum.iterator();
			Iterator<Long> iteratorRCode = jsonRentCode.iterator();
			
			while(iteratorRName.hasNext() && iteratorRId.hasNext() && iteratorRNum.hasNext() && iteratorRCode.hasNext()){
				String userId = iteratorRId.next();
				Long pcNum = iteratorRNum.next();
				Long code = iteratorRCode.next();
				RentOrderList sui = new RentOrderList();
				String state = "승인 대기";
				String id = "[No."+pcNum+"] "+userId;
				String rentName = iteratorRName.next();
				
				sui.setId(id);
				sui.setOrderName(rentName);
				
				Button btn = new Button();
				if(code == 0){
					RentDTO.getInstance().setRentOrderNum(RentDTO.getInstance().getRentOrderNum()+1);
					btn.setText("확인");
					btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							RentOK rent = new RentOK();
							Scene scene = new Scene(rent.getRentPane(userId,rentName,String.valueOf(pcNum), sui, btn, pcRentTable));
							if(rentStage == null){
								rentStage = new Stage();
							}
							rentStage.setScene(scene);
							rentStage.show();
						}
					});
				}else{
					RentDTO.getInstance().setReturnOrderNum(RentDTO.getInstance().getReturnOrderNum()+1);
					state = "대여 중";
					btn.setText("반납");
					btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							try{
								String param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8")+"&id="+URLEncoder.encode(userId,"UTF-8")+
										"&code="+code+"&what="+URLEncoder.encode("return","UTF-8");
								String urlInfo = "http://localhost:8080/buengbueng/fxUserRentReturnOk.do";
								ConnectServer.connect(param, urlInfo);
								int selectedIndex = rentTable.getSelectionModel().getSelectedIndex();
							    if (selectedIndex >= 0) {
							    	rentTable.getItems().remove(selectedIndex);
							    	RentDTO.getInstance().setReturnOrderNum(RentDTO.getInstance().getReturnOrderNum()-1);
								    rentCount.setText(String.valueOf(RentDTO.getInstance().getReturnOrderNum()));
							    }
							}catch(Exception e){
								e.printStackTrace();
							}
						}
					});
				}
				sui.setOrderState(state);
				sui.setOrderBtn(btn);
				data.add(sui);
			}
			orderCount.setText(String.valueOf(RentDTO.getInstance().getRentOrderNum()));
			rentCount.setText(String.valueOf(RentDTO.getInstance().getReturnOrderNum()));
			rentTable.setItems(data);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static void bell(){
		String musicFile = "bell.wav";
		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
	}
	
	public static Stage getStage(){
		return rentStage;
	}

	public static Text getOrderCount(){
		return pcOrderCount;
	}
	
	public static Text getRentCount(){
		return pcRentCount;
	}
	
	public static void userLogin(String[] txt){	
		pcList.get(Integer.parseInt(txt[1])-1).getStyleClass().add("use");
		Label userId = new Label(txt[2]);
		userId.setTranslateX(30); userId.setTranslateY(10);
		pcList.get(Integer.parseInt(txt[1])-1).getChildren().add(userId);
		PCCheckDTO.getInstance().setCurrentCount(PCCheckDTO.getInstance().getCurrentCount()+1);
		String check = PCCheckDTO.getInstance().getCurrentCount()+"/"+PCCheckDTO.getInstance().getPcAllCount();
		pcCount.setText(check);
	}
	
	public static void userLogout(String[] txt){
		pcList.get(Integer.parseInt(txt[1])-1).getStyleClass().clear();
		pcList.get(Integer.parseInt(txt[1])-1).getStyleClass().add("notUse");
		pcList.get(Integer.parseInt(txt[1])-1).getChildren().remove(1);
		PCCheckDTO.getInstance().setCurrentCount(PCCheckDTO.getInstance().getCurrentCount()-1);
		String check = PCCheckDTO.getInstance().getCurrentCount()+"/"+PCCheckDTO.getInstance().getPcAllCount();
		pcCount.setText(check);
	}
	
	public static void addRentOrder(String txt){
		bell();
		RentDTO.getInstance().setRentOrderNum(RentDTO.getInstance().getRentOrderNum()+1);
		RentOrderList sui = new RentOrderList();
		String[] s = txt.split(",");
		String userId = s[1];
		String pcNum = s[0];
		String state = "승인 대기";
		String id = "[No."+s[0]+"] "+s[1];
		String rentName = s[2];
		
		sui.setId(id);
		sui.setOrderName(rentName);
		
		Button btn = new Button("확인");
		btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				RentOK rent = new RentOK();
				Scene scene = new Scene(rent.getRentPane(userId,rentName,String.valueOf(pcNum), sui, btn, pcRentTable));
				if(rentStage == null){
					rentStage = new Stage();
				}
				rentStage.setScene(scene);
				rentStage.show();
			}
		});
		sui.setOrderState(state);
		sui.setOrderBtn(btn);
		data.add(sui);
		pcOrderCount.setText(String.valueOf(RentDTO.getInstance().getRentOrderNum()));
	}
}
