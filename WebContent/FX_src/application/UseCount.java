package application;

import application.controller.login.MainController;
import user.info.dto.UserInfo;

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
				
				// 사용 가능 시간이 없으면
				if(sec==0 && min ==0 && hour ==0){
					time = false;
					MainController main = new MainController();
					main.Logout();
				}
				// 사용 가능 시간이 있으면
				else{
					// 사용 가능 시간 1초 씩 깎임
					String time = String.format("%02d:%02d:%02d", hour, min, sec);
					MainController.getUseTime().setText(time);
					secs--;
					
					// 1초 당 포인트 0.25원 씩 차감
					double usePoint = UserInfo.getInstance().getPoint();
					UserInfo.getInstance().setPoint(usePoint-0.25);
					usePoint = UserInfo.getInstance().getPoint();
					MainController.getPoint().setText(String.valueOf(usePoint)+"원");
					
					Thread.sleep(1000);
				}
			}catch(Exception e){
				// 추후...수정
			}
		}
	}
}
