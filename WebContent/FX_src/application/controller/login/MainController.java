package application.controller.login;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.net.URLEncoder;

import org.json.simple.JSONObject;

import application.ConnectServer;
import application.Main;
import application.UseCount;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import user.info.dto.UserInfo;

public class MainController {
	@FXML private Text id;
	@FXML private Text point;
	@FXML private Text useTime;
	private static Text useTime2;
	
	// 메인창(로그인 후 뜨는 창) 나타날 때 실행됨
	@FXML
	public void initialize(){
		id.setText(UserInfo.getInstance().getId());
		point.setText(UserInfo.getInstance().getPoint()+"원");
		useTime2 = useTime;
		// 타이머 시작 (1시간에 500원이라고 치고...)
		int p = Integer.parseInt(UserInfo.getInstance().getPoint().replaceAll(",", ""));
		int count = (p/500)*3600;
		UseCount.getUseTime(count).start();
	}
	
	public void Logout(){
		try {
			// 타이머 멈춤
			UseCount.stopTime();
			
			// 사용자 로그아웃 시간 로그에 남기기
			String param="id="+URLEncoder.encode(id.getText(),"UTF-8")+"&loginTime="+URLEncoder.encode(UserInfo.getInstance().getLoginTime(),"UTF-8");
			String urlInfo ="http://localhost:8080/buengbueng/fxLogoutPro.do";
			JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
			
			// 로그아웃 정상적으로 되면 초기 화면(로그인 화면)으로 전환
			if(jsonObj.get("result").equals("succ")){
				UserInfo.getInstance().clear();
				BorderPane root = new BorderPane();
				Parent login = FXMLLoader.load(getClass().getResource("/application/controller/login/LoginApp.fxml"));
				root.setCenter(login);
				
				GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("/application/css/application.css").toExternalForm());
				Main.getStage().setWidth(gd.getDisplayMode().getWidth());
				Main.getStage().setHeight(gd.getDisplayMode().getHeight());
				Main.getStage().setX(0);	// 모니터 상에 창이 위치할 X 좌표
				Main.getStage().setY(0);	// 모니터 상에 창이 위치할 Y 좌표
				Main.getStage().setScene(scene);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Text getUseTime(){
		return useTime2;
	}

}
