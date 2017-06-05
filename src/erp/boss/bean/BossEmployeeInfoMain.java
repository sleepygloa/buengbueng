package erp.boss.bean;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BossEmployeeInfoMain {

	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	
	//사장님 알바생관리 메인 페이지
	@RequestMapping("bossEmployeeInfoMain.do")
	public String bossEmployeeInfoMain(Model model, HttpSession session){
		
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		model.addAttribute("sidemenuCheck", sidemenuCheck);
		model.addAttribute("sidemenu", sidemenu);
		//변수들을 페이지로 전달
		
		//세션 아이디를 페이지로전달
		String id = (String)session.getAttribute("loginId");
		model.addAttribute("id",id);
		
		
		return "/bosserpmanage/bossEmployeeManageMain";
	}
	
	//사장님 알바생 추가 페이지로이동
	@RequestMapping("bossEmployeeAdd.do")
	public String bossEmployeeAdd(Model model, HttpSession session){
		
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		model.addAttribute("sidemenuCheck", sidemenuCheck);
		model.addAttribute("sidemenu", sidemenu);
		//변수들을 페이지로 전달
		
		//세션 아이디를 페이지로전달
		String id = (String)session.getAttribute("loginId");
		model.addAttribute("id",id);
		
		return "/bosserpmanage/bossEmployeeAdd";
	}
	
	//사장님 알바생 추가[처리] 페이지로 이동
	@RequestMapping("bossEmployeeAddPro.do")
	public String bossEmployeeAddPro(Model model, HttpSession session, BossEmployeeInfoDataDTO beDTO){
		
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		model.addAttribute("sidemenuCheck", sidemenuCheck);
		model.addAttribute("sidemenu", sidemenu);
		//변수들을 페이지로 전달
		
		//세션 아이디를 페이지로전달
		String id = (String)session.getAttribute("loginId");
		model.addAttribute("id",id);
		
		int check = 0;
		
		//로그인 하지 않았을때 그냥 폼은 보여주지만, 아무것도할수없다.
		if(id == null){
			check = 9; //비회원이 싸이트로 접속했을때.
			return "/bosspcuse/franchiseeAddPro";
		}
		
		try{
			//입력된 정보를 로그에 남겨줍니다.
			sqlMap.insert("erpEmp.insertBossEmployeeAddLog", beDTO);
			
			check = 1;
		}catch(Exception e){
			check = 2;
			e.printStackTrace();
		}
	
	model.addAttribute("check", check);
		
			return "/bosserpmanage/bossEmployeeAddPro";
	}	
	
}
