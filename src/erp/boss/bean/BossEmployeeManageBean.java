package erp.boss.bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import login.user.bean.UserInfoDataDTO;
import manage.boss.bean.FranchiseeDataDTO;
import superclass.all.bean.FranchiseeSelect;
import superclass.all.bean.MenuCategoryDivResponse;
import superclass.all.bean.SuperClass;

@Controller
public class BossEmployeeManageBean {

	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	@Autowired
	public MenuCategoryDivResponse bossEmployeeManageBean;
	
	@Autowired
	public FranchiseeSelect fs;
	
	@Autowired
	protected SuperClass sc;
	
	//사장님 알바생관리 메인 페이지 세션 처리
		@RequestMapping("bossErpMainSession.do")
		public String bossErpMainSession(Model model, HttpSession session, String pageNum,String pageNum2, String b_key){
			String id = sc.getSessionIdModelId(model, session); //sessionId, model.addAttribute(id) template
			fs.franchiseeList(session, id, model, b_key);
			return "redirect:/bossErpMain.do";
		}
	
	//사장님 알바생관리 메인 페이지
	@RequestMapping("bossErpMain.do")
	public String bossEmployeeInfoMain(Model model, HttpSession session, String pageNum,String pageNum2){
		String b_key = (String)session.getAttribute("b_key");
		Calendar day = Calendar.getInstance();
        day.add(Calendar.DATE, 0);
        
        String startDate = new java.text.SimpleDateFormat("yyyy-MM-dd 00:00:00").format(day.getTime());
    	String endDate = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(day.getTime());
        
		sc.sideMenuTemp(model, 1, 3); //sidemenu template
		
		String id = sc.getSessionIdModelId(model, session); //sessionId, model.addAttribute(id) template
		
		
		
		HashMap mainInfo = new HashMap<>();
		mainInfo.put("startDate", startDate);
		mainInfo.put("endDate", endDate);
		mainInfo.put("b_key", b_key);
		
		
		
		/// 각 페이지 카운트
		int count = (int)sqlMap.queryForObject("erpEmp.totalAmountCount", b_key);
		int count2 = (int)sqlMap.queryForObject("erpEmp.dailyUserCount", mainInfo);
		System.out.println("count2" + count2);
		int count3 = (int)sqlMap.queryForObject("erpEmp.dailyAmountCount", mainInfo);
		
		if(count > 0){
			String totalAmount = (String) sqlMap.queryForObject("erpEmp.totalAmount", b_key);
			model.addAttribute("totalAmount", totalAmount);
			System.out.println("totalAmount" + totalAmount);
		}
		if(count2 > 0){
			int dailyUserCount = (int) sqlMap.queryForObject("erpEmp.dailyUserCount", mainInfo);
			model.addAttribute("dailyUserCount", dailyUserCount);
			System.out.println("dailyUserCount" + dailyUserCount);
		}
		
		if(count3 > 0){
			String dailyAmount = (String)sqlMap.queryForObject("erpEmp.dailyUsageHistoryAmountCount", mainInfo);
			model.addAttribute("dailyAmount", dailyAmount);
			System.out.println("dailyAmount" + dailyAmount);
		}
		
		
		//box4 출 퇴근 리스트
		try{
			int check = (Integer)sqlMap.queryForObject("erpEmp.getUserGrade", id);//알바인지, 사장님인지 구분한다.
			//리스트를 뽑는다.
			List list = new ArrayList();
			
			if(check == 1){
				//사장님이면	
				list = (List)sqlMap.queryForList("erpEmp.getEmployeeWorkTimeList", id);
			}else if(check == 2){
				//알바생이면				
				id = (String)sqlMap.queryForObject("erpEmp.getEidBid", id);
				list = (List)sqlMap.queryForList("erpEmp.getEmployeeWorkTimeList", id);
			}else{}
		
			model.addAttribute("list", list);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		// 사용 현황
		//내역 리스트
		if (pageNum == null) {
            pageNum = "1";
        }
        int pageSize = 99999;
        int currentPage = Integer.parseInt(pageNum);
        int startRow = (currentPage - 1) * pageSize + 1;
        int endRow = currentPage * pageSize;
        int count4 = 0;
        int number= 0;
	
        List articleList = null;
               
        count4 = (Integer)sqlMap.queryForObject("erpEmp.useStatusCount", b_key);
        System.out.println("count" + count);
        
        if(count4 > 0){
        	HashMap r = new HashMap<>();
     	    r.put("startRow", startRow);
     	    r.put("endRow", endRow);
     	    r.put("b_key", b_key);
     	    articleList = sqlMap.queryForList("erpEmp.useStatusList", r);
     	    System.out.println("articleList" + articleList.size());
        } else {
        	articleList = Collections.EMPTY_LIST;
        }
        
     
        number = count4 - (currentPage - 1) * pageSize;
        
      //일일정산내역 리스트
  		if (pageNum2 == null) {
              pageNum2 = "1";
          }
          int pageSize2 = 40;
          int currentPage2 = Integer.parseInt(pageNum);
          int startRow2 = (currentPage - 1) * pageSize + 1;
          int endRow2 = currentPage * pageSize;
          int count5 = 0;
          int number2= 0;
  	
          List articleList2 = null;
                 
          count5 = (Integer)sqlMap.queryForObject("erpEmp.dailySettlementCount", b_key);
          System.out.println("count" + count);
          
          if(count5 > 0){
          	HashMap r = new HashMap<>();
       	    r.put("startRow", startRow);
       	    r.put("endRow", endRow);
       	    r.put("b_key", b_key);
       	    articleList2 = sqlMap.queryForList("erpEmp.dailySettlementList", r);
          } else {
          	articleList2 = Collections.EMPTY_LIST;
          }
          
       
          number2 = count5 - (currentPage - 1) * pageSize;
          
  	    
          model.addAttribute("articleList2", articleList2);
          model.addAttribute("currentPage2", new Integer(currentPage2));
          model.addAttribute("startRow2", new Integer(startRow2));
          model.addAttribute("endRow2", new Integer(endRow2));
          model.addAttribute("count5", new Integer(count5));
          model.addAttribute("pageSize2", new Integer(pageSize2));
          model.addAttribute("number2", new Integer(number2));
        
         
	    model.addAttribute("articleList", articleList);
	    model.addAttribute("currentPage", new Integer(currentPage));
	    model.addAttribute("startRow", new Integer(startRow));
	    model.addAttribute("endRow", new Integer(endRow));
	    model.addAttribute("count4", new Integer(count4));
	    model.addAttribute("pageSize", new Integer(pageSize));
	    model.addAttribute("number", new Integer(number));
	    
	    
		model.addAttribute("count", count);
		model.addAttribute("count2", count2);
		model.addAttribute("count3", count3);
    	
		
		return "/bossERP/erpMain";
	}
	

	//사장님 알바생 관리 페이지로이동 (가맹점 선택)
	@RequestMapping("employeeManageInfo.do")
	public String employeeManageInfo(Model model, HttpSession session){
		
		sc.sideMenuTemp(model, 1, 3); //sidemenu template
		
		String id = sc.getSessionIdModelId(model, session); //sessionId, model.addAttribute(id) template
		
		//가맹점 키를 세션으로 받음
		String b_key = (String)session.getAttribute("b_key");
		
		HashMap map = new HashMap();
		map.put("id", id);
		map.put("b_key", b_key);
		
		
		//////////////////////////////////////////////
		///임시로 추가함
		List list = new ArrayList();
		list = (List)sqlMap.queryForList("erpEmp.getEmployeeAddLog",map);
		model.addAttribute("list",list);
		
		//////////////////////////////////////////////
		//알바생 아이디정보를 리스트로 불러옴, 파트 
		List list1 = new ArrayList();
		list1 = (List)sqlMap.queryForList("erpEmp.getEmployeeList", map);
		model.addAttribute("list1",list1);
		
		//////////////////////////////////////////////
		//알바생 아이디정보를 리스트로 불러옴, 파트 
		List list2 = new ArrayList();
		list2 = (List)sqlMap.queryForList("erpEmp.getEmployeeDeleteList", map);
		model.addAttribute("list2",list2);
		
		return "/bossERP/employeeManage/employeeManageInfo";
	}
	
	//알바생 아이디 신청폼 AJAX 
	@RequestMapping("employeeAddInfo.do")
	public String employeeAddInfo(Model model, HttpSession session, BossEmployeeManageDataDTO beDTO){
			
		sc.getSessionBidModelBid(model, session); //session b_id, model.addAttribute(b_id) template
		
		beDTO = (BossEmployeeManageDataDTO)sqlMap.queryForObject("erpEmp.getEmployeeAddLogLastNum", null);
		model.addAttribute("beDTO", beDTO);
		
		return "/bossERP/employeeManage/employeeAddInfo";
	}
	
	//알바생 아이디 추가 신청 처리, Log남김
	@RequestMapping("employeeAddPro.do")
	public String employeeAddPro(Model model, HttpSession session, BossEmployeeManageDataDTO beDTO){
		
		String b_id = sc.getSessionBidModelBid(model, session); //session b_id, model.addAttribute(b_id) template
		
		//가맹점 키를 세션으로 받음
		String b_key = (String)session.getAttribute("b_key");
		
		//////////////////////////////////////////
		//b_key로 가맹점 이름 알바 정보에 입력
		String b_name = (String)sqlMap.queryForObject("franchisee.getFranchiseeLogBkey",b_key);

		int check = 0;
		//로그인 하지 않았을때 그냥 폼은 보여주지만, 아무것도할수없다.
		//////////////////////////////////////////
		//비로그인접근, 잘못된 경로로 접근한사람 내쫓음
		if(b_id == null){check = 9; //비회원이 싸이트로 접속했을때.
			return "/bosspcuse/franchiseeAddPro";		}
		
		try{
			beDTO.setB_key(b_key);
			beDTO.setB_name(b_name);
			//입력된 정보를 로그에 남겨줍니다.
			//////////////////////////////////////
			//사장님이 알바생아이디를 (숫자)만큼 신청함. 
			sqlMap.insert("erpEmp.insertEmployeeAddLog", beDTO);
			check = 1;
			
		}catch(Exception e){
			check = 2;
		}
		model.addAttribute("check", check);
			return "/bossERP/employeeManage/employeePro";
	}	
	
	//알바생 아이디 추가신청에 대한 확인 및 아이디 발급
	@RequestMapping("employeeAddAdminConfirm.do")
	public String employeeAddAdminConfirm(Model model, HttpSession session, BossEmployeeManageDataDTO beDTO){
		
		int applyCount = beDTO.getApplyCount();
		String b_id = beDTO.getB_id();
		
		BossEmployeeManageDataDTO beDTO2 = null;
		int check = 0;
		String checkId = "";
		int length = 0;
		int checkIdInt = 0;	
		String id = null;
		
		try{
			////////////////////////////////////////////////////////////////
			//알바생정보테이블에서 사장님이 가지고있는 알바생아이디가 있는지 찾는다.
			//없다면 없는 것이고, 있다면 있는 알바생아이디중 제일 큰 아이디의 마지막 번호만 가져온다.
			if(sqlMap.queryForObject("erpEmp.getEmployeeId", b_id) != null){
				beDTO2 = (BossEmployeeManageDataDTO)sqlMap.queryForObject("erpEmp.getEmployeeId", b_id);
				 checkId = (beDTO2.getE_id()); //아이디 제일 마지막 숫자만 출력한다.
				 checkIdInt = Integer.parseInt(checkId); //숫자를 인트로 형변환한다.
			}

				for(int i = 0; i < applyCount; i ++){
					checkIdInt += 1; //checkIdInt 가 겹치기 않게 +1을 한다.
						for(int j = 0; j < checkIdInt+1; j++){
							String e_id = null;
							e_id = "employee" + j;
							//J 1부터 검색하여 번호가 빈 알바아이디를 찾아냅니다. null일때, 그곳에 해당아이디를 넣어줍니다.
							if(sqlMap.queryForObject("erpEmp.findE_idNull", e_id) == null){
								HashMap map = new HashMap();
								map.put("e_bossid", b_id);
								map.put("e_id", e_id);
								map.put("b_key", beDTO.getB_key());
								sqlMap.insert("erpEmp.insertEmployeeIdUserInfo", e_id);
								sqlMap.insert("erpEmp.insertEmployeeIdEmployeeInfo", map);
								
								id = e_id;		
								break;
							}else{
								if(j == checkIdInt){
									j += 1;
									e_id = "employee" + j;
									HashMap map = new HashMap();
									map.put("e_bossid", b_id);
									map.put("e_id", e_id);
									map.put("b_key", beDTO.getB_key());
									sqlMap.insert("erpEmp.insertEmployeeIdUserInfo", e_id);
									sqlMap.insert("erpEmp.insertEmployeeIdEmployeeInfo", map);
									
									id = e_id;		
									break;
								}
							};
							
						}
				}
				sqlMap.update("erpEmp.updateEmployeeAddLog", id);	
				check = 1;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}
		
		model.addAttribute("check", check);
		
		return "redirect:/employeeManage.do";
	}
	
	//▲ 를 눌렀을때 AJAX 처리
	@RequestMapping("employeeIdUP.do")
	public String employeeIdUp(Model model, HttpSession session,int num){
		
		String b_id = sc.getSessionBidModelBid(model, session); //session b_id, model.addAttribute(b_id) template
		
		System.out.println(num);
		int indexNum = 0;
		int space = 9999; //해당 컬럼은 primary Key이다.
		
		List list = new ArrayList();
		try{
			list = (List)sqlMap.queryForList("erpEmp.getListNum",b_id);
			for(int i = 0 ; i < list.size(); i ++){
				if((Integer)list.get(i) == num){
					indexNum = i;
					
					int numa = (Integer)list.get(indexNum);
					if((Integer)list.get(indexNum-1) == null){break;}else{
						int numb = (Integer)list.get(indexNum-1);
						
						HashMap map = new HashMap();
						map.put("numa", numa); //선택된수
						map.put("numb", numb); //앞수, 교환될 수
						map.put("space", space);
						sqlMap.update("erpEmp.changeSpace", map);
						sqlMap.update("erpEmp.changeBefore", map);
						sqlMap.update("erpEmp.changeAfter", map);
						break;
					}
				}
			}
//			Collections.swap(list, indexNum-1, indexNum); arrayList 순서바꿔주는 클래스
			System.out.println(indexNum);
			
		}catch(Exception e){}
		
		return "redirect:/employeeManage.do";
	}

	//▼ 를 눌렀을때 AJAX 처리
	@RequestMapping("employeeIdDOWN.do")
	public String employeeIdDOWN(Model model, HttpSession session,int num){
		
		String b_id = sc.getSessionBidModelBid(model, session); //session b_id, model.addAttribute(b_id) template
		
		System.out.println(num);
		int indexNum = 0;
		int space = 9999; //해당 컬럼은 primary Key이다.
		
		List list = new ArrayList();
		try{
			list = (List)sqlMap.queryForList("erpEmp.getListNum",b_id);
			for(int i = 0 ; i < list.size(); i ++){
				if((Integer)list.get(i) == num){
					indexNum = i;
					
					int numa = (Integer)list.get(indexNum);
					if((Integer)list.get(indexNum+1) == null){break;}else{
						int numb = (Integer)list.get(indexNum+1);
						
						System.out.println("numa"+numa);
						System.out.println("numb"+numb);
						HashMap map = new HashMap();//up 버튼과 매개변수 교차로 입력됨
						map.put("numb", numa); //선택된수
						map.put("numa", numb); //뒷수, 교환될 수
						map.put("space", space);
						sqlMap.update("erpEmp.changeSpace", map);
						sqlMap.update("erpEmp.changeBefore", map);
						sqlMap.update("erpEmp.changeAfter", map);
						break;
					}
				}
			}
//			Collections.swap(list, indexNum-1, indexNum); arrayList 순서바꿔주는 클래스
			System.out.println(indexNum);
			
		}catch(Exception e){}
		
		return "redirect:/employeeManage.do";
	}
	
	//알바생 아이디 삭제 폼
	@RequestMapping("employeeDeleteInfo.do")
	public String employeeDeleteInfo(Model model, HttpSession session, int num, BossEmployeeManageDataDTO beDTO){
		
		String b_id = sc.getSessionBidModelBid(model, session); //session b_id, model.addAttribute(b_id) template
		
		int logNum = 0;
		
		beDTO = (BossEmployeeManageDataDTO)sqlMap.queryForObject("erpEmp.getDeleteIdInfo", num);
	
			if(sqlMap.queryForObject("erpEmp.getDeleteLogLastNum", null) == null){
			}else{
				logNum = (Integer)sqlMap.queryForObject("erpEmp.getDeleteLogLastNum", null);
			};
		
		model.addAttribute("e_id", beDTO.getE_id());
		model.addAttribute("logNum", logNum);
		
		return "/bossERP/employeeManage/employeeDeleteInfo";
	}
	
	//알바생 아이디 삭제 신청
	@RequestMapping("employeeDeleteInfoPro.do")
	public String employeeDeleteInfoPro(Model model, HttpSession session, BossEmployeeManageDataDTO beDto){

		String b_id = sc.getSessionBidModelBid(model, session); //session b_id, model.addAttribute(b_id) template
		//////////////////////////////////////////
		//b_key로 가맹점 이름 알바 정보에 입력
		String b_name = (String)sqlMap.queryForObject("franchisee.getFranchiseeLogBkey",beDto.getB_key());
		beDto.setB_id(b_id);
		beDto.setB_name(b_name);
		System.out.println("b_key="+beDto.getB_key()+"b_name="+beDto.getB_name());
		int check = 0;
		try{
			sqlMap.insert("erpEmp.deleteIdLogAdd", beDto);
			 check = 1;
		}catch(Exception e){
			e.printStackTrace();
			 check = 2;
		}
		model.addAttribute("check", check);
		
		return "/bossERP/employeeManage/employeeDeletePro";
	}
	
	//관리자 알바생 아이디 삭제 신청 승인
	@RequestMapping("employeeDeleteAdminConfirm.do")
	public String employeeDeleteAdminConfirm(Model model, String e_id){
		int check = 0;
		try{
			sqlMap.update("erpEmp.deleteIdLogAddConfirm", e_id);
			sqlMap.delete("erpEmp.deleteEidEmployeeInfo", e_id);
			sqlMap.delete("erpEmp.deleteEidUserInfo", e_id);
			check  = 4;
		}catch(Exception e){e.printStackTrace();check = 2;}
		
		model.addAttribute("check", check);
		
		return "/bossERP/employeeManage/employeeDeletePro";
	}
	
	//알바생 신상정보 리스트
	@RequestMapping("employeeInfoList.do")
	public String employeeInfoList(Model model, HttpSession session){
		
		sc.sideMenuTemp(model, 1, 3); //sidemenu template
		
		String id = sc.getSessionIdModelId(model, session); //sessionId, model.addAttribute(id) template
		
		//가맹점 키를 세션으로 받음
		String b_key = (String)session.getAttribute("b_key");
		
		List list = new ArrayList();
		list = (List)sqlMap.queryForList("erpEmp.getEmployeeIdList", b_key);
		
		model.addAttribute("list", list);
		
		String menu =  bossEmployeeManageBean.MenuCategoryDivResponse(list);
		
		model.addAttribute("menu", menu);
		
		
		return "/bossERP/employeeManage/employeeInfoList";
	}
	
	//알바생 정보 보기
	@RequestMapping("employeeInfo.do")
	public String bossEmployeeInfo(Model model, String id){
		
		sc.sideMenuTemp(model, 1, 3); //sidemenu template
		
		////////////////////////////////////////////////////////////////////////////////
		//알바생 리스트에서 클릭했을 때 정보를 불러온다.
		UserInfoDataDTO userDto = null;
		userDto = (UserInfoDataDTO)sqlMap.queryForObject("erpEmp.getEmployeeInfo", id);
		
		model.addAttribute("userDto", userDto);
		
		return "/bossERP/employeeManage/employeeInfo";
	}
	
	//알바생 정보 수정하기
	@RequestMapping("employeeUpdateInfo.do")
	public String employeeUpdateInfo(Model model, String id){
		
		sc.sideMenuTemp(model, 1, 3); //sidemenu template
		
		////////////////////////////////////////////////////////////////////////////////
		//알바생 리스트에서 클릭했을 때 정보를 불러온다.
		UserInfoDataDTO userDto = null;
		userDto = (UserInfoDataDTO)sqlMap.queryForObject("erpEmp.getEmployeeUpdateInfo", id);
		model.addAttribute("userDto", userDto);
		
		return "/bossERP/employeeManage/employeeUpdateInfo";
		}	
	
	//알바생 정보 수정처리
	@RequestMapping("employeeUpdateInfoPro.do")
	public String employeeUpdatePro(Model model, UserInfoDataDTO userDto){
		
		sc.sideMenuTemp(model, 1, 3); //sidemenu template
		
		int check = 0;
		////////////////////////////////////////////////////////////////////////////////
		//알바생정보를 수정한다.
		try{
			sqlMap.update("erpEmp.updateEmployeeId", userDto);
			check = 1;
			System.out.println(check);
		}catch(Exception e){
			e.printStackTrace();
			check = 2;
		}
		
		model.addAttribute("check", check);
		
	return "/bossERP/employeeManage/employeeUpdateInfoPro";
	}	
	
}



