package erp.boss.bean;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import login.user.bean.UserInfoDataDTO;

@Controller
public class BossErpManageBean {

	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	@RequestMapping("bossErpManageMain.do")
	public String bossEmployeeInfoMain(Model model,HttpSession session){
		
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		model.addAttribute("sidemenuCheck", sidemenuCheck);
		model.addAttribute("sidemenu", sidemenu);
		
		String id = (String)session.getAttribute("loginId");
		
		model.addAttribute("id",id);
		
		return "/bosserpmanage/bossErpManageMain";
	}
}
