package application.controller.module;

import java.net.URLEncoder;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import all.info.dto.UserInfo;
import application.ConnectServer;
import application.controller.login.BossMainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class BossNewModuleController {
	@FXML private AnchorPane moduleCheckView;
	@FXML private AnchorPane moduleSetView;
	@FXML private TextField moduleName;
	@FXML private Button addModule;
	@FXML private Text alert;
	private ObservableList<String> selected;
	private ObservableList<String> candidates;
	@FXML
	public void initialize(){
		try{
			String param = "b_id="+URLEncoder.encode(UserInfo.getInstance().getId(),"UTF-8");
			String urlInfo = "http://localhost:8080/buengbueng/fxSetModule.do";
			JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
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
		    GridPane.setHalignment(candidatesLbl, HPos.CENTER);
		    gridPane.add(candidatesLbl, 0, 0);

		    Label selectedLbl = new Label("사용");
		    gridPane.add(selectedLbl, 2, 0);
		    GridPane.setHalignment(selectedLbl, HPos.CENTER);
	
		    // Candidates
		    candidates = FXCollections.observableArrayList();
			JSONArray jsonMenu = (JSONArray)jsonObj.get("moduleName");
			Iterator<String> iteratorMenu = jsonMenu.iterator();
		    while(iteratorMenu.hasNext()){
		    	candidates.add(iteratorMenu.next());
		    }
		    
		    final ListView<String> candidatesListView = new ListView<>(candidates);
		    gridPane.add(candidatesListView, 0, 1);

		    selected = FXCollections.observableArrayList();
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
		}catch(Exception e){
			
		}
	}
	
	public void addModule(){
		try{
			StringBuffer sbModule = new StringBuffer();
			StringBuffer sbMenu = new StringBuffer();
			if(moduleName.getText().length() == 0 || moduleName.getText().equals("기본")){
				alert.setText("모듈 이름을 입력하십시오.('기본' 사용 불가)");
			}else{
				alert.setText("");
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
				String	param = "b_id="+URLEncoder.encode(UserInfo.getInstance().getId(),"UTF-8")+"&m_name="+URLEncoder.encode(moduleName.getText(),"UTF-8")+
						"&module="+URLEncoder.encode(sbModule.toString(),"UTF-8")+
						"&menu="+URLEncoder.encode(sbMenu.toString(),"UTF-8");
				String urlInfo = "http://localhost:8080/buengbueng/fxSetModulePro.do";
				BossMainController.getMenu().getChildren().add(BossMainController.setBossMenu(param,urlInfo));
			}
		}catch(Exception e){
			
		}
	}
		
}
