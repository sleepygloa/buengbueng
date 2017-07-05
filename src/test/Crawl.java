package test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class Crawl{
    public static void main(String[] args) throws Exception{
        String URL = "http://www.inven.co.kr/webzine/";
        Document doc = Jsoup.connect(URL).get();
        Elements elem = doc.select("li span.bullet a");
        String str = elem.text();
        System.out.println("str :" +str);
    }
}