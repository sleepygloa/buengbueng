package erp.boss.bean;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import login.user.bean.UserInfoDataDTO;
import superclass.all.bean.MenuCategoryDivResponse;

@Controller
public class BossEmployeeManageBean {

	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	
	//사장님 알바생관리 메인 페이지
	@RequestMapping("bossErpMain.do")
	public String bossEmployeeInfoMain(Model model, HttpSession session){
		
		//////////////////////////////////////////
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		model.addAttribute("sidemenuCheck", sidemenuCheck);
		model.addAttribute("sidemenu", sidemenu);
		//변수들을 페이지로 전달
		
		//////////////////////////////////////////
		//세션 아이디를 페이지로전달
		String id = (String)session.getAttribute("loginId");
		model.addAttribute("id",id);
		
		
		return "/bossERP/erpMain";
	}
	
	//사장님 알바생 관리 페이지로이동
	@RequestMapping("manageEmployee.do")
	public String bossEmployeeAdd(Model model, HttpSession session){
		
		//////////////////////////////////////////
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		model.addAttribute("sidemenuCheck", sidemenuCheck);
		model.addAttribute("sidemenu", sidemenu);
		//변수들을 페이지로 전달
		
		//////////////////////////////////////////
		//세션 아이디를 페이지로전달
		String id = (String)session.getAttribute("loginId");
		model.addAttribute("id",id);
		
		return "/bossERP/employeeManage/manageEmployee";
	}
	
	@RequestMapping("addEmployeeInfo.do")
	public String AddEmployeeIdAjax(Model model, HttpSession session, BossEmployeeManageDataDTO beDTO ){
			int lastNum = (Integer)sqlMap.queryForObject("erpEmp.getEmployeeAddLogLastNum", null);
			lastNum += 1;
			System.out.println(lastNum);
			model.addAttribute("lastNum", lastNum);
		
		return "/bossERP/employeeManage/employeeAddInfo";
	}
	
	@RequestMapping("AddEmployeeId.do")
	public String AddEmployeeId(Model model, HttpSession session, BossEmployeeManageDataDTO beDTO ){
			//1. 알바생 정보에서 사장님 정보가 없는 아이디를 검색
			//2-1. 있다면, 아이디에 사장님정보를 넣고 아이디를 추가한다.
			//2-2. 없다면, userInfo에 아이디를 제일 마지막번호로 생성, 
			//			생성한 아이디를 알바정보에 아이디와 사장정보를 입력
		
		
		
		
		//////////////////////////////////////////
		//세션 아이디를 페이지로전달
		String b_id = (String)session.getAttribute("loginId");
		model.addAttribute("b_id",b_id);		
		
		int check = 0;
		//로그인 하지 않았을때 그냥 폼은 보여주지만, 아무것도할수없다.
		//////////////////////////////////////////
		//비로그인접근, 잘못된 경로로 접근한사람 내쫓음
		if(b_id == null){
			check = 9; //비회원이 싸이트로 접속했을때.
			return "/bosspcuse/franchiseeAddPro";
		}		
		try{
			String fbinId = (String)sqlMap.queryForObject("erpEmp.findBossIdNull", null);//1. 알바생정보테이블에서 알바생아이디는 있지만 사장님아이디가없는 아이디를 검색한다.
			if(fbinId == null){ //반환된 값은 알바생 아이디
				//2-1. 사장님아이디가 비어있는 것에 사장님 아이디를 추가함.
				//먼저로그를 남긴다
//				sqlMap.update("erpEmp.", parameterObject)
			}else{
				//2-2.
			}
		}catch(Exception e){e.printStackTrace();}
		
		return "/bossERP/employeeManage/manageEmployee";
	}
	
