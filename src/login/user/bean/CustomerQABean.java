package login.user.bean;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerQABean {   // Q & A
	
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	@RequestMapping("customerQA.do")
	public String customerQA(HttpServletRequest request,HashMap map){
		Integer snum = Integer.parseInt(request.getParameter("snum"));
		String pageNum = request.getParameter("pageNum");
		
		if(pageNum==null){pageNum="1";}
		
		int pageSize=10;
		int currentPage = Integer.parseInt(pageNum);
	    int startRow = (currentPage - 1) * pageSize;
	    int number=0;
	    
	    List list=null;

	    int count = (Integer)sqlMap.queryForObject("customer.customercount", snum);
	    if (count > 0) {
	    	map.put("snum",snum);
	    	map.put("startRow",startRow);
		    map.put("pageSize",pageSize);
	    	list = sqlMap.queryForList("customer.customerlist", map);
	    }else{
	    	list = Collections.EMPTY_LIST;
	    }
	    
		number=count-(currentPage-1)*pageSize;
		
        int pageCount = count / pageSize + ( count % pageSize == 0 ? 0 : 1);
		 
        int startPage = (int)(currentPage/10)*10+1;
		int pageBlock=10;
        int endPage = startPage + pageBlock-1;
        if (endPage > pageCount) endPage = pageCount;
		
        request.setAttribute("count", count);
		request.setAttribute("list", list);
		request.setAttribute("number", number);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("snum", snum);
		request.setAttribute("pageNum", pageNum);
		return "/customer-center/customerList";
	}
	
	@RequestMapping("customerForm.do")
	public String franchiseForm(HttpServletRequest request){
		Integer snum = Integer.parseInt(request.getParameter("snum"));
		String pageNum = request.getParameter("pageNum");
		int num=0,ref=1,re_step=0;
		if(request.getParameter("num")!=null){
			num=Integer.parseInt(request.getParameter("num"));
			ref=Integer.parseInt(request.getParameter("ref"));
			re_step=Integer.parseInt(request.getParameter("re_step"));
		}
		request.setAttribute("num", new Integer(num));
		request.setAttribute("ref", new Integer(ref));
		request.setAttribute("re_step", new Integer(re_step));
		request.setAttribute("snum", snum);
		request.setAttribute("pageNum", pageNum);
		return "/customer-center/customerForm";
	}
	
	@RequestMapping("customerPro.do")
	public String franchisePro(CustomerDTO dto,HashMap map,HttpServletRequest request) throws Exception{
		String pageNum = request.getParameter("pageNum");
		
		int num=dto.getNum();
		int ref=dto.getRef();
		int re_step=dto.getRe_step();
		int snum=dto.getSnum();
		int number=0;
		
		if(num!=0){		
			number = (Integer)sqlMap.queryForObject("customer.maxNum", snum);	
		}

		if(number!=0){ 
			number=number+1;	
		}else{
			number=1;
		}
		if (num!=0){ 
			map.put("ref", ref);
			map.put("re_step",re_step);
			map.put("snum", snum);
			sqlMap.update("customer.writeUp", map);
			dto.setRe_step(re_step+1);
	
		}else{ 
			dto.setRef(number);
			dto.setRe_step(0);
		}

		sqlMap.insert("customer.writePro", dto);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("snum", snum);
		return "/customer-center/customerPro";
	}
}
