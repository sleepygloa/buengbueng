package manage.boss.bean;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import login.user.bean.BossInfoDataDTO;

@Controller
public class RentMaterialsBean {

	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	@RequestMapping("rentMain.do")
	public String rentMain(){
		return "/bossERP/rentMaterials/rentMain";
	}
	
	@RequestMapping("rentManage.do")
	public String rentManage(HttpSession session, Model model){
		String id = (String)session.getAttribute("loginId");
		try{
			BossInfoDataDTO bdto = (BossInfoDataDTO)sqlMap.queryForObject("bossERP.getBossInfo", id);		
			ArrayList<RentDataDTO> rentList = (ArrayList)sqlMap.queryForList("rent.getRentAll", bdto.getB_key());
			model.addAttribute("rentList", rentList);
		}catch(Exception e){
			/// 추후 수정
		}
		return "/bossERP/rentMaterials/rentManage";
	}
	
	@RequestMapping("addRent.do")
	public String addRent(Model model){
		model.addAttribute("page", "add");
		return "/bossERP/rentMaterials/addModiRent";
	}
	
	@RequestMapping("addModiRentPro.do")
	public String addRentPro(RentDataDTO rdto, HttpSession session, HttpServletRequest request, String page, Model model){
		int check = 0;
		String id = (String)session.getAttribute("loginId");
		try{
			BossInfoDataDTO bdto = (BossInfoDataDTO)sqlMap.queryForObject("bossERP.getBossInfo", id);
			if(page.equals("add")){
				rdto.setB_key(bdto.getB_key());
				String rentProduct = (String)sqlMap.queryForObject("rent.getRentName",rdto);
				if(rentProduct == null){
					sqlMap.insert("rent.addRent", rdto);
					check = 1;
				}
			}else{
				HashMap<String,String> param = new HashMap<String,String>();
				param.put("b_key", request.getParameter("key"));
				param.put("afterProduct", request.getParameter("afterProduct"));
				param.put("beforeProduct", request.getParameter("beforeProduct"));
				sqlMap.update("rent.modiRent", param);
				check = 1;
			}
			model.addAttribute("check", check);

		}catch(Exception e){
			// 추후 수정
		}
		return "/bossERP/rentMaterials/gotoRentManage";
	}
	
	@RequestMapping("delRent.do")
	public String delRent(HttpSession session, String rentName, Model model){
		String id = (String)session.getAttribute("loginId");
		try{
			BossInfoDataDTO bdto = (BossInfoDataDTO)sqlMap.queryForObject("bossERP.getBossInfo", id);
			RentDataDTO rdto = new RentDataDTO();
			rdto.setB_key(bdto.getB_key());
			String[] rent = rentName.split(",");
			for(int i=0; i< rent.length; i++){
				rdto.setRentProduct(rent[i]);
				sqlMap.delete("rent.deleteRent", rdto);
			}	
			model.addAttribute("check", "1");
		}catch(Exception e){
			/// 추후 수정
		}
		return "/bossERP/rentMaterials/gotoRentManage";
	}
	
	@RequestMapping("modiRent.do")
	public String modiRent(HttpSession session, String rentProduct, Model model){
		String id = (String)session.getAttribute("loginId");
		try{
			BossInfoDataDTO bdto = (BossInfoDataDTO)sqlMap.queryForObject("bossERP.getBossInfo", id);
			RentDataDTO rent = new RentDataDTO();
			rent.setB_key(bdto.getB_key());
			rent.setRentProduct(rentProduct);
			model.addAttribute("rent", rent);
			model.addAttribute("page", "modi");
		}catch(Exception e){
			// 추후 수정
		}
		return "/bossERP/rentMaterials/addModiRent";
	}
	
	@RequestMapping("selectedRentProductAll.do")
	public String getRentProductAll(HttpSession session, String rentProduct, Model model){
		String id = (String)session.getAttribute("loginId");
		try{
			BossInfoDataDTO bdto = (BossInfoDataDTO)sqlMap.queryForObject("bossERP.getBossInfo", id);
			RentDataDTO rent = new RentDataDTO();
			rent.setB_key(bdto.getB_key());
			rent.setRentProduct(rentProduct);
			ArrayList<RentProductDataDTO> rentPList = (ArrayList)sqlMap.queryForList("rent.getRentProductAll", rent);
			model.addAttribute("rentPList", rentPList);
			model.addAttribute("rentProduct", rentProduct);
		}catch(Exception e){
			// 추후 수정
		}
		return "/bossERP/rentMaterials/selectedRentProductAll";
	}
	
