package application.controller.login;

import java.io.IOException;
import java.net.URLEncoder;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import application.ConnectServer;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import user.info.dto.UserInfo;

public class LoginController {
	@FXML private TextField id;
	@FXML private PasswordField pw;
	@FXML private Text alertTxt;
	
	public void searchId(){
		try {
			Parent main =  FXMLLoader.load(getClass().getResource("/application/controller/login/SearchIDApp.fxml"));
			Scene scene = new Scene(main);
			scene.getStylesheets().add(getClass().getResource("/application/css/application.css").toExternalForm());
			Main.getStage().setScene(scene); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void searchPw(){
		try {
			Parent main =  FXMLLoader.load(getClass().getResource("/application/controller/login/SearchPWApp.fxml"));
			Scene scene = new Scene(main);
			scene.getStylesheets().add(getClass().getResource("/application/css/application.css").toExternalForm());
			Main.getStage().setScene(scene); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sign(){
		try {
			Parent main =  FXMLLoader.load(getClass().getResource("/application/controller/login/SignApp.fxml"));
			Scene scene = new Scene(main);
			scene.getStylesheets().add(getClass().getResource("/application/css/application.css").toExternalForm());
			Main.getStage().setScene(scene); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void login(){
		/* ����ڰ� ID�� �Է� ���ϸ� �˸� */
		if(id.getText().equals("")){
			alertTxt.setText("���̵� �Է��ϼ���.");
		}
		/* ����ڰ� PW�� �Է� ���ϸ� �˸� */
		else if(pw.getText().equals("")){
			alertTxt.setText("��й�ȣ�� �Է��ϼ���.");
		}
		/* ����ڰ� ID�� PW�� �Է��ϸ� ���� */
		else{
			try {
				// �Է¹��� ������ �����ϴ� ����� ������ �ִ��� Ȯ��
				String param="id="+URLEncoder.encode(id.getText(),"UTF-8")+"&pw="+URLEncoder.encode(pw.getText(),"UTF-8");
				String urlInfo = "http://localhost:8080/buengbueng/fxLoginPro.do";
				JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
				
				String id = (String)jsonObj.get("id");
				
				// �����κ��� ���� ���� �޾Ұ�, �� ���� fail�� �ƴ϶�� = �α��� ����
				if(!id.isEmpty() && !id.equals("fail")){
					// ����� ���� ����
					UserInfo.getInstance().setId(id);
					UserInfo.getInstance().setPoint((String)jsonObj.get("point"));
					UserInfo.getInstance().setGrade(Integer.parseInt((String)jsonObj.get("grade")));
					UserInfo.getInstance().setLoginTime((String)jsonObj.get("loginTime"));
					Parent main = null;
					// ����� �����(3)�̸�
					if(UserInfo.getInstance().getGrade() == 3){
						// ����ȭ�� ���̾ƿ�
						main =  FXMLLoader.load(getClass().getResource("/application/controller/login/MainApp.fxml"));
					}else{
						main =  FXMLLoader.load(getClass().getResource("/application/controller/login/LoginApp.fxml"));
					}
					// ����ȭ�� ���̾ƿ��� ȭ�鿡 ���
					Scene scene = new Scene(main);
					scene.getStylesheets().add(getClass().getResource("/application/css/application.css").toExternalForm());
					// Main.getStage() = Main.java�� �ִ� ���ν������� ���(���� launch�� ��)
					Main.getStage().setFullScreen(false);
					Main.getStage().setWidth(600);	// â ���� ũ��
					Main.getStage().setHeight(300);	// â ���� ũ��
					Main.getStage().setX(1300);	// ����� �� â�� ��ġ�� X ��ǥ
					Main.getStage().setY(50);	// ����� �� â�� ��ġ�� Y ��ǥ
					Main.getStage().setScene(scene); // â�� ȭ�� �ֱ�
				}
				// �����κ��� ���� ���� ���� ���߰ų�, ���޹��� ���� fail�̶�� = �α��� ����
				else{
					alertTxt.setText("�α��� ����");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
