package application.controller.module;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import all.info.dto.UserInfo;
import application.ConnectServer;
import application.controller.login.BossMainController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class BossOptionController {
	@FXML private AnchorPane moduleCheckView;
	@FXML private AnchorPane moduleSetView;
	private JSONObject jsonObj;
	private String beforeName;
	private String changeName;
	private int changeNameNum;
	private ObservableList<String> selected;
	private ObservableList<String> candidates;
	@FXML
	public void initialize(){
		try {
			String param = "b_id="+URLEncoder.encode(UserInfo.getInstance().getId(),"UTF-8")+
					"&grade="+UserInfo.getInstance().getGrade();
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
						String	param = "b_id="+URLEncoder.encode(UserInfo.getInstance().getId(),"UTF-8")+"&m_name="+URLEncoder.encode(beforeName,"UTF-8")+
								"&change="+URLEncoder.encode(changeName,"UTF-8")+"&grade="+UserInfo.getInstance().getGrade();
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
							for(int i=0; i<selected.size(); i++){
								sbMenu.append("\""+selected.get(i)+"\"");
								sbModule.append("1");
								sbMenu.append(",");
								sbModule.append(",");
							}
							for(int i=0; i<candidates.size(); i++){
								sbMenu.append("\""+candidates.get(i)+"\"");
								sbModule.append("0");
								sbMenu.append(",");
								sbModule.append(",");
							}
							sbMenu.append("\"option\"");
							sbModule.append("1");
							String	param = "b_id="+URLEncoder.encode(UserInfo.getInstance().getId(),"UTF-8")+"&m_name="+URLEncoder.encode(changeName,"UTF-8")+
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
							String	param = "b_id="+URLEncoder.encode(UserInfo.getInstance().getId(),"UTF-8")+"&m_name="+URLEncoder.encode(changeName,"UTF-8");
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
							String param = "b_id="+URLEncoder.encode(UserInfo.getInstance().getId(),"UTF-8")+"&m_name="+URLEncoder.encode(name,"UTF-8")+
									"&grade="+UserInfo.getInstance().getGrade();
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
			GridPane gridPane = new GridPane();
			gridPane.setPadding(new Insets(5));
			gridPane.setHgap(10);
			gridPane.setVgap(10);
			
			ColumnConstraints column1 = new ColumnConstraints(150, 150, Double.MAX_VALUE);
		    ColumnConstraints column2 = new ColumnConstraints(50);
		    ColumnConstraints column3 = new ColumnConstraints(150, 150, Double.MAX_VALUE);
		    column1.setHgrow(Priority.ALWAYS);
		    column3.setHgrow(Priority.ALWAYS);
		    gridPane.getColumnConstraints().addAll(column1, column2, column3);

		    Label candidatesLbl = new Label("사용 안 함");
		    candidatesLbl.setTextFill(Color.WHITE);
		    GridPane.setHalignment(candidatesLbl, HPos.CENTER);
		    gridPane.add(candidatesLbl, 0, 0);

		    Label selectedLbl = new Label("사용");
		    selectedLbl.setTextFill(Color.WHITE);
		    gridPane.add(selectedLbl, 2, 0);
		    GridPane.setHalignment(selectedLbl, HPos.CENTER);
	
		    // Candidates
		    candidates = FXCollections.observableArrayList();
		    selected = FXCollections.observableArrayList();
		    while(iteratorModule.hasNext() && iteratorMenu.hasNext()){
		    	if(iteratorModule.next() == 0){
		    		candidates.add(iteratorMenu.next());
		    	}else{
		    		selected.add(iteratorMenu.next());
		    	}
		    }
		    
		    final ListView<String> candidatesListView = new ListView<>(candidates);
		    gridPane.add(candidatesListView, 0, 1);

		    final ListView<String> heroListView = new ListView<>(selected);
		    gridPane.add(heroListView, 2, 1);

		    Button sendRightButton = new Button(" > ");
		    sendRightButton.setOnAction((ActionEvent event) -> {
		      String potential = candidatesListView.getSelectionModel()
		          .getSelectedItem();
		      if (potential != null) {
		        candidatesListView.getSelectionModel().clearSelection();
		        candidates.remove(potential);
		        selected.add(potential);
		      }
		    });

		    Button sendLeftButton = new Button(" < ");
		    sendLeftButton.setOnAction((ActionEvent event) -> {
		      String s = heroListView.getSelectionModel().getSelectedItem();
		      if (s != null) {
		        heroListView.getSelectionModel().clearSelection();
		        selected.remove(s);
		        candidates.add(s);
		      }
		    });
		    VBox vbox = new VBox(5);
		    vbox.getChildren().addAll(sendRightButton, sendLeftButton);

		    gridPane.add(vbox, 1, 1);
			    
			moduleCheckView.getChildren().add(gridPane);
	}
	
	public void save(){
		
	}

}
