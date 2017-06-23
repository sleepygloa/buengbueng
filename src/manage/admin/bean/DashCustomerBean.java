package manage.admin.bean;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import login.user.bean.CustomerDTO;
import login.user.bean.UserInfoDataDTO;
import sun.invoke.empty.Empty;

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
	// 관리자 가맹 문의 글 호출
	@RequestMapping("dashFranchiseContent.do")
	public String dashFranchiseContent(HttpServletRequest request,CustomerDTO dto,HashMap map){
		Alarm(request);
		adminContent(request, dto, map);
		return "/dash-customer/dashFranchiseContent";
	}
	//관리자 가맹 문의 글 수정 폼
	@RequestMapping("dashFranchiseModify.do")
	public String dashFranchiseModify(HttpServletRequest request,CustomerDTO dto){
		Alarm(request);
		adminModify(request, dto);
		return "/dash-customer/dashFranchiseModify";
	}
	//관리자 가맹 문의 글 수정 
	@RequestMapping("dashFranchiseModifyPro.do")
	public String dashFranchiseModifyPro(HttpServletRequest request,CustomerDTO dto){
		Alarm(request);
		adminModifyPro(request, dto);
		return "/dash-customer/dashFranchiseModifyPro";
	}
	
	// 관리자 페이지 자주 묻는 질문
	@RequestMapping("dashCustomerList.do")
	public String dashCustomerList(HttpServletRequest request,HashMap map){
		Alarm(request);
		adminList(request, map);
		return "/dash-customer/dashCustomerList";
	}
	// 관리자 자주 묻는 질문 게시글 호출
	@RequestMapping("dashCustomerContent.do")
	public String dashCustomerContent(HttpServletRequest request,CustomerDTO dto,HashMap map){
		Alarm(request);
		adminContent(request, dto,map);
		return "/dash-customer/dashCustomerContent";
	}
	//관리자 자주 묻는 질문 글 수정 폼
	@RequestMapping("dashCustomerModify.do")
	public String dashCustomerModify(HttpServletRequest request,CustomerDTO dto){
		Alarm(request);
		adminModify(request, dto);
		return "/dash-customer/dashCustomerModify";
	}
	//관리자 자주 묻는 질문 글 수정 
	@RequestMapping("dashCustomerModifyPro.do")
	public String dashCustomerModifyPro(HttpServletRequest request,CustomerDTO dto){
		Alarm(request);
		adminModifyPro(request, dto);
		return "/dash-customer/dashCustomerModifyPro";
	}
	//관리자 자주 묻는 질문 글 폼
	@RequestMapping("dashCustomerWriteForm.do")
	public String dashCustomerWriteForm(HttpSession session,HttpServletRequest request){
		Alarm(request);
		String id = (String)session.getAttribute("loginId");
		UserInfoDataDTO user = (UserInfoDataDTO)sqlMap.queryForObject("test.getUserInfo", id);
		
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
		
		request.setAttribute("user", user);
		request.setAttribute("num", new Integer(num));
		request.setAttribute("ref", new Integer(ref));
		request.setAttribute("re_step", new Integer(re_step));
		request.setAttribute("snum", snum);
		request.setAttribute("pageNum", pageNum);
		return "/dash-customer/dashCustomerWriteForm";
	}
	//관리자 자주 묻는 질문 글쓰기
	@RequestMapping("dashCustomerWriteFormPro.do")
	public String dashCustomerWriteFormPro(HttpServletRequest request,HashMap map,CustomerDTO dto){
		Alarm(request);
		String pageNum = request.getParameter("pageNum");

		int num=dto.getNum(); 
		int ref=dto.getRef();
		int re_step=dto.getRe_step();
		int snum=dto.getSnum();
		int number=0;
		
		number = (Integer)sqlMap.queryForObject("customer.maxNum", null);
		
		if(number!=0){
			number=number+1;
		}else{
			number=1;
		}
		
		if (num!=0){ 
			dto.setRe_step(re_step+1);
		}else{ 
			dto.setRef(number);
			dto.setRe_step(0);
		}

		sqlMap.insert("customer.writePro", dto);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("snum", snum);
		return "/dash-customer/dashCustomerWriteFormPro";
	}
	
	// 관리자 페이지 1:1 문의 목록	
	@RequestMapping("dashOneList.do")
	public String dashOneList(HttpServletRequest request,HashMap map){
		Alarm(request);
		adminList(request, map);
		return "/dash-customer/dashOneList";
	}
	// 관리자 1:1 문의 게시글 호출
	@RequestMapping("dashOneContent.do")
	public String dashOneContent(HttpServletRequest request,CustomerDTO dto,HashMap map){
		Alarm(request);
		adminContent(request, dto, map);
		return "/dash-customer/dashOneContent";
	}
	//관리자 1:1 문의 글 수정 폼
	@RequestMapping("dashOneModify.do")
	public String dashOneModify(HttpServletRequest request,CustomerDTO dto){
		Alarm(request);
		adminModify(request, dto);
		return "/dash-customer/dashOneModify";
	}
	//관리자 1:1 문의 글 수정 
	@RequestMapping("dashOneModifyPro.do")
	public String dashOneModifyPro(HttpServletRequest request,CustomerDTO dto){
		Alarm(request);
		adminModifyPro(request, dto);
		return "/dash-customer/dashOneModifyPro";
	}
	
	// 관리자 게시글 삭제
	@RequestMapping("dashBoardDel.do")
	public String dashBoardDel(HttpServletRequest request,HashMap map){
		Alarm(request);
		adminDelete(request, map);
		return "/customer-center/bossDelete";
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
	// 답변 중인 게시글 호출
	@RequestMapping("dashReplyContent.do")
	public String dashReplyContent(HttpServletRequest request,HashMap map,CustomerDTO dto){
		Alarm(request);
		String pageNum = request.getParameter("pageNum");
		String number = request.getParameter("number");
		int num = Integer.parseInt(request.getParameter("num"));
	
		dto = (CustomerDTO)sqlMap.queryForObject("customer.getContent",num);

		request.setAttribute("dto", dto);
		request.setAttribute("number", number);
		request.setAttribute("pageNum", pageNum);
		return "/dash-customer/dashReplyContent";
	}
	//답변 중인 게시글 글쓰기 폼
	@RequestMapping("dashReplyWrite.do")
	public String dashReplyWrite(HttpSession session,HttpServletRequest request){
		Alarm(request);
		if(session.getAttribute("loginId") != null){  // 로그인 세션 기록 있을때 해당 로그인 정보 호출
			String id = (String)session.getAttribute("loginId");
			UserInfoDataDTO user = (UserInfoDataDTO)sqlMap.queryForObject("test.getUserInfo", id);
			request.setAttribute("user", user);
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
		return "/dash-customer/dashReplyWrite";
	}
	//답변 중인 게시글 글작성
	@RequestMapping("dashReplyWritePro.do")
	public String dashReplyWritePro(HttpServletRequest request,HashMap map,CustomerDTO dto){
		Alarm(request);
		String pageNum = request.getParameter("pageNum");

		int num=dto.getNum(); 
		int ref=dto.getRef();
		int re_step=dto.getRe_step();
		int snum=dto.getSnum();
		int number=0;
		
		// 답글 작성시 기존 글과 비밀번호 통일
		if(request.getParameter("b_passwd")==""){
			map.put("snum", snum);
			map.put("num",num);
			String passwd = (String)sqlMap.queryForObject("customer.getPasswd", map);
			dto.setPasswd(passwd);
		}
		
		
		number = (Integer)sqlMap.queryForObject("customer.maxNum", null);
		
		if(number!=0){
			number=number+1;
		}else{
			number=1;
		}
		
		if (num!=0){ 
			dto.setRe_step(re_step+1);
		}else{ 
			dto.setRef(number);
			dto.setRe_step(0);
		}

		sqlMap.insert("customer.writePro", dto);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("snum", snum);
		return "/dash-customer/dashReplyWritePro";
	}
	// 게시글 검색 목록
	@RequestMapping("dashBoardSearch.do")
	public String dashUserSearch(HttpServletRequest request,HashMap map){
		Alarm(request);
		String pageNum=request.getParameter("pageNum");
		String column=request.getParameter("column");
		String keyword=request.getParameter("keyword");
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		
		if(pageNum==null){pageNum = "1";}
		int pageSize = 10;
		int currentPage= Integer.parseInt(pageNum);
		int startRow = (currentPage-1)*pageSize;
		int number = 0;
		int count = 0;
		List list=null;
		String dates[]=null;
				
		if(keyword!=null){
			map.put("column", column);
			map.put("keyword", keyword);
			count = (Integer)sqlMap.queryForObject("admin.customerSearchCount", map);
		if(count>0){
			map.put("startRow", startRow);
			map.put("pageSize",pageSize);
			map.put("column", column);
			map.put("keyword", keyword);
			list = sqlMap.queryForList("admin.customerSearch", map);
			dates=new String[count];
			for(int i = 0;i<list.size();i++){
				dates[i]=sdf.format(((CustomerDTO)list.get(i)).getReg_date());
			}
		}else{
			list =Collections.EMPTY_LIST;
		}}		
		
		number=count-(currentPage-1)*pageSize;
		
		int pageCount = count / pageSize + (count%pageSize == 0? 0:1);
		
		int startPage = ((Integer.parseInt(pageNum)-1)/10)*10+1;
		int pageBlock = 10;
		int endPage = startPage + pageBlock - 1;
		if(endPage > pageCount){endPage = pageCount;}
		
		request.setAttribute("number", number);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		request.setAttribute("pageNum", pageNum);		
		request.setAttribute("dates", dates);
		request.setAttribute("keyword", keyword);
		request.setAttribute("column", column);
		return "/dash-customer/dashBoardSearch";
	}
	// 검색된 게시글 들어가기
	@RequestMapping("dashBoardSearchContent.do")
	public String dashBoardSearchContent(HttpServletRequest request){
		Alarm(request);		
		int snum=Integer.parseInt(request.getParameter("snum"));
		int num=Integer.parseInt(request.getParameter("num"));
		String pageNum=request.getParameter("pageNum");
		int number=Integer.parseInt(request.getParameter("number"));
		String addr = null;
		
		if(snum==1){addr="dashFranchiseContent";}
		if(snum==2){addr="dashCustomerContent";}
		if(snum==3){addr="dashOneContent";}
		
		request.setAttribute("addr", addr);
		request.setAttribute("snum", snum);
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("number", number);
		return "/dash-customer/dashBoardSearchContent";
	}
}
