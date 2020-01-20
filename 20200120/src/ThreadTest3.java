import java.util.*;

//공유자원을 소유할 클래스
public class ThreadTest3 implements Runnable {
	private List<Character> list;
	
	public ThreadTest3() {
		list = new ArrayList<Character>();
	}
	
	public synchronized void put(Character data) {
		if(list.size()>2) {
			try {
				wait();
			} catch(Exception e) {
				
			}
		}
		list.add(data);
		
		notify();
		
		System.out.println(data+"가 입고되었습니다.");
		try {
			Thread.sleep(1000);
		} catch(Exception e) {
			
		}
		System.out.println("입고후 현재 수량 : "+list.size());
	}
	
	public synchronized void get() {
		if(list.size()==0) {
			try {
				wait();
			} catch(Exception e) {
				
			}
		} else if(list.size()==1) {
			notify();
		}
		Character data = list.remove(0);
		System.out.println(data+"가 출고되었습니다.");
		try {
			Thread.sleep(1000);
		} catch(Exception e) {
			
		}
		System.out.println("출고후 현재 수량 : "+list.size());
		
	}
	
	public void run() {
		
		
		
	}
}
