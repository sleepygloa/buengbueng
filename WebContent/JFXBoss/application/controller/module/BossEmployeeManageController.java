package application.controller.module;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import all.info.dto.UserInfo;
import application.ConnectServer;
import application.controller.etc.EmployeeList;
import application.controller.etc.RentOrderList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BossEmployeeManageController {
	
	@FXML private AnchorPane employeeManage;
	@FXML private SplitPane splitVertical;
	@FXML private SplitPane splitLeftHorizon;
	@FXML private AnchorPane e_idListSection;
	@FXML private AnchorPane employeeInfoSection;

	@FXML private SplitPane splitRightHorizon;
	@FXML private TableView<EmployeeList> e_idListTable;
	@FXML private TableColumn<EmployeeList,String> e_id; //테이블 컴럼 추가
	private static ObservableList<EmployeeList> e_idListData =FXCollections.observableArrayList();
	
	@FXML private Button idInsertApplyBtn;
	
	@FXML
	public void initialize() {
		try{
			//좌상 아이디 리스트
			String param = "b_id="+URLEncoder.encode(UserInfo.getInstance().getId(),"UTF-8")+"&b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8"); 
			String urlInfo = "http://localhost:8080/buengbueng/fxEmployeeManage.do";
			
			String jsonString = ConnectServer.connectS(param, urlInfo);
			
			JSONParser jsonParser = new JSONParser();
			JSONArray jsonEid = new JSONArray();
			jsonEid = (JSONArray)jsonParser.parse(jsonString);
			JSONObject jsonObj = null;
			for (int i = 0 ; i < jsonEid.size(); i++){
				jsonObj = (JSONObject)jsonEid.get(i);
			}
			System.out.println("================================");
			
			EmployeeList eDto = new EmployeeList();
			for(int i = 0;i<jsonEid.size(); i++){
				jsonObj = (JSONObject)jsonEid.get(i);
				eDto.setE_id((String)jsonObj.get("e_id"));
				e_idListData.add(eDto);
			}

			e_id.setCellValueFactory(new PropertyValueFactory<EmployeeList,String>("e_id")); //테이블 컬럼 이름과 형식
			
			
			//TABLE을 VIEW에 포함하기
			e_idListTable.setItems(e_idListData);
			
			idInsertApplyBtn = new Button();
			idInsertApplyBtn.setOnMouseClicked(new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent event) {
					//여기서나는 신청 수와 신청사유를 가져갈 것이야
					try{
						String param = "b_key="+URLEncoder.encode(UserInfo.getInstance().getB_key(),"UTF-8")
								+"&what="+URLEncoder.encode("return","UTF-8");
						String urlInfo = "http://localhost:8080/buengbueng/employeeAddPro.do";
						ConnectServer.connect(param, urlInfo);
					}catch(UnsupportedEncodingException uee){
						uee.printStackTrace();
					}
				}
			});	
					idInsertApply();
			
					
			
			
			
			
			//각종 VIEW 생성
			splitVertical = new SplitPane();
			splitLeftHorizon = new SplitPane();
			splitRightHorizon  = new SplitPane();
			e_idListSection = new AnchorPane();
			employeeInfoSection = new AnchorPane();
			
			//각종 VIEW 연동
			e_idListSection.getChildren().add(e_idListTable);
			
			splitVertical.getItems().add(e_idListSection);//좌상
			splitVertical.getItems().add(employeeInfoSection);//좌하
			
			employeeManage.getChildren().add(splitVertical);
			
			//좌상 추가신청 폼
			
			//좌상 삭제신청 폼
			
			//좌상 신청중인 아이디개수
			
			//좌상 보유중인 아이디개수
			
			//좌하 알바 신상 현황
			
			//우상 달력
			
			//우하 근무일정
			
			//우하 근무비 지금 대장
			
			
		}catch(Exception e ){e.printStackTrace();}
	}
	
	
	public void idInsertApply(){
		
		
	}
	
}
