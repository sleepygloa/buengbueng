package fx.user.bean;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import manage.boss.bean.RentDataDTO;

@Controller
public class FxRentBean {
	
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	@RequestMapping("fxGetRentList.do")
	public String getRentList(String key, Model model){
		ArrayList<RentDataDTO> rentList = (ArrayList)sqlMap.queryForList("rent.getRentAll",key);
		StringBuffer sb = new StringBuffer("[");
		for(int i=0; i<rentList.size(); i++){
			try {
				sb.append("\""+URLEncoder.encode(rentList.get(i).getRentProduct(),"UTF-8")+"\"");
				if(i!= rentList.size()-1){
					sb.append(",");
				}
			} catch (UnsupportedEncodingException e) {
			}
		}
		sb.append("]");
		
		model.addAttribute("rentList", sb.toString());
		return "fxRent/fxGetRentList";
	}
	
	@RequestMapping("fxOrderRent.do")
	public String fxOrderRent(Model model){
		String result = "succ";
		try{
			
		}catch(Exception e){
			// 추후 수정
		}finally{
			model.addAttribute("result", result);
		}
		return "fxRent/fxOrderRent";
	}
}
