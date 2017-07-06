package config.setting.init;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;

@Controller
public class Config  {
	HttpServletRequest re;
	FileInputStream fis = null;
	FileOutputStream fos = null;
	BufferedReader b = null;
	String fileRealName = "\\log.txt";
	
	File path = new File(Config.class.getResource("").getPath());
	
	@PostConstruct
	public  void init() throws Exception, IOException {
		// TODO Auto-generated method stub
		String logAdminPath = path.getAbsolutePath();
		String logFilePath = System.getProperty("user.home")+"\\Documents\\buengbueng\\log";
		FileOutputStream fos = null;
		
		BufferedReader b = null;
		try{
			File f = new File(logFilePath);
			if(!f.exists()){
				f.mkdirs();
				fis = new FileInputStream(logAdminPath + fileRealName);
				fos = new FileOutputStream(logFilePath + fileRealName);
				   
				int data = 0;
				
				while((data=fis.read())!=-1) {
					fos.write(data);
			   }

			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if( fis != null){fis.close();}
			if( fos != null){fos.close();}
		}
		
		try{
			File file = new File(logFilePath);
			String destination = ""+ file.getCanonicalPath();
			String fileName= "";
			String fileNamee[] = null; 
			
			b = new BufferedReader(new FileReader(file + fileRealName));
			ArrayList<File> f_list = new ArrayList<File>();
			
			String readLine = "";
			String str = "";
			
			int i = 0;
			while((str = b.readLine()) != null){
				//폴더만들기
				f_list.add(new File(str));
				String mkFolder = destination +"\\"+ f_list.get(i);
				System.out.println(" 경로 찾자"+mkFolder);
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
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if( b != null){b.close();}
		}
	}
	
	@PreDestroy
	public void destroy() throws Exception, IOException{
		if( fis != null){fis.close();}
		if( fos != null){fos.close();}
		if( b != null){b.close();}
	}

}