	//사장님 알바생 추가[처리] 페이지로 이동
	@RequestMapping("bossEmployeeAddPro.do")
	public String bossEmployeeAddPro(Model model, HttpSession session, BossEmployeeManageDataDTO beDTO){
		
		//////////////////////////////////////////
		//세션 아이디를 페이지로전달
		String b_id = (String)session.getAttribute("loginId");
		model.addAttribute("b_id",b_id);
		
		int check = 0;
		//로그인 하지 않았을때 그냥 폼은 보여주지만, 아무것도할수없다.
		//////////////////////////////////////////
		//비로그인접근, 잘못된 경로로 접근한사람 내쫓음
		if(b_id == null){
			check = 9; //비회원이 싸이트로 접속했을때.
			return "/bosspcuse/franchiseeAddPro";
		}
		
		try{
			//입력된 정보를 로그에 남겨줍니다.
			//////////////////////////////////////
			//사장님이 알바생아이디를 (숫자)만큼 신청함. 
			sqlMap.insert("erpEmp.insertBossEmployeeAddLog", beDTO);
			check = 1;
			
		}catch(Exception e){
			check = 2;
		}
		
		
		String e_id = "";
		String checkId = "";
		String findId = null;
		BossEmployeeManageDataDTO beDTO2 = null;
		UserInfoDataDTO userDTO = null;
		int length = 0;
		int checkIdInt = 0;
		
//		try{
			//employeeInfo 테이블에서 알바생 아이디를 불러온다.
		if(sqlMap.queryForObject("erpEmp.getEmployeeId", b_id) != null){
			beDTO2 = (BossEmployeeManageDataDTO)sqlMap.queryForObject("erpEmp.getEmployeeId", b_id);
			 checkId = (beDTO2.getE_id().substring(8));
			 checkIdInt = Integer.parseInt(checkId);
		}
			
		
			//요청수가 더클때
			if(beDTO2 == null || beDTO2.getCount() < beDTO.getApplyCount()){
				
				if(beDTO2 == null){
					length = beDTO.getApplyCount();
				}else{
					length = beDTO.getApplyCount() - beDTO2.getCount();
				}
				
				
					checkIdInt += 1;
				for(int i = 0; i < length; i ++){
					checkIdInt += i;
					if(sqlMap.queryForObject("erpEmp.findBossIdNull", null) != null){
						findId = (String)sqlMap.queryForObject("erpEmp.findBossIdNull", null);
					}
					
					if(findId == null){
						e_id = "employee" + checkIdInt;
					}else{
						e_id = findId;
					}
										
					HashMap map = new HashMap();
					map.put("e_id", e_id);
					map.put("e_bossid", b_id);
					//회원 테이블에 새로운 아이디생성
					sqlMap.insert("erpEmp.insertEmployeeIdUserInfo", e_id);
					
					//알바테이블에 사장님아이디와 매칭, 아이디생성,
					sqlMap.insert("erpEmp.connectEmployeeIdBossId", map);
					
				}
			//매칭된 수와 요청한 수가 같을때
			}else if(beDTO2.getCount() == beDTO.getApplyCount()){
				
				check = 5; //변동이없다는 메세지
				model.addAttribute("check", check);
				return "/bosserpmanage/bossEmployeeAddPro";
			//요청수가 적을대, 아이디를 삭제 시킨다.
			}else{
				
				length = beDTO2.getCount() - beDTO.getApplyCount();
				ArrayList findIdArray = null;
				String pw = null;
								
				for(int j = 0; j < beDTO2.getCount(); j++){
					findIdArray = (ArrayList)sqlMap.queryForList("erpEmp.findBossIdNotNull", b_id);
				}
				
				for(int i = 0; i < beDTO2.getCount(); i ++){
					int j = 0;
					e_id = (String)findIdArray.get(i);
					pw = (String)sqlMap.queryForObject("erpEmp.findDeleteId", e_id);
					if(pw.equals("delete")){
						try{
							sqlMap.delete("erpEmp.deleteEmployeeId", e_id);
							sqlMap.delete("erpEmp.deleteUserId", e_id);
							j += 1;
							if(length == j){
								break;
							}
						}catch(Exception e){
							e.printStackTrace();
							check = 3;
						}
					}else{
					}
				}
			}
			
//		}catch(Exception e){
			
//		}
		try{
			////////////////////////////////////////////////////////////////
			//employeeInfo 테이블에서 알바생 아이디를 찾는다. 그런데 그냥 찾는 것이아니라
			//사장님이 고용한 알바생 총수와 알바생 넘버가 가장 큰 친구를 찾는다. 아이디형태 : employee2
			if(sqlMap.queryForObject("erpEmp.getEmployeeId", b_id) != null){
				beDTO2 = (BossEmployeeManageDataDTO)sqlMap.queryForObject("erpEmp.getEmployeeId", b_id);
				 checkId = (beDTO2.getE_id().substring(8)); //아이디 제일 마지막 숫자만 출력한다.
				 checkIdInt = Integer.parseInt(checkId); //숫자를 인트로 형변환한다.
			}
				
				/////////////////////////////////////////////////////////////////
				//사장님이 고용한 알바생수가 아에 없을때 null 이거나
				//신청한 수보다 알바생 수가 작을때
				if(beDTO2 == null || beDTO2.getCount() < beDTO.getApplyCount()){
					
					//알바생이 아에 없다면, 신청한 수만큼 알바아이디생성을 반복한다.
					if(beDTO2 == null){
						length = beDTO.getApplyCount();
					}else{
					//알바생이 있다면, 신청한 수 와 알바생수를 빼서, 뺀만큼만 반복 생성한다.
						length = beDTO.getApplyCount() - beDTO2.getCount();
					}
					
					//아까 찾은 제일 마지막으로 큰 숫자 가 2이라면, 3부터 시작할 수 있게 1을 더해준다. for문은 0부터 시작한다.
						checkIdInt += 1;
					for(int i = 0; i < length; i ++){
						checkIdInt += 1;
							//혹시라도 알바생아이디는 있지만, 사장님정보가 누락된 아이디가 있는지 확인한다. 있다면 그아이디를 findId에 넣어준다.
							if(sqlMap.queryForObject("erpEmp.findBossIdNull", null) != null){
								findId = (String)sqlMap.queryForObject("erpEmp.findBossIdNull", null);
							}
							
							//위의 IF에서 findId를 채우지 못햇다면, 알바생과 사장님 아이디가 매칭이되었다면
							if(findId == null){
							//+1 수를 employee수 로 붙여서 아이디를 만들고
								e_id = "employee" + checkIdInt;
							}else{
							//없다면 찾은 아이디를 생성한다.
								e_id = findId;
							}
						////////////////////////////
						//이렇게 만든아이디를 userInfo에 최초정보만 기입한다. 
						//알바생이 자신의 나머지정보를 입력할수있게한다. 이력서 작성하듯이.
						HashMap map = new HashMap();
						map.put("e_id", e_id);
						map.put("e_bossid", b_id);
						//회원 테이블에 새로운 아이디생성
						
						//새로 만든 알바생 아이디가 회원정보에 입력이 되어있따면?
						
						if(sqlMap.queryForObject("erpEmp.findEmployeeIdUserId", e_id) == null){
							sqlMap.insert("erpEmp.insertEmployeeIdUserInfo", e_id);//유저정보에 넣어준다.
							if(findId == null){
								
							}
							//보스아디를 알바정보에 넣어준다.
						}
						
						if(sqlMap.queryForObject("erpEmp.findEmployeeInfoNullBossId", b_id) != null){
							sqlMap.insert("erpEmp.connectEmployeeIdBossId", map);
						}else{
							sqlMap.update("erpEmp.updateEmployeeInfoNullBossId", e_id);
						}
						//알바생정보 테이블에 사장님아이디와 알바아이디를 새로 기입한다.
						
						//이 내용을 신청 수와 알바 생 수와 비교한 만큼 반복한다.
					}
					
				/////////////////////////////////////////////////////////////////	
				//매칭된 수와 요청한 수가 같을때, 메서드를 빠져나간다. JS alarm
				}else if(beDTO2.getCount() == beDTO.getApplyCount()){
					
					check = 5; //변동이없다는 메세지
					model.addAttribute("check", check);
					return "/bosserpmanage/bossEmployeeAddPro";
				
				/////////////////////////////////////////////////////////////////
				//신청한 수가 알바생보다 작을때는 알바생 아이디를 삭제 시킨다.
				//그러나 삭제를 할때는 꼭 알바생 비밀번호를 delete로 변경해야한다.
				}else{
					//알바생 수 - 신청 수 = 반복할 수
					length = beDTO2.getCount() - beDTO.getApplyCount();
					ArrayList findIdArray = null;
					String pw = null;
									
					for(int j = 0; j < beDTO2.getCount(); j++){
						//사장님의 알바생들의 아이디를 찾을 건데, 가장높은 순으로 정렬한다.
						findIdArray = (ArrayList)sqlMap.queryForList("erpEmp.findBossIdNotNull", b_id);
					}
					
					for(int i = 0; i < beDTO2.getCount(); i ++){
						int j = 0;
						e_id = (String)findIdArray.get(i);
						//가장 높은 수의 아이디부터 비밀번호를 찾아와서 비밀번호가 delete인지 비교한다.
						pw = (String)sqlMap.queryForObject("erpEmp.findDeleteId", e_id);
						if(pw.equals("delete")){
							try{
								//먼저, 알바생정보 테이블에서 아이디를 삭제하고, 회원테이블에서 아이디를 삭제시킨다. 
								sqlMap.delete("erpEmp.deleteEmployeeId", e_id);
								sqlMap.delete("erpEmp.deleteUserId", e_id);
								///////////////////////////////////////////////////////////////////
								//삭제가 성공했을때 count를 1씩올려주고 그 수가 삭제 해야하는 수와 같아지만 Query를 종료한다.
								j += 1;
								if(length == j){
									break;
								}
							}catch(Exception e){
								e.printStackTrace();
								check = 3; //삭제실패
							}
						}else{
						}
					}
				}
				
		}catch(Exception e){
			e.printStackTrace();
		}
	
	model.addAttribute("check", check);
		
			return "/bosserpmanage/bossEmployeeAddPro";
	}	
	
