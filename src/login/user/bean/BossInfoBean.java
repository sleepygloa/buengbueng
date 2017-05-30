package login.user.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BossInfoBean {
	
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	@RequestMapping("bossInfoSignForm.do")
	public String bossInfoSign(){
		return "/userInfo/bossInfoSignForm";
	}
}
