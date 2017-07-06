package manage.admin.bean;


import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import login.user.bean.UserInfoDataDTO;

@Controller
public class DashUserBean extends BoardMethodBean{
	
	@Autowired
	SqlMapClientTemplate sqlMap;

	// 관리자 페이지
	@RequestMapping("dashIndex.do") 
	String dashIndex(HttpServletRequest request){
		Alarm(request);// 알람 메서드
		return "dashIndex";
	}
	
	// 관리자 페이지 회원정보 
	@RequestMapping("dashUser.do")
	public String dashUser(HttpServletRequest request,HashMap map){
		Alarm(request);// 알람 메서드
		int grade = Integer.parseInt(request.getParameter("grade"));
		String pageNum = request.getParameter("pageNum");
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");			
		if(pageNum==null){pageNum="1";}
		
		int pageSize=10; // endRow와 같이써도 가능함. mysql limit 사용시. 출력은 고정.
		int currentPage = Integer.parseInt(pageNum);
	    int startRow = (currentPage - 1) * pageSize; // mysql에서 limit 는 0부터 시작해야 rownum 1번 값부터 호출

	    int count=0;
	    List list= null;
	    String[] dates = null;
	    count = (Integer)sqlMap.queryForObject("admin.userCount", grade); //해당 페이지 내용 갯수
	    if (count > 0) {
	    	map.put("grade", grade);
	    	map.put("startRow", startRow);
	    	map.put("pageSize",pageSize);
	    	list = sqlMap.queryForList("admin.userList", map);
            dates = new String[count];
			for(int i = 0; i< list.size(); i++){
				dates[i] = sdf.format(((UserInfoDataDTO)list.get(i)).getSigndate());
				}
	    }else{
	    	list = Collections.EMPTY_LIST;
	    }
	    
	    // 페이지 카운트
        int pageCount = count / pageSize + ( count % pageSize == 0 ? 0 : 1);
		 
        int startPage = ((Integer.parseInt(pageNum)-1)/10)*10+1;
		int pageBlock=10;
        int endPage = startPage + pageBlock-1;
        if (endPage > pageCount) endPage = pageCount;
        
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("grade", grade);
		request.setAttribute("dates", dates);
		return "/dash-userInfo/dashUser";
	}
	// 관리자 페이지 회원 삭제
	@RequestMapping("dashDelete.do")
	public String dashDelete(HttpServletRequest request){
		Alarm(request);// 알람 메서드
		String id = request.getParameter("id");
		UserInfoDataDTO dto = (UserInfoDataDTO)sqlMap.queryForObject("test.getUserInfo", id); // 회원정보 호출
		sqlMap.insert("test.userDeleteLog", dto); // 탈퇴시 로그
		sqlMap.delete("test.deleteUserInfo", id); // 회원 삭제
		return "/dash-userInfo/dashDelete";
	}
	
	// 관리자 페이지 회원 정보 수정 페이지
	@RequestMapping("dashModify.do")
	public String dashModify(HttpServletRequest request){
		Alarm(request);// 알람 메서드
		String keyword = request.getParameter("keyword");  // 검색 키워드
		String id = request.getParameter("id");
		String pageNum=request.getParameter("pageNum");
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		String date=null;
		UserInfoDataDTO dto = (UserInfoDataDTO)sqlMap.queryForObject("admin.getUser", id);
		date=sdf.format(dto.getSigndate());
		
		request.setAttribute("keyword", keyword);
		request.setAttribute("date", date);
		request.setAttribute("dto", dto);
		request.setAttribute("pageNum", pageNum);
		return "/dash-userInfo/dashModify";
	}
	// 관리자 페이지 회원 정보 수정
	@RequestMapping("dashModifyPro.do")
	public String dashModifyPro(UserInfoDataDTO dto,HttpServletRequest request){
		Alarm(request);// 알람 메서드
		sqlMap.update("admin.userUp",dto);
		return "/dash-userInfo/dashModify";
	}
	// 관리자 페이지 회원 찾기
	@RequestMapping("dashUserSearch.do")
	public String dashUserSearch(HttpServletRequest request,HashMap map){
		Alarm(request);// 알람 메서드
		String keyword = request.getParameter("keyword");
		String pageNum = request.getParameter("pageNum");
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");			
		if(pageNum==null){pageNum="1";}
				
		int pageSize=10;
		int currentPage = Integer.parseInt(pageNum);
	    int startRow = (currentPage - 1) * pageSize;
	    
	    int count=0;
	    List list= null;
	    String[] dates = null;
	    count = (Integer)sqlMap.queryForObject("admin.userSearch", keyword);
	
	    if (count > 0) {
	    	map.put("startRow",startRow);
	    	map.put("pageSize",pageSize);
	    	map.put("keyword", keyword);
	    	list = sqlMap.queryForList("admin.userSearchList", map);
            dates = new String[count];
			for(int i = 0; i< list.size(); i++){
				dates[i] = sdf.format(((UserInfoDataDTO)list.get(i)).getSigndate());
				}
	    }else{
	    	list = Collections.EMPTY_LIST;
	    }
	    
		int pageCount = count / pageSize + ( count % pageSize == 0 ? 0 : 1);
		 
        int startPage = ((Integer.parseInt(pageNum)-1)/10)*10+1;
		int pageBlock=10;
        int endPage = startPage + pageBlock-1;
        if (endPage > pageCount) endPage = pageCount;
        request.setAttribute("keyword", keyword);
        request.setAttribute("list", list);
        request.setAttribute("count", count);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		return "/dash-userInfo/dashUserSearch";
	}
	// 회원 정보 & 가맹 정보 복구 페이지
	@RequestMapping("dashReverse.do")
	public String dashUserReverse(HttpServletRequest request){
		Alarm(request);
		return "/dash-reverse/dashReverse";
	}
	// 회원 아이디 입력시 기본 정보만 복구 , 금액 및 가맹점은 완료가 안되서 추후 적용
	@RequestMapping("dashInto.do")
	public String dashInto(HttpServletRequest request){
		Alarm(request);
		String reverse = request.getParameter("reverse"); // 복구할 아이디
		UserInfoDataDTO dto = (UserInfoDataDTO)sqlMap.queryForObject("admin.getUserDeleteLog", reverse);
		int check= 0;
		if(dto!=null){
			sqlMap.insert("admin.userInfoInsert", dto);
			sqlMap.delete("admin.userLogDelete", dto.getId());
			check = 1;
		}	
		request.setAttribute("check", check);
		return "/dash-reverse/dashInto";
	}
	
}
