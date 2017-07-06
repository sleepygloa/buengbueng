package application.controller.module;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import all.info.dto.UserInfo;
import application.ConnectServer;
import application.controller.etc.EditingCell;
import application.controller.etc.RentProductList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class BossRentManageController {
	@FXML private TabPane rentProductTab;
	@FXML private TextField rentName;
	@FXML private TextField rentProductCode;
	@FXML
	public void initialize(){
		try{
			String param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8");
			String urlInfo = "http://localhost:8080/buengbueng/fxGetRent.do";
			JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
			JSONArray jsonRentProduct = (JSONArray)jsonObj.get("rentProduct");
			
			Iterator<String> iteratorProduct = jsonRentProduct.iterator();
			while(iteratorProduct.hasNext()){
				String rentProduct = iteratorProduct.next();	
				Tab tab = new Tab(rentProduct);
				
				ObservableList<RentProductList> data =FXCollections.observableArrayList();
				TableView<RentProductList> tv = setTable();

				param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8")+
						"&rentProduct="+URLEncoder.encode(rentProduct,"UTF-8");
				urlInfo = "http://localhost:8080/buengbueng/fxGetRentProduct.do";
				JSONObject jsonObj2 = ConnectServer.connect(param, urlInfo);
				
				JSONArray jsonRentCode = (JSONArray)jsonObj2.get("code");
				JSONArray jsonRentCheck = (JSONArray)jsonObj2.get("rentCheck");
				JSONArray jsonRentRegist = (JSONArray)jsonObj2.get("beginRegist");
				
				Iterator<String> iteratorCode = jsonRentCode.iterator();
				Iterator<String> iteratorCheck = jsonRentCheck.iterator();
				Iterator<String> iteratorRegist = jsonRentRegist.iterator();
				
				while(iteratorCode.hasNext()){
					RentProductList rpl = new RentProductList();
					String rentCode = iteratorCode.next();
					rpl.setCode(rentCode);
					rpl.setRentCheck(iteratorCheck.next());
					rpl.setBeginRegist(iteratorRegist.next());
					Button modify = new Button("수정");
					modify.setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							try{
								String afterCode = null;
								String rentCheck = null;
								int selectedIndex = tv.getFocusModel().getFocusedIndex();
								if (selectedIndex >= 0) {
									afterCode = tv.getItems().get(selectedIndex).getCode();
									rentCheck = tv.getItems().get(selectedIndex).getRentCheck();
							    }
								String param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8")+
										"&beforeCode="+URLEncoder.encode(rentCode,"UTF-8")+"&afterCode="+URLEncoder.encode(afterCode,"UTF-8")+
										"&rentCheck="+URLEncoder.encode(rentCheck,"UTF-8");
								String urlInfo = "http://localhost:8080/buengbueng/fxModifyRentProduct.do";
								JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
								String result = (String)jsonObj.get("result");
							}catch(Exception e){
								e.printStackTrace();
							}
						}
					});
					Button delete = new Button("삭제");
					delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							try{
								String param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8")+
										"&code="+URLEncoder.encode(rentCode,"UTF-8");
								String urlInfo = "http://localhost:8080/buengbueng/fxDeleteRentProduct.do";
								JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
								String result = (String)jsonObj.get("result");
								if(result.equals("succ")){
									int selectedIndex = tv.getFocusModel().getFocusedIndex();
								    if (selectedIndex >= 0) {
								    	tv.getItems().remove(selectedIndex);
								    }
								}
							}catch(Exception e){
								e.printStackTrace();
							}
						}
					});
					rpl.setModi(modify);
					rpl.setDel(delete);
					data.add(rpl);
				}
				tv.setItems(data);
				tab.setContent(tv);
				rentProductTab.getTabs().add(tab);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private TableView<RentProductList> setTable(){
		TableView<RentProductList> tv = new TableView<RentProductList>();	
		tv.setEditable(true);
		Callback<TableColumn<RentProductList, String>, TableCell<RentProductList, String>> cellFactory =
         new Callback<TableColumn<RentProductList, String>, TableCell<RentProductList, String>>() {
             public TableCell call(TableColumn p) {
                return new EditingCell();
             }
         };
		
		TableColumn<RentProductList,String> code = new TableColumn<RentProductList,String>("바코드");
		code.setCellValueFactory(new PropertyValueFactory<RentProductList,String>("code"));
		code.setCellFactory(cellFactory);
		code.setOnEditCommit(
	            new EventHandler<CellEditEvent<RentProductList, String>>() {
	                @Override
	                public void handle(CellEditEvent<RentProductList, String> t) {
	                    ((RentProductList) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCode(t.getNewValue());
	                }
	            }
	    );
		
		TableColumn<RentProductList,String> rentCheck = new TableColumn<RentProductList,String>("대여 여부");
		rentCheck.setCellValueFactory(new PropertyValueFactory<RentProductList,String>("rentCheck"));
		rentCheck.setCellFactory(cellFactory);
		rentCheck.setOnEditCommit(
	            new EventHandler<CellEditEvent<RentProductList, String>>() {
	                @Override
	                public void handle(CellEditEvent<RentProductList, String> t) {
	                    ((RentProductList) t.getTableView().getItems().get(t.getTablePosition().getRow())).setRentCheck(t.getNewValue());
	                }
	            }
	    );
		
		TableColumn<RentProductList,String> beginRegist = new TableColumn<RentProductList,String>("등록일");
		beginRegist.setCellValueFactory(new PropertyValueFactory<RentProductList,String>("beginRegist"));
		
		TableColumn<RentProductList,Button> modi = new TableColumn<RentProductList,Button>("수정");
		modi.setCellValueFactory(new PropertyValueFactory<RentProductList,Button>("modi"));	
		
		TableColumn<RentProductList,Button> del = new TableColumn<RentProductList,Button>("삭제");
		del.setCellValueFactory(new PropertyValueFactory<RentProductList,Button>("del"));
		
		tv.getColumns().addAll(code,rentCheck,beginRegist,modi,del);
		
		return tv;
	}

	public void addRent(){
		try{
			String param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8")+
					"&rentProduct="+URLEncoder.encode(rentName.getText(),"UTF-8");
			String urlInfo = "http://localhost:8080/buengbueng/fxAddRent.do";
			JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
			String result = (String)jsonObj.get("result");
			if(result.equals("succ")){
				Tab tab = new Tab(rentName.getText());
				
				ObservableList<RentProductList> data =FXCollections.observableArrayList();
				TableView<RentProductList> tv = setTable();
				tab.setContent(tv);
				rentProductTab.getTabs().add(tab);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void delRent(){
		try{
			int selectedIndex = rentProductTab.getSelectionModel().getSelectedIndex();
		    if (selectedIndex >= 0) {
				String param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8")+
						"&rentProduct="+URLEncoder.encode(rentProductTab.getTabs().get(selectedIndex).getText(),"UTF-8");
				String urlInfo = "http://localhost:8080/buengbueng/fxDelRent.do";
				JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
				String result = (String)jsonObj.get("result");
				if(result.equals("succ")){
			    	rentProductTab.getTabs().remove(selectedIndex);
			    }
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void addRentProduct(){
		try{
			int selectedIndex = rentProductTab.getSelectionModel().getSelectedIndex();
		    if (selectedIndex >= 0) {
		    	long time = System.currentTimeMillis(); 
				SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String date = dayTime.format(new Date(time));
				
		    	String param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8")+
		    			"&rentProduct="+URLEncoder.encode(rentProductTab.getTabs().get(selectedIndex).getText(),"UTF-8")+
						"&code="+URLEncoder.encode(rentProductCode.getText(),"UTF-8")+"&rentCheck=0"+"&regist="+date;
				String urlInfo = "http://localhost:8080/buengbueng/fxAddRentProduct.do";
				JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
				String result = (String)jsonObj.get("result");
				
				if(result.equals("succ")){
			    	TableView<RentProductList> tv = (TableView<RentProductList>) rentProductTab.getTabs().get(selectedIndex).getContent();
			    	RentProductList rpl = new RentProductList();
					String rentCode = rentProductCode.getText();
					rpl.setCode(rentCode);
					rpl.setRentCheck("0");
					rpl.setBeginRegist(date);

					Button modify = new Button("수정");
					modify.setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							try{
								String afterCode = null;
								String rentCheck = null;
								int selectedIndex = tv.getFocusModel().getFocusedIndex();
								if (selectedIndex >= 0) {
									afterCode = tv.getItems().get(selectedIndex).getCode();
									rentCheck = tv.getItems().get(selectedIndex).getRentCheck();
							    }
								String param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8")+
										"&beforeCode="+URLEncoder.encode(rentCode,"UTF-8")+"&afterCode="+URLEncoder.encode(afterCode,"UTF-8")+
										"&rentCheck="+URLEncoder.encode(rentCheck,"UTF-8");
								String urlInfo = "http://localhost:8080/buengbueng/fxModifyRentProduct.do";
								JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
								String result = (String)jsonObj.get("result");
							}catch(Exception e){
								e.printStackTrace();
							}
						}
					});
					Button delete = new Button("삭제");
					delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							try{
								String param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8")+
										"&code="+URLEncoder.encode(rentCode,"UTF-8");
								String urlInfo = "http://localhost:8080/buengbueng/fxDeleteRentProduct.do";
								JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
								String result = (String)jsonObj.get("result");
								if(result.equals("succ")){
									int selectedIndex = tv.getFocusModel().getFocusedIndex();
								    if (selectedIndex >= 0) {
								    	tv.getItems().remove(selectedIndex);
								    }
								}
							}catch(Exception e){
								e.printStackTrace();
							}
						}
					});
					rpl.setModi(modify);
					rpl.setDel(delete);
					tv.getItems().add(rpl);
				}
		    }
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
