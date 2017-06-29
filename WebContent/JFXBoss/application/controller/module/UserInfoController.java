package application.controller.module;

import java.net.URLEncoder;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import application.ConnectServer;
import application.controller.etc.MenuList;
import application.controller.etc.RentList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class UserInfoController {
	@FXML private Text pcNum;
	@FXML private Text id;
	@FXML private Text startTime;
	@FXML private TableView<RentList> rentList;
	@FXML private TableColumn<RentList,String> name;
	@FXML private TableColumn<RentList,String> code;
	@FXML private TableView<MenuList> menuList;
	@FXML private TableColumn<MenuList,String> mname;
	@FXML private TableColumn<MenuList,String> mcode;
	@FXML private TableColumn<MenuList,String> mprice;
	
	private static String num;
	private static String uid;
	@FXML
	private void initialize(){
		pcNum.setText(num);
		id.setText(uid);
		try{
			String param = "id="+URLEncoder.encode(uid,"UTF-8");
			String urlInfo = "http://localhost:8080/buengbueng/fxGetOneUserInfo.do";
			JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
			
			startTime.setText((String)jsonObj.get("startTime"));
			
			
			ObservableList<RentList> data =FXCollections.observableArrayList();
			ObservableList<MenuList> data2 =FXCollections.observableArrayList();
			
			name.setCellValueFactory(new PropertyValueFactory<RentList,String>("name"));
			code.setCellValueFactory(new PropertyValueFactory<RentList,String>("code"));
			
			JSONArray jsonName = (JSONArray)jsonObj.get("name");
			JSONArray jsonCode = (JSONArray)jsonObj.get("code");
			
			Iterator<String> iteratorName = jsonName.iterator();
			Iterator<String> iteratorCode = jsonCode.iterator();
			
			while(iteratorName.hasNext() && iteratorCode.hasNext()){
				String name = iteratorName.next();
				String code = iteratorCode.next();
				RentList sui = new RentList(name,code);
				data.add(sui);
			}
			
			rentList.setItems(data);
			
			mname.setCellValueFactory(new PropertyValueFactory<MenuList,String>("mname"));
			mcode.setCellValueFactory(new PropertyValueFactory<MenuList,String>("mcode"));
			mprice.setCellValueFactory(new PropertyValueFactory<MenuList,String>("mprice"));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void setNum(String num) {
		UserInfoController.num = num;
	}
	public static void setUid(String uid) {
		UserInfoController.uid = uid;
	}
	
	
}
