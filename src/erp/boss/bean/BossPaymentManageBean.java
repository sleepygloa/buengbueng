package erp.boss.bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BossPaymentManageBean {

	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	//사장님 PC방 장부 페이지
	@RequestMapping("bossEmployeeAccountManage.do")
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
		
		//알바생 정보를 불러옵니다. 
		
		String minDate = "2017-06-08 00:00:00";
		String maxDate = "2017-06-08 24:00:00";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try{
			
			HashMap map = new HashMap();
			map.put("minDate", minDate);
			map.put("maxDate", maxDate);
			map.put("id", id);
			
			ArrayList ewcList = new ArrayList(); //알바일한시간 계산리스트, ewc = employeeWorkCount
			ewcList = (ArrayList)sqlMap.queryForList("erpEmp.employeeWorkCount", map);
			
			model.addAttribute("ewcList",ewcList);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		

		
		
		
		return "/bosserpmanage/bossEmployeeAccountManage";
	}
	
}
