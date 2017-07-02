package fx.user.bean;

import java.net.URLEncoder;
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
import menu.all.bean.MenuDTO;
import menu.all.bean.ProductDTO;

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
			model.addAttribute("franchiseeName", URLEncoder.encode(franchiseeName,"UTF-8"));
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
			for(int i = 0; i < rentList.size(); i++){
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
	
	@RequestMapping("fxAddRentProduct.do")
	public String fxAddRentProduct(RentProductDataDTO rent, String regist, Model model){
		String result = "fail";
		try{
			int check = (Integer)sqlMap.queryForObject("rent.getRentCode", rent);
			if(check == 0){
				rent.setBeginRegist(java.sql.Timestamp.valueOf(regist));
				sqlMap.insert("rent.addRentProduct", rent);
				result = "succ";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("result", result);
		return "/fxRent/fxResult";
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
	
	@RequestMapping("fxModifyRentProduct.do")
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
	
	@RequestMapping("fxAddRent.do")
	public String fxAddRent(RentDataDTO rent, Model model){
		String result = "fail";
		try{
			String rentProduct = (String)sqlMap.queryForObject("rent.getRentName", rent);
			if(rentProduct == null){
				sqlMap.insert("rent.addRent", rent);
				result = "succ";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("result", result);
		return "/fxRent/fxResult";
	}
	
	@RequestMapping("fxDelRent.do")
	public String fxDelRent(RentDataDTO rent, Model model){
		String result = "fail";
		try{
			sqlMap.delete("rent.deleteRent", rent);
			result = "succ";
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("result", result);
		return "/fxRent/fxResult";
	}
	
	@RequestMapping("fxGetMenuCategory.do")
	public String fxGetMenu(String b_key, Model model){
		try{
			ArrayList<String> menuList= (ArrayList<String>)sqlMap.queryForList("menu.getCategory",b_key);
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < menuList.size(); i++){
				sb.append("\""+URLEncoder.encode(menuList.get(i), "UTF-8")+"\"");
				if(i != menuList.size()-1){
					sb.append(",");
				}
			}
			model.addAttribute("category", sb.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/fxBossERP/fxGetMenuCategory";
	}
	
	@RequestMapping("fxGetCategoryList.do")
	public String fxGetCategoryList(String b_key, String category, Model model){
		try{
			HashMap<String,String> param = new HashMap<String,String>();
			param.put("l_key", b_key);
			param.put("category", category);
			ArrayList<MenuDTO> menuList= (ArrayList<MenuDTO>)sqlMap.queryForList("menu.categoryMenuList",param);
			StringBuffer sb = new StringBuffer();
			StringBuffer sb2 = new StringBuffer();
			StringBuffer sb3 = new StringBuffer();
			StringBuffer sb4 = new StringBuffer();
			for(int i = 0; i < menuList.size(); i++){
				sb.append("\""+URLEncoder.encode(menuList.get(i).getName(), "UTF-8")+"\"");
				sb2.append("\""+URLEncoder.encode(String.valueOf(menuList.get(i).getPrice()), "UTF-8")+"\"");
				sb3.append("\""+URLEncoder.encode(menuList.get(i).getCompany(), "UTF-8")+"\"");
				sb4.append("\""+URLEncoder.encode(menuList.get(i).getCategory(), "UTF-8")+"\"");
				if(i != menuList.size()-1){
					sb.append(",");
					sb2.append(",");
					sb3.append(",");
					sb4.append(",");
				}
			}
			model.addAttribute("name", sb.toString());
			model.addAttribute("price", sb2.toString());
			model.addAttribute("company", sb3.toString());
			model.addAttribute("category", sb4.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/fxBossERP/fxGetCategoryList";
	}
	
	@RequestMapping("fxAddMenu.do")
	public String fxAddMenu(MenuDTO menu, Model model){
		String result = "fail";
		try{
			sqlMap.insert("menu.insertMenu", menu);
			result = "succ";
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("result", result);
		return "/fxRent/fxResult";
	}
	
	@RequestMapping("fxDeleteMenu.do")
	public String fxDeleteMenu(String l_key, String name, Model model){
		String result = "fail";
		try{
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("l_key", l_key);
			param.put("name", name);
			sqlMap.delete("menu.deleteMenu", param);
			result = "succ";
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("result", result);
		return "/fxRent/fxResult";
	}
	
	@RequestMapping("fxModifyMenu.do")
	public String fxModifyMenu(HttpServletRequest request, Model model){
		String result = "fail";
		try{
			HashMap<String,String> param = new HashMap<String,String>();
			param.put("l_key", request.getParameter("l_key"));
			param.put("name", request.getParameter("name"));
			param.put("beforeName", request.getParameter("beforeName"));
			param.put("company", request.getParameter("company"));
			param.put("price", request.getParameter("price"));
			param.put("category", request.getParameter("category"));	
			sqlMap.update("menu.updateMenu", param);
			result = "succ";
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("result", result);
		return "/fxRent/fxResult";
	}
	
	@RequestMapping("fxGetMenuProduct.do")
	public String fxGetMenuProduct(String b_key, Model model){
		try{
			ArrayList<ProductDTO> product = (ArrayList<ProductDTO>)sqlMap.queryForList("menu.getProduct", b_key);
			StringBuffer sb = new StringBuffer();
			StringBuffer sb2 = new StringBuffer();
			StringBuffer sb3 = new StringBuffer();
			StringBuffer sb4 = new StringBuffer();
			StringBuffer sb5 = new StringBuffer();
			
			for(int i = 0; i < product.size(); i++){
				sb.append("\""+product.get(i).getCode()+"\"");
				sb2.append("\""+URLEncoder.encode(product.get(i).getName(), "UTF-8")+"\"");
				sb3.append("\""+product.get(i).getSalecheck()+"\"");
				sb4.append("\""+product.get(i).getBeginregist()+"\"");
				sb5.append("\""+product.get(i).getLastday()+"\"");
				if(i != product.size()-1){
					sb.append(",");
					sb2.append(",");
					sb3.append(",");
					sb4.append(",");
					sb5.append(",");
				}
			}
			model.addAttribute("code", sb.toString());
			model.addAttribute("name", sb2.toString());
			model.addAttribute("saleCheck", sb3.toString());
			model.addAttribute("beginRegist", sb4.toString());
			model.addAttribute("lastDay", sb5.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/fxBossERP/fxGetMenuProduct";
	}
	
	@RequestMapping("fxAddProduct.do")
	public String fxAddProduct(ProductDTO product, String regist, String last, Model model){
		String result = "fail";
		try{
			product.setBeginregist(java.sql.Timestamp.valueOf(regist));
			product.setLastday(java.sql.Date.valueOf(last));
			sqlMap.insert("menu.insertProductFX", product);
			result = "succ";
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("result", result);
		return "/fxRent/fxResult";
	}
	
	@RequestMapping("fxModifyProduct.do")
	public String fxModifyProduct(HttpServletRequest request, Model model){
		String result = "fail";
		try{
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("l_key", request.getParameter("l_key"));
			param.put("beforeCode", request.getParameter("beforeCode"));
			param.put("code", request.getParameter("code"));
			param.put("lastday", java.sql.Date.valueOf(request.getParameter("lastday")));
			sqlMap.update("menu.updateProduct", param);
			result = "succ";
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("result", result);
		return "/fxRent/fxResult";
	}
	
	@RequestMapping("fxDeleteProduct.do")
	public String fxDeleteProduct(String l_key, String code, Model model){
		String result = "fail";
		try{
			HashMap<String, String> param = new HashMap<String ,String>();
			param.put("l_key", l_key);
			param.put("code", code);
			
			sqlMap.delete("menu.deleteProduct", param);
			result = "succ";
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("result", result);
		return "/fxRent/fxResult";
	}
	
	@RequestMapping("fxDeleteLastProduct.do")
	public String fxDeleteLastProduct(String l_key, Model model){
		String result = "result";
		try{
			sqlMap.delete("order.lastdayDelete", l_key);
			result = "true";
		}catch(Exception e){
			e.printStackTrace();
		}
		model.addAttribute("result", result);
		return "/fxRent/fxResult";
	}
	
}
