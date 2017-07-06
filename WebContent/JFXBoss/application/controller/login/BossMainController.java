package application.controller.login;

import java.net.URLEncoder;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import all.info.dto.UserInfo;
import application.ConnectServer;
import application.Main;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BossMainController {
	@FXML private AnchorPane bossMenu;
	@FXML private AnchorPane bossView;
	private static AnchorPane menu;
	private static AnchorPane view;
	@FXML
	public void initialize(){
		try{
			menu = bossMenu;
			view = bossView;
			String	param = "b_id="+URLEncoder.encode(UserInfo.getInstance().getId(),"UTF-8")+
							"&grade="+UserInfo.getInstance().getGrade();
			String urlInfo = "http://localhost:8080/buengbueng/fxGetModule.do";
			bossMenu.getChildren().add(setBossMenu(param,urlInfo));
			
			param = "l_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8");
			urlInfo = "http://localhost:8080/buengbueng/fxDeleteLastProduct.do";
			ConnectServer.connect(param, urlInfo);
		}catch(Exception e){	
		}
	}
	
	public static AnchorPane getMenu(){
		return menu;
	}
	
	public static AnchorPane getView(){
		return view;
	}
	
	public static HBox setBossMenu(String param, String urlInfo){
		menu.getChildren().clear();
		HBox hbox = new HBox();
		try{
			JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
			JSONArray jsonModule = (JSONArray)jsonObj.get("module");
			JSONArray jsonMenu = (JSONArray)jsonObj.get("menu");
			
			Iterator<Long> iteratorModule = jsonModule.iterator();
			Iterator<String> iteratorMenu = jsonMenu.iterator();
	
			while(iteratorModule.hasNext() && iteratorMenu.hasNext()){
				Long chk = iteratorModule.next();
				String menu = iteratorMenu.next();
				if(chk == 1){
					Button btn = new Button(menu);
					btn.setPrefWidth(200);
					btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							try {
								String url = "/application/controller/module/"+btn.getText()+".fxml";
								Parent node = (Parent)FXMLLoader.load(getClass().getResource(url));
								view.getChildren().setAll(node);
							} catch (Exception e) {
							}
						}
					});
					hbox.getChildren().add(btn);
				}
			}
		} catch (Exception e) {
			// 추후 수정
		}
		return hbox;
	}
	
	public static AnchorPane view(){
		return view;
	}
}
