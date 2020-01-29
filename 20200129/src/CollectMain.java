import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member member1 = new Member(1, "홍길동", "19880707", 1, "01023244155", "a@gmail.com", 10);
		Member member2 = new Member(2, "이순신", "19770209", 1, "01002024555", "b@gmail.com", 3);
		Member member3 = new Member(3, "유관순", "19930416", 0, "01026566466", "c@gmail.com", 1);
		Member member4 = new Member(4, "김유신", "19790723", 1, "01066744472", "d@gmail.com", 20);
		Member member5 = new Member(5, "원균", "19991002", 1, "01098832231", "e@gmail.com", 8);
		
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(member1);
		list.add(member2);
		list.add(member3);
		list.add(member4);
		list.add(member5);
		
		Stream<Member> stream = list.stream();
		
		// gender의 값이 남자인 데이터만 갖고 list를 생성
		List<Member> manList = stream.filter(member->{
			if(member.getGender()==1) return true;
			else return false;
		}).collect(Collectors.toList());
		
		for(Member m:manList) {
			System.out.println(m.getName());
		}
		
		// gender의 값이 남자(1)인 데이터를 골라서 가지고 name을 key로 하고 전체를 value로 하는 Map을 생성
		stream = list.stream();
		Map<String, Member> menMap = stream.filter(member->{
			if(member.getGender()==1) return true;
			else return false;
		}).collect(Collectors.toMap(Member::getName, member->{return member;}));
		
		//Map의 모든 데이터 출력
		Set<String> keys = menMap.keySet();
		for(String key : keys) {
			System.out.println(key + " : " + menMap.get(key));
		}
		
		
	}

}
