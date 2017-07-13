package index.all.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import config.setting.init.NodeInit;
import test.Crawl;

@Controller
public class IndexBean {

	//sql을 연결 시켜주는 변수
	@Autowired
	private SqlMapClientTemplate sqlMap;
	
	
	//메인페이지로 보내주는 Do
	@RequestMapping("index.do")
	public String index(Model model){
		
		newsCrawler(model);
		
		return "index";
	}
	
	//크롤러
	public void newsCrawler(Model model) {
		
		try{
	        String URL = "http://www.inven.co.kr/webzine/";
	    	Document doc = Jsoup.connect(URL).get();
	        Elements elem = doc.select("li span.bullet a");
	        
	        String str = elem.text();
	        
	        IndexBean c = new IndexBean();
	        List newsList = c.subtitution(str); //문자열 치환하여 그날의 log.txt에 저장
	        
	        model.addAttribute("newsList", newsList);
		}catch(Exception e){e.printStackTrace();}
        
    }

    public List subtitution(String str){
    	 Pattern pattern = Pattern.compile(", ", Pattern.CASE_INSENSITIVE); // 대소문자 구분 안함 
         Matcher matcher = pattern.matcher(str);

         StringBuffer replacedString = new StringBuffer();
         
         StringTokenizer st = new StringTokenizer(str, ",");
         List list = new ArrayList();
         
         while(matcher.find()){
         	//찾을대상 치환
         	matcher.appendReplacement(replacedString, "<br />");
         }
         
         while(st.hasMoreElements()){
        	 NewsDTO ndto = new NewsDTO();
        	 ndto.setNewsList((String)st.nextElement());
        	 list.add(ndto);
        	 
        	 
         }
         
         //검색에 마지막으로 찾는 부분 이후의 검색 대상 문자열을 결합
         matcher.appendTail(replacedString);
         
         String strResult = replacedString.toString();
         //치환결과 값은 Log.txt 로 저장.
         
         return list;
    }
    
    //회사소개 페이지 이동
    @RequestMapping("intro.do")
    public String intro(){
    	
    	return "/intro/intro";
    }
    
    
    
}