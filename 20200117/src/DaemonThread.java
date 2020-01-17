import java.util.*;
public class DaemonThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread th = new Thread() {
			public void run() {
				try {
					for(int i=0; i<10; i++) {
						System.out.println("스레드 출력");
						Thread.sleep(500);
					}
				} catch(InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		};
		
		th.setDaemon(true); // 데몬 스레드 : 메인 종료와 함꼐 강제 종료한다. 프로그램에서는 데몬 스레드를 더 많이 사용한다
		th.start(); // 일반 스레드 : 자기 작업이 종료될떄까지 절대로 작업을 멈추지 않음.
		// main이 종료되어도 자기 작업을 계속한다.
		
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(Thread.NORM_PRIORITY);
		
		System.out.println("메인종료");
	}

}
