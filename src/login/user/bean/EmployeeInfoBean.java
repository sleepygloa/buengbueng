package login.user.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeInfoBean {
	@Autowired
	private SqlMapClientTemplate sqlMap;

	
	@RequestMapping("employeeSignForm.do")
	public String employeeSign(){
		return "/userInfo/employeeSignForm";
	}
}
