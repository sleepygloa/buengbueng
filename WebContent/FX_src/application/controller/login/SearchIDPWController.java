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
	// 아이디 찾기
	@FXML private TextField i_name;
	@FXML private TextField i_email;
	@FXML private TextField i_phone;
	@FXML private Text i_alert;
	// 비밀번호 찾기
	@FXML private TextField p_id;
	@FXML private TextField p_name;
	@FXML private TextField p_phone;
	@FXML private Text p_alert;

	// 이전 화면으로 돌아가기 (로그인 화면)
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
	
	// 아이디 찾기
	public void searchId(){
		if(i_name.getText().equals("")){
			i_alert.setText("이름을 입력하세요.");
		}else if(i_email.getText().equals("")){
			i_alert.setText("이메일을 입력하세요");
		}else if(i_phone.getText().equals("")){
			i_alert.setText("전화 번호를 입력하세요.");
		}else{
			try{
				// 입력한 이름, 이메일, 전화번호를 가지고 DB에서 해당 정보에 부합하는 사용자의 ID가 있는지 찾기 위해 서버로 연결
				String param="name="+URLEncoder.encode(i_name.getText(),"UTF-8")+"&email="+URLEncoder.encode(i_email.getText(),"UTF-8")+"&phone="+URLEncoder.encode(i_phone.getText(),"UTF-8");
				String urlInfo = "http://localhost:8080/buengbueng/fxSearchId.do";
				JSONObject jsonObj = ConnectServer.connect(param, urlInfo);

				String id = (String)jsonObj.get("id");
				
				// 아이디가 없으면
				if(id.equals("fail")){
					i_alert.setText("아이디 정보를 찾을 수 없습니다.");
				}
				// 아이디가 있으면 현재 화면의 알림창에 띄움
				else{
					i_alert.setText("회원님의 아이디는 "+id+" 입니다.");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	// 비밀번호 찾기
	public void searchPw(){
		if(p_id.getText().equals("")){
			p_alert.setText("아이디를 입력하세요.");
		}else if(p_name.getText().equals("")){
			p_alert.setText("이름을 입력하세요");
		}else if(p_phone.getText().equals("")){
			p_alert.setText("전화 번호를 입력하세요.");
		}else{
			try{
				// 입력한 아이디, 이름, 전화번호를 가지고 DB에서 해당 정보에 부합하는 사용자의 PW가 있는지 찾기 위해 서버로 연결
				String param="id="+URLEncoder.encode(p_id.getText(),"UTF-8")+"&name="+URLEncoder.encode(p_name.getText(),"UTF-8")+"&phone="+URLEncoder.encode(p_phone.getText(),"UTF-8");
				String urlInfo = "http://localhost:8080/buengbueng/fxSearchPw.do";
				JSONObject jsonObj = ConnectServer.connect(param, urlInfo);

				String pw = (String)jsonObj.get("pw");
				
				// 비밀번호가 없으면
				if(pw.equals("fail")){
					p_alert.setText("비밀번호 정보를 찾을 수 없습니다.");
				}
				// 비밀번호가 있으면 현재 화면의 알림창에 띄움
				else{
					p_alert.setText("회원님의 비밀번호는 "+pw+" 입니다.");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
}
