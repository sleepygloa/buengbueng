package superclass.all.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;

@Controller
public class NowDate {
	//아이디 검사
	public static String nowDate(){

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
		String nowDate = sdf.format(date);
		
		
		return nowDate;
	}
}
