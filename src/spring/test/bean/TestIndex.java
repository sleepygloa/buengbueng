package spring.test.bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.test.bean.EmpDTO;

@Controller
public class TestIndex {
	
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	@RequestMapping("testIndex.do")
	public String testIndex(){
		return "/test/index";
	}
	
	@RequestMapping("mainview.do")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//세션을 불러옵
		HttpSession session = request.getSession();
		EmpDTO edto = (EmpDTO)session.getAttribute("emp");
		
		//dto가 없을때 관리자로 로그인
		if(edto==null)
		{
			return new ModelAndView("test/admin/ad_main");
		}
		
		//직종번호가 5상일때, 사원으로 로그인
		if(edto.getEmp_jobno() >= 5){
			return new ModelAndView("test/head/hd_main");
		} else{
			return new ModelAndView("test/employee/em_main");
		}
	
	
	}
	

}
