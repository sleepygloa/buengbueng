package manage.admin.bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
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

import erp.boss.bean.BossEmployeeManageDataDTO;
import index.all.bean.FranchiseeModuleDataDTO;
import index.all.bean.ModuleDataDTO;
import manage.boss.bean.FranchiseeDataDTO;
import superclass.all.bean.Random;

@Controller
public class DashAllManagementBean extends BoardMethodBean{
	@Autowired
	SqlMapClientTemplate sqlMap;
	@Autowired
	public Random random;
	
	//가맹점 신청 승인
	@RequestMapping("dashfranchiseeConfirm.do")
	public String franchiseeConfirm(int num, String b_name,HttpServletRequest request){
		Alarm(request);
		String b_key = random.random();
		
		HashMap map = new HashMap();
		map.put("num", num);
		map.put("b_key",b_key);
		map.put("b_name", b_name);
		
		try{
			sqlMap.update("franchisee.franchiseeConfirm", map);	
			sqlMap.insert("franchisee.insertFranchiseePolicy", map); //가맹점 추가시 가맹점 금액정책 테이블 추가
			
			FranchiseeDataDTO franchiseeDto = null;
			franchiseeDto = (FranchiseeDataDTO)sqlMap.queryForObject("franchisee.getFranchiseeLastConfirmLog", num);
			
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
	        
			return  "redirect:/dashAgreeList.do?pageNum=1";	
	}
	
	//관리자 페이지 가맹점 신청 리스트
	@RequestMapping("dashAgreeList.do")
	public String dashAgreeList(String pageNum,String pageNum1,HttpServletRequest request,HashMap map){
		Alarm(request);
		if (pageNum == null) {pageNum = "1";}
		int count1 = 0; //글 갯수 초기화
		List articleList1 = null;
                             
        /////////////////////////////////////////////////////////////////////////////////
        //사장님이 보유한 가맹점 리스트
        /////////////////////////////////////////////////////////////////////////////////
        int pageSize = 5; //페이지당 5개씩 보여줌 고정
        int currentPage = Integer.parseInt(pageNum);
        int startRow = (currentPage - 1) * pageSize; //시작 행번호  0  5 10  
        count1 = (Integer)sqlMap.queryForObject("admin.getFranchiseeListCount", null); //가맹점 정보의 갯수를 가져온다.
        if (count1 > 0) {
        	map.put("startRow", startRow);
        	map.put("pageSize",pageSize);
            articleList1 = sqlMap.queryForList("admin.getFranchiseeList", map); //가맹점 리스트를 뽑아온다.
        } else {
            articleList1 = Collections.EMPTY_LIST;
        }   
        int pageCount = count1 / pageSize + (count1%pageSize == 0? 0:1);
		int startPage = ((Integer.parseInt(pageNum)-1)/10)*10+1;
		int pageBlock = 10;
		int endPage = startPage + pageBlock - 1;
		if(endPage > pageCount){endPage = pageCount;}
        
        request.setAttribute("pageCount", pageCount);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("count1", count1);
        request.setAttribute("pageNum", pageNum);
        request.setAttribute("articleList1", articleList1);
        /////////////////////////////////////////////////////////////////////////////////
        //가맹점 신청중인 리스트
        /////////////////////////////////////////////////////////////////////////////////

        if (pageNum1 == null) {pageNum1 = "1";}
		int count2 = 0; //글 갯수 초기화
		List articleList2 = null; 
        
        int currentPage2 = Integer.parseInt(pageNum1);
        int startRow2 = (currentPage2 - 1) * pageSize;
        
        count2 = (Integer)sqlMap.queryForObject("admin.getFranchiseeAddListCount", null); //가맹점 정보의 갯수를 가져온다.
        if (count2 > 0) {
        	map.put("startRow", startRow2);
        	map.put("pageSize",pageSize);
            articleList2 = sqlMap.queryForList("admin.getFranchiseeAddList", map); //가맹점 리스트를 뽑아온다.
        } else {
            articleList2 = Collections.EMPTY_LIST;
        }     
        
		int pageCount2 = count2 / pageSize + (count2%pageSize == 0? 0:1);
		int startPage2 = ((Integer.parseInt(pageNum1)-1)/10)*10+1;
		int endPage2 = startPage2 + pageBlock - 1;
		if(endPage2 > pageCount2){endPage2 = pageCount2;}
		
        request.setAttribute("pageCount2", pageCount2);
        request.setAttribute("startPage2", startPage2);
        request.setAttribute("endPage2", endPage2);
        request.setAttribute("count2", count2);
        request.setAttribute("pageNum1", pageNum1);
        request.setAttribute("articleList2", articleList2);
        
        return  "/dash-Agree/dashAgreeList";	
	}
	//관리자 페이지 가맹점 정보
	@RequestMapping("dashAgreeInfo.do")
	public String dashAgreeInfo(String b_name, Model model){
		FranchiseeDataDTO dto = null;
		dto = (FranchiseeDataDTO)sqlMap.queryForObject("franchisee.getFranchiseeLog", b_name);

		model.addAttribute("dto", dto);

			return  "/dash-Agree/dashFranchiseInfo";
		}
	// 관리자 페이지 가맹점 삭제
	@RequestMapping("dashAgreeDelete.do")
	public String dashAgreeDelete(String b_key,HashMap map){
		map.put("b_key", b_key);
		sqlMap.delete("franchisee.deleteFranchiseePolicy", map); //가맹점 삭제시 가맹점 정책 테이블 삭제
		sqlMap.delete("franchisee.deleteFranchisee", map); 
		return "/dash-Agree/dashAgreeDelete";
	}
	
	//관리자 페이지 알바 목록
	@RequestMapping("dashEmpAgreeList.do")
	public String dashEmpAgreeList(String pageNum,HttpServletRequest request,HashMap map){
		Alarm(request);
		if(pageNum==null){pageNum="1";}
		int currentPage=Integer.parseInt(pageNum);
		int pageSize=20;
		int startRow=(currentPage-1)*pageSize;
		List list =null;
		int count = 0;
		// 검색 키워드 조건으로 리스트 따로 호출
		if(request.getParameter("keyword")!=null){
			String keyword = request.getParameter("keyword");
			map.put("keyword", keyword);
			count = (Integer)sqlMap.queryForObject("admin.getFranchiseeListSearchCount", keyword);
			if(count>0){
				map.put("keyword", keyword);
				map.put("pageSize", pageSize);
				map.put("startRow",startRow);
				list = sqlMap.queryForList("admin.getFranchiseeSearchList",map);
			}else{
				list = Collections.EMPTY_LIST;
			}
		}else{
			count = (Integer)sqlMap.queryForObject("admin.getFranchiseeListCount",null );
			
			if(count>0){
				map.put("pageSize", pageSize);
				map.put("startRow",startRow);
				list = sqlMap.queryForList("admin.getBossFranchiseeList",map);
			}else{
				list = Collections.EMPTY_LIST;
			}
		}
		int pageCount = count / pageSize + (count%pageSize == 0? 0:1);
		int startPage = ((Integer.parseInt(pageNum)-1)/10)*10+1;
		int pageBlock = 10;
		int endPage = startPage + pageBlock - 1;
		if(endPage > pageCount){endPage = pageCount;}
		request.setAttribute("count", count);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("list",list);
		return "/dash-Agree/dashEmpAgreeList";
	}
	@RequestMapping("dashemployeeManageInfo.do")
	public String dashemployeeManageInfo(HttpServletRequest request){
		String id=request.getParameter("b_id");
		String b_key=request.getParameter("b_key");
		String b_name=request.getParameter("b_name");
		HashMap map = new HashMap();
		map.put("id", id);
		map.put("b_key", b_key);
		
		
		//////////////////////////////////////////////
		///임시로 추가함
		List list = new ArrayList();
		list = (List)sqlMap.queryForList("erpEmp.getEmployeeAddLog",map); // 알바생 신청 목록
		request.setAttribute("list",list);
		int count1 = (Integer)sqlMap.queryForObject("erpEmp.getEmployeeAddLogCount", map); // 알바생 신청 목록 카운트
		//////////////////////////////////////////////
		//알바생 아이디정보를 리스트로 불러옴, 파트 
		List list2 = new ArrayList();
		list2 = (List)sqlMap.queryForList("erpEmp.getEmployeeDeleteList", map);
		request.setAttribute("list2",list2);
		int count2 = (Integer)sqlMap.queryForObject("erpEmp.getEmployeeDeleteListCount", map);
		
		request.setAttribute("count1", count1);
		request.setAttribute("count2", count2);
		request.setAttribute("b_name",b_name);
		return "/dash-Agree/dashEmpAgreeBlank";
	}
	
	//관리자 페이지 알바생 아이디 추가신청에 대한 확인 및 아이디 발급
	@RequestMapping("dashEmployeeAddAdminConfirm.do")
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
					//checkIdInt 가 겹치기 않게 +1을 한다.
					checkIdInt += 1;
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
								sqlMap.insert("test.userAccountInsertE", e_id);
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
									sqlMap.insert("test.userAccountInsertE", e_id);
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
		
		return "/dash-Agree/reLoad";
	}
	
