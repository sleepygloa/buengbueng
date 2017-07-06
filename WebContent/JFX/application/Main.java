package application;
	
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URLEncoder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import user.info.dto.UserInfo;

// 로그인 화면 띄우기
public class Main extends Application {
	private static Stage primaryStage = null;
	@Override
	public void start(Stage primaryStage) {
		Main.primaryStage = primaryStage;
		try {
			BorderPane root = new BorderPane();
			Parent main = null;
			String licenseKey = null;
			String result = "fail";
			
			File dir = new File(System.getProperty("user.dir")+"\\licenseKey");
			if(!dir.exists()){
				dir.mkdirs();
			}
			
			File file = new File(dir.getPath()+"\\licenseKey.txt");
			if(file.isFile()){
				String a = null;
				FileReader fReader = new FileReader(file);
				BufferedReader bReader = new BufferedReader(fReader);
				if ((a = bReader.readLine()) != null) {
					licenseKey = a;
					String param = "b_key="+URLEncoder.encode(licenseKey,"UTF-8");
					String urlInfo = "http://localhost:8080/buengbueng/fxCheckLicenseKey.do";
					result = (String) ConnectServer.connect(param, urlInfo).get("result");
				}
				bReader.close();
			}else{
				main = FXMLLoader.load(getClass().getResource("/application/controller/login/LicenseKey.fxml"));
			}
			if(result.equals("succ")){
				UserInfo.getInstance().setB_key(licenseKey);
				main = FXMLLoader.load(getClass().getResource("/application/controller/login/LoginApp.fxml"));
			}else{
				main = FXMLLoader.load(getClass().getResource("/application/controller/login/LicenseKey.fxml"));
			}
			root.setCenter(main);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/css/application.css").toExternalForm());
			primaryStage.setFullScreen(true);
			primaryStage.setFullScreenExitHint("");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Stage getStage(){
		return primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
