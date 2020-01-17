import java.util.*;

public class AnonymousClass implements Comparable<Integer> {
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("야구");
		list.add("축구");
		list.add("농구");
		list.add("야구");
		
		list.sort(new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				
				return arg0.compareTo(arg1);
			}
			
		});
		
		for(String str:list)
			System.out.println(str);
		
		ArrayList<Integer> lis = new ArrayList<Integer>();
		lis.add(8);
		lis.add(3);
		lis.add(5);
		lis.add(2);
		lis.add(1);
		AnonymousTest at=new AnonymousTest();
		
		lis.sort(at);
		
		
		
		for(int str:lis)
			System.out.println(str);
		
		
		// Comparator의 Anonymous Class 만들기
		Comparator<String> c = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {						
				return o2.compareTo(o1);
			}
					
		};
		
		list.sort(c);
		
		for(String str:list)
			System.out.println(str);
		
		
		
		
		
	}

	@Override
	public int compareTo(Integer o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
