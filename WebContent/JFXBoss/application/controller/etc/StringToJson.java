package application.controller.etc;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StringToJson {

	
	//String 을 받아 JSONArray 로 변환 시키는 메서드
	public JSONArray stringToJsonArray(String jsonString){
		JSONParser jsonParser = new JSONParser();
		JSONArray jsonEid = new JSONArray();
		
		try{
			jsonEid = (JSONArray)jsonParser.parse(jsonString);
		}catch(Exception e){
			e.printStackTrace();
		}
			
		return jsonEid;
	}

	//JSONArray를 받아JSONObject로 변환시키는 메서드
	public ObservableList jsonArrayToJsonObject(JSONArray jsonArray, String eDtoString){
		JSONObject jsonObj = new JSONObject();
		ObservableList data =FXCollections.observableArrayList();
		
		try{
			for (int i = 0 ; i < jsonArray.size(); i++){
				jsonObj = (JSONObject)jsonArray.get(i);
			}
			
			EmployeeList eDto1 = null;
			EmployeeTotalIdInfoList eDto2 = null;
			for(int i = 0;i<jsonArray.size(); i++){
				if(eDtoString.equals("EmployeeList")){
					eDto1 = new EmployeeList();
					jsonObj = (JSONObject)jsonArray.get(i);
					eDto1.setE_id((String)jsonObj.get("e_id"));
					data.add(eDto1);
				}else if(eDtoString.equals("EmployeeTotalIdInfoList")){
					eDto2 = new EmployeeTotalIdInfoList();
					jsonObj = (JSONObject)jsonArray.get(i);
						eDto2.setTotalId((String)jsonObj.get("totalId"));
						eDto2.setTotalName((String)jsonObj.get("totalName"));
						eDto2.setTotalBirth((String)jsonObj.get("totalBirth"));
						eDto2.setTotalPhone((String)jsonObj.get("totalPhone"));
						eDto2.setTotalAddress((String)jsonObj.get("totalAddress"));
						eDto2.setTotalEmail((String)jsonObj.get("totalEmail"));
						eDto2.setTotalGoogleId((String)jsonObj.get("totalGoogleId"));
					data.add(eDto2);
				}
				

			}
			
			
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
			
		return data;
	}
	
	
}
