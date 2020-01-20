
public class ThreadTest2 implements Runnable {
	private int idx;
	private int sum;
	
	public int getSum() {
		return sum;
	}
	
	private void sum() {
		for(int i=0; i<2000; i++) {
			synchronized(this) {
				idx+=1;
			
				try {
					Thread.sleep(1);
				}catch(InterruptedException e) {
					
				}
				
				sum += idx;
			}
		}
	}
	
	public void run() {
		
		sum();
		System.out.println(getSum());
	}
}
