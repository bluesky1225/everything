
public class RunnableImple implements Runnable {

	@Override
	public void run() {
		// 클ㄹ스를 만들어서 사용한다고 출력
		try {
			for(int i=0; i<10; i++) {
				Thread.sleep(1000);
				System.out.println("클래스를 만들어서 사용");
			}
		}catch(Exception e) {
			System.out.println("예외 발생 : "+e.getMessage());
		}
	}
	
}
