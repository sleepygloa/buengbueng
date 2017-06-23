package erp.boss.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import login.user.bean.UseTimeLogDTO;
import superclass.all.bean.ParsingDate;

@Controller
public class BossEmployeeManageBean2 {

	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	@Autowired
	protected ParsingDate pd;
	
	//사장님 알바생관리 메인 페이지
	@RequestMapping("employeeLoginList.do")
	public String employeeLoginList(Model model, HttpSession session, String pageNum, String num){
		
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		model.addAttribute("sidemenuCheck", sidemenuCheck);
		model.addAttribute("sidemenu", sidemenu);
		//변수들을 페이지로 전달
		
		//세션 아이디를 페이지로전달
		String id = (String)session.getAttribute("loginId");
		model.addAttribute("id",id);
		
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
		
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		model.addAttribute("sidemenuCheck", sidemenuCheck);
		model.addAttribute("sidemenu", sidemenu);
		//변수들을 페이지로 전달
		
		return "/bossERP/employeeManage/employeeCalender";
	}
	
	//알바생 일정 추가하기
	@RequestMapping("employeeCalenderInsert.do")
	public String employeeCalenderInsert(HttpSession session, Model model, Long start, Long end){
		
		//세션 아이디를 페이지로전달
		String id = (String)session.getAttribute("loginId");
		model.addAttribute("id",id);
		
		model.addAttribute("start",start);
		model.addAttribute("end",end);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String starts = df.format(start);
		String ends = df.format(end-86400000);
		
		model.addAttribute("starts",starts);
		model.addAttribute("ends",ends);
		
		return "/bossERP/employeeManage/employeeCalenderInsert";
	}
	
	//알바생 일정 추가 처리
	@RequestMapping("employeeCalenderInsertPro.do")
	public String employeeCalenderInsertPro(HttpSession session, Model model, BossEmployeeManageDataDTO beDTO){
		
		int check = 9;
		
		String id = (String)session.getAttribute("loginId");
		String b_key = (String)session.getAttribute("b_key");
		beDTO.setId(id);
		beDTO.setB_key(b_key);
		
		Long startDate = pd.stringToLongDay(beDTO.getStartDate());
		Long endDate = pd.stringToLongDay(beDTO.getEndDate());
		Long startHour = Long.parseLong(beDTO.getStartHour());
		Long endHour = Long.parseLong(beDTO.getEndHour());
		
		startDate += startHour;
		endDate += endHour;
		
		beDTO.setStartTime(pd.longToTimestamp(startDate));
		beDTO.setEndTime(pd.longToTimestamp(endDate));
		
		try{
			sqlMap.insert("erpEmp.calenderInsertTime", beDTO);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		model.addAttribute("check", check);
		
		return "/bossERP/employeeManage/employeeCalenderInsert";	
	}
	
	//알바생 일정 JSON으로 불러오기 AJAX
	@RequestMapping("employeeCalenderList.do")
	public ModelAndView employeeCalenderList(HttpSession session, Model model, BossEmployeeManageDataDTO beDTO){
		ModelAndView mv = new ModelAndView();
		List list = new ArrayList();
		
		String id = (String)session.getAttribute("loginId");
		
		try{
			String b_id = (String)sqlMap.queryForObject("erpEmp.getEidBid", id);
			list = (List)sqlMap.queryForList("erpEmp.getCalenderWorkTimeList", b_id);
			
			mv.setViewName("/bossERP/employeeManage/employeeCalenderJSON");
			for(int i = 0; i < list.size(); i++){
				mv.addObject("title", ((EmployeeWorkTimeDTO)(list.get(i))).getE_id());
				mv.addObject("start", ((EmployeeWorkTimeDTO)(list.get(i))).getStartTime());
				mv.addObject("end", ((EmployeeWorkTimeDTO)(list.get(i))).getEndTime());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return mv;
			
	}
	
	
}
