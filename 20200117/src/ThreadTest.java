import java.lang.*;

public class ThreadTest extends Thread {

	public void run() {
		// 1초마다 Hello Thread 10회 출력
		
		
		try {
			for(int i=0; i<10; i++) {
				System.out.println("Hello Thread");
				Thread.sleep(500);
			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
