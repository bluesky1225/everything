import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member member1 = new Member(1, "홍길동", "19880707", 1, "01023244155", "a@gmail.com", 10);
		Member member2 = new Member(2, "이순신", "19770209", 1, "01002024555", "b@gmail.com", 3);
		Member member3 = new Member(3, "유관순", "19930416", 0, "01026566466", "c@gmail.com", 1);
		Member member4 = new Member(4, "김유신", "19790723", 1, "01066744472", "d@gmail.com", 20);
		Member member5 = new Member(5, "원균", "19991002", 1, "01098832231", "e@gmail.com", 8);
		Member member6 = new Member(6, "심청", "19700711", 0, "01066723252", "f@gmail.com", 18);
		Member member7 = new Member(7, "명성황후", "19601022", 0, "0109855231", "g@gmail.com", 7);
		
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(member1);
		list.add(member2);
		list.add(member3);
		list.add(member4);
		list.add(member5);
		
		//List를 Stream으로 변환
		Stream<Member> stream = list.stream();
		
		// stream으로 그룹화
		Map<Integer, List<Member>> map = stream.collect(Collectors.groupingBy(Member::getGender));
		
		Set<Integer> keys = map.keySet();
		
		for(int gender:keys) {
			System.out.println(map.get(gender));
		}
		
		System.out.println();
		
		// 스트림은 한 번 소모하면 소멸됨
		// 새로운 작업을 수행할떄마다 스트림을 다시 생성해주어야함
		stream = list.stream();
		
		// gender별로 그룹화 한 후 workYear의 평균 구하기
		Map <Integer, Double> result = stream.collect(Collectors.groupingBy(Member::getGender, Collectors.averagingDouble(Member::getWorkYear)));
		keys = result.keySet();
		for(Integer key:keys) {
			System.out.println(key + " : " + result.get(key));
		}
		
		stream = list.stream();
		
		Map<Integer, Optional<Member>> result1 = stream.collect(Collectors.groupingBy(
					member ->{ return member.getGender();}, Collectors.maxBy(Comparator.comparingInt(Member::getWorkYear))));
		keys = result1.keySet();
		for(int key:keys) {
			System.out.println(result1.get(key));
		}
		
	}

}
