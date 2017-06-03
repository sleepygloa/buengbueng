package application;

import application.controller.login.MainController;

// ����� �̿�ð� ī��Ʈ
public class UseCount implements Runnable{

	private static UseCount instance;
	private static Thread useTime;
	private boolean time;
	private static int secs = 0;
	
	private UseCount(){
		time = false;
	}
	
	public static void stopTime(){
		// ���� ������� ��� �ð� Thread�� ����
		instance.time = false;
		instance = null;
		useTime = null;
	}
	
	public static Thread getUseTime(int count){
		secs = count;
		// Thread�� 1���� ��ü�� ������ϴ� ���� X -> ���� ���� �� start()
		instance = new UseCount();
		useTime = new Thread(instance);
		// true�� �� �ݺ� ����
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
				// ����...����
			}
		}
	}
}
