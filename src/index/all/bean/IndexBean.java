package index.all.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import config.setting.init.NodeInit;

@Controller
public class IndexBean {

	//sql을 연결 시켜주는 변수
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	
	//메인페이지로 보내주는 Do
	@RequestMapping("index.do")
	public String index(){
		
		return "index";
	}
}