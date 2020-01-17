
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadTest tt1 = new ThreadTest();
		ThreadTest tt2 = new ThreadTest();
		
		//tt1.run();
		//tt2.run();
		
		// run()을 스레드로 실행 : 거의 동시에 출력됨
		tt1.start();
		tt2.start();
	}

}
