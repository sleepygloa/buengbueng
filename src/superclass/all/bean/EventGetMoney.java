package superclass.all.bean;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class EventGetMoney {
	
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	public int eventGetMoney(String id){
		int check = -1;
		int eventMoney = 1000; //이벤트 충전 머니
		System.out.println(id);
		HashMap map = new HashMap();
		map.put("id", id);
		map.put("eventMoney", eventMoney);
		
		try{
		//이벤트 머니가 있을때만 이 클래스가 실행됩니다.
//		System.out.println(map1.get("id"));
		sqlMap.insert("cash.eventAdminGiveUserMoneyLog", map);
		//거래 계좌에 로그를 남겨줍니다. 로그가 남지않으면 입금도 되지 않습니다.
	}catch(Exception e){
		e.printStackTrace();
		check = 0;
		System.out.println(e);
		System.out.println("이벤트 돈 지급 실패1");
	}
		System.out.println("이벤트 돈 지급 실패2");
		
		sqlMap.update("cash.eventAdminGiveUserMoney", map); //회원계좌에 입금해줍니다.
		System.out.println("이벤트 돈 지급 성공3");
			check = 1;
	
		return check;
	}
}
