package erp.boss.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import menu.all.bean.SellBuyLogDTO;
import menu.all.bean.TotalMenuPriceDTO;
import payment.all.bean.DailySettlementDTO;
import superclass.all.bean.SuperClass;


@Controller


public class BossEmployeeManageBean4 {
	
	@Autowired
	private SqlMapClientTemplate sqlMap;
	

	@Autowired
	protected SuperClass sc;

	
	@RequestMapping("/applyForSettlement.do")
	public String applyForSettlement (String pageNum, HttpSession session, HttpServletRequest request, Model model)throws Exception{
		String id = (String)session.getAttribute("loginId");
		String b_key = (String)session.getAttribute("b_key");
		
		String affiliateCodeList = b_key;
		System.out.println("affiliateCodeList" + affiliateCodeList);
		
		sc.sideMenuTemp(model, 1, 3); //sidemenu template
		
		/***********************************************************************************************/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat end = new SimpleDateFormat("yyyy-MM-dd 23:59:59");

        Calendar c1 = Calendar.getInstance();

        String Today = sdf.format(c1.getTime());
        String TodayEndTime = end.format(c1.getTime());
        
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
		String dailyAmount = (String) sqlMap.queryForObject("erpEmp.dailyAmount", time);
		System.out.println("dailyAmount" + dailyAmount);
		String dailyPureAmount = (String) sqlMap.queryForObject("erpEmp.dailyPureAmount", time);	
		System.out.println("dailyPureAmount" + dailyPureAmount);
		int dailyCount = 0;
		dailyCount = (Integer) sqlMap.queryForObject("erpEmp.dailyCount", time);
		System.out.println("dailyCount" + dailyCount);
		
		/*내역 리스트 *********************************************************************/
		
		if (pageNum == null) {
            pageNum = "1";
        }
        int pageSize = 40;
        int currentPage = Integer.parseInt(pageNum);
        int startRow = (currentPage - 1) * pageSize + 1;
        int endRow = currentPage * pageSize;
        int count = 0;
        int number= 0;
        
        count = (Integer)sqlMap.queryForObject("erpEmp.B_keyValidity", affiliateCodeList);
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
     	   
     	    articleList = sqlMap.queryForList("erpEmp.SelectedList", r);
     	    
        } else {
        	articleList = Collections.EMPTY_LIST;
        }
        
        number = count - (currentPage - 1) * pageSize;
        
        /**************************************************************************************************/
        
        /**정산신청 중복방지******************************************************************************************/
        
        HashMap checkValue = new HashMap<>();
        checkValue.put("settlementDate", TodayEndTime);
        checkValue.put("b_key", affiliateCodeList);
        int check =  (int) sqlMap.queryForObject("erpEmp.checkValue", checkValue);
        System.out.println("check" + check);
        int checkPoint = 0;
		if(check < 1){ //  check 0 일결우 삽입
			
			checkPoint = 1;
			System.out.println("checkPoint" + checkPoint);
		}else if(check >= 1){ //  check 0이 아닐 경우에 블럭
			checkPoint = 2;
		}
		
		/**************************************************************************************************/
		
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

		request.setAttribute("checkPoint", checkPoint);
		
		request.setAttribute("Today", Today);
	    request.setAttribute("TodayEndTime", TodayEndTime);
		
		request.setAttribute("dailyPureAmount", dailyPureAmount);
		request.setAttribute("dailyAmount", dailyAmount);
		
		//가맹코드
		request.setAttribute("affiliateCode", affiliateCodeList);
		
