package superclass.all.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ReadDbWriteArray {

	@Autowired
	private	SqlMapClientTemplate sqlMap;
	
	public  void readDb(Object dto, String fileName){
		
		
		
	} 
	
}
