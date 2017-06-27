package application.controller.login;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import application.ConnectServer;
import application.Main;
import application.UseCount;
import application.controller.order.RentPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import user.info.dto.UserInfo;

public class MainController {
	@FXML private Text id;
	@FXML private Text point;
	@FXML private Label pcNum;
	@FXML private Text useTime;
	@FXML private Text alert;
	private static Text point2;
	private static Text useTime2;
	private static Stage rentStage;
	
	// 메인창(로그인 후 뜨는 창) 나타날 때 실행됨
	@FXML
	public void initialize(){
		id.setText(UserInfo.getInstance().getId());
		point.setText(UserInfo.getInstance().getPoint()+"원");
		pcNum.setText(UserInfo.getInstance().getPcNum());
		useTime2 = useTime;
		point2 = point;
		count();
	}
	
	// 사용 가능 시간 타이머
	public void count(){
		// 타이머 시작 (1초에 0.25원)
		int count = (int)(UserInfo.getInstance().getPoint()/0.25);
		UseCount.getUseTime(count).start();
	}
	
	// 메뉴 주문 -> 포인트 차감 -> 사용 가능 시간 깎임
	public void menuOrder(){
		// 타이머 멈춤
		UseCount.stopTime();
		// 주문한 메뉴가 2000원이라고 치고...
		double menu = 2000;
		double currentPoint = UserInfo.getInstance().getPoint();
		if(menu < currentPoint){
			UserInfo.getInstance().setPoint(currentPoint-menu);
			count();
		}else{
			alert.setText("충전 후 이용해주십시오.");
			count();
		}
	}
	
	// 
	public void rentOrder(){
		try {
			String param="key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8");
			String urlInfo ="http://localhost:8080/buengbueng/fxGetRentList.do";
			JSONObject jsonObj = ConnectServer.connect(param, urlInfo);

			RentPane rent = new RentPane();
			Scene scene = new Scene(rent.getRentPane((JSONArray)jsonObj.get("rent")));
			if(rentStage == null){
				rentStage = new Stage();
			}
			rentStage.setScene(scene);
			rentStage.show();
		} catch (IOException e) {
			// 추후 수정
		}
	}
	
	// 사용자 로그아웃
	public void Logout(){
		try {
			// 타이머 멈춤
			UseCount.stopTime();
			
			// 사용자 로그아웃 시간 로그에 남기기
			String param="id="+URLEncoder.encode(UserInfo.getInstance().getId(),"UTF-8")+"&loginTime="+URLEncoder.encode(UserInfo.getInstance().getLoginTime(),"UTF-8")+
					"&pcNum="+URLEncoder.encode(UserInfo.getInstance().getPcNum(),"UTF-8")+"&key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8");
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
	
	public static Text getPoint(){
		return point2;
	}
	
	public static Stage getStage(){
		return rentStage;
	}
}
