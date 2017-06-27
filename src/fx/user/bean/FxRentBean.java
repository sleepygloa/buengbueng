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
import manage.boss.bean.RentProductDataDTO;

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
				int count = (Integer)sqlMap.queryForObject("rent.getRentProductCount", rentList.get(i));
				int orderCount = (Integer)sqlMap.queryForObject("rent.getUserRentOrderCount", rentList.get(i));
				if(count != 0 && (count - orderCount)>0){
					sb.append("\""+URLEncoder.encode(rentList.get(i).getRentProduct(),"UTF-8")+"\"");
					if(i!= rentList.size()-1){
						sb.append(",");
					}
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
		String suc = "";
		String err = "";
		StringBuffer sb = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		try{
			String[] name = rentList.split(" ");
			for(int i=0; i<name.length; i++){
				rentLog.setName(name[i]);
				int count = (Integer)sqlMap.queryForObject("rent.getUserRentCheck", rentLog);
				if(count ==0){
					sqlMap.insert("rent.addUserRent", rentLog);
					sb2.append(name[i]+",");
					result = "succ";
				}else{
					sb.append(rentLog.getName()+",");
				}
			}
			if(sb.length() != 0){
				err = sb.toString().substring(0,sb.toString().length()-1)+"은(는) 대여 신청 또는 대여 중인 물품으로 제외되었습니다.";
			}
			if(sb2.length() != 0){
				suc = sb2.toString().substring(0,sb2.toString().length()-1);
			}
			model.addAttribute("result", URLEncoder.encode(result, "UTF-8"));
			model.addAttribute("suc", URLEncoder.encode(suc, "UTF-8"));
			model.addAttribute("err", URLEncoder.encode(err, "UTF-8"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/fxRent/fxOrderRent";
	}
	
	@RequestMapping("fxGetUserRentOrder.do")
	public String fxGetUserRentOrder(String b_key, Model model){
		try{
			ArrayList<RentLogDataDTO> rentOrderList = (ArrayList<RentLogDataDTO>)sqlMap.queryForList("rent.getUserRentOrder", b_key);
			StringBuffer sb = new StringBuffer("[");
			StringBuffer sb2 = new StringBuffer("[");
			StringBuffer sb3 = new StringBuffer("[");
			for(int i=0; i<rentOrderList.size(); i++){
				sb.append("\""+URLEncoder.encode(rentOrderList.get(i).getName(),"UTF-8")+"\"");
				sb2.append("\""+URLEncoder.encode(rentOrderList.get(i).getId(),"UTF-8")+"\"");
				sb3.append(rentOrderList.get(i).getPcNum());
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
			model.addAttribute("pcNum", sb3.toString());
		}catch(Exception e){
			
		}
		return "/fxRent/fxGetUserRentOrder";
	}
	
	@RequestMapping("fxGetUserRentCancel.do")
	public String fxGetUserRentCancel(RentLogDataDTO rentLog, Model model){
		String result = "fail";
		try{
			sqlMap.delete("rent.userRentCancel", rentLog);
			result = "succ";
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("result", result);
		return "/fxRent/fxResult";
	}
	
	@RequestMapping("fxGetUserReturnOrder.do")
	public String fxGetUserReturnOrder(String b_key, Model model){
		try{
			ArrayList<RentLogDataDTO> rentOrderList = (ArrayList<RentLogDataDTO>)sqlMap.queryForList("rent.getUsersRentList", b_key);
			StringBuffer sb = new StringBuffer("[");
			StringBuffer sb2 = new StringBuffer("[");
			StringBuffer sb3 = new StringBuffer("[");
			StringBuffer sb4 = new StringBuffer("[");
			for(int i=0; i<rentOrderList.size(); i++){
				sb.append("\""+URLEncoder.encode(rentOrderList.get(i).getName(),"UTF-8")+"\"");
				sb2.append("\""+URLEncoder.encode(rentOrderList.get(i).getId(),"UTF-8")+"\"");
				sb3.append(URLEncoder.encode(String.valueOf(rentOrderList.get(i).getCode()),"UTF-8"));
				sb3.append(rentOrderList.get(i).getPcNum());
				if(i != rentOrderList.size()-1){
					sb.append(",");
					sb2.append(",");
					sb3.append(",");
					sb4.append(",");
				}
			}
			sb.append("]");
			sb2.append("]");
			sb3.append("]");
			sb4.append("]");
			model.addAttribute("name", sb.toString());
			model.addAttribute("id", sb2.toString());
			model.addAttribute("code", sb3.toString());
			model.addAttribute("pcNum", sb4.toString());
			
		}catch(Exception e){
			
		}
		return "/fxRent/fxGetUserReturnOrder";
	}
	
	@RequestMapping("fxUserRentReturnOk.do")
	public String fxUserRentReturnOk(RentLogDataDTO rentLog, String what, Model model){
		String result = "fail";
		try{
			RentProductDataDTO rdto = new RentProductDataDTO();
			rdto.setB_key(rentLog.getB_key());
			rdto.setCode(rentLog.getCode());
			if(what.equals("rent")){
				rdto = (RentProductDataDTO)sqlMap.queryForObject("rent.getRentProduct", rdto);
				if(rdto != null && rdto.getRentCheck() == 0 && rdto.getRentProduct().equals(rentLog.getName())){
					sqlMap.update("rent.userRentOk", rentLog);
					rdto.setRentCheck(1);
					sqlMap.update("rent.updateRentState", rdto);
					result = "succ";
				}else{
					result = URLEncoder.encode("바코드 정보를 정확히 입력하세요.","UTF-8");
				}
			}else{
				sqlMap.update("rent.userReturnOK", rentLog);
				rdto.setRentCheck(0);
				sqlMap.update("rent.updateRentState", rdto);
				result = "succ";
			}
			model.addAttribute("result", result);
		}catch(Exception e){
			
		}
		return "/fxRent/fxResult";
	}
	
}
