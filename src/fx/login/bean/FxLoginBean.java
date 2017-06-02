package fx.login.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import login.user.bean.UserInfoDataDTO;

@Controller
public class FxLoginBean {
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	@RequestMapping("fxLoginPro.do")
	public String fxLoginPro(UserInfoDataDTO dto, Model model){
		UserInfoDataDTO info = (UserInfoDataDTO)sqlMap.queryForObject("test.getUserInfo", dto.getId());
		if(info.getPw().equals(dto.getPw())){
			model.addAttribute("result", info.getId());
			model.addAttribute("grade", info.getGrade());
		}else{
			model.addAttribute("result", "fail");
		}
		return "/fxUserInfo/fxLoginPro";
	}
}
