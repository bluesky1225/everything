package di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Service {
	// 서비스가 Dao를 사용
	@Autowired
	private Dao dao;
	
	public void insert() {
		dao.insert();
	}
}
