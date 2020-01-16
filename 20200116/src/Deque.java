import java.util.*;

public class Deque {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayDeque <String> deque = new ArrayDeque<>();
		
		deque.add("중국");
		deque.addFirst("한국");
		deque.addLast("일본");
		deque.addFirst("미국");
		deque.addLast("영국");
		
		for(String data:deque)
			System.out.println(data);
		
		System.out.println(deque.pollFirst());
		
		for(String data:deque)
			System.out.println(data);
	}

}
