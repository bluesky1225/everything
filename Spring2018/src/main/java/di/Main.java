package di;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		// 일반적인  자바 프로젝트의 구조
		// 자바에서 Controller의 insert 메소드를 호출
		/*
		Dao dao = new Dao();
		
		Service service = new Service();
		service.setDao(dao);
		
		Controller controller = new Controller();
		controller.setService(service);
		
		controller.insert();
		*/	
		
		// Spring
		// Spring 설정 파일의 내용 가져오기
		// property 입력전
		/*
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:app.xml");
		Dao dao = context.getBean("dao", Dao.class);
		
		Service service = context.getBean("service", Service.class);
		service.setDao(dao);
		Controller controller = context.getBean("controller", Controller.class);
		controller.setService(service);
		controller.insert();
		*/
		
		// Spring
		// Spring 설정 파일의 내용 가져오기
		// property 입력후 또는  @Autowired 설정시 이렇게만 해도 된다
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:app.xml");
		Controller controller = context.getBean("controller", Controller.class);
		controller.insert();
		context.close();
	}
}
