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
	
	public void pageNum(HttpServletRequest request){
		String pageNum = request.getParameter("pageNum");
		String pageNum2 = request.getParameter("pageNum2");
		String pageNum3 = request.getParameter("pageNum3");
		String pageNum4 = request.getParameter("pageNum4");
		String pageNum5 = request.getParameter("pageNum5");
		
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageNum2", pageNum2);
		request.setAttribute("pageNum3", pageNum3);
		request.setAttribute("pageNum4", pageNum4);
		request.setAttribute("pageNum5", pageNum5);
	}
}
