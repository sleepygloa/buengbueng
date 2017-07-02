package manage.boss.bean;

import java.io.IOException;
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

import index.all.bean.FranchiseeModuleDataDTO;
import index.all.bean.ModuleDataDTO;
import login.user.bean.BossInfoDataDTO;
import login.user.bean.UserInfoDataDTO;
import superclass.all.bean.CheckInfo;
import superclass.all.bean.FindIpBean;
import superclass.all.bean.Random;
import superclass.all.bean.ReadDbWriteArray;
import superclass.all.bean.SuperClass;

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
	
	//비밀번호 검사
	@Autowired
	public CheckInfo pwcheck;
	
	//Log파일쓰기
	@Autowired
	public ReadDbWriteArray read;
	
	@Autowired
	protected SuperClass sc;
	
	//대메뉴에서 '사장님 가맹점 관리 버튼 클릭시' 이동
	@RequestMapping("franchiseeManagementMain.do")
	public String franchiseeManagementMain(Model model){
		
		sc.sideMenuTemp(model, 1, 1); //sidemenu template
		
		return "/bosspcuse/franchiseeManagementMain";
	}
	
	//가맹점 추가 //폼에서 입력받음
	@RequestMapping("franchiseeAdd.do")
	public String franchiseeAdd(HttpSession session, BossInfoDataDTO bossDto, Model model){
		
		sc.sideMenuTemp(model, 0, 1); //sidemenu template
		
		//세션의 아이디와 BossInfo Table의 아이디가 동일한 것이 있는지 부터 검사를 한다.
		UserInfoDataDTO userDto;
		
		//현재 로그인한 사용자의 아이디를 불러온다.
		String id = (String)session.getAttribute("loginId");
		int check;
		String ip;
		
		//////////////////////////////////////////
		//비로그인접근, 잘못된 경로로 접근한사람 내쫓음
		if(id == null){
			check = 9; //비회원이 싸이트로 접속했을때.
			return "/bosspcuse/franchiseeAddPro";
		}
		
		//////////////////////////////////////////////////////////////////////////////
		//사장님이라면 사장님정보를 불러온다.
		userDto = (UserInfoDataDTO)sqlMap.queryForObject("franchisee.getBossInfo", id);
		
		//방문자의 IP주소를 알아낸다
		ip = (String)findIP.findIp();
		
		//가맹점 신청 테이블에 이력을 남긴다. 
		
		//가맹점 추가신청을한다.
		model.addAttribute("userDto", userDto);
		model.addAttribute("ip", ip);
		
		return "/bosspcuse/franchiseeAdd";
	}
	
	
	
	//가맹점 신청 처리 BEAN
	@RequestMapping("franchiseeAddPro.do")
	public String franchiseeAddPro(HttpServletRequest request, HttpSession session, FranchiseeDataDTO franchiseeDto, Model model) throws IOException{
		String b_number=request.getParameter("b_number_1")+"-"+request.getParameter("b_number_2")+"-"+request.getParameter("b_number_3"); // 사업자 번호를 bdto에 저장
		franchiseeDto.setB_number(b_number);
		String b_tel=request.getParameter("b_tel1")+"-"+request.getParameter("b_tel2")+"-"+request.getParameter("b_tel3"); // 사업장 전화번호를 bdto에 저장
		franchiseeDto.setB_tel(b_tel);
		
		//세션의 아이디와 BossInfo Table의 아이디가 동일한 것이 있는지 부터 검사를 한다.
		UserInfoDataDTO userDto;
		
		//현재 로그인한 사용자의 아이디를 불러온다.
		String id = (String)session.getAttribute("loginId");
		int check = 0;
		

			try{
				/////////////////////////////////////////////////////////////
				//가맹점 정보 로그를 입력한다.
				sqlMap.insert("log.insertFranchiseeLog", franchiseeDto);
				check = 1;
				
				////////////////////////////////////////////////////////////
				//TEXT파일로 로그를 남기는 코드
				String fileName = "\\franchisee\\addSuccessLog\\addSuccessLog.txt";
				String fileCheck = "franchisee";
				franchiseeDto.setB_id(id);
				read.readDb(franchiseeDto, fileName, fileCheck);
				////////////////////////////////////////////////////////////
			}catch(Exception e){
				check = 2;
				e.printStackTrace();
				System.out.println(e);
				////////////////////////////////////////////////////////////
				//TEXT파일로 로그를 남기는 코드
				String fileName = "\\franchisee\\addErrorLog\\addErrorLog.txt";
				String fileCheck = "franchisee";
				franchiseeDto.setB_id(id);
				read.readDb(franchiseeDto, fileName, fileCheck);
				////////////////////////////////////////////////////////////
			}
		
		model.addAttribute("check", check);
		
		return "/bosspcuse/franchiseeAddPro";
	}
	
	//가맹점 신청 승인
	@RequestMapping("franchiseeConfirm.do")
	public String franchiseeConfirm(int num, String b_name){
		String b_key = random.random();
		
		HashMap map = new HashMap();
		map.put("num", num);
		map.put("b_key",b_key);
		map.put("b_name", b_name);
		
		try{
			sqlMap.update("franchisee.franchiseeConfirm", map);	
			
			FranchiseeDataDTO franchiseeDto = null;
			franchiseeDto = (FranchiseeDataDTO)sqlMap.queryForObject("franchisee.getFranchiseeLastConfirmLog", num);
			System.out.println(franchiseeDto.getB_key());
			sqlMap.insert("franchisee.insertFranchiseeInfo", franchiseeDto);
			
			// 혜민 코드 추가 시작
			HashMap param = new HashMap();
			int pcCount = Integer.parseInt(franchiseeDto.getB_pccount());
			param.put("b_key", franchiseeDto.getB_key());
			
			StringBuffer sb = new StringBuffer();
			for(int i=1; i<=pcCount; i++){
				sb.append("0");
				if(param.get("num") != null){
					param.remove("num");
				}
				if(i!=pcCount){
					sb.append(",");
				}
				param.put("num", i);
				sqlMap.insert("pcInfo.insertPcInfoDefault", param);
				sqlMap.insert("pcInfo.insertConputerInfoDefault", param);
				sqlMap.insert("pcInfo.insertMonitorInfoDefault", param);
				sqlMap.insert("pcInfo.insertKeyboardInfoDefault", param);
				sqlMap.insert("pcInfo.insertMouseInfoDefault", param);
				sqlMap.insert("pcInfo.insertSpeakerInfoDefault", param);
			}
			param.remove("num");
			param.put("check", sb.toString());
			sqlMap.insert("bossERP.addSeatState", param);
			ModuleDataDTO defaultModule = (ModuleDataDTO)sqlMap.queryForObject("module.getOfferMenu", null);
			FranchiseeModuleDataDTO module = new FranchiseeModuleDataDTO();
			module.setB_id(franchiseeDto.getB_id());
			module.setM_name("기본");
			module.setMenu(defaultModule.getModuleName());
			sb = new StringBuffer();
			for(int i=0; i<defaultModule.getModuleCount(); i++){
				sb.append("1");
				if(i != defaultModule.getModuleCount()-1){
					sb.append(",");
				}
			}
			module.setModule(sb.toString());
			sqlMap.insert("module.setModule", module);
			// 혜민 코드 추가 끝
			
			
		}catch (Exception e){
			e.printStackTrace();
		}
	        
			return  "redirect:/franchiseeList.do";	
		}
	
	//가맹점 신청 리스트
	@RequestMapping("franchiseeList.do")
	public String franchiseeList(String pageNum , HttpServletRequest request, Model model, HttpSession session){
		
		sc.sideMenuTemp(model, 0, 1); //sidemenu template
		
		//현재 로그인한 사용자의 아이디를 불러온다.
		String id = (String)session.getAttribute("loginId");
		
		if (pageNum == null) {
            pageNum = "1";
        }
		
        int pageSize = 20; //페이지당 20개씩 보여줌
        int currentPage = Integer.parseInt(pageNum);
        int startRow = (currentPage - 1) * pageSize + 1; //시작 행번호
        int endRow = currentPage * pageSize; //끝 행 번호
        int count1 = 0; //글 갯수 초기화
        int count2 = 0; //글 갯수 초기화

        List articleList1 = null;
        List articleList2 = null; 
        
        /////////////////////////////////////////////////////////////////////////////////
        //사장님이 보유한 가맹점 리스트
        /////////////////////////////////////////////////////////////////////////////////
        count1 = (Integer)sqlMap.queryForObject("franchisee.getFranchiseeListCount", id); //가맹점 정보의 갯수를 가져온다.
        if (count1 > 0) {
        	HashMap map = new HashMap(); //HashMap에 여러가지정보 (시작행번호, 마지막행번호)넣어 한번에 보낸다.
        	map.put("id", id);
        	map.put("startRow", startRow);
        	map.put("endRow", endRow);
            articleList1 = sqlMap.queryForList("franchisee.getFranchiseeList", map); //가맹점 리스트를 뽑아온다.
        } else {
            articleList1 = Collections.EMPTY_LIST;
        }

        /////////////////////////////////////////////////////////////////////////////////
        //가맹점 신청중인 리스트
        /////////////////////////////////////////////////////////////////////////////////
        count2 = (Integer)sqlMap.queryForObject("franchisee.getFranchiseeAddListCount", id); //가맹점 정보의 갯수를 가져온다.
        if (count2 > 0) {
            articleList2 = sqlMap.queryForList("franchisee.getFranchiseeAddList", id); //가맹점 리스트를 뽑아온다.
        } else {
            articleList2 = Collections.EMPTY_LIST;
        }       
        
        request.setAttribute("currentPage", new Integer(currentPage));
        request.setAttribute("startRow", new Integer(startRow));
        request.setAttribute("endRow", new Integer(endRow));
        request.setAttribute("count1", new Integer(count1));
        request.setAttribute("count2", new Integer(count2));
        request.setAttribute("pageSize", new Integer(pageSize));
        request.setAttribute("articleList1", articleList1);
        request.setAttribute("articleList2", articleList2);
        
		return  "/bosspcuse/franchiseeList";	
	}

	
	//가맹점 정보
	@RequestMapping("franchiseeInfo.do")
	public String franchiseeInfo(String b_name, Model model){
		FranchiseeDataDTO dto = null;
		dto = (FranchiseeDataDTO)sqlMap.queryForObject("franchisee.getFranchiseeInfo", b_name);
		
		model.addAttribute("dto", dto);
	        
			return  "/bosspcuse/franchiseeInfo";	
		}
	
	//가맹점 정보 수정
	@RequestMapping("franchiseeInfoUpdate.do")
	public String franchiseeInfoUpdate(String b_name, Model model){
		FranchiseeDataDTO dto = null;
		dto = (FranchiseeDataDTO)sqlMap.queryForObject("franchisee.getFranchiseeInfo", b_name);
		String check = "update"; //update Form 으로 변경
		model.addAttribute("dto", dto);
		model.addAttribute("check", check);
	        
			return  "/bosspcuse/franchiseeInfoUpdate";	
		}
	
	//가맹점 정보 수정
	@RequestMapping("franchiseeInfoUpdatePro.do")
	public String franchiseeInfoUpdatePro(HttpSession session,FranchiseeDataDTO dto, Model model) throws IOException{
		
		//현재 로그인한 사용자의 아이디를 불러온다.
		String id = (String)session.getAttribute("loginId");
		
		try{
			sqlMap.insert("franchisee.insertFranchiseeUpdateLog", dto);
			////////////////////////////////////////////////////////////
			//TEXT파일로 로그를 남기는 코드
			String fileName = "\\franchisee\\updateSuccessLog\\updateSuccessLog.txt";
			String fileCheck = "franchiseeUpdate";
			dto.setB_id(id);
			read.readDb(dto, fileName, fileCheck);
			////////////////////////////////////////////////////////////
			sqlMap.update("franchisee.updateFranchiseeInfo", dto);
		}catch(Exception e){
			e.printStackTrace();
			////////////////////////////////////////////////////////////
			//TEXT파일로 로그를 남기는 코드
			String fileName = "\\franchisee\\updateErrorLog\\updateErrorLog.txt";
			String fileCheck = "franchiseeUpdate";
			dto.setB_id(id);
			read.readDb(dto, fileName, fileCheck);
			////////////////////////////////////////////////////////////
		}
	        
			return  "redirect:/franchiseeList.do";	
		}	
	
	//가맹점 삭제 신청
	@RequestMapping("franchiseeDelete.do")
	public String frachiseeDelete(HttpSession session, HttpServletRequest request,  Model model){

	        
			return  "/bosspcuse/franchiseeDelete";	
		}	
	
	//가맹점 삭제 신청
	@RequestMapping("franchiseeDeletePro.do")
	public String frachiseeDeletePro(String password, String reason, String b_key, HttpSession session,  Model model) throws IOException{
		//현재 로그인한 사용자의 아이디를 불러온다.
		String id = (String)session.getAttribute("loginId");
		
		int check = pwcheck.pwCheck2(password,id);
		System.out.println(b_key);
		if(check == 1){
			HashMap map = new HashMap();
			map.put("pw", password);
			map.put("reason", reason);
			map.put("b_key", b_key);

		FranchiseeDataDTO dto = null;	
			
			try{
				sqlMap.insert("franchisee.insertFranchiseeDeleteLog", map);
				dto = (FranchiseeDataDTO)sqlMap.queryForObject("franchisee.getFranchiseeDeleteLogBkey", b_key);
				
				////////////////////////////////////////////////////////////
				//TEXT파일로 로그를 남기는 코드
				String fileName = "\\franchisee\\deleteSuccessLog\\deleteSuccessLog.txt";
				String fileCheck = "franchiseeDelete";
				read.readDb(dto, fileName, fileCheck);
				////////////////////////////////////////////////////////////
				sqlMap.delete("franchisee.deleteFranchisee", map);
			}catch(Exception e){
				e.printStackTrace();
				////////////////////////////////////////////////////////////
				//TEXT파일로 로그를 남기는 코드
//				String fileName = "\\franchisee\\deleteErrorLog\\deleteErrorLog.txt";
//				String fileCheck = "franchiseeDelete";
//				read.readDb(dto, fileName, fileCheck);
				////////////////////////////////////////////////////////////
			}
		}
	        
			return  "redirect:/franchiseeList.do";	
		}
	
}
