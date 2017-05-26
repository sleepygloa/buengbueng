package login.user.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserInfoFormBean {
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	@RequestMapping("userInfoForm.do")
	public String userInfoForm(String id, Model model){
		UserInfoDataBean user = (UserInfoDataBean)sqlMap.queryForObject("test.getUserInfo", id);
		model.addAttribute("user", user);
		return "/userInfo/userInfoForm";
	}
}
