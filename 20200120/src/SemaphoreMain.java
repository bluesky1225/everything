import java.util.concurrent.Semaphore;

public class SemaphoreMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Semaphore sem = new Semaphore(10);
		
		for(int i=0; i<20; i++) {
			ThreadTest4 tt = new ThreadTest4(sem);
			tt.start();
		}
		
		System.out.println("PC 코어 개수: "+Runtime.getRuntime().availableProcessors());
	}

}
