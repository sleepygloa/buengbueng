package login.user.bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	@RequestMapping("loginForm.do")
	public String loginForm(){
		return "/userInfo/userInfoLogin";
	}
	
	@RequestMapping("login.do")
	public String login(HttpServletRequest request,HttpSession session){
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		UserInfoDataBean dto = (UserInfoDataBean)sqlMap.queryForObject("test.getUserInfo", id);
		if(pw.equals(dto.getPw())){
			session.setAttribute("loginId", dto.getId());
		}
		return "/userInfo/userInfoMain";
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session){
		session.invalidate();
		return "/userInfo/userInfoLogin";
	}

	@RequestMapping("userInfoSearchIdForm.do")
	public String SearchId(){
		return "/userInfo/userInfoSearchIdForm";
	}

	@RequestMapping("userInfoSearchIdFormPro.do")
	public String SearchIdPro(UserInfoDataBean dto, HttpServletRequest request){
		int check = -1;
		String id = (String)sqlMap.queryForObject("checkInfo.SearchId",dto);
		if(id==null){
			check = 0;
		}else{
			check = 1;
		}
		request.setAttribute("id",id);
		request.setAttribute("check", check);
		
		return "/userInfo/userInfoSearchIdFormPro";
	}
	
	@RequestMapping("userInfoSearchPwForm.do")
	public String SearchPw(){
		return "/userInfo/userInfoSearchPwForm";
	}

	@RequestMapping("userInfoSearchPwFormPro.do")
	public String SearchPwPro(UserInfoDataBean dto, HttpServletRequest request){
		int check = -1;
		String pw = (String)sqlMap.queryForObject("checkInfo.SearchPw",dto);
		if(pw==null){
			check = 0;
		}else{
			check = 1;
		}
		request.setAttribute("pw",pw);
		request.setAttribute("check", check);
		
		return "/userInfo/userInfoSearchPwFormPro";
	}
}
