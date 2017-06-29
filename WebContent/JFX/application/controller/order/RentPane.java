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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import user.info.dto.UserInfo;

public class RentPane extends AnchorPane{

	public RentPane getRentPane(JSONArray jsonArr){
		Label label = new Label();
		RentPane r = new RentPane();
		Iterator<String> iterator = jsonArr.iterator();
		VBox vbox = new VBox();
		HBox hbox = new HBox();
		Label alert = new Label();
		alert.setTextFill(Color.RED);
		hbox.setSpacing(20);
		vbox.setSpacing(20);
		Button rent = new Button("대여하기");
		rent.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				try {
					if(!label.getText().equals("")){
						String param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8")+"&id="+URLEncoder.encode(UserInfo.getInstance().getId(),"UTF-8")+
								"&rentList="+URLEncoder.encode(label.getText(),"UTF-8")+"&pcNum="+UserInfo.getInstance().getPcNum();
						String urlInfo ="http://localhost:8080/buengbueng/fxOrderRent.do";
						JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
						if(jsonObj.get("result").equals("succ")){
							// 소켓 통신 (UDP)...
							String msg = URLEncoder.encode(UserInfo.getInstance().getPcNum()+","+UserInfo.getInstance().getId()+","+jsonObj.get("suc"),"UTF-8");
							// 전송할 수 있는 UDP 소켓 생성
							DatagramSocket socket = new DatagramSocket();
		   
							// 받을 곳의 주소 생성
							InetAddress ia = InetAddress.getByName(UserInfo.getInstance().getBossIP());
		   
							// 전소할 데이터 생성
							DatagramPacket dp = new DatagramPacket(msg.getBytes(),msg.getBytes().length,ia, 7777);
		   
							socket.send(dp);
							socket.close();
						}
						if(jsonObj.get("result").equals("succ") && jsonObj.get("err").equals("")){
							MainController.getStage().close();
						}else{
							alert.setText((String)jsonObj.get("err"));
							label.setText("");
						}
					}else{
						alert.setText("대여할 물품을 선택 후 눌러주세요.");
					}
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		while(iterator.hasNext()){
			Button btn = new Button(iterator.next());
			btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					if(!label.getText().contains(btn.getText())){
						String txt = label.getText();
						label.setText(btn.getText()+" "+txt);
					}
				}
			});
			hbox.getChildren().add(btn);
		}
		vbox.getChildren().addAll(alert,hbox,label,rent);
		r.getChildren().add(vbox);
		return r;
	}	
}
