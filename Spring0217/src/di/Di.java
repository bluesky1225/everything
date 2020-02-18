package di;

public class Di {
	private String msg;
	// 어느 하나의 클래스가 다른 클래스 안에서 사용되는 것 = has a 관계(포함 관계)
	
	public void disp() {
		msg = "Hello World";
		System.out.println(msg);
	}

	public Di(String msg) {
		super();
		this.msg = msg;
	}

	public Di() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