		return "/bossERP/dailySettlement/applyForSettlement";
	}
	
	
	//일일정산 데이터 받아 데이터 삽입 부분
	@RequestMapping("/applyForSettlementPro.do")
	public String applyForSettlementPro(DailySettlementDTO dto, HttpSession session, HttpServletRequest request){
		
		String id = (String)session.getAttribute("loginId");
		String affiliateCodeList = request.getParameter("affiliateCodeList");
		System.out.println("affiliateCodeList"+ affiliateCodeList);
    	
		//String settlementDate = (String) sqlMap.queryForObject("cash.settlementDate", id);

		
		/*
		int resultValue = 0;
		resultValue = sqlMap.queryForObject("cash.resultValueCount", result);
		*/
		sqlMap.insert("erpEmp.dailySettlement", dto);
		
		 
		
		return "/bossERP/dailySettlement/applyForSettlementPro";
	}
	
	//일일 정산 내역 
	@RequestMapping("/dailySettlementList.do")
	public String dailySettlementList(String pageNum, HttpSession session,Model model, HttpServletRequest request)throws Exception{
		String b_key = (String)session.getAttribute("b_key");
		System.out.println(b_key);
		
		sc.sideMenuTemp(model, 1, 3); //sidemenu template
		
		//내역 리스트
		if (pageNum == null) {
            pageNum = "1";
        }
        int pageSize = 40;
        int currentPage = Integer.parseInt(pageNum);
        int startRow = (currentPage - 1) * pageSize + 1;
        int endRow = currentPage * pageSize;
        int count = 0;
        int number= 0;
	
        List articleList = null;
               
        count = (Integer)sqlMap.queryForObject("erpEmp.dailySettlementCount", b_key);
        System.out.println("count" + count);
        
        if(count > 0){
        	HashMap r = new HashMap<>();
     	    r.put("startRow", startRow);
     	    r.put("endRow", endRow);
     	    r.put("b_key", b_key);
     	    articleList = sqlMap.queryForList("erpEmp.dailySettlementList", r);
     	    System.out.println("articleList" + articleList.size());
        } else {
        	articleList = Collections.EMPTY_LIST;
        }
        
     
        number = count - (currentPage - 1) * pageSize;
        
	    System.out.println("number" + number);
		request.setAttribute("articleList", articleList);
        request.setAttribute("currentPage", new Integer(currentPage));
        request.setAttribute("startRow", new Integer(startRow));
        request.setAttribute("endRow", new Integer(endRow));
        request.setAttribute("count", new Integer(count));
        request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
				
	
		return "/bossERP/dailySettlement/dailySettlementList";
	}
	@RequestMapping("/viewDetails.do")
	public String viewDetails(String pageNum, HttpSession session, HttpServletRequest request){
		String b_key = (String)session.getAttribute("b_key");
		String settlementDate = (String)request.getParameter("settlementDate");
		System.out.println("settlementDate" + settlementDate);
		
		Calendar day = Calendar.getInstance();
        day.add(Calendar.DATE , -1);
        
        //현재 오늘일 기준으로 어제 시작 일 00:00:00  코드
    	String startDate = new java.text.SimpleDateFormat("yyyy-MM-dd 00:00:00").format(day.getTime());
    	//현재 오늘일 기준으로 어제 종료 일 23:59:59  코드
    	String endDate = new java.text.SimpleDateFormat("yyyy-MM-dd 23:59:59").format(day.getTime());
    	
    	String yesterday=settlementDate.substring(0,10);  
		
		//내역 리스트
		if (pageNum == null) {
            pageNum = "1";
        }
        int pageSize = 4;
        int currentPage = Integer.parseInt(pageNum);
        int startRow = (currentPage - 1) * pageSize + 1;
        int endRow = currentPage * pageSize;
        int count = 0;
        int number= 0;
        int TotalMoney=0;
        
        HashMap time = new HashMap<>();
        time.put("yesterday",yesterday);
        time.put("b_key", b_key);
        List<TotalMenuPriceDTO> FranchiseeStatusList =(List)sqlMap.queryForList("erpEmp.menuOrderCount", time);
        System.out.println(FranchiseeStatusList);
        
        if(FranchiseeStatusList.equals(null)){
          	FranchiseeStatusList = Collections.EMPTY_LIST;
        }
        
        for(int i=0; i<FranchiseeStatusList.size();i++){
        	int money= FranchiseeStatusList.get(i).getTotalprice();
        	TotalMoney=TotalMoney+money;
        }
       
           
        number = count - (currentPage - 1) * pageSize;
        
	    System.out.println("number" + number);
		request.setAttribute("FranchiseeStatusList",FranchiseeStatusList);
		request.setAttribute("TotalMoney", TotalMoney);
        request.setAttribute("currentPage", new Integer(currentPage));
        request.setAttribute("startRow", new Integer(startRow));
        request.setAttribute("endRow", new Integer(endRow));
        request.setAttribute("count", new Integer(count));
        request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		
		
		return "/bossERP/dailySettlement/viewDetails";
	}
	
	
	@RequestMapping("/pcUseStatusList.do")
	public String pcUseStatusList(HttpSession session, Model model, String pageNum, HttpServletRequest request){
		String b_key = (String)session.getAttribute("b_key");
		System.out.println(b_key);
		

		sc.sideMenuTemp(model, 1, 3); //sidemenu template

		

		
		//내역 리스트
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
               
        count = (Integer)sqlMap.queryForObject("erpEmp.useStatusCount", b_key);
        System.out.println("count" + count);
        
        if(count > 0){
        	HashMap r = new HashMap<>();
     	    r.put("startRow", startRow);
     	    r.put("endRow", endRow);
     	    r.put("b_key", b_key);
     	    articleList = sqlMap.queryForList("erpEmp.useStatusList", r);
     	    System.out.println("articleList" + articleList.size());
        } else {
        	articleList = Collections.EMPTY_LIST;
        }
        
     
        number = count - (currentPage - 1) * pageSize;
        
	    System.out.println("number" + number);
		request.setAttribute("articleList", articleList);
        request.setAttribute("currentPage", new Integer(currentPage));
        request.setAttribute("startRow", new Integer(startRow));
        request.setAttribute("endRow", new Integer(endRow));
        request.setAttribute("count", new Integer(count));
        request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		
		
		return "/bossERP/pcUseStatus/pcUseStatusList";
	}
	
	@RequestMapping("/chart.do")
	public String chart(HttpSession session, HttpServletRequest request){
		String b_key = (String)session.getAttribute("b_key");
		System.out.println("key" + b_key);
		List chart = sqlMap.queryForList("erpEmp.chartData", b_key);
		System.out.println("chart"+ chart);
		request.setAttribute("chartList", chart);
		for(int i=0; i<chart.size(); i++){
			System.out.println("chartaaa"+ chart.get(i));
			request.setAttribute("chart", chart.get(i));
		}
		
		return "/bossERP/chart/chart";
	}
	
	@RequestMapping("userviewDetails.do")
	public String userviewDetails(String id,HttpSession session,String starttime, String endtime, HttpServletRequest request){
		try{
		String l_key=(String)session.getAttribute("b_key");
		ArrayList countList=new ArrayList();
		ArrayList priceList=new ArrayList();
		ArrayList totalpriceList=new ArrayList();
		ArrayList menunameList=new ArrayList();
		int total=0;
				
		String startTime=starttime.substring(0,10);
		String endTime=endtime.substring(0,10);
		
		
		
		HashMap map = new HashMap();
		map.put("id", id);
		map.put("l_key",l_key);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		List<SellBuyLogDTO> idMatchList = (List)sqlMap.queryForList("erpEmp.sellBuyLogIdMatch", map);
		
		if(idMatchList!=null){
			menunameList = (ArrayList)sqlMap.queryForList("erpEmp.getMenuname",map);
			for(int i=0; i<menunameList.size();i++){
				String name = (String)menunameList.get(i);
				
				HashMap map1=new HashMap();
				map1.put("l_key",l_key);
				map1.put("name", name);
				map1.put("id",id);
				map1.put("startTime",startTime);
				map1.put("endTime", endTime);
				int count =(Integer)sqlMap.queryForObject("erpEmp.getCountMenu",map1);
				System.out.println(count+"count");
				countList.add(count);
				int price=(Integer)sqlMap.queryForObject("erpEmp.getPriceMenu", map1);
				System.out.println(count+"count");
				priceList.add(price);
				int totalprice=price*count;
			
				totalpriceList.add(totalprice);				
			}
			//총합
			
			for(int i=0;i<totalpriceList.size();i++){
				total= total+(Integer)totalpriceList.get(i);
			}
		}else{
			idMatchList=Collections.EMPTY_LIST;
		}
		request.setAttribute("menunameList",menunameList);
		request.setAttribute("countList",countList);
		request.setAttribute("priceList",priceList);
		request.setAttribute("totalpriceList", totalpriceList);
		request.setAttribute("total", total);
		}catch(Exception e){ e.printStackTrace();}
		return "/bossERP/dailySettlement/userviewDetails";
	}
	
	

}
