package fx.user.bean;

import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import manage.boss.bean.RentDataDTO;
import manage.boss.bean.RentProductDataDTO;
import manage.boss.bean.SeatStateDataDTO;

@Controller
public class FxBossERPBean {
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	@RequestMapping("fxGetPcUseState.do")
	public String fxGetPcUseState(String b_key, Model model){
		try{
			SeatStateDataDTO sdto = (SeatStateDataDTO)sqlMap.queryForObject("bossERP.getSeatCount", b_key);
			ArrayList<String> state = (ArrayList<String>)sqlMap.queryForList("pcInfo.getState", b_key);
			int pcCount = (Integer)sqlMap.queryForObject("bossERP.getPcCount", b_key);
			String franchiseeName = (String)sqlMap.queryForObject("bossERP.getFranchiseeName", b_key);
			model.addAttribute("franchiseeName", franchiseeName);
			model.addAttribute("count",pcCount);
			StringBuffer s = new StringBuffer();
			for(int i = 0; i < state.size(); i++){
				s.append("\""+URLEncoder.encode(state.get(i),"UTF-8")+"\"");
				if(i != state.size()-1){
					s.append(",");
				}
			}
			model.addAttribute("state", s.toString());
			if(sdto != null){
				model.addAttribute("seatCon",sdto.getSeatCheck());
				ArrayList<HashMap<String,String>> param = (ArrayList<HashMap<String,String>>)sqlMap.queryForList("useSeat.getUseUserId", b_key);
				StringBuffer useSeatId = new StringBuffer();
				StringBuffer useSeatNum = new StringBuffer();
				if(param != null){
					for(int i=0; i<param.size(); i++){
						HashMap<String,Object> a = new HashMap();
						a.put("key",b_key);
						a.put("ip",param.get(i).get("ip"));
						// 사용자의 좌석번호 알아내기
						int num = (int)sqlMap.queryForObject("bossERP.getPcNum",a);
						useSeatNum.append("\""+num+"\"");
						a.remove("ip");
						a.put("id", param.get(i).get("id").toString());
						useSeatId.append("\""+param.get(i).get("id").toString()+"\"");
						if(i != param.size()-1){
							useSeatNum.append(",");
							useSeatId.append(",");
						}
					}
					model.addAttribute("useSeatId",useSeatId.toString());
				}
				model.addAttribute("useSeatNum",useSeatNum.toString());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/fxBossERP/fxGetPcUseState";
	}
	
	@RequestMapping("fxGetRent.do")
	public String fxGetRent(String b_key, Model model){
		try{
			ArrayList<RentDataDTO> rentList = (ArrayList)sqlMap.queryForList("rent.getRentAll", b_key);
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < rentList.size()-1; i++){
				sb.append("\""+URLEncoder.encode(rentList.get(i).getRentProduct(),"UTF-8")+"\"");
				if(i != rentList.size()-1){
					sb.append(",");
				}
			}
			model.addAttribute("rentProduct", sb.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "/fxBossERP/fxGetRent";
	}
	
	@RequestMapping("fxGetRentProduct.do")
	public String fxGetRentProduct(RentDataDTO rent, Model model){
		try{
			ArrayList<RentProductDataDTO> rentPList = (ArrayList)sqlMap.queryForList("rent.getRentProductAll", rent);
			StringBuffer sb = new StringBuffer();
			StringBuffer sb2 = new StringBuffer();
			StringBuffer sb3 = new StringBuffer();
			for(int i = 0; i < rentPList.size(); i++){
				sb.append("\""+rentPList.get(i).getCode()+"\"");
				sb2.append("\""+rentPList.get(i).getRentCheck()+"\"");
				sb3.append("\""+rentPList.get(i).getBeginRegist()+"\"");
				if(i != rentPList.size()-1){
					sb.append(",");
					sb2.append(",");
					sb3.append(",");
				}
			}
			model.addAttribute("code", sb.toString());
			model.addAttribute("rentCheck", sb2.toString());
			model.addAttribute("beginRegist", sb3.toString());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "/fxBossERP/fxGetRentProduct";
	}
	
	@RequestMapping("fxDeleteRentProduct.do")
	public String fxDeleteRentProduct(RentProductDataDTO rdto, Model model){
		String result = "fail";
		try{
			sqlMap.delete("rent.deleteRentProduct", rdto);
			result = "succ";
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("result", result);
		return "/fxRent/fxResult";
	}
	
	@RequestMapping("fxDeleteRentProduct.do")
	public String fxDeleteRentProduct(HttpServletRequest request, Model model){
		String result = "fail";
		try{
			HashMap<String,Object> param = new HashMap<String,Object>();
			param.put("b_key", request.getParameter("b_key"));
			param.put("afterCode", request.getParameter("afterCode"));
			param.put("beforeCode", request.getParameter("beforeCode"));
			param.put("rentCheck", request.getParameter("rentCheck"));
			param.put("beginRegist", java.sql.Timestamp.valueOf(request.getParameter("beginRegist")));	
			sqlMap.update("rent.modifyRentProduct", param);
			result = "succ";
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("result", result);
		return "/fxRent/fxResult";
	}
}
