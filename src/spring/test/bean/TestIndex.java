package spring.test.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestIndex {
	
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	@RequestMapping("testIndex.do")
	public String testIndex(){
		return "/test/index";
	}
	
	

}
