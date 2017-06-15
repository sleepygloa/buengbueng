package superclass.all.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;

import login.user.bean.UserInfoDataDTO;

@Controller
public class MenuCategoryDivResponse {
	public  String MenuCategoryDivResponse(List array){
		
		int divWidth = 12;
		
		switch (array.size()){
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
			
		
		for(int i = 0; i < array.size(); i ++){
			menu += "<div style='border:solid 1px black' class='col-xs-" +divWidth + "-12 col-sm-" +divWidth + "-12 col-md-" +divWidth + "-12' >";
			dto =  (UserInfoDataDTO)array.get(i);
			menu += "<span  onclick=\"getInfo(\'"+dto.getId()+"\')\">"+ dto.getId()+" : "+dto.getName()+"</span>";
			menu += "</div>";
		}
		
		return menu;
	}
}
