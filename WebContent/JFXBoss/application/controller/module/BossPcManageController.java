package application.controller.module;

import java.net.URLEncoder;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import all.info.dto.UserInfo;
import application.ConnectServer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class BossPcManageController {
	@FXML private AnchorPane pcAlertView;
	@FXML private AnchorPane pcUseView;
	@FXML private AnchorPane pcCountView;
	@FXML private Text pcCheck;
	@FXML
	public void initialize(){
		try{
			String param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8");
			String urlInfo = "http://localhost:8080/buengbueng/fxGetPcUseState.do";
			JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
			JSONArray jsonPc = (JSONArray)jsonObj.get("seatCon");
			
			String check = 0+"/"+jsonObj.get("count");
			
			pcCheck.setText(check);
			Iterator<Long> iteratorPc = jsonPc.iterator();
			int i = 0;
			int j = 0;
			int k = 1;
			GridPane gridPane = new GridPane();
			while(iteratorPc.hasNext()){
				Long chkUse = iteratorPc.next();
				Label label = new Label(String.valueOf(k));
				label.getStyleClass().add("pcNum");
				AnchorPane pcUseCheck = new AnchorPane();
				pcUseCheck.setMaxWidth(128); pcUseCheck.setMinWidth(128);
				pcUseCheck.setMaxHeight(128); pcUseCheck.setMinHeight(128);
				pcUseCheck.getChildren().add(label);
				if(chkUse == 0){
					pcUseCheck.getStyleClass().add("notUse");
				}else{
					pcUseCheck.getStyleClass().add("use");
				}
				gridPane.add(pcUseCheck, i, j);
				i++;
				k++;
				if(i%10 == 0){
					i = 0;
					j++;
				}
			}
			pcUseView.getChildren().add(gridPane);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
