package erp.boss.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import login.user.bean.UseTimeLogDTO;
import superclass.all.bean.ParsingDate;
import superclass.all.bean.SuperClass;

@Controller
public class BossEmployeeManageBean2 {

	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	@Autowired
	protected ParsingDate pd;
	
	@Autowired
	protected SuperClass sc;
	
	//사장님 알바생관리 메인 페이지
	@RequestMapping("employeeLoginList.do")
	public String employeeLoginList(Model model, HttpSession session, String pageNum, String num){
		
		sc.sideMenuTemp(model, 1, 3); //sidemenu template
		
		String id = sc.getSessionIdModelId(model, session); //sessionId, model.addAttribute(id) template
		
		///////////////////////////////////////////////////////
		//알바생 로그인 로그아웃 한 것에 대한 리스트//
		///////////////////////////////////////////////////////
		
		if (pageNum == null) {
            pageNum = "1";
        }
		
        int pageSize = 50; //페이지당 50개씩 보여줌
        int currentPage = Integer.parseInt(pageNum);
        int startRow = (currentPage - 1) * pageSize + 1; //시작 행번호
        int endRow = currentPage * pageSize; //끝 행 번호
        int count = 0; //글 갯수 초기화
        int number = 0; // 글 번호 초기화

        List articleList = null; 
        
        UseTimeLogDTO utlDto = null;
        Long substract = null;
        int substractint = 0;
        
        
        count = (Integer)sqlMap.queryForObject("erpEmp.getEmployeeLoginLogoutLogListCount", id); //알바생 로그인로그아웃 이력의 갯수를 센다.
        if (count > 0) {
        	HashMap map = new HashMap(); //HashMap에 여러가지정보 (시작행번호, 마지막행번호)넣어 한번에 보낸다.
        	map.put("id", id);
        	map.put("startRow", startRow);
        	map.put("endRow", endRow);
            articleList = sqlMap.queryForList("erpEmp.getEmployeeLoginLogoutLogList", map); //알바생 로그인로그아웃 이력을 가져온다.
            
            //알바생 급여 에 대한 계산을 30초 단위로 한다.
            for(int i = 0; i < articleList.size(); i ++){
            	utlDto = null;
            	utlDto = (UseTimeLogDTO)articleList.get(i);
            	substract = utlDto.getLogoutTime().getTime() - utlDto.getLoginTime().getTime();
            	//밀리초단위로 결과가 나옴.
            	substractint = (int)(substract/1000); //초단위
            	utlDto.setWorkTime(substractint);
            }
            
            
        } else {
            articleList = Collections.EMPTY_LIST;
        }
		
		model.addAttribute("articleList",articleList);
		model.addAttribute("count",count);
		model.addAttribute("number",number);
        
		return "/bossERP/employeeManage/employeeLoginList";
	}
	
	
	
	//사장님 알바생관리 메인 페이지
	@RequestMapping("employeeCalender.do")
	public String employeeCalender(Model model){
		
		sc.sideMenuTemp(model, 1, 3); //sidemenu template
		
		return "/bossERP/employeeManage/employeeCalender";
	}
	
	//알바생 일정 추가하기전에 검색하기
	@RequestMapping("employeeCalenderEventInsertCheck.do")
	public ModelAndView employeeCalenderEventInsertCheck(HttpSession session, Model model, Long start, Long end){
		
		String id = sc.getSessionIdModelId(model, session); //sessionId, model.addAttribute(id) template
		String returnText = "";
		ModelAndView mv = new ModelAndView();
		
		HashMap map = new HashMap();
		map.put("id", id);
		map.put("start", pd.longToTimestamp(start-32400000));
		map.put("startBeforDay", pd.longToTimestamp(start-86400000-32400000));
		map.put("end", pd.longToTimestamp(end-32400000));
		map.put("endAfterDay", pd.longToTimestamp(end+86400000-32400000));
		try{
			int check = (Integer)sqlMap.queryForObject("erpEmp.calenderInsertTimeCheck", map);
			if(check == 0){
				check = (Integer)sqlMap.queryForObject("erpEmp.calenderInsertTimeCheckNight", map);
				if(check == 1){
					returnText = "선택한 일정에는 이미 "+check+" 개의 일정이 추가 되어있습니다. ";
				}else{
					check = (Integer)sqlMap.queryForObject("erpEmp.calenderInsertTimeCheckNight2", map);
					if(check == 1){
						returnText = "선택한 일정에는 이미 "+check+" 개의 일정이 추가 되어있습니다. ";
					}
				}
			}else{//check != 0 뭔가 있을때
				returnText = "선택한 일정에는 이미 "+check+" 개의 일정이 추가 되어있습니다. ";
			}
			model.addAttribute("jsonList", returnText);
			mv.setViewName("/bossERP/employeeManage/employeeCalenderJSON");
		}catch(Exception e){
			
		}
		return mv;
	}
	