	//관리자 알바생 아이디 삭제 신청 승인
	@RequestMapping("dashEmployeeDeleteAdminConfirm.do")
	public String employeeDeleteAdminConfirm(Model model, String e_id){
		int check = 0;
		try{
			sqlMap.delete("test.userAccountDeleteE",e_id);
			sqlMap.update("erpEmp.deleteIdLogAddConfirm", e_id);
			sqlMap.delete("erpEmp.deleteEidEmployeeInfo", e_id);
			sqlMap.delete("erpEmp.deleteEidUserInfo", e_id);
			check  = 4;
		}catch(Exception e){e.printStackTrace();check = 2;}
		
		model.addAttribute("check", check);
		
		return "/dash-Agree/reLoad";
	}
	
	//일일정산 요청 승인 
	@RequestMapping("/AcceptingRequest.do")
	public String AcceptingRequest(String pageNum, HttpServletRequest request){
		
		int check = 2;
		
		List accept = sqlMap.queryForList("cash.accept", check);
		
		System.out.println("accept = " + accept);
		
		/*내역 리스트 *********************************************************************/
		if (pageNum == null) {
            pageNum = "1";
        }
        int pageSize = 5;
        int currentPage = Integer.parseInt(pageNum);
        int startRow = (currentPage - 1) * pageSize + 1;
        int endRow = currentPage * pageSize;
        int count = 0;
        int number= 0;
        
        count = (Integer)sqlMap.queryForObject("cash.acceptCount", check);
        System.out.println("가맹점에서 이용한 사용한 내역 카운트 =" + count);
        List articleList = null;
        
        
        
        if(count > 0){
        	HashMap r = new HashMap<>();
     	    r.put("startRow", startRow);
     	    r.put("endRow", endRow);
     	    r.put("check", check);
     	   
     	    articleList = sqlMap.queryForList("cash.accept", r);
     	    
        } else {
        	articleList = Collections.EMPTY_LIST;
        }
        
        number = count - (currentPage - 1) * pageSize;
        /**************************************************************************************************/
        request.setAttribute("articleList", articleList);
        request.setAttribute("currentPage", new Integer(currentPage));
        request.setAttribute("startRow", new Integer(startRow));
        request.setAttribute("endRow", new Integer(endRow));
        request.setAttribute("count", new Integer(count));
        request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		
		return "/dash-AcceptingRequest/AcceptingRequest";
	}
	@RequestMapping("/AcceptingRequestPro.do")
	public String AcceptingRequestPro(HttpServletRequest request){
		//가맹키 배열로 받음
		String[] chbox = request.getParameterValues("chbox"); 
		
		// 시간계산 코드
		Calendar day = Calendar.getInstance();
        day.add(Calendar.DATE , -1);
        
        //현재 오늘일 기준으로 어제 시작 일 00:00:00  코드
    	String startDate = new java.text.SimpleDateFormat("yyyy-MM-dd 00:00:00").format(day.getTime());
    	System.out.println("startDate" + startDate);
    	//현재 오늘일 기준으로 어제 종료 일 23:59:59  코드
    	String endDate = new java.text.SimpleDateFormat("yyyy-MM-dd 23:59:59").format(day.getTime());
    	System.out.println("endDate" + endDate);
    	
    	//chbox를 배열로 받아 리스트로 변경 해주는 코드
		ArrayList<String> arrayList = new ArrayList<>();
		for(String temp : chbox){
		  arrayList.add(temp);
		}
		
		
		for(int i=0; i<chbox.length; i++){
			System.out.println("chbox ㄴㅇ" + chbox[i]);
			HashMap idx = new HashMap<>();
			idx.put("idx", chbox[i]);
			 String b_key = (String)sqlMap.queryForObject("admin.getAcceptingRequestB_key", idx);
			 System.out.println("b_key" + b_key);
			 
			 HashMap info = new HashMap<>();
			 info.put("b_key", b_key);
			 info.put("start", startDate);
			 info.put("end", endDate);
			 
			 
			 List num = (List) sqlMap.queryForList("admin.getTitle", info);
			 
			 //알바비 포함하고 정산하는 경우
			 if(num != null){
				 int sum=0; // 알바들의 알바비 총합
				 int Amount=0; // 가맹점 요청 정산 금액
				 int settlementAmount=0; // 최종 정산 승인시 삽입될 금액
				 
				 //알바들 num값  각각 돌리기
				 for (int p = 0; p<num.size(); p++) {		       
		           
		            HashMap nupm = new HashMap<>();
		            nupm.put("num", num.get(p));
		            
		            //각각 받은 num값으로 하루 일한 금액 추출 
		            List paySum = (List) sqlMap.queryForList("admin.getSumEmployeeWorkTimePay", nupm);
		            
		            //각각 받은 금액을 가맹점별로 따른 계산을 하여 일일 정산신 요청금액 - 합금액 = 최종금액 구하기 
		            for(int pay=0; pay<paySum.size(); pay++){
		            	
		            	// 가맹점당 알바비 합산 금액 코드
		            	int payValue = (int) paySum.get(pay);
		            	sum += payValue;
		            	
		            	// 가맹점의 정산요청시 금액 코드
		            	Amount = (int)sqlMap.queryForObject("cash.getSettlementAmount", idx);
		            	
		            	// 최종 승인에 삽입될 금액 코드
		            	settlementAmount = Amount-sum;
		            	
		            	HashMap FinalAmountValues = new HashMap<>();
		            	FinalAmountValues.put("idx", chbox[i]); // 가맹점 고유 키
		            	FinalAmountValues.put("settlementAmount", settlementAmount); // 최종정산에 들어갈 금액 (알바비 - 가맹점 요청 금액)
		            	
		            	//알바비를 포함하여 정산 하는 쿼리
		            	sqlMap.update("cash.approval2", FinalAmountValues);
		            
		            }
			     } 
			 //알바비 없이 정산하는 경우
			 }else{
				//알바비를 포함하지 않고 정산 하는 쿼리
				 sqlMap.update("cash.approval", idx);
			 }
		}
		
		return "/dash-AcceptingRequest/AcceptingRequestPro";
	}
}
