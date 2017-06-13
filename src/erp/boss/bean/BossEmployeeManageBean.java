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
	@RequestMapping("bossEmployeeManageMain.do")
	public String bossEmployeeInfoMain(Model model, HttpSession session){
		
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		model.addAttribute("sidemenuCheck", sidemenuCheck);
		model.addAttribute("sidemenu", sidemenu);
		//변수들을 페이지로 전달
		
		//세션 아이디를 페이지로전달
		String id = (String)session.getAttribute("loginId");
		model.addAttribute("id",id);
		
		
		return "/bosserpmanage/bossEmployeeManageMain";
	}
	
	//사장님 알바생 추가 페이지로이동
	@RequestMapping("bossEmployeeAdd.do")
	public String bossEmployeeAdd(Model model, HttpSession session){
		
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		model.addAttribute("sidemenuCheck", sidemenuCheck);
		model.addAttribute("sidemenu", sidemenu);
		//변수들을 페이지로 전달
		
		//세션 아이디를 페이지로전달
		String id = (String)session.getAttribute("loginId");
		model.addAttribute("id",id);
		
		return "/bosserpmanage/bossEmployeeAdd";
	}
	
	//사장님 알바생 추가[처리] 페이지로 이동
	@RequestMapping("bossEmployeeAddPro.do")
	public String bossEmployeeAddPro(Model model, HttpSession session, BossEmployeeManageDataDTO beDTO){
		
		//세션 아이디를 페이지로전달
		String b_id = (String)session.getAttribute("loginId");
		model.addAttribute("b_id",b_id);
		
		int check = 0;
		
		//로그인 하지 않았을때 그냥 폼은 보여주지만, 아무것도할수없다.
		if(b_id == null){
			check = 9; //비회원이 싸이트로 접속했을때.
			return "/bosspcuse/franchiseeAddPro";
		}
		
		try{
			//입력된 정보를 로그에 남겨줍니다.
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
	
	model.addAttribute("check", check);
		
			return "/bosserpmanage/bossEmployeeAddPro";
	}	
	
	//알바생 정보 LIST
	@RequestMapping("bossEmployeeInfoList.do")
	public String bossEmployeeInfoUpdate(Model model, HttpSession session){
		
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		model.addAttribute("sidemenuCheck", sidemenuCheck);
		model.addAttribute("sidemenu", sidemenu);
		//변수들을 페이지로 전달
		
		//세션 아이디를 페이지로전달
		String id = (String)session.getAttribute("loginId");
		model.addAttribute("id",id);
		
		int count = 0; //알바생수 초기화
		UserInfoDataDTO userDTO = null;
		ArrayList employeeIdInfoList = null;
        
        count = (Integer)sqlMap.queryForObject("erpEmp.getEmployeeIdCount", id); //알바생 아이디 수
        if (count > 0) {
        	HashMap map = new HashMap();
        	employeeIdInfoList = new ArrayList();
        	
			for(int i = 0; i < count; i ++){
	        	map.put("id", id);
				map.put("i", i);
				userDTO = (UserInfoDataDTO)sqlMap.queryForObject("erpEmp.getEmployeeIdInfoList", map);
				employeeIdInfoList.add(userDTO);
				map.clear();
			}
			
        } else {
        	
        }
        int idCount = 0;
		if(employeeIdInfoList == null){
		}else{
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
		
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		model.addAttribute("sidemenuCheck", sidemenuCheck);
		model.addAttribute("sidemenu", sidemenu);
		//변수들을 페이지로 전달
		
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