	@RequestMapping("addRentProduct.do")
	public String addRentProduct(HttpSession session, Model model){
		String id = (String)session.getAttribute("loginId");
		try{
			BossInfoDataDTO bdto = (BossInfoDataDTO)sqlMap.queryForObject("bossERP.getBossInfo", id);
			ArrayList<RentDataDTO> rentName = (ArrayList)sqlMap.queryForList("rent.getRentAll", bdto.getB_key());
			model.addAttribute("rentName", rentName);
			model.addAttribute("page", "add");
		}catch(Exception e){
			// 추후 수정
		}
		return "/bossERP/rentMaterials/addModiRentProduct";
	}
	
	@RequestMapping("addModiRentProductPro.do")
	public String addRentProductPro(HttpSession session, String page, RentProductDataDTO rdto, HttpServletRequest request, Model model){
		String id = (String)session.getAttribute("loginId");
		int check = 0;
		try{
			BossInfoDataDTO bdto = (BossInfoDataDTO)sqlMap.queryForObject("bossERP.getBossInfo", id);
			rdto.setB_key(bdto.getB_key());
			if(page.equals("add")){
				check = (Integer)sqlMap.queryForObject("rent.getRentCode", rdto);
				if(check == 0){
					sqlMap.insert("rent.addRentProduct", rdto);
					check = 1;
				}else{
					check = 0;
				}
			}else{		
				if(Integer.parseInt(request.getParameter("beforeCode")) != rdto.getCode()){
					check = (Integer)sqlMap.queryForObject("rent.getRentCode", rdto);
				}
				if(check == 0){
					HashMap<String,Object> param = new HashMap<String,Object>();
					param.put("b_key", bdto.getB_key());
					param.put("afterProduct", rdto.getRentProduct());
					param.put("beforeCode", request.getParameter("beforeCode"));
					param.put("afterCode", rdto.getCode());	
					sqlMap.update("rent.modiRentProduct", param);
					check = 1;
				}else{
					check = 0;
				}
			}
			model.addAttribute("check", check);
		}catch(Exception e){
			// 추후 수정
		}
		return "/bossERP/rentMaterials/gotoRentManage";
	}

	@RequestMapping("modiRentProduct.do")
	public String modiRentProduct(HttpSession session, int rentCode, Model model){
		String id = (String)session.getAttribute("loginId");
		try{
			BossInfoDataDTO bdto = (BossInfoDataDTO)sqlMap.queryForObject("bossERP.getBossInfo", id);
			RentProductDataDTO param = new RentProductDataDTO();
			param.setB_key(bdto.getB_key());
			param.setCode(rentCode);
			
			param = (RentProductDataDTO)sqlMap.queryForObject("rent.getRentProduct", param);
			
			ArrayList<RentDataDTO> rentName = (ArrayList)sqlMap.queryForList("rent.getRentAll", bdto.getB_key());
			model.addAttribute("rentName", rentName);
			model.addAttribute("rentP", param);
			model.addAttribute("page", "modi");

		}catch(Exception e){
			// 추후 수정
		}
		return "/bossERP/rentMaterials/addModiRentProduct";
	}
	
	@RequestMapping("delRentProduct.do")
	public String delRentProduct(HttpSession session, String rentPCode, Model model){
		String id = (String)session.getAttribute("loginId");
		try{
			BossInfoDataDTO bdto = (BossInfoDataDTO)sqlMap.queryForObject("bossERP.getBossInfo", id);
			RentProductDataDTO rdto = new RentProductDataDTO();
			rdto.setB_key(bdto.getB_key());
			String[] rent = rentPCode.split(",");
			for(int i=0; i< rent.length; i++){
				rdto.setCode(Integer.parseInt(rent[i]));
				sqlMap.delete("rent.deleteRentProduct", rdto);
			}	
			model.addAttribute("check", "1");
		}catch(Exception e){
			/// 추후 수정
		}
		return "/bossERP/rentMaterials/gotoRentManage";
	}
}
