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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BossEmployeeManageController {
	
	//영역(PANE)
	@FXML private AnchorPane employeeManage;
	@FXML private SplitPane splitVertical;
	//좌측
	@FXML private SplitPane splitLeftHorizon;
	@FXML private AnchorPane splitLeftHorizonPane;
	@FXML private AnchorPane e_idListSection;
	@FXML private AnchorPane employeeInfoSection;
	//우측
	@FXML private SplitPane splitRightBottomHorizon;
	@FXML private SplitPane splitRightHorizon;
	@FXML private AnchorPane splitRightHorizonPane;
	@FXML private AnchorPane commuteSection;
	@FXML private TitledPane commuteTitlePane;
	@FXML private AnchorPane commuteTablePane;
	@FXML private TitledPane payTitlePane;
	@FXML private AnchorPane payTablePane;
	@FXML private AnchorPane dialySection;
	
	//좌상 
	@FXML private TableView<EmployeeList> e_idListTable;
	@FXML private TableColumn<EmployeeList,String> e_id; //테이블 컴럼 추가
	private static ObservableList<EmployeeList> e_idListData =FXCollections.observableArrayList();
	
	
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
			e_idListSection.getChildren().add(e_idListTable);
		}catch(Exception e ){e.printStackTrace();}
		

			
//			idInsertApplyBtn = new Button();
//			idInsertApplyBtn.setOnMouseClicked(new EventHandler<MouseEvent>(){
//				@Override
//				public void handle(MouseEvent event) {
//					//여기서나는 신청 수와 신청사유를 가져갈 것이야
//					try{
//						String param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8")
//								+"&what="+URLEncoder.encode("return","UTF-8");
//						String urlInfo = "http://localhost:8080/buengbueng/employeeAddPro.do";
//						ConnectServer.connect(param, urlInfo);
//					}catch(UnsupportedEncodingException uee){
//						uee.printStackTrace();
//					}
//				}
//			});	
//					idInsertApply();
			
					
			
			
			
			
			//각종 VIEW 생성
//			splitVertical = new SplitPane();
//			splitLeftHorizon = new SplitPane();
//			splitRightHorizon  = new SplitPane();
//			e_idListSection = new AnchorPane();
//			employeeInfoSection = new AnchorPane();
			
			

			
			//좌상 추가신청 폼
			
			//좌상 삭제신청 폼
			
			//좌상 신청중인 아이디개수
			
			//좌상 보유중인 아이디개수
			
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
		
			//우상 달력
			
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
			
			employeeInfoSection.getChildren().add(e_idListSection);
			
			splitRightBottomHorizon.getItems().addAll(commuteTitlePane,payTitlePane);
			commuteSection.getChildren().add(splitRightBottomHorizon);
			
			splitLeftHorizon.getItems().addAll(e_idListSection,employeeInfoSection);
			splitLeftHorizonPane.getChildren().add(splitLeftHorizon);
			
			splitRightHorizon.getItems().addAll(dialySection,commuteSection); //한개더넣어야됨
			splitRightHorizonPane.getChildren().add(splitRightHorizon);
			
			splitVertical.getItems().addAll(splitLeftHorizonPane,splitRightHorizonPane);//좌하
			
			employeeManage.getChildren().add(splitVertical);
		}catch(Exception e ){e.printStackTrace();}
		
	}
	
	
	public void idInsertApply(){
		
		
	}
	
}
