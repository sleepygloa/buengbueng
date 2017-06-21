package superclass.all.bean;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String franchiseeList(String id,Model model){
		List list = new ArrayList();
		
		list = sqlMap.queryForList("franchisee.getFirstFranchiseeInfo", id);
		model.addAttribute("flist",list);
		
		return "/bossERP/employeeManage/franchiseeList";
	}
}
