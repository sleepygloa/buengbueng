package manage.admin.bean;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
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
}
