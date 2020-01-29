import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class CollectionUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// List의 데이터를 사용
		// 배열을 이용해서 List 만들기
		List<String> list = Arrays.asList("C", "Python", "Java");

		// 인덱스를 이용해서 하나씩 접근 - 배열이나 List의 데이터 개수를 알아야 함
		int length = list.size();
		
		int i=0;
		while(i<length) {
			String temp = list.get(i);
			System.out.println(temp);
			i+=1;
		}
		
		System.out.println("반복자(Iterator - Enumeration : __iter__: python)를 이용해서 하나씩 접근");
		
		// 반복자는 데이터 개수를 알 필요가 없음
		Iterator<String> iterator = list.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		
		// 스트림
		Stream <String> stream = list.stream();
		stream.forEach((name) -> {System.out.println(name);});
		
		
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./test.csv")));
			
			String content = br.readLine();
			
			String[] ar = content.split(", ");
			
			//  빠른 열거
			for(String temp:ar) {
				System.out.println(temp);
			}
			
			
			// 스트림
			Stream<String> stream2 = Arrays.stream(ar);			
			stream2.forEach(System.out::println);
			
			System.out.println(ar[3].length());
			// ar[3]에는 12345건이라는 문자열이 존재 - 이걸 12345라는 정수로 변환
			int su = 0;
			for(int j=0; j<ar[3].length(); j++) {
				// 한글자씩 져오기
				char ch = ar[3].charAt(j);
				// 숫자인지 확인
				if(ch >= '0' && ch <= '9') {
					su = su*10 + (ch-'0');
					
				} else {
					break;
				}
				
			}
			System.out.print(su);
			br.close();
		} catch(Exception e) {
			System.out.println("읽기 실패 : "+e.getMessage());
			e.printStackTrace();
		}
	}

}