	//알바생 일정 추가하기
	@RequestMapping("employeeCalenderInsert.do")
	public String employeeCalenderInsert(HttpSession session, Model model, Long start, Long end){
		
		String id = sc.getSessionIdModelId(model, session); //sessionId, model.addAttribute(id) template
		
		model.addAttribute("start",start);
		model.addAttribute("end",end);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String starts = df.format(start);
		String ends = df.format(end-86400000);
		
		DateFormat df2 = new SimpleDateFormat("dd");
		String forDate = df2.format(end-start-86400000);
		
		model.addAttribute("starts",starts);
		model.addAttribute("ends",ends);
		model.addAttribute("forDate",forDate);
		
		return "/bossERP/employeeManage/employeeCalenderInsert";
	}
	
	//알바생 일정 추가 처리
	@RequestMapping("employeeCalenderInsertPro.do")
	public ModelAndView employeeCalenderInsertPro(HttpSession session, Model model, BossEmployeeManageDataDTO beDTO){
		int check = 9;
		
		beDTO.setBorderColor(beDTO.getBackgroundColor()); //이벤트 선택된 배경과 경계선 생상이 같다.
		String id = (String)session.getAttribute("loginId");
		String b_key = (String)session.getAttribute("b_key");
		beDTO.setId(id);
		beDTO.setB_key(b_key);
		
		Long startDate = pd.stringToLongDay(beDTO.getStartDate());
		Long endDate = pd.stringToLongDay(beDTO.getEndDate());
		Long startHour = Long.parseLong(beDTO.getStartHour());
		Long endHour = Long.parseLong(beDTO.getEndHour());
		
		int forDate = Integer.parseInt(beDTO.getForDate());
		
		if(startHour < endHour){
			
			
			if(forDate > 1){
				endDate = startDate + endHour;
				startDate += startHour;
			}else{
				startDate += startHour;
				endDate += endHour;
			}
			

			try{
				for(int i = 0; i < forDate; i++){
					beDTO.setStartTime(pd.longToTimestamp(startDate+i*86400000));
					beDTO.setEndTime(pd.longToTimestamp(endDate+i*86400000));
					
					sqlMap.insert("erpEmp.calenderInsertTime", beDTO);	
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{// endHour < startHour 새벽근무자
			if(forDate > 2){
				check = 9;//2일이상 종일근무시 불가능하다는 경고창을 보낸다.
			}else{
				startDate += startHour;
				endDate += endHour;
				
				beDTO.setStartTime(pd.longToTimestamp(startDate));
				beDTO.setEndTime(pd.longToTimestamp(endDate));
				
				sqlMap.insert("erpEmp.calenderInsertTime", beDTO);
			}

		}
		
		model.addAttribute("check", check);
		
		return new ModelAndView("redirect:/employeeCalender.do");	
	}
	
	//알바생 일정 JSON으로 불러오기 AJAX
	@RequestMapping("employeeCalenderList.do")
	public ModelAndView employeeCalenderList(HttpSession session, Model model, BossEmployeeManageDataDTO beDTO){
		ModelAndView mv = new ModelAndView();
		List list = new ArrayList();
		
		String id = sc.getSessionIdModelId(model, session); //sessionId, model.addAttribute(id) template
		String b_key = (String)session.getAttribute("b_key");
		
		try{
			
			ObjectMapper mapper = new ObjectMapper();
			
			String b_id = (String)sqlMap.queryForObject("erpEmp.getEidBid", id);
			list = (List)sqlMap.queryForList("erpEmp.getCalenderWorkTimeList", b_key);

			String jsonList = mapper.writeValueAsString(list);
			mv.setViewName("/bossERP/employeeManage/employeeCalenderJSON");
			//굳이 ModelAndView를 사용했다. String으로 반환해도되는데
			model.addAttribute("jsonList", jsonList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mv;
	}
	
	//알바생 일정 이벤트드랍시 변경 처리 AJAX
	@RequestMapping("employeeCalenderEventDrop.do")
	public ModelAndView employeeCalenderEventDrop(HttpSession session, Model model, String date){
		
		String e_id = (String)session.getAttribute("loginId");
		String b_key = (String)session.getAttribute("b_key");
		
		try{
			
			JSONParser Jparser = new JSONParser();
			
			JSONObject JObject = (JSONObject)Jparser.parse(date);
			String start = (String)JObject.get("start");
			String end =  (String)JObject.get("end");
			String dragPlanStart = (String)JObject.get("dragPlanStart");
			String dragPlanEnd =  (String)JObject.get("dragPlanEnd");
			
			
			HashMap map = new HashMap();
			map.put("e_id", e_id);
			map.put("start", start);
			map.put("end", end);
			map.put("b_key", b_key);
			map.put("dragPlanStart", dragPlanStart);
			map.put("dragPlanEnd", dragPlanEnd);
			
			sqlMap.insert("erpEmp.calenderUpdateTimeLog", map); //근무시간 변경 로그남김
			sqlMap.update("erpEmp.calenderUpdateTime", map); //근무시간 변경
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return new ModelAndView("ajaxView");
	}
	
		//알바생 일정 직접 수정 정보보기 AJAX
		@RequestMapping("employeeCalenderEventInfo.do")
		public String employeeCalenderEventInfo(HttpSession session, Model model, String eventInfoDateStart, String eventInfoDateEnd){
			
			String e_id = (String)session.getAttribute("loginId");
			String b_key = (String)session.getAttribute("b_key");
			
			model.addAttribute("eventInfoDateStart", eventInfoDateStart);
			model.addAttribute("eventInfoDateEnd", eventInfoDateEnd);
			
			return "/bossERP/employeeManage/employeeCalenderEventInfo";
		}	
	
		//알바생 일정 직접 수정 정보 변경 AJAX
		@RequestMapping("employeeCalenderEventInfoUpdatePro.do")
		public ModelAndView employeeCalenderEventInfoUpdatePro(HttpSession session, Model model,String eventInfoDateStart,String eventInfoDateEnd, String eventInfoChagneDateStart, String eventInfoChangeDateEnd){
			
			String e_id = (String)session.getAttribute("loginId");
			String b_key = (String)session.getAttribute("b_key");
			
			try{
				HashMap map = new HashMap();
				map.put("dragPlanStart", eventInfoDateStart);
				map.put("dragPlanEnd", eventInfoDateEnd);
				map.put("start", eventInfoChagneDateStart);
				map.put("end", eventInfoChangeDateEnd);
				map.put("e_id", e_id);
				map.put("b_key", b_key);			
				
				sqlMap.insert("erpEmp.calenderUpdateTimeLog", map); //근무시간 변경 로그남김
				sqlMap.update("erpEmp.calenderUpdateTime", map); //근무시간 변경
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return new ModelAndView("redirect:/employeeCalender.do");
		}	
	
		
		
		//알바생 일정 직접 수정정보 의 삭제 AJAX
		@RequestMapping("employeeCalenderEventDelete.do")
		public ModelAndView employeeCalenderEventDelete(HttpSession session, Model model, String eventInfoDateStart, String eventInfoDateEnd){
			String e_id = (String)session.getAttribute("loginId");
			String b_key = (String)session.getAttribute("b_key");
			
			String check = "";
			
			try{
				HashMap map = new HashMap();
				map.put("dragPlanStart", eventInfoDateStart);
				map.put("dragPlanEnd", eventInfoDateEnd);
				map.put("e_id", e_id);
				map.put("b_key", b_key);			
				//
				sqlMap.insert("erpEmp.calenderDeleteTimeLog", map); //근무시간 변경 로그남김
				sqlMap.delete("erpEmp.calenderDeleteTime", map); //근무시간 변경
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return new ModelAndView("ajaxView");
		}	
	
}
