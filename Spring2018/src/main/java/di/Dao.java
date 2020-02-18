package di;

import org.springframework.stereotype.Component;

@Component
public class Dao {
	public void insert() {
		System.out.println("Dao의 insert 메소드 호출");
	}
}
