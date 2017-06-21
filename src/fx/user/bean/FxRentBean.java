package fx.user.bean;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import manage.boss.bean.RentDataDTO;
import manage.boss.bean.RentLogDataDTO;

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
		return "/fxRent/fxGetRentList";
	}
	
	@RequestMapping("fxOrderRent.do")
	public String fxOrderRent(RentLogDataDTO rentLog, String rentList, Model model){
		String result = "fail";
		try{
			String[] name = rentList.split(" ");
			for(int i=0; i<name.length; i++){
				rentLog.setName(name[i]);
				sqlMap.insert("rent.addUserRent", rentLog);
			}
			result = "succ";
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			model.addAttribute("result", result);
		}
		return "/fxRent/fxOrderRent";
	}
	
	@RequestMapping("fxGetUserRentOrder.do")
	public String fxGetUserRentOrder(String b_key, Model model){
		try{
			ArrayList<RentLogDataDTO> rentOrderList = (ArrayList<RentLogDataDTO>)sqlMap.queryForList("rent.getUserRentOrder", b_key);
			StringBuffer sb = new StringBuffer("[");
			StringBuffer sb2 = new StringBuffer("[");
			for(int i=0; i<rentOrderList.size(); i++){
				sb.append("\""+URLEncoder.encode(rentOrderList.get(i).getName(),"UTF-8")+"\"");
				sb2.append("\""+URLEncoder.encode(rentOrderList.get(i).getId(),"UTF-8")+"\"");
				if(i != rentOrderList.size()-1){
					sb.append(",");
					sb2.append(",");
				}
			}
			sb.append("]");
			sb2.append("]");
			model.addAttribute("name", sb.toString());
			model.addAttribute("id", sb2.toString());
		}catch(Exception e){
			
		}
		return "/fxRent/fxGetUserRentOrder";
	}
	
	@RequestMapping("fxGetUserReturnOrder.do")
	public String fxGetUserReturnOrder(String b_key, Model model){
		try{
			ArrayList<RentLogDataDTO> rentOrderList = (ArrayList<RentLogDataDTO>)sqlMap.queryForList("rent.getUsersRentList", b_key);
			StringBuffer sb = new StringBuffer("[");
			StringBuffer sb2 = new StringBuffer("[");
			StringBuffer sb3 = new StringBuffer("[");
			for(int i=0; i<rentOrderList.size(); i++){
				sb.append("\""+URLEncoder.encode(rentOrderList.get(i).getName(),"UTF-8")+"\"");
				sb2.append("\""+URLEncoder.encode(rentOrderList.get(i).getId(),"UTF-8")+"\"");
				sb3.append(URLEncoder.encode(String.valueOf(rentOrderList.get(i).getCode()),"UTF-8"));
				if(i != rentOrderList.size()-1){
					sb.append(",");
					sb2.append(",");
					sb3.append(",");
				}
			}
			sb.append("]");
			sb2.append("]");
			sb3.append("]");
			model.addAttribute("name", sb.toString());
			model.addAttribute("id", sb2.toString());
			model.addAttribute("code", sb3.toString());
			
		}catch(Exception e){
			
		}
		return "/fxRent/fxGetUserReturnOrder";
	}
	
	@RequestMapping("fxUserRentReturnOk.do")
	public String fxUserRentReturnOk(RentLogDataDTO rentLog, String what, Model model){
		String result = "fail";
		try{
			HashMap param = new HashMap();
			param.put("b_key", rentLog.getB_key());
			param.put("code", rentLog.getCode());
			if(what.equals("rent")){
				sqlMap.update("rent.userRentOk", rentLog);
				param.put("rentCheck", 1);
				sqlMap.update("rent.updateRentState", param);
			}else{
				System.out.println(what);
				sqlMap.update("rent.userReturnOK", rentLog);
				param.put("rentCheck", 0);
				sqlMap.update("rent.updateRentState", param);
			}
			result = "succ";
			model.addAttribute("result", result);
		}catch(Exception e){
			
		}
		return "/fxRent/fxUserRentReturnOk";
	}
	
}
