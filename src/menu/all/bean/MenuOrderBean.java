package menu.all.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.SqlMapTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MenuOrderBean {
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	@RequestMapping("menuOrderListForm.do")
	public String menuOrderListForm(){
		
		return "/menu/menuOrderListForm";
	}
}
