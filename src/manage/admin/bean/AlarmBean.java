package manage.admin.bean;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class AlarmBean {
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
}
