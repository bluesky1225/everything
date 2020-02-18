package di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Controller {
	@Autowired
	private Service service;
	
	public void insert() {
		service.insert();
	}
}
