package superclass.all.bean;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class SuperClass {

	//사이드메뉴 템플릿
	public void sideMenuTemp(Model model,int sidemenuCheck, int sidemenu){
		
		model.addAttribute("sidemenuCheck", sidemenuCheck);
		model.addAttribute("sidemenu", sidemenu);
		//변수들을 페이지로 전달
	}

	//세션아이디 불러오기 템플릿 (ID)
	public String getSessionIdModelId(Model model, HttpSession session){
		
		String id = (String)session.getAttribute("loginId");
		model.addAttribute("id",id);
		
		return id;
	}
	
	//세션아이디 불러오기 템플릿(B_ID)
	public String getSessionBidModelBid(Model model, HttpSession session){
		
		String b_id = (String)session.getAttribute("loginId");
		model.addAttribute("b_id",b_id);
		
		return b_id;
	}
	
}
