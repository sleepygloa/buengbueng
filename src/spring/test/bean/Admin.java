package spring.test.bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Admin {

	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	
	@RequestMapping("ad_insview.do")
	public ModelAndView testIndex(){
		return new ModelAndView("/test/admin/ad_emInsert");
	}
	
	
	
}
