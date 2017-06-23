package application.controller.order;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

import application.controller.login.BossMainController;
import application.controller.module.BossPcManageController;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class RentOrder implements Runnable{
	public void run() {
		try{
			// 상대방이 연결할수 있도록 UDP 소켓 생성
			DatagramSocket socket = new DatagramSocket(7777);
			// 전송받은 데이터를 지정할 바이트 배열선언
			byte [] date = new byte[66536];
   
			// UDP 통신으로 전송을 받을 packet 객체생성
			DatagramPacket dp = new DatagramPacket(date, date.length);
			while(!socket.isClosed()){
				System.out.println("데이터 수신 준비 완료....");
				socket.receive(dp);
				byte[] data = dp.getData();
                String txt = new String(data, 0, dp.getLength());
			}
		}catch(Exception e){ }
	}
}