package erp.boss.bean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BossEmployeeManageBean3 {

	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	//알바생 출근하기
	//알바생이 계획된 시간이 아니면 출근하지 못한다.
	@RequestMapping("employeeCommute.do")
	public String employeeCommute(HttpSession session, Model model, EmployeeWorkTimeDTO ewtDTO){
		
		String e_id = (String)session.getAttribute("loginId");
		String b_key = (String)session.getAttribute("b_key");
		
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		model.addAttribute("sidemenuCheck", sidemenuCheck);
		model.addAttribute("sidemenu", sidemenu);
		//변수들을 페이지로 전달
		
		Timestamp commuteTime = null;
		int checkCommute = 1; //1. 출근, 2. 퇴근
		
		//1. 출근 유효성검사 : 출근 10분전에만 인수인계를 위해 출근 할 수 있다.
		try{
			ewtDTO = (EmployeeWorkTimeDTO)sqlMap.queryForObject("erpEmp.employeeCommuteCheck", e_id);
			
			if(ewtDTO == null){
				int check = 10;
				model.addAttribute("check", check);
				return "/bossERP/employeeManage/employeeCalender";
			}else if(ewtDTO.getResult() != 0){
				ewtDTO = (EmployeeWorkTimeDTO)sqlMap.queryForObject("erpEmp.getCommute", ewtDTO);
				int check = -1;
				model.addAttribute("check", check);
			}else{
				//2.출근로그
				sqlMap.insert("log.insertEmployeeCommuteLog", ewtDTO);
				//3.출근상태로 변경
				sqlMap.insert("erpEmp.insertEmployeeCommute", ewtDTO);
				sqlMap.update("erpEmp.updateEmployeeCommute", e_id);
				ewtDTO = (EmployeeWorkTimeDTO)sqlMap.queryForObject("erpEmp.getCommute", ewtDTO);
			}
			commuteTime = ewtDTO.getCommuteTime();
			
			model.addAttribute("commuteTime", commuteTime);
			model.addAttribute("checkCommute", checkCommute);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "/bossERP/employeeManage/employeeCommute";
	}

	//알바생 퇴근하기
	//알바생이 계획된 시간이 아니어도, 지나도, 계획한 시간만큼 일한 것으로 처리한다.
	@RequestMapping("employeeOffWork.do")
	public String employeeOffWork(HttpSession session, Model model, EmployeeWorkTimeDTO ewtDTO){
		
		String e_id = (String)session.getAttribute("loginId");
		String b_key = (String)session.getAttribute("b_key");
		
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		model.addAttribute("sidemenuCheck", sidemenuCheck);
		model.addAttribute("sidemenu", sidemenu);
		//변수들을 페이지로 전달
		
		Timestamp commuteTime = null;
		int checkCommute = 2; //1. 출근, 2. 퇴근
		
		//1. 퇴근 유효성검사 : 퇴근 10후전에만 인수인계를 위해 퇴근 할 수 있다.
		try{
			ewtDTO = (EmployeeWorkTimeDTO)sqlMap.queryForObject("erpEmp.employeeOffWorkCheck", e_id);
			
			if(ewtDTO == null){
				int check = 10;
				model.addAttribute("check", check);
				return "/bossERP/employeeManage/employeeCalender";
			}else if(ewtDTO.getResult() == 2){
				ewtDTO = (EmployeeWorkTimeDTO)sqlMap.queryForObject("erpEmp.getCommute", ewtDTO);
				int check = -1;
				model.addAttribute("check", check);
			}else{
				//2.퇴근
				sqlMap.update("log.updateEmployeeCommuteLog", ewtDTO);
				//3.퇴근 상태로 변경, 계획된 퇴근시간을 넘으면 초과 시간으로 표시한다.
				sqlMap.update("erpEmp.updateEmployeeOffWork", ewtDTO);
				sqlMap.update("erpEmp.updateEmployeeOffWork2", e_id);
				ewtDTO = (EmployeeWorkTimeDTO)sqlMap.queryForObject("erpEmp.getCommute", ewtDTO);
			}
			commuteTime = ewtDTO.getCommuteTime();
			
			model.addAttribute("commuteTime", commuteTime);
			model.addAttribute("checkCommute", checkCommute);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "/bossERP/employeeManage/employeeCommute";
	}
	
	//사장님은 알바생, 알바생은 알바생 출퇴근이력확인하기
	//
	@RequestMapping("employeeWorkTimeList.do")
	public String employeeWorkTimeList(HttpSession session, Model model, EmployeeWorkTimeDTO ewtDTO){
		
		String id = (String)session.getAttribute("loginId");
		String b_key = (String)session.getAttribute("b_key");
		
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		model.addAttribute("sidemenuCheck", sidemenuCheck);
		model.addAttribute("sidemenu", sidemenu);
		//변수들을 페이지로 전달
		
		try{
			int check = (Integer)sqlMap.queryForObject("erpEmp.getUserGrade", id);//알바인지, 사장님인지 구분한다.
			//리스트를 뽑는다.
			List list = new ArrayList();
			
			if(check == 1){
				//사장님이면	
				list = (List)sqlMap.queryForList("erpEmp.getEmployeeWorkTimeList", id);
			}else if(check == 2){
				//알바생이면				
				id = (String)sqlMap.queryForObject("erpEmp.getEidBid", id);
				list = (List)sqlMap.queryForList("erpEmp.getEmployeeWorkTimeList", id);
			}else{}
		
			model.addAttribute("list", list);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "/bossERP/employeeManage/employeeWorkTimeList";
	}	
	
}
