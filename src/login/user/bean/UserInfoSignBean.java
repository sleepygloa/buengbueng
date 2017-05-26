package login.user.bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import valid.all.bean.CheckInfo;

@Controller
public class UserInfoSignBean {
	@Autowired
	private CheckInfo checkInfo;
	@Autowired
	private SqlMapClientTemplate sqlMap;
	/* 회원 가입 페이지 */
	@RequestMapping("userInfoSignForm.do")
	public String signForm(){
		return "/userInfo/userInfoSignForm";
	}
	
	/* 회원 가입 시 아이디 중복 확인 페이지 */
	@RequestMapping("userInfoSignCheckId.do")
	public String signCheckId(String id, Model model){
		// 아이디 유효성 검사
		int validCheck = checkInfo.idCheck(id);
		if(validCheck == 1){ // 아이디 있음 -> 중복!
			model.addAttribute("result", "idF");
		}else{ // 아이디 없음 -> 사용 가능!
			model.addAttribute("result", "idT");
		}
		model.addAttribute("id", id);
		return "/userInfo/userInfoSignCheckId";
	}
	
	/* 회원 가입 정보 DB에 저장 페이지 */
	@RequestMapping("userInfoSignPro.do")
	public String signPro(UserInfoDataBean dto, HttpServletRequest request, HttpSession session){
		String phone = request.getParameter("phone_1")+"-"+request.getParameter("phone_2")+"-"+request.getParameter("phone_3"); // 전화번호를 dto에 저장
		dto.setPhone(phone);
		try{
			sqlMap.insert("test.userInfoInsert", dto);	// DB에 회원 가입 정보 추가하기
			session.setAttribute("loginId", dto.getId());	// 회원 가입 완료된 id를 세션으로 사용
			request.setAttribute("result", "succ");	// 성공적으로 회원 가입이 완료됨을 알림
		}catch(Exception e){	// DB에 회원 가입 정보 INSERT 시 에러 발생하면 아래 코드 실행
			e.printStackTrace();	// 에러 상황 콘솔에 알림
			request.setAttribute("result", "fail");	// 회원 가입이 실패했음을 알림
		}
		return "/userInfo/userInfoSignPro";
	}
}
