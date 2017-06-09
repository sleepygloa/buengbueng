package manage.boss.bean;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import login.user.bean.BossInfoDataDTO;
import login.user.bean.UserInfoDataDTO;
import superclass.all.bean.FindIpBean;
import superclass.all.bean.Random;

@Controller
public class FranchiseeManagementBean {

	//sql을 연결 시켜주는 변수
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	//sql을 연결 시켜주는 변수
	@Autowired
	public FindIpBean findIP;
	
	//랜덤수 만들어주는 변수
	@Autowired
	public Random random;
	
	//대메뉴에서 '사장님 가맹점 관리 버튼 클릭시' 이동
	@RequestMapping("franchiseeManagementMain.do")
	public String franchiseeManagementMain(Model model){
		
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 1; //사이드메뉴의 내용을 선택
		model.addAttribute("sidemenuCheck", sidemenuCheck);
		model.addAttribute("sidemenu", sidemenu);
		
		return "/bosspcuse/franchiseeManagementMain";
	}
	
	//가맹점 추가 //폼에서 입력받음
	@RequestMapping("franchiseeAdd.do")
	public String franchiseeAdd(HttpSession session, BossInfoDataDTO bossDto, Model model){
		
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 1; //사이드메뉴의 내용을 선택
		model.addAttribute("sidemenuCheck", sidemenuCheck);
		model.addAttribute("sidemenu", sidemenu);
		
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
	
	
	
	//가맹점 신청 처리 BEAN
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
				
				//로그남겨졌을때, franchiseeInfo에 프랜차이즈 정보를 입력해줍니다.
				sqlMap.insert("franchisee.insertFranchiseeInfoAdd", bossDto);
				check = 1;
			}catch(Exception e){
				check = 2;
				e.printStackTrace();
				System.out.println(e);
			}
		
		model.addAttribute("check", check);
		
		return "/bosspcuse/franchiseeAddPro";
	}
	
	//가맹점 신청 리스트
	@RequestMapping("franchiseeList.do")
	public String franchiseeList(String pageNum , HttpServletRequest request, Model model){
		
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 1; //사이드메뉴의 내용을 선택
		model.addAttribute("sidemenuCheck", sidemenuCheck);
		model.addAttribute("sidemenu", sidemenu);
		
		if (pageNum == null) {
            pageNum = "1";
        }
		
        int pageSize = 20; //페이지당 20개씩 보여줌
        int currentPage = Integer.parseInt(pageNum);
        int startRow = (currentPage - 1) * pageSize + 1; //시작 행번호
        int endRow = currentPage * pageSize; //끝 행 번호
        int count = 0; //글 갯수 초기화
        int number = 0; // 글 번호 초기화

        List articleList = null; 
        
        count = (Integer)sqlMap.queryForObject("franchisee.getFranchiseeListCount", null); //가맹점 정보의 갯수를 가져온다.
        if (count > 0) {
        	HashMap map = new HashMap(); //HashMap에 여러가지정보 (시작행번호, 마지막행번호)넣어 한번에 보낸다.
        	map.put("startRow", startRow);
        	map.put("endRow", endRow);
            articleList = sqlMap.queryForList("franchisee.getFranchiseeList", map); //가맹점 리스트를 뽑아온다.
        } else {
            articleList = Collections.EMPTY_LIST;
        }

        
		number=count-(currentPage-1)*pageSize; // 글번호
        
        request.setAttribute("currentPage", new Integer(currentPage));
        request.setAttribute("startRow", new Integer(startRow));
        request.setAttribute("endRow", new Integer(endRow));
        request.setAttribute("count", new Integer(count));
        request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
        request.setAttribute("articleList", articleList);
        
		return  "/bosspcuse/franchiseeList";	
	}
	
	//가맹점 신청 승인
		@RequestMapping("franchiseeListConfirm.do")
		public String franchiseeListConfirm(int num, HttpServletRequest request, Model model){
			
			int check = 0;
			
			
			String b_key = "";
			// 8자리 16진수 라이센스키를 가져오는 메서드 실행
			b_key += random.random();
			
			HashMap map = new HashMap();
			map.put("b_key", b_key);
			map.put("num", num);
			
			try{
				sqlMap.update("franchisee.franchiseeConfirm", map);	
				check = 1;
			}catch(Exception e){
				check = 2;
			}
			
			
			int franchiseeListConfirm = 1;
			model.addAttribute("franchiseeListConfirm", franchiseeListConfirm);
			model.addAttribute("check",check);
	        
			return  "/bosspcuse/franchiseeListPro";	
		}
	
}
