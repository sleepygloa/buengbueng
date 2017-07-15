package application;

import java.util.Optional;

import org.json.simple.JSONObject;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class CancelController {
	private static String param;
	private static String urlInfo;
	private static CancelController instance = new CancelController();
	private static Alert alert;
	private CancelController(){
		alert = new Alert(AlertType.CONFIRMATION);
	}
	
	public static void getInstance(){
		alert.setTitle("취소 확인");
		alert.setHeaderText("확인을 누르시면 취소됩니다.");
		alert.setContentText("정말 취소하시겠습니까?");

		ButtonType buttonTypeOk = new ButtonType("확인");
		ButtonType buttonTypeCancel = new ButtonType("취소");
		
		alert.getButtonTypes().setAll(buttonTypeOk, buttonTypeCancel);
		
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOk){
			instance.cancelOK();
		}else {
		    instance.cancelCancel();
		}
	}
	
	public static void setParam(String txt){
		param = txt;
	}
	
	public static void setUrlInfo(String txt){
		urlInfo = txt;
	}
	
	public void cancelOK(){
		try {
			JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
			if(((String)jsonObj.get("result")).equals("succ")){
				alert.close();
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void cancelCancel(){
		alert.close();
	}
}
