package superclass.all.bean;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class EventGetMoney {
	
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	public int eventGetMoney(HashMap map1){
		int check = -1;
		int check2 = -1;
		try{
		//이벤트 머니가 있을때만 이 클래스가 실행됩니다.
		System.out.println(map1.get("id"));
		//거래 계좌에 로그를 남겨줍니다. 로그가 남지않으면 입금도 되지 않습니다.
		sqlMap.insert("cash.eventAdminGiveUserMoneyLog", map1.get("id"));
	}catch(Exception e){
		e.printStackTrace();
		check = 0;
		System.out.println(e);
		System.out.println("이벤트 돈 지급 실패1");
	}
		System.out.println("이벤트 돈 지급 실패2");
		
		sqlMap.update("cash.eventAdminGiveUserMoney", map1); //회원계좌에 입금해줍니다.
		System.out.println("이벤트 돈 지급 성공3");
			check = 1;

		
		return check;
	}
}
