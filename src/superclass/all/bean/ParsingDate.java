package superclass.all.bean;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;

@Controller
public class ParsingDate {

	//Long 타입 날짜를 String(yyyy-MM-dd)로 변환
	public String longToStringDay(Long date){
		String obj = "";
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		obj = df.format(date);
		
		return obj;
	}
	
	//Long 타입 날짜를 String(yyyy-MM-dd hh:mm:ss)로 변환
	public String longToStringSec(Long date){
		String obj = "";
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		obj = df.format(date);
		
		return obj;
	}
	
	//String(yyyy-MM-dd)을 Long 타입 날짜로 변환
	public Long stringToLongDay(String date){
		Long obj = 0L;
		Date d = null;
		
		try{
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			d = df.parse(date);
			obj = d.getTime();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return obj;
	}
	
	//String(yyyy-MM-dd hh:mm:ss)을 Long 타입 날짜로 변환
	public Long stringToLongSec(String date){
		Long obj = 0L;
		Date d = null;
		
		try{
			DateFormat df  = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			d = df.parse(date);
			obj = d.getTime();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return obj;
	}
	
	//Long to Timestamp 
	public Timestamp longToTimestamp(Long date){
		Timestamp t = null;
		
		t = new Timestamp(date);
		return t;
	}
	
}
