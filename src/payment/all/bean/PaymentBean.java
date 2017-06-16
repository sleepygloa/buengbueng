package payment.all.bean;



import java.sql.Timestamp;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import login.user.bean.UserInfoDataDTO;



@Controller
public class PaymentBean {
	
	private static final Object Accept = null;
	@Autowired
	private SqlMapClientTemplate sqlMap;

	@RequestMapping("/cash.do")
	public String cash(HttpServletRequest request, HttpSession session, UserAccountDTO infodto)throws Exception{
		String id = (String)session.getAttribute("loginId"); // session Id
		request.setCharacterEncoding("UTF-8");// 한글 인코딩
		
		//session과 일치하는 회원 정보 로드
		UserAccountDTO info = (UserAccountDTO)sqlMap.queryForObject("cash.cash_userAccount", id);
		
		//view에서 사용할 것
		request.setAttribute("info", info);
		request.setAttribute("id", id);
		
		return "/userbilling/cash";
	}
	
	@RequestMapping("/cashPro.do")
	public String cashPro(HttpServletRequest request, UserBillingHistoryDTO dto, HttpSession session, UserAccountDTO info)throws Exception{
		String id = (String)session.getAttribute("loginId");
		request.setCharacterEncoding("UTF-8");
		String pay = request.getParameter("pay"); //???
		String paying_price = request.getParameter("paying_price"); // 결제후 금액
		String payment_type = request.getParameter("payment_type"); // 결제수단
		String cash = request.getParameter("cash"); // 충전 금액
		System.out.println("충전 금액"+cash);
	
		//회원 저장
		dto.setBuyer_chatid(id);
		dto.setPaying_price(Integer.parseInt(paying_price));		
		UserAccountDTO info1 = (UserAccountDTO)sqlMap.queryForObject("cash.cash_userAccount", id);
		
		//회원이 충전한 캐시 누적 (Update)
		
		HashMap map = new HashMap();
    	map.put("id", id);
    	map.put("paying_price", paying_price);
		sqlMap.update("cash.cash_stack", map);
		System.out.println("캐시 스텍" + paying_price);
		System.out.println("캐시 스텍" + id);
		//view에서 사용할 것
		request.setAttribute("info1", info1);
		request.setAttribute("cash", cash);
		request.setAttribute("pay", pay);
		request.setAttribute("id", id);
		request.setAttribute("paying_price", dto.getPaying_price());
		request.setAttribute("payment_type", dto.getPayment_type());
		
		//System.out.println("회원 보유 포인트" + info1.getCash());
		System.out.println("충전 금액"+cash);
		System.out.println("결제 후 금액" + dto.getPaying_price());
		System.out.println("결제수단" + dto.getPayment_type());
		return "/userbilling/cashPro";
	}
	
	
	
	@RequestMapping("/ledger.do")
	public String ledger(HttpServletRequest request, UserBillingHistoryDTO dto){
		
		List payment = (List)sqlMap.queryForList("cash.cash_area", dto);
		
		//view에서 사용할 것
		request.setAttribute("payment", payment);
		
		System.out.println(payment);
		
		return "/userbilling/ledger";
	}
	
	@RequestMapping("/cashHistory.do")
	public String cashHistory(String pageNum,HttpServletRequest request, UserBillingHistoryDTO dto, UserAccountDTO accountDTO, HttpSession session)throws Exception{
		String id = (String)session.getAttribute("loginId");
		request.setCharacterEncoding("UTF-8");
		
        if (pageNum == null) {
            pageNum = "1";
        }
        int pageSize = 4;
        int currentPage = Integer.parseInt(pageNum);
        int startRow = (currentPage - 1) * pageSize + 1;
        int endRow = currentPage * pageSize;
        int count = 0;
        int number= 0;
	
        List articleList = null;
       System.out.println("아이디" + id);
        
        count = (Integer)sqlMap.queryForObject("cash.cashCount", id);
 
        if(count > 0){
        	HashMap r = new HashMap<>();
     	    r.put("startRow", startRow);
     	    r.put("endRow", endRow);
     	    r.put("id", id);
     	    r.put("confirmation", "Accept");
     	    articleList = sqlMap.queryForList("cash.getArticles", r);
        } else {
        	articleList = Collections.EMPTY_LIST;
        }
        System.out.println(startRow);
        System.out.println(endRow);
        number = count - (currentPage - 1) * pageSize;
        
	     System.out.println("number" + number);
		request.setAttribute("articleList", articleList);
        request.setAttribute("currentPage", new Integer(currentPage));
        request.setAttribute("startRow", new Integer(startRow));
        request.setAttribute("endRow", new Integer(endRow));
        request.setAttribute("count", new Integer(count));
        request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		
		HashMap map = new HashMap();
    	map.put("id", id);
    	map.put("confirmation", "Accept");
    	map.put("confirmation_f", "failure");
		List payment = (List)sqlMap.queryForList("cash.cash_id", map);
		int failure = (int) sqlMap.queryForObject("cash.cash_failureCount", map);
		System.out.println("실패 횟수" + failure);
		UserAccountDTO c = (UserAccountDTO)sqlMap.queryForObject("cash.cash_userAccount", id);
		
		request.setAttribute("failure_count", failure);
		request.setAttribute("c", c);
		request.setAttribute("payment", payment);
		
		request.setAttribute("id", id);
		//System.out.println(getUse_area);
		//System.out.println(dto.getUse_area());
		
		return "/userbilling/cashHistory";		
	}
	
