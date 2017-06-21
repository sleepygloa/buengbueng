package application.controller.order;

import java.io.UnsupportedEncodingException;
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
import user.info.dto.UserInfo;

public class RentPane extends AnchorPane{

	public RentPane getRentPane(JSONArray jsonArr){
		Label label = new Label();
		RentPane r = new RentPane();
		Iterator<String> iterator = jsonArr.iterator();
		VBox vbox = new VBox();
		HBox hbox = new HBox();
		hbox.setSpacing(20);
		vbox.setSpacing(20);
		Button rent = new Button("대여하기");
		rent.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				try {
					String param = "key="+URLEncoder.encode("k93h11m16","UTF-8")+"&id="+URLEncoder.encode(UserInfo.getInstance().getId(),"UTF-8")+
							"rentList="+URLEncoder.encode(label.getText(),"UTF-8");
					String urlInfo ="http://localhost:8080/buengbueng/fxOrderRent.do";
					JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
					if(jsonObj.get("result").equals("succ")){
						MainController.getStage().close();	
					}
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		while(iterator.hasNext()){
			Button btn = new Button(iterator.next());
			btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
				int i = 1;
				@Override
				public void handle(MouseEvent event) {
					if(label.getText().contains(btn.getText())){
						String txt = label.getText().replace(btn.getText()+(i-1), btn.getText()+i);
						label.setText(txt);
						i++;
					}else{
						String txt = label.getText();
						label.setText(txt+" "+btn.getText()+i);
						i++;
					}
				}
			});
			hbox.getChildren().add(btn);
		}
		vbox.getChildren().addAll(hbox,label,rent);
		r.getChildren().add(vbox);
		return r;
	}	
}
