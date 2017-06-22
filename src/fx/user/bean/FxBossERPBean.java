package fx.user.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FxBossERPBean {

	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	@RequestMapping("fxGetModule.do")
	public String fxGetModule(String key, Model model){
		try{
			StringBuffer sb = new StringBuffer();
			sb.append("[");
			sb.append((String)sqlMap.queryForObject("module.getModule",key));
			sb.append("]");
			model.addAttribute("module", sb.toString());
		}catch(Exception e){
			
		}
		return "/fxBossERP/fxGetModule";
	}
	
}
