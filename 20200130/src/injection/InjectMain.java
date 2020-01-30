package injection;

public class InjectMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Injection injection = new Injection("Java Script");
		injection.setDiff2("spring");
		injection.disp();
		
		Injection injection2 = new Injection("python");
		
		injection2.disp();
	}

}
