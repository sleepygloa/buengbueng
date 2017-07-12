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
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

@Controller
public class Config  {
	HttpServletRequest re;
	FileInputStream fis = null;
	FileOutputStream fos = null;
	BufferedReader b = null;
	String fileRealName = "\\log.txt";
	File path = new File(Config.class.getResource("").getPath());
	NodeInit ni = new NodeInit();
	
	@PostConstruct
	public void init() {
		
//		NodeInit.nodeExit();
		
//		String folderCheck = folderCheck();
//		
//		fileCheck(folderCheck);
		
		
//		ni.start();
		
	}
	
	@PreDestroy
	public void destroy() {
		if( fis != null){try{fis.close();}catch(IOException e){System.out.println("init 종료시 fis 오류"+e);}}
		if( fos != null){try{fos.close();}catch(IOException e){System.out.println("init 종료시 fos 오류"+e);}}
		if( b != null){try{b.close();}catch(IOException e){System.out.println("init 종료시 b 오류"+e);}}
		
//		try {Thread.sleep(10000);} catch(InterruptedException e) {}

//		NodeInit.nodeExit();

	}

	public String folderCheck(){
		String logAdminPath = path.getAbsolutePath();
		String logFilePath = System.getProperty("user.home")+"\\Documents\\buengbueng\\log"; //파일의 위치 지정
		FileOutputStream fos = null;
		
		try{
			File f = new File(logFilePath);
			if(!f.exists()){//폴더 존재 유무를 확인
				f.mkdirs(); //폴더를 생성
				fis = new FileInputStream(logAdminPath + fileRealName); 
				fos = new FileOutputStream(logFilePath + fileRealName);
				int data = 0;
				while((data=fis.read())!=-1) {
					fos.write(data);
			   }
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(" log 폴더 체크시 오류  : "+e);
		}finally{
			if( fis != null){try{fis.close();}catch(IOException e){System.out.println(e);}}
			if( fos != null){try{fos.close();}catch(IOException e){System.out.println(e);}}
		}
		
		return logFilePath;
	}
	
	public void fileCheck(String logFilePath){
		try{
			File file = new File(logFilePath);
			String destination = ""+ file.getCanonicalPath(); //log 파일 위치 경로
			String fileName= "";
			String fileNamee[] = null; 
			
			b = new BufferedReader(new FileReader(file + fileRealName)); //로그파일위치를 읽는다.
			ArrayList<File> f_list = new ArrayList<File>();
			
			String readLine = "";
			String str = "";
			
			int i = 0;
			while((str = b.readLine()) != null){
				//폴더만들기
				f_list.add(new File(str)); //로그파일안의 경로를 읽는다.
				String mkFolder = destination +"\\"+ f_list.get(i); // 폴더를 만들기 위해 경로를 저장
//				System.out.println(" 경로 찾자"+mkFolder);
				File desti = new File(mkFolder); //String을 File형태로 변환
				if(!desti.exists()){
					desti.mkdirs(); //폴더를 생성
				}
				//파일만들기
				StringTokenizer tokens = new StringTokenizer(str); //log.txt내의 경로를 읽어 파일이름으로 쓸 문자를 쪼갠다.
				fileName = tokens.nextToken("\\"); 
				if(tokens.hasMoreTokens()){
					fileName = tokens.nextToken(); // \\ 의 다음 토큰을 구한다.
				}
				System.out.println(fileName + ".txt"); //이름 + .txt 로 파일이름을 만든다.
				System.out.println(desti+"\\" + fileName + ".txt");
					BufferedWriter bw = new BufferedWriter(new FileWriter(new File(desti+ "\\" + fileName + ".txt"),true)); //파일을 만든다.
					bw.close();
				
				i++;
			}
			System.out.println("Log 디렉토리 생성 완료");
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(" Log 디렉토리 생성시 오류 : "+e);
		}finally{
			if( b != null){ try{b.close();}catch(IOException e){System.out.println(" Log 디렉토리 생성시 오류 : "+e);}}
		}
	}
	
}
