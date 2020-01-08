package board;

import org.junit.Test;

public class ControlArticle {
	
	@Test
	public void getNumber() {
		Article ar = new Article();
		System.out.println(ar.getNum());
		System.out.println(ar.getNum());
		
		Article ar2 = new Article();
		System.out.println(ar2.getNum());
		
		System.out.println(ar.toString());
	}
}
