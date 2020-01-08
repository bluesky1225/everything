

class Sample {
	protected int a = 1;
	static int share = 10;
	String str = "test";
	
	private static int share2 = 7;
	
	static {
		System.out.println("클래스가 처음 호출될때 1번만 수행");
	}
	
	protected class Sample_child {
		int sc = 1;
	}
	
}
