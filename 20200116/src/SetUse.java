import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Set 인스턴스 생성 - HashSet, LinkedHashSet, TreeSet으로 변경하면서 패턴
		Set<Integer> set = new TreeSet<Integer>();
		// Set에 데이터 추가
		set.add(100);
		set.add(200);
		set.add(300);
		set.add(700);
		set.add(500);
		set.add(400);
		set.add(600);
		
		for(Integer temp:set)
			System.out.println(temp);
		
		
	}

}
