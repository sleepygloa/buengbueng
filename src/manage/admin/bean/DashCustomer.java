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
public class DashCustomer extends MethodBean {
	
	@Autowired
	SqlMapClientTemplate sqlMap;
	
	@RequestMapping("dashFranchiseList.do")
	public String dashFranchise(HttpServletRequest request,HashMap map){
		Alarm(request);
		dashList(request, map);

		return "/dash-customer/dashFranchiseList";
	}
	
	@RequestMapping("dashCustomerList.do")
	public String dashCustomer(HttpServletRequest request,HashMap map){
		Alarm(request);
		dashList(request, map);
		
		return "/dash-customer/dashCustomerList";
	}
	
	@RequestMapping("dashOneList.do")
	public String dashOne(HttpServletRequest request,HashMap map){
		Alarm(request);
		dashList(request, map);
		
		return "/dash-customer/dashOneList";
	}
	
	@RequestMapping("dashReply.do")
	public String dashReply(HttpServletRequest request,HashMap map){
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
