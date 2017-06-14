package manage.admin.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import login.user.bean.UserInfoDataDTO;

@Controller
public class DashIndexBean {
	
	@Autowired
	SqlMapClientTemplate sqlMap;
	
	// 관리자 페이지
	@RequestMapping("dashIndex.do")
	public String dashIndex(){
		return "dashIndex";
	}
	
	// 관리자 페이지 회원정보
	@RequestMapping("dashUser.do")
	public String dashUser(HttpServletRequest request){
		int grade = Integer.parseInt(request.getParameter("grade"));
		String pageNum = request.getParameter("pageNum");
					
		if(pageNum==null){pageNum="1";}
		
		int pageSize=10; // endRow와 같이써도 가능함. mysql limit 사용시. 출력은 고정.
		int currentPage = Integer.parseInt(pageNum);
	    int startRow = (currentPage - 1) * pageSize; // mysql에서 limit 는 0부터 시작해야 rownum 1번 값부터 호출
	    int number=0;
	    int count=0;
	    List list= null;
	    
	    count = (Integer)sqlMap.queryForObject("admin.userCount", grade); //해당 페이지 내용 갯수
	    if (count > 0) {
	    	list = sqlMap.queryForList("admin.userList", grade);
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
		return "/dash-userInfo/dashUser";
	}
	// 관리자 페이지 회원 탈퇴 
	@RequestMapping("dashDelete.do")
	public String dashDelete(HttpServletRequest request){
		String id = request.getParameter("id");
		sqlMap.delete("admin.userDelete", id);
		return "/dash-userInfo/dashDelete";
	}
	
	@RequestMapping("dashModify.do")
	public String dashModify(HttpServletRequest request){
		String id = request.getParameter("id");
		UserInfoDataDTO dto = (UserInfoDataDTO)sqlMap.queryForObject("admin.getUser", id);
		request.setAttribute("dto", dto);
		return "/dash-userInfo/dashModify";
	}
	// 관리자 페이지 회원 정보 수정
	@RequestMapping("dashModifyPro.do")
	public String dashModifyPro(UserInfoDataDTO dto,HttpServletRequest request){
		sqlMap.update("admin.userUp",dto);
		return "/dash-userInfo/dashModifyPro";
	}

}
