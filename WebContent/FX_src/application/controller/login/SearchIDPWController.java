package application.controller.login;

import java.net.URLEncoder;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import application.ConnectServer;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class SearchIDPWController {
	// ���̵� ã��
	@FXML private TextField i_name;
	@FXML private TextField i_email;
	@FXML private TextField i_phone;
	@FXML private Text i_alert;
	// ��й�ȣ ã��
	@FXML private TextField p_id;
	@FXML private TextField p_name;
	@FXML private TextField p_phone;
	@FXML private Text p_alert;

	// ���� ȭ������ ���ư��� (�α��� ȭ��)
	public void before(){
		try{
			BorderPane root = new BorderPane();
			Parent login = FXMLLoader.load(getClass().getResource("/application/controller/login/LoginApp.fxml"));
			root.setCenter(login);
			Scene scene = new Scene(root);
			Main.getStage().setScene(scene);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// ���̵� ã��
	public void searchId(){
		if(i_name.getText().equals("")){
			i_alert.setText("�̸��� �Է��ϼ���.");
		}else if(i_email.getText().equals("")){
			i_alert.setText("�̸����� �Է��ϼ���");
		}else if(i_phone.getText().equals("")){
			i_alert.setText("��ȭ ��ȣ�� �Է��ϼ���.");
		}else{
			try{
				// �Է��� �̸�, �̸���, ��ȭ��ȣ�� ������ DB���� �ش� ������ �����ϴ� ������� ID�� �ִ��� ã�� ���� ������ ����
				String param="name="+URLEncoder.encode(i_name.getText(),"UTF-8")+"&email="+URLEncoder.encode(i_email.getText(),"UTF-8")+"&phone="+URLEncoder.encode(i_phone.getText(),"UTF-8");
				String urlInfo = "http://localhost:8080/buengbueng/fxSearchId.do";
				JSONObject jsonObj = ConnectServer.connect(param, urlInfo);

				String id = (String)jsonObj.get("id");
				
				// ���̵� ������
				if(id.equals("fail")){
					i_alert.setText("���̵� ������ ã�� �� �����ϴ�.");
				}
				// ���̵� ������ ���� ȭ���� �˸�â�� ���
				else{
					i_alert.setText("ȸ������ ���̵�� "+id+" �Դϴ�.");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	// ��й�ȣ ã��
	public void searchPw(){
		if(p_id.getText().equals("")){
			p_alert.setText("���̵� �Է��ϼ���.");
		}else if(p_name.getText().equals("")){
			p_alert.setText("�̸��� �Է��ϼ���");
		}else if(p_phone.getText().equals("")){
			p_alert.setText("��ȭ ��ȣ�� �Է��ϼ���.");
		}else{
			try{
				// �Է��� ���̵�, �̸�, ��ȭ��ȣ�� ������ DB���� �ش� ������ �����ϴ� ������� PW�� �ִ��� ã�� ���� ������ ����
				String param="id="+URLEncoder.encode(p_id.getText(),"UTF-8")+"&name="+URLEncoder.encode(p_name.getText(),"UTF-8")+"&phone="+URLEncoder.encode(p_phone.getText(),"UTF-8");
				String urlInfo = "http://localhost:8080/buengbueng/fxSearchPw.do";
				JSONObject jsonObj = ConnectServer.connect(param, urlInfo);

				String pw = (String)jsonObj.get("pw");
				
				// ��й�ȣ�� ������
				if(pw.equals("fail")){
					p_alert.setText("��й�ȣ ������ ã�� �� �����ϴ�.");
				}
				// ��й�ȣ�� ������ ���� ȭ���� �˸�â�� ���
				else{
					p_alert.setText("ȸ������ ��й�ȣ�� "+pw+" �Դϴ�.");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
}
