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
import application.controller.etc.MenuProductList;
import application.controller.etc.ProductList;
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

public class BossMenuManageController {
	@FXML private TabPane menuTab;
	@FXML private TextField category;
	@FXML private TextField name;
	@FXML private TextField company;
	@FXML private TextField price;
	@FXML private TextField code;
	@FXML private TextField proName;
	@FXML private TextField lastDay;
	@FXML
	public void initialize(){
		getMenu();
	}
	
	private TableView<MenuProductList> setTable(){
		TableView<MenuProductList> tv = new TableView<MenuProductList>();	
		tv.setEditable(true);
		Callback<TableColumn<MenuProductList, String>, TableCell<MenuProductList, String>> cellFactory =
         new Callback<TableColumn<MenuProductList, String>, TableCell<MenuProductList, String>>() {
             public TableCell call(TableColumn p) {
                return new EditingCell();
             }
         };
		
		TableColumn<MenuProductList,String> category = new TableColumn<MenuProductList,String>("메뉴명");
		category.setCellValueFactory(new PropertyValueFactory<MenuProductList,String>("category"));
		
		TableColumn<MenuProductList,String> name = new TableColumn<MenuProductList,String>("제품명");
		name.setCellValueFactory(new PropertyValueFactory<MenuProductList,String>("name"));
		name.setCellFactory(cellFactory);
		name.setOnEditCommit(
	            new EventHandler<CellEditEvent<MenuProductList, String>>() {
	                @Override
	                public void handle(CellEditEvent<MenuProductList, String> t) {
	                    ((MenuProductList) t.getTableView().getItems().get(t.getTablePosition().getRow())).setName(t.getNewValue());
	                }
	            }
	    );
		
		TableColumn<MenuProductList,String> company = new TableColumn<MenuProductList,String>("제품 회사");
		company.setCellValueFactory(new PropertyValueFactory<MenuProductList,String>("company"));
		company.setCellFactory(cellFactory);
		company.setOnEditCommit(
	            new EventHandler<CellEditEvent<MenuProductList, String>>() {
	                @Override
	                public void handle(CellEditEvent<MenuProductList, String> t) {
	                    ((MenuProductList) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCompany(t.getNewValue());
	                }
	            }
	    );
		
		TableColumn<MenuProductList,String> price = new TableColumn<MenuProductList,String>("가격");
		price.setCellValueFactory(new PropertyValueFactory<MenuProductList,String>("price"));
		price.setCellFactory(cellFactory);
		price.setOnEditCommit(
	            new EventHandler<CellEditEvent<MenuProductList, String>>() {
	                @Override
	                public void handle(CellEditEvent<MenuProductList, String> t) {
	                    ((MenuProductList) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPrice(t.getNewValue());
	                }
	            }
	    );
		
		TableColumn<MenuProductList,Button> modi = new TableColumn<MenuProductList,Button>("수정");
		modi.setCellValueFactory(new PropertyValueFactory<MenuProductList,Button>("modi"));	
		
		TableColumn<MenuProductList,Button> del = new TableColumn<MenuProductList,Button>("삭제");
		del.setCellValueFactory(new PropertyValueFactory<MenuProductList,Button>("del"));
		
		tv.getColumns().addAll(category,name,company,price,modi,del);
		
		return tv;
	}

	private TableView<ProductList> setPTable(){
		TableView<ProductList> tv = new TableView<ProductList>();	
		tv.setEditable(true);
		Callback<TableColumn<ProductList, String>, TableCell<ProductList, String>> cellFactory =
         new Callback<TableColumn<ProductList, String>, TableCell<ProductList, String>>() {
             public TableCell call(TableColumn p) {
                return new EditingCell();
             }
         };
		
		TableColumn<ProductList,String> code = new TableColumn<ProductList,String>("바코드");
		code.setCellValueFactory(new PropertyValueFactory<ProductList,String>("code"));
		code.setCellFactory(cellFactory);
		code.setOnEditCommit(
	            new EventHandler<CellEditEvent<ProductList, String>>() {
	                @Override
	                public void handle(CellEditEvent<ProductList, String> t) {
	                    ((ProductList) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCode(t.getNewValue());
	                }
	            }
	    );
		
		TableColumn<ProductList,String> name = new TableColumn<ProductList,String>("제품명");
		name.setCellValueFactory(new PropertyValueFactory<ProductList,String>("name"));
		name.setCellFactory(cellFactory);
		name.setOnEditCommit(
	            new EventHandler<CellEditEvent<ProductList, String>>() {
	                @Override
	                public void handle(CellEditEvent<ProductList, String> t) {
	                    ((ProductList) t.getTableView().getItems().get(t.getTablePosition().getRow())).setName(t.getNewValue());
	                }
	            }
	    );
		
		TableColumn<ProductList,String> saleCheck = new TableColumn<ProductList,String>("판매 유무");
		saleCheck.setCellValueFactory(new PropertyValueFactory<ProductList,String>("saleCheck"));

		
		TableColumn<ProductList,String> beginRegist = new TableColumn<ProductList,String>("등록일");
		beginRegist.setCellValueFactory(new PropertyValueFactory<ProductList,String>("beginRegist"));

		
		TableColumn<ProductList,String> lastDay = new TableColumn<ProductList,String>("유통기한");
		lastDay.setCellValueFactory(new PropertyValueFactory<ProductList,String>("lastDay"));
		lastDay.setCellFactory(cellFactory);
		lastDay.setOnEditCommit(
	            new EventHandler<CellEditEvent<ProductList, String>>() {
	                @Override
	                public void handle(CellEditEvent<ProductList, String> t) {
	                    ((ProductList) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLastDay(t.getNewValue());
	                }
	            }
	    );
		
		TableColumn<ProductList,Button> modi = new TableColumn<ProductList,Button>("수정");
		modi.setCellValueFactory(new PropertyValueFactory<ProductList,Button>("modi"));	
		
		TableColumn<ProductList,Button> del = new TableColumn<ProductList,Button>("삭제");
		del.setCellValueFactory(new PropertyValueFactory<ProductList,Button>("del"));
		
		tv.getColumns().addAll(code,name,saleCheck,beginRegist,lastDay,modi,del);
		
		return tv;
	}
	
	public void getMenu(){
		try{
			menuTab.getTabs().clear();
			String param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8");
			String urlInfo = "http://localhost:8080/buengbueng/fxGetMenuCategory.do";
			JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
			JSONArray jsonCategory = (JSONArray)jsonObj.get("category");
			
			Iterator<String> iteratorCategory = jsonCategory.iterator();
			while(iteratorCategory.hasNext()){
				String category = iteratorCategory.next();	
				Tab tab = new Tab(category);
				
				ObservableList<MenuProductList> data =FXCollections.observableArrayList();
				TableView<MenuProductList> tv = setTable();
	
				param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8")+
						"&category="+URLEncoder.encode(category,"UTF-8");
				urlInfo = "http://localhost:8080/buengbueng/fxGetCategoryList.do";
				JSONObject jsonObj2 = ConnectServer.connect(param, urlInfo);
				
				JSONArray jsonCategory2 = (JSONArray)jsonObj2.get("category");
				JSONArray jsonName = (JSONArray)jsonObj2.get("name");
				JSONArray jsonPrice = (JSONArray)jsonObj2.get("price");
				JSONArray jsonCompany = (JSONArray)jsonObj2.get("company");
				
				Iterator<String> iteratorCategory2 = jsonCategory2.iterator();
				Iterator<String> iteratorName = jsonName.iterator();
				Iterator<String> iteratorPrice = jsonPrice.iterator();
				Iterator<String> iteratorCompany = jsonCompany.iterator();
				
				while(iteratorName.hasNext()){
					MenuProductList mpl = new MenuProductList();
					String menuCategory = iteratorCategory2.next();
					String menuName = iteratorName.next();
					String menuPrice = iteratorPrice.next();
					String menuCompany = iteratorCompany.next();
	
					mpl.setCategory(menuCategory);
					mpl.setName(menuName);
					mpl.setCompany(menuCompany);
					mpl.setPrice(menuPrice);
					
					Button modify = menuModifyButton(tv, menuName, menuCategory);
					Button delete = menuDeleteButton(tv, menuName);
					
					mpl.setModi(modify);
					mpl.setDel(delete);
					data.add(mpl);
				}
				tv.setItems(data);
				tab.setContent(tv);
				menuTab.getTabs().add(tab);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void addMenu(){
		try{
			String param = "l_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8")+
					"&category="+URLEncoder.encode(category.getText(),"UTF-8")+
					"&name="+URLEncoder.encode(name.getText(),"UTF-8")+
					"&company="+URLEncoder.encode(company.getText(),"UTF-8")+
					"&price="+URLEncoder.encode(price.getText(),"UTF-8");
			String urlInfo = "http://localhost:8080/buengbueng/fxAddMenu.do";
			JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
			String result = (String)jsonObj.get("result");
			if(result.equals("succ")){
				for(int i = 0; i < menuTab.getTabs().size(); i++){
					if(menuTab.getTabs().get(i).getText().equals(category.getText())){
						TableView<MenuProductList> tv = (TableView<MenuProductList>) menuTab.getTabs().get(i).getContent();
						MenuProductList mpl = new MenuProductList();
						mpl.setCategory(category.getText());
						mpl.setName(name.getText());
						mpl.setCompany(company.getText());
						mpl.setPrice(price.getText());
						
						Button modify = menuModifyButton(tv, name.getText(), category.getText());
						Button delete = menuDeleteButton(tv, name.getText());
						
						mpl.setModi(modify);
						mpl.setDel(delete);
						tv.getItems().add(mpl);
						return;
					}
				}
				Tab tab = new Tab(category.getText());	
				ObservableList<MenuProductList> data =FXCollections.observableArrayList();
				TableView<MenuProductList> tv = setTable();
				MenuProductList mpl = new MenuProductList();
				mpl.setCategory(category.getText());
				mpl.setName(name.getText());
				mpl.setCompany(company.getText());
				mpl.setPrice(price.getText());
				
				Button modify = menuModifyButton(tv, name.getText(), category.getText());
				Button delete = menuDeleteButton(tv, name.getText());
				
				mpl.setModi(modify);
				mpl.setDel(delete);
				data.add(mpl);
				tv.setItems(data);
				tab.setContent(tv);
				menuTab.getTabs().add(tab);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private Button menuModifyButton(TableView<MenuProductList> tv, String menuName, String menuCategory){
		Button modify = new Button("수정");
		modify.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				try{
					String mName = null;
					String mCompany = null;
					String mPrice = null;
					int selectedIndex = tv.getSelectionModel().getSelectedIndex();
					if (selectedIndex >= 0) {
						mName = tv.getItems().get(selectedIndex).getName();
						mCompany = tv.getItems().get(selectedIndex).getCompany();
						mPrice = tv.getItems().get(selectedIndex).getPrice();
				    }
					String param = "l_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8")+
							"&beforeName="+URLEncoder.encode(menuName,"UTF-8")+"&name="+URLEncoder.encode(mName,"UTF-8")+
							"&company="+URLEncoder.encode(mCompany,"UTF-8")+"&price="+URLEncoder.encode(mPrice,"UTF-8")+
							"&category="+URLEncoder.encode(menuCategory,"UTF-8");
					String urlInfo = "http://localhost:8080/buengbueng/fxModifyMenu.do";
					JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
					String result = (String)jsonObj.get("result");
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		return modify;
	}
	
	private Button menuDeleteButton(TableView<MenuProductList> tv, String menuName){
		Button delete = new Button("삭제");
		delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				try{
					String param = "l_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8")+
							"&name="+URLEncoder.encode(menuName,"UTF-8");
					String urlInfo = "http://localhost:8080/buengbueng/fxDeleteMenu.do";
					JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
					String result = (String)jsonObj.get("result");
					if(result.equals("succ")){
						int selectedIndex = tv.getSelectionModel().getSelectedIndex();
					    if (selectedIndex >= 0) {
					    	tv.getItems().remove(selectedIndex);
					    }
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		return delete;
	}
	
	public void getProduct(){
		try{
			menuTab.getTabs().clear();
			String param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8");
			String urlInfo = "http://localhost:8080/buengbueng/fxGetMenuProduct.do";
			JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
			
			Tab tab = new Tab("재고");
			ObservableList<ProductList> data =FXCollections.observableArrayList();
			TableView<ProductList> tv = setPTable();
			
			JSONArray jsonCode = (JSONArray)jsonObj.get("code");
			JSONArray jsonName = (JSONArray)jsonObj.get("name");
			JSONArray jsonCheck = (JSONArray)jsonObj.get("saleCheck");
			JSONArray jsonBegin = (JSONArray)jsonObj.get("beginRegist");
			JSONArray jsonLast = (JSONArray)jsonObj.get("lastDay");
			
			Iterator<String> iteratorCode = jsonCode.iterator();
			Iterator<String> iteratorName = jsonName.iterator();
			Iterator<String> iteratorCheck = jsonCheck.iterator();
			Iterator<String> iteratorBegin = jsonBegin.iterator();
			Iterator<String> iteratorLast = jsonLast.iterator();
			
			while(iteratorCode.hasNext()){
				ProductList pl = new ProductList();
				String productCode = iteratorCode.next();
				String productName = iteratorName.next();
				String productCheck = iteratorCheck.next();
				String productBegin = iteratorBegin.next();
				String productLast = iteratorLast.next();

				pl.setCode(productCode);
				pl.setName(productName);
				pl.setSaleCheck(productCheck);
				pl.setBeginRegist(productBegin);
				pl.setLastDay(productLast);
				
				Button modify = productModifyButton(tv, productCode);
				Button delete = productDeleteButton(tv, productCode);
				
				pl.setModi(modify);
				pl.setDel(delete);
				data.add(pl);
			}
			tv.setItems(data);
			tab.setContent(tv);
			menuTab.getTabs().add(tab);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void addProduct(){
		try{
			long time = System.currentTimeMillis(); 
			SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String date = dayTime.format(new Date(time));
			
			String param = "l_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8")+
					"&code="+code.getText() + "&name="+URLEncoder.encode(proName.getText(),"UTF-8")+
					"&salecheck=1"+"&regist="+date + "&last="+lastDay.getText();

			String urlInfo = "http://localhost:8080/buengbueng/fxAddProduct.do";
			JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
			String result = (String)jsonObj.get("result");
			if(result.equals("succ")){
				TableView<ProductList> tv = (TableView<ProductList>) menuTab.getTabs().get(0).getContent();
				ProductList pl = new ProductList();
				pl.setCode(code.getText());
				pl.setName(proName.getText());
				pl.setSaleCheck("0");
				pl.setBeginRegist(date);
				pl.setLastDay(lastDay.getText());
				
				Button modify = productModifyButton(tv, code.getText());
				Button delete = productDeleteButton(tv, code.getText());
			
				pl.setModi(modify);
				pl.setDel(delete);
				tv.getItems().add(pl);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private Button productModifyButton(TableView<ProductList> tv, String beforCode){
		Button modify = new Button("수정");
		modify.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				try{
					String pCode = null;
					String pLast = null;
					int selectedIndex = tv.getSelectionModel().getSelectedIndex();
					if (selectedIndex >= 0) {
						pCode = tv.getItems().get(selectedIndex).getCode();
						pLast = tv.getItems().get(selectedIndex).getLastDay();
				    }
					String param = "l_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8")+
							"&beforeCode="+lastDay + "&code="+pCode + "&lastday="+pLast;
					String urlInfo = "http://localhost:8080/buengbueng/fxModifyProduct.do";
					
					JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
					String result = (String)jsonObj.get("result");
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		return modify;
	}
	
	private Button productDeleteButton(TableView<ProductList> tv, String code){
		Button delete = new Button("삭제");
		delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				try{
					String param = "l_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8")+
							"&code="+code;
					String urlInfo = "http://localhost:8080/buengbueng/fxDeleteProduct.do";
					JSONObject jsonObj = ConnectServer.connect(param, urlInfo);
					String result = (String)jsonObj.get("result");
					if(result.equals("succ")){
						int selectedIndex = tv.getSelectionModel().getSelectedIndex();
					    if (selectedIndex >= 0) {
					    	tv.getItems().remove(selectedIndex);
					    }
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		return delete;
	}
}
