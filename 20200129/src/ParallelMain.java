import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelMain {

	public static void work(String str) {
		try {
			Thread.sleep(2000);
			System.out.println(str);
		} catch(Exception e) {}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] ar = {"일", "이", "삼", "사", "오"};
		// 일반 스트림을 생성해서 ar에 work를 수행 - 10초 정도 소요
		
		List<String> list = Arrays.asList(ar);
		
		Stream<String> arStream = Arrays.stream(ar);
		
		long start = System.currentTimeMillis();
		
		arStream.forEach(data -> work(data));
		
		long end = System.currentTimeMillis();
		
		System.out.println("순차처리 : "+(end - start));
		
		Stream <String> parallelStream = list.parallelStream();
		
		start = System.currentTimeMillis();
		
		parallelStream.forEach(data -> work(data));
		
		end = System.currentTimeMillis();
		
		System.out.println("병렬처리 : "+(end - start));
		
		
	}

}
