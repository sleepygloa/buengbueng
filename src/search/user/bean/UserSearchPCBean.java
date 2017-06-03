package search.user.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserSearchPCBean {
	
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	
	//대메뉴에서 '사장님 가맹점 관리 버튼 클릭시' 이동
	@RequestMapping("searchPCForm.do")
	public String searchPC(Model model){
		
		//사이드메뉴 템플릿
		int sidemenu = 2;
		model.addAttribute("sidemenu", sidemenu);
		
		return "/searchPC/searchPCForm";
	}
	
	
}
