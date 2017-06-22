package superclass.all.bean;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import manage.boss.bean.FranchiseeDataDTO;

@Controller
public class FranchiseeSelect {

	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	@RequestMapping("franchiseeSelect.do")
	public String franchiseeSelect(HttpSession session, String b_key){
		
		if(session.getAttribute(b_key) != null){
			session.removeAttribute("b_key");
		}
		session.setAttribute("b_key", b_key);
		
		return "sidemenu";
				
	}
	
	@RequestMapping("franchiseeSelectList.do")
	public String franchiseeList(HttpSession session,String id,Model model){
		List<FranchiseeDataDTO> list = new ArrayList();
		FranchiseeDataDTO fdto= null;
		//알바생 아이디검사
		if(id.contains("employee")){
			try{
				list.add((FranchiseeDataDTO)sqlMap.queryForObject("erpEmp.getEidBkey", id));
				fdto = (FranchiseeDataDTO)list;
				session.setAttribute("b_key", fdto.getB_key());
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			list = sqlMap.queryForList("franchisee.getFirstFranchiseeInfo", id);
		}
		

		model.addAttribute("flist",list);
		
		return "/bossERP/employeeManage/franchiseeList";
	}
}
