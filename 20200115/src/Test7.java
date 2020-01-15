
public class Test7 {
	public static void main(String [] args) {
		Integer[] i = {1, 2, 3, 4, 5, 6, 7};
		Generic<Integer> g = new Generic<Integer>(i);
		g.disp();
		
		String[] j = {"hi", "java"};
		Generic<String> g2 = new Generic<String>(j);
		g2.disp();
		
		g2.aaa("YELLOW");
	}
}
