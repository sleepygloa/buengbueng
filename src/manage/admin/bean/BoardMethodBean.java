package manage.admin.bean;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;

import login.user.bean.CustomerDTO;

@Controller
public class BoardMethodBean {
	@Autowired
	SqlMapClientTemplate sqlMap;
	// 알람 메서드
	public void Alarm(HttpServletRequest request){
		int franchiseAlarm=0;
		int oneAlarm=0;
		int noReply=0;
		franchiseAlarm=(Integer)sqlMap.queryForObject("admin.franchiseAlarm", null);
		oneAlarm=(Integer)sqlMap.queryForObject("admin.oneAlarm", null);
		noReply=(Integer)sqlMap.queryForObject("admin.customerReplyCount", null);
		if(franchiseAlarm > 0 || oneAlarm > 0){
			String alarm="new";
			request.setAttribute("alarm", alarm);
			request.setAttribute("franchiseAlarm", franchiseAlarm);
			request.setAttribute("oneAlarm", oneAlarm);
		}
		request.setAttribute("noReply", noReply);
	}
	// 게시글 목록
	public void adminList(HttpServletRequest request,HashMap map){
		int snum = Integer.parseInt(request.getParameter("snum"));
		String pageNum = request.getParameter("pageNum");
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		Date day = new Date();
		String today = sdf.format(day); // java에서 오늘 날짜 출력
		
		if(pageNum==null){pageNum = "1";}
		int pageSize = 10;
		int currentPage= Integer.parseInt(pageNum);
		int startRow = (currentPage-1)*pageSize;
		int number = 0;
		
		List list = null;
		String[] dates = null;
		int count = (Integer)sqlMap.queryForObject("customer.customercount", snum);
		if(count>0){
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
	}
	//관리자 게시글 호출
	public void adminContent(HttpServletRequest request,CustomerDTO dto,HashMap map){
		String pageNum = request.getParameter("pageNum");
		String number = request.getParameter("number");
		int snum = Integer.parseInt(request.getParameter("snum"));
		int num = Integer.parseInt(request.getParameter("num"));

		sqlMap.update("customer.contentUp", num);
	
		dto = (CustomerDTO)sqlMap.queryForObject("customer.getContent",num);
		
		map.put("ref", dto.getRef());
		map.put("snum",snum);
		int re_step = (Integer)sqlMap.queryForObject("customer.getReply",map); // 답글의 여부 확인 1일때만 답변 쓸수있음.
		
		request.setAttribute("re_step", re_step);
		request.setAttribute("dto", dto);
		request.setAttribute("number", number);
		request.setAttribute("pageNum", pageNum);
	}
	// 관리자 페이지 글삭제
	public void adminDelete(HttpServletRequest request,HashMap map){
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String addr=null;
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
		if(snum==0){
			int ref =(Integer)sqlMap.queryForObject("customer.getRefNum", num);
			
		}
		if(snum == 1){addr="dashFranchiseList"; check=0;}
		if(snum == 2){addr="dashCustomerList"; check=0;}
		if(snum == 3){addr="dashOneList"; check=0;}
		
		request.setAttribute("check", check);
		request.setAttribute("addr", addr);
		request.setAttribute("snum", snum);
		request.setAttribute("pageNum", pageNum);
	}
	// 관리자 글수정 폼
	public void adminModify(HttpServletRequest request,CustomerDTO dto){
		Integer snum = Integer.parseInt(request.getParameter("snum"));
		Integer num = Integer.parseInt(request.getParameter("num"));
		String pageNum=request.getParameter("pageNum");
		
		dto = (CustomerDTO)sqlMap.queryForObject("customer.getContent",num);
		
		request.setAttribute("dto", dto);
		request.setAttribute("pageNum", pageNum);
	}
	//관리자 글수정 프로
	public void adminModifyPro(HttpServletRequest request,CustomerDTO dto){
		String pageNum= request.getParameter("pageNum");
		int check = 0;
			
		sqlMap.update("customer.modifyContent", dto);

		request.setAttribute("pageNum", pageNum);
		request.setAttribute("dto", dto);
	}
}
