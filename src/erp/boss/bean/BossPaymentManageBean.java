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
		
		//////////////////////////////////////////
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		model.addAttribute("sidemenuCheck", sidemenuCheck);
		model.addAttribute("sidemenu", sidemenu);
		//변수들을 페이지로 전달
		
		//////////////////////////////////////////
		//세션 아이디를 페이지로전달
		String id = (String)session.getAttribute("loginId");
		model.addAttribute("id",id);
		
		////////////////////////////////////////////////////
		//일하고있는 시간은 초단위로 정보를 불러온다.
		
		//검색 변수로 받을 DATE, 현재는 금일로만 지정이되어있음
		String minDate = "2017-06-08 00:00:00";
		String maxDate = "2017-06-08 24:00:00";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try{
			
			HashMap map = new HashMap();
			map.put("minDate", minDate);
			map.put("maxDate", maxDate);
			map.put("id", id);
			
			ArrayList ewcList = new ArrayList(); //알바일한시간 계산리스트, ewc = employeeWorkCount
			//알바생이 일정 기간 일을했다면, 중복되는 사람의 아이디를 그룹화하여 합치고, 그만큼의 일한 수를 계산하여 반환한다. 기간중 최초 로그인한날짜를 반환한다(yyyy-mm-dd) 
			ewcList = (ArrayList)sqlMap.queryForList("erpEmp.employeeWorkCount", map);
			
			model.addAttribute("ewcList",ewcList);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		

		
		
		
		return "/bosserpmanage/bossEmployeeAccountManage";
	}
	
}
