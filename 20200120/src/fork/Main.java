package fork;

import java.util.Calendar;
import java.util.concurrent.ForkJoinPool;

public class Main {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		ParallelProcessing p = new ParallelProcessing(1, 60);
		// 위의 작업을 나눠서 할 수 있는 Pool을 생성
		ForkJoinPool pool = new ForkJoinPool();
		
		System.out.println(pool.invoke(p));
	}

}
