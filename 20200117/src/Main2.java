import java.lang.*;

class RunnableImpl implements Runnable {
	public void run() {
		try {
			for(int i=0; i<5; i++) {
				Thread.sleep(1000);
				System.out.println("스레드 테스트2");						
			}
		} catch(InterruptedException e) {
			System.out.println("스레드 예외 발생 : "+e);
		}
	}
}

public class Main2 {
	public static void main(String[] args) {
		Runnable r1 = new RunnableImpl();
		
		Runnable r2 = new Runnable() {
			public void run() {
				try {
					for(int i=0; i<5; i++) {
						Thread.sleep(1000);
						System.out.println("스레드 테스트");						
					}
				} catch(InterruptedException e) {
					System.out.println("스레드 예외 발생 : "+e);
				}
			}
		};
		Thread t = new Thread(r1);
		
		Thread t2 = new Thread(r2);
		
		t.start();
		t2.start();
		
		Thread t3 = new Thread() {
			public void run() {
				try {
					for(int i=0; i<5; i++) {
						Thread.sleep(1000);
						System.out.println("스레드 테스트");						
					}
				} catch(InterruptedException e) {
					System.out.println("스레드 예외 발생 : "+e);
				}
			}
		};
		
		t3.start();
		
		
	}
}
