package login.user.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserInfoBean {

	//sql을 연결 시켜주는 변수
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	@RequestMapping("test.do")
	public String test(Model model){
		UserInfoDataBean dto = (UserInfoDataBean)sqlMap.queryForObject("test.loginCheck", null);
		System.out.println(dto.getId());
		model.addAttribute("dto",dto);

		return "/userInfo/test";
	}
	
}
