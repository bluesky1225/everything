import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class ReductionMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
			this.num = num;
			this.name = name;
			this.birthday = birthday;
			this.gender = gender;
			this.phone = phone;
			this.email = email;
		 * */
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
		
		// distinct - 중복 제거 메소드
		String [] ar = {"한국", "일본", "한국", "한국", "캐나다", "말레이시아"};
		Stream<String> stream = Arrays.stream(ar);
		//stream.forEach(System.out::println);		
		//stream.distinct().forEach(System.out::println); 
		
		// filter - 조건에 맞는 데이터만 추출하는 중간연산
		// filter에는 매개변수 1개를 갖고 boolean을 리턴하는 람다식을 대입
		/*
		stream.filter(str->{
			if(str.length() >= 3) { return true;}
			else { return false;}
		}).forEach(System.out::println);
		*/
		
		Stream<Member> stream2 = list.stream();
		
		stream2.filter(member->{
			if(member.getGender() == 0) return true;
			else return false;
		}).forEach(System.out::println);
		
		stream2 = list.stream(); // 스트림은 1회용. 한번 사용시 소멸되므로 다시 사용할때 재생성 필요
		// map()은 데이터를 변환할때 사용하는 메소드
		// 숫자 -> 문자열, 문자열 -> 숫자, 날짜 -> 문자열, 인스턴스 -> 기본형
		// Member를 workDay로 변환
		stream2.forEach(System.out::println);
		stream2 = list.stream();
		//stream2.mapToInt(member -> {return member.getWorkYear();}).forEach(System.out::println);
		stream2.mapToInt(Member::getWorkYear).forEach(System.out::println);
		
		System.out.println();
		// 데이터 정렬은 sorted 메소드를 이용
		// 각 요소가 크기 비교가 가능하다면 바로 오름차순 정렬을 수행
		// 요소가 크기 비교가 불가능하다면 크기 비교가 가능한 메소드를 대입해야 합니다.
		// 크기 비교가 가능한 데이터는 속성을 하나만 가진 데이터들입니다.
		// 기본 자료형, 문자열, 날짜 정도가 하나의 데이터만을 가진 자료형입니다.
		// c언어는 자료구조나 비교 함수등 이런 것들을 하나하나 다 구현해야함
		// String은 크기 비교가 가능하기 때문에 바로 오름차순 정렬
		stream = Arrays.stream(ar);
		stream.sorted().forEach(System.out::println);
		System.out.println();
		
		stream2 = list.stream();
		
		stream2.sorted((member, other) -> { 
				return member.getWorkYear()-other.getWorkYear();
		}).forEach(System.out::println);
		
		System.out.println();
		
		stream2 = list.stream();
		
		stream2.sorted((member, other) -> { 
			return member.getName().compareTo(other.getName());
		}).forEach(System.out::println);
		
		System.out.println();
		
		
	}

}
