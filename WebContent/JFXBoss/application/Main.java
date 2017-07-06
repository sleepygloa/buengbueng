package application;
	
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URLEncoder;

import all.info.dto.UserInfo;
import application.controller.order.RentOrder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	private static Stage primaryStage = null;
	private static Thread socket = RentOrder.getRent();
	private static Thread socketT = Socket.getSocket();
	private static boolean socketCheck = false;
	private static boolean socketCheckT = false;
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
			
			// [x] 박스 클릭 시 로그아웃
			primaryStage.setOnCloseRequest(event -> {
				try{
					if(UserInfo.getInstance().getId() != null){
						// 사용자 로그아웃 시간 로그에 남기기
						String param="id="+URLEncoder.encode(UserInfo.getInstance().getId(),"UTF-8")+"&loginTime="+URLEncoder.encode(UserInfo.getInstance().getLoginTime(),"UTF-8")+
								"&pcNum="+URLEncoder.encode("0","UTF-8")+"&key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8");
						String urlInfo ="http://localhost:8080/buengbueng/fxLogoutPro.do";
						ConnectServer.connect(param, urlInfo);
					}
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					// 수정하기
					Socket.socketClose();
					RentOrder.rentClose();
				}
			});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Stage getStage(){
		return primaryStage;
	}
	
	public static Thread getSocket(){
		return socket;
	}
	
	public static Thread getSocketT(){
		return socketT;
	}
	
	public static boolean getSocketCheck(){
		return socketCheck;
	}
	
	public static void setSocketCheck(boolean tf){
		socketCheck = tf;
	}
	public static boolean getSocketCheckT(){
		return socketCheckT;
	}
	
	public static void setSocketCheckT(boolean tf){
		socketCheckT = tf;
	}
	public static void main(String[] args) {
		launch(args);
	}
}
