package inheritance;

public class Based {
	// 자신의 클래스 내부에 있는 메소드에서 사용 가능
	private int num = 10;
	// 같은 패키지내에서는 public, 밖에서는 private
	String title="..."; //접근 지정자를 설정하지 않는 것을 default 또는 package
	// default + 상속 받은 클래스에서 사용 가능
	protected String content;
	// 어디서나 다 사용 가능
	public int readcnt;
	
	public Based(int i) {
		
	}
	
	public int getNum() {
		return num;
	}
	
	public void print() {
		System.out.println("상위 클래스의 프린트");
	}
}


