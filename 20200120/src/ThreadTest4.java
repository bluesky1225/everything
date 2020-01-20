import java.util.concurrent.Semaphore;

public class ThreadTest4 extends Thread {
	// Semaphore
	
	// 세마포어 변수
	private Semaphore sem;
			
	// 외부에서  Semaphore를 주입받음
	public ThreadTest4(Semaphore sem) {
		this.sem = sem;
	}
	
	public void run() {
		try {
			sem.acquire();
			System.out.println("몬스터 생성");
		
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			
		}
		System.out.println("몬스터 소멸");
		sem.release();
	}
}
