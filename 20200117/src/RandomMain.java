import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Comparator;

public class RandomMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r1 = new Random();
		Random r2 = new Random(1);
		
		int result1 = r1.nextInt()%100;
		int result2 = r2.nextInt();
		
		System.out.println(result1);
		System.out.println(result2);
		
		// 빨강 파랑 녹색을 랜덤하게 출력
		// 복원추출
		String[] color = {"빨강", "파랑", "녹색"};
		Random r3 = new Random();
		System.out.println(color[r3.nextInt(color.length+1)%(color.length)]);
		
		// 비복원추출(로또처럼 중복되어선 안 되는 경우)
		List<Integer> list = new ArrayList<Integer>();
		//1-45 저장
		for(int i=1; i<=45; i++) {
			list.add(i);
		}
		//20개의 숫자를 비복원추출
		
		list.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
			
		});
		
		for(int i=0; i<20; i++) {
			int x = r1.nextInt(list.size());
			int value = list.get(x);
			list.remove(x);
			System.out.print(value + "\t");
		}
	}

}
