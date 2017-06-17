package application.controller.module;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import application.ConnectServer;
import application.controller.login.BossMainController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import user.info.dto.UserInfo;

public class BossOptionController {
	@FXML private AnchorPane moduleCheckView;
	@FXML private AnchorPane moduleSetView;
	private ArrayList<CheckBox> chk = new ArrayList<CheckBox>();
	private ArrayList<Label> lb = new ArrayList<Label>();
	private JSONObject jsonObj;
	private String beforeName;
	private String changeName;
	private int changeNameNum;
	@FXML
	public void initialize(){
		try {
			String param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8");
			getModule(param);
			JSONArray jsonName = (JSONArray)jsonObj.get("name");
			beforeName = jsonName.get(0).toString();
			Iterator<String> iteratorName = jsonName.iterator();
			VBox setVBox = new VBox();
			setVBox.setSpacing(10);
			Label alert = new Label();
			alert.setTextFill(Color.web("red"));
			HBox setHBox = new HBox();
			Button change = new Button("적용");
			ComboBox<String> option = new ComboBox<>();
			change.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					try{
						String	param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8")+"&m_name="+URLEncoder.encode(beforeName,"UTF-8")+
								"&change="+URLEncoder.encode(changeName,"UTF-8");
						String urlInfo = "http://localhost:8080/buengbueng/fxGetModule.do";
						BossMainController.getMenu().getChildren().add(BossMainController.setBossMenu(param,urlInfo));
					}catch(Exception e){
						
					}
				}
			});
			Button modify = new Button("수정");
			modify.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					try{
						if(!changeName.equals("기본")){
							StringBuffer sbModule = new StringBuffer();
							StringBuffer sbMenu = new StringBuffer();
							for(int i=0; i<chk.size(); i++){
								sbMenu.append("\""+lb.get(i).getText()+"\"");
								if(chk.get(i).isSelected()){
									sbModule.append("1");
								}else{
									sbModule.append("0");
								}				
								if(i != chk.size()-1){
									sbMenu.append(",");
									sbModule.append(",");
								}
							}
							String	param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8")+"&m_name="+URLEncoder.encode(changeName,"UTF-8")+
									"&module="+URLEncoder.encode(sbModule.toString(),"UTF-8")+
									"&menu="+URLEncoder.encode(sbMenu.toString(),"UTF-8");
							String urlInfo = "http://localhost:8080/buengbueng/fxModiModulePro.do";
							BossMainController.getMenu().getChildren().add(BossMainController.setBossMenu(param,urlInfo));
						}else{
							alert.setText("기본 모듈은 수정할 수 없습니다.");
						}
					}catch(Exception e){
						
					}
				}
			});
			Button remove = new Button("삭제");
			remove.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					try{
						if(!changeName.equals(beforeName) || changeName.equals("기본")){
							alert.setText("");
							String	param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8")+"&m_name="+URLEncoder.encode(changeName,"UTF-8");
							String urlInfo = "http://localhost:8080/buengbueng/fxRemoveModule.do";
							ConnectServer.connect(param, urlInfo);
							option.getItems().remove(changeNameNum);
						}else{
							alert.setText("기본 모듈 또는 현재 사용 중인 모듈은 삭제할 수 없습니다.");
						}
					}catch(Exception e){
						
					}
				}
			});
			Button newModule = new Button("새 모듈 만들기");
			newModule.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					try {
						String url = "/application/controller/module/newModuleApp.fxml";
						Node node = (Node)FXMLLoader.load(getClass().getResource(url));
						BossMainController.getView().getChildren().setAll(node);
					} catch (IOException e) {
						
					}
				}
			});
			modify.setTranslateX(20);
			remove.setTranslateX(40);
			newModule.setTranslateX(60);
			setHBox.getChildren().addAll(option,change,modify,remove,newModule);
			setVBox.getChildren().addAll(setHBox,alert);
			while(iteratorName.hasNext()){
				option.getItems().add(iteratorName.next());
				option.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
					// 두 번 입력됨 -> 수정해야함
					@Override
					public void changed(ObservableValue<? extends Number> observable, Number oldValue,
							Number newValue) {
						try {
							moduleCheckView.getChildren().clear();
							changeNameNum = newValue.intValue();
							String name = option.getItems().get(changeNameNum);
							String param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8")+"&m_name="+URLEncoder.encode(name,"UTF-8");
							getModule(param);
							showModuleChecked();
							changeName = name; 
						} catch (Exception e) {
						}
					}
				});
			}
			moduleSetView.getChildren().add(setVBox);
			showModuleChecked();
		} catch(Exception e) {
		}
	}
	
	private void getModule(String param){
		try{
			String urlInfo = "http://localhost:8080/buengbueng/fxGetModule.do";
			jsonObj = ConnectServer.connect(param, urlInfo);
		}catch(Exception e){
		}
	}
		
	private void showModuleChecked(){
			JSONArray jsonModule = (JSONArray)jsonObj.get("module");
			JSONArray jsonMenu = (JSONArray)jsonObj.get("menu");
			
			Iterator<Long> iteratorModule = jsonModule.iterator();
			Iterator<String> iteratorMenu = jsonMenu.iterator();
			int i = 0;
			int j = 0;
			GridPane gridPane = new GridPane();
			chk.clear();
			lb.clear();
			while(iteratorModule.hasNext() && iteratorMenu.hasNext()){
				HBox hbox = new HBox();
		        gridPane.setHgap(20);
		        gridPane.setVgap(20);
				Long chkModule = iteratorModule.next();
				CheckBox chkBox = new CheckBox();
				chk.add(chkBox);
				Label label = new Label();
				lb.add(label);
				if(chkModule == 0){
					chkBox.setSelected(false);
					label.setText(iteratorMenu.next());
					hbox.getChildren().addAll(chkBox,label);
				}else{
					chkBox.setSelected(true);
					label.setText(iteratorMenu.next());
					hbox.getChildren().addAll(chkBox,label);
				}
				gridPane.add(hbox, i, j);
				i++;
				if(i%3 == 0 || !iteratorModule.hasNext()){
					i = 0;
					j++;
				}
			}
			moduleCheckView.getChildren().add(gridPane);
	}
	
	public void save(){
		
	}

}
