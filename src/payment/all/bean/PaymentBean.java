package payment.all.bean;



import java.io.PrintStream;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import login.user.bean.UserInfoDataDTO;



@Controller
@RequestMapping("/userbilling/*")
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
	public String cashHistory(String pageNum,HttpServletRequest request, HttpSession session)throws Exception{
		String id = (String)session.getAttribute("loginId");
		request.setCharacterEncoding("UTF-8");
		
		HashMap map = new HashMap();
    	map.put("id", id);
    	map.put("confirmation", "Accept");
    	map.put("confirmation_f", "failure");
		List payment = (List)sqlMap.queryForList("cash.cash_id", map);
		int failure = (int) sqlMap.queryForObject("cash.cash_failureCount", map);
		
		
		
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
        int listcount = count - failure;
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
        number = listcount - (currentPage - 1) * pageSize;
        
	     System.out.println("number" + number);
		request.setAttribute("articleList", articleList);
        request.setAttribute("currentPage", new Integer(currentPage));
        request.setAttribute("startRow", new Integer(startRow));
        request.setAttribute("endRow", new Integer(endRow));
        request.setAttribute("count", new Integer(count));
        request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		
		
		
		System.out.println("실패 횟수" + failure);
		UserAccountDTO c = (UserAccountDTO)sqlMap.queryForObject("cash.cash_userAccount", id);
		request.setAttribute("listcount", listcount);
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
		String pg_tid = request.getParameter("pg_tid");
		String card_code = request.getParameter("card_code");
		
		UserInfoDataDTO c = (UserInfoDataDTO)sqlMap.queryForObject("cash.cash_payment_useInfoLoad", id);
		
		//view에서 사용할 것
		request.setAttribute("card_code", card_code);
		request.setAttribute("c", c);		
		request.setAttribute("cardtype", cardtype);
		request.setAttribute("error_msg", error_msg);
		request.setAttribute("pg_tid", pg_tid);
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
		String pg_tid = request.getParameter("pg_tid");
		System.out.println("pg_tid = s	" + pg_tid);
		//API 부가적인 정보
		String card_code = request.getParameter("card_code");
		System.out.println("card_code =" + card_code);
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
	
	//사용자 내역
	@RequestMapping("/usageHistory.do")
	public String usageHistory(String pageNum, HttpServletRequest request, HttpSession session)throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		String id = (String)session.getAttribute("loginId");
		System.out.println("id = " + id);
		List usageHistory = (List)sqlMap.queryForList("cash.usageHistory", id);

		System.out.println("usageHistory =" + usageHistory);
		request.setAttribute("usageHistory", usageHistory);
		
		if (pageNum == null) {
            pageNum = "1";
        }
        int pageSize = 10;
        int currentPage = Integer.parseInt(pageNum);
        int startRow = (currentPage - 1) * pageSize + 1;
        int endRow = currentPage * pageSize;
        int count = 0;
        int number= 0;
	
        List articleList = null;
        
        count = (Integer)sqlMap.queryForObject("cash.usageHistoryCount", id);
        int listcount = count;
        if(count > 0){
        	HashMap r = new HashMap<>();
     	    r.put("startRow", startRow);
     	    r.put("endRow", endRow);
     	    r.put("id", id);
     	    articleList = sqlMap.queryForList("cash.getUsageHistory", r);
     	   
        } else {
        	articleList = Collections.EMPTY_LIST;
        }
        
        
        
        number = count - (currentPage - 1) * pageSize;
        
		request.setAttribute("articleList", articleList);
        request.setAttribute("currentPage", new Integer(currentPage));
        request.setAttribute("startRow", new Integer(startRow));
        request.setAttribute("endRow", new Integer(endRow));
        request.setAttribute("count", new Integer(count));
        request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		
		return "/userbilling/usageHistory";
	}
	
	@RequestMapping("/usageHistoryPro.do")
	public String usageHistoryPro()throws Exception{
		
		
		return "/userbilling/usageHistoryPro";
	}
	
	@RequestMapping("/dailySettlementLoad.do")
	public String dailySettlementLoad(String pageNum, HttpServletRequest request,HttpSession session)throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		String id = (String)session.getAttribute("loginId");
		
		/*게시판*/
		if (pageNum == null) {
            pageNum = "1";
        }
        int pageSize = 10;
        int currentPage = Integer.parseInt(pageNum);
        int startRow = (currentPage - 1) * pageSize + 1;
        int endRow = currentPage * pageSize;
        int count = 0;
        int number= 0;
	
        List articleList = null;
        
       
        
        List affiliateCodeList = sqlMap.queryForList("cash.getB-keyList", id);
        ArrayList acList = new ArrayList();
       System.out.println("11111111111" + affiliateCodeList);
       	request.setAttribute("affiliateCodeList", affiliateCodeList);
  

		/**/
		
	
		return "/userbilling/dailySettlementLoad";
	}
	
	
	
	@RequestMapping("/dailySettlement.do")
	public String dailySettlement (String pageNum, HttpSession session, HttpServletRequest request)throws Exception{
		String id = (String)session.getAttribute("loginId");
		//가맹코드 
		String affiliateCodeList = request.getParameter("affiliateCodeList");
		request.setAttribute("affiliateCode", affiliateCodeList);
		
		/***********************************************************************************************/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat end = new SimpleDateFormat("yyyy-MM-dd 23:59:59");

        Calendar c1 = Calendar.getInstance();

        String Today = sdf.format(c1.getTime());
        request.setAttribute("Today", Today);
        String TodayEndTime = end.format(c1.getTime());
        request.setAttribute("TodayEndTime", TodayEndTime);
        System.out.println("TodayEndTime" + TodayEndTime);

		Calendar day = Calendar.getInstance();
        day.add(Calendar.DATE , -1);
        
        //현재 오늘일 기준으로 어제 시작 일 00:00:00  코드
    	String startDate = new java.text.SimpleDateFormat("yyyy-MM-dd 00:00:00").format(day.getTime());
    	//현재 오늘일 기준으로 어제 종료 일 23:59:59  코드
    	String endDate = new java.text.SimpleDateFormat("yyyy-MM-dd 23:59:59").format(day.getTime());
    	
    	/***********************************************************************************************/
    	
    	
		/*가맹주 기본정보  *********************************************************************/
    	
    	HashMap time = new HashMap<>();
		time.put("startDate", startDate);
		time.put("endDate", endDate);
		time.put("affiliateCode", affiliateCodeList);
		
		//일일정산시 총 합계금액 계산
		
		String dailyAmount = (String) sqlMap.queryForObject("cash.dailyAmount", time);
		request.setAttribute("dailyAmount", dailyAmount);
		
		String dailyPureAmount = (String) sqlMap.queryForObject("cash.dailyPureAmount", time);
		request.setAttribute("dailyPureAmount", dailyPureAmount);
		
		
		
		int dailyCount = 0;
		dailyCount = (Integer) sqlMap.queryForObject("cash.dailyCount", time);
		System.out.println("dailyCount" + dailyCount);
		/*내역 리스트 *********************************************************************/
		if (pageNum == null) {
            pageNum = "1";
        }
        int pageSize = 5;
        int currentPage = Integer.parseInt(pageNum);
        int startRow = (currentPage - 1) * pageSize + 1;
        int endRow = currentPage * pageSize;
        int count = 0;
        int number= 0;
        
        count = (Integer)sqlMap.queryForObject("cash.B_keyValidity", affiliateCodeList);
        System.out.println("가맹점에서 이용한 사용한 내역 카운트 =" + count);
        List articleList = null;
        
        
        
        if(count > 0){
        	HashMap r = new HashMap<>();
        	
    		r.put("startDate", startDate);
        	r.put("endDate", endDate);
     	    r.put("startRow", startRow);
     	    r.put("endRow", endRow);
     	    //가맹점 코드
     	    r.put("affiliateCodeList", affiliateCodeList);
     	   
     	    articleList = sqlMap.queryForList("cash.SelectedList", r);
     	    
        } else {
        	articleList = Collections.EMPTY_LIST;
        }
        
        number = count - (currentPage - 1) * pageSize;
        /**************************************************************************************************/
        HashMap checkValue = new HashMap<>();
        checkValue.put("settlementDate", TodayEndTime);
        checkValue.put("b_key", affiliateCodeList);
        int check =  (int) sqlMap.queryForObject("cash.checkValue", checkValue);
        System.out.println("check" + check);
        int checkPoint = 0;
		if(check < 1){ //  check 0 일결우 삽입
			checkPoint = 1;
		}else if(check == 1){ //  check 0이 아닐 경우에 블럭
			checkPoint = 2;
		}
		
		request.setAttribute("checkPoint", checkPoint);
		System.out.println("checkPoint" + checkPoint);
		
        /*view에서 사용할 코드****************************************************************************/
		//게시판
		
        request.setAttribute("articleList", articleList);
        request.setAttribute("currentPage", new Integer(currentPage));
        request.setAttribute("startRow", new Integer(startRow));
        request.setAttribute("endRow", new Integer(endRow));
        request.setAttribute("count", new Integer(count));
        request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		
		//가맹주 기본 정보
		request.setAttribute("id", id);
		request.setAttribute("affiliateCodeList", affiliateCodeList);
		request.setAttribute("dailyCount", dailyCount);
		/****************************************************************************************************/
		/*
		String sCurTime = null;
		String sMinTime = "20170623155200";
		String sMaxTime = "20170623155300";
		String sTime = "";
		    
		sCurTime = new java.text.SimpleDateFormat("yyyyMMddHHmmss", java.util.Locale.KOREA).format(new java.util.Date());
		    
		if (sCurTime.compareTo(sMinTime) >= 0 && sCurTime.compareTo(sMaxTime) < 0) {
		        
		}
		*/
		
		
		return "/userbilling/dailySettlement";
	}
	@RequestMapping("/dailySettlementPro.do")
	public String dailySettlementPro(DailySettlementDTO dto, HttpSession session, HttpServletRequest request){
		
		String id = (String)session.getAttribute("loginId");
		String affiliateCodeList = request.getParameter("affiliateCodeList");
		System.out.println("affiliateCodeList"+ affiliateCodeList);
    	
		//String settlementDate = (String) sqlMap.queryForObject("cash.settlementDate", id);

		
		/*
		int resultValue = 0;
		resultValue = sqlMap.queryForObject("cash.resultValueCount", result);
		*/
		sqlMap.insert("cash.dailySettlement", dto);
		
		 
		
		return "/userbilling/dailySettlementPro";
	}
	
	@RequestMapping("/request.do")
	public String request(String pageNum, HttpServletRequest request){
		
		int check = 2;
		
		List accept = sqlMap.queryForList("cash.accept", check);
		
		System.out.println("accept = " + accept);
		
		/*내역 리스트 *********************************************************************/
		if (pageNum == null) {
            pageNum = "1";
        }
        int pageSize = 5;
        int currentPage = Integer.parseInt(pageNum);
        int startRow = (currentPage - 1) * pageSize + 1;
        int endRow = currentPage * pageSize;
        int count = 0;
        int number= 0;
        
        count = (Integer)sqlMap.queryForObject("cash.acceptCount", check);
        System.out.println("가맹점에서 이용한 사용한 내역 카운트 =" + count);
        List articleList = null;
        
        
        
        if(count > 0){
        	HashMap r = new HashMap<>();
     	    r.put("startRow", startRow);
     	    r.put("endRow", endRow);
     	    r.put("check", check);
     	   
     	    articleList = sqlMap.queryForList("cash.accept", r);
     	    
        } else {
        	articleList = Collections.EMPTY_LIST;
        }
        
        number = count - (currentPage - 1) * pageSize;
        /**************************************************************************************************/
        request.setAttribute("articleList", articleList);
        request.setAttribute("currentPage", new Integer(currentPage));
        request.setAttribute("startRow", new Integer(startRow));
        request.setAttribute("endRow", new Integer(endRow));
        request.setAttribute("count", new Integer(count));
        request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		
		return "/userbilling/request";
	}
	
	@RequestMapping("/requestPro.do")
	public String requestPro(HttpServletRequest request){
		//String chbox = request.getParameter("chbox");
		String[] chbox = request.getParameterValues("chbox") ;
		System.out.println("방의 길이" + chbox.length);

		ArrayList<String> arrayList = new ArrayList<>();
		for(String temp : chbox){
		  arrayList.add(temp);
		}		
		
		System.out.println("방의 값" + arrayList);
		
		
		for(int i=0; i<chbox.length; i++){
			HashMap idx = new HashMap<>();
			idx.put("idx", chbox[i]);
			 sqlMap.update("cash.approval", idx);
		}
		
		return "/userbilling/requestPro";
	}
}
