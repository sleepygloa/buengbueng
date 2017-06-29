package manage.admin.bean;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import login.user.bean.CustomerDTO;
import login.user.bean.UserInfoDataDTO;

@Controller
public class DashCustomerBean extends BoardMethodBean{
	
	@Autowired
	SqlMapClientTemplate sqlMap;
	
	@RequestMapping("dashList.do")
	public String dashList(HttpServletRequest request){
		Alarm(request);
		int pageSize = 10; // 한페이지 크기
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		Date day = new Date();
		String today = sdf.format(day); // java에서 오늘 날짜 출력
		
		int snum = 1;
		String pageNum = request.getParameter("pageNum");
		
		if(pageNum==null){pageNum = "1";}
		int currentPage= Integer.parseInt(pageNum);
		int startRow = (currentPage-1)*pageSize;
		int number = 0;
		
		List list = null;
		String[] dates = null;
		int count = (Integer)sqlMap.queryForObject("customer.customercount", snum);
		if(count>0){
			HashMap map = new HashMap();
			map.put("snum",snum);
			map.put("startRow",startRow);
			map.put("pageSize",pageSize);
			list = sqlMap.queryForList("customer.customerlist", map);
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
		
		request.setAttribute("today", today);
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		request.setAttribute("number", number);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("snum", snum);
		request.setAttribute("dates", dates);
		
		///////////////////////////////////////////////////

		int snum2 = 2;
		String pageNum2 = request.getParameter("pageNum2");
				
		if(pageNum2==null){pageNum2 = "1";}
		int currentPage2= Integer.parseInt(pageNum2);
		int startRow2 = (currentPage2-1)*pageSize;
		int number2 = 0;
		
		List list2 = null;
		String[] dates2 = null;
		int count2 = (Integer)sqlMap.queryForObject("customer.customercount", snum2);
		if(count2>0){
			HashMap map2 = new HashMap();
			map2.put("snum",snum2);
			map2.put("startRow",startRow2);
			map2.put("pageSize",pageSize);
			list2 = sqlMap.queryForList("customer.customerlist", map2);
			dates2=new String[count2];
			for(int i=0;i<list2.size();i++){
				dates2[i]=sdf.format(((CustomerDTO)list2.get(i)).getReg_date());
			}
		}else{
			list2 = Collections.EMPTY_LIST;
		}
		number2=count2-(currentPage2-1)*pageSize;
		
		int pageCount2 = count2 / pageSize + (count2%pageSize == 0? 0:1);
		
		int startPage2 = ((Integer.parseInt(pageNum2)-1)/10)*10+1;
		int pageBlock2 = 10;
		int endPage2 = startPage2 + pageBlock2 - 1;
		if(endPage2 > pageCount2){endPage2 = pageCount2;}

		request.setAttribute("count2", count2);
		request.setAttribute("list2", list2);
		request.setAttribute("number2", number2);
		request.setAttribute("pageNum2", pageNum2);
		request.setAttribute("currentPage2", currentPage2);
		request.setAttribute("pageCount2", pageCount2);
		request.setAttribute("startPage2", startPage2);
		request.setAttribute("endPage2", endPage2);
		request.setAttribute("snum2", snum2);
		request.setAttribute("dates2", dates2);
		
		///////////////////////////////////////////////////////////

		int snum3 = 3;
		String pageNum3 = request.getParameter("pageNum3");
				
		if(pageNum3==null){pageNum3 = "1";}
		int currentPage3= Integer.parseInt(pageNum3);
		int startRow3 = (currentPage3-1)*pageSize;
		int number3 = 0;
		
		List list3 = null;
		String[] dates3 = null;
		int count3 = (Integer)sqlMap.queryForObject("customer.customercount", snum3);
		if(count3>0){
			HashMap map3=new HashMap();
			map3.put("snum",snum3);
			map3.put("startRow",startRow3);
			map3.put("pageSize",pageSize);
			list3 = sqlMap.queryForList("customer.customerlist", map3);
			dates3=new String[count3];
			for(int i=0;i<list3.size();i++){
				dates3[i]=sdf.format(((CustomerDTO)list3.get(i)).getReg_date());
			}
		}else{
			list3 = Collections.EMPTY_LIST;
		}
		number3=count3-(currentPage3-1)*pageSize;
		
		int pageCount3 = count3 / pageSize + (count3%pageSize == 0? 0:1);
		
		int startPage3 = ((Integer.parseInt(pageNum3)-1)/10)*10+1;
		int pageBlock3 = 10;
		int endPage3 = startPage3 + pageBlock3 - 1;
		if(endPage3 > pageCount3){endPage3 = pageCount3;}

		request.setAttribute("count3", count3);
		request.setAttribute("list3", list3);
		request.setAttribute("number3", number3);
		request.setAttribute("pageNum3", pageNum3);
		request.setAttribute("currentPage3", currentPage3);
		request.setAttribute("pageCount3", pageCount3);
		request.setAttribute("startPage3", startPage3);
		request.setAttribute("endPage3", endPage3);
		request.setAttribute("snum3", snum3);
		request.setAttribute("dates3", dates3);
		
		//////////////////////////////////////////////////////////////////
		String pageNum4 = request.getParameter("pageNum4");
		
		if(pageNum4==null){pageNum4 = "1";}
		int currentPage4= Integer.parseInt(pageNum4);
		int startRow4 = (currentPage4-1)*pageSize;
		int number4 = 0;
		
		List list4 = null;
		String[] dates4 = null;
		int count4 = (Integer)sqlMap.queryForObject("admin.customerReplyCount",null );
		if(count4>0){
			HashMap map4 = new HashMap();
			map4.put("startRow", startRow4);
			map4.put("pageSize",pageSize);
			list4 = sqlMap.queryForList("admin.customerReplyList", map4);
			dates4=new String[count4];
			for(int i=0;i<list4.size();i++){
				dates4[i]=sdf.format(((CustomerDTO)list4.get(i)).getReg_date());
			}
		}else{
			list4 = Collections.EMPTY_LIST;
		}
		number4=count4-(currentPage4-1)*pageSize;
		
		int pageCount4 = count4 / pageSize + (count4%pageSize == 0? 0:1);
		
		int startPage4 = ((Integer.parseInt(pageNum)-1)/10)*10+1;
		int pageBlock4 = 10;
		int endPage4 = startPage4 + pageBlock4 - 1;
		if(endPage4 > pageCount4){endPage4 = pageCount4;}
		
		request.setAttribute("count4", count4);
		request.setAttribute("list4", list4);
		request.setAttribute("number4", number4);
		request.setAttribute("pageNum4", pageNum4);
		request.setAttribute("currentPage4", currentPage4);
		request.setAttribute("pageCount4", pageCount4);
		request.setAttribute("startPage4", startPage4);
		request.setAttribute("endPage4", endPage4);
		request.setAttribute("dates4", dates4);
		int check = 1;
		request.setAttribute("check", check);
		return "/dash-customer/dashList";
	}
	
	// 관리자 페이지 글 호출
	@RequestMapping("dashBoardContent.do")
	public String dashBoardContent(HttpServletRequest request,CustomerDTO dto,HashMap map){
		pageNum(request);
		String number = request.getParameter("number");
		int num = Integer.parseInt(request.getParameter("num"));

		sqlMap.update("customer.contentUp", num);
	
		dto = (CustomerDTO)sqlMap.queryForObject("customer.getContent",num);
		
		map.put("ref", dto.getRef());
		map.put("snum",dto.getSnum());
		int re_step = (Integer)sqlMap.queryForObject("customer.getReply",map); // 답글의 여부 확인 1일때만 답변 쓸수있음.

		request.setAttribute("re_step", re_step);
		request.setAttribute("dto", dto);
		request.setAttribute("number", number);
		return "/dash-customer/dashBoardContent";
	}
	//관리자 글 수정 폼
	@RequestMapping("dashBoardModify.do")
	public String dashBoardModify(HttpServletRequest request,CustomerDTO dto){
		pageNum(request);
		Integer snum = Integer.parseInt(request.getParameter("snum"));
		Integer num = Integer.parseInt(request.getParameter("num"));
		Integer number = Integer.parseInt(request.getParameter("number"));
	
		dto = (CustomerDTO)sqlMap.queryForObject("customer.getContent",num);
		
		request.setAttribute("number", number);
		request.setAttribute("dto", dto);
		return "/dash-customer/dashBoardModify";
	}
	//관리자  글 수정 
	@RequestMapping("dashBoardModifyPro.do")
	public String dashBoardModifyPro(HttpServletRequest request,CustomerDTO dto){
		pageNum(request);
		Integer number = Integer.parseInt(request.getParameter("number"));
		int check = 0;
			
		sqlMap.update("customer.modifyContent", dto);

		request.setAttribute("number", number);
		request.setAttribute("dto", dto);
		return "/dash-customer/dashBoardModifyPro";
	}
	//관리자 글쓰기 폼
	@RequestMapping("dashBoardWriteForm.do")
	public String dashBoardWriteForm(HttpSession session,HttpServletRequest request){
		pageNum(request);
		String id = (String)session.getAttribute("loginId");
		UserInfoDataDTO user = (UserInfoDataDTO)sqlMap.queryForObject("test.getUserInfo", id);
		int snum=Integer.parseInt(request.getParameter("snum"));

				
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
		return "/dash-customer/dashBoardWriteForm";
	}
	//관리자 글쓰기
	@RequestMapping("dashBoardWriteFormPro.do")
	public String dashBoardWriteFormPro(HttpServletRequest request,HashMap map,CustomerDTO dto){
		pageNum(request);

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
		return "/dash-customer/dashBoardWriteFormPro";
	}
	
	// 관리자 게시글 삭제
	@RequestMapping("dashBoardDel.do")
	public String dashBoardDel(HttpServletRequest request,HashMap map){
		pageNum(request);
		int num = Integer.parseInt(request.getParameter("num"));
		int snum=0;
		int check=0;
		if(request.getParameter("snum")!=null){
			snum = Integer.parseInt(request.getParameter("snum"));
			map.put("num", num);
			map.put("snum",snum);
			int ref = (Integer)sqlMap.queryForObject("customer.getRef", map);
			int re_step = (Integer)sqlMap.queryForObject("customer.getRe_step", map);
			map.put("snum",snum);
			map.put("ref",ref);
			map.put("re_step",re_step);
			sqlMap.delete("customer.bossDel", map);
		}
		if(snum == 1 || snum==2 || snum==3){check=0;}
	
		request.setAttribute("check", check);
		request.setAttribute("snum", snum);
		return "/customer-center/bossDelete";
	}

	// 게시글 검색 목록
	@RequestMapping("dashBoardSearch.do")
	public String dashUserSearch(HttpServletRequest request,HashMap map){
		Alarm(request);
		String pageNum=request.getParameter("pageNum");
		String column=request.getParameter("column");
		String keyword=request.getParameter("keyword");
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		Date day = new Date();
		String today = sdf.format(day); // 오늘날짜 스트링으로 형변환
		
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
			count = (Integer)sqlMap.queryForObject("admin.searchDashFranchiseCount", map);
			if(count>0){
			map.put("pageSize",pageSize);
			map.put("startRow", startRow);
			list = sqlMap.queryForList("admin.searchDashFranhicse", map);
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
		
		request.setAttribute("today", today);
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
		////////////////////////////////////////////////////////////////////
		String pageNum2=request.getParameter("pageNum2");
		
		if(pageNum2==null){pageNum2 = "1";}
		int currentPage2= Integer.parseInt(pageNum2);
		int startRow2 = (currentPage2-1)*pageSize;
		int number2 = 0;
		int count2 = 0;
		List list2=null;
		String dates2[]=null;
				
		if(keyword!=null){
			map.put("column", column);
			map.put("keyword", keyword);
			count2 = (Integer)sqlMap.queryForObject("admin.searchDashCustomerCount", map);
		if(count2>0){
			map.put("column", column);
			map.put("keyword", keyword);
			map.put("startRow", startRow2);
			map.put("pageSize", pageSize);
			list2 = sqlMap.queryForList("admin.searchDashCustomer", map);
			dates2=new String[count2];
			for(int i = 0;i<list2.size();i++){
				dates2[i]=sdf.format(((CustomerDTO)list2.get(i)).getReg_date());
			}
		}else{
			list2 =Collections.EMPTY_LIST;
		}}		
		
		number2=count2-(currentPage2-1)*pageSize;
		
		int pageCount2 = count2 / pageSize + (count2%pageSize == 0? 0:1);
		
		int startPage2 = ((Integer.parseInt(pageNum2)-1)/10)*10+1;
		int pageBlock2 = 10;
		int endPage2 = startPage2 + pageBlock2 - 1;
		if(endPage2 > pageCount2){endPage2 = pageCount2;}

		request.setAttribute("number2", number2);
		request.setAttribute("currentPage2", currentPage2);
		request.setAttribute("pageCount2", pageCount2);
		request.setAttribute("startPage2", startPage2);
		request.setAttribute("endPage2", endPage2);
		request.setAttribute("count2", count2);
		request.setAttribute("list2", list2);
		request.setAttribute("pageNum2", pageNum2);		
		request.setAttribute("dates2", dates2);
		/////////////////////////////////////////////////////////////////
		String pageNum3=request.getParameter("pageNum3");
		
		if(pageNum3==null){pageNum3 = "1";}
		int currentPage3= Integer.parseInt(pageNum3);
		int startRow3 = (currentPage3-1)*pageSize;
		int number3 = 0;
		int count3 = 0;
		List list3=null;
		String dates3[]=null;
				
		if(keyword!=null){
			map.put("column", column);
			map.put("keyword", keyword);
			count3 = (Integer)sqlMap.queryForObject("admin.searchDashOneCount", map);
		if(count3>0){
			map.put("column", column);
			map.put("keyword", keyword);
			map.put("startRow", startRow3);
			map.put("pageSize",pageSize);
			list3 = sqlMap.queryForList("admin.searchDashOne", map);
			dates3=new String[count3];
			for(int i = 0;i<list3.size();i++){
				dates3[i]=sdf.format(((CustomerDTO)list3.get(i)).getReg_date());
			}
		}else{
			list3 =Collections.EMPTY_LIST;
		}}		
		
		number3=count3-(currentPage3-1)*pageSize;
		
		int pageCount3 = count3 / pageSize + (count3%pageSize == 0? 0:1);
		
		int startPage3 = ((Integer.parseInt(pageNum3)-1)/10)*10+1;
		int pageBlock3 = 10;
		int endPage3 = startPage3 + pageBlock3 - 1;
		if(endPage3 > pageCount3){endPage3 = pageCount3;}

		request.setAttribute("number3", number3);
		request.setAttribute("currentPage3", currentPage3);
		request.setAttribute("pageCount3", pageCount3);
		request.setAttribute("startPage3", startPage3);
		request.setAttribute("endPage3", endPage3);
		request.setAttribute("count3", count3);
		request.setAttribute("list3", list3);
		request.setAttribute("pageNum3", pageNum3);		
		request.setAttribute("dates3", dates3);
		/////////////////////////////////////////////////////////////////
		String pageNum4 = request.getParameter("pageNum4");
		
		if(pageNum4==null){pageNum4 = "1";}
		int currentPage4= Integer.parseInt(pageNum4);
		int startRow4 = (currentPage4-1)*pageSize;
		int number4 = 0;
		
		List list4 = null;
		String[] dates4 = null;
		int count4 = (Integer)sqlMap.queryForObject("admin.customerReplyCount",null );
		if(count4>0){
			map.put("startRow", startRow4);
			map.put("pageSize",pageSize);
			list4 = sqlMap.queryForList("admin.customerReplyList", map);
			dates4=new String[count4];
			for(int i=0;i<list4.size();i++){
				dates4[i]=sdf.format(((CustomerDTO)list4.get(i)).getReg_date());
			}
		}else{
			list4 = Collections.EMPTY_LIST;
		}
		number4=count4-(currentPage4-1)*pageSize;
		
		int pageCount4 = count4 / pageSize + (count4%pageSize == 0? 0:1);
		
		int startPage4 = ((Integer.parseInt(pageNum)-1)/10)*10+1;
		int pageBlock4 = 10;
		int endPage4 = startPage4 + pageBlock4 - 1;
		if(endPage4 > pageCount4){endPage4 = pageCount4;}
		
		request.setAttribute("count4", count4);
		request.setAttribute("list4", list4);
		request.setAttribute("number4", number4);
		request.setAttribute("pageNum4", pageNum4);
		request.setAttribute("currentPage4", currentPage4);
		request.setAttribute("pageCount4", pageCount4);
		request.setAttribute("startPage4", startPage4);
		request.setAttribute("endPage4", endPage4);
		request.setAttribute("dates4", dates4);
		
		int check = 2;
		request.setAttribute("check", check);		
		return "/dash-customer/dashList";
	}
}
