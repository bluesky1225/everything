package fork;

import java.util.concurrent.RecursiveTask;

// 1부터 60까지 합계를 분할해서 수행하는 클래스
public class ParallelProcessing extends RecursiveTask<Integer> {
	public int start;
	public int end;
	
	private int sum() {
		int r = 0;
		for(int i=start; i<end; i++) {
			r+=i;
			try {
				Thread.sleep(1000); // 프로세스 개수에 따라서 작업 시간을 크게 달라진다
			}catch(InterruptedException e) {}
		}
		return r;
	}
	
	public ParallelProcessing(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	protected Integer compute() {	
		if(end-start<10) {
			return sum();
		}
		
		int half = (end+start)/2;
		
		ParallelProcessing pp1 = new ParallelProcessing(start, half);
		ParallelProcessing pp2 = new ParallelProcessing(half+1, end);
		
		pp1.fork();
		return pp2.compute() + pp1.join();
	}
}
