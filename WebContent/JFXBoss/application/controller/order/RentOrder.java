package application.controller.order;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.URLDecoder;

import application.controller.module.BossPcManageController;
import javafx.application.Platform;

public class RentOrder implements Runnable{
	private static RentOrder instance;
	private static Thread rent;
	private DatagramSocket socket;
	private RentOrder(){
		try {
			socket = new DatagramSocket(7777);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	};
	public static Thread getRent(){
		instance = new RentOrder();
		rent = new Thread(instance);
		// true일 때 반복 실행
		return rent;
	}
	
	public static void rentClose(){
		instance.socket = null;
		instance = null;
		rent = null;
	}
	
	@Override
	public void run() {
		try{
			// 전송받은 데이터를 지정할 바이트 배열선언
			byte [] date = new byte[66536];
   
			// UDP 통신으로 전송을 받을 packet 객체생성
			DatagramPacket dp = new DatagramPacket(date, date.length);
			while(!socket.isClosed()){
				System.out.println("데이터 수신 준비 완료....");
				socket.receive(dp);
				byte[] data = dp.getData();
                String txt = URLDecoder.decode(new String(data, 0, dp.getLength()),"UTF-8");
                Platform.runLater(() -> {
                	rent(txt);
                });
                Thread.sleep(1000);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void rent(String txt){
		BossPcManageController.addRentOrder(txt);
	}
}