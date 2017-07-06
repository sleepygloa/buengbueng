package menu.all.bean;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class TotalPriceBean {

	@Autowired
	private SqlMapClientTemplate sqlMap; 
	
	@RequestMapping("menuTodayTotalPrice.do")
	public String menuTodayTotalPrice(HttpSession session,HttpServletRequest request){
		int check=0;
		try{
			String l_key=(String)session.getAttribute("b_key");
			int sumprice=0;
			List totalMenuAccount=null;
			Calendar day = Calendar.getInstance();
	        day.add(Calendar.DATE , -1);
	       String yesterday = new java.text.SimpleDateFormat("yyyy-MM-dd").format(day.getTime());
	       
	       // 메뉴명 가지고오기 
	       HashMap map = new HashMap();
	       map.put("yesterday",yesterday);
	       map.put("l_key", l_key);
	       List menuNameList=(List)sqlMap.queryForList("menu.getTodayMenu", map);
	       
	       //메뉴명이 있을경우 
	       if(menuNameList!=null){
	    	   for(int i=0; i<menuNameList.size();i++){
	    		   String menuname=(String)menuNameList.get(i);
	
	    		   HashMap map1=new HashMap();
	    		   map1.put("menuname",menuname);
	    		   map1.put("l_key",l_key);
	    		   map1.put("yesterday", yesterday);
	    		   int count=(Integer)sqlMap.queryForObject("menu.getMenuCount",map1); //메뉴명에맞는 수량구하기.
	    		   
	    		   HashMap map2=new HashMap();
	    		   map2.put("l_key", l_key);
	    		   map2.put("menuname", menuname);
	    		   int price =(Integer)sqlMap.queryForObject("menu.getMenuPrice", map2); 
	    		   
	    		   int totalprice=price*count;
	    		   	    		   
	    		   HashMap map3 = new HashMap();
	    		   map3.put("menuname", menuname);
	    		   map3.put("menuprice", price);
	    		   map3.put("menucount",count);
	    		   map3.put("saledate", yesterday);
	    		   map3.put("totalprice", totalprice);
	    		   map3.put("l_key",l_key);
	    		   
	    		   sqlMap.insert("menu.menuTotalPriceInsert",map3);
	    		   check=1;
	    		   
	    		   HashMap last = new HashMap();
	    		   
	    	       last.put("l_key",l_key);
	    	       last.put("yesterday", yesterday);
	    	       totalMenuAccount = (List)sqlMap.queryForList("menu.getTotalMenuPrice",last);
	    	       
	    		   
	    	       List todaytotalprice =(List)sqlMap.queryForList("menu.gettodaytotalprice", map3);
	    	       for(int j=0; j<todaytotalprice.size();j++){
	    	    	   int ttp=(int) todaytotalprice.get(j);
	    	    	   sumprice += ttp;
	    	       }
	    	   }
	       }else{
	    	   check=0;
	       }
	
	       request.setAttribute("menuTotalAccount", totalMenuAccount);
	       request.setAttribute("check",check);
	       request.setAttribute("sumprice", sumprice);
			System.out.println(check);
		}catch(Exception e){
			e.printStackTrace();
			check=-1; request.setAttribute("check", check);
		}
		
		return "/menu/menuTodayTotalPrice";
	}

}
