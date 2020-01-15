
public class Test6 {
	public static void main(String[] args) {
		
		String a = "hello";
		
		String b = a + "java";
		
		a.toUpperCase();
		System.out.println(a);
		a.toUpperCase();
		System.out.println(a);
		
		String[] c = {"hi", "java"};
		System.out.println(c[0].hashCode());
		c[0].toUpperCase();
		System.out.println(c[0]);
		System.out.println(c[0].hashCode());
		c[0] = "aaa";
		System.out.println(c[0]);
		System.out.println(c[0].hashCode());
		
		
		char[] d = {'a', 'b'};
		
		System.out.println(d[0]);
		
		StringBuffer sb = new StringBuffer("hello");
		System.out.println(sb.hashCode());
		sb.append("java");
		System.out.println(sb.hashCode());
		System.out.println();
		System.out.println(c[0]);
		System.out.println(c[1]);
		
		System.out.println(c[0].hashCode());
		System.out.println(c[1].hashCode());
		c[0] = c[0]+"cccccccccccccccccccccccc";
		c[1] = "ddddddddddddddddddddddddd";
		System.out.println(c[0]);
		System.out.println(c[1]);
		
		System.out.println(c[0].hashCode());
		System.out.println(c[1].hashCode());
	}
}
