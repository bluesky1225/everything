import java.util.*;

public class Test8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = {1, 2, 3, 4, 7, 6, 5, 8};
		String[] ar2 = {"a", "bb","ccc", "aa", "t", "n"};
		String[] ar3 = {"하", "가", "마", "나", "아"};
		Arrays.sort(ar);
		Arrays.sort(ar2);
		Arrays.parallelSort(ar3);
		for(int a:ar)
			System.out.print(a+" ");
		System.out.println();
		for(String b:ar2)
			System.out.print(b+" ");
		System.out.println();
		for(String c:ar3)
			System.out.print(c+" ");
		
	}

}
