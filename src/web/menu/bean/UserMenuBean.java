package web.menu.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserMenuBean {

	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	//사용자 메뉴의 메인페이지로이동  
	@RequestMapping("userpcuseMain.do")
	public String userpcusemain(Model model){
		
		String indexV = "사용자가메뉴에접근";
		
		//템블릿으로 사용할 변수 지정
		model.addAttribute("indexV", indexV);
		
		return "/index";
	}
	
}
