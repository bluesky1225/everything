
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		ThreadTest tt1 = new ThreadTest();
		ThreadTest tt2 = new ThreadTest();
		tt1.setMessage("1월 20일");
		tt2.setMessage("월요일");
		Thread t1 = new Thread(tt1);
		Thread t2 = new Thread(tt1);
		
		t1.start();
		t2.start();
		*/
		/*
		ThreadTest2 tt1 = new ThreadTest2();
		ThreadTest2 tt2 = new ThreadTest2();
		Thread t1 = new Thread(tt1);
		Thread t2 = new Thread(tt1);
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(5000);
			System.out.println(tt1.getSum());
		} catch(InterruptedException e) {}
		*/
		ThreadTest3 tt = new ThreadTest3();
		ThreadTest3_2 tt1 = new ThreadTest3_2(tt);
		ThreadTest3_3 tt2 = new ThreadTest3_3(tt);
		
		tt1.start();
		/*
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {}
		*/
		
		tt2.start();
	}

}
