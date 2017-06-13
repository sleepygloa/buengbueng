package manage.admin.bean;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashIndexBean {
	
	@Autowired
	SqlMapClientTemplate sqlMap;
	
	// 관리자 페이지
	@RequestMapping("dashIndex.do")
	public String dashIndex(){
		return "dashIndex";
	}
	
	// 회원정보 수정창
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
	    List list=null;

	    count = (Integer)sqlMap.queryForObject("admin.userCount", null); //해당 페이지 내용 갯수
	    System.out.println("count="+count);
	    if (count > 0) {
	    	list = sqlMap.queryForList("admin.userList", grade);
	    	System.out.println(list);
	    }else{
	    	list = Collections.EMPTY_LIST;
	    }
	    System.out.println(count);
	    
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
}
