import java.util.*;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> ar = new ArrayList<Integer>();
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ar.add(10);
		ar.add(30);
		ll.add(10);
		ll.add(30);
		/*
		System.out.println("데이터 순서대로 삽입");
		
		long preTime = System.currentTimeMillis();
		for(int value:data) {
			ar.add(value);
		}
		long curTime = System.currentTimeMillis();
		
		System.err.println("Array List : "+(preTime - curTime));
		
		preTime = System.currentTimeMillis();
		for(int value:data) {
			ll.add(value);
		}
		curTime = System.currentTimeMillis();
		
		System.err.println("Linked List : "+(preTime - curTime));
		
		*/
		System.out.println("데이터를 중간에 삽입");
		
		long preTime = System.currentTimeMillis();
		for(int i = 0; i< 100000; i++)
			ar.add(1,20);
		long curTime = System.currentTimeMillis();
		
		System.err.println("Array List : "+(curTime-preTime));
		
		preTime = System.currentTimeMillis();
		for(int i = 0; i< 100000; i++)
			ll.add(1,20);
		curTime = System.currentTimeMillis();
		
		System.err.println("Linked List : "+(curTime-preTime));
		
		
		System.out.println("중간의 데이터를 삭제");
		
		preTime = System.currentTimeMillis();
		for(int i = 0; i< 100000; i++)
			ar.remove(1);
		curTime = System.currentTimeMillis();
		
		System.err.println("Array List : "+(curTime-preTime));
		
		preTime = System.currentTimeMillis();
		for(int i = 0; i< 100000; i++)
			ll.remove(1);
		curTime = System.currentTimeMillis();
		
		System.err.println("Linked List : "+(curTime-preTime));
		
		
		System.out.println("데이터를 2에 삽입");
		
		preTime = System.currentTimeMillis();
		for(int i = 0; i< 100000; i++)
			ar.add(2,20);
		curTime = System.currentTimeMillis();
		
		System.err.println("Array List : "+(curTime-preTime));
		
		preTime = System.currentTimeMillis();
		for(int i = 0; i< 100000; i++)
			ll.add(2,20);
		curTime = System.currentTimeMillis();
		
		System.err.println("Linked List : "+(curTime-preTime));
		
		/*
		System.out.println("모든 데이터를 읽어서 출력");
		
		preTime = System.currentTimeMillis();
		for(int temp:ar)
			System.out.println(temp + " ");
		System.out.println();
		curTime = System.currentTimeMillis();
		
		System.err.println("Array List : "+(curTime-preTime)); // 10만개 : 425, 20만개 : 823
		
		preTime = System.currentTimeMillis();
		for(int temp2:ll)
			System.out.println(temp2 + " ");
		System.out.println();
		curTime = System.currentTimeMillis();
		
		System.err.println("Linked List : "+(curTime-preTime)); // 10만개 : 403, 20만개 : 792
		
		
		System.out.println("맨앞에 데이터를 추가");
		
		preTime = System.currentTimeMillis();
		ar.add(0, 110);
		curTime = System.currentTimeMillis();
		
		System.err.println("Array List : "+(preTime - curTime));
		
		preTime = System.currentTimeMillis();
		ll.add(0, 110);
		curTime = System.currentTimeMillis();
		
		System.err.println("Linked List : "+(preTime - curTime));
		
		
		System.out.println("맨앞의 데이터를 삭제");
		
		preTime = System.currentTimeMillis();
		ar.remove(0);
		curTime = System.currentTimeMillis();
		
		System.err.println("Array List : "+(preTime - curTime));
		
		preTime = System.currentTimeMillis();
		ll.remove(0);
		curTime = System.currentTimeMillis();
		
		System.err.println("Linked List : "+(preTime - curTime));
		
		
		System.out.println("맨뒤에 데이터를 추가");
		
		preTime = System.currentTimeMillis();
		ar.add(8, 120);
		curTime = System.currentTimeMillis();
		
		System.err.println("Array List : "+(preTime - curTime));
		
		preTime = System.currentTimeMillis();
		ll.add(8, 120);
		curTime = System.currentTimeMillis();
		
		System.err.println("Linked List : "+(preTime - curTime));
		
		
		System.out.println("맨뒤의 데이터를 삭제");
		
		preTime = System.currentTimeMillis();
		ar.remove(8);
		curTime = System.currentTimeMillis();
		
		System.err.println("Array List : "+(preTime - curTime));
		
		preTime = System.currentTimeMillis();
		ll.remove(8);
		curTime = System.currentTimeMillis();
		
		System.err.println("Linked List : "+(preTime - curTime));
		
		preTime = System.currentTimeMillis();
		for(int temp:ar)
			System.out.print(temp + " ");
		System.out.println();
		for(int temp2:ll)
			System.out.print(temp2 + " ");
		System.out.println();
		curTime = System.currentTimeMillis();
		
		System.err.println("Linked List : "+(preTime - curTime));
		*/
	}

}
