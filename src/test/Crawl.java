package test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.ui.Model;
public class Crawl{
	
    public static void main(String[] args)  throws Exception{
        String URL = "http://www.inven.co.kr/webzine/";
        Document doc = Jsoup.connect(URL).get();
        Elements elem = doc.select("li span.bullet a");
        String str = elem.text();
        
        Crawl c = new Crawl();
        c.subtitution(str); //문자열 치환하여 그날의 log.txt에 저장
        
        String[] items = str.split(", ");
        List<String> list = Arrays.asList(items);
       
        model.addAttribute("list", list);
        
    }
    

    public void subtitution(String str){
    	 Pattern pattern = Pattern.compile(", ", Pattern.CASE_INSENSITIVE); // 대소문자 구분 안함 
         Matcher matcher = pattern.matcher(str);

         StringBuffer replacedString = new StringBuffer();
         while(matcher.find()){
         	//찾을대상 치환
         	matcher.appendReplacement(replacedString, "\n");
         }
         //검색에 마지막으로 찾는 부분 이후의 검색 대상 문자열을 결합
         matcher.appendTail(replacedString);
         
         String strResult = replacedString.toString();
         //치환결과 값은 Log.txt 로 저장.
         System.out.println("strResult :" +strResult);
    }


}