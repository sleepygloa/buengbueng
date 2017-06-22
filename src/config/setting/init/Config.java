package config.setting.init;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;

@Controller
public class Config  {

	@PostConstruct
	public  void init() throws Exception, IOException {
		// TODO Auto-generated method stub
		try{
//			String destination = "C:\\Users\\user2\\Documents\\workspace\\buengbueng\\WebContent\\log\\";
//			String destination = "C:\\Users\\KO\\Documents\\eclipse\\Spring\\buengbueng\\WebContent\\log\\";
			File file = new File("\\buengbueng");
			String destination = 
					"" + file.getCanonicalFile().getPath()  + 
					"\\WebContent\\log\\";
			String logText = "log.txt";
			String fileName= "";
			String fileNamee[] = null; 
			
			File f = new File(destination+logText);
			BufferedReader b = new BufferedReader(new FileReader(f));
			ArrayList<File> f_list = new ArrayList<File>();
			
			String readLine = "";
			String str = "";
			
			int i = 0;
			while((str = b.readLine()) != null){
				//폴더만들기
				f_list.add(new File(str));
				String mkFolder = destination + f_list.get(i);
				
				File desti = new File(mkFolder);
				if(!desti.exists()){
					desti.mkdirs();
				}
				//파일만들기
				StringTokenizer tokens = new StringTokenizer(str);
				fileName = tokens.nextToken("\\");
				if(tokens.hasMoreTokens()){
					fileName = tokens.nextToken();
				}
				System.out.println(fileName + ".txt");
				System.out.println(desti+"\\" + fileName + ".txt");
					BufferedWriter bw = new BufferedWriter(new FileWriter(new File(desti+ "\\" + fileName + ".txt"),true));
					bw.close();
				
				i++;
			}
			System.out.println("Log 디렉토리 생성 완료");
			
			b.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		}
	}
	
	@PreDestroy
	public void destroy() throws Exception, IOException{
	}

}
