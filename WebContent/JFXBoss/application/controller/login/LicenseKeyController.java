package application.controller.login;

import java.io.FileWriter;
import java.net.URLEncoder;

import all.info.dto.UserInfo;
import application.ConnectServer;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class LicenseKeyController {
	@FXML private Text alert;
	@FXML private TextField licenseKey;
	
	public void checkLicenseKey(){
		try{
			String param = "b_key="+URLEncoder.encode(licenseKey.getText(),"UTF-8");
			String urlInfo = "http://localhost:8080/buengbueng/fxCheckLicenseKey.do";
			String result = (String) ConnectServer.connect(param, urlInfo).get("result");
			if(result.equals("succ")){
				FileWriter fw;
				fw = new FileWriter(System.getProperty("user.dir")+"\\licenseKey\\licenseKey.txt");
				fw.write(licenseKey.getText());
				fw.flush();
				fw.close();
				
				UserInfo.getInstance().setB_key(licenseKey.getText());
				
				BorderPane root = new BorderPane();
				Parent main = FXMLLoader.load(getClass().getResource("/application/controller/login/LoginApp.fxml"));
				root.setCenter(main);
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("/application/css/application.css").toExternalForm());
				Main.getStage().setScene(scene);
				Main.getStage().setFullScreen(true);
			}else{
				alert.setText("입력한 라이센스키가 맞지 않습니다.");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
