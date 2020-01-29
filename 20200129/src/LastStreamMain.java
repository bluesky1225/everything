import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class LastStreamMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 문자열 배열을 이용해서 스트림을 생성
		String [] ar = {"Python", "Java", "Closure", "Scala", "Kotlin", "Swift", "C#", "C&C++", "JavaScript"};
		
		Stream<String> stream = Arrays.stream(ar);
		
		boolean r = stream.allMatch(name->{
			return name.length()>5;
		});
		System.out.println(r);
		System.out.println();
		
		stream = Arrays.stream(ar);
		
		stream.filter(name -> {
			if(name.length()>5) return true;
			else return false;
		}).forEach(System.out::println);
		
		
		
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
		
		Stream<Member> stream2 = list.stream();
		int tot = stream2.mapToInt(Member::getWorkYear).sum();
		System.out.println("근무 년수 합계 : "+tot);
		System.out.println();
		
		// 데이터 개수
		stream2 = list.stream();
		long cnt = stream2.filter(member -> {return member.getName().equals("홍길동");}).count();
		System.out.println("이름 홍길동은 몇명 : "+cnt);
		System.out.println();
		
		//gender가 남인 사람의 근무년수 평균은?
		stream2 = list.stream();
		//Optional은 기존 자료형의 데이터를 Wrapping 한 자료형
		OptionalDouble avg = stream2.filter((member)->{ 
			if(member.getGender()==1) return true;
			else return false; 
			}).mapToInt(Member::getWorkYear).average();
		
		System.out.println("남자 workYear 평균 : "+avg);
		System.out.println();
		
		// max 나 min은 Comparator.comparing 자료형(비교할 데이터의 메소드)를 대입하면 Optional<제네릭스>으로 결과를 리턴
		stream2 = list.stream();
		Optional<Member> memberMax = stream2.filter((member)->{ 
			if(member.getGender()==1) return true;
			else return false; 
			}).max(Comparator.comparingInt(Member::getWorkYear));
		
		System.out.println("최장 근무자 : "+memberMax.get());
		
	
	}

}
