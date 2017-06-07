package login.user.bean;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import superclass.all.bean.CheckInfo;
import superclass.all.bean.FindIpBean;

@Controller
public class UserInfoBean {

	//유효성 검사에 사용되는 변수
	@Autowired
	public CheckInfo CheckInfo;
	
	//sql을 연결 시켜주는 변수
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	//로그인 클릭시 로그인 페이지로 이동
	@RequestMapping("loginForm.do")
	public String loginForm(){
		return "/userInfo/userInfoLogin";
	}
	
	//로그인페이지에서 ID/PW 입력후 로그인시 --> 유효성검사 --> 성공:로그인/실패:로그인실패
	@RequestMapping("login.do")
	public String login(HttpServletRequest request,HttpSession session){
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		//ID로 사용자 정보 불러온다음 입력한 PW와 DB의 PW와 비교한다.
		UserInfoDataDTO dto = (UserInfoDataDTO)sqlMap.queryForObject("test.getUserInfo", id);
		if(pw.equals(dto.getPw())){
			session.setAttribute("loginId", dto.getId());
			
			//로그인 LOG 남김
			FindIpBean fib = new FindIpBean();
			String ip = (String)fib.findIp();
			
			HashMap map = new HashMap();
			map.put("id", id);
			map.put("ip", ip);
			sqlMap.insert("erpEmp.insertEmployeeLoginLog", map);
		}
		
		return "/index";
	}
	
	//로그아웃 클릭시 세션이 종료됨 =--> 메인페이지로 이동
	@RequestMapping("logout.do")
	public String logout(HttpSession session){
		
		try{
			//세션 아이디를 페이지로전달
			String id = (String)session.getAttribute("loginId");
			System.out.println(id);
			if(sqlMap.queryForObject("erpEmp.findLoginLogLogoutNull", id) == null){
				System.out.println(id);
				System.out.println("dd");
				sqlMap.update("erpEmp.updateEmployeeLogoutLog", id);
			};
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.invalidate();
		}
		
		

		return "/index";
	}

	//아이디찾기 폼으로 이동
	@RequestMapping("userInfoSearchIdForm.do")
	public String SearchId(){
		return "/userInfo/userInfoSearchIdForm";
	}

	//아이디찾기 유효성검사
	@RequestMapping("userInfoSearchIdFormPro.do")
	public String SearchIdPro(UserInfoDataDTO dto, HttpServletRequest request){
		int check = -1; 
		
		//아이디찾는 Query : 이름, 비밀번호, 전화번호 로 아이디를 찾음
		String id = (String)sqlMap.queryForObject("checkInfo.SearchId",dto);
		if(id==null){
			check = 0; //아이디 찾기 실패
		}else{
			check = 1; //아이디 찾기 성공
		}
		request.setAttribute("id",id);
		request.setAttribute("check", check);
		
		return "/userInfo/userInfoSearchIdFormPro";
	}
	
	//비밀번호찾기 폼으로 이동
	@RequestMapping("userInfoSearchPwForm.do")
	public String SearchPw(){
		return "/userInfo/userInfoSearchPwForm";
	}

	//비밀번호찾기 유효성검사
	@RequestMapping("userInfoSearchPwFormPro.do")
	public String SearchPwPro(UserInfoDataDTO dto, HttpServletRequest request){
		int check = -1;
		
		//비밀번호 찾는 Query : 아이디, 이름, 전화번호로 비밀번호를 찾음.
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
	
	//회원정보에서 삭제시 삭제폼으로 이동
	@RequestMapping("userInfoDeleteForm.do")
	public String deletrForm(){
		return "userInfo/userInfoDeleteForm";
	}
	
	//삭제시 비밀번호 유효성검사를 진행
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
	

	
	@RequestMapping("userInfoForm.do")
	public String userInfoForm(HttpSession session, Model model){
		String id = (String)session.getAttribute("loginId");
		UserInfoDataDTO user = (UserInfoDataDTO)sqlMap.queryForObject("test.getUserInfo", id);
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
	public String userInfoFormUpdatePro(UserInfoDataDTO dto, Model model){
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
	
	/* 회원 가입 페이지 */
	@RequestMapping("userInfoSignForm.do")
	public String signForm(){
		return "/userInfo/userInfoSignForm";
	}
	
	/* 회원 가입 시 아이디 중복 확인 페이지 */
	@RequestMapping("userInfoSignCheckId.do")
	public String signCheckId(String id, Model model){
		// 아이디 유효성 검사
		int validCheck = CheckInfo.idCheck(id);
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
	public String signPro(UserInfoDataDTO dto, BossInfoDataDTO bdto, EmployeeInfoDataDTO edto,HttpServletRequest request, HttpSession session){
		String phone = request.getParameter("phone_1")+"-"+request.getParameter("phone_2")+"-"+request.getParameter("phone_3"); // 전화번호를 dto에 저장
		dto.setPhone(phone);
		String b_number=request.getParameter("b_number_1")+"-"+request.getParameter("b_number_2")+"-"+request.getParameter("b_number_3"); // 사업자 번호를 bdto에 저장
		bdto.setB_number(b_number);
		String b_tel=request.getParameter("b_tel1")+"-"+request.getParameter("b_tel2")+"-"+request.getParameter("b_tel3"); // 사업장 전화번호를 bdto에 저장
		bdto.setB_tel(b_tel);
		

		try{
			sqlMap.insert("test.userInfoInsert", dto);	// DB에 회원 가입 정보 추가하기
			session.setAttribute("loginId", dto.getId());	// 회원 가입 완료된 id를 세션으로 사용
			request.setAttribute("result", "succ");	// 성공적으로 회원 가입이 완료됨을 알림
		}catch(Exception e){	// DB에 회원 가입 정보 INSERT 시 에러 발생하면 아래 코드 실행
			e.printStackTrace();	// 에러 상황 콘솔에 알림
			request.setAttribute("result", "fail");	// 회원 가입이 실패했음을 알림
		}
		
		if(dto.getGrade()==1){
			bdto.setB_id(dto.getId());
			sqlMap.insert("test.bossInfoInsert",bdto);
		}
		if(dto.getGrade()==2){
			edto.setE_id(dto.getId());
			String bossid= request.getParameter("bossid");
			String bossCheck = (String) sqlMap.queryForObject("test.searchBossId", bossid);
			if(bossCheck!=null){
				edto.setE_bossid(bdto.getB_id());
				sqlMap.insert("test.employeeInfoInsert",edto);
			}else{
				bossCheck="fail";
			}
			request.setAttribute("bossCheck",bossCheck);
		}
		
		
		
		return "/userInfo/userInfoSignPro";
	}
	
	/* 회원 가입 중 등급 사용자 클릭 */
	@RequestMapping("userInfoGrade.do")
	public String userInfoGrade(){
		return "/userInfo/userInfoGrade";
	}
	
	
	
	
}
