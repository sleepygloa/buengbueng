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

	@RequestMapping("rentManage.do")
	public String rentManage(HttpSession session, Model model){
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		model.addAttribute("sidemenuCheck", sidemenuCheck);
		model.addAttribute("sidemenu", sidemenu);
		
		try{
			String b_key = (String)session.getAttribute("b_key");
			ArrayList<RentDataDTO> rentList = (ArrayList)sqlMap.queryForList("rent.getRentAll", b_key);
			model.addAttribute("rentList", rentList);
		}catch(Exception e){
			/// 추후 수정
		}
		return "/bossERP/rentMaterials/rentManage";
	}
	
	@RequestMapping("addRent.do")
	public String addRent(String b_key,Model model){
		model.addAttribute("page", "add");
		model.addAttribute("b_key", b_key);
		return "/bossERP/rentMaterials/addModiRent";
	}
	
	@RequestMapping("addModiRentPro.do")
	public String addRentPro(RentDataDTO rdto, HttpServletRequest request, String page, Model model){
		int check = 0;
		try{
			if(page.equals("add")){
				String rentProduct = (String)sqlMap.queryForObject("rent.getRentName",rdto);
				if(rentProduct == null){
					sqlMap.insert("rent.addRent", rdto);
					check = 1;
					model.addAttribute("b_key", rdto.getB_key());
				}
			}else{
				HashMap<String,String> param = new HashMap<String,String>();
				param.put("b_key", request.getParameter("key"));
				param.put("afterProduct", request.getParameter("afterProduct"));
				param.put("beforeProduct", request.getParameter("beforeProduct"));
				sqlMap.update("rent.modiRent", param);
				check = 1;
				model.addAttribute("b_key", request.getParameter("key"));
			}
			model.addAttribute("check", check);
		}catch(Exception e){
			// 추후 수정
		}
		return "/bossERP/rentMaterials/gotoRentManage";
	}
	
	@RequestMapping("delRent.do")
	public String delRent(RentDataDTO rdto,String rentName, Model model){
		try{
			String[] rent = rentName.split(",");
			for(int i=0; i< rent.length; i++){
				rdto.setRentProduct(rent[i]);
				sqlMap.delete("rent.deleteRent", rdto);
			}	
			model.addAttribute("check", "1");
			model.addAttribute("b_key", rdto.getB_key());
		}catch(Exception e){
			/// 추후 수정
		}
		return "/bossERP/rentMaterials/gotoRentManage";
	}
	
	@RequestMapping("modiRent.do")
	public String modiRent(RentDataDTO rent, Model model){
		try{
			model.addAttribute("rent", rent);
			model.addAttribute("page", "modi");
		}catch(Exception e){
			// 추후 수정
		}
		return "/bossERP/rentMaterials/addModiRent";
	}
	
	@RequestMapping("selectedRentProductAll.do")
	public String getRentProductAll(RentDataDTO rent, Model model){
		try{
			ArrayList<RentProductDataDTO> rentPList = (ArrayList)sqlMap.queryForList("rent.getRentProductAll", rent);
			model.addAttribute("rentPList", rentPList);
			model.addAttribute("rentProduct", rent.getRentProduct());
			model.addAttribute("b_key", rent.getB_key());
		}catch(Exception e){
			// 추후 수정
		}
		return "/bossERP/rentMaterials/selectedRentProductAll";
	}
	
	@RequestMapping("addRentProduct.do")
	public String addRentProduct(String b_key, Model model){
		try{
			ArrayList<RentDataDTO> rentName = (ArrayList<RentDataDTO>)sqlMap.queryForList("rent.getRentAll", b_key);
			model.addAttribute("rentName", rentName);
			model.addAttribute("page", "add");
			model.addAttribute("b_key", b_key);
		}catch(Exception e){
			// 추후 수정
		}
		return "/bossERP/rentMaterials/addModiRentProduct";
	}
	
	@RequestMapping("addModiRentProductPro.do")
	public String addRentProductPro(String page, RentProductDataDTO rdto, HttpServletRequest request, Model model){
		int check = 0;
		try{
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
					param.put("b_key", rdto.getB_key());
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
			model.addAttribute("b_key", rdto.getB_key());
		}catch(Exception e){
			// 추후 수정
		}
		return "/bossERP/rentMaterials/gotoRentManage";
	}

	@RequestMapping("modiRentProduct.do")
	public String modiRentProduct(RentProductDataDTO param, Model model){
		try{
			param = (RentProductDataDTO)sqlMap.queryForObject("rent.getRentProduct", param);
			
			ArrayList<RentDataDTO> rentName = (ArrayList<RentDataDTO>)sqlMap.queryForList("rent.getRentAll", param.getB_key());
			model.addAttribute("rentName", rentName);
			model.addAttribute("rentP", param);
			model.addAttribute("page", "modi");
			model.addAttribute("b_key", param.getB_key());
		}catch(Exception e){
			// 추후 수정
		}
		return "/bossERP/rentMaterials/addModiRentProduct";
	}
	
	@RequestMapping("delRentProduct.do")
	public String delRentProduct(RentProductDataDTO rdto, String rentPCode, Model model){
		try{
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
