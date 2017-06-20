package manage.admin.bean;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import login.user.bean.CustomerDTO;

@Controller
public class DashCustomerBean extends BoardMethodBean{
	
	@Autowired
	SqlMapClientTemplate sqlMap;
	// 관리자 페이지 가맹 문의 
	@RequestMapping("dashFranchiseList.do")
	public String dashFranchiseList(HttpServletRequest request,HashMap map){
		int snum=0;
		Alarm(request);
		adminList(request, map);
		return "/dash-customer/dashFranchiseList";
	}
	@RequestMapping("dashFranchiseContent.do")
	public String dashFranchiseContent(HttpServletRequest request,CustomerDTO dto){
		adminContent(request, dto);
		return "/dahs-customer/dashFranchiseContent";
	}
	// 관리자 페이지 자주 묻는 질문
	@RequestMapping("dashCustomerList.do")
	public String dashCustomerList(HttpServletRequest request,HashMap map){
		Alarm(request);
		adminList(request, map);
		return "/dash-customer/dashCustomerList";
	}
	@RequestMapping("dashCustomerContent.do")
	public String dashCustomerContent(HttpServletRequest request,CustomerDTO dto){
		adminContent(request, dto);
		return "/dahs-customer/dashCustomerContent";
	}
	
	// 관리자 페이지 1:1 문의	
	@RequestMapping("dashOneList.do")
	public String dashOneList(HttpServletRequest request,HashMap map){
		Alarm(request);
		adminList(request, map);
		return "/dash-customer/dashOneList";
	}
	@RequestMapping("dashOneContent.do")
	public String dashOneContent(HttpServletRequest request,CustomerDTO dto){
		adminContent(request, dto);
		return "/dahs-customer/dashOneContent";
	}
	// 관리자 게시글 삭제
	@RequestMapping("dashBoardDel.do")
	public String dashBoardDel(HttpServletRequest request,HashMap map){
		//adminDelete(request, map);
		return "/dash-customer/bossDelete";
	}
	// 답변중인 게시판
	@RequestMapping("dashReply.do")
	public String dashReply(HttpServletRequest request,HashMap map){
		Alarm(request);
		String pageNum = request.getParameter("pageNum");
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		
		if(pageNum==null){pageNum = "1";}
		int pageSize = 10;
		int currentPage= Integer.parseInt(pageNum);
		int startRow = (currentPage-1)*pageSize;
		int number = 0;
		
		List list = null;
		List same = null;
		String[] dates = null;
		int count = (Integer)sqlMap.queryForObject("admin.customerReplyCount",null );
		if(count>0){
			map.put("startRow", startRow);
			map.put("pageSize",pageSize);
			list = sqlMap.queryForList("admin.customerReplyList", map);
			dates=new String[count];
			for(int i=0;i<list.size();i++){
				dates[i]=sdf.format(((CustomerDTO)list.get(i)).getReg_date());
			}
		}else{
			list = Collections.EMPTY_LIST;
		}
		number=count-(currentPage-1)*pageSize;
		
		int pageCount = count / pageSize + (count%pageSize == 0? 0:1);
		
		int startPage = ((Integer.parseInt(pageNum)-1)/10)*10+1;
		int pageBlock = 10;
		int endPage = startPage + pageBlock - 1;
		if(endPage > pageCount){endPage = pageCount;}
		
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		request.setAttribute("number", number);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("dates", dates);
		return "/dash-customer/dashReply";
	}
}
