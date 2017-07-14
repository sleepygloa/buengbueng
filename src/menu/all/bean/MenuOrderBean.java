package menu.all.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MenuOrderBean {
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	////// 사용자 주문 //////
	
	/* 사용자 주문 페이지*/
	@RequestMapping("userOrderForm.do")
	public String userOrderForm(String id, String tf ,HttpServletRequest request, String name){
		try{
			String l_key = (String)sqlMap.queryForObject("order.getLicenseKey",name);
			List menuList= sqlMap.queryForList("menu.getMenu",l_key);
			request.setAttribute("menuList", menuList);
			
			//사용자가 주문 주문내역 가져오기
			String loginTime = (String)sqlMap.queryForObject("useSeat.getUserStartTime2", id);
			
			HashMap map = new HashMap();
			map.put("l_key",l_key);
			map.put("id",id);
			map.put("loginTime", loginTime);
			List<OrderDTO> userOrderList=(List<OrderDTO>)sqlMap.queryForList("order.getUserOrderList", map);
			request.setAttribute("userOrderList", userOrderList);
			request.setAttribute("id", id);
			request.setAttribute("name",name);
	
			
			List categoryList =sqlMap.queryForList("menu.getCategory",l_key);
			if(categoryList!=null){
				request.setAttribute("categoryList",categoryList);
				request.setAttribute("l_key",l_key);
				request.setAttribute("name", name);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	    if(tf == null){
	         return "/menu/userOrderForm";
	      }else{
	         return "/menu/userOrderTable";
	      }
	}
	
	@RequestMapping("userOrderPro.do")
	public String userOrderPro(String name,String order,HttpServletRequest request,String l_key, String id){
		
		int check;
		int num;
		int orderMoney = 0;
		int orderstatus=1;
		List<OrderDTO> menuOrderList;
		try{
			HashMap map1 = new HashMap();
			map1.put("order", order);
			map1.put("l_key",l_key);
			int productsalecheck=(Integer)sqlMap.queryForObject("order.selectProduct",map1); // 판매되지 않은 주문한 메뉴의 재고를 불러오는 list.
			int menuorderstatus=(Integer)sqlMap.queryForObject("order.selectMenuOrder", map1);

			int price=(Integer)sqlMap.queryForObject("order.getPrice",map1);

			// 사용자가 주문은 하고 아직 승인이 안됬을 때 그 금액도 현재잔액과 합해야함
			List userOrderMoneyList = (List)sqlMap.queryForList("order.getMenuOrderMoney",id);
			if(userOrderMoneyList!=null){
				for(int i=0; i<userOrderMoneyList.size(); i++){
					orderMoney+=(int) userOrderMoneyList.get(i);
				}
			}
			
			int userMoney=(Integer)sqlMap.queryForObject("order.getUserMoney",id);
			userMoney=userMoney-orderMoney; //현재 잔액에서 주문내역에들어간 주문승인이 안된 값을 빼주고 난 뒤에 주문가능.
			
			if(userMoney<price){
				check=2;
			}else{
						
			if(productsalecheck > menuorderstatus){ // 판매되지 않은 주문한 메뉴의 재고가 있을 시.
				menuOrderList=(List<OrderDTO>)sqlMap.queryForList("order.orderCount",l_key);
				if(menuOrderList.size()==0){
					num=0;
					}else{				
					Date nowtime=new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String nowTime = sdf.format(nowtime);
					
					// 마지막 주문의 날짜 가져오기.
					String lastOrdertime=(String)sqlMap.queryForObject("order.getLastOrder",l_key);
					if(lastOrdertime.equals(nowTime)){ 
						OrderDTO odto=(OrderDTO) menuOrderList.get(0);
						num=odto.getNum();
					}else{
						num=0;
					}
				}
				num=num+1;		
							
				HashMap map=new HashMap();
				map.put("num",num);
				map.put("id",id);
				map.put("menuname",order); 
				map.put("orderstatus",orderstatus);
				map.put("ordermoney",price);
				map.put("l_key",l_key);
				sqlMap.insert("order.insertMenuOrder", map);
				 
				//야매
				HashMap map7 = new HashMap();
				map7.put("name", order);
				map7.put("l_key", l_key);
				int ordermoney = (Integer)sqlMap.queryForObject("order.getOrderMoney", map7); // 메뉴가격 가져오는 것.
				int usermoney = (Integer)sqlMap .queryForObject("order.getUserMoney",id);
				int money = usermoney-ordermoney; // 사용자의 잔액에서 메뉴의 가격을 차감한다.
				
				HashMap map4 = new HashMap();
				map4.put("userId",id);
				map4.put("money",money);
				sqlMap.update("order.menuPayment", map4); //사용자 잔액에서 메뉴 금액 뺀 금액 update.
				
				check=1;
			}else{ // 주문한 메뉴의 재고가 없을 시.
				check=0;
				}
			}
			request.setAttribute("check", check);
			request.setAttribute("order",order);
			request.setAttribute("name",name);
			request.setAttribute("l_key", l_key);
			request.setAttribute("id",id);
			
		}catch(Exception e){
			e.printStackTrace(); 
			check=-1; request.setAttribute("check", check);
			request.setAttribute("name",name);
			request.setAttribute("l_key", l_key);
			request.setAttribute("id",id);
		}
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
		request.setAttribute("id",request.getParameter("id"));
		request.setAttribute("name",name);
		return "menu/userCategoryClick";
	}
	
	/* 카테고리 전체 메뉴 보여주기 (사용자) */
	@RequestMapping("userCategoryAll.do")
	public String userCategoryAll(HttpServletRequest request, String l_key, String name, String id){
		List menuList= sqlMap.queryForList("menu.getMenu",l_key);
		request.setAttribute("menuList", menuList);
		request.setAttribute("l_key",l_key);
		request.setAttribute("name",name);
		request.setAttribute("id",id);
		return "/menu/userCategoryAll";
	}
	
	/* 사용자 주문창에서 취소 창 */
	@RequestMapping("userOrderCancel.do")
	public String userOrderCancel(HttpServletRequest request, String id, String l_key, String name, String ordermoney){
		int check=0;
		String ordertime=request.getParameter("ordertime");
		try{			
			HashMap map = new HashMap();
			map.put("id",id);
			map.put("l_key",l_key);
			map.put("ordertime",ordertime);
			int status = (Integer)sqlMap.queryForObject("order.getUserOrder", map);
			String fcname=(String)sqlMap.queryForObject("order.getfranchiseeName", l_key);
			
			if(status==1){
				sqlMap.update("order.userOrderCancel", map);
		
				check=1;
			}else{
				check=0;
			}
			request.setAttribute("check", check);
			request.setAttribute("name",fcname);
			request.setAttribute("id",id);
		}catch(Exception e){e.printStackTrace(); check=-1; request.setAttribute("check",check); request.setAttribute("l_key", l_key);}
		return "/menu/userOrderCancel";
	}
	
	/* 사용자 주문승된 후 환불 요청 페이지 */
	@RequestMapping("userOrderRefund.do")
	public String userOrderRefund(HttpServletRequest request, String id, String l_key){
		int check=0;
		try{
			String ordertime=request.getParameter("ordertime");
			String fcname=(String)sqlMap.queryForObject("order.getfranchiseeName", l_key);
			HashMap map = new HashMap();
			map.put("ordertime", ordertime);
			map.put("id", id);
			map.put("l_key",l_key);
			int status=(Integer)sqlMap.queryForObject("order.getUserOrder", map);
			if(status==2){
				sqlMap.update("order.userOrderRefund",map);
				check=1;
			}else{
				check=0;
			}
			request.setAttribute("check", check);
			request.setAttribute("name",fcname);
			request.setAttribute("id",id);
		}catch(Exception e){e.printStackTrace(); check=-1; request.setAttribute("check", check);}
		return "menu/userOrderRefund";
	}

	
	////// 사장님 주문 //////
	
	@RequestMapping("menuOrderListForm.do")
	public String menuOrderListForm(String tf,HttpServletRequest request, HttpSession session, String l_key){
		try{
			//사이드메뉴 템플릿
			int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
			int sidemenu = 3; //사이드메뉴의 내용을 선택
			request.setAttribute("sidemenuCheck", sidemenuCheck);
			request.setAttribute("sidemenu", sidemenu);
			
			if(l_key == null){
				l_key=(String)session.getAttribute("b_key");
			}
			
			// 이건 전체
			List orderList = (List)sqlMap.queryForList("order.getMenuOrder", l_key);
			// 처리해야할 주문
			List canList = (List)sqlMap.queryForList("order.canOrder", l_key);
			// 처리된 주문
			List cantList = (List)sqlMap.queryForList("order.cantOrder",l_key);
			
			request.setAttribute("canList", canList);
			request.setAttribute("cantList", cantList);
			request.setAttribute("orderList", orderList);
			request.setAttribute("l_key",l_key);
			
		}catch(Exception e){e.printStackTrace();}
		
		if(tf == null){
			return "/menu/menuOrderListForm";
		}else{

			return "/menu/menuOrderTable";
		}
		

	}
	
	/* 주문승인버튼 누른 후 바코드 확인하기*/
	@RequestMapping("menuBarcodeCheck.do")
	public String menuBarcodeCheck(HttpServletRequest request,String menuname, int num, String l_key){
		
		//사이드메뉴 템플릿
		int sidemenuCheck = 1; //사이드메뉴 를 보여줄건지
		int sidemenu = 3; //사이드메뉴의 내용을 선택
		request.setAttribute("sidemenuCheck", sidemenuCheck);
		request.setAttribute("sidemenu", sidemenu);
		
		request.setAttribute("name",menuname);
		request.setAttribute("num",num);
		request.setAttribute("l_key",l_key);
		return "/menu/menuBarcodeCheck";
	}
	
	/* 바코드 확인하고 정상적인 주문일 때 완료 페이지*/
	@RequestMapping("menuOrderComplete.do")
	public String menuOrderComplete(HttpServletRequest request, String barcode, int num, String name, String l_key){
		int check;
		try{
			HashMap map=new HashMap();
			map.put("barcode", barcode);
			map.put("name",name);
			map.put("l_key",l_key);
			// 해당 바코드를 가지고 있는 메뉴의 판매유무를 확인.
			ProductDTO pdto=(ProductDTO)sqlMap.queryForObject("order.salecheckCheck", map);
			
			if(pdto==null){ // 판매되어서 salecheck 가 0 일 때.
				check=0;
			}else{			
				// 주문자 아이디 가져오기
				HashMap map3 = new HashMap();
				map3.put("num",num);
				map3.put("l_key",l_key);
				map3.put("name",name);
				String userId=(String)sqlMap.queryForObject("order.getOrderUserId",map3);
			
				/* 주문 승인시 사용자 잔액 처리
				HashMap map7 = new HashMap();
				map7.put("name", name);
				map7.put("l_key", l_key);
				int ordermoney = (Integer)sqlMap.queryForObject("order.getOrderMoney", map7); // 메뉴가격 가져오는 것.
				int usermoney = (Integer)sqlMap .queryForObject("order.getUserMoney",userId);
				int money = usermoney-ordermoney; // 사용자의 잔액에서 메뉴의 가격을 차감한다.
				
				HashMap map4 = new HashMap();
				map4.put("userId",userId);
				map4.put("money",money);
				sqlMap.update("order.menuPayment", map4); //사용자 잔액에서 메뉴 금액 뺀 금액 update.
				*/
				
				HashMap map1=new HashMap();
				map1.put("num",num);
				map1.put("l_key",l_key);
				map1.put("id", userId);
				map1.put("barcode", barcode);
				sqlMap.update("order.updateStatus",map1); // 주문현황 주문중 --> 주문완료 and menuOrder에 사용자가주문한 상품 바코드 입력
				
				HashMap map2=new HashMap();
				map2.put("name", name);
				map2.put("barcode", barcode);
				map2.put("l_key", l_key);
				sqlMap.update("order.updateSaleCheck",map2); // 재고 판매여부 1 --> 0
				
				// sellBuyLog 판매시간 입력 / sellBuyLog 금액 입력. /주문한 사용자 아이디도 집어넣기!
				HashMap map5 = new HashMap();
				map5.put("name",name);
				map5.put("l_key",l_key);
				int price = (Integer)sqlMap.queryForObject("order.getMenuPrice", map5);
				
				HashMap map6 = new HashMap();
				map6.put("price", price);
				map6.put("userId", userId);
				map6.put("name", name);
				map6.put("barcode", barcode);
				map6.put("l_key", l_key);
				
				sqlMap.update("order.productsaleregistdate", map6);
							
				//여기서부터는 정산
				
				Date nowtime=new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String nowTime = sdf.format(nowtime);
								
				HashMap tmp1=new HashMap();
				tmp1.put("menuname", name);
				tmp1.put("menuprice",price);
				tmp1.put("l_key", l_key);
				
				HashMap tmp2=new HashMap();
				tmp2.put("menuname",name);
				tmp2.put("l_key", l_key);
				tmp2.put("saledate", nowTime);
				
				int sellbuylogcheck=(Integer)sqlMap.queryForObject("order.sellBuyLogCheck",l_key);
				if(sellbuylogcheck==0){ // TotalMenuPrice 처음 등록. (각 가맹점마다 한번만 실행됨.)
				
					sqlMap.insert("order.firstTMPinsert", tmp1);
				}else{ // TotalMenuPrice에 값이 있는 경우
					TotalMenuPriceDTO todaymenuname = (TotalMenuPriceDTO)sqlMap.queryForObject("order.tmpMenuCheck",tmp2);
					if(todaymenuname!=null){
						int menucount = todaymenuname.getMenucount()+1;
						int mprice = todaymenuname.getMenuprice();
						int totalprice=todaymenuname.getTotalprice()+mprice;
						HashMap countup = new HashMap();
						countup.put("menucount",menucount);
						countup.put("totalprice",totalprice);
						countup.put("saledate",todaymenuname.getSaledate());
						countup.put("menuname",todaymenuname.getMenuname());
						countup.put("l_key",l_key);
						
						sqlMap.update("order.updateTotalmenuCount", countup);
						
						
					}else{	 // 날짜가 바뀐 경우.
						sqlMap.insert("order.firstTMPinsert", tmp1);
					}
				}	
				check=1;
			}
			request.setAttribute("check",check);
			request.setAttribute("l_key", l_key);
			request.setAttribute("name",name);
		}catch(Exception e){e.printStackTrace(); check=-1; request.setAttribute("check",check);}
		return "/menu/menuOrderComplete";
	}	
	
	/* 사용자가 환불요청시 환불 요청 승인 해주는 페이지 */
	@RequestMapping("menuOrderRefund.do")
	public String menuOrderRefund(HttpServletRequest request,OrderDTO odto, String l_key){
		int check=0;
		int orderstatus=odto.getOrderstatus();
		try{
			if(orderstatus==4){
				
				// 정산부분 .

				Date nowtime=new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String nowTime = sdf.format(nowtime);
				
				HashMap map1 = new HashMap();
				map1.put("menuname",odto.getMenuname());
				map1.put("code",odto.getCode());
				map1.put("id",odto.getId());
				map1.put("l_key",odto.getL_key());
				SellBuyLogDTO sbldto =(SellBuyLogDTO)sqlMap.queryForObject("order.getSellBuyLog", map1);
				
				HashMap map2=new HashMap();
				map2.put("menuname",odto.getMenuname());
				map2.put("saledate", sbldto.getProductsaleregistdate());
				map2.put("l_key", odto.getL_key());				
				TotalMenuPriceDTO tmpdto = (TotalMenuPriceDTO)sqlMap.queryForObject("order.tmpMenuCheck",map2);
				if(tmpdto.getMenucount()==1){
					sqlMap.delete("order.deleteTotalMenu",map2);
				}else{
					int menucount = tmpdto.getMenucount()-1;
					int mprice = tmpdto.getMenuprice();
					int totalprice=tmpdto.getTotalprice()-mprice;
					
					HashMap map3=new HashMap();
					map3.put("menucount",menucount);
					map3.put("totalprice", totalprice);
					map3.put("menuname",odto.getMenuname());
					map3.put("saledate", sbldto.getProductsaleregistdate());
					map3.put("l_key", odto.getL_key());	
					sqlMap.update("order.updateTotalMenu",map3);
				}
					sqlMap.update("order.refundStatus", odto); //status 값을 5로 바꿔주는데 사용.
					sqlMap.update("order.refundResetproductsaleregistdate",odto); //sellBuyLog의 판매시간 0000-00-00으로 초기화.
					sqlMap.update("order.refundProduct", odto);
								
				// 사용자에게 돈 돌려주기
				
				int usermoney=(Integer)sqlMap.queryForObject("order.getUserMoney", odto.getId());
				int ordermoney=odto.getOrdermoney();
				
				int menuordermoney=usermoney+ordermoney;
					
					HashMap param = new HashMap();
				param.put("id", odto.getId());
				param.put("ordermoney", menuordermoney);
				
				sqlMap.update("order.cancelMenuOrder", param);
				
				
				
				
				
				check=1;
				
		
				
			}else{check=0; }
			request.setAttribute("check",check);
			request.setAttribute("l_key", odto.getL_key());
			
		}catch(Exception e){e.printStackTrace(); check=-1; request.setAttribute("check",check); request.setAttribute("l_key",l_key);}
		return "/menu/menuOrderRefund";
	}
	

	/* 사용자가 환불요청시 환불 요청 거절하는 페이지 */
	@RequestMapping("menuOrderNotRefund.do")
	public String menuOrderNotRefund(HttpServletRequest request, OrderDTO odto){
		int check=0;
		int orderstatus=odto.getOrderstatus();
		try{
			if(orderstatus==4){
			sqlMap.update("order.notRefundStatus", odto);
			check=1;
			}else{check=0;}
			request.setAttribute("check", check);
			request.setAttribute("l_key", odto.getL_key());
			
		}catch(Exception e){e.printStackTrace(); check=-1; request.setAttribute("check", check);}
		return "/menu/menuOrderNotRefund";
	}
	
}
