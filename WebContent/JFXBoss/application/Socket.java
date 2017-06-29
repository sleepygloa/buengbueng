package application;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;

import application.controller.module.BossPcManageController;
import javafx.application.Platform;

public class Socket implements Runnable{
	private static Socket instance;
	private static Thread Socket;
	
	public static Thread getSocket(){
		instance = new Socket();
		Socket = new Thread(instance);
		// true일 때 반복 실행
		return Socket;
	}

	public void run(){
		try{
	        ServerSocket server = new ServerSocket(7778);
	        System.out.println("Wating Connect ..");    
	       
	        String line = null;
	        while(true){
		        java.net.Socket sock = server.accept();	       
		        InputStream in = sock.getInputStream();
		        BufferedReader br = new BufferedReader(new InputStreamReader(in));
		        if((line = br.readLine()) != null){
		        	System.out.println("클라이언트로부터 전송받은 문자열 : "+line);
		            String[] s = line.split(",");
		            if(s[0].equals("login")){
		            	Platform.runLater(() -> {
		            		BossPcManageController.userLogin(s);
		            	});
		            }else{
		            	Platform.runLater(() -> {
		            		BossPcManageController.userLogout(s);
		            	});
		            }
		        }
		        Thread.sleep(1000);
	        }
		 } catch(Exception e){
		        System.out.println(e);
		 }
	}
}
