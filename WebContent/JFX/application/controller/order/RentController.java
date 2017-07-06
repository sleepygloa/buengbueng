package application.controller.order;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import application.ConnectServer;
import application.controller.login.MainController;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import user.info.dto.UserInfo;

public class RentController extends AnchorPane{
	@FXML private Label alert;
	@FXML private Text rentOrder;
	@FXML private AnchorPane rentList;
	@FXML private AnchorPane userRentList;
	
	public void initialize(){
		try{
			String param="key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8");
			String urlInfo ="http://localhost:8080/buengbueng/fxGetRentList.do";
			JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
			JSONArray jsonArr = (JSONArray)jsonObj.get("rent");
	
			Iterator<String> iterator = jsonArr.iterator();
	
			GridPane gridPane = new GridPane();
			int i = 0;
			int j = 0;
			while(iterator.hasNext()){
				AnchorPane rentListChk = new AnchorPane();
				Button btn = new Button(iterator.next());
				btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						if(!rentOrder.getText().contains(btn.getText())){
							String txt = "";
							if(rentOrder.getText().length()!=0){
								txt = rentOrder.getText()+",";
							}
							rentOrder.setText(txt+btn.getText());
						}
					}
				});
				rentListChk.setPadding(new Insets(10.0));
				rentListChk.getChildren().add(btn);
				gridPane.add(rentListChk, i, j);
				i++;
				if(i%5 == 0){
					i = 0;
					j++;
				}
			}
			rentList.getChildren().add(gridPane);
			
			param = "id="+URLEncoder.encode(UserInfo.getInstance().getId(),"UTF-8");
			urlInfo = "http://localhost:8080/buengbueng/fxGetOneUserInfo.do";
			jsonObj = ConnectServer.connect(param, urlInfo);
			jsonArr = (JSONArray)jsonObj.get("name");
	
			iterator = jsonArr.iterator();
	
			while(iterator.hasNext()){
				VBox vbox = new VBox();
				Text txt = new Text(iterator.next()+" 대여 중입니다.");
				vbox.getChildren().add(txt);
				userRentList.getChildren().add(vbox);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void rent(){
		try {
			if(!rentOrder.getText().equals("")){
				String param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8")+"&id="+URLEncoder.encode(UserInfo.getInstance().getId(),"UTF-8")+
						"&rentList="+URLEncoder.encode(rentOrder.getText(),"UTF-8")+"&pcNum="+UserInfo.getInstance().getPcNum();
				String urlInfo ="http://localhost:8080/buengbueng/fxOrderRent.do";
				JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
				if(jsonObj.get("result").equals("succ")){
					String s[] = ((String)jsonObj.get("suc")).split(",");
					for(int i = 0; i < s.length ; i ++){
						// 소켓 통신 (UDP)...
						String msg = URLEncoder.encode(UserInfo.getInstance().getPcNum()+","+UserInfo.getInstance().getId()+","+s[i],"UTF-8");
						// 전송할 수 있는 UDP 소켓 생성
						DatagramSocket socket = new DatagramSocket();
	   
						// 받을 곳의 주소 생성
						InetAddress ia = InetAddress.getByName(UserInfo.getInstance().getBossIP());
	   
						// 전소할 데이터 생성
						DatagramPacket dp = new DatagramPacket(msg.getBytes(),msg.getBytes().length,ia, 7777);
	   
						socket.send(dp);
						socket.close();
					}
				}
				if(jsonObj.get("result").equals("succ") && jsonObj.get("err").equals("")){
					MainController.getStage().close();
				}else{
					alert.setText((String)jsonObj.get("err"));
					rentOrder.setText("");
				}
			}else{
				alert.setText("대여할 물품을 선택 후 눌러주세요.");
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
