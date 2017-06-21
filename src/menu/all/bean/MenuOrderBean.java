package menu.all.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.SqlMapTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MenuOrderBean {
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	////// 사용자 주문 //////
	
	/* 사용자가 이동할 가맹점 선택 페이지*/
	@RequestMapping("userSelectFranchisee.do")
	public String userSelectFranchisee(HttpServletRequest request){
		try{
			List franchiseeList = (List)sqlMap.queryForList("order.selectFranchisee", null);
			request.setAttribute("franchiseeList", franchiseeList);
		}catch(Exception e){e.printStackTrace();}
		
		return "/menu/userSelectFranchisee";
	}
	@RequestMapping("userSelectFranchiseePro.do")
	public String userSelectFranchiseePro(HttpServletRequest request, String name){
		int check=0;
		try{
			if(name==""){
				check=0;
			}else{
				check=1;	
			}
			request.setAttribute("name",name);
			request.setAttribute("check",check);
		}catch(Exception e){
			e.printStackTrace();
			check=-1;
			request.setAttribute("check",check);
		}
		return "/menu/userSelectFranchiseePro";
	}
	
	
	/* 사용자 주문 페이지*/
	@RequestMapping("userOrderForm.do")
	public String userOrderForm(HttpServletRequest request, String name){
		try{
		String l_key = (String)sqlMap.queryForObject("order.getLicenseKey",name);
		List menuList= sqlMap.queryForList("menu.getMenu",l_key);
		request.setAttribute("menuList", menuList);
		List categoryList =sqlMap.queryForList("menu.getCategory",l_key);
		if(categoryList!=null){
			request.setAttribute("categoryList",categoryList);
			request.setAttribute("l_key",l_key);
			request.setAttribute("name", name);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/menu/userOrderForm";
	}
	
	@RequestMapping("userOrderPro.do")
	public String userOrderPro(String name,String order,HttpServletRequest request,String l_key, HttpSession session){
		System.out.println("이름"+name+order);
		int check;
		int orderstatus=1;
		try{
			HashMap map1 = new HashMap();
			map1.put("order", order);
			map1.put("l_key",l_key);
			int productsalecheck=(Integer)sqlMap.queryForObject("order.selectProduct",map1); // 판매되지 않은 주문한 메뉴의 재고를 불러오는 list.
			int menuorderstatus=(Integer)sqlMap.queryForObject("order.selectMenuOrder", map1);
			if(productsalecheck > menuorderstatus){ // 판매되지 않은 주문한 메뉴의 재고가 있을 시.
				// 주문번호 올려주기 위해서
				int num=(Integer)sqlMap.queryForObject("order.orderCount",l_key);
				num=num+1;
		
				int price=(Integer)sqlMap.queryForObject("order.getPrice",map1);
				String id = (String)session.getAttribute("loginId");
				
				HashMap map=new HashMap();
				map.put("num", num);
				map.put("id",id);
				map.put("menuname",order);
				map.put("orderstatus",orderstatus);
				map.put("ordermoney",price);
				map.put("l_key",l_key);
				sqlMap.insert("order.insertMenuOrder", map);
				 
				check=1;
			}else{ // 주문한 메뉴의 재고가 없을 시.
				check=0;
			}
			request.setAttribute("check", check);
			request.setAttribute("order",order);
			request.setAttribute("name",name);
			request.setAttribute("l_key", l_key);
			
		}catch(Exception e){
			e.printStackTrace(); 
			check=-1; request.setAttribute("check", check);
			request.setAttribute("name",name);
			request.setAttribute("l_key", l_key);}
		return "/menu/userOrderPro";
	}
	
	/* 카테고리별 메뉴 리스트 보여주기 (사용자) */
	@RequestMapping("userCategoryClick.do")
	public String userCategoryClick(HttpServletRequest request,String name, String l_key){
		String category=request.getParameter("category");
		// 전체 다 뜨는 거
		if(category.equals("all")){
			List menuList= sqlMap.queryForList("menu.getMenu",l_key);
			request.setAttribute("menuList", menuList);
		}else{
			HashMap map=new HashMap();
			map.put("category", category);
			map.put("l_key", l_key);
			List<MenuDTO> categoryMenuList=(List<MenuDTO>)sqlMap.queryForList("menu.categoryMenuList",map);
			request.setAttribute("categoryMenuList",categoryMenuList);
		}
		request.setAttribute("l_key",l_key);
		request.setAttribute("name",name);
		return "menu/userCategoryClick";
	}
	
	/* 카테고리 전체 메뉴 보여주기 (사용자) */
	@RequestMapping("userCategoryAll.do")
	public String userCategoryAll(HttpServletRequest request, String l_key, String name){
		List menuList= sqlMap.queryForList("menu.getMenu",l_key);
		request.setAttribute("menuList", menuList);
		request.setAttribute("l_key",l_key);
		request.setAttribute("name",name);
		return "/menu/userCategoryAll";
	}
	
	////// 사장님 주문 //////
	
	@RequestMapping("menuOrderListForm.do")
	public String menuOrderListForm(HttpServletRequest request, String l_key){
		String status;
		int check=0;
		try{
			List orderList = (List)sqlMap.queryForList("order.getMenuOrder", l_key);
			request.setAttribute("orderList", orderList);
			request.setAttribute("l_key",l_key);			
		}catch(Exception e){e.printStackTrace();}
		return "/menu/menuOrderListForm";

	}
	
	/* 주문승인버튼 누른 후 바코드 확인하기*/
	@RequestMapping("menuBarcodeCheck.do")
	public String menuBarcodeCheck(HttpServletRequest request,String menuname, int num, String l_key){
		System.out.println("menuBarcodeCheck"+l_key);
		request.setAttribute("name",menuname);
		request.setAttribute("num",num);
		request.setAttribute("l_key",l_key);
		return "/menu/menuBarcodeCheck";
	}
	
	/* 바코드 확인하고 정상적인 주문일 때 완료 페이지*/
	@RequestMapping("menuOrderComplete.do")
	public String menuOrderComplete(HttpServletRequest request, String barcode, int num, String name, String l_key){
		int check=0;
		try{
			System.out.println("menuOrderComplete"+name+l_key+barcode);
			HashMap map=new HashMap();
			map.put("barcode", barcode);
			map.put("name",name);
			map.put("l_key",l_key);
			ProductDTO pdto=(ProductDTO)sqlMap.queryForObject("order.salecheckCheck", map);
			if(pdto==null){
				check=0;
			}else{
				HashMap map1=new HashMap();
				map1.put("num",num);
				map1.put("l_key",l_key);
				sqlMap.update("order.updateStatus",map1); // 주문현황 주문중 --> 주문완료
				
				HashMap map2=new HashMap();
				map2.put("name", name);
				map2.put("barcode", barcode);
				map2.put("l_key", l_key);
				sqlMap.update("order.updateSaleCheck",map2); // 재고 판매여부 1 --> 0
				
				// sellBuyLog 판매시간 입력.
				sqlMap.update("order.productsaleregistdate", map2);
				
				check=1;
			}
			request.setAttribute("check",check);
			request.setAttribute("l_key", l_key);
			request.setAttribute("name",name);
		}catch(Exception e){e.printStackTrace(); check=-1; request.setAttribute("check",check);}
		
		return "/menu/menuOrderComplete";
	}	
}
