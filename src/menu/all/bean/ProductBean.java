package menu.all.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ProductBean {
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	
}
