
public class SingletonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton s1 = Singleton.sharedInstance();
		s1.setName("홍길동");
		Singleton s2 = Singleton.sharedInstance();
		
		System.out.println(s2.getName());
		
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
	}

}