	@RequestMapping("/payment.do")
	public String payment(HttpServletRequest request, HttpSession session, UserInfoDataDTO userinfoDTO, Model model)throws Exception{
		request.setCharacterEncoding("UTF-8");
		String pay = request.getParameter("pay");
		String cardtype = request.getParameter("cardtype");
		String payment_type = request.getParameter("payment_type");
		String buyer_chatid = request.getParameter("buyer_chatid");
		String confirmation = request.getParameter("confirmation");
		String paying_name = request.getParameter("paying_name");
		String id = (String)session.getAttribute("loginId"); 
		Timestamp payment_date = new Timestamp(System.currentTimeMillis());	
		String error_msg = request.getParameter("error_msg");
		
		UserInfoDataDTO c = (UserInfoDataDTO)sqlMap.queryForObject("cash.cash_payment_useInfoLoad", id);
		
		//view에서 사용할 것
		request.setAttribute("c", c);		
		request.setAttribute("cardtype", cardtype);
		request.setAttribute("error_msg", error_msg);
		request.setAttribute("id", id);
		request.setAttribute("pay", pay);
		request.setAttribute("payment_type", payment_type);
		request.setAttribute("buyer_chatid", buyer_chatid);
		request.setAttribute("confirmation", confirmation);
		request.setAttribute("paying_name", paying_name);
		request.setAttribute("payment_date", payment_date);
		
		return "/userbilling/payment";	
	}
	
	@RequestMapping("/paymentPro.do")
	public String paymentPro(HttpServletRequest request, UserBillingHistoryDTO dto, HttpSession session, UserAccountDTO accountDTO)throws Exception{
		String id = (String)session.getAttribute("loginId"); // session Id
		request.setCharacterEncoding("UTF-8");//한글 인코딩
		
		//결제페이지에서  받아오는 결제 정보를 데이터베이스에 저장 
		String error_msg = request.getParameter("error_msg");
		String confirmation = request.getParameter("confirmation");
		String paying_price = request.getParameter("pay");
		String payment_type = request.getParameter("cardtype");
		
		//API 부가적인 정보
		String merchant_uid = request.getParameter("merchant_uid");
		String imp_uid = request.getParameter("imp_uid");
		
		//session과 일치하는 회원정보 수집
		UserInfoDataDTO info1 = (UserInfoDataDTO)sqlMap.queryForObject("cash.cash_payment_useInfoLoad", id);
		UserAccountDTO account = (UserAccountDTO)sqlMap.queryForObject("cash.cash_userAccount", id);
		
		System.out.println("결제 완료 imp_uid" + imp_uid);
		System.out.println("결제 완료 confirmation" + confirmation);
		//API 부가적인 정보
		System.out.println("결제 완료 merchant_uid" + merchant_uid);
		
		//회원이 결제한 회원 결제 정보 insert
		sqlMap.insert("cash.cash_input", dto);
		
		//view에서 사용할 것
		request.setAttribute("account", account);
		request.setAttribute("info1", info1);
		request.setAttribute("imp_uid", imp_uid);
		request.setAttribute("merchant_uid", merchant_uid);
		request.setAttribute("paying_price", dto.getPaying_price());
		request.setAttribute("payment_type", dto.getPayment_type());

		
		return "userbilling/paymentPro";
	}
	//결제 취소Pro 페이지
	@RequestMapping("/cashCancelPro.do")
	public String cashCancelPro(HttpServletRequest request, UserBillingHistoryDTO dto, HttpSession session)throws Exception{
		String id = (String)session.getAttribute("loginId");
		request.setCharacterEncoding("UTF-8");
		
		String error_msg = request.getParameter("error_msg");
		//view에서 사용할 것
		request.setAttribute("error_msg", error_msg);
		
		//결제 취소 로그 삽입
		sqlMap.insert("cash.cash_input", dto);
		System.out.println("결제 취소 사유111" + dto.getError_msg());
		return "userbilling/cashCancelPro";
	}
	//
	@RequestMapping("/cashlist.do")
	public String cashlist(){
		
		return "/userbilling/cashlist";
	}
	//결제 취소 페이지
	@RequestMapping("/cashCancel.do")
	public String cashCancel(HttpServletRequest request, HttpSession session, UserBillingHistoryDTO dto)throws Exception{
		request.setCharacterEncoding("UTF-8");
		
		String id = (String)session.getAttribute("loginId");
		String error_msg = request.getParameter("error_msg");
		
		//view에서 사용할 것
		request.setAttribute("id", id);
		request.setAttribute("error_msg", error_msg);
		
		System.out.println("결제 취소 사유" + dto.getError_msg());
		
		return "/userbilling/cashCancel";
	}
}
