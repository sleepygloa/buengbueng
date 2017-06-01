package superclass.all.bean;

import java.net.InetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FindIpBean {

	
	//접속자의 Ip를 찾는 메서드
	public String findIp(){

		String connectIp = ""; //접속자 컴퓨터 이름
		
		try {           
			InetAddress ip = InetAddress.getLocalHost();  
			connectIp += ip.getHostName() + " " + ip.getHostAddress();
		}      
		catch (Exception e) {    
			e.printStackTrace();     
		} 
		
		return connectIp;
	}
	
}
