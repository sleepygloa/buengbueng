package menu.all.bean;

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
	 
	/* 사용자 주문 페이지*/
	@RequestMapping("userOrderForm.do")
	public String userOrderForm(HttpServletRequest request){
		try{
		List menuList= sqlMap.queryForList("menu.getMenu",null);
		request.setAttribute("menuList", menuList);
		List categoryList =sqlMap.queryForList("menu.getCategory",null);
		if(categoryList!=null){
			request.setAttribute("categoryList",categoryList);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/menu/userOrderForm";
	}
	
	@RequestMapping("userOrderPro.do")
	public String userOrderPro(String order,HttpServletRequest request, HttpSession session){
		int check;
		int orderstatus=1;
		try{
			List orderProductList=(List)sqlMap.queryForList("menu.selectProduct",order); // 판매되지 않은 주문한 메뉴의 재고를 불러오는 list.
			if(orderProductList!=null){ // 판매되지 않은 주문한 메뉴의 재고가 있을 시.
				// 주문번호 올려주기 위해서
				int num=(Integer)sqlMap.queryForObject("menu.orderCount",null);
				num=num+1;
				System.out.println("제발좀..."+order);
				int price=(Integer)sqlMap.queryForObject("menu.getPrice",order);
				String id = (String)session.getAttribute("loginId");
				
				HashMap map=new HashMap();
				map.put("num", num);
				map.put("id",id);
				map.put("menuname",order);
				map.put("orderstatus",orderstatus);
				map.put("ordermoney",price);
				sqlMap.insert("menu.insertMenuOrder", map);
				
				check=1;
			}else{ // 주문한 메뉴의 재고가 없을 시.
				check=0;
			}
			request.setAttribute("check", check);
			request.setAttribute("order",order);
		}catch(Exception e){e.printStackTrace(); check=-1; request.setAttribute("check", check);}
		return "/menu/userOrderPro";
	}
	
	/* 카테고리별 메뉴 리스트 보여주기 (사용자) */
	@RequestMapping("userCategoryClick.do")
	public String userCategoryClick(HttpServletRequest request){
		String category=request.getParameter("category");
		// 전체 다 뜨는 거
		if(category.equals("all")){
			List menuList= sqlMap.queryForList("menu.getMenu",null);
			request.setAttribute("menuList", menuList);
		}else{
			List categoryMenuList=sqlMap.queryForList("menu.categoryMenuList",category);
			request.setAttribute("categoryMenuList",categoryMenuList);
		}
		return "menu/userCategoryClick";
	}
	
	/* 카테고리 전체 메뉴 보여주기 (사용자) */
	@RequestMapping("userCategoryAll.do")
	public String userCategoryAll(HttpServletRequest request){
		List menuList= sqlMap.queryForList("menu.getMenu",null);
		request.setAttribute("menuList", menuList);
		return "/menu/userCategoryAll";
	}
	
	
	
	
	////// 사장님 주문 //////
	@RequestMapping("menuOrderListForm.do")
	public String menuOrderListForm(HttpServletRequest request){
		String status;
		try{
			List orderList = (List)sqlMap.queryForList("menu.getMenuOrder", null);
			request.setAttribute("orderList", orderList);
			for(int i=0; i<orderList.size();i++){
				OrderDTO odto=(OrderDTO) orderList.get(i);
				if(odto.getOrderstatus()==1){
					status="주문중";
				}else if(odto.getOrderstatus()==2){
					status="주문완료";
				}else{
					status="주문취소";
				}
				request.setAttribute("status",status);
			}
			
		}catch(Exception e){e.printStackTrace();}
		return "/menu/menuOrderListForm";
	}
	
	/* 주문승인버튼 누른 후 바코드 확인하기*/
	@RequestMapping("menuBarcodeCheck.do")
	public String menuBarcodeCheck(HttpServletRequest request,String menuname, int num){
		request.setAttribute("menuname",menuname);
		request.setAttribute("num",num);
		return "/menu/menuBarcodeCheck";
	}
	
	/* 바코드 확인하고 정상적인 주문일 때 완료 페이지*/
	@RequestMapping("menuOrderComplete.do")
	public String menuOrderComplete(HttpServletRequest request, int barcode, int num, String menuname){
		try{
			HashMap map=new HashMap();
			map.put("barcode", barcode);
			map.put("menuname",menuname);
			ProductDTO pdto=(ProductDTO)sqlMap.queryForObject("menu.salecheckCheck", map);
			if(!pdto.equals(null)){
				sqlMap.update("menu.updateStatus",num); // 주문현황 주문중 --> 주문완료
				sqlMap.update("menu.updateStatus",barcode); // 재고 판매여부 1 --> 0
				
			}
			
		}catch(Exception e){e.printStackTrace();}
		
		return "/menu/menuOrderComplete";
	}	
}