	//알바생 정보 LIST
	@RequestMapping("bossEmployeeInfoList.do")
	public String bossEmployeeInfoUpdate(Model model, HttpSession session){
		
		//////////////////////////////////////////
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		model.addAttribute("sidemenuCheck", sidemenuCheck);
		model.addAttribute("sidemenu", sidemenu);
		//변수들을 페이지로 전달
		
		//////////////////////////////////////////
		//세션 아이디를 페이지로전달
		String id = (String)session.getAttribute("loginId");
		model.addAttribute("id",id);
		
		//////////////////////////////////////////
		//알바생 게시판		
		int count = 0; //알바생수 초기화
		UserInfoDataDTO userDTO = null;
		ArrayList employeeIdInfoList = null;
        
		//알바생 수를 센다.
        count = (Integer)sqlMap.queryForObject("erpEmp.getEmployeeIdCount", id); //알바생 아이디 수
        if (count > 0) {
        	HashMap map = new HashMap();
        	employeeIdInfoList = new ArrayList();
        	
			for(int i = 0; i < count; i ++){
	        	map.put("id", id);
				map.put("i", i);
				//알바생 정보를 list로 출력한다.
				userDTO = (UserInfoDataDTO)sqlMap.queryForObject("erpEmp.getEmployeeIdInfoList", map);
				employeeIdInfoList.add(userDTO);
				map.clear();
			}
			
        } else {
        	
        }
        int idCount = 0;
		if(employeeIdInfoList == null){
		}else{
		///////////////////////////////////////////////////////////////////////////////////////////////
		//알바생 List를 반응형CSS로 제공한다.
			idCount = employeeIdInfoList.size();
			 String menuDiv = MenuCategoryDivResponse.MenuCategoryDivResponse(idCount, employeeIdInfoList);
			 model.addAttribute("menuDiv",menuDiv);
		}
        
        model.addAttribute("idCount",idCount);
        model.addAttribute("count",count);
        model.addAttribute("employeeIdInfoList",employeeIdInfoList);
        
		return "/bosserpmanage/bossEmployeeInfoList";
	}	
	

