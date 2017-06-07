package application;

import application.controller.login.MainController;

// 사용자 이용시간 카운트
public class UseCount implements Runnable{

	private static UseCount instance;
	private static Thread useTime;
	private boolean time;
	private static int secs = 0;
	
	private UseCount(){
		time = false;
	}
	
	public static void stopTime(){
		// 이전 사용자의 사용 시간 Thread는 끄기
		instance.time = false;
		instance = null;
		useTime = null;
	}
	
	public static Thread getUseTime(int count){
		secs = count;
		// Thread는 1개의 객체를 재시작하는 개념 X -> 새로 생성 후 start()
		instance = new UseCount();
		useTime = new Thread(instance);
		// true일 때 반복 실행
		instance.time = true;
		return useTime;
	}

	public void run(){
		while(time){
			try{
				int sec = secs % 60;
				int min = secs / 60 % 60;
				int hour = secs / 3600;
				String time = String.format("%02d:%02d:%02d", hour, min, sec);
				MainController.getUseTime().setText(time);
				secs--;
				Thread.sleep(1000);
			}catch(Exception e){
				// 추후...수정
			}
		}
	}
}
