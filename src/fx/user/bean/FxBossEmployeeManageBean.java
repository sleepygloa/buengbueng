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
	public String fxEmployeeCommute(Model model, String b_key, String b_id){
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
