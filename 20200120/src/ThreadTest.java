
public class ThreadTest implements Runnable {
	String message;
	int count=0;
	
	
	
	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public void run() {
		try {
			for(int i=0; i<20000; i++) {
				count++;
				System.out.println(count);
				Thread.sleep(1);	
			}
		} catch(InterruptedException e) {
			
		}
	}
}
