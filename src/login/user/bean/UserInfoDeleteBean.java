package login.user.bean;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserInfoDeleteBean {
	@RequestMapping("userInfoDeleteForm.do")
	public String deletrForm(){
		return "userInfo/userInfoDeleteForm";
	}
	
	@Autowired
	private SqlMapClientTemplate sqlMap;
	@RequestMapping("userInfoDeletePro.do")
	public String deletePro(HttpSession session, String pw, Model model){
		int check=0;
		String id = (String)session.getAttribute("loginId");
		String asd = (String)sqlMap.queryForObject("test.checkPasswd",id);
		if(asd.equals(pw)){
			try{
				sqlMap.delete("test.deleteUserInfo",id);
				session.invalidate();
				check=1;
				System.out.println(check);
				model.addAttribute("check",check);
			}catch(Exception e){e.printStackTrace();
		}
	  }		
		return "userInfo/userInfoDeletePro";
	}

}