	//알바생 정보 보기
	@RequestMapping("bossEmployeeInfo.do")
	public String bossEmployeeInfo(Model model, String id){
		
		//////////////////////////////////////////
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		model.addAttribute("sidemenuCheck", sidemenuCheck);
		model.addAttribute("sidemenu", sidemenu);
		//변수들을 페이지로 전달
		
		
		////////////////////////////////////////////////////////////////////////////////
		//알바생 리스트에서 클릭했을 때 정보를 불러온다.
		UserInfoDataDTO userDto = null;
		userDto = (UserInfoDataDTO)sqlMap.queryForObject("erpEmp.getEmployeeIdInfo", id);
		
		model.addAttribute("userDto", userDto);
		
		return "/bosserpmanage/bossEmployeeInfo";
	}
	
	//알바생 정보 변경
	@RequestMapping("bossEmployeeUpdate.do")
	public String bossEmployeeUpdate(UserInfoDataDTO dto,Model model){
		int check = 0;
		try{
			////////////////////////////////////////////////////////////////////////////
			//알바생정보를 수정한다.
			sqlMap.update("erpEmp.updateEmployeeId", dto);
			check = 1;
		}catch(Exception e){
			check = 2;
			e.printStackTrace();
		}
		model.addAttribute("check", check);
		
		return "/bosserpmanage/bossEmployeeInfoUPro";
	}
	
}
