package AdapterPattern;

public class AdapterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewSystem newSystem = new NewSystem();
		// 새로 만들어진 메소드
		newSystem.process();
		// 이전에 만들어진 메소드
		newSystem.legacyProcess();
	}

}
