// 소비자 스레드
public class ThreadTest3_3 extends Thread {
	private ThreadTest3 product;
	
	public ThreadTest3_3(ThreadTest3 product) {
		this.product = product;
	}
	
	public void run() {
		for(char i='A'; i<'Z'; i++) {
			product.get();
		}
	}
}
