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
public class MethodBean {
	@Autowired
	SqlMapClientTemplate sqlMap;
	// 알람 메서드
	public void Alarm(HttpServletRequest request){
		int franchiseAlarm=0;
		int oneAlarm=0;
		franchiseAlarm=(Integer)sqlMap.queryForObject("admin.franchiseAlarm", null);
		oneAlarm=(Integer)sqlMap.queryForObject("admin.oneAlarm", null);
			
		if(franchiseAlarm > 0 || oneAlarm > 0){
			String alarm="new";
			request.setAttribute("alarm", alarm);
			request.setAttribute("franchiseAlarm", franchiseAlarm);
			request.setAttribute("oneAlarm", oneAlarm);
		}
	}
	// 게시글 목록
	public void dashList(HttpServletRequest request,HashMap map){
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
}
