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

	
	// 이전 화면으로 돌아가기 (로그인 화면)
	public void before(){
		try{
			BorderPane root = new BorderPane();
			Parent login = FXMLLoader.load(getClass().getResource("/application/controller/login/LoginApp.fxml"));
			root.setCenter(login);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/css/application.css").toExternalForm());
			Main.getStage().setScene(scene);
			Main.getStage().setFullScreen(true);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// 웹 사이트의 회원가입 페이지 나타남
	@FXML
	public void initialize(){
		WebEngine webEngine = webSign.getEngine();
		// 웹 사이트에서 아이디 중복확인할 때 새 창 띄우는 거 없애고, Ajax 써야할 듯 -> load()가 여러 페이지를 보여주지 않고, 현재 페이지에 새로 띄우는 페이지를 덮어씌움
		webEngine.load("http://localhost:8080/buengbueng/userInfoSignForm.do");
		webEngine.setJavaScriptEnabled(true);
	}

}
