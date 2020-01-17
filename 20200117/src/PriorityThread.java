import java.util.*;
// 클래스를 만드는 경우는 대부분 인스턴스를 2개 이상 만드는 경우
class Threadext extends Thread {
	public void run() {
		// 스레드 자신의 이름을 10번 출력(1초마다 쉬면서)
		try {
			Thread.sleep(1000);
			System.out.println(getName());
			Thread.sleep(1000);
			System.out.println(getName());
			Thread.sleep(1000);
			System.out.println(getName());
			Thread.sleep(1000);
			System.out.println(getName());
		} catch(InterruptedException e) {
			// return;
			 // return이 있고 없고에 따라서 Thread가 강제 종료 되기도 하고 안 되기도 한다
		}
	}
}

public class PriorityThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Threadext().run(); // 한번만 수행
		
		Threadext t1 = new Threadext();
		Threadext t2 = new Threadext();
		Threadext t3 = new Threadext();
		
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.NORM_PRIORITY);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(3000);
			t2.interrupt();
		} catch(InterruptedException e) {
			
		}
	}

}
