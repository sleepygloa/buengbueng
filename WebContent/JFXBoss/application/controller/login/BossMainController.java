package application.controller.login;

import java.net.URLEncoder;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import application.ConnectServer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import user.info.dto.UserInfo;

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
			String	param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8");
			String urlInfo = "http://localhost:8080/buengbueng/fxGetModule.do";
			bossMenu.getChildren().add(setBossMenu(param,urlInfo));
		}catch(Exception e){	
		}
	}
	
	
	public static AnchorPane getMenu(){
		return menu;
	}
	
	public static AnchorPane getView(){
		return view;
	}
	
	public static VBox setBossMenu(String param, String urlInfo){
		menu.getChildren().clear();
		VBox vbox = new VBox();
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
								Node node = (Node)FXMLLoader.load(getClass().getResource(url));
								view.getChildren().setAll(node);
							} catch (Exception e) {
							}
						}
					});
					vbox.getChildren().add(btn);
				}
			}
		} catch (Exception e) {
			// 추후 수정
		}
		return vbox;
	}
}
