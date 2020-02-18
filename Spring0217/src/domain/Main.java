package domain;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// SpringContainer 클래스 객체 만들기
		// 1. annotation을 이용하는 방법
		AnnotationConfigApplicationContext itemFactory = new AnnotationConfigApplicationContext(Factory.class);
		
		// Bean 생성 메소드를 호출해서 Bean을 생성
		// Factory 클래스의 create라는 메소드를 이용해서 인스턴스를 생성하고 리턴
		Item item1 = itemFactory.getBean("create", Item.class);
		item1.setNum(1);
		item1.setName("강감찬");		
		System.out.println(item1);
		System.out.println(item1.hashCode());
		
		Item item2 = itemFactory.getBean("create", Item.class);
		item2.setNum(2);
		item2.setName("이순신");		
		System.out.println(item2);
		System.out.println(item2.hashCode());
		
		itemFactory.close();
		
		// 2. XML을 이용하는 방법
		GenericXmlApplicationContext itemFactory2 = new GenericXmlApplicationContext("classpath:applicationcontext.xml");
		Item item3 = itemFactory2.getBean("item", Item.class);
		item3.setNum(3);
		item3.setName("홍길동");		
		System.out.println(item3);
		System.out.println(item3.hashCode());
		
		Item item4 = itemFactory2.getBean("item", Item.class);
		item4.setNum(4);
		item4.setName("이성계");		
		System.out.println(item4);
		System.out.println(item4.hashCode());
		
		itemFactory2.close();
	}

}
