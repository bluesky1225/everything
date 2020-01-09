package inheritance;

// Based 클래스를 상속받은 Derived 클래스
public class Derived extends Based {
	
	//메소드
	public void disp() {
		//num = 10; // num : not visible
		// protected로 변경할 것인지 물어본다
		
		title = "제목";
		content = "내용";
		readcnt = 0;
		
	}
	
	public Derived() {
		super(1); // new Based(1)과 동일
	}
	
	public void print() {
		System.out.println("하위 클래스의 프린트");
	}
	
	public void method() {
		print();
		System.out.println("======================");
		super.print();
		System.out.println(super.getNum());
	}
}
