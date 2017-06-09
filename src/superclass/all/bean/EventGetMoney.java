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
		
		try{
		//관리자가 가상계좌로 접속한사용자에게 돈을 지불해줍니다.	
		sqlMap.insert("cash.eventAdminGiveUserMoneyLog", map1);
		//거래 계좌에 로그를 남겨줍니다. 로그가 남지않으면 입금도 되지 않습니다.
		sqlMap.update("cash.eventAdminGiveUserMoney", map1); //회원계좌에 입금해줍니다.
		check = 1;//성공했을때 변수
	}catch(Exception e){
		e.printStackTrace();
		check = 0;//실패했을때 변수
		System.out.println(e);
	}
		
		return check;
	}
}
