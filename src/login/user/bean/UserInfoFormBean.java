package login.user.bean;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import valid.all.bean.CheckInfo;

@Controller
public class UserInfoFormBean {
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	@Autowired
	public CheckInfo CheckInfo;
	
	@RequestMapping("userInfoForm.do")
	public String userInfoForm(HttpSession session, Model model){
		String id = (String)session.getAttribute("loginId");
		UserInfoDataBean user = (UserInfoDataBean)sqlMap.queryForObject("test.getUserInfo", id);
		model.addAttribute("user", user);
		return "/userInfo/userInfoForm";
	}
	
	
	//----- 회원 정보 수정 페이지로 -----
	@RequestMapping("userInfoFormUpdate.do")
	public String userInfoFormUpdate(){
		
		return "/userInfo/userInfoFormUpdate";
	}
	
	//----- 회원 정보 수정 -----
	@RequestMapping("userInfoFormUpdatePro.do")
	public String userInfoFormUpdatePro(UserInfoDataBean dto, Model model){
		//정보수정 결과 확인 변수
		int check = -1;
		
		//유효성 검사, 비밀번호가 같은지 확인
		int validCheck = CheckInfo.pwCheck(dto);
		
		if(validCheck == 1){
			try{
			//회원정보를 받아와 DB정보를 UPDATE 함.
				sqlMap.update("test.userInfoUpdate", dto);
				check = 1; // 정보 수정 완료
			}catch(RuntimeException e){
				e.printStackTrace();
				check = 2; // 실행 오류
			}
		}else{
			check = 3; //비밀번호가 틀림
		}
		
		//정보 수정 결과를 return
		model.addAttribute("check", check);
		
		return "/userInfo/userInfoFormUpdatePro";
	}
	
}
