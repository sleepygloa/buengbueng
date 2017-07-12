package remote.all.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RemoteIntro {

	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	
	@RequestMapping("remoteIntro.do")
	public String remoteIntro(){
		return "/remote/remoteIntro";
	}
	
	
}
