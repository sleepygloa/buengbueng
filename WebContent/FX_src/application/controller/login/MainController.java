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
	
	// ����â(�α��� �� �ߴ� â) ��Ÿ�� �� �����
	@FXML
	public void initialize(){
		id.setText(UserInfo.getInstance().getId());
		point.setText(UserInfo.getInstance().getPoint()+"��");
		useTime2 = useTime;
		// Ÿ�̸� ���� (1�ð��� 500���̶�� ġ��...)
		int p = Integer.parseInt(UserInfo.getInstance().getPoint().replaceAll(",", ""));
		int count = (p/500)*3600;
		UseCount.getUseTime(count).start();
	}
	
	public void Logout(){
		try {
			// Ÿ�̸� ����
			UseCount.stopTime();
			
			// ����� �α׾ƿ� �ð� �α׿� �����
			String param="id="+URLEncoder.encode(id.getText(),"UTF-8")+"&loginTime="+URLEncoder.encode(UserInfo.getInstance().getLoginTime(),"UTF-8");
			String urlInfo ="http://localhost:8080/buengbueng/fxLogoutPro.do";
			JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
			
			// �α׾ƿ� ���������� �Ǹ� �ʱ� ȭ��(�α��� ȭ��)���� ��ȯ
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
				Main.getStage().setX(0);	// ����� �� â�� ��ġ�� X ��ǥ
				Main.getStage().setY(0);	// ����� �� â�� ��ġ�� Y ��ǥ
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
