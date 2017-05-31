package manage.boss.bean;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import findip.all.bean.findIpBean;
import login.user.bean.BossInfoDataDTO;
import login.user.bean.UserInfoDataDTO;

@Controller
public class FranchiseeManagementBean {

	//sql을 연결 시켜주는 변수
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	//sql을 연결 시켜주는 변수
	@Autowired
	public findIpBean findIP;
	
	//대메뉴에서 '사장님 가맹점 관리 버튼 클릭시' 이동
	@RequestMapping("franchiseeManagementMain.do")
	public String franchiseeManagementMain(){
		return "/bosspcuse/franchiseeManagementMain";
	}
	
	//가맹점 추가 //폼에서 입력받음
	@RequestMapping("franchiseeAdd.do")
	public String franchiseeAdd(HttpSession session, BossInfoDataDTO bossDto, Model model){
		
		//세션의 아이디와 BossInfo Table의 아이디가 동일한 것이 있는지 부터 검사를 한다.
		UserInfoDataDTO userDto;
		
		//현재 로그인한 사용자의 아이디를 불러온다.
		String id = (String)session.getAttribute("loginId");
		int check;
		String ip;
		
		//로그인 하지 않았을때 그냥 폼은 보여주지만, 아무것도할수없다.
		if(id == null){
			check = 9; //비회원이 싸이트로 접속했을때.
			return "/bosspcuse/franchiseeAddPro";
		}
		
		//사장님이라면 사장님정보를 불러온다.
		bossDto = (BossInfoDataDTO)sqlMap.queryForObject("franchisee.getBossInfo", id);
		
		//사용자라면 사용자정보를 불러오고, 사장님  PC방정보를 입력한다.
		userDto = (UserInfoDataDTO)sqlMap.queryForObject("test.getUserInfo", id);
		
		//방문자의 IP주소를 알아낸다
		ip = (String)findIP.findIp();
		
		//가맹점 신청 테이블에 이력을 남긴다. 
		
		//가맹점 추가신청을한다.
		
		model.addAttribute("bossDto", bossDto);
		model.addAttribute("userDto", userDto);
		model.addAttribute("ip", ip);
		
		
		return "/bosspcuse/franchiseeAdd";
	}
	
	@RequestMapping("franchiseeAddPro.do")
	public String franchiseeAddPro(HttpSession session, BossInfoDataDTO bossDto, Model model){
	
		//세션의 아이디와 BossInfo Table의 아이디가 동일한 것이 있는지 부터 검사를 한다.
		UserInfoDataDTO userDto;
		
		//현재 로그인한 사용자의 아이디를 불러온다.
		String id = (String)session.getAttribute("loginId");
		int check = 0;
		
		bossDto.setB_id(id);
			try{
				//입력된 정보를 로그에 남겨줍니다.
				sqlMap.insert("franchisee.insertFranchiseeAddLog", bossDto);
				
				check = 1;
			}catch(Exception e){
				check = 2;
				e.printStackTrace();
				System.out.println(e);
			}
		
		
		
		model.addAttribute("check", check);
		
		
		
		return "/bosspcuse/franchiseeAddPro";
	}
}
