package application.controller.login;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class SignController {
	
	@FXML private WebView webSign;

	
	// ���� ȭ������ ���ư��� (�α��� ȭ��)
	public void before(){
		try{
			BorderPane root = new BorderPane();
			Parent login = FXMLLoader.load(getClass().getResource("/application/controller/login/LoginApp.fxml"));
			root.setCenter(login);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/css/application.css").toExternalForm());
			Main.getStage().setScene(scene);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// �� ����Ʈ�� ȸ������ ������ ��Ÿ��
	@FXML
	public void initialize(){
		WebEngine webEngine = webSign.getEngine();
		webEngine.load("http://localhost:8080/buengbueng/userInfoSignForm.do");
		webEngine.setJavaScriptEnabled(true);
	}

}
