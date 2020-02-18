package di;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		Di di = new Di();
		// 이처럼 외부에서 인스턴스(여기서는 String 클래스의 인스턴스)를 만든 후 대입하는 구조를 의존성 주입이라고 함
		String msg = "Hello Di";
		di.setMsg(msg); // setter를 이용한 주입
		System.out.println(di.getMsg());
		
		Di di1 = new Di(msg); // 생성자를 이용한 의존성 주입 : 코드가 짧다. 메소드 호출 횟수가 감소하여 실행시간 감소, 빨라짐
		System.out.println(di1.getMsg());
		
		// 스프링 설정 파일의 경로 설정
		// classpath: src 또는 src/main/java, src/main/resources
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:diconfig.xml");
		// bean 찾아오기
		// 주입받는 코드가 없음
		DTO dto = context.getBean("dto", DTO.class);
		// diconfig.xml 파일에 설정한 내용이 출력
		System.out.println(dto.getName());
		System.out.println(dto);
		
		DTO dto2 = context.getBean("dto2", DTO.class);
		System.out.println(dto2.getName());
		System.out.println(dto2);
		
		DTO dto3 = context.getBean("dto3", DTO.class);
		System.out.println(dto3.getName());
		System.out.println(dto3);
		
		// 객체 해제
		context.close();
		
		
	}

}
