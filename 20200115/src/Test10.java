import java.lang.reflect.Array;
import java.util.Arrays;

public class Test10 {
	public static void main(String[] args) {
		int[] ar = {100, 20, 40, 50, 30};
		System.out.println(Arrays.binarySearch(ar, 100));
		
		Arrays.parallelSort(ar);
		System.out.println(Arrays.binarySearch(ar, 100));
	}
}
