package login.user.bean;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OneQABean { // 1:1 문의

	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	@RequestMapping("oneQA.do")  // 게시판 리스트
	public String oneQA(HttpServletRequest request,HashMap map){
		Integer snum = Integer.parseInt(request.getParameter("snum"));
		String pageNum = request.getParameter("pageNum");
		
		if(pageNum==null){pageNum="1";}
		
		int pageSize=10; // endRow와 같이써도 가능함. mysql limit 사용시. 출력은 고정.
		int currentPage = Integer.parseInt(pageNum);
	    int startRow = (currentPage - 1) * pageSize; // mysql에서 limit 는 0부터 시작해야 rownum 1번 값부터 호출
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
		// 페이지 카운트
        int pageCount = count / pageSize + ( count % pageSize == 0 ? 0 : 1);
		 
        int startPage = ((Integer.parseInt(pageNum)-1)/10)*10+1;
		int pageBlock=10;
        int endPage = startPage + pageBlock-1;
        if (endPage > pageCount) endPage = pageCount;

		request.setAttribute("count", count);
		request.setAttribute("list", list);
		request.setAttribute("number", number);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("snum", snum);
		return "/customer-center/oneList";
	}
	
	@RequestMapping("oneForm.do")
	public String oneForm(HttpServletRequest request,HttpSession session){   // 가맹 문의 폼 
		if(session.getAttribute("loginId") != null){
			String id = (String)session.getAttribute("loginId");
			UserInfoDataDTO dto = (UserInfoDataDTO)sqlMap.queryForObject("test.getUserInfo", id);
			request.setAttribute("dto", dto);
		}
		
		Integer snum = Integer.parseInt(request.getParameter("snum"));
		String pageNum = request.getParameter("pageNum");
		int num=0,ref=1,re_step=0;
		if(request.getParameter("num")!=null){
			String title=request.getParameter("title");
			num=Integer.parseInt(request.getParameter("num"));
			ref=Integer.parseInt(request.getParameter("ref"));
			re_step=Integer.parseInt(request.getParameter("re_step"));
			request.setAttribute("title", title);
		}
		request.setAttribute("num", new Integer(num));
		request.setAttribute("ref", new Integer(ref));
		request.setAttribute("re_step", new Integer(re_step));
		request.setAttribute("snum", snum);
		request.setAttribute("pageNum", pageNum);
		return "/customer-center/oneForm";
	}
	
	@RequestMapping("onePro.do")
	public String onePro(CustomerDTO dto,HashMap map,HttpServletRequest request) throws Exception{
		String pageNum = request.getParameter("pageNum");
		
		int num=dto.getNum(); 
		int ref=dto.getRef();
		int re_step=dto.getRe_step();
		int snum=dto.getSnum();
		int number=0;
		
			
		number = (Integer)sqlMap.queryForObject("customer.maxNum", snum);	
		

		if(number!=0){ 
			number=number+1;	
		}else{
			number=1;
		}
		if (num!=0){ 
			map.put("number",number);
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
		return "/customer-center/onePro";
	}
	
	@RequestMapping("oneContent.do")
	public String oneContent(HttpServletRequest request,HashMap map,CustomerDTO dto){
		String pageNum = request.getParameter("pageNum");
		String number = request.getParameter("number");
		Integer snum = Integer.parseInt(request.getParameter("snum"));
		Integer num = Integer.parseInt(request.getParameter("num"));

		map.put("snum",snum);
		map.put("num",num);
	
		sqlMap.update("customer.contentUp", map);
		dto = (CustomerDTO)sqlMap.queryForObject("customer.getContent", map);
		
		request.setAttribute("dto", dto);
		request.setAttribute("number", number);
		request.setAttribute("pageNum", pageNum);
		return "/customer-center/oneContent";
	}
	
	@RequestMapping("oneDelete.do")
	public String oneDelete(HttpServletRequest request){
		Integer num = Integer.parseInt(request.getParameter("num"));
		Integer snum = Integer.parseInt(request.getParameter("snum"));
		String pageNum = request.getParameter("pageNum");
		request.setAttribute("snum", snum);
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		return "/customer-center/oneDelete";
	}
	
	@RequestMapping("oneDeletePro.do")
	public String oneDeletePro(HttpServletRequest request,HashMap map){
		int num = Integer.parseInt(request.getParameter("num"));
		Integer snum = Integer.parseInt(request.getParameter("snum"));
		String pageNum = request.getParameter("pageNum");
		String passwd = request.getParameter("passwd");
		int check=0;
		
		map.put("num", num);
		map.put("snum",snum);
		String dispasswd = (String)sqlMap.queryForObject("customer.getPasswd", map);
				
		if(passwd.equals(dispasswd)){
			int ref = (Integer)sqlMap.queryForObject("customer.getRef", map);
			sqlMap.delete("customer.delRef", ref);
			check =1;
		}	
		request.setAttribute("snum", snum);
		request.setAttribute("check", check);
		request.setAttribute("pageNum", pageNum);
		return "/customer-center/oneDeletePro";
	}
}
