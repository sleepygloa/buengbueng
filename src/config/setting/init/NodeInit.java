package config.setting.init;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class  NodeInit extends Thread {
	public static void nodeExit(){
		StringBuffer message = new StringBuffer();
		 InputStreamReader isr = null;
		 BufferedReader br = null;
		 BufferedReader r = null;
		  try {
			   Process p = Runtime.getRuntime().exec(System.getenv("windir")+"\\system32\\"+"tasklist.exe");
			   isr = new InputStreamReader(p.getInputStream());
			   br = new BufferedReader(isr);
			   
			   String line = null;
			   while ((line = br.readLine())!= null) {
//				System.out.println("msg=>"+line);
				   if(line.contains("node")){
					   System.out.println("노드가 실행 중입니다. 노드를 종료하고 다시 실행 합니다.");
					   
					   List<String> list = new ArrayList<String>();
						list.add("cmd.exe");
						list.add("/c");
						list.add("taskkill /F /IM node.exe");
						
						ProcessBuilder pb = new ProcessBuilder(
								list
								);
//					       System.out.println(pb.command());
					       pb.redirectErrorStream(true);
					        Process p2 = pb.start();
					        r = new BufferedReader(new InputStreamReader(p2.getInputStream()));
					        String line2;
					        while(true){
					            line2 = r.readLine();
					            if(line2 == null) { break; }
					            System.out.println("line : "+line2);
					        } 
				   }
			   }
			  } catch (Exception e) {
			   e.printStackTrace();
			   System.out.println(" 노드 실행시 프로세스 삭제 시 오류 : "+e);
			  } finally {
			   if(isr!=null) try {isr.close(); } catch (IOException e) {}
			   if(br!=null) try { br.close();} catch (IOException e) {}
			   if(r!=null) try { r.close();} catch (IOException e) {}
			  }
	}
	
	//노드 실행
	public void run(){
		BufferedReader r = null;
		try{
			
			List<String> list = new ArrayList<String>();
			list.add("cmd.exe");
			list.add("/c");
//			list.add("dir");
			list.add("supervisor chatServer.js");
			
			ProcessBuilder pb = new ProcessBuilder(
					list
					);
//			pb.directory(new File("C:\\Users\\user2\\Documents\\workspace\\buengbueng\\WebContent\\Node\\project\\")); //학원선호컴
			pb.directory(new File("C:\\Users\\sleep\\Documents\\workspace\\buengbueng\\WebContent\\Node\\project\\")); //선호 집컴
//		       System.out.println(pb.command());
		       pb.redirectErrorStream(true);
		        Process p = pb.start();
		        r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		        String line;
		        while(true){
		            line = r.readLine();
		            if(line == null) { break; }
//		            System.out.println("line ::"+line);
		        }
		}catch (Exception e){
			e.printStackTrace();
			System.out.println(" 노드 실행시 오류 : "+e);
		}finally{
			try{r.close();}catch(IOException e){System.out.println(" 노드 실행시 오류 : "+e);}
		}
		
	}
}
