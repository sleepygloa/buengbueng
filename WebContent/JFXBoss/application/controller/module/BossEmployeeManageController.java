package application.controller.module;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import all.info.dto.UserInfo;
import application.ConnectServer;
import application.controller.etc.EmployeeList;
import application.controller.etc.EmployeePayList;
import application.controller.etc.EmployeeTotalIdInfoList;
import application.controller.etc.EmployeeWorkTimeList;
import application.controller.etc.RentOrderList;
import application.controller.etc.StringToJson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class BossEmployeeManageController {
	
	//영역(PANE)
	@FXML private AnchorPane employeeManage;
	//좌측
	@FXML private AnchorPane splitLeftHorizonPane;
	@FXML private AnchorPane e_idListSection;
	@FXML private AnchorPane employeeInfoSection;
	//우측
	@FXML private AnchorPane splitRightHorizonPane;
	@FXML private AnchorPane commuteSection;
	@FXML private TitledPane commuteTitlePane;
	@FXML private AnchorPane commuteTablePane;
	@FXML private TitledPane payTitlePane;
	@FXML private AnchorPane payTablePane;
	@FXML private AnchorPane diarySection;
	
	//좌상 
	
	@FXML private TableView<EmployeeList> e_idListTable;
	@FXML private TableColumn<EmployeeList,String> e_id; //테이블 컴럼 추가
	private static ObservableList<EmployeeList> e_idListData =FXCollections.observableArrayList();
	
	@FXML private TableView<EmployeeList> commuteList;
	@FXML private TableColumn<EmployeeList,String> commuteListColumn; //테이블 컴럼 추가
	private static ObservableList<EmployeeList> e_idListData5 =FXCollections.observableArrayList();
	
	@FXML private TextField commuteIdText; //아이디 입력창
	@FXML private Button commute; //출근
	@FXML private Button offWork; //퇴근
	
	//좌하
	@FXML private TabPane totalIdInfo; //좌하 의 탭페이지
	@FXML private Tab totalIdInfoList; //좌하의 탭 중 TOTAL
	@FXML private TableView<EmployeeTotalIdInfoList> totalTable;
	@FXML private TableColumn<EmployeeTotalIdInfoList,String> totalId; //테이블 컴럼 추가
	@FXML private TableColumn<EmployeeTotalIdInfoList,String> totalName; //테이블 컴럼 추가
	@FXML private TableColumn<EmployeeTotalIdInfoList,String> totalBirth; //테이블 컴럼 추가
	@FXML private TableColumn<EmployeeTotalIdInfoList,String> totalPhone; //테이블 컴럼 추가
	@FXML private TableColumn<EmployeeTotalIdInfoList,String> totalAddress; //테이블 컴럼 추가
	@FXML private TableColumn<EmployeeTotalIdInfoList,String> totalEmail; //테이블 컴럼 추가
	@FXML private TableColumn<EmployeeTotalIdInfoList,String> totalGoogleId; //테이블 컴럼 추가
	private static ObservableList<EmployeeTotalIdInfoList> e_idListData2 =FXCollections.observableArrayList();
	
	//우상
	@FXML private WebView diary; //달력
	
	
	//우하
	@FXML private TableView<EmployeeWorkTimeList> commuteTable;
	@FXML private TableColumn<EmployeeWorkTimeList,Long> wtNum; //테이블 컴럼 추가
	@FXML private TableColumn<EmployeeWorkTimeList,Timestamp> wtTodayDate; //테이블 컴럼 추가
	@FXML private TableColumn<EmployeeWorkTimeList,String> wtTitle; //테이블 컴럼 추가
	@FXML private TableColumn<EmployeeWorkTimeList,Timestamp> wtStart; //테이블 컴럼 추가
	@FXML private TableColumn<EmployeeWorkTimeList,Timestamp> wtEnd; //테이블 컴럼 추가
	@FXML private TableColumn<EmployeeWorkTimeList,Timestamp> wtCommuteTime; //테이블 컴럼 추가
	@FXML private TableColumn<EmployeeWorkTimeList,Timestamp> wtOffWorkTime; //테이블 컴럼 추가
	@FXML private TableColumn<EmployeeWorkTimeList,Long> wtResult; //테이블 컴럼 추가
	@FXML private TableColumn<EmployeeWorkTimeList,String> wtColor; //테이블 컴럼 추가
	@FXML private TableColumn<EmployeeWorkTimeList,Timestamp> wtEx; //테이블 컴럼 추가
	private static ObservableList<EmployeeWorkTimeList> e_idListData3 =FXCollections.observableArrayList();
	
	@FXML private TableView<EmployeePayList> payTable;
	@FXML private TableColumn<EmployeePayList,Long> payNum; //테이블 컴럼 추가
	@FXML private TableColumn<EmployeePayList,String> payId; //테이블 컴럼 추가
	@FXML private TableColumn<EmployeePayList,String> payName; //테이블 컴럼 추가
	@FXML private TableColumn<EmployeePayList,Long> payWorkTime; //테이블 컴럼 추가
	@FXML private TableColumn<EmployeePayList,Long> payPayment; //테이블 컴럼 추가
	@FXML private TableColumn<EmployeePayList,Timestamp> payCommute; //테이블 컴럼 추가
	@FXML private TableColumn<EmployeePayList,Timestamp> payOffWork; //테이블 컴럼 추가
	
	
	private static ObservableList<EmployeePayList> e_idListData4 =FXCollections.observableArrayList();
	
	
	
	
	@FXML private Button idInsertApplyBtn;
	
	@FXML
	public void commute(){
		StringToJson jsonTo = new StringToJson();
		try{
			//좌상 출근하기
			jsonTo.urlConntectToReturnStringContainText("fxEmployeeCommute.do", commuteIdText); //Bean에 연결
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@FXML
	public void offWork(){
		StringToJson jsonTo = new StringToJson();
		try{
			//좌상 퇴근하기
			jsonTo.urlConntectToReturnStringContainText("fxEmployeeOffWork.do", commuteIdText); //Bean에 연결
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@FXML
	public void initialize(){
		StringToJson jsonTo = new StringToJson();
		try{
			e_idListTable.getItems().clear();
			e_idListData.clear();
			
			//좌상 아이디 리스트
			String jsonString = jsonTo.urlConntectToReturnString("fxEmployeeIdList.do"); //Bean에 연결
			JSONArray jsonEid = jsonTo.stringToJsonArray(jsonString);//String 을 JsonArray 변경
			String eDtoString = "EmployeeList"; //구분 변수 
			e_idListData = jsonTo.jsonArrayToJsonObject(jsonEid, eDtoString); //JsonArray를 JsonObject로 변경하고 dto에 넣음.
			
			e_id.setCellValueFactory(new PropertyValueFactory<EmployeeList,String>("e_id")); //테이블 컬럼 이름과 형식

			//TABLE을 VIEW에 포함하기
			e_idListTable.setItems(e_idListData);

		}catch(Exception e ){e.printStackTrace();}
		
		
		
		//좌상 출근중인사람 리스트
		try{
			commuteList.getItems().clear();
			e_idListData5.clear();
			
			String jsonString = jsonTo.urlConntectToReturnString("fxEmployeeWorkList.do"); //Bean에 연결
			JSONArray jsonEid = jsonTo.stringToJsonArray(jsonString);//String 을 JsonArray 변경
			String eDtoString = "EmployeeWorkList"; //구분 변수 
			e_idListData5 = jsonTo.jsonArrayToJsonObject(jsonEid, eDtoString); //JsonArray를 JsonObject로 변경하고 dto에 넣음.
			
			commuteListColumn.setCellValueFactory(new PropertyValueFactory<EmployeeList,String>("e_id")); //테이블 컬럼 이름과 형식
			
			commuteList.setItems(e_idListData5);
			
		}catch(Exception e){
			e.printStackTrace();
		}
			
			

			
			
		//좌하 알바 신상 현황
		try{
			totalTable.getItems().clear();
			e_idListData2.clear();
			//좌하 알바 신상 리스트
			String jsonString = jsonTo.urlConntectToReturnString("fxEmployeeTotalIdList.do"); //Bean에 연결
			JSONArray jsonEid = jsonTo.stringToJsonArray(jsonString);//String 을 JsonArray 변경
			String eDtoString = "EmployeeTotalIdInfoList"; //구분 변수 
			e_idListData2 = jsonTo.jsonArrayToJsonObject(jsonEid, eDtoString); //JsonArray를 JsonObject로 변경하고 dto에 넣음.
			
			totalId.setCellValueFactory(new PropertyValueFactory<EmployeeTotalIdInfoList,String>("totalId")); //테이블 컬럼 이름과 형식
			totalName.setCellValueFactory(new PropertyValueFactory<EmployeeTotalIdInfoList,String>("totalName")); //테이블 컬럼 이름과 형식
			totalBirth.setCellValueFactory(new PropertyValueFactory<EmployeeTotalIdInfoList,String>("totalBirth")); //테이블 컬럼 이름과 형식
			totalPhone.setCellValueFactory(new PropertyValueFactory<EmployeeTotalIdInfoList,String>("totalPhone")); //테이블 컬럼 이름과 형식
			totalAddress.setCellValueFactory(new PropertyValueFactory<EmployeeTotalIdInfoList,String>("totalAddress")); //테이블 컬럼 이름과 형식
			totalEmail.setCellValueFactory(new PropertyValueFactory<EmployeeTotalIdInfoList,String>("totalEmail")); //테이블 컬럼 이름과 형식
			totalGoogleId.setCellValueFactory(new PropertyValueFactory<EmployeeTotalIdInfoList,String>("totalGoogleId")); //테이블 컬럼 이름과 형식
			
			//View 연결
			totalTable.setItems(e_idListData2);
			totalIdInfoList.setContent(totalTable);
			totalIdInfo.getTabs().add(totalIdInfoList);
			
		}catch(Exception e){e.printStackTrace();}
		
		try{
		//우상 달력
		WebEngine webEngine = diary.getEngine();
		// 웹 사이트에서 아이디 중복확인할 때 새 창 띄우는 거 없애고, Ajax 써야할 듯 -> load()가 여러 페이지를 보여주지 않고, 현재 페이지에 새로 띄우는 페이지를 덮어씌움
		webEngine.load("http://localhost:8080/buengbueng/employeeCalenderOnly.do?id="+URLEncoder.encode(UserInfo.getInstance().getId(),"UTF-8")+
				"&b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8"));
		webEngine.setJavaScriptEnabled(true);
		}catch(Exception e){
			e.printStackTrace();
		}
		
			//우하 근무일정
		try{
			commuteTable.getItems().clear();
			e_idListData3.clear();
			
			String jsonString = jsonTo.urlConntectToReturnString("fxEmployeeCommuteList.do"); //Bean에 연결
			JSONArray jsonEid = jsonTo.stringToJsonArray(jsonString);//String 을 JsonArray 변경
			String eDtoString = "EmployeeCommuteList"; //구분 변수 
			e_idListData3 = jsonTo.jsonArrayToJsonObject(jsonEid, eDtoString); //JsonArray를 JsonObject로 변경하고 dto에 넣음.
			
			wtNum.setCellValueFactory(new PropertyValueFactory<EmployeeWorkTimeList,Long>("wtNum")); //테이블 컬럼 이름과 형식
			wtTodayDate.setCellValueFactory(new PropertyValueFactory<EmployeeWorkTimeList,Timestamp>("wtTodayDate")); //테이블 컬럼 이름과 형식
			wtTitle.setCellValueFactory(new PropertyValueFactory<EmployeeWorkTimeList,String>("wtTitle")); //테이블 컬럼 이름과 형식
			wtStart.setCellValueFactory(new PropertyValueFactory<EmployeeWorkTimeList,Timestamp>("wtStart")); //테이블 컬럼 이름과 형식
			wtEnd.setCellValueFactory(new PropertyValueFactory<EmployeeWorkTimeList,Timestamp>("wtEnd")); //테이블 컬럼 이름과 형식
			wtCommuteTime.setCellValueFactory(new PropertyValueFactory<EmployeeWorkTimeList,Timestamp>("wtCommuteTime")); //테이블 컬럼 이름과 형식
			wtOffWorkTime.setCellValueFactory(new PropertyValueFactory<EmployeeWorkTimeList,Timestamp>("wtOffWorkTime")); //테이블 컬럼 이름과 형식
			wtResult.setCellValueFactory(new PropertyValueFactory<EmployeeWorkTimeList,Long>("wtResult")); //테이블 컬럼 이름과 형식
			wtColor.setCellValueFactory(new PropertyValueFactory<EmployeeWorkTimeList,String>("wtColor")); //테이블 컬럼 이름과 형식
			wtEx.setCellValueFactory(new PropertyValueFactory<EmployeeWorkTimeList,Timestamp>("wtEx")); //테이블 컬럼 이름과 형식
			
			commuteTable.setItems(e_idListData3);
			commuteTitlePane.setContent(commuteTable);
			
		}catch(Exception e){e.printStackTrace();}
			//우하 근무비 지금 대장
		try{
			payTable.getItems().clear();
			e_idListData4.clear();
			
			String jsonString = jsonTo.urlConntectToReturnString("fxEmployeePayList.do"); //Bean에 연결
			JSONArray jsonEid = jsonTo.stringToJsonArray(jsonString);//String 을 JsonArray 변경
			String eDtoString = "EmployeePayList"; //구분 변수 
			e_idListData4 = jsonTo.jsonArrayToJsonObject(jsonEid, eDtoString); //JsonArray를 JsonObject로 변경하고 dto에 넣음.
			
			payNum.setCellValueFactory(new PropertyValueFactory<EmployeePayList,Long>("payNum")); //테이블 컬럼 이름과 형식
			payId.setCellValueFactory(new PropertyValueFactory<EmployeePayList,String>("payId")); //테이블 컬럼 이름과 형식
			payName.setCellValueFactory(new PropertyValueFactory<EmployeePayList,String>("payName")); //테이블 컬럼 이름과 형식
			payWorkTime.setCellValueFactory(new PropertyValueFactory<EmployeePayList,Long>("payWorkTime")); //테이블 컬럼 이름과 형식
			payPayment.setCellValueFactory(new PropertyValueFactory<EmployeePayList,Long>("payPayment")); //테이블 컬럼 이름과 형식
			payCommute.setCellValueFactory(new PropertyValueFactory<EmployeePayList,Timestamp>("payCommute")); //테이블 컬럼 이름과 형식
			payOffWork.setCellValueFactory(new PropertyValueFactory<EmployeePayList,Timestamp>("payOffWork")); //테이블 컬럼 이름과 형식
			payTable.setItems(e_idListData4);
			payTitlePane.setContent(payTable);
		}catch(Exception e){e.printStackTrace();}
//		
		
		
		try{	
			//각종 VIEW 연동
			
			
			e_idListSection.getChildren().addAll(e_idListTable, commuteList);
			
			employeeInfoSection.getChildren().add(e_idListSection);
			
			commuteSection.getChildren().addAll(commuteTablePane, payTablePane);
			
			splitLeftHorizonPane.getChildren().addAll(e_idListSection,employeeInfoSection);
			
			splitRightHorizonPane.getChildren().addAll(diarySection,commuteSection);
			
			employeeManage.getChildren().addAll(splitLeftHorizonPane,splitRightHorizonPane);
		}catch(Exception e ){e.printStackTrace();}
		
	}
	
	
	public void idInsertApply(){
		
		
	}
	
}

