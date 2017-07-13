package fx.user.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import erp.boss.bean.EmployeeWorkTimeDTO;

@Controller
public class FxBossEmployeeManageBean {

	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	//1. 좌상
	@RequestMapping("fxEmployeeIdList.do")
	public String fxEmployeeManage(Model model, String b_key, String b_id){
		System.out.println("연결됐음:");
		ModelAndView mv = new ModelAndView();
		try{
		HashMap map = new HashMap();
		map.put("id", b_id);
		map.put("b_key", b_key);
		
		List list = new ArrayList();
		list = (List)sqlMap.queryForList("erpEmp.getFxEmployeeList", map);
		model.addAttribute("list",list);
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonList = mapper.writeValueAsString(list);
		//굳이 ModelAndView를 사용했다. String으로 반환해도되는데
		model.addAttribute("jsonList", jsonList);
		
		}catch(Exception e){e.printStackTrace();}
		
		return "/fxBossERP/fxEmployeeManageJson";
	}
	
	//1. 좌상
	@RequestMapping("fxEmployeeIdListCount.do")
	public String fxEmployeeIdListCount(Model model, String b_key, String b_id){
		System.out.println("연결됐음:");
		ModelAndView mv = new ModelAndView();
		try{
		HashMap map = new HashMap();
		map.put("id", b_id);
		map.put("b_key", b_key);
		
		List list = new ArrayList();
		list = (List)sqlMap.queryForList("erpEmp.getFxEmployeeList", map);
		model.addAttribute("list",list);
		ObjectMapper mapper = new ObjectMapper();
		String jsonList = mapper.writeValueAsString(list);
		//굳이 ModelAndView를 사용했다. String으로 반환해도되는데
		model.addAttribute("jsonList", jsonList);
		
		}catch(Exception e){e.printStackTrace();}
		
		return "/fxBossERP/fxEmployeeManageJson";
	}
	
	//1.좌상
	@RequestMapping("fxEmployeeCommute.do")
	public String fxEmployeeCommute(Model model, String b_key, String e_id){
		System.out.println("Bean 출근 처리 연결됐음:");
		String jsonList = null;
		EmployeeWorkTimeDTO ewtDTO = null;
		try{
			ewtDTO = (EmployeeWorkTimeDTO)sqlMap.queryForObject("erpEmp.employeeCommuteCheck", e_id);
			if( ewtDTO != null){
				//2.출근로그
				sqlMap.insert("log.insertEmployeeCommuteLog", ewtDTO);
				//3.출근상태로 변경
				sqlMap.insert("erpEmp.insertEmployeeCommute", ewtDTO);
				sqlMap.update("erpEmp.updateEmployeeCommute", e_id);
				jsonList = "1"; //출근 되었음.
			}
			jsonList = "2"; //출근처리안됨.
			model.addAttribute("jsonList", jsonList);
		
		}catch(Exception e){e.printStackTrace();
		}
		
		return "/fxBossERP/fxEmployeeManageJson";
	}
	
	//1.좌상
	@RequestMapping("fxEmployeeOffWork.do")
	public String fxEmployeeOffWork(Model model, String b_key, String e_id){
		System.out.println("Bean 퇴근 처리 연결됐음:");
		String jsonList = null;
		EmployeeWorkTimeDTO ewtDTO = null;
		try{
			ewtDTO = (EmployeeWorkTimeDTO)sqlMap.queryForObject("erpEmp.employeeOffWorkCheck", e_id);
			if( ewtDTO != null){
				//2.퇴근
				sqlMap.update("log.updateEmployeeCommuteLog", ewtDTO);
				//3.퇴근 상태로 변경, 계획된 퇴근시간을 넘으면 초과 시간으로 표시한다.
				sqlMap.update("erpEmp.updateEmployeeOffWork", ewtDTO);
				sqlMap.update("erpEmp.updateEmployeeOffWork2", e_id);
				jsonList = "1"; //퇴근되었음.
			}
			jsonList = "2"; //퇴근처리안됨.
			model.addAttribute("jsonList", jsonList);
		
		}catch(Exception e){e.printStackTrace();
		}
		
		return "/fxBossERP/fxEmployeeManageJson";
	}
	
	//1. 좌상
	@RequestMapping("fxEmployeeWorkList.do")
	public String fxEmployeeWorkList(Model model, String b_key, String b_id){
		String jsonList = null;
		
		HashMap map = new HashMap();
		map.put("b_key", b_key);
		map.put("b_id", b_id);
		
		try{
			List list = new ArrayList();
			list = (List)sqlMap.queryForList("erpEmp.getFxEmployeeWorkList", map);
			
			model.addAttribute("list",list);
			ObjectMapper mapper = new ObjectMapper();
			jsonList = mapper.writeValueAsString(list);
			//굳이 ModelAndView를 사용했다. String으로 반환해도되는데
			model.addAttribute("jsonList", jsonList);
			}catch(Exception e){e.printStackTrace();}
			
			return "/fxBossERP/fxEmployeeManageJson";
	}
	
	//2. 좌하
	@RequestMapping("fxEmployeeTotalIdList.do")
	public String fxEmployeeTotalIdList(Model model, String b_key, String b_id){
		System.out.println("연결됐음:");
		ModelAndView mv = new ModelAndView();
		try{
		
		List list = new ArrayList();
		list = (List)sqlMap.queryForList("erpEmp.getFxEmployeeTotalIdList", b_key);
		model.addAttribute("list",list);
		ObjectMapper mapper = new ObjectMapper();
		String jsonList = mapper.writeValueAsString(list);
		//굳이 ModelAndView를 사용했다. String으로 반환해도되는데
		model.addAttribute("jsonList", jsonList);
		
		}catch(Exception e){e.printStackTrace();}
		
		return "/fxBossERP/fxEmployeeManageJson";
	}
	
	//4. 우하
	@RequestMapping("fxEmployeeCommuteList.do")
	public String fxEmployeeCommuteList(Model model, String b_key, String b_id){
		System.out.println("연결됐음:");
		ModelAndView mv = new ModelAndView();
		try{
		
		List list = new ArrayList();
		list = (List)sqlMap.queryForList("erpEmp.getFxEmployeeCommuteList", b_key);
		model.addAttribute("list",list);
		ObjectMapper mapper = new ObjectMapper();
		String jsonList = mapper.writeValueAsString(list);
		//굳이 ModelAndView를 사용했다. String으로 반환해도되는데
		model.addAttribute("jsonList", jsonList);
		
		}catch(Exception e){e.printStackTrace();}
		
		return "/fxBossERP/fxEmployeeManageJson";
	}
	
	//4. 우하
	@RequestMapping("fxEmployeePayList.do")
	public String fxEmployeePayList(Model model, String b_key, String b_id){
		System.out.println("연결됐음:");
		ModelAndView mv = new ModelAndView();
		try{
		
		List list = new ArrayList();
		list = (List)sqlMap.queryForList("erpEmp.getFxEmployeePayList", b_key);
		model.addAttribute("list",list);
		ObjectMapper mapper = new ObjectMapper();
		String jsonList = mapper.writeValueAsString(list);
		//굳이 ModelAndView를 사용했다. String으로 반환해도되는데
		model.addAttribute("jsonList", jsonList);
		}catch(Exception e){e.printStackTrace();}
		
		return "/fxBossERP/fxEmployeeManageJson";
	}
	
	
}
