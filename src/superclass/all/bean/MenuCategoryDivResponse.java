package superclass.all.bean;

import java.util.ArrayList;
import java.util.HashMap;

import login.user.bean.UserInfoDataDTO;

public class MenuCategoryDivResponse {
	public static String MenuCategoryDivResponse(int idCount, ArrayList array){
		
		int divWidth = 12;
		
		switch (idCount){
			case 1 : divWidth = 12;break;
			case 2 : divWidth = 6;break;
			case 3 : divWidth = 4;break;
			case 4 : divWidth = 3;break;
			case 5 : divWidth = 2;break;
			case 6 : divWidth = 2;break;
			case 7 : divWidth = 1;break;
			case 8 : divWidth = 1;break;
			case 9 : divWidth = 1;break;
			case 10 : divWidth = 1;break;
			case 11 : divWidth = 1;break;
		} 
		
		String menu = "";
		UserInfoDataDTO dto = null;
		HashMap map = new HashMap();
		
		
		for(int i = 0; i < array.size(); i ++){
			menu += "<div class='col-xs-" +divWidth + "-12 col-sm-" +divWidth + "-12 col-md-" +divWidth + "-12' >";
			dto =  (UserInfoDataDTO)array.get(i);
			menu += "<span><a href='bossEmployeeInfo.do?id="+ dto.getId() +"'>"+dto.getName()+"</a></span>";
			menu += "</div>";
		}
		
		return menu;
	}
}
