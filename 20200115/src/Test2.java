
public class Test2 {
	public static void main(String[] args) {
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("java.version"));
	
		int a = 10;
		int b = a;
		System.out.println(a + " " + b);
		
		Runtime r1 = Runtime.getRuntime();
		Runtime r2 = Runtime.getRuntime();
		
		// 해시코드 출력
		System.out.println("r1 : " + System.identityHashCode(r1));
		System.out.println("r2 : " + System.identityHashCode(r2));
		System.out.println("r1 : " + r1.hashCode());
		System.out.println("r2 : " + System.identityHashCode(r2));
		
		try {
			r1.exec("notepad.exe C:\\Users\\admin\\Desktop\\a.txt");
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	}
}
