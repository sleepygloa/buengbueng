package application.controller.module;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import application.ConnectServer;
import application.controller.login.BossMainController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import user.info.dto.UserInfo;

public class BossNewModuleController {
	@FXML private AnchorPane moduleCheckView;
	@FXML private AnchorPane moduleSetView;
	@FXML private TextField moduleName;
	@FXML private Button addModule;
	private ArrayList<CheckBox> chk = new ArrayList<CheckBox>();
	private ArrayList<Label> lb = new ArrayList<Label>();
	@FXML
	public void initialize(){
		try{
			String param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8");
			String urlInfo = "http://localhost:8080/buengbueng/fxSetModule.do";
			JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
			GridPane gridPane = new GridPane();
			JSONArray jsonMenu = (JSONArray)jsonObj.get("moduleName");
			int i = 0;
			int j = 0;
			Iterator<String> iteratorMenu = jsonMenu.iterator();
			while(iteratorMenu.hasNext()){
				HBox hbox = new HBox();
		        gridPane.setHgap(20);
		        gridPane.setVgap(20);
				CheckBox chkBox = new CheckBox();
				chk.add(chkBox);
				Label label = new Label();
				lb.add(label);
				String name = iteratorMenu.next();
				if(name.equals("option")){
					chkBox.setSelected(true);
				}else{
					chkBox.setSelected(false);
				}
				label.setText(name);
				hbox.getChildren().addAll(chkBox,label);
				gridPane.add(hbox, i, j);
				i++;
				if(i%3 == 0){
					i = 0;
					j++;
				}
			}
			moduleCheckView.getChildren().add(gridPane);
		}catch(Exception e){
			
		}
	}
	
	public void addModule(){
		try{
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
			String	param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8")+"&m_name="+URLEncoder.encode(moduleName.getText(),"UTF-8")+
					"&module="+URLEncoder.encode(sbModule.toString(),"UTF-8")+
					"&menu="+URLEncoder.encode(sbMenu.toString(),"UTF-8");
			String urlInfo = "http://localhost:8080/buengbueng/fxSetModulePro.do";
			BossMainController.getMenu().getChildren().add(BossMainController.setBossMenu(param,urlInfo));
		}catch(Exception e){
			
		}
	}
		
}
